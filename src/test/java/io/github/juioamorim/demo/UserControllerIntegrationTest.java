package io.github.juioamorim.demo;

import java.nio.charset.Charset;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

	@MockBean
	private UserRepository userRepository;

	@Autowired
	UserController userController;

	@Autowired

	private MockMvc mockMvc;

	@Test
	public void whenPostRequestToUsersAndValidUser_thenCorrectResponse() throws Exception {
		MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
		String user = "{\"userName\": \"Júlio Amorim\", \"userEmail\" : \"julio.l.amorim@github.com\"}";

		mockMvc.perform(
				MockMvcRequestBuilders.post("/users").content(user).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(textPlainUtf8));
	}

	@Test
	public void whenPostRequestToUsersAndInValidUser_thenCorrectResponse() throws Exception {

		String user = "{\"userName\": \"\", \"userEmail\" : \"julio.l.amorim@github.com\"}";
		mockMvc.perform(
				MockMvcRequestBuilders.post("/users").content(user).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(MockMvcResultMatchers.jsonPath("$.userName", Is.is("Username is required")));
	}

}