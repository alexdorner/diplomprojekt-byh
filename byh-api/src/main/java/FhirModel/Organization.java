package FhirModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Organization extends DomainResource {
    public String name;


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
