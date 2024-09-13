public class JogadorComum extends Jogador {

    public JogadorComum(String name, String color, int position, String type) {
        super(name, color, position, type);
    }

    @Override
    public boolean jogadaValida(int dicesSum) {
        return true;
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
