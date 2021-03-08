package Framework;
public class Consumer {
	 Producer Producer;
	    public Consumer(Producer Producer){
	        this.Producer = Producer;
	    }
	    public void takeDellivery(){
	        this.Producer.first();
	    }
}
