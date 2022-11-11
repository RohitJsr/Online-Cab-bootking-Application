package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Cab;
import com.masai.model.CabType;

@Repository
public interface CabDao extends JpaRepository<Cab, Integer> {

	public Cab findByNumberPlate(String number);
	
}
