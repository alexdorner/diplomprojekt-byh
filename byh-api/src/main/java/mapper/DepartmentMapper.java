package mapper;


import FhirModel.Organization;
import KisModel.MedicalDepartmentK;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper departmentMapper = Mappers.getMapper(DepartmentMapper.class);
    Organization FromKisDepartmentToOrganization (MedicalDepartmentK medicalDepartmentK);


}
