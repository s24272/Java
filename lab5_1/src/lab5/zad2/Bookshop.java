package lab5.zad2;

import java.util.Arrays;

public class Bookshop extends Shop{
    public Bookshop(String adres, int size) {
        super(adres, size);
    }

    private String[] products = {"ksiazka1", "ksiazka2", "ksiazka3"};

    @Override
    public void getInformation() {
        System.out.printf(adres, size, products);
    }

    @Override
    public String toString() {
        return "Bookshop{" +
                "products=" + Arrays.toString(products) +
                ", adres='" + adres + '\'' +
                ", size=" + size +
                '}';
    }
}
