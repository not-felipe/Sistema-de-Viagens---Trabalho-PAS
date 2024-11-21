package Model;

public class Trecho {
    private String inicio;
    private String fim;
    private int duracaoHoras;
    private int duracaoMinutos;
    private double custo;

    public Trecho(String inicio, String fim, int duracaoHoras, int duracaoMinutos, double custo) {
        this.inicio = inicio;
        this.fim = fim;
        this.duracaoHoras = duracaoHoras;
        this.duracaoMinutos = duracaoMinutos;
        this.custo = custo;
    }

    public String getInicio() {
        return inicio;
    }

    public String getFim() {
        return fim;
    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public double getCusto() {
        return custo;
    }
}
