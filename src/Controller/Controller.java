package Controller;

import Model.*;
import Model.Exceptions.*;

import java.util.*;

public class Controller {
    private Map<String, Motorista> motoristaMap = new HashMap<>();
    private Map<String, Passageiro> passageiroMap = new HashMap<>();
    private Map<String, Onibus> onibusMap = new HashMap<>();
    private List<Trecho> trechos = new ArrayList<>();
    private List<Rota> rotas = new ArrayList<>();
    private List<Viagem> viagens = new ArrayList<>();

    public void cadastrarTrecho(Trecho trecho) throws TrechoDuplicadoException {
        for (Trecho t : trechos) {
            if (t.getInicio().equalsIgnoreCase(trecho.getInicio()) &&
                t.getFim().equalsIgnoreCase(trecho.getFim())) {
                throw new TrechoDuplicadoException("Trecho já cadastrado com início e fim iguais.");
            }
        }
        trechos.add(trecho);
    }

    public List<Trecho> listarTrechos() {
        return trechos;
    }
    
    public void cadastrarMotorista(Motorista motorista) throws CadastroDuplicadoException {
        if (motoristaMap.containsKey(motorista.getCpf())) {
            throw new CadastroDuplicadoException("Motorista com esse CPF já cadastrado.");
        }
        motoristaMap.put(motorista.getCpf(), motorista);
    }

    public Motorista buscarMotorista(String cpf) {
        return motoristaMap.get(cpf);
    }

    public List<Motorista> listarMotoristas() {
        return new ArrayList<>(motoristaMap.values());
    }

    public void cadastrarPassageiro(Passageiro passageiro) throws CadastroDuplicadoException {
        if (passageiroMap.containsKey(passageiro.getCpf())) {
            throw new CadastroDuplicadoException("Passageiro com esse CPF já cadastrado.");
        }
        passageiroMap.put(passageiro.getCpf(), passageiro);
    }

    public Passageiro buscarPassageiro(String cpf) {
        return passageiroMap.get(cpf);
    }

    public List<Passageiro> listarPassageiros() {
        return new ArrayList<>(passageiroMap.values());
    }

    public void cadastrarOnibus(Onibus onibus) throws CadastroDuplicadoException {
        if (onibusMap.containsKey(onibus.getPlaca())) {
            throw new CadastroDuplicadoException("Ônibus com essa placa já cadastrado.");
        }
        onibusMap.put(onibus.getPlaca(), onibus);
    }

    public List<Onibus> listarOnibus() {
        return new ArrayList<>(onibusMap.values());
    }

    public void cadastrarRota(Rota rota) throws RotaNotFoundException {
        rota.validarRota();
        rotas.add(rota);
    }

    public List<Rota> listarRotas() {
        return rotas;
    }

    public void criarViagem(Viagem viagem) {
        viagens.add(viagem);
    }

    public List<Viagem> listarViagens() {
        return viagens;
    }
}
