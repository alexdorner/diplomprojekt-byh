package FhirModel;

public class Reference extends Element {

    public String type;

    public Reference(String type, String uri, String reference) {
        this.type = type;
        this.uri = uri;
        this.reference = reference;
    }

    public String uri;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String reference;




    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }





    public Reference (){super();}

}
