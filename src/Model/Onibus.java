package Model;

public class Onibus {
    private String placa;
    private int numeroDeLugares;
    private String classe;
    private double custo;

    public Onibus(String placa, int numeroDeLugares, String classe, double custo) {
        this.placa = placa;
        this.numeroDeLugares = numeroDeLugares;
        this.classe = classe;
        this.custo = custo;
    }

    public String getPlaca() {
        return placa;
    }

    public int getNumeroDeLugares() {
        return numeroDeLugares;
    }

    public String getClasse() {
        return classe;
    }

    public double getCusto() {
        return custo;
    }
}
