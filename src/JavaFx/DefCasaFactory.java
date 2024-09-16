package JavaFx;

public class DefCasaFactory {
    public static Casa novaCasa(int i, int indiceDaCasa) {
        switch (i) {
            case 1 -> {
                return new CasaSimples(indiceDaCasa);
            }
            case 2 -> {
                return new CasaSurpresa(indiceDaCasa);
            }
            case 3 -> {
                return new CasaPrisao(indiceDaCasa);
            }
            case 4 -> {
                return new CasaSorte(indiceDaCasa);
            }
            case 5 -> {
                return new CasaAzar(indiceDaCasa);
            }
            case 6 -> {
                return new CasaReversa(indiceDaCasa);
            }
            case 7 -> {
                return new CasaJogarDeNovo(indiceDaCasa);
            }
            case 8 -> {
                return new CasaTroca(indiceDaCasa);
            }
            default -> {
                return new CasaSimples(indiceDaCasa);
            }
        }
    }
}