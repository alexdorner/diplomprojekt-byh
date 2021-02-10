package FhirModel;

public class Reference extends Element {

    public String type;

    public Reference(String type, String reference) {
        this.type = type;
        this.reference = reference;
    }


    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String reference;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }





    public Reference (){super();}

}
