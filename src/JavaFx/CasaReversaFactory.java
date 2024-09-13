package JavaFx;

public class CasaReversaFactory implements CasaFactory {
    @Override
    public Casa criarCasa(int numCasa) {
        return new CasaReversa(numCasa);
    }

}
