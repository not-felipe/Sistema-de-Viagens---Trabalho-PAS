package Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Viagem {
    private Onibus onibus;
    private Motorista motorista;
    private Rota rota;
    private Calendar dataInicio;
    private Map<Integer, Passageiro> lugaresOcupados;

    public Viagem(Onibus onibus, Motorista motorista, Rota rota, Calendar dataInicio) {
        this.onibus = onibus;
        this.motorista = motorista;
        this.rota = rota;
        this.dataInicio = dataInicio;
        this.lugaresOcupados = new HashMap<>();
    }

    public void reservarLugar(int lugar, Passageiro passageiro) {
        if (lugar <= 0 || lugar > onibus.getNumeroDeLugares()) {
            throw new IllegalArgumentException("Lugar inválido.");
        }
        if (lugaresOcupados.containsKey(lugar)) {
            throw new IllegalStateException("Lugar já reservado.");
        }
        lugaresOcupados.put(lugar, passageiro);
    }

    public double calcularPrecoViagem() {
        return onibus.getCusto() + motorista.getValorDiaria() + rota.getCustoTotal();
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return "Viagem{" +
                "Onibus='" + onibus.getPlaca() + " (" + onibus.getClasse() + ")'" +
                ", Motorista='" + motorista.getNome() + " (CPF: " + motorista.getCpf() + ")'" +
                ", Rota='De " + rota.getOrigem() + " para " + rota.getDestino() + "'" +
                ", Data de Inicio=" + sdf.format(dataInicio.getTime()) +
                ", Preco Total=R$ " + String.format("%.2f", calcularPrecoViagem()) +
                '}';
    }
}
