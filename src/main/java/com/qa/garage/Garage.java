package com.qa.garage;

import java.util.ArrayList;
import java.util.List;

import com.qa.garage.vehicle.Boat;
import com.qa.garage.vehicle.Car;
import com.qa.garage.vehicle.Plane;
import com.qa.garage.vehicle.Vehicle;

public class Garage {

	private List<Vehicle> vehicles = new ArrayList<>();

	public boolean addVehicle(Vehicle v) {
		return this.vehicles.add(v);
	}

	public boolean empty() {
		this.vehicles.clear();
		return this.vehicles.size() == 0;
	}

	public int calcBillInstance() {
		int bill = 0;
		for (Vehicle v : this.vehicles) {
			if (v instanceof Car)
				bill += 10;
			else if (v instanceof Boat)
				bill += 15;
			else if (v instanceof Plane)
				bill += 23;
		}
		return bill;
	}

	public int calcBill() {
		int bill = 0;
		for (Vehicle v : this.vehicles)
			bill += v.calcBill();
		return bill;
	}

	public Vehicle find(int id) throws VehicleNotFoundException {
		for (Vehicle v : this.vehicles) {
			if (v.getId() == id)
				return v;
		}
		throw new VehicleNotFoundException("No vehicle found with id: " + id);
	}

	public boolean remove(int id) {
		for (Vehicle v : this.vehicles) {
			if (v.getId() == id) {
				this.vehicles.remove(v);
				return true;
			}
		}
		return false;
	}

	// name -> com.qa.vehicles.Car
	// simple name -> Car
	public boolean remove(String type) {
		List<Vehicle> toRemove = new ArrayList<>();
		for (Vehicle v : this.vehicles) {
			if (v.getClass().getSimpleName().equalsIgnoreCase(type))
				toRemove.add(v);
		}
		return this.vehicles.removeAll(toRemove);
	}

	public boolean remove(Class clazz) {
		List<Vehicle> toRemove = new ArrayList<>();
		for (Vehicle v : this.vehicles) {
			if (v.getClass() == clazz)
				toRemove.add(v);
		}
		return this.vehicles.removeAll(toRemove);
	}

	@Override
	public String toString() {
		return "Garage [vehicles=" + this.vehicles + "]";
	}

}
