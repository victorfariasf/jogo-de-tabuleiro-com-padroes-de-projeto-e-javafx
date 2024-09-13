package JavaFx;

public class Tela {

    private Tabuleiro tabuleiro;

    public Tela(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public void HudCompleto(int rodadaAtual) {
        System.out.println("Nova rodada");
        System.out.println("Número da rodada atual: " + rodadaAtual);
        System.out.println();
        for (Jogador j : tabuleiro.getJogadoresList()) {
            System.out.println("Jogador: " + j.getNome());
            System.out.println("Cor: " + j.getCor());
            System.out.println("Tipo do Jogador: " + j.getTipo());
            System.out.println();
            System.out.println("Jogadas realizadas: " + j.getJogadas());
            System.out.println("Posição dentro do tabuleiro: " + j.getCor() + ": " + j.getPosicao());
            System.out.println("Pode jogar? " + j.podeJogar);
            System.out.println("-------------------------------------------------------");
        }
    }

    public void HudSimples(Jogador jogador) {
        System.out.println(jogador.getNome() + " -  " + jogador.getCor() + " -  " + jogador.getTipo());
        System.out.println("Jogadas feitas: " + jogador.getJogadas() + " -  " + "Posição da peça " + jogador.getCor() + ": " + jogador.getPosicao());

    }

    public void HudInicial() {
        System.out.println("Jogadores: ");
        for (Jogador j : tabuleiro.getJogadoresList()) {
            System.out.println("Jogador: " + j.getNome());
            System.out.println("Cor: " + j.getCor());
            System.out.println("Tipo de Jogador: " + j.getTipo());
            System.out.println();
            System.out.println("Jogadas realizadas: " + j.getJogadas());
            System.out.println("Posição da peça " + j.getCor() + ": " + j.getPosicao());
            System.out.println("-------------------------------------------------------");
        }
    }
}
