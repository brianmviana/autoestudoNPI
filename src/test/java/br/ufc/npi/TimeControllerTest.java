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

import br.ufc.npi.bean.Time;
import br.ufc.npi.controller.TimeController;
import br.ufc.npi.service.TimeService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeControllerTest {

	private MockMvc mockMvc;

	@Autowired
    private WebApplicationContext webApplicationContext;

	@Autowired
	private TimeController controller;

	@MockBean
    private TimeService timeServiceMock;

    Time time;
    @Before
    public void setUpProduct() throws Exception{
    	time = new Time();
    	time.setId(1);
    	time.setNome("TESTE");
    }

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
	

	@Test
	public void timeControler() throws Exception {
		assertThat(controller).isNotNull();
	}

    @Test
    public void testList() throws Exception {
        assertThat(this.timeServiceMock).isNotNull();
        mockMvc.perform(MockMvcRequestBuilders.get("/times/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("times"))
                .andExpect(MockMvcResultMatchers.view().name("times"))
                .andExpect(content().string(Matchers.containsString("times")))
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
