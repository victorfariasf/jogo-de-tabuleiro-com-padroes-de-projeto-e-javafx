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
    }

}
