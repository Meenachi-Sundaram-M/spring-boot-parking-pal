package com.augusta.springboot.Parking.control.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.augusta.springboot.Parking.control.entity.SlotTable;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class SlotDAOImpl implements SlotDAO {

	private EntityManager entitymanger;

	@Autowired
	public SlotDAOImpl(EntityManager theEntitymanager) {
		entitymanger = theEntitymanager;
	}

	@Override
	public List<SlotTable> getSlotInfo() {
		// get Slot Info from database
		TypedQuery<SlotTable> theQuery = entitymanger.createQuery("from SlotTable", SlotTable.class);
		List<SlotTable> theSlotDb = theQuery.getResultList();
		return theSlotDb;
	}

	@Override
	public SlotTable update(SlotTable theSlotTable) {
		// Update the required Column
		SlotTable updateSlot = entitymanger.merge(theSlotTable);
		return updateSlot;
	}

	@Override
	public SlotTable findAvailableSlot() {
		// find the available Slot
		TypedQuery<SlotTable> findSlot = entitymanger.createQuery("from SlotTable where isOccupied=false",
				SlotTable.class);
		List<SlotTable> thedata = findSlot.getResultList();
		return thedata.get(0);
	}

	@Override
	public SlotTable findSlotId(int theId) {
		// TODO Auto-generated method stub
		SlotTable findSlot = entitymanger.find(SlotTable.class, theId);
		return findSlot;
	}

	@Override
	public List<SlotTable> SlotDashboard() {
		
		TypedQuery<SlotTable> findSlot=entitymanger.createQuery("from SlotTable where isOccupied=false",SlotTable.class);
		List<SlotTable> thedata=findSlot.getResultList();
		return thedata;
	}

}
