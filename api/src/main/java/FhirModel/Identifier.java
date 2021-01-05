package FhirModel;

public class Identifier extends Element {
    public enum Identifier_code {usual, official, temp, secondary, old}
    public Identifier_code use;

    public Identifier_code getUse() {
        return use;
    }

    public Identifier(Identifier_code use) {
        this.use = use;
    }

    public void setUse(Identifier_code use) {
        this.use = use;
    }

    public Identifier(){super();}

}
