package byh.api.controller;

import FhirModel.Organization;
import Impl.OrganizationMapperImpl;
import KisModel.MedicalDepartmentWrapper;
import KisModel.MedicaldepartmentWrapperList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;


@RestController
@RequestMapping(path = "/api/organization")
@CrossOrigin
public class OrganizationController {

    @GetMapping("/Get")
    public @ResponseBody
    Iterable<Organization> getAllOrganizations(/*@RequestBody OrganizationWrapper organization*/) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        final String medicalDepartment = "http://192.189.51.8/api/resource/Medical Department?" + LoginDataController.getAll();
        RestTemplate restTemplate = new RestTemplate();
        Set<Organization> o = new HashSet<>();
        OrganizationMapperImpl organizationMapper = new OrganizationMapperImpl();
        //String json ="{\"data\":[{\"name\":\"Urology\"},{\"name\":\"Serology\"},{\"name\":\"Rheumatology\"},{\"name\":\"Physiotherapy\"},{\"name\":\"Pathology\"},{\"name\":\"Orthopaedics\"},{\"name\":\"Oncology\"},{\"name\":\"Neurology\"},{\"name\":\"Nephrology\"},{\"name\":\"Microbiology\"},{\"name\":\"Maternity\"},{\"name\":\"Haematology\"},{\"name\":\"Gynaecology\"},{\"name\":\"General Surgery\"},{\"name\":\"Gastroenterology\"},{\"name\":\"ENT\"},{\"name\":\"Diagnostic Imaging\"},{\"name\":\"Dermatology\"},{\"name\":\"Cardiology\"},{\"name\":\"Biochemistry\"}]}";
        MedicaldepartmentWrapperList wrapper = restTemplate.getForObject(medicalDepartment, MedicaldepartmentWrapperList.class);
        wrapper.getData().forEach(organization -> {
            o.add((organizationMapper.FromKisDepartmentToOrganization(organization)));
        });
        return o;
    }

    @GetMapping("/{id}")
    public Organization getOneOrganization(@PathVariable String id) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Set<Organization> o = new HashSet<>();
        final String detailDepartment = "http://192.189.51.8/api/resource//Medical Department/" + id + "?" + LoginDataController.getAll();
        OrganizationMapperImpl organizationMapper = new OrganizationMapperImpl();
        RestTemplate restTemplate = new RestTemplate();
        //String json ="{\"data\":[{\"name\":\"Urology\"},{\"name\":\"Serology\"},{\"name\":\"Rheumatology\"},{\"name\":\"Physiotherapy\"},{\"name\":\"Pathology\"},{\"name\":\"Orthopaedics\"},{\"name\":\"Oncology\"},{\"name\":\"Neurology\"},{\"name\":\"Nephrology\"},{\"name\":\"Microbiology\"},{\"name\":\"Maternity\"},{\"name\":\"Haematology\"},{\"name\":\"Gynaecology\"},{\"name\":\"General Surgery\"},{\"name\":\"Gastroenterology\"},{\"name\":\"ENT\"},{\"name\":\"Diagnostic Imaging\"},{\"name\":\"Dermatology\"},{\"name\":\"Cardiology\"},{\"name\":\"Biochemistry\"}]}";
        MedicalDepartmentWrapper wrapper = restTemplate.getForObject(detailDepartment, MedicalDepartmentWrapper.class);

        return organizationMapper.FromKisDepartmentToOrganization(wrapper.getData());
    }
}

