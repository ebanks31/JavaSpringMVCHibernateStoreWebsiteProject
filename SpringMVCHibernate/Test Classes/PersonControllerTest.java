package com.ebanks.springapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
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
    
    @Mock
    Person mockPerson;
    
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

when(personService.listPersons()).thenReturn(Arrays.asList(first, second));

		this.mockMvc
			.perform(get("/persons").accept(MediaType.TEXT_PLAIN))
			.andExpect(MockMvcResultMatchers.view().name("person"))
         .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/person.jsp"))
			.andExpect(status().isOk())
			.andExpect(content().string(""))
		    .andExpect(model().attribute("person", hasSize(2)))
         .andExpect(model().attribute("person", hasItem(
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
		
		verify(personService, times(1)).listPersons();
     verifyNoMoreInteractions(personService);
	}

	@Test
	public void testListPersonsByLastNameASC() throws Exception {
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
		    .andExpect(model().attribute("person", hasSize(2)))
         .andExpect(model().attribute("person", hasItem(
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
	public void testAddPerson() throws Exception {
	       Person first = new Person();
	       first.setId(1);
     first.setFirstName("Eroc");
     first.setLastName("Banks");
     first.setAge(17);
     
     Person test = Mockito.mock(Person.class);
     
     when(test.getId()).thenReturn(0);

		this.mockMvc
			.perform(post("/person/add").accept(MediaType.TEXT_PLAIN))
			.andExpect(MockMvcResultMatchers.view().name("redirect:/persons"))
      .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/person.jsp"))
			.andExpect(status().isOk())
			.andExpect(content().string(""))
		    .andExpect(model().attribute("person", hasSize(2)))
      .andExpect(model().attribute("person", hasItem(
                  allOf(
                          hasProperty("id", is(1)),
                          hasProperty("firstName", is("Eroc")),
                          hasProperty("lastName", is("Banks")),
                          hasProperty("age", is(17))
                  )
          )));
		
		verify(personService, times(1)).addPerson(first);
  verifyNoMoreInteractions(personService);
	}

	@Test
	public void testRemovePerson() throws Exception {
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


		int id = 1;
		String stringID = String.valueOf(id);
		
		
		this.mockMvc
			.perform(get("/remove" +stringID).accept(MediaType.TEXT_PLAIN))
			.andExpect(MockMvcResultMatchers.view().name("redirect:/persons"))
   .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/person.jsp"))
			.andExpect(status().isOk());
		
verifyNoMoreInteractions(personService); 
	}

	@Test
	public void testEditPerson() throws Exception {
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

when(personService.listPersons()).thenReturn(Arrays.asList(first, second));

		int id = 1;
		String stringID = String.valueOf(id);
		when(personService.getPersonById(id)).thenReturn(first);
		
		
		this.mockMvc
			.perform(get("/edit" +stringID).accept(MediaType.TEXT_PLAIN))
			.andExpect(MockMvcResultMatchers.view().name("person"))
      .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/person.jsp"))
			.andExpect(status().isOk())
			.andExpect(content().string(""))
		    .andExpect(model().attribute("person", hasSize(2)))
      .andExpect(model().attribute("person", hasItem(
                  allOf(
                          hasProperty("id", is(1)),
                          hasProperty("firstName", is("Eroc")),
                          hasProperty("lastName", is("Banks")),
                          hasProperty("age", is(17))
                  )
          )));
		
		verify(personService, times(1)).listPersons();
  verifyNoMoreInteractions(personService); 
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
	public void foundURLPathValidWithPersonObjects() throws Exception {
		
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
		    .andExpect(model().attribute("person", hasSize(2)))
            .andExpect(model().attribute("person", hasItem(
                        allOf(
                                hasProperty("id", is(1)),
                                hasProperty("firstName", is("Eroc")),
                                hasProperty("lastName", is("Banks")),
                                hasProperty("age", is(17))
                        )
                )))
                .andExpect(model().attribute("person", hasItem(
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


	@Test
	public void testListPersonsByDistinctAddressModel() throws Exception {
	       Person first = new Person();
	       first.setId(1);
     first.setFirstName("Eroc");
     first.setLastName("Banks");
     first.setAge(17);
     first.setAddress("234 Hello Dr.");
     
	       Person second = new Person();
	       first.setId(2);
     first.setFirstName("Fred");
     first.setLastName("Taylor");
     first.setAge(24);
     first.setAddress("234 Hello Dr.");
     
	       Person third = new Person();
	       first.setId(3);
  first.setFirstName("Ryan");
  first.setLastName("Matthews");
  first.setAge(22);
  first.setAddress("235 Hello Dr.");

when(personService.getAllDistinctAddress()).thenReturn(Arrays.asList(first, second));

		this.mockMvc
			.perform(get("/persons").accept(MediaType.TEXT_PLAIN))
			.andExpect(MockMvcResultMatchers.view().name("person"))
         .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/person.jsp"))
			.andExpect(status().isOk())
			.andExpect(content().string(""))
		    .andExpect(model().attribute("person", hasSize(2)))
         .andExpect(model().attribute("person", hasItem(
                     allOf(
                             hasProperty("id", is(1)),
                             hasProperty("firstName", is("Eroc")),
                             hasProperty("lastName", is("Banks")),
                             hasProperty("age", is(17))
                     )
             )))
             .andExpect(model().attribute("person", hasItem(
                     allOf(
                             hasProperty("id", is(2)),
                             hasProperty("firstName", is("Fred")),
                             hasProperty("lastName", is("Taylor")),
                             hasProperty("age", is(24))
                     )
             )));
		
		verify(personService, times(1)).getAllDistinctAddress();
     verifyNoMoreInteractions(personService);
	}


	@Test
	public void testListPersonsBySpecificAddress() throws Exception {
	       Person first = new Person();
	       first.setId(1);
        first.setFirstName("Eroc");
        first.setLastName("Banks");
        first.setAge(17);
        first.setAddress("234 Hello Dr.");
        
	       Person second = new Person();
	       first.setId(2);
        first.setFirstName("Fred");
        first.setLastName("Taylor");
        first.setAge(24);
        first.setAddress("234 Hello Dr.");
        
	       Person third = new Person();
	       first.setId(2);
     first.setFirstName("Ryan");
     first.setLastName("Matthews");
     first.setAge(22);
     first.setAddress("235 Hello Dr.");
     
     String address = "234 Hello Dr.";
     
when(personService.personsBySpecificAddress(address)).thenReturn(Arrays.asList(first, second));

		this.mockMvc
			.perform(get("/persons"+address).accept(MediaType.TEXT_PLAIN))
			.andExpect(MockMvcResultMatchers.view().name("person"))
         .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/person.jsp"))
			.andExpect(status().isOk())
			.andExpect(content().string(""))
		    .andExpect(model().attribute("person", hasSize(2)))
         .andExpect(model().attribute("person", hasItem(
                     allOf(
                             hasProperty("id", is(1)),
                             hasProperty("firstName", is("Eroc")),
                             hasProperty("lastName", is("Banks")),
                             hasProperty("age", is(17))
                     )
             )))
             .andExpect(model().attribute("person", hasItem(
                     allOf(
                             hasProperty("id", is(2)),
                             hasProperty("firstName", is("Fred")),
                             hasProperty("lastName", is("Taylor")),
                             hasProperty("age", is(24))
                     )c
             )));
		
		verify(personService, times(1)).personsBySpecificAddress(address);
     verifyNoMoreInteractions(personService);
	}
	

}
