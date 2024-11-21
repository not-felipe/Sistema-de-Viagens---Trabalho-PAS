package View;

import Controller.Controller;
import Model.*;
import Model.Exceptions.CadastroDuplicadoException;
import Model.Exceptions.RotaNotFoundException;
import Model.Exceptions.TrechoDuplicadoException;

import java.util.*;

public class View {
    private Controller sistemaController;
    private Scanner scanner;

    public View() {
        this.sistemaController = new Controller();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
    while (true) {
        System.out.println("1 - Cadastrar Motorista");
        System.out.println("2 - Cadastrar Passageiro");
        System.out.println("3 - Cadastrar Ônibus");
        System.out.println("4 - Cadastrar Trecho");  
        System.out.println("5 - Cadastrar Rota");
        System.out.println("6 - Criar Viagem");
        System.out.println("7 - Listar Viagens");
        System.out.println("8 - Listar Motoristas");
        System.out.println("9 - Listar Rotas");
        System.out.println("10 - Listar Trechos");  
        System.out.println("11 - Listar Ônibus");
        System.out.println("12 - Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1 -> cadastrarMotorista();
            case 2 -> cadastrarPassageiro();
            case 3 -> cadastrarOnibus();
            case 4 -> cadastrarTrecho(); 
            case 5 -> cadastrarRota();
            case 6 -> criarViagem();
            case 7 -> listarViagens();
            case 8 -> listarMotoristas();
            case 9 -> listarRotas();
            case 10 -> listarTrechos();  
            case 11 -> listarOnibus();
            case 12 -> {
                System.out.println("Saindo...");
                return;
            }
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }
}

    private void cadastrarTrecho() {
        System.out.print("Digite o início do trecho: ");
        String inicio = scanner.nextLine();
        System.out.print("Digite o fim do trecho: ");
        String fim = scanner.nextLine();
        System.out.print("Digite a duração em horas: ");
        int horas = scanner.nextInt();
        System.out.print("Digite a duração em minutos: ");
        int minutos = scanner.nextInt();
        System.out.print("Digite o custo do trecho: ");
        double custo = scanner.nextDouble();
        scanner.nextLine(); 

        Trecho trecho = new Trecho(inicio, fim, horas, minutos, custo);

        try {
            sistemaController.cadastrarTrecho(trecho);
            System.out.println("Trecho cadastrado com sucesso!");
        } catch (TrechoDuplicadoException e) {
            System.out.println("Erro ao cadastrar trecho: " + e.getMessage());
        }
    }

    private void listarTrechos() {
        List<Trecho> trechos = sistemaController.listarTrechos();
        if (trechos.isEmpty()) {
            System.out.println("Nenhum trecho cadastrado.");
        } else {
            System.out.println("Trechos cadastrados:");
            for (Trecho trecho : trechos) {
                System.out.println("- De " + trecho.getInicio() + " para " + trecho.getFim() +
                                   ", Duração: " + trecho.getDuracaoHoras() + "h " +
                                   trecho.getDuracaoMinutos() + "min, Custo: R$ " +
                                   String.format("%.2f", trecho.getCusto()));
            }
        }
    }

    //Criei esse método para facilitar testes
    public void cadastrarDadosIniciais() {
        try {
            Onibus onibus1 = new Onibus("ABC-1234", 50, "Executiva", 500.0);
            Onibus onibus2 = new Onibus("DEF-5678", 40, "Luxo", 800.0);
            sistemaController.cadastrarOnibus(onibus1);
            sistemaController.cadastrarOnibus(onibus2);

            Motorista motorista1 = new Motorista("12345678901", "João da Silva", 45, 200.0);
            Motorista motorista2 = new Motorista("98765432100", "Maria Oliveira", 38, 250.0);
            sistemaController.cadastrarMotorista(motorista1);
            sistemaController.cadastrarMotorista(motorista2);

            Passageiro passageiro1 = new Passageiro("Carlos Souza", "11111111111", "carlos@email.com");
            Passageiro passageiro2 = new Passageiro("Ana Lima", "22222222222", "ana@email.com");
            sistemaController.cadastrarPassageiro(passageiro1);
            sistemaController.cadastrarPassageiro(passageiro2);

            Trecho trecho1 = new Trecho("São Paulo", "Campinas", 1, 30, 100.0);
            Trecho trecho2 = new Trecho("Campinas", "Rio de Janeiro", 6, 0, 300.0);
            sistemaController.cadastrarTrecho(trecho1);
            sistemaController.cadastrarTrecho(trecho2);

            List<Trecho> trechos = Arrays.asList(trecho1, trecho2);
            Rota rota1 = new Rota("São Paulo", "Rio de Janeiro", trechos);
            sistemaController.cadastrarRota(rota1);

            System.out.println("Dados iniciais cadastrados com sucesso!");
        } catch (CadastroDuplicadoException | RotaNotFoundException | TrechoDuplicadoException e) {
            System.out.println("Erro ao cadastrar dados iniciais: " + e.getMessage());
        }
    }

    private void cadastrarMotorista() {
        System.out.print("Digite o CPF do motorista: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o nome do motorista: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a idade do motorista: ");
        int idade = scanner.nextInt();
        System.out.print("Digite o valor da diaria do motorista: ");
        double diaria = scanner.nextDouble();
        scanner.nextLine();

        Motorista motorista = new Motorista(cpf, nome, idade, diaria);
        try {
            sistemaController.cadastrarMotorista(motorista);
            System.out.println("Motorista cadastrado com sucesso!");
        } catch (CadastroDuplicadoException e) {
            System.out.println("Erro ao cadastrar motorista: " + e.getMessage());
        }
    }

    private void cadastrarPassageiro() {
        System.out.print("Digite o CPF do passageiro: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o nome do passageiro: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o email do passageiro: ");
        String email = scanner.nextLine();

        Passageiro passageiro = new Passageiro(nome, cpf, email);
        try {
            sistemaController.cadastrarPassageiro(passageiro);
            System.out.println("Passageiro cadastrado com sucesso!");
        } catch (CadastroDuplicadoException e) {
            System.out.println("Erro ao cadastrar passageiro: " + e.getMessage());
        }
    }

    private void cadastrarOnibus() {
        System.out.print("Digite a placa do onibus: ");
        String placa = scanner.nextLine();
        System.out.print("Digite o numero de lugares: ");
        int lugares = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite a classe do onibus (economica, executiva ou luxo): ");
        String classe = scanner.nextLine();
        System.out.print("Digite o custo do onibus: ");
        double custo = scanner.nextDouble();
        scanner.nextLine();

        Onibus onibus = new Onibus(placa, lugares, classe, custo);
        try {
            sistemaController.cadastrarOnibus(onibus);
            System.out.println("Onibus cadastrado com sucesso!");
        } catch (CadastroDuplicadoException e) {
            System.out.println("Erro ao cadastrar onibus: " + e.getMessage());
        }
    }

    private void cadastrarRota() {
    System.out.print("Digite a origem da rota: ");
    String origem = scanner.nextLine();
    System.out.print("Digite o destino da rota: ");
    String destino = scanner.nextLine();

    List<Trecho> trechos = sistemaController.listarTrechos();
    if (trechos.isEmpty()) {
        System.out.println("Nenhum trecho cadastrado. Cadastre trechos primeiro.");
        return;
    }

    System.out.println("Selecione os trechos que compõem a rota:");
    List<Trecho> trechosSelecionados = new ArrayList<>();

    for (int i = 0; i < trechos.size(); i++) {
        System.out.println((i + 1) + " - De " + trechos.get(i).getInicio() +
                           " para " + trechos.get(i).getFim() +
                           ", Duração: " + trechos.get(i).getDuracaoHoras() +
                           "h " + trechos.get(i).getDuracaoMinutos() +
                           "min, Custo: R$ " +
                           String.format("%.2f", trechos.get(i).getCusto()));
    }

    System.out.println("Digite os números dos trechos desejados (separados por espaço):");
    String[] indices = scanner.nextLine().split(" ");

    for (String indice : indices) {
        try {
            int idx = Integer.parseInt(indice.trim()) - 1;
            if (idx >= 0 && idx < trechos.size()) {
                trechosSelecionados.add(trechos.get(idx));
            } else {
                System.out.println("Índice inválido: " + indice);
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida: " + indice);
        }
    }

    try {
        Rota rota = new Rota(origem, destino, trechosSelecionados);
        sistemaController.cadastrarRota(rota);
        System.out.println("Rota cadastrada com sucesso!");
    } catch (RotaNotFoundException e) {
        System.out.println("Erro ao cadastrar rota: " + e.getMessage());
    }
}

    private void criarViagem() {
        System.out.println("Criando uma nova viagem...");

        System.out.println("Selecione um onibus:");
        List<Onibus> onibusList = sistemaController.listarOnibus();
        if (onibusList.isEmpty()) {
            System.out.println("Nenhum onibus cadastrado. Cadastre um onibus primeiro.");
            return;
        }
        for (int i = 0; i < onibusList.size(); i++) {
            System.out.println((i + 1) + " - " + onibusList.get(i).getPlaca() + " (" + onibusList.get(i).getClasse() + ")");
        }
        int onibusIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        Onibus onibus = onibusList.get(onibusIndex);

        System.out.println("Selecione um motorista:");
        List<Motorista> motoristas = sistemaController.listarMotoristas();
        for (int i = 0; i < motoristas.size(); i++) {
            System.out.println((i + 1) + " - " + motoristas.get(i).getNome());
        }
        int motoristaIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        Motorista motorista = motoristas.get(motoristaIndex);

        System.out.println("Selecione uma rota:");
        List<Rota> rotas = sistemaController.listarRotas();
        for (int i = 0; i < rotas.size(); i++) {
            System.out.println((i + 1) + " - De " + rotas.get(i).getOrigem() + " para " + rotas.get(i).getDestino());
        }
        int rotaIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        Rota rota = rotas.get(rotaIndex);

        System.out.print("Digite o dia (DD): ");
        int dia = scanner.nextInt();
        System.out.print("Digite o mes (MM): ");
        int mes = scanner.nextInt();
        System.out.print("Digite o ano (YYYY): ");
        int ano = scanner.nextInt();
        System.out.print("Digite a hora (HH): ");
        int hora = scanner.nextInt();
        System.out.print("Digite os minutos (MM): ");
        int minuto = scanner.nextInt();

        Calendar dataInicio = Calendar.getInstance();
        dataInicio.set(ano, mes - 1, dia, hora, minuto);

        Viagem viagem = new Viagem(onibus, motorista, rota, dataInicio);
        sistemaController.criarViagem(viagem);

        System.out.println("Viagem criada com sucesso!");
    }

    private void listarMotoristas() {
        List<Motorista> motoristas = sistemaController.listarMotoristas();
        if (motoristas.isEmpty()) {
            System.out.println("Nenhum motorista cadastrado.");
        } else {
            System.out.println("Motoristas cadastrados:");
            for (Motorista motorista : motoristas) {
                System.out.println("- Nome: " + motorista.getNome() +
                                   ", CPF: " + motorista.getCpf() +
                                   ", Idade: " + motorista.getIdade() +
                                   ", Diaria: R$ " + String.format("%.2f", motorista.getValorDiaria()));
            }
        }
    }

    private void listarRotas() {
        List<Rota> rotas = sistemaController.listarRotas();
        if (rotas.isEmpty()) {
            System.out.println("Nenhuma rota cadastrada.");
        } else {
            System.out.println("Rotas cadastradas:");
            for (Rota rota : rotas) {
                System.out.println("- Origem: " + rota.getOrigem() +
                                   ", Destino: " + rota.getDestino() +
                                   ", Custo Total: R$ " + String.format("%.2f", rota.getCustoTotal()));
                System.out.println("  Trechos:");
                for (Trecho trecho : rota.getTrechos()) {
                    System.out.println("    - De " + trecho.getInicio() +
                                       " para " + trecho.getFim() +
                                       ", Duracao: " + trecho.getDuracaoHoras() + "h " + trecho.getDuracaoMinutos() + "min" +
                                       ", Custo: R$ " + String.format("%.2f", trecho.getCusto()));
                }
            }
        }
    }

    private void listarOnibus() {
        List<Onibus> onibusList = sistemaController.listarOnibus();
        if (onibusList.isEmpty()) {
            System.out.println("Nenhum onibus cadastrado.");
        } else {
            System.out.println("Onibus cadastrados:");
            for (Onibus onibus : onibusList) {
                System.out.println("- Placa: " + onibus.getPlaca() +
                                   ", Classe: " + onibus.getClasse() +
                                   ", Numero de Lugares: " + onibus.getNumeroDeLugares() +
                                   ", Custo: R$ " + String.format("%.2f", onibus.getCusto()));
            }
        }
    }

    private void listarViagens() {
        List<Viagem> viagens = sistemaController.listarViagens();
        if (viagens.isEmpty()) {
            System.out.println("Nenhuma viagem cadastrada.");
        } else {
            System.out.println("Viagens cadastradas:");
            for (Viagem viagem : viagens) {
                System.out.println(viagem);
            }
        }
    }
}
