package Impl;

import FhirModel.Patient;
import KisModel.PatientK;
import Model.PatienKIS;
import Model.PatientFHIR;
import mapper.PatientMapper;

import java.util.Locale;

 public class PatientMapperImpl implements PatientMapper {

     @Override
     public PatientFHIR FromKisToFhir(PatienKIS patienKIS) {
         if (patienKIS == null) {
             return null;
         }
         PatientFHIR patientFHIR = new PatientFHIR();
        patientFHIR.setId(patienKIS.getId());

         patientFHIR.setVorname(patienKIS.getVorname());
         patientFHIR.setNachname(patienKIS.getNachname());
         return patientFHIR;
     }
 }



/*
@Override
public Patient FromKisToFhir(PatientK patientK) {
        if (patientK == null){
        return null;
        }
        Patient patient = new Patient();
        patient.setActive();

        return null;
        }




@Override
public PatientFHIR FromKisToFhir(PatienKIS patienKIS) {
        if (patienKIS == null) {
        return null;
        }
        PatientFHIR patientFHIR = new PatientFHIR();
        patientFHIR.setId(patienKIS.getId());
        patientFHIR.setVorname(patienKIS.getVorname());
        patientFHIR.setNachname(patienKIS.getNachname());
        return patientFHIR;



@Override
public PatientFHIR FromKisToFhir(PatienKIS patienKIS) {
        if (patienKIS == null){
        return null;
        }

        PatientFHIR patient = new PatientFHIR.PatientFHIRBuilder()
        .withid(patienKIS.getId())
        .whitvorname(patienKIS.getVorname())
        .withnachname(patienKIS.getNachname()).build();
        return patient;
        }


        }

        PatienKIS kis = new PatienKIS("1", "meli", "p");
        mapper.PatientMapperImpl m = new mapper.PatientMapperImpl();

 */