package byh.api.controller;


import FhirModel.*;
import Impl.AppointmentMapperImpl;
import KisModel.PatientAppointmentWrapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@RestController
@RequestMapping(path = "/api")
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

    
}
