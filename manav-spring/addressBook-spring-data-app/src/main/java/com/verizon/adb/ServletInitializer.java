package com.verizon.adb;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@EnableWebMvc
public class ServletInitializer extends SpringBootServletInitializer {
//web mvc is used for servelet pages jsp to work
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AddressBookSpringDataAppApplication.class);
	}

}
