package com.augusta.springboot.Parking.control.service;

import java.util.List;

import com.augusta.springboot.Parking.control.entity.BikeSlotTable;
import com.augusta.springboot.Parking.control.entity.SlotTable;
import com.augusta.springboot.Parking.control.entity.VehicleTable;

public interface ParkingServiceLayer {

	List<SlotTable> getSlotInfo();

	SlotTable update(SlotTable theSlotTable);

	SlotTable findAvailableSlot();
	
	SlotTable findSlotId(int theId);
	
	List<VehicleTable> getVehicleInfo();

	VehicleTable save(VehicleTable theVehicletable);

	VehicleTable findById(int vehicleId);
	
	List<BikeSlotTable> getBikeSlotInfo();

	BikeSlotTable update(BikeSlotTable theSlotTable);

	BikeSlotTable findAvailableSlot1();
	
	BikeSlotTable findSlotId1(int theId);
	
	List<SlotTable> SlotDashboard();
	
	List<BikeSlotTable> BikeSlotDashboard();
}
