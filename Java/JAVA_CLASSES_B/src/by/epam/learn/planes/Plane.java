package by.epam.learn.planes;

import java.util.Objects;

public abstract class Plane {

    private String manufacturer;
    private String model;
    private int flightRange;
    private int fuelConsumption;

    Plane(String manufacturer, String model, int flightRange, int fuelConsumption) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.flightRange = flightRange;
        this.fuelConsumption = fuelConsumption;
    }

    public abstract int getCapacity();

    public abstract int getLoadCapacity();

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(int flightRange) {
        this.flightRange = flightRange;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", flightRange=" + flightRange +
                ", fuelConsumption=" + fuelConsumption +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return flightRange == plane.flightRange &&
                fuelConsumption == plane.fuelConsumption &&
                manufacturer.equals(plane.manufacturer) &&
                model.equals(plane.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, model, flightRange, fuelConsumption);
    }
}
