package com.augusta.springboot.Parking.control.dao;

import java.util.List;

import com.augusta.springboot.Parking.control.entity.VehicleTable;

public interface VehicleDAO {

	List<VehicleTable> getVehicleInfo();
	
	VehicleTable save(VehicleTable theVehicletable);
	
	VehicleTable findById(int vehicleId);
}
