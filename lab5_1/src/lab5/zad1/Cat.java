package lab5.zad1;

public class Cat extends animal{
    public Cat(String name, String color) {
        super(name, color);
    }

    public void makeSound(){
        System.out.printf("[%s:%s] Miau Miau\n", name, color);
    }
}
