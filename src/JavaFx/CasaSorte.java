package JavaFx;

import java.util.ArrayList;

public class CasaSorte extends Casa {

    public CasaSorte(int numero) {
        super(numero);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void aplicarRegra(ArrayList<Jogador> jogadores, int jogadorAtual) {
        System.out.println("Casa da sorte");
        if (jogadores.get(jogadorAtual).getTipo().equals("azarado")) {
            System.out.println("Não pode andar");
        } else {
            jogadores.get(jogadorAtual).mover(3);
        }

    }

}
