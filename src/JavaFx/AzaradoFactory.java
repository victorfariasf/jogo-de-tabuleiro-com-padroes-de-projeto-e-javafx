package JavaFx;

public class AzaradoFactory implements JogadorFactory {

    @Override
    public Jogador criarJogador(String nome, String cor, int posicao, int jogadas) {
        return new JogadorAzarado(nome, cor, posicao, jogadas);
    }

}
