package Impl;

import FhirModel.Appointment;
import FhirModel.Participant;
import FhirModel.Patient;
import FhirModel.Reference;
import KisModel.AppointmentTypeK;
import KisModel.PatientAppointmentK;
import mapper.AppointmentMapper;

import java.util.HashSet;
import java.util.Set;

public class AppointmentMapperImpl implements AppointmentMapper {
    @Override
    public Appointment FromPaToAppointment(PatientAppointmentK patientAppointmentK) {
        if (patientAppointmentK == null){
            return null;
        }
        Appointment appointment = new Appointment();
        Set<Participant> participant = new HashSet<>();
        AppointmentTypeK appointmentTypeK = new AppointmentTypeK();
        HealthcareServiceMapperImpl health = new HealthcareServiceMapperImpl();
        health.FromAptToHcs(appointmentTypeK);

        Patient patient = new Patient();
        Reference ref2 = new Reference();
        ref2.setReference("Referenz zum Patienten");
        ref2.setType(patientAppointmentK.getPatient());
        ref2.setId("ref2");

        participant.add(new Participant(ref2));
        appointment.setParticipant(participant);
        appointment.setId(patientAppointmentK.getName());
        appointment.setStart(patientAppointmentK.getAppointment_time());
        Reference ref3 = new Reference();
        ref3.setType(patientAppointmentK.getCompany());

        participant.add(new Participant(ref3));
        appointment.setCreated(patientAppointmentK.getAppointment_date());
        Reference ref4 = new Reference();
        ref4.setId("ref4");
        ref4.setType(patientAppointmentK.getDepartment());
        ref4.setReference("http://localhost:8080/api/organization/" + patientAppointmentK.getDepartment());
        participant.add(new Participant(ref4));
        Reference ref5 = new Reference();
        ref5.setType(patientAppointmentK.getService_unit());
        ref5.setReference("Referenz zum device");
        participant.add(new Participant(ref5));
        // reference für den Slot fehlt noch
        return appointment;
    }

    @Override
    public Appointment FromPaListToAppointment(PatientAppointmentK patientAppointmentK) {
        if(patientAppointmentK == null){
            return null;
        }
        Appointment appointment = new Appointment();
        appointment.setId(patientAppointmentK.getName());
        return appointment;
    }
}
