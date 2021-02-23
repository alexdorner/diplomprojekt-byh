package Impl;

import FhirModel.Organization;
import KisModel.MedicalDepartmentK;
import mapper.OrganizationMapper;

public class OrganizationMapperImpl implements OrganizationMapper {
    @Override
    public Organization FromKisDepartmentToOrganization(MedicalDepartmentK medicalDepartmentK) {
        if(medicalDepartmentK == null){
            return null;
        }
        Organization organization = new Organization();
        organization.setName(medicalDepartmentK.getName());
        organization.setId(medicalDepartmentK.getName());
        return organization;
    }
}
