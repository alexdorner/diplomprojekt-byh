package FhirModel;

public class ContactPoint extends Element{
    public enum CodeContactPoint_system {phone, fax, email, pager, url, sms, other}
    public CodeContactPoint_system system;
    String value;

    public enum ContactPoint_use {home, work, temp, old, mobile}

    public CodeContactPoint_system getSystem() {
        return system;
    }

    public void setSystem(CodeContactPoint_system system) {
        this.system = system;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ContactPoint(){super();}



}
