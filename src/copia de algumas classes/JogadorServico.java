import java.util.Random;

public class JogadorServico {

    public Jogador criarJogador(String name, String color) {
        Random randomizerInt = new Random();
        int jogadorTipo = randomizerInt.nextInt(3) + 1;
        System.out.println(jogadorTipo);
        switch (jogadorTipo) {
            case 1 -> {
                return new JogadorComum(name, color, 0, "Comum");
            }
            case 2 -> {
                return new JogadorAzarado(name, color, 0, "Azarado");
            }
            case 3 -> {
                return new JogadorSortudo(name, color, 0, "Sortudo");

            }
            default -> {
                return new JogadorComum(name, color, 0, "Comum");
            }

        }

    }
}
