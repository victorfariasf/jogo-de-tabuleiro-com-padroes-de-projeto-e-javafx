package JavaFx;

import java.util.ArrayList;

public class CasaReversa extends Casa {

    public CasaReversa(int numero) {
        super(numero);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void aplicarRegra(ArrayList<Jogador> jogadores, int jogadorAtual) {
        System.out.println("Casa Reversa");
        int posicaoDoJogadorAtual = jogadores.get(jogadorAtual).getPosicao();
        int posicaoDoJogadorMaisAtras = Integer.MAX_VALUE;
        // buscando o jogador mais atrás
        for (Jogador x : jogadores) {
            if (x.getPosicao() < posicaoDoJogadorMaisAtras) {
                posicaoDoJogadorMaisAtras = x.getPosicao();
            }
        }
        if (jogadores.get(jogadorAtual).getPosicao() == posicaoDoJogadorMaisAtras) {
            System.out.println("Não precisa de lógica");
        } else {
            // jogador mais atrás recebe a nova posição (do jogador atual)
            for (Jogador x : jogadores) {
                if (x.getPosicao() == posicaoDoJogadorMaisAtras) {
                    x.setPosicao(posicaoDoJogadorAtual);
                }
            }
            // jogador atual recebe a posição do jogador mais atrás
            jogadores.get(jogadorAtual).setPosicao(posicaoDoJogadorMaisAtras);
        }

    }

}
