import java.util.ArrayList;
import java.util.Random;


public class RandomAI implements AI{
    Random seed = new Random();
    public int juegaCarta(ArrayList<Carta> mano, Partida p){
        return seed.nextInt(mano.size());
    }

}
