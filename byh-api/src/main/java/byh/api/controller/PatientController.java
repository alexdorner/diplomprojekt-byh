package byh.api.controller;

import FhirModel.ContactPoint;
import FhirModel.Identifier;
import FhirModel.Patient;
import Impl.PatientMapperImpl;
import KisModel.PatientK;
import Model.PatienKIS;
import Model.PatientFHIR;
import com.fasterxml.jackson.databind.ObjectMapper;
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


    @PostMapping()
    public ResponseEntity<PatientK> createPatient (@RequestBody Patient patient){
        PatientMapperImpl patientMapper = new PatientMapperImpl();
        PatientK patientK = patientMapper.FromFhirToKis(patient);
        return  ResponseEntity.created(URI.create("" + patientK.getID())).body(patientK);
    }


}
