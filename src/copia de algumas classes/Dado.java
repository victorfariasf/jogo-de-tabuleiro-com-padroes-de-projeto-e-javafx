import java.util.Random;

public class Dado {
    public int rolarDados() {
        Random randomizerInt = new Random();
        return randomizerInt.nextInt(6) + 1;
    }
}
