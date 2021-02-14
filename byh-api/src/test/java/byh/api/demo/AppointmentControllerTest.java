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
public class AppointmentControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void getAllAppointments() throws Exception {
		mockMvc
			.perform(MockMvcRequestBuilders.get("/api/GetAll"))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk()); 
	}

	@Test
	public void getAppointments() throws Exception {
		/*
		mockMvc
			.perform(MockMvcRequestBuilders.get("/api"))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk()); 
			*/
	}
}
