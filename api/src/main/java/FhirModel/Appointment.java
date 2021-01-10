package FhirModel;

import java.util.HashSet;
import java.util.Set;

public class Appointment extends DomainResource{

    Set<Reference> reasonReference = new HashSet<Reference>(); //type

    public Appointment(Set<Reference> reasonReference, Set<Reference> slot, Set<CodeableConcept> serviceType) {
        this.reasonReference = reasonReference;
        this.slot = slot;
        this.serviceType = serviceType;
    }

    Set<Reference> slot = new HashSet<Reference>(); //Duration

    public Set<Reference> getReasonReference() {
        return reasonReference;
    }

    public void setReasonReference(Set<Reference> reasonReference) {
        this.reasonReference = reasonReference;
    }

    public Set<Reference> getSlot() {
        return slot;
    }

    public void setSlot(Set<Reference> slot) {
        this.slot = slot;
    }

    public Set<CodeableConcept> getServiceType() {
        return serviceType;
    }

    public void setServiceType(Set<CodeableConcept> serviceType) {
        this.serviceType = serviceType;
    }

    Set<CodeableConcept> serviceType = new HashSet<CodeableConcept>();//extra
}
