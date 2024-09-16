package JavaFx;

import java.util.ArrayList;
import java.util.Random;
import javafx.application.Platform;
import javafx.stage.Stage;

public class NovoTabuleiro {
    private ArrayList<Jogador> jogadores = new ArrayList<>();
    private ArrayList<Casa> casas = new ArrayList<>();

    private int numCasas;
    private int numJogadores;

    private Stage stage = Main.getStage();

    private static NovoTabuleiro instance = null;

    public static NovoTabuleiro getInstance() {
        if (instance == null)
            instance = new NovoTabuleiro();
        return instance;
    }

    private boolean debugMode = false;

    private DefCasaFactory factoryCasa = new DefCasaFactory();
    private DefJogadorFactory factoryJogador = new DefJogadorFactory();

    // ------------------------- INÍCIO DO JOGO -------------------------------

    public void defConfigurarTabuleiro(int numCasas) {
        for (int i = 1; i <= numCasas; i++) {
            Random random = new Random();
            int iRandom = random.nextInt(8) + 1;
            casas.add(factoryCasa.novaCasa(iRandom, i));
        }
    }

    /*
     * public void criarJogador(String nome, String cor) {
     * Random randomizador = new Random();
     * int indiceRandomizado = randomizador.nextInt(3) + 1;
     * switch (indiceRandomizado) {
     * case 1 -> {
     * jogadores.add(azaradoFactory.criarJogador(nome, cor, 0, 0));
     * }
     * case 2 -> {
     * jogadores.add(sortudoFactory.criarJogador(nome, cor, 0, 0));
     * }
     * case 3 -> {
     * jogadores.add(comumFactory.criarJogador(nome, cor, 0, 0));
     * }
     * default -> {
     * jogadores.add(comumFactory.criarJogador(nome, cor, 0, 0));
     * }
     * }
     * }
     */

    public void criarJogador(String nome, String cor) {
        Random randomizador = new Random();
        int indiceRandomizado = randomizador.nextInt(3) + 1;
        jogadores.add(factoryJogador.criarJogador(nome, cor, 0, 0, indiceRandomizado));

    }
    // ------------------------- DURANTE O JOGO -------------------------------

    public Jogador criarNovoJogador(String nome, String cor, int posicao, int jogadas) {
        Random randomizador = new Random();
        int indiceRandomizado = randomizador.nextInt(3) + 1;
        return factoryJogador.criarJogador(nome, cor, posicao, jogadas,
                indiceRandomizado);
    }

    public void decorarJogador(Jogador jogador, int jogadorAtual) {
        if (!jogador.getDescricao().contains("bone")) {
            jogador.gastarMoeda(1);
            Jogador jogadorDecorado = new BoneDecorator(jogador);
            atualizarLista(jogadorDecorado, jogadorAtual);
        } else if (!jogador.getDescricao().contains("moleton")) {
            jogador.gastarMoeda(1);
            Jogador jogadorDecorado = new MoletonDecorator(jogador);
            atualizarLista(jogadorDecorado, jogadorAtual);
        } else if (!jogador.getDescricao().contains("oculos")) {
            jogador.gastarMoeda(1);
            Jogador jogadorDecorado = new OculosDecorator(jogador);
            atualizarLista(jogadorDecorado, jogadorAtual);
        }

    }

    public void atualizarLista(Jogador jogador, int jogadorAtual) {
        jogadores.set(jogadorAtual, jogador);
    }

    public void verificarCasa(int jogadorAtual) {
        int casaAtualNumero = jogadores.get(jogadorAtual).getPosicao() - 1;
        casas.get(casaAtualNumero).aplicarRegra(jogadores, jogadorAtual);
    }

    public boolean verificaFimDeJogo(int jogadorAtual) {
        for (Jogador x : jogadores) {
            if (x.getPosicao() >= casas.size()) {
                return true;
            }
        }
        return false;

    }

    public boolean podeJogar(int rodadaAtual, int jogadorAtual) {
        if (jogadores.get(jogadorAtual).getPodeJogar()) {
            return true;
        } else {
            jogadores.get(jogadorAtual).podeJogar();
            avisoNaoJogar(jogadores.get(jogadorAtual), stage);
            return false;
        }
    }

    public void moverJogador(int jogadorAtual, int somaDosDados, int rodadaAtual) {
        jogadores.get(jogadorAtual).mover(somaDosDados);
        jogadores.get(jogadorAtual).setJogadas(1);
        if (jogadores.get(jogadorAtual).getMoedas() < 0) {
            jogadores.get(jogadorAtual).setMoedas(0);
        }
    }

    public void moverDebug(int jogadorAtual, int casaEscolhida) {
        jogadores.get(jogadorAtual).setPosicao(casaEscolhida);
        jogadores.get(jogadorAtual).setJogadas(1);
        if (jogadores.get(jogadorAtual).getMoedas() < 0) {
            jogadores.get(jogadorAtual).setMoedas(0);
        }
    }

    // --------------NOVAS CASAS ESPECIAIS------------------------

    public void chamarTelaDaCasa(int jogadorAtual, int rodadaAtual) {
        Platform.runLater(() -> {
            int casaAtualNumero = jogadores.get(jogadorAtual).getPosicao() - 1;
            Casa casaAtual = casas.get(casaAtualNumero);
            if (casaAtual instanceof CasaSimples) {
                // System.out.println("Casa simples");
                casaSimplesTela(jogadores, jogadorAtual, stage);
            } else if (casaAtual instanceof CasaSurpresa) {
                // System.out.println("Casa Surpresa");
                // substituirJogador(jogadores.get(jogadorAtual), jogadorAtual);
                casaSurpresaTela(jogadores, jogadorAtual, stage);
            } else if (casaAtual instanceof CasaPrisao) {
                // System.out.println("Casa Prisão");
                casaPrisaoTela(jogadores, jogadorAtual, stage);
            } else if (casaAtual instanceof CasaSorte) {
                // System.out.println("Casa da Sorte");
                casaSorteTela(jogadores, jogadorAtual, stage);
            } else if (casaAtual instanceof CasaAzar) {
                // System.out.println("Casa do Azar");
                casaAzarTela(jogadores, jogadorAtual, stage);
            } else if (casaAtual instanceof CasaReversa) {
                // System.out.println("Casa Reversa");
                casaReversaTela(jogadores, jogadorAtual, stage);
            } else if (casaAtual instanceof CasaJogarDeNovo) {
                // System.out.println("Casa Joga De Novo");
                casaJogaDeNovoTela(jogadores, jogadorAtual, stage);
            } else if (casaAtual instanceof CasaTroca) {
                // System.out.println("Casa Troca de Tela");
                casaTrocaTela(jogadores, jogadorAtual, stage);
            }

        });
    }

    private void casaSimplesTela(ArrayList<Jogador> jogadores, int jogadorAtual, Stage stage) {
        Platform.runLater(() -> {
            CasaSimplesModalController controller = new CasaSimplesModalController();
            ScreenUtil.mostrarTela(stage, "./fxml/new_fxml/casaSimplesModal.fxml", controller,
                    "Casa simples", jogadores, "simples", jogadorAtual);
        });
    }

    private void casaSurpresaTela(ArrayList<Jogador> jogadores, int jogadorAtual, Stage stage) {
        Platform.runLater(() -> {
            CasaSurpresaModalController controller = new CasaSurpresaModalController();
            ScreenUtil.mostrarTela(stage, "./fxml/new_fxml/casaSurpresaModal.fxml", controller,
                    "Casa surpresa", jogadores, "surpresa", jogadorAtual);
        });
    }

    private void casaPrisaoTela(ArrayList<Jogador> jogadores, int jogadorAtual, Stage stage) {
        Platform.runLater(() -> {
            CasaPrisaoModalController controller = new CasaPrisaoModalController();
            ScreenUtil.mostrarTela(stage, "./fxml/new_fxml/casaPrisaoModal.fxml", controller,
                    "Casa Prisão", jogadores, "prisao", jogadorAtual);
        });
    }

    private void casaSorteTela(ArrayList<Jogador> jogadores, int jogadorAtual, Stage stage) {
        Platform.runLater(() -> {
            CasaSorteModalController controller = new CasaSorteModalController();
            ScreenUtil.mostrarTela(stage, "./fxml/new_fxml/casaSorteModal.fxml", controller,
                    "Casa da Sorte", jogadores, "sorte", jogadorAtual);
        });
    }

    private void casaAzarTela(ArrayList<Jogador> jogadores, int jogadorAtual, Stage stage) {
        Platform.runLater(() -> {
            CasaAzarModalController controller = new CasaAzarModalController();
            ScreenUtil.mostrarTela(stage, "./fxml/new_fxml/casaAzarModal.fxml", controller,
                    "Casa do Azar", jogadores, "azar", jogadorAtual);
        });
    }

    private void casaReversaTela(ArrayList<Jogador> jogadores, int jogadorAtual, Stage stage) {
        Platform.runLater(() -> {
            CasaReversaModalController controller = new CasaReversaModalController();
            ScreenUtil.mostrarTela(stage, "./fxml/new_fxml/casaReversaModal.fxml", controller,
                    "Casa Reversa", jogadores, "reversa", jogadorAtual);
        });
    }

    private void casaJogaDeNovoTela(ArrayList<Jogador> jogadores, int jogadorAtual, Stage stage) {
        Platform.runLater(() -> {
            CasaJogarDeNovoModalController controller = new CasaJogarDeNovoModalController();
            ScreenUtil.mostrarTela(stage, "./fxml/new_fxml/casaJogarDeNovoModal.fxml", controller,
                    "Jogar De Novo", jogadores, "jogaDeNovo", jogadorAtual);
        });
    }

    private void casaTrocaTela(ArrayList<Jogador> jogadores, int jogadorAtual, Stage stage) {
        Platform.runLater(() -> {
            CasaTrocaModalController controller = new CasaTrocaModalController();
            ScreenUtil.mostrarTela(stage, "./fxml/new_fxml/casaTrocaModal.fxml", controller,
                    "Casa de Troca", jogadores, "troca", jogadorAtual);
        });
    }

    // ******************************

    public void mostrarTelaFinal(int jogadorAtual) {
        ganhou(jogadores, stage, jogadores.get(jogadorAtual));
    }

    private void ganhou(ArrayList<Jogador> jogadores, Stage stage, Jogador ganhador) {
        Platform.runLater(() -> {
            // showModalGanhou(jogadores);
            ModalGanhouController controller = new ModalGanhouController();
            ScreenUtil.showModal(stage, "./fxml/modalGanhou.fxml", controller, "Fim de jogo", jogadores, "ganhou",
                    ganhador);
        });
    }

    // ******************************

    public boolean verificaJogadaInvalida(Jogador jogador, int dadoUm, int dadoDois, Stage stage) {
        if (jogador.validandoSomaDosDados(dadoUm, dadoDois) == false) {
            valoresInvalidos(jogador, stage);
            return true;
        }
        return false;
    }

    private void valoresInvalidos(Jogador jogador, Stage stage) {
        Platform.runLater(() -> {
            ModalValoresInvalidosController controller = new ModalValoresInvalidosController();
            ScreenUtil.showModal(stage, "./fxml/modalValoresInvalidos.fxml", controller, "Dados inválidos", null,
                    "valoresInvalidos", jogador);
        });
    }

    // *****************

    private void avisoNaoJogar(Jogador jogador, Stage stage) {
        Platform.runLater(() -> {
            ModalAvisoNaoJogaController controller = new ModalAvisoNaoJogaController();
            ScreenUtil.showModal(stage, "./fxml/modalAvisoNaoJoga.fxml", controller, "Rodada sem jogar", null,
                    "avisoNaoJoga",
                    jogador);
        });
    }

    // --------------------------------------

    public ArrayList<Jogador> retornarListaDeJogadores() {
        return jogadores;
    }

    // ----------------------------- PARA DEBUG ------------------------------------
    public void mostrarJogadores() {
        for (Jogador x : jogadores) {
            System.out.println(x.getDescricao());
        }
    }

    public void mostrarCasasEIndices() {
        for (int i = 0; i < casas.size(); i++) {
            System.out.println(casas.get(i) + ", índice " + (i + 1));
        }
    }

    // ---------------------------------GETTERS &
    // SETTERS------------------------------------------
    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public ArrayList<Casa> getCasas() {
        return casas;
    }

    public void setCasas(ArrayList<Casa> casas) {
        this.casas = casas;
    }

    public int getNumJogadores() {
        return numJogadores;
    }

    public void setNumJogadores(int numJogadores) {
        this.numJogadores = numJogadores;
    }

    public int getNumCasas() {
        return numCasas;
    }

    public void setNumCasas(int numCasas) {
        this.numCasas = numCasas;
    }

    public boolean isDebugMode() {
        return debugMode;
    }

    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }
}