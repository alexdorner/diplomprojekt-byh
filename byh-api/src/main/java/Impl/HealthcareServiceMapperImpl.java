package Impl;

import FhirModel.HealthCareService;
import FhirModel.Reference;
import KisModel.AppointmentTypeK;
import mapper.HealthCareServiceMapper;


public class HealthcareServiceMapperImpl implements HealthCareServiceMapper {
    @Override
    public HealthCareService FromAptToHcs(AppointmentTypeK appointmentTypeK) {
       if (appointmentTypeK == null){
           return null;
       }

       HealthCareService healthCareService = new HealthCareService();
        healthCareService.setId(appointmentTypeK.getName());
       healthCareService.setName(appointmentTypeK.getName());
        Reference ref1 = new Reference();
        ref1.setReference("http://localhost:8080/api/organization/Get");
        ref1.setId("ref01");
        ref1.setType("Location = Organization/MedicalDepartment");
        healthCareService.setProvidedBy(ref1);
       return healthCareService;
    }


}

