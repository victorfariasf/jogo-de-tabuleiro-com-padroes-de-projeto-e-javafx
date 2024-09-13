package JavaFx;

import java.util.ArrayList;

public class CasaTroca extends Casa {

    public CasaTroca(int numero) {
        super(numero);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void aplicarRegra(ArrayList<Jogador> jogadores, int jogadorAtual) {
        System.out.println("comprar acessórios");
        tabuleiro.decorarJogador(jogadores.get(jogadorAtual), jogadorAtual);
        // jogadores.get(jogadorAtual).gastarMoeda(1);
    }

}
