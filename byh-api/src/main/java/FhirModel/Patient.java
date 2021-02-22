package FhirModel;

import java.util.HashSet;
import java.util.Set;

public class Patient  extends DomainResource{

    public Patient(){super();}



    public Set<ContactPoint> getTelecome() {
        return telecome;
    }

    public void setTelecome(Set<ContactPoint> telecome) {
        this.telecome = telecome;
    }

    private Set<ContactPoint> telecome =  new HashSet<ContactPoint>();


}
