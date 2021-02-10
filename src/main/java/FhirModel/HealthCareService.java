package FhirModel;


public class HealthCareService extends DomainResource{
    public Reference providedBy;
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Reference getProvidedBy() {
        return providedBy;
    }

    public void setProvidedBy(Reference providedBy) {
        this.providedBy = providedBy;
    }


}
