package by.epam.learn.port;

public class Port {

    private static int placeCount;
    private int maxNumOfContainersInPort;

    public Port(int placeCount, int maxNumOfContainersInPort) {
        Port.placeCount = placeCount;
        this.maxNumOfContainersInPort = maxNumOfContainersInPort;
    }

    public int getPlaceCount() {
        return placeCount;
    }

    public int getMaxNumOfContainersInPort() {
        return maxNumOfContainersInPort;
    }
}