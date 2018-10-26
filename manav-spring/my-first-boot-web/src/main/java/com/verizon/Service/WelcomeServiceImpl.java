package com.verizon.Service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class WelcomeServiceImpl implements WelcomeService {

	@Override
	public String getWelcomeStatement(String userName) {
		int hour=LocalDateTime.now().getHour();
		String greet="";
		
		if(hour >=3 && hour <=11)
			greet="Good Morning";
		else if(hour>=12 && hour <=16)
			greet="Good Noon";
		else
			greet="Good Evening";
		
		return greet+userName+" welcome Aboard!!";
	}

}
