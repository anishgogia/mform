package Framework;
public class Main {
    public static void main(String[] args) {
    	Producer producer = Factory.getObject();
      //  Producer producer = new Nproducer();
        Consumer consumer = new Consumer(producer);
        consumer.takeDellivery();
    }
}
