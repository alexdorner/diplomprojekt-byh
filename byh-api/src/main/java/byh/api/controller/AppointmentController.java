package byh.api.controller;


import FhirModel.*;
import Impl.AppointmentMapperImpl;
import KisModel.AppointmentTypeWrapper;
import KisModel.PatientAppointmentK;
import KisModel.PatientAppointmentWrapper;
import KisModel.PatientAppointmentWrapperList;
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


@RestController
@RequestMapping(path = "/api/appointment")
@CrossOrigin
public class AppointmentController {

    @GetMapping("/GetAll")
    public @ResponseBody
    Iterable<Appointment> getAllAppointments() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    Set<Appointment> appointments = new HashSet<>();
    AppointmentMapperImpl appointmentMapper = new AppointmentMapperImpl();
    String json = "{\"data\":{\"creation\":\"2021-02-02 20:16:04.115358\",\"doctype\":\"Patient Appointment\",\"owner\":\"Administrator\",\"duration\":10,\"patient\":\"HLC-PAT-2021-00001\",\"invoiced\":0,\"modified_by\":\"Administrator\",\"appointment_date\":\"2021-02-18\",\"paid_amount\":0.0,\"reminded\":0,\"patient_name\":\"Melanie Pakchehr\",\"department\":\"Orthopaedics\",\"docstatus\":0,\"status\":\"Open\",\"practitioner\":\"Alexandra Dorner\",\"appointment_type\":\"Untersuchung\",\"company\":\"BookYourHospital\",\"referring_practitioner\":\"Alexandra Dorner\",\"name\":\"OP-000001\",\"idx\":0,\"patient_sex\":\"Female\",\"modified\":\"2021-02-02 20:16:08.059841\",\"service_unit\":\"\",\"appointment_time\":\"18:40:00\"}}";
    PatientAppointmentWrapper wrapper = objectMapper.readValue(json, PatientAppointmentWrapper.class);
    appointments.add(appointmentMapper.FromPaToAppointment(wrapper.getData()));
    return appointments;
}
    @GetMapping("/Get")
    public @ResponseBody
    static PatientAppointmentWrapperList getAll() {
        final String uriPa = "http://192.189.51.8/api/resource/Patient Appointment?sid=963f39c24b198e6266333c0fbfec89c28b8f1eda6755980e4fceb93c";
        final String uriLo = "http://192.189.51.8/api/method/login?usr=Administrator&pwd=12345678";
        RestTemplate restTemplate = new RestTemplate();

        PatientAppointmentWrapperList result = restTemplate.getForObject(uriPa, PatientAppointmentWrapperList.class);
        return result;

    }


}
