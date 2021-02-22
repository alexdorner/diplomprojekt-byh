package Impl;

import FhirModel.Organization;
import KisModel.MedicalDepartmentK;
import mapper.DepartmentMapper;

public class DepartmentMapperImpl implements DepartmentMapper {
    @Override
    public Organization FromKisDepartmentToOrganization(MedicalDepartmentK medicalDepartmentK) {
        if(medicalDepartmentK == null){
            return null;
        }
        Organization organization = new Organization();
        organization.setName(medicalDepartmentK.getKis_service_unit_name());
        return organization;
    }
}
