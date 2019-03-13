package by.epam.learn.airline;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import by.epam.learn.planes.Plane;
import by.epam.learn.planes.CargoPlane;
import by.epam.learn.planes.PassengerPlane;

public class Airline {


    private String title;
    private List<? extends Plane> planes;

    public Airline(String title, List<? extends Plane> planes) {
        this.title = title;
        this.planes = planes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<? extends Plane> planes) {
        this.planes = planes;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "title='" + title + '\'' +
                ", planes=" + planes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return title.equals(airline.title) &&
                planes.equals(airline.planes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, planes);
    }

    private void displayList(List<Plane> plan) {
        for (Plane p : plan) {
            System.out.print(p.getManufacturer() + " " + p.getModel() + ", flight range(km): " + p.getFlightRange() + ", fuel consumption(kg/h): " + p.getFuelConsumption());
            if (p instanceof PassengerPlane) {
                System.out.print(", capacity(kg): " + p.getCapacity() + "\n");
            }
            if (p instanceof CargoPlane) {
                System.out.print(", load capacity(kg): " + p.getLoadCapacity() + "\n");
            }
        }
    }


    //рассчитать общую грузоподъемность пассажиров
    public void calculateTotalCapacityAndPayload() {
        int totalCapacity = 0;
        int totalLoadCapacity = 0;
        for (Plane plane : planes) {
            totalCapacity += plane.getCapacity();
            totalLoadCapacity += plane.getLoadCapacity();
        }
        System.out.println("Total passenger capacity of the company: " + totalCapacity);
        System.out.println("The total capacity of the company " + totalLoadCapacity);
    }



    public void sortCompanyPlanesByRange(List<Plane> plan) {
        planes.sort(Comparator.comparingInt(Plane::getFlightRange));
        displayList(plan);
    }


    //фильтровать самолеты по расходу топлива
    public void findAircraftFuelConsumption(int min, int max) {
        ArrayList<Plane> resultList = new ArrayList<>();
        for (Plane plane : planes) {
            if ((plane.getFuelConsumption() >= min) && (plane.getFuelConsumption() <= max)) {
                resultList.add(plane);
            }
        }
        if (resultList.size() == 0) {
            System.out.println("The company has no aircraft required fuel consumption parameters.");
        }
        displayList(resultList);
    }
}
