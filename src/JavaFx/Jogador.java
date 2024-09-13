package JavaFx;

public abstract class Jogador {

    // Atributos
    protected String nome;
    protected String cor;
    protected String tipo;
    protected int posicao;
    protected int jogadas;
    // sobre jogada inválida
    protected boolean podeJogar = true;
    // sobre casa especial
    protected boolean naoPodeJogar = false;

    protected int rodadaQuePodeJogar;

    protected int rodadasSemJogar = 0;
    protected int posicaoEspecial;

    /*
     * protected boolean temBone = false;
     * protected boolean temOculos = false;
     * protected boolean temMoleton = false;
     */

    protected int moedas = 0;

    // Métodos
    public Jogador(String nome, String cor, String tipo, int posicao, int jogadas) {
        this.nome = nome;
        this.cor = cor;
        this.tipo = tipo;
        this.posicao = posicao;
        this.jogadas = jogadas;
    }

    public void ganharMoeda(int ordemDeIncremento) {
        this.moedas += ordemDeIncremento;
    }

    public void gastarMoeda(int ordemDeDecremento) {
        if (this.moedas > 0) {
            this.moedas = this.moedas - ordemDeDecremento;
        } else {
            System.out.println("0 moedas. Não tem como gastar");
        }

    }

    public abstract int jogadarDados(Dado dado);

    public abstract boolean validandoSomaDosDados(int dado1, int dado2);

    public abstract String getDescricao();

    public boolean isNaoPodeJogar() {
        return naoPodeJogar;
    }

    public void setNaoPodeJogar(boolean naoPodeJogar) {
        this.naoPodeJogar = naoPodeJogar;
    }

    public int getRodadaQuePodeJogar() {
        return rodadaQuePodeJogar;
    }

    public void setRodadaQuePodeJogar(int rodadaQuePodeJogar) {
        this.rodadaQuePodeJogar = rodadaQuePodeJogar;
    }

    public int getMoedas() {
        return moedas;
    }

    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getJogadas() {
        return jogadas;
    }

    public void setJogadas(int jogadas) {
        this.jogadas += jogadas;
    }

    public boolean verificaDadosIguais(int resultadoDadoUm, int resultadoDadoDois) {
        return resultadoDadoUm == resultadoDadoDois;
    }

    public void mover(int jogada) {
        this.posicao += jogada;
    }

    public boolean ganhou(int tamanhoDoTabuleiro) {
        return this.getPosicao() >= tamanhoDoTabuleiro;
    }

    public void setPodeJogar(boolean podeJogar) {
        this.podeJogar = podeJogar;
    }

    public boolean getPodeJogar() {
        return podeJogar;
    }

    // auxiliares entre si
    public void podeJogar() {
        rodadasSemJogar++;
        if (rodadasSemJogar == 3) {
            this.setPodeJogar(true);
            setRodadasSemJogar(0);
        }
    }

    public int getRodadasSemJogar() {
        return rodadasSemJogar;
    }

    public void setRodadasSemJogar(int rodadasSemJogar) {
        this.rodadasSemJogar = rodadasSemJogar;
    }
    // ----------------------------------------
    // public abstract String temAcessorio();

    public int getPosicaoEspecial() {
        return posicaoEspecial;
    }

    public void setPosicaoEspecial(int posicaoEspecial) {
        this.posicaoEspecial = posicaoEspecial;
    }

}
