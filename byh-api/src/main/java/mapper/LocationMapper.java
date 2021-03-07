package mapper;

import FhirModel.Location;
import KisModel.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LocationMapper {
    LocationMapper locationMapper = Mappers.getMapper(LocationMapper.class);

    Location FromCompanyToLocation(Company company);
    Location FromCompanyListToLocation (Company company);

}
