package br.ufc.npi.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class JogadorControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private JogadorController jogadorController;
	

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(jogadorController).build();
	}
	
	@Test
	public void testGETIndexJogadorController() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/jogadores/")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testGETSaveJogadorController() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/jogadores/"))
			.andExpect(MockMvcResultMatchers.model().attributeExists("nomeJogador","idadeJogador"))	
			.andExpect(MockMvcResultMatchers.status().isOk());
}
	
	
	
}

