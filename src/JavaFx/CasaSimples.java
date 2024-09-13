package JavaFx;

import java.util.ArrayList;

public class CasaSimples extends Casa {

    public CasaSimples(int numero) {
        super(numero);

    }

    @Override
    public void aplicarRegra(ArrayList<Jogador> jogadores, int jogadorAtual) {
        Jogador jogador = jogadores.get(jogadorAtual);
        int moedasGanhas = 1; // Moeda base

        System.out.println("Ganhou uma moeda");

        // Verifica e adiciona moedas baseadas na descrição do jogador
        if (jogador.getDescricao().contains("bone")) {
            moedasGanhas += 1; // Total: 2 moedas
            System.out.println("Ganhou 2 moedas");
        }
        if (jogador.getDescricao().contains("oculos")) {
            moedasGanhas += 2; // Total: 4 moedas
            System.out.println("Ganhou 4 moedas");
        }
        if (jogador.getDescricao().contains("moleton")) {
            moedasGanhas += 3; // Total: 7 moedas
            System.out.println("Ganhou 7 moedas");
        }

        // Aplica a quantidade total de moedas ganhas ao jogador
        jogador.ganharMoeda(moedasGanhas);
        System.out.println("Total de moedas ganhas: " + moedasGanhas);

        // Atualiza a lista de jogadores
        tabuleiro.atualizarLista(jogador, jogadorAtual);
    }

}
