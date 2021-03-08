package KisModel;

import java.util.HashSet;
import java.util.Set;

public class PatientKWrapperList {
    public Set<PatientK> getData() {
        return data;
    }

    public void setData(Set<PatientK> data) {
        this.data = data;
    }

    Set<PatientK> data = new HashSet<>();
}
