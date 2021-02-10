package FhirModel;

public class ContactPoint extends Element{
    public enum CodeContactPoint_system {phone, fax, email, pager, url, sms, other}
    public CodeContactPoint_system system;

    public ContactPoint(CodeContactPoint_system system, String value, ContactPoint_use use) {
        this.system = system;
        this.value = value;
        this.use = use;
    }

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

    public ContactPoint_use getUse() {
        return use;
    }

    public void setUse(ContactPoint_use use) {
        this.use = use;
    }

    public ContactPoint_use use;

    public ContactPoint(){super();}



}
