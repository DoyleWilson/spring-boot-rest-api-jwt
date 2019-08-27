package com.doyle.challenge.restful;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import com.doyle.challenge.restful.controller.EmployeeAPI;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	
	@Mock
	private EmployeeAPI empRepo;

	private MockMvc mockMvc;

	@Test
	public void contextLoads() {
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
