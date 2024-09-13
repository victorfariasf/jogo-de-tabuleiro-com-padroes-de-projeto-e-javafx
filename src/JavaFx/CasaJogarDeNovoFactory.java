package JavaFx;

public class CasaJogarDeNovoFactory implements CasaFactory {

    @Override
    public Casa criarCasa(int numCasa) {
        return new CasaJogarDeNovo(numCasa);
    }

}
