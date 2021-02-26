package Impl;

import FhirModel.Device;
import FhirModel.DeviceName;
import FhirModel.Reference;
import KisModel.ServiceUnit;
import mapper.DeviceMapper;

public class DeviceMapperImpl implements DeviceMapper {
    @Override
    public Device FromerviceUnitToDevice(ServiceUnit serviceUnit) {
        if (serviceUnit == null){
            return null;
        }

        Device device = new Device();
        DeviceName deviceName = new DeviceName();
        deviceName.setName(serviceUnit.getName());
        device.setDeviceName(deviceName);
        Reference reference = new Reference();
        reference.setType("Device");
        reference.setReference("Referez zum Organization");
        device.setOwner(reference);
        reference.setId("ref01");
        deviceName.setId(serviceUnit.getName());
        return device;
    }
}
