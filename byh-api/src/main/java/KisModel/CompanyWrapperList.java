package KisModel;

import java.util.HashSet;
import java.util.Set;

public class CompanyWrapperList {
    public Set<Company> getData() {
        return data;
    }

    public void setData(Set<Company> data) {
        this.data = data;
    }

    Set<Company> data = new HashSet<>();
}
