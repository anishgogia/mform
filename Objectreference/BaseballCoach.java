package Objectreference;

public class BaseballCoach implements ICoach {
    private IFortune ifortune;
    private String name;
    private String email;
    private String teamName;
    private Address address;
 
 
    public BaseballCoach(IFortune ifortune, String name, String email, String teamName, Address address) {
        this.ifortune = ifortune;
        this.name = name;
        this.email = email;
        this.teamName = teamName;
        this.address = address;
    }
 
    public BaseballCoach() {
 
    }
 
    @Override
    public String toString() {
        return "BaseballCoach{" +
                "ifortune=" + ifortune.getFortune() +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", teamName='" + teamName + '\'' +
                ", address=" + address.toString() +
                '}';
    }
 
    @Override
    public String getFortune() {
        return ifortune.getFortune();
    }
 
    @Override
    public String getDailyWorkout() {
        return "Practice Daily";
    }
 
 
    public IFortune getIfortune() {
        return ifortune;
    }
 
    public void setIfortune(IFortune ifortune) {
        this.ifortune = ifortune;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getTeamName() {
        return teamName;
    }
 
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
 
    public Address getAddress() {
        return address;
    }
 
    public void setAddress(Address address) {
        this.address = address;
    }
 
 
}

