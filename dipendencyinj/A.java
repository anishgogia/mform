package dipendencyinj;
public class A {
    private B bClass;
 
 
    public A() {
        System.out.println("Calling A constructor");
    }
 
 
    public B getbClass() {
        return bClass;
    }
 
    public void setbClass(B bClass) {
        this.bClass = bClass;
    }
 
 
 
}

