package Model;

public class Motorista {
    private String cpf;
    private String nome;
    private int idade;
    private double diaria;

    public Motorista(String cpf, String nome, int idade, double diaria) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.diaria = diaria;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getValorDiaria() {
        return diaria;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setValorDiaria(double diaria) {
        this.diaria = diaria;
    }

    @Override
    public String toString() {
        return "Motorista{" +
               "cpf='" + cpf + '\'' +
               ", nome='" + nome + '\'' +
               ", idade=" + idade +
               ", diaria=" + diaria +
               '}';
    }
}
