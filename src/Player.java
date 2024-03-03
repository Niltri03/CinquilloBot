import java.sql.Array;
import java.util.ArrayList;

public class Player {

    private Partida game;
    private ArrayList<Carta> mano = new ArrayList<Carta>();
    private ArrayList<Carta> jugables = new ArrayList<Carta>();

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
            return mano.get(patronIA.juegaCarta(mano, game));
        }
    }

    private void jugables(){
        ArrayList<Carta> tab = game.getTablero();
        for(int i = 0; i < tab.size(); ++i){

        }
    }

    private void turno(){
        jugables();
        Carta jugada;
        if(patronIA != null) jugada = jugables.get(patronIA.juegaCarta(jugables, game));
        else;
    }

    public Character calcCincos() {
        Character c;
        Integer ret = 0;
        for(int i = 0; i < mano.size(); ++i){
            Carta act = mano.get(i);
            if(act.getNum() == 5) ret++;
        }
        return Integer.toString(ret).charAt(0);
    }

    public Character calcReyes(){
        Character c;
        Integer ret = 0;
        for(int i = 0; i < mano.size(); ++i){
            Carta act = mano.get(i);
            if(act.getNum() == 10) ret++;
        }
        return Integer.toString(ret).charAt(0);
    }

    public Character calcOtros() {
        Character c;
        Integer ret = 0;
        for(int i = 0; i < mano.size(); ++i){
            Carta act = mano.get(i);
            if(act.getNum() == 9 || act.getNum() == 8) ret++;
        }
        return Integer.toString(ret).charAt(0);
    }

    public boolean primerMove() {
        for(int i = 0; i < mano.size(); ++i){
            Carta c = mano.get(i);
            if(c.getPalo() == 'O' && c.getNum() == 5) return true;
        }
        return false;
    }
}
