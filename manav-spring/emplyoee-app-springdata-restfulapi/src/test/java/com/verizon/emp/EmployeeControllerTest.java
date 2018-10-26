package com.verizon.emp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import com.verizon.emp.service.EmplyoeeServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers=EmplyoeeApi.class)
public class EmployeeControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webapplicationcontext;
	
	@MockBean
	private EmplyoeeServiceImpl empServiceWork;
	
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webapplicationcontext).build();
	}


	@Test
	public void testListEmployees() throws Exception{
		assertThat(this.empServiceWork).isNotNull();
		List<Emplyoee> elistPage = new ArrayList<>();
		elistPage.add(new Emplyoee());
		when(empServiceWork.getAllEmplyoees()).thenReturn(elistPage);
		
		mockMvc.perform(get("/emplyoeeList"))
		.andExpect(status().isOk())
		.andExpect(view().name("elistPage"))
		.andExpect(model().attributeExists("emplyoees"))
		.andExpect(model().attribute("emplyoees",elistPage))
		.andDo(print());
	}
	@Test
	public void testAddEmployees() throws Exception{
		assertThat(this.empServiceWork).isNotNull();
		
		//Emplyoee emp = new Emplyoee();
		//when(new Emplyoee()).thenReturn(emp);
		
		mockMvc.perform(get("/addEmplyoee"))
		.andExpect(status().isOk())
		.andExpect(view().name("addEmplyoeePage"))
		.andExpect(model().attributeExists("emplyoee"))
		//.andExpect(model().attribute("emplyoee",new Emplyoee()))
		.andExpect(model().attributeExists("genders"))
		.andExpect(model().attribute("genders",Gender.values()))
		.andExpect(model().attributeExists("possibDept"))
		.andExpect(model().attribute("possibDept",new String[] { "It", "Cloud", "Support", "Testing" }))
		.andDo(print());
		
		Emplyoee emp = new Emplyoee();
		emp.setBasic(22000);
		emp.setDateOfBirth(java.time.LocalDate.now());
		emp.setDept("Cloud");
		emp.setEmailId("manavkumar@gm.com");
		emp.setEmpId(23);
		emp.setFirstName("Aman");
		emp.setLastName("Kumar");
		emp.setGender(Gender.GENT);
		emp.setHra(23);
		emp.setMobileNumber("12554785");

		mockMvc.perform(post("/addEmplyoee",emp))
		//.andExpect(status().isOk())
		.andExpect(view().name("redirect:/emplyoeeList"))
		.andExpect(model().attributeExists("emplyoee"))
		//.andExpect(model().attribute("emplyoee",emp))
		.andExpect(model().attributeExists("genders"))
		.andExpect(model().attribute("genders",Gender.values()))
		.andExpect(model().attributeExists("possibDept"))
		.andExpect(model().attribute("possibDept",new String[] { "It", "Cloud", "Support", "Testing" }))
		.andDo(print());
	}
	
	@Test
	public void testEditEmployees() throws Exception{
		assertThat(this.empServiceWork).isNotNull();
		
		long id=15;
		Emplyoee ee = empServiceWork.getEmplyoeeById(id);
		when(empServiceWork.getEmplyoeeById(id)).thenReturn(ee);
		
		mockMvc.perform(get("/editEmp?empId=15"))
		.andExpect(status().isOk())
		.andExpect(view().name("addEmplyoeePage"))
		//.andExpect(model().attributeExists("emplyoee"))
		.andExpect(model().attribute("emplyoee",ee))
		.andExpect(model().attributeExists("genders"))
		.andExpect(model().attribute("genders",Gender.values()))
		.andExpect(model().attributeExists("possibDept"))
		.andExpect(model().attribute("possibDept",new String[] { "It", "Cloud", "Support", "Testing" }))
		.andDo(print());
	}
		

	@Test
	public void testDeleteEmployees() throws Exception{
		assertThat(this.empServiceWork).isNotNull();
		
		Emplyoee emp = new Emplyoee();
		emp.setBasic(22000);
		emp.setDateOfBirth(java.time.LocalDate.now());
		emp.setDept("Cloud");
		emp.setEmailId("manavkumar@gm.com");
		emp.setEmpId(23);
		emp.setFirstName("Aman");
		emp.setLastName("Kumar");
		emp.setGender(Gender.GENT);
		emp.setHra(23);
		emp.setMobileNumber("12554785");
		
		empServiceWork.addEmplyoee(emp);
		//when(empServiceWork.getEmplyoeeById(emp.getEmpId())).thenReturn(emp);
		
		mockMvc.perform(get("//deleteEmp?empId=23"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void handleDoSearchEmplyoee() throws Exception{
		assertThat(this.empServiceWork).isNotNull();
		
		Emplyoee elistPage = empServiceWork.findByMobileNumber("3336698569");
		List<Emplyoee> emp = empServiceWork.findAllByLastName("Acharya");

		when(empServiceWork.findByMobileNumber("3336698569")).thenReturn(elistPage);
		when(empServiceWork.findByEmailId("kumar.manav@gmaul.com")).thenReturn(elistPage);
		
		when(empServiceWork.findAllByLastName("Acharya")).thenReturn(emp);
		when(empServiceWork.findAllByDept("Support")).thenReturn(emp);
		
		
		mockMvc.perform(get("/searchEmplyoee"))
		.andExpect(status().isOk())
		.andExpect(view().name("searchPage"))
		.andDo(print());
		
		
		mockMvc.perform(post("/searchEmplyoee").param("srhValue", "3336698569").param("field", "mobile"))
		.andExpect(status().isOk())
		.andExpect(view().name("searchPage"))
		.andExpect(model().attribute("result",elistPage))
		.andDo(print());
				
		mockMvc.perform(post("/searchEmplyoee").param("srhValue", "kumar.manav@gmaul.com").param("field", "email"))
		.andExpect(status().isOk())
		.andExpect(view().name("searchPage"))
		.andExpect(model().attribute("result",elistPage))
		.andDo(print());
	
		mockMvc.perform(post("/searchEmplyoee?").param("srhValue", "Acharya").param("field", "lnm"))
		.andExpect(status().isOk())
		.andExpect(view().name("searchPage"))
		.andExpect(model().attribute("results",emp))
		.andDo(print());

		mockMvc.perform(post("/searchEmplyoee?").param("srhValue", "Support").param("field", "dp"))
		.andExpect(status().isOk())
		.andExpect(view().name("searchPage"))
		.andExpect(model().attribute("results",emp))
		.andDo(print());
		
		

	}
}
