package JavaFx;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {

    // Atributos
    private ArrayList<Jogador> jogadoresList = new ArrayList();
    private int quantidadeJogadores;
    private Jogador[] casas = new Jogador[40];

    public Tabuleiro(int quantidadeJogadores) {
        this.quantidadeJogadores = quantidadeJogadores;
    }

    // Métodos
    public void adicionarJogadores() {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        for (int i = 0; i < quantidadeJogadores; i++) {
            System.out.print("Insira o nome do jogador " + (i + 1) + " : ");
            String nome = teclado.nextLine();
            System.out.print("Insira a cor do jogador: ");
            String cor = teclado.nextLine();
            int testeTipo = random.nextInt(3) + 1;
            switch (testeTipo) {
                case 1 -> {
                    Jogador x = new JogadorAzarado(nome, cor, 0, 0);
                    jogadoresList.add(x);
                }
                case 2 -> {
                    Jogador x = new JogadorComun(nome, cor, 0, 0);
                    jogadoresList.add(x);
                }
                default -> {
                    Jogador x = new JogadorSortudo(nome, cor, 0, 0);
                    jogadoresList.add(x);
                }
            }
        }
    }

    public boolean VerificaCasa(Jogador jogador) {

        switch (jogador.getPosicao()) {
            case 10, 25, 38 -> {
                System.out.println("Casa Especial - Não pode jogar na próxima rodada");
                NaoJoga(jogador);
                return true;
            }
            case 13 -> {
                System.out.println("Casa Especial - Trocar tipo de peça");
                Jogador novoJogador = puxarCartaAleatoria(jogador);
                trocaPeca(novoJogador, jogador);
                Tela hud = new Tela(this);
                System.out.println("Peça antiga: ");
                hud.HudSimples(jogador);
                System.out.println("Nova peça: ");
                hud.HudSimples(novoJogador);
                return true;
            }
            case 5, 15, 30 -> {
                System.out.println("Casa Especial - Andar três casas para frente");
                AndarPraFrente(jogador);
                return true;
            }
            case 17, 27 -> {
                System.out.println("Casa Especial - Manda um jogador para o início do jogo");
                System.out.println("Qual jogador você deseja mandar para o início do jogo?");
                int i = 0;
                for (Jogador x : jogadoresList) {
                    System.out.println(i + ". " + x.getNome() + " -  " + x.getCor());
                    i++;
                }
                Scanner teclado = new Scanner(System.in);
                int qualJogadorLascar = teclado.nextInt();
                mandarJogadorAbaixo(jogadoresList.get(qualJogadorLascar));

                return true;

            }
            case 20, 35 -> {
                System.out.println("Casa Especial - Trocar de lugar com o jogador mais atrás");
                Jogador maisAtras = QuemTaMaisAtras();
                if (maisAtras == null) {
                    System.out.println("Não tem jogador mais atrás");
                    return true;
                } else {
                    trocarComUltimoJogador(jogador, maisAtras);
                    return true;
                }

            }
            default -> {
                System.out.println("Não caiu em nenhuma casa especial");
                return false;
            }
        }

    }

    public void NaoJoga(Jogador jogador) {
        jogador.setPodeJogar(false);

    }

    public Jogador puxarCartaAleatoria(Jogador jogador) {
        Random random = new Random();
        int CartaAleatoria = random.nextInt(3) + 1;
        switch (CartaAleatoria) {
            case 1 -> {
                Jogador novoJogador = new JogadorAzarado(jogador.getNome(), jogador.getCor(), jogador.getPosicao(),
                        jogador.getJogadas());
                return novoJogador;
            }
            case 2 -> {
                Jogador novoJogador = new JogadorSortudo(jogador.getNome(), jogador.getCor(), jogador.getPosicao(),
                        jogador.getJogadas());
                return novoJogador;
            }
            default -> {
                Jogador novoJogador = new JogadorComun(jogador.getNome(), jogador.getCor(), jogador.getPosicao(),
                        jogador.getJogadas());
                return novoJogador;
            }
        }

    }

    public void trocaPeca(Jogador jogadorNovo, Jogador jogadorAntigo) {
        int indice = 0;
        for (Jogador x : jogadoresList) {
            if (x.getCor().equals(jogadorAntigo.getCor())) {
                break;
            }
            indice++;
        }

        jogadoresList.set(indice, jogadorNovo);
    }

    public void AndarPraFrente(Jogador jogador) {
        if (jogador.getTipo().equals("azarado")) {
            System.out.println("Não vai poder andar porque é um azarado");
        } else {
            System.out.println("Andando três casas para frente");
            System.out.println("Posição antiga: " + jogador.getPosicao());
            AndarNoTabuleiro(jogador, 3);
            jogador.mover(3);
            System.out.println("Posição atual: " + jogador.getPosicao());

        }

    }

    public void mandarJogadorAbaixo(Jogador jogador) {
        System.out.println("Posição antiga da peça " + jogador.getCor() + ": " + jogador.getPosicao());
        AndarNoTabuleiro(jogador, 0);
        jogador.setPosicao(0);
        System.out.println("Posição nova da peça " + jogador.getCor() + ": " + jogador.getPosicao());
    }

    public void trocarComUltimoJogador(Jogador jogador, Jogador maisAtras) {
        int aux = jogador.getPosicao();
        AndarNoTabuleiro(jogador, maisAtras.getPosicao());
        jogador.setPosicao(maisAtras.getPosicao());

        AndarNoTabuleiro(maisAtras, jogador.getPosicao());
        maisAtras.setPosicao(aux);

        System.out.println("Nova posição da peça " + jogador.getCor() + ": " + jogador.getPosicao());
        System.out.println("Nova posição da peça " + maisAtras.getCor() + ": " + maisAtras.getPosicao());

    }

    public Jogador QuemTaMaisAtras() {
        int maisAtras = Integer.MAX_VALUE;
        for (Jogador x : jogadoresList) {
            if (x.getPosicao() < maisAtras) {
                maisAtras = x.getPosicao();
            }
        }
        for (Jogador x : jogadoresList) {
            if (x.getPosicao() == maisAtras) {
                return x;
            }
        }
        return null;
    }

    public Jogador PegarJogadores(Jogador jogador) {
        for (Jogador x : jogadoresList) {
            if (x.getCor().equals(jogador.getCor())) {
                return x;
            }
        }
        return null;
    }

    public ArrayList<Jogador> getJogadoresList() {
        return jogadoresList;
    }

    public void AndarNoTabuleiro(Jogador jogador, int casasAndadas) {
        casas[casasAndadas] = jogador;

    }
}
