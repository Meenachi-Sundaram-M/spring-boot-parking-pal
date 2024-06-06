package com.augusta.springboot.Parking.control.dao;

import java.util.List;

import com.augusta.springboot.Parking.control.entity.BikeSlotTable;

public interface BikeSlotDAO {

	List<BikeSlotTable> getSlotInfo();

	BikeSlotTable update(BikeSlotTable theSlotTable);

	BikeSlotTable findAvailableSlot();
	
	BikeSlotTable findById(int theId);
	
	List<BikeSlotTable> BikeSlotDashboard();
}
