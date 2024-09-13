package JavaFx;

public class CasaSorteFactory implements CasaFactory {

    @Override
    public Casa criarCasa(int numCasa) {
        return new CasaSorte(numCasa);
    }

}
