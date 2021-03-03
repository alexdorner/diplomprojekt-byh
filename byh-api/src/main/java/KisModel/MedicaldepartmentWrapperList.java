package KisModel;

import FhirModel.Organization;

import java.util.Set;

public class MedicaldepartmentWrapperList {

    public Set<MedicalDepartmentK> getData() {
        return data;
    }

    public void setData(Set<MedicalDepartmentK> data) {
        this.data = data;
    }

    Set<MedicalDepartmentK> data;
}
