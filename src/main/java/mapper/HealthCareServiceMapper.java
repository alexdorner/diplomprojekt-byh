package mapper;

import FhirModel.HealthCareService;
import KisModel.AppointmentTypeK;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HealthCareServiceMapper {

    HealthCareServiceMapper healthcareservice = Mappers.getMapper(HealthCareServiceMapper.class);

    HealthCareService FromAptToHcs(AppointmentTypeK appointmentTypeK);
}