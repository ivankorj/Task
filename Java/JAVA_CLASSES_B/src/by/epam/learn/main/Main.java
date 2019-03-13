package by.epam.learn.main;

import java.util.Arrays;
import java.util.List;

import by.epam.learn.airline.Airline;
import by.epam.learn.planes.Plane;
import by.epam.learn.planes.CargoPlane;
import by.epam.learn.planes.PassengerPlane;
import by.epam.learn.type.TypeOfCargoPlane;
import by.epam.learn.type.TypeOfPassengerPlane;

public class Main {

    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing", "747", 14000, 10200, 624, TypeOfPassengerPlane.WIDE_BODY_AIRCRAFT),
            new PassengerPlane("Airbus", "A380", 15400, 13000, 853, TypeOfPassengerPlane.WIDE_BODY_AIRCRAFT),
            new PassengerPlane("Ил", "96", 13000, 7800, 435, TypeOfPassengerPlane.WIDE_BODY_AIRCRAFT),
            new PassengerPlane("Boeing", "737", 5925, 2650, 189, TypeOfPassengerPlane.NARROW_BODY_AIRCRAFT),
            new PassengerPlane("Airbus", "A320", 5950, 2500, 220, TypeOfPassengerPlane.NARROW_BODY_AIRCRAFT),
            new PassengerPlane("Ту", "154", 6600, 5300, 176, TypeOfPassengerPlane.WIDE_BODY_AIRCRAFT),
            new PassengerPlane("Embraer", "E195", 3350, 1850, 124, TypeOfPassengerPlane.REGIONAL_AIRCRAFT),
            new PassengerPlane("Ан", "148", 4400, 1650, 80, TypeOfPassengerPlane.REGIONAL_AIRCRAFT),
            new PassengerPlane("Sukhoi", "Superjet 100", 4578, 1700, 98, TypeOfPassengerPlane.REGIONAL_AIRCRAFT),
            new PassengerPlane("Cessna", "210", 1668, 300, 6, TypeOfPassengerPlane.LOCAL_PLANE),
            new PassengerPlane("Beechcraft", "King Air", 2446, 1000, 12, TypeOfPassengerPlane.LOCAL_PLANE),
            new PassengerPlane("Ан", "2", 990, 131, 189, TypeOfPassengerPlane.LOCAL_PLANE),
            new CargoPlane("Ан", "124", 7500, 12500, 150000, TypeOfCargoPlane.HEAVY),
            new CargoPlane("Lockheed", "C-5 Galaxy", 4440, 10000, 118387, TypeOfCargoPlane.HEAVY),
            new CargoPlane("Ил", "76", 6500, 8262, 60000, TypeOfCargoPlane.HEAVY),
            new CargoPlane("Ан", "12", 5530, 1983, 21000, TypeOfCargoPlane.AVERAGE),
            new CargoPlane("Lockheed", "C-130 Hercules", 7000, 2500, 20000, TypeOfCargoPlane.AVERAGE),
            new CargoPlane("Ан", "14", 470, 200, 720, TypeOfCargoPlane.LIGHT)
    );

    public static void main(String[] args) {

        Airline airline = new Airline("Belavia", planes);
        System.out.println("Airline " + airline.getTitle() + " created");
        System.out.println();
        System.out.println("Company aircraft sorted by flight range:");
        airline.sortCompanyPlanesByRange(planes);
        System.out.println();
        System.out.println("The company's aircraft correspond to a given range of fuel consumption parameters:");
        airline.findAircraftFuelConsumption(6500, 7000);
        System.out.println();
        airline.calculateTotalCapacityAndPayload();
    }
}