package JavaFx;

public class CasaTrocaFactory implements CasaFactory {

    @Override
    public Casa criarCasa(int numCasa) {
        return new CasaTroca(numCasa);
    }

}
