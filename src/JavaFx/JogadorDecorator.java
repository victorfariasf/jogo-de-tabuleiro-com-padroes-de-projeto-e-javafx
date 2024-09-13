package JavaFx;

public abstract class JogadorDecorator extends Jogador {
    protected Jogador jogador;

    public JogadorDecorator(Jogador jogador) {
        super(jogador.getNome(), jogador.getCor(), jogador.getTipo(), jogador.getPosicao(), jogador.getJogadas());
        this.jogador = jogador;
    }

    @Override
    public boolean isNaoPodeJogar() {
        return jogador.isNaoPodeJogar();
    }

    @Override
    public void setNaoPodeJogar(boolean naoPodeJogar) {
        jogador.setNaoPodeJogar(naoPodeJogar);
    }

    @Override
    public void ganharMoeda(int quantida) {
        jogador.ganharMoeda(quantida);
    }

    @Override
    public void gastarMoeda(int quantida) {
        jogador.gastarMoeda(quantida);
    }

    @Override
    public int jogadarDados(Dado dado) {
        return jogador.jogadarDados(dado);
    }

    @Override
    public boolean validandoSomaDosDados(int dado1, int dado2) {
        return jogador.validandoSomaDosDados(dado1, dado2);
    }

    @Override
    public String getDescricao() {
        return jogador.getDescricao();
    }

    @Override
    public String getTipo() {
        return jogador.getTipo();
    }

    @Override
    public int getMoedas() {
        return jogador.getMoedas();
    }

    @Override
    public void setMoedas(int quantidade) {
        jogador.setMoedas(quantidade);
    }

    @Override
    public void mover(int quantida) {
        jogador.mover(quantida);
    }

}
