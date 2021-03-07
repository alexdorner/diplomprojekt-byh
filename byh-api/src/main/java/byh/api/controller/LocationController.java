package byh.api.controller;


import FhirModel.Location;
import Impl.LocationWrapperImpl;
import KisModel.CompanyWrapper;
import KisModel.CompanyWrapperList;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/location")
@CrossOrigin
//Krankenhaus
public class LocationController {

@GetMapping("/GetAll")
    public  @ResponseBody
    Iterable<Location> getAllHospitals(){
    final String companys = "http://192.189.51.8/api/resource/Company?" + LoginDataController.getAll();
    RestTemplate restTemplate = new RestTemplate();
    Set<Location> hospitals = new HashSet<>();
    LocationWrapperImpl locationWrapper = new LocationWrapperImpl();
    CompanyWrapperList wrapperList = restTemplate.getForObject(companys, CompanyWrapperList.class);
    wrapperList.getData().forEach(hospital ->{
        hospitals.add((locationWrapper.FromCompanyToLocation(hospital)));
    });
    return hospitals;
}

@GetMapping("/{id}")
    public  Location getOneHospital(@PathVariable String id){
    Set<Location> locations = new HashSet<>();
    final String singleHospital ="http://192.189.51.8/api/resource/Company/"+ id + "?" + LoginDataController.getAll();
    LocationWrapperImpl locationWrapper = new LocationWrapperImpl();
    RestTemplate restTemplate = new RestTemplate();
    CompanyWrapper companyWrapper =restTemplate.getForObject(singleHospital, CompanyWrapper.class);
    return locationWrapper.FromCompanyToLocation(companyWrapper.getData());
}
}
