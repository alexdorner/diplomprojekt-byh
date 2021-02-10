package Impl;

import FhirModel.HealthCareService;
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
       return healthCareService;
    }


}

