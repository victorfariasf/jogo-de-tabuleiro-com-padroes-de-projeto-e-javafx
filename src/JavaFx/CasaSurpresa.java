package JavaFx;

import java.util.ArrayList;

public class CasaSurpresa extends Casa {
    private NovoTabuleiro tabuleiro = NovoTabuleiro.getInstance();

    public CasaSurpresa(int numero) {
        super(numero);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void aplicarRegra(ArrayList<Jogador> jogadores, int jogadorAtual) {
        // tabuleiro.substituirJogador(jogadores.get(jogadorAtual), jogadorAtual);
        substituirJogador(jogadores.get(jogadorAtual), jogadorAtual);
        System.out.println("Casa surpresa");
    }

    public void substituirJogador(Jogador jogador, int jogadorAtual) {
        Jogador novoJogador = tabuleiro.criarNovoJogador(jogador.getNome(), jogador.getCor(), jogador.getPosicao(),
                jogador.getJogadas());
        if (jogador.getDescricao().contains("bone")) {
            novoJogador = new BoneDecorator(novoJogador);
        }
        if (jogador.getDescricao().contains("oculos")) {
            novoJogador = new OculosDecorator(novoJogador);
        }
        if (jogador.getDescricao().contains("moleton")) {
            novoJogador = new MoletonDecorator(novoJogador);
        }

        novoJogador.setMoedas(jogador.getMoedas());

        tabuleiro.atualizarLista(novoJogador, jogadorAtual);
    }

}
