package JavaFx;

public class DefJogadorFactory {
    public static Jogador criarJogador(String nome, String cor, int posicao, int jogadas, int qualJogador) {
        switch (qualJogador) {
            case 1:
                return new JogadorAzarado(nome, cor, posicao, jogadas);
            case 2:
                return new JogadorComun(nome, cor, posicao, jogadas);
            case 3:
                return new JogadorSortudo(nome, cor, posicao, jogadas);
            default:
                return new JogadorComun(nome, cor, posicao, jogadas);
        }

    }
}
