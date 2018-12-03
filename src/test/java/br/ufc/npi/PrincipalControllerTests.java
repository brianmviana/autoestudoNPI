package br.ufc.npi;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.ufc.npi.controller.PrincipalController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrincipalControllerTests {

    @Autowired
    private PrincipalController controller;

    @Test
    public void principalControler() throws Exception {
        assertThat(controller).isNotNull();
    }
}