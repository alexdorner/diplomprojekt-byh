package FhirModel;

import FhirModel.Element;

public class CodeableConcept extends Element {
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CodeableConcept(String text) {
        this.text = text;
    }

    public String text;

}
