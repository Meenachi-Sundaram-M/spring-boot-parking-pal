package com.augusta.springboot.Parking.control.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="slot_info_bike")
public class BikeSlotTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Slotid")
	private int slotId;
	
	@Column(name="Slotno")
	private String slotNo;
	
	@Column(name="Vehicleid")
	private Integer vehicleKey;
	
	@Column(name="Isoccupied")
	private boolean isOccupied;
	
	public BikeSlotTable() {
		
	}

	public BikeSlotTable(String slotNo, Integer vehicleKey, boolean isOccupied) {
		super();
		this.slotNo = slotNo;
		this.vehicleKey = vehicleKey;
		this.isOccupied = isOccupied;
	}

	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public String getSlotNo() {
		return slotNo;
	}

	public void setSlotNo(String slotNo) {
		this.slotNo = slotNo;
	}

	public Integer getVehicleKey() {
		return vehicleKey;
	}

	public void setVehicleKey(Integer vehicleKey) {
		this.vehicleKey = vehicleKey;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	@Override
	public String toString() {
		return "SlotTable [slotId=" + slotId + ", slotNo=" + slotNo + ", vehicleKey=" + vehicleKey + ", isOccupied="
				+ isOccupied + "]";
	}
}
