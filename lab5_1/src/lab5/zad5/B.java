package lab5.zad5;

public class B extends A{
    A a = new A();
    protected void present(String phrase){
        a.present(phrase);
    }
}
