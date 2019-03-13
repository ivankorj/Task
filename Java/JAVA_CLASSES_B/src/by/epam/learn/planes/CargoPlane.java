package by.epam.learn.planes;

import java.util.Objects;

import by.epam.learn.type.TypeOfCargoPlane;

public class CargoPlane extends Plane {

    private int loadCapacity;
    private TypeOfCargoPlane typeOfCargoPlane;

    public CargoPlane(String manufacturer, String model, int flightRange, int fuelConsumption, int loadCapacity, TypeOfCargoPlane typeOfCargoPlane) {
        super(manufacturer, model, flightRange, fuelConsumption);
        this.loadCapacity = loadCapacity;
        this.typeOfCargoPlane = typeOfCargoPlane;
    }

    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public TypeOfCargoPlane getTypeOfCargoPlane() {
        return typeOfCargoPlane;
    }

    public void setTypeOfCargoPlane(TypeOfCargoPlane typeOfCargoPlane) {
        this.typeOfCargoPlane = typeOfCargoPlane;
    }

    @Override
    public String toString() {
        return "CargoPlane{" +
                "loadCapacity=" + loadCapacity +
                ", typeOfCargoPlane=" + typeOfCargoPlane +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CargoPlane that = (CargoPlane) o;
        return loadCapacity == that.loadCapacity &&
                typeOfCargoPlane == that.typeOfCargoPlane;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), loadCapacity, typeOfCargoPlane);
    }
}
