package com.augusta.springboot.Parking.control.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.augusta.springboot.Parking.control.dao.BikeSlotDAOImpl;
import com.augusta.springboot.Parking.control.dao.SlotDAOImpl;
import com.augusta.springboot.Parking.control.dao.VehicleDAOImpl;
import com.augusta.springboot.Parking.control.entity.BikeSlotTable;
import com.augusta.springboot.Parking.control.entity.SlotTable;
import com.augusta.springboot.Parking.control.entity.VehicleTable;

import jakarta.transaction.Transactional;

@Service
public class ParkingServiceImpl implements ParkingServiceLayer {

	private SlotDAOImpl slotDAOImpl;
	private VehicleDAOImpl vehicleDAOImpl;
	private BikeSlotDAOImpl bikeSlotDAOImpl;

	@Autowired
	public ParkingServiceImpl(SlotDAOImpl theSlotDAOImpl, VehicleDAOImpl theVehicleDAOImpl,
			BikeSlotDAOImpl theBikeSlotDAOImpl) {
		slotDAOImpl = theSlotDAOImpl;
		bikeSlotDAOImpl = theBikeSlotDAOImpl;
		vehicleDAOImpl = theVehicleDAOImpl;
	}

	@Override
	public List<SlotTable> getSlotInfo() {
		// TODO Auto-generated method stub
		return slotDAOImpl.getSlotInfo();
	}

	@Transactional
	@Override
	public SlotTable update(SlotTable theSlotTable) {
		// TODO Auto-generated method stub
		return slotDAOImpl.update(theSlotTable);
	}

	@Override
	public SlotTable findAvailableSlot() {
		// TODO Auto-generated method stub
		return slotDAOImpl.findAvailableSlot();
	}
	
	@Override
	public SlotTable findSlotId(int theId) {
		// TODO Auto-generated method stub
		return slotDAOImpl.findSlotId(theId);
	}

	@Override
	public List<VehicleTable> getVehicleInfo() {
		// TODO Auto-generated method stub
		return vehicleDAOImpl.getVehicleInfo();
	}

	@Transactional
	@Override
	public VehicleTable save(VehicleTable theVehicletable) {
		// TODO Auto-generated method stub
		return vehicleDAOImpl.save(theVehicletable);
	}

	@Override
	public VehicleTable findById(int vehicleId) {
		// TODO Auto-generated method stub
		return vehicleDAOImpl.findById(vehicleId);
	}

	@Override
	public List<BikeSlotTable> getBikeSlotInfo() {
		// TODO Auto-generated method stub
		return bikeSlotDAOImpl.getSlotInfo();
	}

	@Transactional
	@Override
	public BikeSlotTable update(BikeSlotTable theBikeSlotTable) {
		// TODO Auto-generated method stub
		return bikeSlotDAOImpl.update(theBikeSlotTable);
	}

	@Override
	public BikeSlotTable findAvailableSlot1() {
		// TODO Auto-generated method stub
		return bikeSlotDAOImpl.findAvailableSlot();
	}

	@Override
	public BikeSlotTable findSlotId1(int theId) {
		// TODO Auto-generated method stub
		return bikeSlotDAOImpl.findById(theId);
	}

	@Override
	public List<SlotTable> SlotDashboard() {
		// TODO Auto-generated method stub
		return slotDAOImpl.SlotDashboard();
	}

	@Override
	public List<BikeSlotTable> BikeSlotDashboard() {
		// TODO Auto-generated method stub
		return bikeSlotDAOImpl.BikeSlotDashboard();
	}

}
