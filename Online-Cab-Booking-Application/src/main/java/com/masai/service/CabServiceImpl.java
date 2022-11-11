package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CabException;
import com.masai.model.Cab;
import com.masai.model.CabType;
import com.masai.repository.CabDao;

@Service
public class CabServiceImpl implements CabService{

	@Autowired
	private CabDao cabDao;

	
	@Override
	public Cab registerCab(Cab cab) throws CabException {
		
		CabType type = cab.getCabtype();
		
		cab.setPerKmRate(type.getPrice());
		cab.setSittingCapacity(type.sittingCapacity());
		
		return cabDao.save(cab);
		
		
	}

	@Override
	public Cab updateCab(int cabId, Cab cab) throws CabException {
		
		Cab cab1 = cabDao.findById(cabId).orElseThrow(() -> new CabException("Cab with Id: "+ cabId + "does not exist"));

		return cabDao.save(cab);
		
	}

	@Override
	public Cab deleteCab(int cabId) throws CabException {
		
		Cab cab = cabDao.findById(cabId).orElseThrow(() -> new CabException("Cab with Id: "+ cabId + "does not exist"));
		cabDao.delete(cab);
		return cab;
		
	}

	@Override
	public List<Cab> viewCabsOfType(CabType CabType) throws CabException {
		
		return cabDao.findAllByCabtype(CabType);
	}

	@Override
	public Integer countCabsOfType(CabType cabType) throws CabException {
		
		return cabDao.findAllByCabtype(cabType).size();
	}
	
	

}
