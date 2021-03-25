 package Objectreference;
public class Address {
     private String houseNumber;
    private String city;
    private String state;
    private int pincode;
 
    public Address(String houseNumber, String city, String state, int pincode) {
        this.houseNumber = houseNumber;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }
 
    @Override
    public String toString() {
        return "Address{" +
                "houseNumber='" + houseNumber + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode=" + pincode +
                '}';
    }
 
    public String getHouseNumber() {
        return houseNumber;
    }
 
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 
    public String getState() {
        return state;
    }
 
    public void setState(String state) {
        this.state = state;
    }
 
    public int getPincode() {
        return pincode;
    }
 
    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
}

