package JavaFx;

import java.util.ArrayList;

public abstract class Casa {
    protected int numero;
    protected NovoTabuleiro tabuleiro = NovoTabuleiro.getInstance();

    public NovoTabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(NovoTabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public Casa(int numero) {
        this.numero = numero;
    }

    public abstract void aplicarRegra(ArrayList<Jogador> jogadores, int jogadorAtual);
}
