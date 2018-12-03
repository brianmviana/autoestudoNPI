package br.ufc.npi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.ufc.npi.bean.Jogador;
import br.ufc.npi.controller.JogadorController;
import br.ufc.npi.service.JogadorService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JogadorControllerTest {

	private MockMvc mockMvc;

	@Autowired
    private WebApplicationContext webApplicationContext;

	@Autowired
	private JogadorController controller;

	@MockBean
    private JogadorService jogadorServiceMock;

    Jogador jogador;
    @Before
    public void setUpProduct() throws Exception{
    	jogador = new Jogador();
    	jogador.setId(1);
    	jogador.setNome("TESTE");
    	jogador.setIdade(21);
    }

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
	

	@Test
	public void jogadorControler() throws Exception {
		assertThat(controller).isNotNull();
	}

    @Test
    public void testList() throws Exception {
        assertThat(this.jogadorServiceMock).isNotNull();
        mockMvc.perform(MockMvcRequestBuilders.get("/jogadores/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("jogadores"))
                .andExpect(MockMvcResultMatchers.view().name("jogadores"))
                .andExpect(content().string(Matchers.containsString("Jogadores")))
                .andDo(print());
    }
    
//    @Test
//    public void addTest() throws Exception {
//    	assertThat(this.jogadorServiceMock).isNotNull();
//    	mockMvc.perform(MockMvcRequestBuilders.post("/jogadores/salvar", jogador))
//    	.andExpect(status().isOk())
//        .andExpect(view().name("jogadores"));
//    }
}
