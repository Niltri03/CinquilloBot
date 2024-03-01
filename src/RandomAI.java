import java.util.ArrayList;
import java.util.Random;


public class RandomAI implements AI{
    Random seed = new Random();
    public Carta juegaCarta(ArrayList<Carta> mano, Partida p){
        return mano.get(seed.nextInt(mano.size()));
    }

}
