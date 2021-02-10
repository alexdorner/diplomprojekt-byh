package KisModel;

import java.time.LocalDateTime;

public class PatientK {
    String ID;
    String email;
    String mobile;


    public PatientK(String patientK_UUID, String patientK_Email, String patientK_Mobile) {
        this.ID = patientK_UUID;
        this.email = patientK_Email;
        this.mobile = patientK_Mobile;
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPatientK_Email() {
        return email;
    }

    public void setPatientK_Email(String patientK_Email) {
        this.email = patientK_Email;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


}
