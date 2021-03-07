package FhirModel;

public class Location extends DomainResource {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;

}
