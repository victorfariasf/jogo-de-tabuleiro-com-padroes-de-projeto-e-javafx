package JavaFx;

public class CasaSurpresaFactory implements CasaFactory {

    @Override
    public Casa criarCasa(int numCasa) {
        return new CasaSurpresa(numCasa);
    }

}
