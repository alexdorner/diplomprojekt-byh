package byh.api.controller;

import FhirModel.Organization;
import Impl.OrganizationMapperImpl;
import KisModel.MedicaldepartmentWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;


@RestController
@RequestMapping(path = "/api/organization")
@CrossOrigin
public class OrganizationController {

    @GetMapping("/Get")
    public @ResponseBody
    Iterable<Organization> getAllOrganizations (/*@RequestBody OrganizationWrapper organization*/) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Set<Organization> o = new HashSet<>();
        OrganizationMapperImpl organizationMapper = new OrganizationMapperImpl();
        String json = ""{\data\":[{"\name\":"\Plastische, Rekonstruktive und Aethetische Chirurgie"},{"\name\":"\Psychiatrie und Psychotherapie"},{"\name\":"\Thoraxchirurgie"};"
        MedicaldepartmentWrapper wrapper = objectMapper.readValue(json, MedicaldepartmentWrapper.class);
        wrapper.getData().forEach( organization ->{
            o.add((organizationMapper.FromKisDepartmentToOrganization(organization)));
        });
        return o;
    }

    @GetMapping("/{id}")
    public Organization getOneOrganization(@PathVariable String id) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Set<Organization> o = new HashSet<>();
        OrganizationMapperImpl organizationMapper = new OrganizationMapperImpl();
        String json = ""{\data\":[{"\name\":"\Plastische, Rekonstruktive und Aethetische Chirurgie"},{"\name\":"\Psychiatrie und Psychotherapie"},{"\name\":"\Thoraxchirurgie"};"
        MedicaldepartmentWrapper wrapper = objectMapper.readValue(json, MedicaldepartmentWrapper.class);
        wrapper.getData().forEach( organization ->{
            o.add((organizationMapper.FromKisDepartmentToOrganization(organization)));
        });
        for (Organization org : o){
            if (org.getId().equals(id)){
                return org;
            }
        }
        return null;
    }

}
