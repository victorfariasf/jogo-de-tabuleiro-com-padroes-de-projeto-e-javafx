package JavaFx;

public class MoletonDecorator extends JogadorDecorator {
    public MoletonDecorator(Jogador jogador) {
        super(jogador);
    }

    @Override
    public String getDescricao() {
        return jogador.getDescricao() + ", moleton";
    }

}
