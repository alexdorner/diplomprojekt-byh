package Impl;

import FhirModel.Location;
import KisModel.Company;
import mapper.LocationMapper;

public class LocationWrapperImpl implements LocationMapper {
    @Override
    public Location FromCompanyToLocation(Company company) {
        if(company == null){
            return null;
        }
        Location location = new Location();
        location.setId(company.getName());
        location.setName(company.getName());
        return location;
    }
    @Override
    public Location FromCompanyListToLocation(Company company) {
       if(company == null){
           return null;
       }

       Location location= new Location();
       location.setId(company.getName());
       return location;
    }
}
