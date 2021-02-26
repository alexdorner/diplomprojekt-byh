package mapper;

import FhirModel.Appointment;
import KisModel.PatientAppointmentK;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppointmentMapper {
    AppointmentMapper appointments = Mappers.getMapper((AppointmentMapper.class));

    Appointment FromPaToAppointment (PatientAppointmentK patientAppointmentK);

    Appointment FromPaListToAppointment(PatientAppointmentK patientAppointmentK);

}
