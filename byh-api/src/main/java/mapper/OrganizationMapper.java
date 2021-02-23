package mapper;


import FhirModel.Organization;
import KisModel.MedicalDepartmentK;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganizationMapper {

    OrganizationMapper organizationtMapper = Mappers.getMapper(OrganizationMapper.class);
    Organization FromKisDepartmentToOrganization (MedicalDepartmentK medicalDepartmentK);


}
