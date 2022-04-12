package lab5.zad5;

public class C extends B{
    B b = new B();
    protected void present(String phrase){
        b.present(phrase);
    }
}
