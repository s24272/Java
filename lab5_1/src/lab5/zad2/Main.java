package lab5.zad2;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop("nowa", 56);
        Bakery bakery = new Bakery("mazowiecka", 20);
        Bookshop bookshop = new Bookshop("3 maja", 112);


        System.out.println(bookshop);
        System.out.println(bakery);
        System.out.println(shop);

    }
}
