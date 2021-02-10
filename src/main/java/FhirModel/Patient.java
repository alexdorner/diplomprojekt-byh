package FhirModel;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.HashSet;
import java.util.Set;

public class Patient  extends DomainResource{

    public Patient(){super();}

    private Set<Identifier> identifier=  new HashSet<Identifier>();

    public Patient(Set<Identifier> identifier, Set<ContactPoint> telecome) {
        this.identifier = identifier;
        this.telecome = telecome;
    }


    public Set<Identifier> getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Set<Identifier> identifier) {
        this.identifier = identifier;
    }


    public Set<ContactPoint> getTelecome() {
        return telecome;
    }

    public void setTelecome(Set<ContactPoint> telecome) {
        this.telecome = telecome;
    }

    private Set<ContactPoint> telecome =  new HashSet<ContactPoint>();


    @Override
    public String toString() {
        return "Patient{" +
                "identifier=" + identifier +
                ", telecome=" + telecome +
                ", id='" + id + '\'' +
                '}';
    }
}
