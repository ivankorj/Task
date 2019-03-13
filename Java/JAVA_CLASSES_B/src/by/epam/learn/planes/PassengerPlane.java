package by.epam.learn.planes;

import java.util.Objects;

import by.epam.learn.type.TypeOfPassengerPlane;

public class PassengerPlane extends Plane {

    private int capacity;
    private TypeOfPassengerPlane typeOfPassengerPlane;

    public PassengerPlane(String manufacturer, String model, int flightRange, int fuelConsumption, int capacity, TypeOfPassengerPlane typeOfPassengerPlane) {
        super(manufacturer, model, flightRange, fuelConsumption);
        this.capacity = capacity;
        this.typeOfPassengerPlane = typeOfPassengerPlane;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int getLoadCapacity() {
        return 0;
    }

    public TypeOfPassengerPlane getTypeOfPassengerPlane() {
        return typeOfPassengerPlane;
    }

    public void setTypeOfPassengerPlane(TypeOfPassengerPlane typeOfPassengerPlane) {
        this.typeOfPassengerPlane = typeOfPassengerPlane;
    }

    @Override
    public String toString() {
        return "PassengerPlane{" +
                "capacity=" + capacity +
                ", typeOfPassengerPlane=" + typeOfPassengerPlane +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerPlane that = (PassengerPlane) o;
        return capacity == that.capacity &&
                typeOfPassengerPlane == that.typeOfPassengerPlane;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity, typeOfPassengerPlane);
    }
}
