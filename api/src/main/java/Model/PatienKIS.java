package Model;

public class PatienKIS {
    String idK;
    String vorname;

    public PatienKIS(String id, String vorname, String nachname) {
        this.idK = id;
        this.vorname = vorname;
        this.nachname = nachname;
    }

    String nachname;
    public String getId() {
        return idK;
    }

    public void setId(String id) {
        this.idK = id;
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
