package pers.junebao.observer_pattern.channel_subscription;

public class Client {
    public static void main(String[] args) {
        CCTV1 cctv1 = new CCTV1();
        Customer customer1 = new Customer();
        cctv1.addObserver(customer1);
        cctv1.release();
    }
}
