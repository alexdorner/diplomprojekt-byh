package mapper;

import FhirModel.Patient;
import KisModel.PatientK;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {
    PatientMapper patientMapper = Mappers.getMapper(PatientMapper.class);

   // Patient FromKisToFhir(PatientK patientK);

    PatientK FromFhirToKis(Patient patient);

    Patient FromKisToFhir (PatientK patientK);
    
}
