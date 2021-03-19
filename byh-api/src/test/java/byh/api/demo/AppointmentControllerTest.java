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
			.perform(MockMvcRequestBuilders.get("/api/appointment/GetAll"))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk()); 
	}

	@Test
	public void getAppointments() throws Exception {
		mockMvc
			.perform(MockMvcRequestBuilders.get("/api/appointment/1b8f2dd081"))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk()); 
	}

	@Test
	public void stornoAppointment() throws Exception {
		mockMvc
			.perform(MockMvcRequestBuilders.get("/api/appointment/stornieren"))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk()); 
	}
	@Test
	public void vormerkenAppointment() throws Exception {
		/*mockMvc
			.perform(MockMvcRequestBuilders.get("/api/appointment/vormerken?IdAppointment=1b8f2dd081&phonenumber=431234567&mail=BookYourHospital@gmail.com"))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk()); 
	*/
	}
}
