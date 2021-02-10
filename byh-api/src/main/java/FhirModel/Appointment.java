package FhirModel;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Appointment extends DomainResource{

    //Set<Reference> reasonReference = new HashSet<Reference>();
    //Patient muss noch dazu

    Set<Participant> participant = new HashSet<Participant>();//Da ist dann der Appointment_Type und der Patient drinnen
    Set<Reference> slot = new HashSet<Reference>(); //duration
    public LocalDateTime start; //appointment_time

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String Name;

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

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }


}
