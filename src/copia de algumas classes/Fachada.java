import java.util.ArrayList;

public class Fachada {
    JogadorServico jogadorServico = new JogadorServico();
    ArrayList<Jogador> jogadores = new ArrayList<>();
    Dado dice = new Dado();

    public void criarJogadores(String name, String color) {
        Jogador jogador = jogadorServico.criarJogador(name, color);
        jogadores.add(jogador);
    }

    public ArrayList<Jogador> returnPlayerList() {
        return jogadores;
    }

    public int rolarDados() {
        return dice.rolarDados();
    }

}
