package Impl;

import FhirModel.Patient;
import KisModel.PatientK;
import mapper.PatientMapper;

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
 }
