package semKloeverly.domain;

public class Resident {

    private int points;
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;


    public Resident(int points, String name,  String surname, String address, String phoneNumber) {
        this.points = points;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;

    }

    public int getPoints() {
        return points;
    }
    public void setPoints(int newPoints) {
        this.points = newPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
