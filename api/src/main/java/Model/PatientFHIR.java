package Model;

public class PatientFHIR {
	//public PatientFHIR(){}
    String idF;
    String vorname;

    @Override
    public String toString() {

        return "PatientFHIR{" +
                "idF='" + idF + '\'' +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                '}';
    }

    String nachname;

    public String getId() {
        return idF;
    }

    public void setId(String id) {
        this.idF= id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }


    /*

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public static class PatientFHIRBuilder{
    String id;
    String vorname;
    String nachname;

    public PatientFHIRBuilder withid(String id){
        this.id = id;
        return this;
    }
    public PatientFHIRBuilder whitvorname(String vorname){
        this.vorname = vorname;
        return this;
    }
    public PatientFHIRBuilder withnachname(String nachname){
        this.nachname = nachname;
        return this;
    }

    public PatientFHIR build(){
        PatientFHIR patientFHIR = new PatientFHIR();
        patientFHIR.id = this.id;
        patientFHIR.vorname = this.vorname;
        patientFHIR.nachname = this.nachname;
        return patientFHIR;
    }

    }

     */
}
