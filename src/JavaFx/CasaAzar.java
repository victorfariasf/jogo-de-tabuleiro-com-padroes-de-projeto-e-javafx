package JavaFx;

import java.util.ArrayList;

public class CasaAzar extends Casa {

    public CasaAzar(int numero) {
        super(numero);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void aplicarRegra(ArrayList<Jogador> jogadores, int jogadorAtual) {
        if (jogadores.get(jogadorAtual).getTipo().equals("sortudo")) {
            System.out.println("Não perde moedas!");
        } else if (jogadores.get(jogadorAtual).getMoedas() <= 3) {
            jogadores.get(jogadorAtual).setMoedas(0);
        } else {
            jogadores.get(jogadorAtual).gastarMoeda(3);
        }
    }

}
