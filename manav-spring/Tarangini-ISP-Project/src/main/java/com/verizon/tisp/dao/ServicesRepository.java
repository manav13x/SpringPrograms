package com.verizon.tisp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.tisp.model.Services;

@Repository
public interface ServicesRepository extends JpaRepository<Services, String> {

	List<Services> findAllByCharges(Double  charges);
	List<Services> findAllByNetSpeed(Double netSpeed);
	List<Services> findAllByMaxUsage(Double  maxUsage);
}
