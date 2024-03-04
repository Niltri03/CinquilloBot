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

    public Carta juegaCarta(int jugada){
        if(patronIA == null){
            //el player hace algo
            return null;
        }
        else{
            Carta aux = jugables.get(jugada);
            heJugado(aux.getNum(), aux.getPalo());
            game.jugada(aux);
            return aux;
        }
    }

    private void jugables(){
        jugables = new ArrayList<>();
        ArrayList<Carta> tab = game.getTablero();
        for(int i = 0; i < mano.size(); ++i){
            if (mano.get(i).getNum() == 5) jugables.add(mano.get(i));
            else {

            }
        }
    }

    private void heJugado(Integer a, Character b){
        for(int i = 0; i < mano.size(); ++i){
            Carta aux = mano.get(i);
            if(aux.getPalo() == b && aux.getNum() == a){
                mano.remove(i);
            }
        }

    }

    public int turno(){
        jugables();
        Carta jugada;
        if(patronIA != null) return (patronIA.juegaCarta(jugables));
        else return -1;
    }

    public boolean done(){
        return mano.size() == 0;
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
            if(c.getPalo() == 'O' && c.getNum() == 5){
                heJugado(5, 'O');
                game.jugada(mano.get(i));
                return true;
            }
        }
        return false;
    }
}
