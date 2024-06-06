package com.augusta.springboot.Parking.control.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vehicle_info")
public class VehicleTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int vehicleId;
	
	@Column(name="Vehicletype")
	private String vehicleType;
	
	@Column(name="Vehicleno")
	private String vehicleNo;
	
	@Column(name="Drivername")
	private String driverName;
	
	@Column(name="Intime")
	private String inTime;
	
	@Column(name="Outtime")
	private String outTime;
	
	public VehicleTable() {
		
	}

	public VehicleTable(String vehicleType, String vehicleNo, String driverName, String inTime, String outTime) {
		super();
		this.vehicleType = vehicleType;
		this.vehicleNo = vehicleNo;
		this.driverName = driverName;
		this.inTime = inTime;
		this.outTime = outTime;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	@Override
	public String toString() {
		return "VehicleTable [vehicleId=" + vehicleId + ", vehicleType=" + vehicleType + ", vehicleNo=" + vehicleNo
				+ ", driverName=" + driverName + ", inTime=" + inTime + ", outTime=" + outTime + "]";
	}
	
}
