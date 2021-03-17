package byh.api.demo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import FhirModel.ContactPoint;
import FhirModel.Identifier;
import FhirModel.Identifier.Identifier_code;
import FhirModel.Patient;
import FhirModel.ContactPoint.CodeContactPoint_system;
import FhirModel.ContactPoint.ContactPoint_use;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientControllerTest {
	
	@Autowired
	MockMvc mockMvc;

	@Test
	public void createPatient() throws Exception {
		
		
		Set<Identifier> identifier = new HashSet<Identifier>();
		identifier.add(new Identifier(Identifier_code.official));
		
		//Set<ContactPoint> telecome = new HashSet<ContactPoint>();
		//telecome.add(new ContactPoint(CodeContactPoint_system.email, "test@test.at", ContactPoint_use.home));
		
		Patient p = new Patient();
		p.setId("1");
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		
		String json = objectMapper.writeValueAsString(p);
		
		/*
		mockMvc
			.perform(MockMvcRequestBuilders.post("/api/patient")
			.accept(MediaType.APPLICATION_JSON)
			.contentType(MediaType.APPLICATION_JSON)
			.content(json))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk());
		*/
	}	
}
