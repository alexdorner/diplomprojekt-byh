package byh.api.controller;


import FhirModel.Appointment;
import FhirModel.Device;
import Impl.AppointmentMapperImpl;
import Impl.DeviceMapperImpl;
import KisModel.PatientAppointmentWrapper;
import KisModel.ServiceUnitWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/device")
@CrossOrigin
public class DeviceController {

    @GetMapping("GetAll")
    public @ResponseBody
    Iterable<Device> getAllDevices() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Set<Device> deviceList = new HashSet<>();
        DeviceMapperImpl deviceMapper = new DeviceMapperImpl();
        String json = "{\"data\":[{\"name\":\"CT\",\"department\":\"HNO\"}]}";
        ServiceUnitWrapper wrapper = objectMapper.readValue(json, ServiceUnitWrapper.class);
        wrapper.getData().forEach(d ->{
            deviceList.add(deviceMapper.FromerviceUnitToDevice(d));
        });
        return deviceList;
    }
}