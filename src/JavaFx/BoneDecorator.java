package JavaFx;

public class BoneDecorator extends JogadorDecorator {
    public BoneDecorator(Jogador jogador) {
        super(jogador);
    }

    @Override
    public String getDescricao() {
        return jogador.getDescricao() + ", bone";
    }
}
