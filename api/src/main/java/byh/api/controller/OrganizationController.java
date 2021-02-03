package byh.api.controller;

import FhirModel.Organization;
import FhirModel.Patient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "/api/organization")

public class OrganizationController {

    @GetMapping
    public @ResponseBody
    Iterable <Organization> GetAllOrganizationss()
    {
        Organization organization1 = new Organization("Cardio");
        organization1.setId("123");
        Organization organization2 = new Organization("Röntgen");
        List<Organization> departmentList= new ArrayList<>();
        departmentList.add(organization1);
        departmentList.add(organization2);
        return departmentList;
    }

}
