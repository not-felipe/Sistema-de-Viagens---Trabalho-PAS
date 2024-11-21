package Model;

public class Passageiro extends Pessoa {
    private String email;

    public Passageiro(String nome, String cpf, String email) {
        super(nome, cpf);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
