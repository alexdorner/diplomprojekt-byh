package KisModel;

import java.time.LocalDateTime;

public class PatientK {
    String patientK_UUID;
    String patientK_Email;
    String patientK_Svnr;
    String patientK_Mobile;
    LocalDateTime patientK_DateOfBirth;



    @Override
    public String toString() {
        return "PatientK{" +
                "patientK_UUID='" + patientK_UUID + '\'' +
                ", patientK_Email='" + patientK_Email + '\'' +
                ", patientK_Svnr='" + patientK_Svnr + '\'' +
                ", patientK_Mobile='" + patientK_Mobile + '\'' +
                ", patientK_DateOfBirth=" + patientK_DateOfBirth +
                ", patientK_FirstName='" + patientK_FirstName + '\'' +
                ", patientK_Gender='" + patientK_Gender + '\'' +
                ", patientK_SecondName='" + patientK_SecondName + '\'' +
                '}';
    }

    String patientK_FirstName;
    String patientK_Gender;

    public PatientK(String patientK_UUID, String patientK_Email, String patientK_Svnr, String patientK_Mobile, LocalDateTime patientK_DateOfBirth, String patientK_FirstName, String patientK_Gender, String patientK_SecondName) {
        this.patientK_UUID = patientK_UUID;
        this.patientK_Email = patientK_Email;
        this.patientK_Svnr = patientK_Svnr;
        this.patientK_Mobile = patientK_Mobile;
        this.patientK_DateOfBirth = patientK_DateOfBirth;
        this.patientK_FirstName = patientK_FirstName;
        this.patientK_Gender = patientK_Gender;
        this.patientK_SecondName = patientK_SecondName;
    }

    String patientK_SecondName;

    public String getPatientK_UUID() {
        return patientK_UUID;
    }

    public void setPatientK_UUID(String patientK_UUID) {
        this.patientK_UUID = patientK_UUID;
    }

    public String getPatientK_Email() {
        return patientK_Email;
    }

    public void setPatientK_Email(String patientK_Email) {
        this.patientK_Email = patientK_Email;
    }

    public String getPatientK_Svnr() {
        return patientK_Svnr;
    }

    public void setPatientK_Svnr(String patientK_Svnr) {
        this.patientK_Svnr = patientK_Svnr;
    }

    public String getPatientK_Mobile() {
        return patientK_Mobile;
    }

    public void setPatientK_Mobile(String patientK_Mobile) {
        this.patientK_Mobile = patientK_Mobile;
    }

    public LocalDateTime getPatientK_DateOfBirth() {
        return patientK_DateOfBirth;
    }

    public void setPatientK_DateOfBirth(LocalDateTime patientK_DateOfBirth) {
        this.patientK_DateOfBirth = patientK_DateOfBirth;
    }

    public String getPatientK_FirstName() {
        return patientK_FirstName;
    }

    public void setPatientK_FirstName(String patientK_FirstName) {
        this.patientK_FirstName = patientK_FirstName;
    }

    public String getPatientK_Gender() {
        return patientK_Gender;
    }

    public void setPatientK_Gender(String patientK_Gender) {
        this.patientK_Gender = patientK_Gender;
    }

    public String getPatientK_SecondName() {
        return patientK_SecondName;
    }

    public void setPatientK_SecondName(String patientK_SecondName) {
        this.patientK_SecondName = patientK_SecondName;
    }



}
