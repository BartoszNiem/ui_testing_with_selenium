package Entities;

public class Travellers {
    private int numberOfRooms;
    private int numberOfAdults;
    private int numberOfChilds;

    public Travellers() {
    }

    public Travellers(int numberOfRooms, int numberOfAdults, int numberOfChilds) {
        this.numberOfRooms = numberOfRooms;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChilds = numberOfChilds;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public int getNumberOfChilds() {
        return numberOfChilds;
    }

    public void setNumberOfChilds(int numberOfChilds) {
        this.numberOfChilds = numberOfChilds;
    }
}
