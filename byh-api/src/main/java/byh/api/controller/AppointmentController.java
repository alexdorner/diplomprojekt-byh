package byh.api.controller;


import FhirModel.*;
import Impl.AppointmentMapperImpl;
import Impl.OrganizationMapperImpl;
import KisModel.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;


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
        ObjectMapper objectMapper = new ObjectMapper();
        final String detailAppointment="http://192.189.51.8/api/resource/Patient Appointment/" + id +"?" + LoginDataController.getAll();
        AppointmentMapperImpl appointmentMapper = new AppointmentMapperImpl();
        RestTemplate restTemplate = new RestTemplate();
        PatientAppointmentWrapper wrapper = restTemplate.getForObject(detailAppointment, PatientAppointmentWrapper.class);
        return appointmentMapper.FromPaToAppointment(wrapper.getData());
    }
}


