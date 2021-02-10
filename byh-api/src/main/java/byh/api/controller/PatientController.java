package byh.api.controller;

import FhirModel.ContactPoint;
import FhirModel.Identifier;
import FhirModel.Patient;
import Impl.PatientMapperImpl;
import Model.PatienKIS;
import Model.PatientFHIR;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import java.util.HashSet;

@RestController
@RequestMapping(path = "/api/patient")
@CrossOrigin
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
    @GetMapping ("/getAll")
    public @ResponseBody
    Iterable <PatientFHIR> GetAllPatientsREAL(@RequestBody Set<PatienKIS> patienKIS) {
        Set<PatientFHIR> fhirs = new HashSet<>();
        PatientMapperImpl pm = new PatientMapperImpl();
        patienKIS.forEach(p -> {
            fhirs.add(pm.FromKisToFhir(p));
        });

        return fhirs;
    }

    @PostMapping()
    public ResponseEntity<Patient> createPatientFHIR (@RequestBody Patient patient ){
        Patient gespeichert = patient;
        return  ResponseEntity.created(URI.create("/api/patient/" + gespeichert.getId())).body(gespeichert);
    }


}
