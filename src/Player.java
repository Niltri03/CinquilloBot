import java.sql.Array;
import java.util.ArrayList;

public class Player {

    private Partida game;
    private ArrayList<Carta> mano = new ArrayList<Carta>();

    private AI patronIA;

    public Player(Partida p){
        game = p;
    }

    public Player(Partida p, AI patt){
        game = p;
        patronIA = patt;
    }
    public void roba20(){
        for(int i = 0; i < 20; ++i) mano.add(game.robaCarta());
    }

    public Carta juegaCarta(){
        if(patronIA == null){
            //el player hace algo
            return null;
        }
        else{
            return patronIA.juegaCarta(mano, game);
        }
    }
}
