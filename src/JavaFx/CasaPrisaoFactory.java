package JavaFx;

public class CasaPrisaoFactory implements CasaFactory {

    @Override
    public Casa criarCasa(int numCasa) {
        return new CasaPrisao(numCasa);
    }

}
