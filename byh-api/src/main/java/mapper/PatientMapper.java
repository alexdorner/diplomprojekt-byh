package mapper;

import FhirModel.Patient;
import KisModel.PatientK;
import Model.PatienKIS;
import Model.PatientFHIR;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {
    PatientMapper patientMapper = Mappers.getMapper(PatientMapper.class);

   // Patient FromKisToFhir(PatientK patientK);

    PatientFHIR FromKisToFhir(PatienKIS patienKIS);

    
}
