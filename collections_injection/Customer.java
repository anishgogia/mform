package collections_injection;
import java.util.*;

public class Customer {
    private List<String> names = new Vector<String>();
    private Set<Long> Phno;
    private Map<Long, String>aadharNo;
    private Map<Long, Address> address;
    private Properties email;
 
    @Override
    public String toString() {
        return "Customer{" +
                "names=" + names +
                ", Phno=" + Phno +
                ", aadharNo=" + aadharNo +
                ", address=" + address +
                ", email=" + email +
                '}';
    }
 
 
 
    public List<String> getNames() {
        return names;
    }
 
    public void setNames(List<String> names) {
        this.names = names;
    }
 
    public Set<Long> getPhno() {
        return Phno;
    }
 
    public void setPhno(Set<Long> phno) {
        Phno = phno;
    }
 
    public Map<Long, String> getAadharNo() {
        return aadharNo;
    }
 
    public void setAadharNo(Map<Long, String> aadharNo) {
        this.aadharNo = aadharNo;
    }
 
    public Map<Long, Address> getAddress() {
        return address;
    }
 
    public void setAddress(Map<Long, Address> address) {
        this.address = address;
    }
 
    public Properties getEmail() {
        return email;
    }
 
    public void setEmail(Properties email) {
        this.email = email;
    }
}


