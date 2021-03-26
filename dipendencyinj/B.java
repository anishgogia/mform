package dipendencyinj;

public class B {
	private C cClass;
	 
	 
    public B() {
        System.out.println("Calling B Constructor");
    }
 
    public C getcClass() {
        return cClass;
    }
 
    public void setcClass(C cClass) {
        this.cClass = cClass;
    }


}
