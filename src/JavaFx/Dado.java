package JavaFx;

import java.util.Random;


public class Dado {
    // Atributos
    private int lado;
    private Random random = new Random();

    public Dado(int lado){
        this.lado = lado;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public int rolarDado(){
        return random.nextInt(lado) + 1;
    }
}
