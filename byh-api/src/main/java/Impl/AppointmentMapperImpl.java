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


        Patient patient = new Patient();

        Reference ref2 = new Reference();
        ref2.setReference("Patient");
        ref2.setType("Patient");
        ref2.setId(patientAppointmentK.getID());
        Participant pPatient = new Participant(ref2);
        pPatient.setId("patient");
        //participant.add(new Participant(ref2));
        participant.add(pPatient);

        appointment.setParticipant(participant);
        appointment.setId(patientAppointmentK.getName());
        appointment.setStart(patientAppointmentK.getAppointment_time());

        Reference ref3 = new Reference();
        ref3.setType("Location");
        ref3.setId(patientAppointmentK.getCompany());
        ref3.setReference("http://localhost:8080/api/location/"+patientAppointmentK.getCompany());
        Participant pCompany = new Participant(ref3);
        pCompany.setId("Location");
        participant.add(pCompany);

        appointment.setCreated(patientAppointmentK.getAppointment_date());

        Reference ref4 = new Reference();
        ref4.setId(patientAppointmentK.getDepartment());
        ref4.setType("Organization");
        ref4.setReference("http://localhost:8080/api/organization/" + patientAppointmentK.getDepartment());
        Participant pOrganization = new Participant(ref4);
        pOrganization.setId("Organization");
        participant.add(pOrganization);

        Reference ref5 = new Reference();
        ref5.setId(patientAppointmentK.getService_unit());
        ref5.setType("Device");
        ref5.setReference("http://localhost:8080/api/device/" +patientAppointmentK.getService_unit());
        Participant pDevice = new Participant(ref5);
        pDevice.setId("Device");
        participant.add(pDevice);

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
