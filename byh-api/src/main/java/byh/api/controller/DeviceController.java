package byh.api.controller;


import FhirModel.Device;
import FhirModel.Organization;
import Impl.DeviceMapperImpl;
import Impl.OrganizationMapperImpl;
import KisModel.MedicalDepartmentWrapper;
import KisModel.ServiceUnitWrapper;
import KisModel.ServiceUnitWrapperList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/device")
@CrossOrigin
public class DeviceController {

    @GetMapping("/GetAll")
    public @ResponseBody
    Iterable<Device> getAllDevices() throws JsonProcessingException {
        final String serviceUnitURL = "http://192.189.51.8/api/resource/Service Unit?" + LoginDataController.getAll();
        RestTemplate restTemplate = new RestTemplate();
        Set<Device> deviceList = new HashSet<>();
        Set<Device> devices = new HashSet<>();
        DeviceMapperImpl deviceMapper = new DeviceMapperImpl();
        ServiceUnitWrapperList wrapper = restTemplate.getForObject(serviceUnitURL, ServiceUnitWrapperList.class);
        wrapper.getData().forEach(serviceUnit -> {
            deviceList.add(deviceMapper.FromDeviceListToDevice(serviceUnit));
        });
        deviceList.forEach(device -> {
            final String detaildevice = "http://192.189.51.8/api/resource/Service Unit/" + device.getId() + "?" + LoginDataController.getAll();
            ServiceUnitWrapper serviceUnitWrapper = restTemplate.getForObject(detaildevice, ServiceUnitWrapper.class);
            devices.add(deviceMapper.FromerviceUnitToDevice(serviceUnitWrapper.getData()));
        });
        return devices;
    }

    @GetMapping("/{id}")
    public Device getOneDevice(@PathVariable String id) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Set<Device> o = new HashSet<>();
        final String detailDevice = "http://192.189.51.8/api/resource/Service Unit/" + id + "?" + LoginDataController.getAll();
        DeviceMapperImpl deviceMapper = new DeviceMapperImpl();
        RestTemplate restTemplate = new RestTemplate();
        //String json ="{\"data\":[{\"name\":\"Urology\"},{\"name\":\"Serology\"},{\"name\":\"Rheumatology\"},{\"name\":\"Physiotherapy\"},{\"name\":\"Pathology\"},{\"name\":\"Orthopaedics\"},{\"name\":\"Oncology\"},{\"name\":\"Neurology\"},{\"name\":\"Nephrology\"},{\"name\":\"Microbiology\"},{\"name\":\"Maternity\"},{\"name\":\"Haematology\"},{\"name\":\"Gynaecology\"},{\"name\":\"General Surgery\"},{\"name\":\"Gastroenterology\"},{\"name\":\"ENT\"},{\"name\":\"Diagnostic Imaging\"},{\"name\":\"Dermatology\"},{\"name\":\"Cardiology\"},{\"name\":\"Biochemistry\"}]}";
        ServiceUnitWrapper wrapper = restTemplate.getForObject(detailDevice, ServiceUnitWrapper.class);

        return deviceMapper.FromerviceUnitToDevice(wrapper.getData());
    }
}


