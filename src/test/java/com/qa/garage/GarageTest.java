package com.qa.garage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.garage.vehicle.Boat;
import com.qa.garage.vehicle.Car;
import com.qa.garage.vehicle.Plane;

public class GarageTest {

	private Garage garage;

	private Car testCar;

	@BeforeEach
	void init() {
		this.testCar = new Car(4, "Black");
		garage = new Garage(this.testCar, new Boat(0, "White"));
	}

	@Test
	void testAddVehicle() {
		assertTrue(this.garage.addVehicle(new Plane(3, "Polka Dots")));
	}

//	@Test
//	void testFindSuccess() throws VehicleNotFoundException {
//		assertEquals(this.testCar, this.garage.find(this.testCar.getId()));
//	}

	@Test
	void testFindFails() {
		assertThrows(VehicleNotFoundException.class, () -> this.garage.find(-1));
	}

	@Test
	void testRemoveSuccess() {
		assertTrue(this.garage.remove(this.testCar.getId()));
	}

	@Test
	void testRemoveFail() {
		assertFalse(this.garage.remove(-1));
	}
}
