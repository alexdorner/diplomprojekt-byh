package FhirModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Appointment extends DomainResource{

    //Set<Reference> reasonReference = new HashSet<Reference>();
    //Patient muss noch dazu

    Set<Participant> participant = new HashSet<Participant>();//Da ist dann der Appointment_Type und der Patient drinnen
    Set<Reference> slot = new HashSet<Reference>(); //duration
    public String start; //appointment_time

    @JsonProperty("Date")
    public String getCreated() {
        return created;
    }
    @JsonProperty("Date")
    public void setCreated(String created) {
        this.created = created;
    }

    public String created;

    public Set<Participant> getParticipant() {
        return participant;
    }

    public void setParticipant(Set<Participant> participant) {
        this.participant = participant;
    }

    public Set<Reference> getSlot() {
        return slot;
    }

    public void setSlot(Set<Reference> slot) {
        this.slot = slot;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }


}
