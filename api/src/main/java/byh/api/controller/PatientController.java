package byh.api.controller;

import FhirModel.ContactPoint;
import FhirModel.Identifier;
import FhirModel.Patient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import java.util.HashSet;

@RestController
@RequestMapping(path = "/api/patient")
public class PatientController {

    @GetMapping
    public @ResponseBody
    Iterable <Patient> GetAllPatient() {
        Set<Identifier> identifier1 = new HashSet<Identifier>();
        identifier1.add(new Identifier(Identifier.Identifier_code.official));
        Set<ContactPoint> contactPoint1  = new HashSet<ContactPoint>();
        contactPoint1.add((new ContactPoint(ContactPoint.CodeContactPoint_system.sms, "value1", ContactPoint.ContactPoint_use.home)));
        Patient patient1 = new Patient(identifier1, contactPoint1);

        Set<Identifier> identifier2 = new HashSet<Identifier>();
        identifier2.add(new Identifier(Identifier.Identifier_code.secondary));
        Set<ContactPoint> contactPoint2  = new HashSet<ContactPoint>();
        contactPoint2.add((new ContactPoint(ContactPoint.CodeContactPoint_system.email, "value2", ContactPoint.ContactPoint_use.work)));
        Patient patient2 = new Patient(identifier2, contactPoint2);

        List<Patient> patientList = new ArrayList<>();
        patientList.add(patient1);
        patientList.add(patient2);
        return patientList;
    }
}
