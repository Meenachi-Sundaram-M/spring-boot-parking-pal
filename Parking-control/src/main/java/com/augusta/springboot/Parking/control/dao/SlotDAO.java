package com.augusta.springboot.Parking.control.dao;

import java.util.List;

import com.augusta.springboot.Parking.control.entity.SlotTable;

public interface SlotDAO {

	List<SlotTable> getSlotInfo();

	SlotTable update(SlotTable theSlotTable);

	SlotTable findAvailableSlot();
	
	List<SlotTable> SlotDashboard();
	
	SlotTable findSlotId(int theId);
}
