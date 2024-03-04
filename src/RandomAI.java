import java.util.ArrayList;
import java.util.Random;


public class RandomAI implements AI{
    Random seed = new Random();
    public int juegaCarta(ArrayList<Carta> mano){
        if(mano.size() == 0) return -1;
        return seed.nextInt(mano.size());
    }

}
