package JavaFx;

import java.util.ArrayList;

public class CasaJogarDeNovo extends Casa {

    public CasaJogarDeNovo(int numero) {
        super(numero);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void aplicarRegra(ArrayList<Jogador> jogadores, int jogadorAtual) {
        System.out.println("Jogue de novo");
    }

}
