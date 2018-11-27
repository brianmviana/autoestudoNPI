package br.ufc.npi.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PrincipalControllerTest {
	
	private MockMvc mockMvc;
	
	private PrincipalController principalController;
	
	@Before
	public void setup() {
		principalController = new PrincipalController();
		mockMvc = MockMvcBuilders.standaloneSetup(principalController).build();
	}
	
	@Test
	public void testIndex() throws Exception{
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("index"));
	}

}
