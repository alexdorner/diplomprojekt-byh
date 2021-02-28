package mapper;

import FhirModel.Device;
import KisModel.ServiceUnit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeviceMapper {
    DeviceMapper deviceMapper = Mappers.getMapper(DeviceMapper.class);

    Device FromerviceUnitToDevice (ServiceUnit serviceUnit);

    Device FromDeviceListToDevice (ServiceUnit serviceUnit);
}
