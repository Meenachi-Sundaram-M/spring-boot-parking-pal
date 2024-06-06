package com.augusta.springboot.Parking.control.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.augusta.springboot.Parking.control.entity.VehicleTable;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class VehicleDAOImpl implements VehicleDAO {

	private EntityManager entitymanager;

	@Autowired
	public VehicleDAOImpl(EntityManager theEntityManager) {
		entitymanager = theEntityManager;
	}

	@Override
	public List<VehicleTable> getVehicleInfo() {

		// Get Vehicle Info From the Database
		TypedQuery<VehicleTable> theQuery = entitymanager.createQuery("from VehicleTable", VehicleTable.class);
		List<VehicleTable> theVehicleDb = theQuery.getResultList();
		return theVehicleDb;
	}

	@Override
	public VehicleTable save(VehicleTable theVehicletable) {
		// Save the Vehicle Info to the Database
		VehicleTable toVehicleDb = entitymanager.merge(theVehicletable);
		return toVehicleDb;
	}

	@Override
	public VehicleTable findById(int vehicleId) {
		// Find Vehicle Info By Using Id
		VehicleTable getVehicleInfo = entitymanager.find(VehicleTable.class, vehicleId);
		return getVehicleInfo;
	}

}
