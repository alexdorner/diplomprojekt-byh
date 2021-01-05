package byh.api.controller;


import FhirModel.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(path = "/api")
public class AppointmentController {

    @GetMapping("/{id}")
    public @ResponseBody
    Appointment getAppointment(@PathVariable String id){
        Reference reference1 = new Reference("Cardio", "Organization", "URL für Organization wo Cardio ist");
        Organization organization1 = new Organization("Cardio", reference1);
        organization1.setId("123");
        HealthCareService healthCareService1 = new HealthCareService(reference1);
        Reference reference2 = new Reference("HealthCareService1", "HealthCareService", "URL für HealthCareService");
        Participant participant1 = new Participant(reference2);
        Set<Reference> references3 = new HashSet<Reference>();
        references3.add(new Reference("Reason for appointment", "Organization Cardio", "URL für Cardio"));
        Set<Reference> references4 = new HashSet<Reference>();
        references4.add(new Reference("Slot for the appointment", "Which slot in the Organization Cardio", "URL für Cardio_Slot"));
        Set<CodeableConcept> codeableConcept1 = new HashSet<CodeableConcept>();
        codeableConcept1.add(new CodeableConcept("Text"));
        Appointment appointment1 = new Appointment(references3, references4,codeableConcept1);
        return appointment1;
    }


    @GetMapping()
    public @ResponseBody
     Appointment getAppointment(){
    Reference reference1 = new Reference("Cardio", "Organization", "URL für Organization wo Cardio ist");
    HealthCareService healthCareService1 = new HealthCareService(reference1);
    Reference reference2 = new Reference("HealthCareService1", "HealthCareService", "URL für HealthCareService");
    Participant participant1 = new Participant(reference2);
    Set<Reference> references3 = new HashSet<Reference>();
    references3.add(new Reference("Reason for appointment", "Organization Cardio", "URL für Cardio"));
    Set<Reference> references4 = new HashSet<Reference>();
    references4.add(new Reference("Slot for the appointment", "Which slot in the Organization Cardio", "URL für Cardio_Slot"));
    Set<CodeableConcept> codeableConcept1 = new HashSet<CodeableConcept>();
    codeableConcept1.add(new CodeableConcept("Text"));
    Appointment appointment1 = new Appointment(references3, references4,codeableConcept1);
    return appointment1;
}
    
}
