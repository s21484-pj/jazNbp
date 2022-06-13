package pl.pjatk.jazs21484nbp.model;

public class Root {

    private String data;
    private double cena;

    public Root() {
    }

    public Root(String data, double cena) {
        this.data = data;
        this.cena = cena;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
