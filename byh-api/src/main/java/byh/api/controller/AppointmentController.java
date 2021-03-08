package byh.api.controller;


import FhirModel.*;
import Impl.AppointmentMapperImpl;
import KisModel.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;


@RestController
@RequestMapping(path = "/api/appointment")
@CrossOrigin
public class AppointmentController {

    //Die Methode filtert nach MedicalDepartment(Organization), Service Unit(Device), und datum
    @GetMapping("/GetAll")
    public @ResponseBody
    Iterable<Appointment> getAllAppointments(@RequestParam(required = false) String idKrankenhaus, @RequestParam(required = false) String idOrganization,@RequestParam(required = false) String idDevice, @RequestParam(required = false) String datum) throws JsonProcessingException {
        final String allAppointments = "http://192.189.51.8/api/resource/Patient Appointment?" + LoginDataController.getAll();
        RestTemplate restTemplate = new RestTemplate();
        Set<Appointment> listAppointment = new HashSet<>();
        Set<Appointment> appointments = new HashSet<>();
        AppointmentMapperImpl appointmentMapper = new AppointmentMapperImpl();
        PatientAppointmentWrapperList appointmentListWrapper = restTemplate.getForObject(allAppointments, PatientAppointmentWrapperList.class);
        appointmentListWrapper.getData().forEach(list -> {
            listAppointment.add(appointmentMapper.FromPaListToAppointment(list));});
        listAppointment.forEach(item ->{
            final String detailAppointment = "http://192.189.51.8/api/resource/Patient Appointment/"+item.getId()+"?"+LoginDataController.getAll() ;
            PatientAppointmentWrapper patientAppointmentWrapper = restTemplate.getForObject(detailAppointment, PatientAppointmentWrapper.class);
            appointments.add(appointmentMapper.FromPaToAppointment(patientAppointmentWrapper.getData()));});

        /*
        Set<Appointment> apFilter = new HashSet<>();
        appointments.forEach(f -> {
            f.getParticipant().forEach(p->{
                if(p.getActor().getReference().equals("Patient") && p.getActor().getType().equals("")){
                    apFilter.add(f);
                }

            });
        });

         */

        Set<Appointment> filtered = new HashSet<>();

        if (idOrganization == null || idOrganization == "" && idDevice == null || idDevice == "" && idKrankenhaus == null || idKrankenhaus == ""){
            return appointments;
        }
        if(idOrganization != null&& idDevice != null){
            appointments.forEach(a ->{
                a.getParticipant().forEach(participant -> {
                    if (participant.getActor().getType().equals(idOrganization)){
                        appointments.forEach(device ->{
                            device.getParticipant().forEach(d ->{
                                if(d.getActor().getType().equals(idDevice)){
                                    filtered.add(a); } }); } ); } }); });
        return filtered;}

            if(idOrganization != null&& idDevice != null && idKrankenhaus != null){
                appointments.forEach(a ->{
                    a.getParticipant().forEach(participant -> {
                        if (participant.getActor().getType().equals(idOrganization)){
                            appointments.forEach(device ->{
                                device.getParticipant().forEach(d ->{
                                    if(d.getActor().getType().equals(idDevice)){
                                        appointments.forEach(hospital->{
                                            hospital.getParticipant().forEach(kh->{
                                                if(kh.getActor().getType().equals(idKrankenhaus)){
                                                    filtered.add(a); } }); } ); } }); } ); } }); });
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
    public @ResponseBody//der patient gibt seinen termincode ein und ich hol sie mir dann über die parameter und setzte dort wo er diesen code finden den patienten dann auf
    //null, dass heißt der termin wäre wieder frei
    Set<Appointment> DeleteAppointment(@RequestParam(required = false) String termincode){
        final String allAppointments = "http://192.189.51.8/api/resource/Patient Appointment?" + LoginDataController.getAll();
        RestTemplate restTemplate = new RestTemplate();
        Set<Appointment> listAppointment = new HashSet<>();
        Set<Appointment> appointments = new HashSet<>();
        AppointmentMapperImpl appointmentMapper = new AppointmentMapperImpl();
        PatientAppointmentWrapperList appointmentListWrapper = restTemplate.getForObject(allAppointments, PatientAppointmentWrapperList.class);
        appointmentListWrapper.getData().forEach(list -> {
            listAppointment.add(appointmentMapper.FromPaListToAppointment(list));});
        listAppointment.forEach(item ->{
            final String detailAppointment = "http://192.189.51.8/api/resource/Patient Appointment/"+item.getId()+"?"+LoginDataController.getAll() ;
            PatientAppointmentWrapper patientAppointmentWrapper = restTemplate.getForObject(detailAppointment, PatientAppointmentWrapper.class);
            appointments.add(appointmentMapper.FromPaToAppointment(patientAppointmentWrapper.getData()));});

        appointments.forEach(ap ->{
            ap.getParticipant().forEach(delete -> {
                if(delete.getActor().getType().equals(termincode)){
                    String deleteAppointmentURL ="http://192.189.51.8/api/resource/Patient Appointment/" + ap.getId();
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                    PatientAppointmentK patientAppointmentK = new PatientAppointmentK();
                    patientAppointmentK.setPatient(null);
                    PatientAppointmentWrapper wrapper = restTemplate.getForObject(deleteAppointmentURL+ "?" + LoginDataController.getAll(), PatientAppointmentWrapper.class);
                    patientAppointmentK = wrapper.getData();
                    ResponseEntity<String> forEntity = restTemplate.getForEntity("http://192.189.51.8/api/method/login?usr=Administrator&pwd=12345678", String.class);
                    forEntity.getHeaders().get("Set-Cookie").stream().forEach(f ->{headers.add("Cookie", f); });
                    HttpEntity requestEntity = new HttpEntity(patientAppointmentK,headers);
                    ResponseEntity responseEntity = restTemplate.exchange(deleteAppointmentURL, HttpMethod.PUT, requestEntity, PatientAppointmentK.class);
                }
            });
        });
        return appointments;
    }

   @GetMapping("/vormerken")//geht noch nicht, patient hat noch was
    public @ResponseBody
    String AppointmentVormerken(@RequestParam (required = false) String IdAppointment, @RequestParam(required = false) String phonenumber, @RequestParam(required = false) String mail){
        String postPatient = "http://192.189.51.8/api/resource/Patient/";
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        PatientK patientK = new PatientK();
       ResponseEntity<String> forEntity = restTemplate.getForEntity("http://192.189.51.8/api/method/login?usr=Administrator&pwd=12345678", String.class);
       forEntity.getHeaders().get("Set-Cookie").stream().forEach(f ->{headers.add("Cookie", f); });
       HttpEntity requestEntity = new HttpEntity(headers);
        ResponseEntity responseEntity = restTemplate.exchange(postPatient, HttpMethod.POST, requestEntity, PatientKWrapper.class);
        return patientK.getName();
   }


}

