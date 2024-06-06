package com.augusta.springboot.Parking.control.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.augusta.springboot.Parking.control.entity.BikeSlotTable;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class BikeSlotDAOImpl implements BikeSlotDAO {
	private EntityManager entitymanger;

	@Autowired
	public BikeSlotDAOImpl(EntityManager theEntitymanager) {
		entitymanger = theEntitymanager;
	}

	@Override
	public List<BikeSlotTable> getSlotInfo() {
		// get Slot Info from database
		TypedQuery<BikeSlotTable> theQuery = entitymanger.createQuery("from BikeSlotTable", BikeSlotTable.class);
		List<BikeSlotTable> theSlotDb = theQuery.getResultList();
		return theSlotDb;
	}

	@Override
	public BikeSlotTable update(BikeSlotTable theBikeSlotTable) {
		// Update the required Column
		BikeSlotTable updateSlot = entitymanger.merge(theBikeSlotTable);
		return updateSlot;
	}

	@Override
	public BikeSlotTable findAvailableSlot() {
		// find the available Slot
		TypedQuery<BikeSlotTable> findSlot = entitymanger.createQuery("from BikeSlotTable where isOccupied=false",
				BikeSlotTable.class);
		List<BikeSlotTable> thedata = findSlot.getResultList();
		return thedata.get(0);
	}

	@Override
	public BikeSlotTable findById(int theId) {
		// TODO Auto-generated method stub
		BikeSlotTable theBikeSlot = entitymanger.find(BikeSlotTable.class, theId);
		return theBikeSlot;
	}

	@Override
	public List<BikeSlotTable> BikeSlotDashboard() {
		TypedQuery<BikeSlotTable> findSlot = entitymanger.createQuery("from BikeSlotTable where isOccupied=false",
				BikeSlotTable.class);
		List<BikeSlotTable> thedata = findSlot.getResultList();
		return thedata;

	}

}
