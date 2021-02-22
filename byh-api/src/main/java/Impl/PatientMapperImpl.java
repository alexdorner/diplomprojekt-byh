package Impl;

import FhirModel.ContactPoint;
import FhirModel.Patient;
import KisModel.PatientK;
import Model.PatienKIS;
import Model.PatientFHIR;
import mapper.PatientMapper;

import java.util.Locale;

 public class PatientMapperImpl implements PatientMapper {


     @Override
     public PatientK FromFhirToKis(Patient patient) {
         if (patient == null){
             return null;
         }
         PatientK patientK= new PatientK();
         patientK.setID(patient.getId());
         return patientK;
     }
 }
