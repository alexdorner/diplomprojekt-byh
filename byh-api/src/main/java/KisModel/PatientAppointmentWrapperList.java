package KisModel;

import java.util.HashSet;
import java.util.Set;

public class PatientAppointmentWrapperList {

    public Set<PatientAppointmentK> getData() {
        return data;
    }

    public void setData(Set<PatientAppointmentK> data) {
        this.data = data;
    }

    Set<PatientAppointmentK> data = new HashSet<>();
}
