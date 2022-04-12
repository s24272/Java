package lab5.zad2;

import java.util.Arrays;

public class Bakery extends Shop{
    public Bakery(String adres, int size) {
        super(adres, size);
    }
    private String[] products = {"ciabata", "bułka", "chleb"};

    @Override
    public void getInformation() {
        System.out.printf(adres, size, products);
    }

    @Override
    public String toString() {
        return "Bakery{" +
                "products=" + Arrays.toString(products) +
                ", adres='" + adres + '\'' +
                ", size=" + size +
                '}';
    }
}
