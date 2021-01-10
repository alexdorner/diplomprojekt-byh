package FhirModel;

public class Organization extends DomainResource {
    public Organization(String name, Reference partOf) {
        this.name = name;
        this.partOf = partOf;
    }

    public String name;

    public Reference getPartOf() {
        return partOf;
    }

    public void setPartOf(Reference partOf) {
        this.partOf = partOf;
    }

    public Reference partOf;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public Organization (){super();}
}
