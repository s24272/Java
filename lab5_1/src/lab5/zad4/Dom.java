package lab5.zad4;

public class Dom {
    private double powierzchniaDomu;
    private int iloscPieter;
    private String ulica;
    private double powierzchniaOgrodu;
    private boolean czyZamieszkany;

    public Dom(double powierzchniaDomu, int iloscPieter, String ulica,
               double powierzchniaOgrodu, boolean czyZamieszkany) {
        this.powierzchniaDomu = powierzchniaDomu;
        this.iloscPieter = iloscPieter;
        this.ulica = ulica;
        this.powierzchniaOgrodu = powierzchniaOgrodu;
        this.czyZamieszkany = czyZamieszkany;
    }

    @Override
    public String toString() {
        return "Dom{" +
                "powierzchniaDomu=" + powierzchniaDomu +
                ", iloscPieter=" + iloscPieter +
                ", ulica='" + ulica + '\'' +
                ", powierzchniaOgrodu=" + powierzchniaOgrodu +
                ", czyZamieszkany=" + czyZamieszkany +
                '}';
    }
}
