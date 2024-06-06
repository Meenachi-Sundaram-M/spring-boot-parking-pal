package com.augusta.springboot.Parking.control.rest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.augusta.springboot.Parking.control.entity.BikeSlotTable;
import com.augusta.springboot.Parking.control.entity.SlotTable;
import com.augusta.springboot.Parking.control.entity.VehicleTable;
import com.augusta.springboot.Parking.control.service.ParkingServiceImpl;

@RestController
@RequestMapping("/api")
public class ParkingRestController {

	private ParkingServiceImpl parkingServiceLayer;

	public ParkingRestController(ParkingServiceImpl theParkingServiceImpl) {
		parkingServiceLayer = theParkingServiceImpl;
	}

	// User APIs

	@GetMapping("/get/dashboard")
	public ResponseEntity<String> dashboard() {
		List<SlotTable> theSlots = parkingServiceLayer.SlotDashboard();
		List<BikeSlotTable> theBikeSlots = parkingServiceLayer.BikeSlotDashboard();
		long availableNo = theSlots.stream().count();
		long availableNo1 = theBikeSlots.stream().count();
		return ResponseEntity.ok("Available Car Slots: " + availableNo + "\n" + "Availabe Bike Slots: " + availableNo1);
	}

	@PostMapping("/book/parking")
	public ResponseEntity<String> bookParkingTicket(@RequestBody VehicleTable theVehicleTable) {

		int tokenId = 0;

		String type = theVehicleTable.getVehicleType().toUpperCase();

		theVehicleTable.setInTime(
				new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis())));
		VehicleTable theVehicleDb = parkingServiceLayer.save(theVehicleTable);

		int Key = theVehicleDb.getVehicleId();

		if (type.equals("CAR")) {
			SlotTable theSlotDb = parkingServiceLayer.findAvailableSlot();
			theSlotDb.setVehicleKey(Key);
			theSlotDb.setOccupied(true);
			SlotTable bookSlot = parkingServiceLayer.update(theSlotDb);
			tokenId = bookSlot.getSlotId();

		} else if (type.equals("BIKE")) {
			BikeSlotTable theBikeSlotDb = parkingServiceLayer.findAvailableSlot1();
			theBikeSlotDb.setVehicleKey(Key);
			theBikeSlotDb.setOccupied(true);
			BikeSlotTable bookSlot = parkingServiceLayer.update(theBikeSlotDb);
			tokenId = bookSlot.getSlotId();
		} else {
			return ResponseEntity.ok("No available Slots");
		}

		return ResponseEntity.ok("Ticket is Booked: " + tokenId);

	}

	@PutMapping("car/unpark/{token}")
	public ResponseEntity<String> unparkVehicle(@PathVariable int token) {

		SlotTable theSlotDB = parkingServiceLayer.findSlotId(token);

		if (theSlotDB != null) {
			int vKey = theSlotDB.getVehicleKey();
			VehicleTable theVehicleDB = parkingServiceLayer.findById(vKey);
			if (vKey != 0) {
				theVehicleDB.setOutTime(
						new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis())));
			} else {
				return ResponseEntity.ok("Please pass the Valid Token");
			}
			theSlotDB.setVehicleKey(null);
			theSlotDB.setOccupied(false);
			parkingServiceLayer.update(theSlotDB);
			return ResponseEntity.ok("Vehicle is Succefully Unparked!");
		}

		else {
			return ResponseEntity.notFound().build();
		}

	}

	@PutMapping("bike/unpark/{token}")
	public ResponseEntity<String> unparkBike(@PathVariable int token) {

		BikeSlotTable theSlotDB = parkingServiceLayer.findSlotId1(token);

		if (theSlotDB != null) {
			int vKey = theSlotDB.getVehicleKey();
			VehicleTable theVehicleDB = parkingServiceLayer.findById(vKey);
			if (vKey != 0) {
				theVehicleDB.setOutTime(
						new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis())));
			} else {
				return ResponseEntity.ok("Please pass the Valid Token");
			}
			theSlotDB.setVehicleKey(null);
			theSlotDB.setOccupied(false);
			parkingServiceLayer.update(theSlotDB);
			return ResponseEntity.ok("Vehicle is Succefully Unparked!");
		}

		else {
			return ResponseEntity.notFound().build();
		}

	}

	// Admin APIs
	@GetMapping("/slot/{theId}")
	public SlotTable getSlot(@PathVariable Integer theId) {
		SlotTable theSlotDB = parkingServiceLayer.findSlotId(theId);
		if (theSlotDB == null) {
			throw new RuntimeException("Slot Id not Found--" + theId);
		} else
			return theSlotDB;

	}

	@GetMapping("/vehicleinfo")
	public List<VehicleTable> getVehicleInfo() {

		List<VehicleTable> theVehicles = parkingServiceLayer.getVehicleInfo();
		return theVehicles;
	}

	@GetMapping("/slotinfo")
	public List<SlotTable> getSlotInfo() {

		List<SlotTable> theSlots = parkingServiceLayer.getSlotInfo();
		return theSlots;
	}

	@GetMapping("/bikeslotinfo")
	public List<BikeSlotTable> getBikeInfo() {

		List<BikeSlotTable> theBikeSlots = parkingServiceLayer.getBikeSlotInfo();
		return theBikeSlots;
	}
}
