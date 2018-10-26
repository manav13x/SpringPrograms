package com.verizon.tisp.service;

import java.util.List;

import com.verizon.tisp.model.Services;

public interface ServicesI {

	List<Services> getAllServices();
	List<Services> findAllByCharges(Double  charges);
	List<Services> findAllByNetSpeed(Double netspeed);
	List<Services> findAllByMaxUsage(Double  maxusage);
}
