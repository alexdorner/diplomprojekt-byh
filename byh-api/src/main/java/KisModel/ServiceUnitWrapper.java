package KisModel;

import java.util.HashSet;
import java.util.Set;

public class ServiceUnitWrapper {

    public Set<ServiceUnit> getData() {
        return data;
    }

    public void setData(Set<ServiceUnit> data) {
        this.data = data;
    }

    Set<ServiceUnit> data = new HashSet<>();
}
