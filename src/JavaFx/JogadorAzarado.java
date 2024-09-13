package JavaFx;

public class JogadorAzarado extends Jogador {

    // Métodos
    public JogadorAzarado(String nome, String cor, int posicao, int jogadas) {
        super(nome, cor, "azarado", posicao, jogadas);
    }

    @Override
    public int jogadarDados(Dado dado) {
        int dadoUm = dado.rolarDado();
        int dadoDois = dado.rolarDado();
        System.out.println("Dado 1 (" + dadoUm + ") - Dado 2 (" + dadoDois + ")");
        // verificaDadosIguais(dadoUm, dadoDois);
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
                System.out.println("Rolando os dados novamente porque os dados anteriores eram iguais");
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
            if (somaDosDados > 6) {
                System.out.println("Soma dos dados: " + somaDosDados);
                System.out.println("Valor dos dados maior que 6");
                return false;
            } else {
                return true;
            }
        } else {
            System.out.println("Jogador não pode jogar nessa rodada");
            return false;
        }
    }

    @Override
    public boolean validandoSomaDosDados(int dado1, int dado2) {
        if (dado1 + dado2 > 6) {
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
