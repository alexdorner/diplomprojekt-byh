package FhirModel;

public class Participant extends BackboneElement{

    public Participant(Reference actor) {
        this.actor = actor;
    }

    public Reference actor;

    public Reference getActor() {
        return actor;
    }

    public void setActor(Reference actor) {
        this.actor = actor;
    }



}

