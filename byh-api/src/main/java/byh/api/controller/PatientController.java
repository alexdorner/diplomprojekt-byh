package byh.api.controller;

import FhirModel.Patient;
import Impl.PatientMapperImpl;
import KisModel.PatientK;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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
