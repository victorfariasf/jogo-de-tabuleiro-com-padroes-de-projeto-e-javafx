package JavaFx;

import java.util.ArrayList;

public class CasaPrisao extends Casa {

    public CasaPrisao(int numero) {
        super(numero);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void aplicarRegra(ArrayList<Jogador> jogadores, int jogadorAtual) {
        System.out.println("Prisão");
        jogadores.get(jogadorAtual).setPodeJogar(false);
        jogadores.get(jogadorAtual).podeJogar();

        // jogadores.get(jogadorAtual).setRodadaQuePodeJogar(jogadores.get(jogadorAtual).getPosicao()
        // + 2);
        // jogadores.get(jogadorAtual).setNaoPodeJogar(true);

    }

}
