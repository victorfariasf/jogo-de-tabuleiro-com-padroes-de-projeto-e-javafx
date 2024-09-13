public abstract class Jogador {
    protected String name;
    protected String color;
    protected int position;
    protected String type;

    public Jogador(String name, String color, int position, String type) {
        this.name = name;
        this.color = color;
        this.position = position;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract void andarNoJogo(int dicesSum);

    public abstract boolean jogadaValida(int dicesSum);

    public abstract String toString();
}
