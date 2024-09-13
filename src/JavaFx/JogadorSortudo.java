package JavaFx;

public class JogadorSortudo extends Jogador {

    // Métodos
    public JogadorSortudo(String nome, String cor, int posicao, int jogadas) {
        super(nome, cor, "sortudo", posicao, jogadas);
    }

    @Override
    public int jogadarDados(Dado dado) {
        int dadoUm = dado.rolarDado();
        int dadoDois = dado.rolarDado();
        System.out.println("Dado 1 (" + dadoUm + ") - Dado 2 (" + dadoDois + ")");
        boolean dadosValidos = valoresValidos((dadoUm + dadoDois));

        if (dadosValidos == false) {
            System.out.println("Rolando os dados novamente");
            dadoUm = dado.rolarDado();
            dadoDois = dado.rolarDado();
            System.out.println("Dado 1 (" + dadoUm + ") - Dado 2 (" + dadoDois + ")");

            dadosValidos = valoresValidos((dadoUm + dadoDois));

            if (dadosValidos == false) {

                System.out.println("Passando a vez");
                return -1;
            } else {

                System.out.println("Soma dos dados: " + (dadoUm + dadoDois));

                if (dadoUm == dadoDois) {
                    int novoDadoUm = dado.rolarDado();
                    int novoDadoDois = dado.rolarDado();
                    System.out.println("Rolando os dados novamente porque os dados anteriores");
                    System.out.println("NOVOS DADOS - Dado 1 (" + novoDadoUm + ") - Dado 2 (" + novoDadoDois + ")");
                    System.out.println("Soma dos dados: " + (novoDadoUm + novoDadoDois));
                    System.out.println("Soma de todos os dados: " + (dadoUm + dadoDois + novoDadoDois + novoDadoDois));
                    return dadoUm + dadoDois + novoDadoDois + novoDadoDois;
                }

                return dadoUm + dadoDois;
            }
        } else {

            System.out.println("Soma dos dados: " + (dadoUm + dadoDois));

            if (dadoUm == dadoDois) {
                int novoDadoUm = dado.rolarDado();
                int novoDadoDois = dado.rolarDado();
                System.out.println("Rolando os dados novamente porque os dados anteriores são iguais");
                System.out.println("NOVOS DADOS - Dado 1 (" + novoDadoUm + ") - Dado 2 (" + novoDadoDois + ")");
                System.out.println("Soma dos dados: " + (novoDadoUm + novoDadoDois));
                System.out.println("Soma de todos os dados: " + (dadoUm + dadoDois + novoDadoDois + novoDadoDois));
                return dadoUm + dadoDois + novoDadoDois + novoDadoDois;
            }

            return dadoUm + dadoDois;
        }
    }

    public boolean valoresValidos(int somaDosDados) {
        if (podeJogar == true) {
            if (somaDosDados < 7) {
                System.out.println("Soma dos dados: " + somaDosDados);
                System.out.println("Valor dos dados menor que 7");
                return false;
            } else {
                return true;
            }
        } else {
            System.out.println("Jogador não poderá jogar nesta rodada!");
            return false;
        }
    }

    @Override
    public boolean validandoSomaDosDados(int dado1, int dado2) {
        if (dado1 + dado2 < 7) {
            return false;
        } else
            return true;
    }

    @Override
    public String getDescricao() {
        return getNome() + "/ " + getCor() + "/ Posição atual->" + getPosicao() + "/ jogadas feitas->" + getJogadas()
                + "/ Tipo da peça->" + getTipo() + "/ Quantidade de moedas->" + getMoedas();
    }
}
