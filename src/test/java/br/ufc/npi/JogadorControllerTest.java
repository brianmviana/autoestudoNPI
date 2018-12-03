package br.ufc.npi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.ufc.npi.controller.JogadorController;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JogadorControllerTest {
	@Autowired
	private JogadorController controller;

	private MockMvc mockMvc;
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(new JogadorController()).build();
	}


	@Test
	public void jogadorControler() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Test
	public void testIndex() throws Exception{
		this.mockMvc.perform(get("/jogadores/"))
		.andExpect(status().isOk())
		.andExpect(view().name("jogadores"))
		.andDo(print());
	}
}
