package com.doyle.challenge.restful;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import com.doyle.challenge.restful.controller.EmployeeAPI;
import com.doyle.challenge.restful.employee.Request;
import org.springframework.boot.web.server.LocalServerPort;
import static io.restassured.RestAssured.given;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	
	@Mock
	private EmployeeAPI empRepo;

	private MockMvc mockMvc;

	@Autowired
    WebApplicationContext applicationContext;
	
	@Autowired
    ObjectMapper objectMapper;
	
	@Test
	public void contextLoads() {
	}

	@Before
    public void setup() {
		/*
		 * String token = given() .contentType(ContentType.JSON)
		 * .body(Request.builder().username("jwtCodeChallenge").password("password").
		 * build()) .when().post("/auth/signin")
		 * .andReturn().jsonPath().getString("token"); System.out.println("Got token:" +
		 * token);
		 */
	        
        this.mockMvc = webAppContextSetup(this.applicationContext)
            .apply(springSecurity())
            .build();
    }

	@Test
    public void getAllEmployees() throws Exception {
		
		this.mockMvc
        .perform(
            get("/employees")
                .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().is4xxClientError());
		
    }
	
	@Test
    public void getEmployeesById() throws Exception {
		
		this.mockMvc
        .perform(
            get("/employees/1")
                .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().is4xxClientError());
		
    }


	/*
	 * @Test public void testUpdateEmployee() throws Exception { Employee emp = new
	 * Employee(); emp.setId((long) 1); emp.setFullName("Wilson Doyle");
	 * 
	 * ObjectMapper mapper = new ObjectMapper(); String jsonString =
	 * mapper.writeValueAsString(emp); Mockito.when(((OngoingStubbing)
	 * empRepo.retrieveEmployees((Mockito.anyLong()))).thenReturn(emp));
	 * Mockito.doNothing().when(empRepo).updateEmployees(Mockito.any(Employee.class)
	 * , 1); mockMvc.perform(
	 * MockMvcRequestBuilders.put("/employees/1").content(jsonString).contentType(
	 * MediaType.APPLICATION_JSON))
	 * .andExpect(MockMvcResultMatchers.status().is(401)); }
	 */
}
