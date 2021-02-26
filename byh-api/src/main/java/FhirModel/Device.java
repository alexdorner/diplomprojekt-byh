package FhirModel;

public class Device {

    public Reference owner;

    public Reference getOwner() {
        return owner;
    }

    public void setOwner(Reference owner) {
        this.owner = owner;
    }

    public DeviceName getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(DeviceName deviceName) {
        this.deviceName = deviceName;
    }

    public DeviceName deviceName;
}
