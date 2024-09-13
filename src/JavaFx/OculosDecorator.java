package JavaFx;

public class OculosDecorator extends JogadorDecorator {
    public OculosDecorator(Jogador jogador) {
        super(jogador);
    }

    @Override
    public String getDescricao() {
        return jogador.getDescricao() + ", oculos";
    }
}
