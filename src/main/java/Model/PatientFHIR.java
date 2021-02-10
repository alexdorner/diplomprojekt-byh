package Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PatientFHIR {
	//public PatientFHIR(){}

    String idF;
    String vorname;


    String nachname;

    @JsonProperty("FHIR_ID")
    public String getId() {
        return idF;
    }

    @JsonProperty("FHIR_ID")
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

}
