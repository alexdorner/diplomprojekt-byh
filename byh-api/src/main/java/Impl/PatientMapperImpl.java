package Impl;

import FhirModel.ContactPoint;
import FhirModel.Patient;
import KisModel.PatientK;
import mapper.PatientMapper;

import java.util.HashSet;
import java.util.Set;

public class PatientMapperImpl implements PatientMapper {


     @Override
     public PatientK FromFhirToKis(Patient patient) {
         if (patient == null){
             return null;
         }
         PatientK patientK= new PatientK();
         patientK.setName(patient.getId());
         return patientK;
     }

    @Override
    public Patient FromKisToFhir(PatientK patientK) {
        if (patientK == null){
            return null;
        }
        Patient patient = new Patient();
        Set<ContactPoint> contactPointSet = new HashSet<>();
        contactPointSet.add((new ContactPoint()));


        return null;
    }
}
