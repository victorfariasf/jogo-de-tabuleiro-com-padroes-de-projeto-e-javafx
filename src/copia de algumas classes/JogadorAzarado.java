public class JogadorAzarado extends Jogador {

    public JogadorAzarado(String name, String color, int position, String type) {
        super(name, color, position, type);
    }

    @Override
    public boolean jogadaValida(int dicesSum) {
        if (dicesSum > 6) {
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
