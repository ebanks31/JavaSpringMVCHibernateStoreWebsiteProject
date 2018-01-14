package com.ebanks.springapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ebanks.springapp.controllers.UserController;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:servlet-context.xml" })
public class PersonControllerTest1 {

	private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

	@Test
	public void testSetPersonService() throws Exception {
		this.mockMvc.perform(get("/redirect/uriTemplate"))
		.andExpect(redirectedUrl("/redirect/a123?date=12%2F31%2F11"));
	}

	@Test
	public void testListPersons() throws Exception {
		this.mockMvc.perform(get("/personsASC"))
		.andExpect(content().string("person"));
	}

	@Test
	public void testListPersonsByLastNameASC() throws Exception {
		this.mockMvc.perform(get("/redirect/uriTemplate"))
		.andExpect(redirectedUrl("/redirect/a123?date=12%2F31%2F11"));
	}

	@Test
	public void testAddPerson() throws Exception {
		this.mockMvc.perform(get("/redirect/uriTemplate"))
		.andExpect(redirectedUrl("/redirect/a123?date=12%2F31%2F11"));
	}

	@Test
	public void testRemovePerson() throws Exception {
		this.mockMvc.perform(get("/redirect/uriTemplate"))
		.andExpect(redirectedUrl("/redirect/a123?date=12%2F31%2F11"));
	}

	@Test
	public void testEditPerson() throws Exception {
		this.mockMvc.perform(get("/redirect/uriTemplate"))
		.andExpect(redirectedUrl("/redirect/a123?date=12%2F31%2F11"));
	}

	@Test
	public void notFoundURLPath() throws Exception {
		standaloneSetup(new UserController()).build()
			.perform(get("/notfound").accept(MediaType.TEXT_PLAIN))
			.andExpect(status().is4xxClientError());
	}

	@Test
	public void foundURLPath() throws Exception {
		standaloneSetup(new UserController()).build()
			.perform(get("/persons").accept(MediaType.TEXT_PLAIN))
			.andExpect(status().isOk());
	}

}
