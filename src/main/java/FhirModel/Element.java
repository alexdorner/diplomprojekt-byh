package FhirModel;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.hibernate.annotations.GenericGenerator;
public class Element {

    @GeneratedValue(strategy = GenerationType.AUTO,generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    String id;


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


}
