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

        int i = 0;
        Set<Participant> participant = new HashSet<>();
        AppointmentTypeK appointmentTypeK = new AppointmentTypeK();
        HealthcareServiceMapperImpl health = new HealthcareServiceMapperImpl();
        health.FromAptToHcs(appointmentTypeK);
        Patient patient = new Patient();
        Reference ref1 = new Reference();
        Reference ref2 = new Reference();
        //ref1.setReference("http://192.189.51.8/api/resource/Appointment%20Type/"+patientAppointmentK.getAppointment_type() );//referenziert zum HealthCareService
        ref1.setReference("http://localhost:8080/api/healthcareservice/" + patientAppointmentK.getAppointment_type());
        ref1.setType("HealthCareService");
        ref1.setId("ref" + i++);
        ref2.setReference("Referenz zum Patienten");
        ref2.setType("Patient");
        ref2.setId("ref" + i++);
        participant.add(new Participant(ref1));
        participant.add(new Participant(ref2));
        appointment.setParticipant(participant);
        appointment.setId(patientAppointmentK.getName());
        appointment.setStart(patientAppointmentK.getAppointment_time());
        Reference ref3 = new Reference();
        ref3.setType(patientAppointmentK.getCompany());
        ref3.setId("ref" + i++);
        participant.add(new Participant(ref3));
        appointment.setCreated(patientAppointmentK.getAppointment_date());
        Reference ref4 = new Reference();
        ref4.setId("ref" + i++);
        ref4.setType("Location = Organization/MedicalDepartment");
        ref4.setReference("http://localhost:8080/api/organization/" + patientAppointmentK.getDepartment());
        participant.add(new Participant(ref4));

        // reference für den Slot fehlt noch
        return appointment;
    }
}
