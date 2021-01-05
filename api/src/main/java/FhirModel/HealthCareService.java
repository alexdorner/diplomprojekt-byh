package FhirModel;



public class HealthCareService extends DomainResource{

    public Reference getProvidedBy() {
        return providedBy;
    }

    public void setProvidedBy(Reference providedBy) {
        this.providedBy = providedBy;
    }

    public HealthCareService(Reference providedBy) {
        this.providedBy = providedBy;
    }

    public Reference providedBy;
}
