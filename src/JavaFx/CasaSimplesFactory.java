package JavaFx;

public class CasaSimplesFactory implements CasaFactory {

    @Override
    public Casa criarCasa(int numCasa) {
        return new CasaSimples(numCasa);
    }
}
