package FhirModel;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Resource {

    @GeneratedValue(strategy = GenerationType.AUTO,generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    String id;
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    public String getId() {
        return id;
    }

    @GeneratedValue(strategy = GenerationType.AUTO,generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    public void setId(String id) {
        this.id = id;
    }

}
