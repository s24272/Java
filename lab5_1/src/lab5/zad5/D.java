package lab5.zad5;

public class D extends C{
    C c = new C();
    protected void present(String phrase){
        c.present(phrase);
    }
}
