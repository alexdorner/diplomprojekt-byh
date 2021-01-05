package KisModel;

public class PatientAppointmentK  {

    String patientAppointmentK_id;

    public PatientAppointmentK(String patientAppointmentK_id, AppointmentTypeK appointmentTypeKID, PatientK patientKID) {
        this.patientAppointmentK_id = patientAppointmentK_id;
        this.appointmentTypeKID = appointmentTypeKID;
        this.patientKID = patientKID;
    }

    public AppointmentTypeK getAppointmentTypeKID() {
        return appointmentTypeKID;
    }

    public void setAppointmentTypeKID(AppointmentTypeK appointmentTypeKID) {
        this.appointmentTypeKID = appointmentTypeKID;
    }

    public AppointmentTypeK appointmentTypeKID;

    public PatientK patientKID;

    public PatientK getPatientKID() {
        return patientKID;
    }

    public void setPatientKID(PatientK patientKID) {
        this.patientKID = patientKID;
    }


    public String getPatientAppointmentK_id() {
        return patientAppointmentK_id;
    }

    public void setPatientAppointmentK_id(String patientAppointmentK_id) {
        this.patientAppointmentK_id = patientAppointmentK_id;
    }


}
