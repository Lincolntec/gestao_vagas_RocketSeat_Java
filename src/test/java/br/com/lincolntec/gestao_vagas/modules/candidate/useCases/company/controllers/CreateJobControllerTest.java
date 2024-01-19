package br.com.lincolntec.gestao_vagas.modules.candidate.useCases.company.controllers;


import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class CreateJobControllerTest {

    private MockMvc mvc;

    private WebApplicationContext context;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    @Test
    public void shoud_be_able_to_create_a_new_job() {

    }
}
