package JavaFx;

import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Jogo {

    private Stage stage;
    private NovoTabuleiro tabuleiro = NovoTabuleiro.getInstance();

    public Jogo(Stage stage) {
        this.stage = stage;
    }

    private ArrayList<Jogador> jogadores = new ArrayList<>();
    // private Auxiliar aux = new Auxiliar();

    // --------------------NOVO TABULEIRO------------------------

    public void configurarTabuleiro(int numeroDeCasas) {
        tabuleiro.defConfigurarTabuleiro(numeroDeCasas);
    }

    public void configurarJogadores(int numeroDeJogadores) {
        tabuleiro.setNumJogadores(numeroDeJogadores);
    }

    public void criarJogador(String nome, String cor) {
        tabuleiro.criarJogador(nome, cor);
    }

    // ------------------------------------------------------------
    public void andarNoTabuleiro(int jogadorAtual, int somasDosDados, int rodadaAtual) {
        // tabuleiro.verificarCasa(jogador, jogadorAtual);
        tabuleiro.moverJogador(jogadorAtual, somasDosDados, rodadaAtual);
    }

    public void andarNoTabuleiroDebug(int jogadorAtual, int casaEscolhida) {
        tabuleiro.moverDebug(jogadorAtual, casaEscolhida);
    }

    public void mostrarTela(int jogadorAtual, int rodadaAtual) {
        tabuleiro.chamarTelaDaCasa(jogadorAtual, rodadaAtual);
    }

    public void mostrarTelaFinal(int jogadorAtual) {
        tabuleiro.mostrarTelaFinal(jogadorAtual);
    }

    public boolean verificaSeAlguemGanhou(int jogadorAtual) {
        return tabuleiro.verificaFimDeJogo(jogadorAtual);
    }

    public void mostrarDescricoes() {
        tabuleiro.mostrarJogadores();

    }

    public boolean verificarJogadaInvalida(Jogador jogador, int dadoUmValor, int dadoDoisValor, Stage stage) {
        if (tabuleiro.verificaJogadaInvalida(jogador, dadoUmValor, dadoDoisValor, stage)) {
            return true;
        }
        return false;
    }

    public boolean jogadorPodeJogar(int rodadaAtual, int jogadorAtual) {
        return tabuleiro.podeJogar(rodadaAtual, jogadorAtual);
    }

    // nova função
    /*
     * public boolean verificaSeEstaPreso(int jogadorAtual, int rodadaAtual) {
     * return tabuleiro.verificaJogarNaPartidaAtual(jogadorAtual, rodadaAtual);
     * }
     */
    // função que deve ser trocada
    /*
     * public boolean verificaPodeJogarPartidaAtual(Jogador jogador, int
     * rodadaAtual, Stage stage) {
     * if (tabuleiro.verificaJogarNaPartidaAtual(jogador, rodadaAtual, stage)) {
     * return true;
     * }
     * return false;
     * }
     */

    public boolean modoDebug() {
        return tabuleiro.isDebugMode();
    }

    public void setModoDebug(boolean opcao) {
        tabuleiro.setDebugMode(opcao);
    }

    public void mostrarCasasESeusIndices() {
        tabuleiro.mostrarCasasEIndices();
    }

    /*
     * public boolean verificaJogadaInvalida(Jogador jogador, int dadoUmValor, int
     * dadoDoisValor, Stage stage) {
     * if (aux.verificaJogadaInvalida(jogador, dadoUmValor, dadoDoisValor, stage)) {
     * return true;
     * }
     * return false;
     * }
     */

    // ---------------------------------------------------------------
    public ArrayList<Jogador> pegarListaDeJogadores() {
        return tabuleiro.getJogadores();
    }

    // -------------------------------------------------------------
    // ---- teste ----
    public void quantidaDeJogadores() {
        tabuleiro.mostrarJogadores();
    }

    public void buscarJogadores() {
        jogadores = tabuleiro.getJogadores();
    }

    public ArrayList<Jogador> retornarListaDeJogadores() {
        return jogadores;
    }

    // --------------------------------------------

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}