package JavaFx;

public class SortudoFactory implements JogadorFactory {

    @Override
    public Jogador criarJogador(String nome, String cor, int posicao, int jogadas) {
        return new JogadorSortudo(nome, cor, posicao, jogadas);
    }

}
