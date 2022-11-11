package com.masai.service;

import java.util.List;

import com.masai.exceptions.CabException;
import com.masai.model.Cab;
import com.masai.model.CabType;

public interface CabService {

    public Cab registerCab(Cab cab) throws CabException;
	
	public Cab updateCab(int cabId, Cab cab) throws CabException;
	
	public Cab deleteCab(int cabId) throws CabException;
	
	public List<Cab> viewCabsOfType(CabType CabType) throws CabException;
	
	public Integer countCabsOfType(CabType cabType) throws CabException;
}
