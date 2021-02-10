package FhirModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Organization extends DomainResource {
    public Reference partOf;
    public String name;

    public Organization(String name, Reference partOf) {
        this.name = name;
        this.partOf = partOf;
    }

    @JsonIgnore
    public Reference getPartOf() {
        return partOf;
    }

    @JsonIgnore
    public void setPartOf(Reference partOf) {
        this.partOf = partOf;
    }

    @JsonProperty("Name_FHIR_Organization")
    public String getName() {
        return name;
    }

    @JsonProperty("Name_FHIR_Organization")
    public void setName(String name) {
        this.name = name;
    }


    public Organization (){super();}
}
