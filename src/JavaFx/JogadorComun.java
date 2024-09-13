package JavaFx;

public class JogadorComun extends Jogador {

    // Metodos
    public JogadorComun(String nome, String cor, int posicao, int jogadas) {
        super(nome, cor, "comum", posicao, jogadas);
    }

    @Override
    public int jogadarDados(Dado dado) {
        int dadoUm = dado.rolarDado();
        int dadoDois = dado.rolarDado();
        if (podeJogar == true) {

            System.out.println("Dado 1 (" + dadoUm + ") - Dado 2 (" + dadoDois + ")");
            System.out.println("Soma dos dados: " + (dadoUm + dadoDois));

            if (dadoUm == dadoDois) {
                int novoDadoUm = dado.rolarDado();
                int novoDadoDois = dado.rolarDado();
                System.out.println("Rolando os dados novamente porque os dados anteriores eram iguais");
                System.out.println("NOVOS DADOS - Dado 1 (" + novoDadoUm + ") - Dado 2 (" + novoDadoDois + ")");
                System.out.println("Soma dos dados: " + (novoDadoUm + novoDadoDois));
                System.out.println("Soma de todos os dados: " + (dadoUm + dadoDois + novoDadoDois + novoDadoDois));
                return dadoUm + dadoDois + novoDadoDois + novoDadoDois;
            }

            return dadoUm + dadoDois;
        } else {
            System.out.println("Jogador não poderá jogar nesta rodada!");
            return 0;
        }

    }

    @Override
    public boolean validandoSomaDosDados(int dado1, int dado2) {
        return true;
    }

    @Override
    public String getDescricao() {
        return getNome() + "/ " + getCor() + "/ Posição atual->" + getPosicao() + "/ jogadas feitas->" + getJogadas()
                + "/ Tipo da peça->" + getTipo() + "/ Quantidade de moedas->" + getMoedas();
    }

}
