package byh.api.controller;


import FhirModel.*;
import Impl.AppointmentMapperImpl;
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

    //Die Methode filtert nach MedicalDepartment(Organization), Service Unit(Device)
    @GetMapping("/GetAll")
    public @ResponseBody
    Iterable<Appointment> getAllAppointments(@RequestParam(required = false) String idOrganization,@RequestParam(required = false) String idDevice) throws JsonProcessingException {
        final String allAppointments = "http://192.189.51.8/api/resource/Patient Appointment?sid=c14fa5e7c5e3a1bdb4848a3ba97895c3d9696f1b3b860e37a1c1492b";
        RestTemplate restTemplate = new RestTemplate();
        Set<Appointment> listAppointment = new HashSet<>();
        Set<Appointment> appointments = new HashSet<>();
        AppointmentMapperImpl appointmentMapper = new AppointmentMapperImpl();
        PatientAppointmentWrapperList appointmentListWrapper = restTemplate.getForObject(allAppointments, PatientAppointmentWrapperList.class);
        appointmentListWrapper.getData().forEach(list -> {
            listAppointment.add(appointmentMapper.FromPaListToAppointment(list));
        });

        listAppointment.forEach(item ->{
            final String detailAppointment = "http://192.189.51.8/api/resource/Patient Appointment/"+item.getId()+"?sid=c14fa5e7c5e3a1bdb4848a3ba97895c3d9696f1b3b860e37a1c1492b" ;
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
}
//o.add((organizationMapper.FromKisDepartmentToOrganization(organization)));

//Die Methode filtert dann nach Datum und oder KH


