package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.DriverException;
import com.masai.model.Admin;
import com.masai.model.Cab;
import com.masai.model.CurrentUserSession;
import com.masai.model.TripBooking;
import com.masai.repository.AdminDao;
import com.masai.repository.CabDao;
import com.masai.repository.SessionDao;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao aDao;

	@Autowired
	private SessionDao sDao;

	@Autowired
	private CabDao cabDao;

	public Admin createAdmin(Admin admin) throws AdminException {

		Admin existingAdmin = aDao.findByMobileNumber(admin.getMobileNumber());

		if (existingAdmin != null)
			throw new AdminException("Admin Already Registered with Mobile number");

		return aDao.save(admin);

	}

	@Override
	public Admin updateAdmin(Admin Admin, String key) throws AdminException {

		CurrentUserSession loggedInUser = sDao.findByUuid(key);

		if (loggedInUser == null) {
			throw new AdminException("Please provide a valid key to update a Admin");
		}

		if (Admin.getAdminId() == loggedInUser.getUserId()) {

			return aDao.save(Admin);
		} else
			throw new AdminException("Invalid Admin Details, please login first");

	}

	@Override
	public Admin deleteAdmin(Admin admin) throws AdminException {
		// TODO Auto-generated method stub

		Admin adminDetails = aDao.findByAdminId(admin.getAdminId());

		if (adminDetails != null) {

			aDao.delete(admin);
			return admin;

		} else {
			throw new AdminException("Admin not found with adminId :" + admin.getAdminId());
		}

	}

	@Override
	public List<TripBooking> getAllTripsByCab(Integer cabId) throws AdminException {
		Cab cab = cabDao.findById(cabId).get();
		if (cab == null)
			throw new AdminException("Cab Does not Exist");
		List<TripBooking> allTripsBycab = cab.getDriver().getTripBookingList();

		return allTripsBycab;

	}

}
