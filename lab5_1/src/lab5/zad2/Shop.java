package lab5.zad2;

public class Shop {
    protected String adres;
    protected int size;

    public Shop(String adres, int size) {
        this.adres = adres;
        this.size = size;
    }

    public void getInformation(){
        System.out.printf(adres, size);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "adres='" + adres + '\'' +
                ", size=" + size +
                '}';
    }
}
