package com.verizon.emp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.verizon.emp.model.Emplyoee;
import com.verizon.emp.model.Gender;
import com.verizon.emp.restapi.EmplyoeeApi;
import com.verizon.emp.restapi.TestUtil;
import com.verizon.emp.service.EmplyoeeService;
import com.verizon.emp.service.EmplyoeeServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = EmplyoeeApi.class)
public class EmplyoeeApiTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private EmplyoeeServiceImpl empServiceMock;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() {
		mockMvc = null;
	}

	@Test
	public void testGetAllEmplyoees() throws Exception {
		assertThat(this.empServiceMock).isNotNull();

		List<Emplyoee> empList = new ArrayList<>();
		empList.add(new Emplyoee());

		when(empServiceMock.getAllEmplyoees()).thenReturn(empList);

		mockMvc.perform(get("/emplyoees")).andExpect(status().isOk()).andDo(print());

	}

	@Test
	public void testGetEmplyoeeById() throws Exception {
		assertThat(this.empServiceMock).isNotNull();
		int empId = 13;
	

		Emplyoee empAdded = new Emplyoee();

		empAdded.setEmpId(13);
		empAdded.setFirstName("Aditya");
		empAdded.setLastName("Raj");
		empAdded.setBasic(8977);
		empAdded.setHra(45);
		empAdded.setDateOfBirth((LocalDate.of(2018, 10, 17)));;
		empAdded.setDept("Cloud");

		when(empServiceMock.getEmplyoeeById(empId)).thenReturn(empAdded);

		mockMvc.perform(get("/emplyoees/13")).andExpect(status().isOk()).andDo(print());

	}
	/*

	@Test
	public void testGetAllEmplyoeess() throws Exception {
		assertThat(this.empServiceMock).isNotNull();

		List<Emplyoee> empList = new ArrayList<>();
		empList.add(new Emplyoee());

		when(empServiceMock.getAllEmplyoees()).thenReturn(empList);

		mockMvc.perform(get("/Emplyoees/empName/Aditya")).andExpect(status().isOk()).andDo(print());

	}
*/
	@Test
	public void testAddEmplyoee() throws Exception {
		assertThat(this.empServiceMock).isNotNull();

		Emplyoee emp = new Emplyoee();

		emp.setFirstName("Mahesh");
		emp.setLastName("Raj");
		emp.setBasic(8977);
		emp.setHra(45);
		emp.setDateOfBirth(null);
		emp.setDept("Testing");

		Emplyoee empAdded = new Emplyoee();
		empAdded.setEmpId(14);
		empAdded.setFirstName("MAhesh");
		empAdded.setLastName("Raj");
		empAdded.setBasic(8977);
		empAdded.setHra(45);
		empAdded.setDateOfBirth(null);
		empAdded.setDept("Testing");

		System.out.println(emp);

		when(empServiceMock.addEmplyoee(Mockito.any(Emplyoee.class))).thenReturn(empAdded);

		mockMvc.perform(post("/emplyoees").contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(emp))).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8));

	}

	@Test
	public void testUpdateEmplyoee() throws Exception {
		assertThat(this.empServiceMock).isNotNull();

		Emplyoee emp = new Emplyoee();
		emp.setEmpId(13);
		emp.setFirstName("Aditya");
		emp.setLastName("Raj");
		emp.setBasic(8977);
		emp.setHra(45);
		emp.setDateOfBirth(null);
		emp.setDept("Cloud");

		int empId = 13;
		

		Emplyoee empAdded = new Emplyoee();

		empAdded.setEmpId(13);
		empAdded.setFirstName("Aditya");
		empAdded.setLastName("Raj");
		empAdded.setBasic(8977);
		empAdded.setHra(45);
		empAdded.setDateOfBirth(LocalDate.of(2018, 10, 17));
		empAdded.setDept("Cloud");

		when(empServiceMock.getEmplyoeeById(empId)).thenReturn(empAdded);

		when(empServiceMock.updateEmplyoee(Mockito.any(Emplyoee.class))).thenReturn(emp);

		mockMvc.perform(put("/emplyoees").contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(emp))).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8));


	}

	@Test
	public void testDeleteEmplyoee() throws Exception {
		assertThat(this.empServiceMock).isNotNull();

		int empId = 10;

		when(empServiceMock.deleteEmplyoee(empId)).thenReturn(true);

		mockMvc.perform(delete("/emplyoees/10")).andExpect(status().isOk()).andDo(print());

	}

}