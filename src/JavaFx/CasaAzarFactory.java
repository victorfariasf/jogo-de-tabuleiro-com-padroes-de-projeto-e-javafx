package JavaFx;

public class CasaAzarFactory implements CasaFactory {

    @Override
    public Casa criarCasa(int numCasa) {
        return new CasaAzar(numCasa);
    }

}
