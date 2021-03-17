package byh.api.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class LocationControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void getAllLocationControllers() throws Exception {
		mockMvc
			.perform(MockMvcRequestBuilders.get("/api/location/GetAll"))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk()); 
	}
	
	@Test
	public void getAllLocationController() throws Exception {
		mockMvc
			.perform(MockMvcRequestBuilders.get("/api/location/BookYourHospital"))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk()); 
	}

}
