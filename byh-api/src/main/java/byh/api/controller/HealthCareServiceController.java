package byh.api.controller;

import FhirModel.HealthCareService;
import Impl.HealthcareServiceMapperImpl;
import KisModel.AppointmentTypeK;
import KisModel.AppointmentTypeWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/healthcareservice")
@CrossOrigin
@Service
//http://192.189.51.8/api/resource/Appointment%20Type --> daher bekomme ich meine Healthcar Services
public class HealthCareServiceController {

    @GetMapping("/Get")
    public  @ResponseBody
    Iterable<HealthCareService> getAllAppointmentType (/*@RequestBody AppointmentTypeWrapper appointments*/) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Set<HealthCareService> services = new HashSet<>();
        HealthcareServiceMapperImpl hp = new HealthcareServiceMapperImpl();
        String json = "{\"data\":[{\"name\":\"Erstgespraech\"},{\"name\":\"Kontrolle\"},{\"name\":\"Untersuchung\"}]}";//kommt raus sobalt ich einen http Request verschicken kann
        AppointmentTypeWrapper appointments = objectMapper.readValue(json, AppointmentTypeWrapper.class);
        appointments.getData().forEach(a -> {
        services.add(hp.FromAptToHcs(a));
        });
        return services;
    }
}

