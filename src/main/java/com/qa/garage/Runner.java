package com.qa.garage;

import java.util.Scanner;

import com.qa.garage.vehicle.Bike;
import com.qa.garage.vehicle.Boat;
import com.qa.garage.vehicle.Car;

public class Runner {

	public static void main(String[] args) {
		Garage g = new Garage();

		g.addVehicle(new Car(4, "Black"));
		g.addVehicle(new Boat(0, "Blue"));
		g.addVehicle(new Bike(2, "Red"));
		g.addVehicle(new Car(3, "red"));

		System.out.println(g);

//		g.removeByType("car");
//		g.remove(Car.class);
		System.out.println(g);

		try (Scanner scan = new Scanner(System.in)) {
			String input = null;

			do {
				System.out.print("Enter an id or q to quit: ");
				input = scan.nextLine();
				if (input.equals("q"))
					break;
				try {
					System.out.println(g.find(Integer.parseInt(input)));
				} catch (NumberFormatException nfe) {
					System.out.println("NAN");
				} catch (VehicleNotFoundException vnfe) {
					System.out.println(vnfe.getMessage());
				}
			} while (true);

			System.out.println("So long!");
		}
	}

}
