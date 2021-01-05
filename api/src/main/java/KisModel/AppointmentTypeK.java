package KisModel;

public class AppointmentTypeK {
String appointmentTypeK_Id;
String appointmentTypeK_Type;
String appointmentTypeK_Extra;
String appointmentTypeK_Duration;

    public AppointmentTypeK(String appointmentTypeK_Id, String appointmentTypeK_Type, String appointmentTypeK_Extra, String appointmentTypeK_Duration, MedicalDepartmentK medicalDepartmentKID) {
        this.appointmentTypeK_Id = appointmentTypeK_Id;
        this.appointmentTypeK_Type = appointmentTypeK_Type;
        this.appointmentTypeK_Extra = appointmentTypeK_Extra;
        this.appointmentTypeK_Duration = appointmentTypeK_Duration;
        this.medicalDepartmentKID = medicalDepartmentKID;
    }

    public MedicalDepartmentK medicalDepartmentKID;

    public MedicalDepartmentK getMedicalDepartmentKID() {
        return medicalDepartmentKID;
    }

    public void setMedicalDepartmentKID(MedicalDepartmentK medicalDepartmentKID) {
        this.medicalDepartmentKID = medicalDepartmentKID;
    }



    public String getAppointmentTypeK_Id() {
        return appointmentTypeK_Id;
    }

    public void setAppointmentTypeK_Id(String appointmentTypeK_Id) {
        this.appointmentTypeK_Id = appointmentTypeK_Id;
    }

    public String getAppointmentTypeK_Type() {
        return appointmentTypeK_Type;
    }

    public void setAppointmentTypeK_Type(String appointmentTypeK_Type) {
        this.appointmentTypeK_Type = appointmentTypeK_Type;
    }

    public String getAppointmentTypeK_Extra() {
        return appointmentTypeK_Extra;
    }

    public void setAppointmentTypeK_Extra(String appointmentTypeK_Extra) {
        this.appointmentTypeK_Extra = appointmentTypeK_Extra;
    }

    public String getAppointmentTypeK_Duration() {
        return appointmentTypeK_Duration;
    }

    public void setAppointmentTypeK_Duration(String appointmentTypeK_Duration) {
        this.appointmentTypeK_Duration = appointmentTypeK_Duration;
    }


}
