package com.verizon.TISP;

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

import com.verizon.tisp.model.Customer;
import com.verizon.tisp.model.Services;
import com.verizon.tisp.restapi.CustomerApi;
import com.verizon.tisp.restapi.TestUtil;
import com.verizon.tisp.service.CustomerServiceImpl;
import com.verizon.tisp.service.ServiceImpl;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CustomerApi.class)
public class CustomerAPI {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private CustomerServiceImpl cService;

	@MockBean
	private ServiceImpl sService;

	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() {
		mockMvc = null;
	}

	@Test
	public void testGetServices() throws Exception {
		assertThat(this.sService).isNotNull();

		List<Services> empList = new ArrayList<>();
		empList.add(new Services());

		when(sService.getAllServices()).thenReturn(empList);

		mockMvc.perform(get("/customers")).andExpect(status().isOk()).andDo(print());

	}

	@Test
	public void testGetCustomerById() throws Exception {
		assertThat(this.cService).isNotNull();
		int cId = 13;
	

		Customer cAdded = new Customer();
		
		cAdded.setcId(13);
		cAdded.setDateOfRequest((LocalDate.of(2018, 10, 17)));
		cAdded.setAddress("Ranchi Jharkhand");
		cAdded.setMobileNumber("7631145875");
		cAdded.setName("Aditya");
		cAdded.setsPlan("LL250");
		cAdded.settSlot("9AM to 11Am");
		
		
		when(cService.getCustomerById(cId)).thenReturn(cAdded);

		mockMvc.perform(get("/customers/13")).andExpect(status().isOk()).andDo(print());

	}
	@Test
	public void testAddCustomer() throws Exception {
		assertThat(this.cService).isNotNull();

		Customer emp = new Customer();

		emp.setDateOfRequest(null);
		emp.setAddress("Ranchi Jharkhand");
		emp.setMobileNumber("7631145875");
		emp.setName("Aditya");
		emp.setsPlan("LL250");
		emp.settSlot("9AM to 11Am");

		Customer cAdded = new Customer();
		cAdded.setcId(14);
		cAdded.setDateOfRequest(null);
		cAdded.setAddress("Ranchi Jharkhand");
		cAdded.setMobileNumber("7631145875");
		cAdded.setName("Aditya");
		cAdded.setsPlan("LL250");
		cAdded.settSlot("9AM to 11Am");


		System.out.println(emp);

		when(cService.addCustomer(Mockito.any(Customer.class))).thenReturn(cAdded);

		mockMvc.perform(post("/customers").contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(emp))).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8));

	}

	

}