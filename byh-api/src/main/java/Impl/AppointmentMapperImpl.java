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
        Reference ref1 = new Reference();
        Reference ref2 = new Reference();
        ref1.setReference("http://192.189.51.8/api/resource/Appointment%20Type/" );//referenziert zum HealthCareService
        ref1.setType("HealthCareService");
        ref2.setReference("Referenz zum Patienten");
        ref2.setType("Patient");
        participant.add(new Participant(ref1));
        participant.add(new Participant(ref2));
        appointment.setParticipant(participant);
        appointment.setId(patientAppointmentK.getName());
        appointment.setStart(patientAppointmentK.getAppointment_time());
        // reference für den Slot fehlt noch
        return appointment;
    }
}
