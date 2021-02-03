package FhirModel;

public class Organization extends DomainResource {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organization(String name) {
        this.name = name;
    }


    public Organization (){super();}
}
