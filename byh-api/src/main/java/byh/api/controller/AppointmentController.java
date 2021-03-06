package byh.api.controller;


import FhirModel.*;
import Impl.AppointmentMapperImpl;
import KisModel.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import javax.servlet.http.Cookie;
import java.util.*;


@RestController
@RequestMapping(path = "/api/appointment")
@CrossOrigin
public class AppointmentController {

    //Die Methode filtert nach MedicalDepartment(Organization), Service Unit(Device), und datum
    @GetMapping("/GetAll")
    public @ResponseBody
    Iterable<Appointment> getAllAppointments(@RequestParam(required = false) String idOrganization,@RequestParam(required = false) String idDevice, @RequestParam(required = false) String datum) throws JsonProcessingException {
        final String allAppointments = "http://192.189.51.8/api/resource/Patient Appointment?" + LoginDataController.getAll();
        RestTemplate restTemplate = new RestTemplate();
        Set<Appointment> listAppointment = new HashSet<>();
        Set<Appointment> appointments = new HashSet<>();
        AppointmentMapperImpl appointmentMapper = new AppointmentMapperImpl();
        PatientAppointmentWrapperList appointmentListWrapper = restTemplate.getForObject(allAppointments, PatientAppointmentWrapperList.class);
        appointmentListWrapper.getData().forEach(list -> {
            listAppointment.add(appointmentMapper.FromPaListToAppointment(list));
        });

        listAppointment.forEach(item ->{
            final String detailAppointment = "http://192.189.51.8/api/resource/Patient Appointment/"+item.getId()+"?"+LoginDataController.getAll() ;
            PatientAppointmentWrapper patientAppointmentWrapper = restTemplate.getForObject(detailAppointment, PatientAppointmentWrapper.class);
            appointments.add(appointmentMapper.FromPaToAppointment(patientAppointmentWrapper.getData()));
        });
        Set<Appointment> apFilter = new HashSet<>();

        appointments.forEach(f -> {
            f.getParticipant().forEach(p->{
                if(p.getActor().getId() == "ref2" && p.getActor().getType() == null);{
                    apFilter.add(f);
                }

            });
        });



        Set<Appointment> filtered = new HashSet<>();

        if (idOrganization == null || idOrganization == "" && idDevice == null || idDevice == ""){
            return appointments;
        }
        if(idOrganization != null){
            appointments.forEach(a ->{
                a.getParticipant().forEach(participant -> {
                    if (participant.getActor().getType().equals(idOrganization)){
                        filtered.add(a);
                    }
                });
            });
            return filtered;
        }

        return appointments;
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Appointment getOneAppointment(@PathVariable String id){
        final String detailAppointment="http://192.189.51.8/api/resource/Patient Appointment/" + id +"?" + LoginDataController.getAll();
        AppointmentMapperImpl appointmentMapper = new AppointmentMapperImpl();
        RestTemplate restTemplate = new RestTemplate();
        PatientAppointmentWrapper wrapper = restTemplate.getForObject(detailAppointment, PatientAppointmentWrapper.class);
        return appointmentMapper.FromPaToAppointment(wrapper.getData());
    }

    @GetMapping("/stornieren") //sollte gehen, aber appointment muss upgedated werden
    public @ResponseBody//vielleicht dem patienten zum termincode auch appointment id mitgeben? dann kann man es genauer machen
    void DeleteAppointment(@RequestParam(required = false) String appointmentId){
        String deleteAppointmentURL ="http://192.189.51.8/api/resource/Patient Appointment/OP-000001";//appointmentId
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        PatientAppointmentK patientAppointmentK = new PatientAppointmentK();
        PatientAppointmentWrapper wrapper = restTemplate.getForObject(deleteAppointmentURL+ "?" + LoginDataController.getAll(), PatientAppointmentWrapper.class);
        patientAppointmentK = wrapper.getData();
        patientAppointmentK.setPatient(null);
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://192.189.51.8/api/method/login?usr=Administrator&pwd=12345678", String.class);
        forEntity.getHeaders().get("Set-Cookie").stream().forEach(f ->{headers.add("Cookie", f); });
        HttpEntity requestEntity = new HttpEntity(patientAppointmentK,headers);
        ResponseEntity responseEntity = restTemplate.exchange(deleteAppointmentURL, HttpMethod.PUT, requestEntity, PatientAppointmentK.class);
    }


}

