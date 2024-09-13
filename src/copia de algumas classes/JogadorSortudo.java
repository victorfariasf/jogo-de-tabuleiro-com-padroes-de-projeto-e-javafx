public class JogadorSortudo extends Jogador {

    public JogadorSortudo(String name, String color, int position, String type) {
        super(name, color, position, type);
    }

    @Override
    public boolean jogadaValida(int dicesSum) {
        if (dicesSum < 7) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return getName() + " | " + getColor() + " | " + getPosition() + " | " + getType();
    }

    @Override
    public void andarNoJogo(int dicesSum) {
        int temp = getPosition();
        setPosition(temp + dicesSum);
    }

}
