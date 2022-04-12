package lab5.zad1;

public class main {
    public static void main(String[] args) {
        Cat cat = new Cat("filemon", "czarnobiały");
        Dog dog = new Dog("Burek", "beżowy");
        dog.makeSound();
        cat.makeSound();
    }
}
