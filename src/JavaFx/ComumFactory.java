package JavaFx;

public class ComumFactory implements JogadorFactory {

    @Override
    public Jogador criarJogador(String nome, String cor, int posicao, int jogadas) {
        return new JogadorComun(nome, cor, posicao, jogadas);
    }

}
