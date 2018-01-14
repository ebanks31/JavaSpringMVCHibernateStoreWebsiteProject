package com.ebanks.springapp.integrationTests;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ebanks.springapp.model.User;

/**
 * This class holds the integration test for Spring MVC Store project. These
 * tests are similar to the unit test except that they connect to an actual
 * database that is determined by a configuration properties file.
 *
 * @author Eric
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:servlet-context.xml")
public class ITUserControllerTest {
	final static Logger logger = Logger.getLogger(ITUserControllerTest.class);

	private static final String DBSCRIPT = "localDBScriptInsert.sql";

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Value("${jdbc.driverClassName}")
	private String jdbcClassName;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;

	@Value("${jdbc.url}")
	private String jdbcURL;

	@Before
	public void setup() throws SQLException {
		MockitoAnnotations.initMocks(this);
		Connection connection = null;

		try {
			// this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
			ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
			resourceDatabasePopulator.addScript(new ClassPathResource("sql/" + DBSCRIPT));

			DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
			/*
			 * driverManagerDatasource.setDriverClassName(JDBC_DRIVER_CLASS_NAME);
			 * driverManagerDatasource.setUrl(JDBC_URL);
			 * driverManagerDatasource.setUsername(JDBC_USERNAME);
			 * driverManagerDatasource.setPassword(JDBC_PASSWORD);
			 */
			driverManagerDataSource.setDriverClassName(jdbcClassName);
			driverManagerDataSource.setUrl(jdbcURL);
			driverManagerDataSource.setUsername(username);
			driverManagerDataSource.setPassword(password);
			logger.info("jdbcURL " + jdbcURL);

			connection = driverManagerDataSource.getConnection();
			resourceDatabasePopulator.populate(connection);
		} catch (Exception ex) {
			throw new RuntimeException("Could not initialize script: " + DBSCRIPT);
		} finally {
			if (connection != null) {
				connection.close();
			}
		}

		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testListUsers() throws Exception {
		this.mockMvc.perform(get("/users").accept(MediaType.TEXT_PLAIN))
				.andExpect(MockMvcResultMatchers.view().name("user"))
				.andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/user.jsp")).andExpect(status().isOk())
				.andExpect(content().string("")).andExpect(model().attribute("listUsers", hasSize(3)))
				.andExpect(model().attribute("listUsers",
						hasItem(allOf(hasProperty("id", is(21)), hasProperty("firstName", is("Eroc")),
								hasProperty("lastName", is("Banks")), hasProperty("age", is(17))))))
				.andExpect(model().attribute("todos",
						hasItem(allOf(hasProperty("id", is(2)), hasProperty("firstName", is("Fred")),
								hasProperty("lastName", is("Taylor")), hasProperty("age", is(24))))));
	}

	@Test
	public void testListUsersByLastNameASC() throws Exception {
		User first = new User();
		first.setId(1);
		first.setFirstName("Eroc");
		first.setLastName("Banks");
		first.setAge(17);

		User second = new User();
		first.setId(2);
		first.setFirstName("Fred");
		first.setLastName("Taylor");
		first.setAge(24);

		this.mockMvc.perform(get("/users").accept(MediaType.TEXT_PLAIN))
				.andExpect(MockMvcResultMatchers.view().name("user"))
				.andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/user.jsp")).andExpect(status().isOk())
				.andExpect(content().string("")).andExpect(model().attribute("user", hasSize(2)))
				.andExpect(model().attribute("user",
						hasItem(allOf(hasProperty("id", is(1)), hasProperty("firstName", is("Eroc")),
								hasProperty("lastName", is("Banks")), hasProperty("age", is(17))))))
				.andExpect(model().attribute("todos",
						hasItem(allOf(hasProperty("id", is(2)), hasProperty("firstName", is("Fred")),
								hasProperty("lastName", is("Taylor")), hasProperty("age", is(24))))));

	}

	@Test
	public void testAddUser() throws Exception {
		User first = new User();
		first.setId(1);
		first.setFirstName("Eroc");
		first.setLastName("Banks");
		first.setAge(17);

		this.mockMvc.perform(post("/user/add").accept(MediaType.TEXT_PLAIN))
				.andExpect(MockMvcResultMatchers.view().name("redirect:/users"))
				.andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/user.jsp")).andExpect(status().isOk())
				.andExpect(content().string("")).andExpect(model().attribute("user", hasSize(2)))
				.andExpect(model().attribute("user",
						hasItem(allOf(hasProperty("id", is(1)), hasProperty("firstName", is("Eroc")),
								hasProperty("lastName", is("Banks")), hasProperty("age", is(17))))));

	}

	@Test
	public void testRemoveUser() throws Exception {
		User first = new User();
		first.setId(1);
		first.setFirstName("Eroc");
		first.setLastName("Banks");
		first.setAge(17);

		User second = new User();
		first.setId(2);
		first.setFirstName("Fred");
		first.setLastName("Taylor");
		first.setAge(24);

		int id = 1;
		String stringID = String.valueOf(id);

		this.mockMvc.perform(get("/remove" + stringID).accept(MediaType.TEXT_PLAIN))
				.andExpect(MockMvcResultMatchers.view().name("redirect:/users"))
				.andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/user.jsp")).andExpect(status().isOk());

	}

	@Test
	public void testEditUser() throws Exception {
		User first = new User();
		first.setId(1);
		first.setFirstName("Eroc");
		first.setLastName("Banks");
		first.setAge(17);

		User second = new User();
		first.setId(2);
		first.setFirstName("Fred");
		first.setLastName("Taylor");
		first.setAge(24);

		String stringId = "1";

		this.mockMvc.perform(get("/edit" + stringId).accept(MediaType.TEXT_PLAIN))
				.andExpect(MockMvcResultMatchers.view().name("user"))
				.andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/user.jsp")).andExpect(status().isOk())
				.andExpect(content().string("")).andExpect(model().attribute("user", hasSize(2)))
				.andExpect(model().attribute("user",
						hasItem(allOf(hasProperty("id", is(1)), hasProperty("firstName", is("Eroc")),
								hasProperty("lastName", is("Banks")), hasProperty("age", is(17))))));

	}

	@Test
	public void notFoundURLPath() throws Exception {
		this.mockMvc.perform(get("/notfound").accept(MediaType.TEXT_PLAIN)).andExpect(status().is4xxClientError());
	}

	@Test
	public void foundURLPath() throws Exception {
		this.mockMvc.perform(get("/users").accept(MediaType.TEXT_PLAIN)).andExpect(status().isOk())
				.andExpect(content().string(""));
	}

	@Test
	public void foundURLPathValidWithUserObjects() throws Exception {

		User first = new User();
		first.setId(1);
		first.setFirstName("Eroc");
		first.setLastName("Banks");
		first.setAge(17);

		User second = new User();
		first.setId(2);
		first.setFirstName("Fred");
		first.setLastName("Taylor");
		first.setAge(24);

		this.mockMvc.perform(get("/users").accept(MediaType.TEXT_PLAIN))
				.andExpect(MockMvcResultMatchers.view().name("user"))
				.andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/user.jsp")).andExpect(status().isOk())
				.andExpect(content().string("")).andExpect(model().attribute("user", hasSize(2)))
				.andExpect(model().attribute("user",
						hasItem(allOf(hasProperty("id", is(1)), hasProperty("firstName", is("Eroc")),
								hasProperty("lastName", is("Banks")), hasProperty("age", is(17))))))
				.andExpect(model().attribute("user",
						hasItem(allOf(hasProperty("id", is(2)), hasProperty("firstName", is("Fred")),
								hasProperty("lastName", is("Taylor")), hasProperty("age", is(24))))));

	}

	@Test
	public void testListUsersByDistinctAddressModel() throws Exception {
		User first = new User();
		first.setId(1);
		first.setFirstName("Eroc");
		first.setLastName("Banks");
		first.setAge(17);
		first.setAddress("234 Hello Dr.");

		User second = new User();
		first.setId(2);
		first.setFirstName("Fred");
		first.setLastName("Taylor");
		first.setAge(24);
		first.setAddress("234 Hello Dr.");

		User third = new User();
		first.setId(3);
		first.setFirstName("Ryan");
		first.setLastName("Matthews");
		first.setAge(22);
		first.setAddress("235 Hello Dr.");

		this.mockMvc.perform(get("/users").accept(MediaType.TEXT_PLAIN))
				.andExpect(MockMvcResultMatchers.view().name("user"))
				.andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/user.jsp")).andExpect(status().isOk())
				.andExpect(content().string("")).andExpect(model().attribute("user", hasSize(2)))
				.andExpect(model().attribute("user",
						hasItem(allOf(hasProperty("id", is(1)), hasProperty("firstName", is("Eroc")),
								hasProperty("lastName", is("Banks")), hasProperty("age", is(17))))))
				.andExpect(model().attribute("user",
						hasItem(allOf(hasProperty("id", is(2)), hasProperty("firstName", is("Fred")),
								hasProperty("lastName", is("Taylor")), hasProperty("age", is(24))))));

	}

	@Test
	public void testListUsersBySpecificAddress() throws Exception {
		User first = new User();
		first.setId(1);
		first.setFirstName("Eroc");
		first.setLastName("Banks");
		first.setAge(17);
		first.setAddress("234 Hello Dr.");

		User second = new User();
		first.setId(2);
		first.setFirstName("Fred");
		first.setLastName("Taylor");
		first.setAge(24);
		first.setAddress("234 Hello Dr.");

		User third = new User();
		first.setId(2);
		first.setFirstName("Ryan");
		first.setLastName("Matthews");
		first.setAge(22);
		first.setAddress("235 Hello Dr.");

		String address = "234 Hello Dr.";

		this.mockMvc.perform(get("/users" + address).accept(MediaType.TEXT_PLAIN))
				.andExpect(MockMvcResultMatchers.view().name("user"))
				.andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/user.jsp")).andExpect(status().isOk())
				.andExpect(content().string("")).andExpect(model().attribute("user", hasSize(2)))
				.andExpect(model().attribute("user",
						hasItem(allOf(hasProperty("id", is(1)), hasProperty("firstName", is("Eroc")),
								hasProperty("lastName", is("Banks")), hasProperty("age", is(17))))))
				.andExpect(model().attribute("user",
						hasItem(allOf(hasProperty("id", is(2)), hasProperty("firstName", is("Fred")),
								hasProperty("lastName", is("Taylor")), hasProperty("age", is(24))))));

	}
}
