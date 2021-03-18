package byh.api.controller;


import FhirModel.*;
import Impl.AppointmentMapperImpl;
import KisModel.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;


@RestController
@RequestMapping(path = "/api/appointment")
@CrossOrigin
public class AppointmentController {

    //das ganze filtern geht. ABER KEINEN LEHREN STRING MITSCHICKEN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @GetMapping("/GetAll")
    public @ResponseBody
    ResponseEntity<Iterable<Appointment>>getAllAppointments(@RequestParam(required = false) String idKrankenhaus, @RequestParam(required = false) String idOrganization,@RequestParam(required = false) String idDevice, @RequestParam(required = false) String datum) throws JsonProcessingException {
        Set<String> parameters = new HashSet<>();
        parameters.add(idKrankenhaus);
        parameters.add(idDevice);
        parameters.add(idOrganization);
        parameters.add(datum);
        for (String p: parameters){
            if(p!=null){
                if(p.equals("")){
                    return ResponseEntity.badRequest().build();
                }
            }
        }
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

        Set<Appointment> myAppointments = new HashSet<>();
        myAppointments = appointments;
        if(idKrankenhaus != null)
        {
            Set<Appointment> filter = new HashSet<>();
            myAppointments.forEach(kh -> {
                kh.getParticipant().forEach(p ->{
                if(p.getActor() != null && p.getActor().getId() != null){
                    if(p.getActor().getId().equals(idKrankenhaus)){
                        filter.add(kh);
                    }
                }
                });
            });
            myAppointments = filter;
            }

        if(idOrganization != null ){
            Set<Appointment> filter = new HashSet<>();
            myAppointments.forEach((organisation ->{
                organisation.getParticipant().forEach(p ->{
                    if(p.getActor() != null && p.getActor().getId() != null){
                        if(p.getActor().getId().equals(idOrganization)){
                            filter.add(organisation);
                        }
                    }
                });
            }));
            myAppointments = filter;
        }
        if(idDevice != null){
            Set<Appointment> filter = new HashSet<>();
            myAppointments.forEach(device ->{
                device.getParticipant().forEach(p->{
                    if(p.getActor() != null && p.getActor().getId() != null){
                        if(p.getActor().getId().equals(idDevice)){
                            filter.add(device);
                        }
                    }
                });
            });
            myAppointments = filter;
        }
        if(datum != null){
            Set<Appointment> filter = new HashSet<>();
            myAppointments.forEach(date ->{
                if(date.getCreated() != null){
                    if(date.getCreated().equals(datum)){
                        filter.add(date);
                    }
                }
            });
            myAppointments = filter;
        }

        return ResponseEntity.ok().body(myAppointments);
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


    @GetMapping("/stornieren")
    public @ResponseBody
    String DeleteAppointment(@RequestParam(required = false) String termincode){
        final String allAppointments = "http://192.189.51.8/api/resource/Patient Appointment?" + LoginDataController.getAll();
        RestTemplate restTemplate = new RestTemplate();
        Set<PatientAppointmentK> listAppointment = new HashSet<>();
        Set<PatientAppointmentK> appointments = new HashSet<>();
        AppointmentMapperImpl appointmentMapper = new AppointmentMapperImpl();
        PatientAppointmentWrapperList appointmentListWrapper = restTemplate.getForObject(allAppointments, PatientAppointmentWrapperList.class);
        appointmentListWrapper.getData().forEach(list -> {
            listAppointment.add(list);});

        listAppointment.forEach(item ->{
            final String detailAppointment = "http://192.189.51.8/api/resource/Patient Appointment/"+item.getName()+"?"+LoginDataController.getAll() ;
            PatientAppointmentWrapper patientAppointmentWrapper = restTemplate.getForObject(detailAppointment, PatientAppointmentWrapper.class);
            appointments.add(patientAppointmentWrapper.getData());});

        appointments.forEach(ap ->{
            if(ap.getName().equals(termincode)) {
                    String deleteAppointmentURL ="http://192.189.51.8/api/resource/Patient Appointment/" + ap.getName();
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                    ResponseEntity<String> forEntity = restTemplate.getForEntity("http://192.189.51.8/api/method/login?usr=Administrator&pwd=12345678", String.class);
                    forEntity.getHeaders().get("Set-Cookie").stream().forEach(f ->{headers.add("Cookie", f); });
                    PatientAppointmentK patientAppointmentK = new PatientAppointmentK();
                    PatientAppointmentWrapper wrapper = restTemplate.getForObject(deleteAppointmentURL+ "?" + LoginDataController.getAll(), PatientAppointmentWrapper.class);
                    patientAppointmentK = wrapper.getData();
                    patientAppointmentK.setID("empty");
                    HttpEntity requestEntity = new HttpEntity(patientAppointmentK,headers);
                    ResponseEntity responseEntity = restTemplate.exchange(deleteAppointmentURL, HttpMethod.PUT, requestEntity, PatientAppointmentK.class);
                }
            });
        return "Termin wurde erfolgreich storniert";
    }


   @GetMapping("/vormerken")
    public @ResponseBody
   String AppointmentVormerken(@RequestParam (required = false) String IdAppointment, @RequestParam(required = false) String phonenumber, @RequestParam(required = false) String mail){
        if(phonenumber == null || mail == null){
            if(phonenumber== null){
                phonenumber = "";
            }
            if(mail==null){
                mail="";
            }
        }
        String postPatient = "http://192.189.51.8/api/resource/Patient/";
        HttpHeaders headers = new HttpHeaders();
        Set<PatientK> patientsList = new HashSet<>();
        Set<PatientK> patientDetail = new HashSet<>();
        RestTemplate restTemplate = new RestTemplate();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        PatientK patientK = new PatientK();
        patientK.setMobile(phonenumber);
        patientK.setEmail(mail);
       ResponseEntity<String> forEntity = restTemplate.getForEntity("http://192.189.51.8/api/method/login?usr=Administrator&pwd=12345678", String.class);
       forEntity.getHeaders().get("Set-Cookie").stream().forEach(f ->{headers.add("Cookie", f); });
       HttpEntity requestEntity = new HttpEntity(patientK,headers);
       PatientKWrapperList getPatients = restTemplate.getForObject("http://192.189.51.8/api/resource/Patient?"+ LoginDataController.getAll(), PatientKWrapperList.class);
        getPatients.getData().forEach(l ->{
            patientsList.add(l);
        });
        patientsList.forEach(p->{
            final String detail= "http://192.189.51.8/api/resource/Patient/" + p.getName()+"?"+LoginDataController.getAll();
            PatientKWrapper wrapper = restTemplate.getForObject(detail, PatientKWrapper.class);
            patientDetail.add(wrapper.getData());
        });

       AtomicBoolean found = new AtomicBoolean(false);
       String finalMail = mail;
       String finalPhonenumber = phonenumber;
       patientDetail.forEach(detail ->{ //hier kommt er rein wenn es schon einen patienten mit dieser mailadresse und telefonnummer gibt

               if(detail.getEmail().equals(finalMail) || detail.getMobile().equals(finalPhonenumber)){
                   String updateAppointmentURL ="http://192.189.51.8/api/resource/Patient Appointment/" + IdAppointment;
                   PatientAppointmentK patientAppointmentK = new PatientAppointmentK();
                   HttpHeaders headers2 = new HttpHeaders();
                   headers2.setContentType(MediaType.APPLICATION_JSON);
                   headers2.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                   PatientAppointmentWrapper wrapper = restTemplate.getForObject(updateAppointmentURL + "?" + LoginDataController.getAll(), PatientAppointmentWrapper.class);
                   patientAppointmentK = wrapper.getData();
                   patientAppointmentK.setID(detail.getName());
                   HttpEntity requestEntity2 = new HttpEntity(patientAppointmentK,headers);
                   ResponseEntity responseEntity2 = restTemplate.exchange(updateAppointmentURL, HttpMethod.PUT, requestEntity2, PatientAppointmentK.class);
                   found.set(true);
               }
       });


       if(!found.get()){ //hier erstellt er zusätzlich einen neuen patienten
           ResponseEntity responseEntity = restTemplate.exchange(postPatient, HttpMethod.POST, requestEntity, PatientKWrapper.class);
           Set<PatientK> pList = new HashSet<>();
           Set<PatientK> pDetails = new HashSet<>();
           PatientKWrapperList patients = restTemplate.getForObject("http://192.189.51.8/api/resource/Patient?"+ LoginDataController.getAll(), PatientKWrapperList.class);
           patients.getData().forEach(l ->{
               pList.add(l);
           });
           pList.forEach(p->{
               final String detail= "http://192.189.51.8/api/resource/Patient/" + p.getName()+"?"+LoginDataController.getAll();
               PatientKWrapper wrapper = restTemplate.getForObject(detail, PatientKWrapper.class);
               pDetails.add(wrapper.getData());
           });
           String finalMail1 = mail;
           String finalPhonenumber1 = phonenumber;
           pDetails.forEach(item->{
               if(item.getEmail().equals(finalMail1) && item.getMobile().equals(finalPhonenumber1)){
                   String updateAppointmentURL ="http://192.189.51.8/api/resource/Patient Appointment/" + IdAppointment;
                   PatientAppointmentK patientAppointmentK = new PatientAppointmentK();
                   HttpHeaders headers2 = new HttpHeaders();
                   headers2.setContentType(MediaType.APPLICATION_JSON);
                   headers2.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                   PatientAppointmentWrapper wrapper = restTemplate.getForObject(updateAppointmentURL + "?" + LoginDataController.getAll(), PatientAppointmentWrapper.class);
                   patientAppointmentK = wrapper.getData();
                   patientAppointmentK.setID(item.getName());
                   HttpEntity requestEntity2 = new HttpEntity(patientAppointmentK,headers);
                   ResponseEntity responseEntity2 = restTemplate.exchange(updateAppointmentURL, HttpMethod.PUT, requestEntity2, PatientAppointmentK.class);
               }
           });
       }
       return IdAppointment;

   }
}

