package Model;

import java.util.List;
import Model.Exceptions.RotaNotFoundException;

public class Rota {
    private String origem;
    private String destino;
    private List<Trecho> trechos;

    public Rota(String origem, String destino, List<Trecho> trechos) throws RotaNotFoundException {
        this.origem = origem;
        this.destino = destino;
        this.trechos = trechos;
        validarRota();
    }

    public void validarRota() throws RotaNotFoundException {
        boolean origemEncontrada = false;
        boolean destinoEncontrado = false;

        for (Trecho trecho : trechos) {
            if (trecho.getInicio().equals(this.origem)) {
                origemEncontrada = true;
            }
            if (trecho.getFim().equals(this.destino)) {
                destinoEncontrado = true;
            }
        }

        if (!origemEncontrada) {
            throw new RotaNotFoundException("Origem não encontrada nos trechos.");
        }
        if (!destinoEncontrado) {
            throw new RotaNotFoundException("Destino não encontrado nos trechos.");
        }
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public List<Trecho> getTrechos() {
        return trechos;
    }

    public double getCustoTotal() {
        return trechos.stream().mapToDouble(Trecho::getCusto).sum();
    }
}
