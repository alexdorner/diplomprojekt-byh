package byh.api.controller;

import FhirModel.Organization;
import FhirModel.Patient;
import FhirModel.Reference;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "/api/organization")

public class OrganizationController {

    @GetMapping
    public @ResponseBody
    Iterable<Organization> GetAllOrganizationss() {
        Reference reference1 = new Reference("Cardio", "Organization", "URL für Organization wo Cardio ist");
        Organization organization1 = new Organization("Cardio", reference1);
        organization1.setId("123");
        Reference reference2 = new Reference("Röntgen", "Organization", "S");
        Organization organization2 = new Organization("Röntgen", reference2);
        List<Organization> departmentList = new ArrayList<>();
        departmentList.add(organization1);
        departmentList.add(organization2);
        return departmentList;
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Organization getOneOrganization(@PathVariable String id) {
        Reference reference1 = new Reference("Cardio", "Organization", "URL für Organization wo Cardio ist");
        Organization organization1 = new Organization("Cardio", reference1);
        organization1.setId("123Cardio");
        Reference reference2 = new Reference("Röntgen", "Organization", "S");
        Organization organization2 = new Organization("Röntgen", reference2);
        organization2.setId("11Röntgen");
        Reference reference3 = new Reference("Interne", "Organization", "URL für Organization wo die Interne ist");
        Organization organization3 = new Organization("Interne", reference3);
        organization3.setId("1100Interne");
        List<Organization> departmentList = new ArrayList<>();
        departmentList.add(organization1);
        departmentList.add(organization2);
        departmentList.add(organization3);

        for (Organization o : departmentList) {
            if (o.getId().equals(id)) {
                return o;
            }
        }
        return null;
    }
}

