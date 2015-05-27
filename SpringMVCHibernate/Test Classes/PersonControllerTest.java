package com.ebanks.springapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ebanks.springapp.model.Person;
import com.ebanks.springapp.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath:servlet-context.xml" })
public class PersonControllerTest {
   
	@Autowired
    private WebApplicationContext wac;
	
    private MockMvc mockMvc;
    
    @Autowired
    private PersonService personService;
    
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

	
	@Test
	public void testSetPersonService() throws Exception {
		// TODO 
	}

	@Test
	public void testListPersons() throws Exception {
		// TODO 
	}

	@Test
	public void testListPersonsByLastNameASC() throws Exception {
		// TODO 
	}

	@Test
	public void testAddPerson() throws Exception {
		// TODO 
	}

	@Test
	public void testRemovePerson() throws Exception {
		// TODO 
	}

	@Test
	public void testEditPerson() throws Exception {
		// TODO 
	}
	
	@Test
	public void notFoundURLPath() throws Exception {
		this.mockMvc
			.perform(get("/notfound").accept(MediaType.TEXT_PLAIN))
			.andExpect(status().is4xxClientError());
	}
	
	@Test
	public void foundURLPath() throws Exception {
		this.mockMvc
			.perform(get("/persons").accept(MediaType.TEXT_PLAIN))
			.andExpect(status().isOk())
			.andExpect(content().string(""));
	}
	
	@Test
	public void foundURLPath1() throws Exception {
		
	       Person first = new Person();
	       first.setId(1);
           first.setFirstName("Eroc");
           first.setLastName("Banks");
           first.setAge(17);

	       Person second = new Person();
	       first.setId(2);
           first.setFirstName("Fred");
           first.setLastName("Taylor");
           first.setAge(24);

   when(personService.listPersonsOrderbyLastNameASC()).thenReturn(Arrays.asList(first, second));
   
		this.mockMvc
			.perform(get("/persons").accept(MediaType.TEXT_PLAIN))
			.andExpect(MockMvcResultMatchers.view().name("person"))
            .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/person.jsp"))
			.andExpect(status().isOk())
			.andExpect(content().string(""))
		    .andExpect(model().attribute("todos", hasSize(2)))
            .andExpect(model().attribute("todos", hasItem(
                        allOf(
                                hasProperty("id", is(1)),
                                hasProperty("firstName", is("Eroc")),
                                hasProperty("lastName", is("Banks")),
                                hasProperty("age", is(17))
                        )
                )))
                .andExpect(model().attribute("todos", hasItem(
                        allOf(
                                hasProperty("id", is(2)),
                                hasProperty("firstName", is("Fred")),
                                hasProperty("lastName", is("Taylor")),
                                hasProperty("age", is(24))
                        )
                )));
		
		verify(personService, times(1)).listPersonsOrderbyLastNameASC();
        verifyNoMoreInteractions(personService);
	}
	
	@Test
	public void simple() throws Exception {
		standaloneSetup(new PersonController()).build()
			.perform(get("/simple"))
			.andExpect(status().isOk())
			.andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
			.andExpect(content().string("Hello world!"));
	}
	

}
