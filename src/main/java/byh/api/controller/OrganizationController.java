package byh.api.controller;

import FhirModel.*;
import Impl.DepartmentMapperImpl;
import KisModel.MedicalDepartmentK;
import mapper.DepartmentMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping(path = "/api/organization")
@CrossOrigin
public class OrganizationController {



}

/*
@GetMapping
    public @ResponseBody
    Iterable<Organization> GetAllOrganizations() {
        Reference reference1 = new Reference("Organization",  "http://localhost:8080/api/organization/123Cardio");
        Organization organization1 = new Organization("Cardio", reference1);
        organization1.setId("123");
        Reference reference2 = new Reference("Organization", "http://localhost:8080/api/organization/11Röntgen");
        Organization organization2 = new Organization("Röntgen", reference2);
        organization2.setId("11Röntgen");
        Reference reference3 = new Reference("Organization", "http://localhost:8080/api/organization/1100Interne");
        Organization organization3 = new Organization("Interne", reference3);
        organization3.setId("1100Interne");
        List<Organization> departmentList = new ArrayList<>();
        departmentList.add(organization1);
        departmentList.add(organization2);
        departmentList.add(organization3);
        return departmentList;
    }

    @GetMapping("/getAll")
    public @ResponseBody
    Iterable<Organization> GetAllOrganizationsREAL(@RequestBody Set<MedicalDepartmentK> medicalDepartmentKS) {
        Set<Organization> organizations = new HashSet<>();
        DepartmentMapper pm = new DepartmentMapperImpl();
        medicalDepartmentKS.forEach(d -> {
            organizations.add((pm.FromKisDepartmentToOrganization(d)));
        });
        return organizations;
    }


    @GetMapping("/{id}")
    public @ResponseBody
    Organization getOneOrganization(@PathVariable String id) {
        Reference reference1 = new Reference("Organization",  "http://localhost:8080/api/organization/123Cardio");
        reference1.setId("refi01");
        Organization organization1 = new Organization("Cardio", reference1);
        organization1.setId("123Cardio");
        Reference reference2 = new Reference( "Organization", "http://localhost:8080/api/organization/11Röntgen");
        reference2.setId("ref02");
        Organization organization2 = new Organization("Röntgen", reference2);
        organization2.setId("11Röntgen");
        Reference reference3 = new Reference("Organization", "http://localhost:8080/api/organization/1100Interne");
        reference3.setId("ref03");
        Organization organization3 = new Organization("Interne", reference3);
        organization3.setId("1100Interne");

        List<Organization> departmentList = new ArrayList<>();
        departmentList.add(organization1);
        departmentList.add(organization2);
        departmentList.add(organization3);

        //departmentList.stream().filter((o)-> o.getId() == id).findFirst();
        for (Organization o : departmentList) {
            if (o.getId().equals(id)) {
                return o;
            }
        }

        return null;
    }

    @GetMapping("HealthCareService/{id}")
    public @ResponseBody
    HealthCareService getHealthCareService (@PathVariable String id){
        Reference reference1 = new Reference("Organization",  "http://localhost:8080/api/organization/123Cardio");
        HealthCareService healthCareService1 = new HealthCareService(reference1);
        healthCareService1.setId("h1");

        Reference reference2 = new Reference("Organization",  "http://localhost:8080/api/organization/11Röntgen");
        HealthCareService healthCareService2 = new HealthCareService(reference2);
        healthCareService2.setId("h2");

        Reference reference3 = new Reference("Organization",  "http://localhost:8080/api/organization/1100Interne");
        HealthCareService healthCareService3 = new HealthCareService(reference3);
        healthCareService3.setId("h3");

        List<HealthCareService> healthCareServiceList = new ArrayList<>();
        healthCareServiceList.add(healthCareService1);
        healthCareServiceList.add(healthCareService2);
        healthCareServiceList.add(healthCareService3);

        for (HealthCareService healthCareService : healthCareServiceList) {
            if (healthCareService.getId().equals(id)) {
                return healthCareService;
            }
        }

        return null;
    }

    @RequestMapping("/try2")
    public Iterable<String> getData() throws IOException {
        Document doc = Jsoup.connect("https://www.hl7.org/fhir/organization.html").get();
        //Elements element = doc.body().select("*");
        List<String> elm = new ArrayList<>();
        List<Element> elme = new ArrayList<>();
        String titel = doc.title();
        Element body = doc.select("a").first();
        String text = doc.body().text();
        Element p = doc.getElementById("12");
        elm.add(text);
        elm.add(titel);
        elme.add(body);
        //elme.add(p);

        for (Element e : element) {
            System.out.println(e);
        }

        return elm;

                }

@RequestMapping("/try")
public RedirectView localRedirect(){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:81/desk#List/Patient/List");
        return redirectView;
        }

@GetMapping("/appointment/{id}")
public @ResponseBody
    Appointment getAppointment (@PathVariable String id) {
        Reference reference1 = new Reference("Organization",  "http://localhost:8080/api/organization/123Cardio");
        reference1.setId("ref01");
        Organization organization1 = new Organization("Cardio", reference1);
        organization1.setId("123Cardio");

        Reference reference2 = new Reference( "Organization",  "http://localhost:8080/api/organization/11Röntgen");
        reference2.setId("ref02");
        Organization organization2 = new Organization("Röntgen", reference2);
        organization2.setId("11Röntgen");

        Reference reference3 = new Reference("Organization",  "http://localhost:8080/api/organization/1100Interne");
        Organization organization3 = new Organization("Interne", reference3);
        organization3.setId("1100Interne");


        HealthCareService healthCareService1 = new HealthCareService(reference1);

        Reference reference5 = new Reference( "HealthCareService", "URL für HealthCareService");

        Set<Participant> participants1 = new HashSet<>();
        participants1.add((new Participant(reference5)));

        Set<Reference> references3 = new HashSet<Reference>();
        references3.add(new Reference( "Organization Cardio", "URL für Cardio"));
        references3.add(reference1);
        Set<Reference> references4 = new HashSet<Reference>();
        references4.add(new Reference("Which slot in the Organization Cardio", "URL für Cardio_Slot"));
        Set<CodeableConcept> codeableConcept1 = new HashSet<CodeableConcept>();
        codeableConcept1.add(new CodeableConcept("Text"));
        Appointment appointment1 = new Appointment(references3, participants1 , references4,codeableConcept1);
        appointment1.setId("a01");

        HealthCareService healthCareService2 = new HealthCareService(reference2);
        Reference reference6 = new Reference("HealthCareService", "URL für HealthCareService");
        Set<Participant> participants2 = new HashSet<>();
        participants1.add((new Participant(reference5)));
        Set<Reference> references7 = new HashSet<Reference>();
        references7.add(new Reference( "Organization Cardio", "URL für Cardio"));
        references7.add(reference2);
        Set<Reference> references8 = new HashSet<Reference>();
        references8.add(new Reference( "Which slot in the Organization Cardio", "URL für Cardio_Slot"));
        Set<CodeableConcept> codeableConcept2 = new HashSet<CodeableConcept>();
        codeableConcept2.add(new CodeableConcept("Text"));
        Appointment appointment2 = new Appointment(references7,participants2 , references8,codeableConcept2);
        appointment2.setId("a02");

        List<Appointment> appointmentList = new ArrayList<>();
        appointmentList.add(appointment1);
        appointmentList.add(appointment2);

        List<Organization> departmentList = new ArrayList<>();
        departmentList.add(organization1);
        departmentList.add(organization2);
        departmentList.add(organization3);

        List<HealthCareService> healthCareServiceList = new ArrayList<>();
        healthCareServiceList.add(healthCareService1);
        healthCareServiceList.add(healthCareService2);

        Organization reqOrg = departmentList.stream().filter(d -> d.getId()== id).findFirst().get();
        HealthCareService reqHealth = healthCareServiceList.stream().filter(h -> h.getProvidedBy() == reqOrg.getPartOf()).findFirst().get();

        //List<Appointment> reqappointments = appointmentList.stream().filter(a -> a.getParticipant().stream().filter(p -> p.getActor() == reqHealth.getProvidedBy()).findAny()).findAny();


        //departmentList.stream().filter((o)-> o.getId() == id).findFirst();

        for (Organization o : departmentList) {
            if (o.getId().equals(id)) {
                return o;
            }
        }

        for (Appointment o : appointmentList) {
        if (o.getId().equals(id)) {
        return o;
        }
        }

        return null;
        }
 */