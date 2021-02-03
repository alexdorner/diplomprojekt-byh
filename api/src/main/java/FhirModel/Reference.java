package FhirModel;

public class Reference extends Element {

    public String type;
    public String uri;

    public Reference(String type, String uri) {
        this.type = type;
        this.uri = uri;
    }


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
