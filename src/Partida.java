import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

public class Partida {

    //Instancia típica de un Singleton
    private static Partida instance;
    //Mazo inicial
    private ArrayList<Carta> mazo = new ArrayList<Carta>();

    //Tablero. Tan solo analiza las cartas más altas y bajas de la posición. 
    private ArrayList<Carta> tablero = new ArrayList<Carta>();
    private Random rand = new Random();
    private Partida(){
        initMazo();
    }

    public void reset(){
        initMazo();
    }
    private void initMazo(){
        for(int i = 1; i <= 10; ++i){
            Carta c = new Carta(i, 'O');
            mazo.add(c);
            c = new Carta(i, 'C');
            mazo.add(c);
            c = new Carta(i, 'E');
            mazo.add(c);
            c = new Carta(i, 'B');
            mazo.add(c);
        }
        Carta aux = new Carta(0, 'x');
        for(int i = 0; i < 8; ++i){
            tablero.add(aux);
        }
    }
    public static Partida getInstance(){
        if(instance == null) instance = new Partida();
        return instance;
    }
    public Carta robaCarta(){
        int rng = rand.nextInt(mazo.size());
        Carta c = mazo.get(rng);
        mazo.remove(rng);
        return c;
    }

    public void dimeSize(){
        System.out.println(mazo.size());
    }


    public ArrayList<Carta> getTablero() {
        return tablero;
    }

    public boolean notFinished(Player p1, Player p2) {
        return p1.done() || p2.done();
    }

    public void jugada(Carta c){
        if(c.getPalo() == 'O'){
            if(c.getNum() == 5){
                tablero.set(0, c);
                tablero.set(1, c);
            }
            else if (c.getNum() < tablero.get(0).getNum()){
                tablero.set(0, c);
            }
            else tablero.set(1, c);
        }
        if(c.getPalo() == 'C'){
            if(c.getNum() == 5){
                tablero.set(2, c);
                tablero.set(3, c);
            }
            else if (c.getNum() < tablero.get(2).getNum()){
                tablero.set(2, c);
            }
            else tablero.set(3, c);
        }
        if(c.getPalo() == 'E'){
            if(c.getNum() == 5){
                tablero.set(4, c);
                tablero.set(5, c);
            }
            else if (c.getNum() < tablero.get(4).getNum()){
                tablero.set(4, c);
            }
            else tablero.set(5, c);
        }
        else{
            if(c.getNum() == 5){
                tablero.set(6, c);
                tablero.set(7, c);
            }
            else if (c.getNum() < tablero.get(6).getNum()){
                tablero.set(6, c);
            }
            else tablero.set(7, c);
        }
    }

    public void writeTablero(){
        tablero.get(0).escribe();
        tablero.get(1).escribe();
        tablero.get(2).escribe();
        System.out.println("-------------");
        System.out.println(tablero.get(1).getNum() + "" + tablero.get(1).getPalo() + " - " + tablero.get(3).getNum() + tablero.get(3).getPalo() + " - " + tablero.get(5).getNum() + tablero.get(5).getPalo() + " - " + tablero.get(7).getNum() + tablero.get(7).getPalo());
        System.out.println("   ----------      ");
        System.out.println(tablero.get(0).getNum() + "" + tablero.get(0).getPalo() + " - " + tablero.get(2).getNum() + tablero.get(2).getPalo() + " - " + tablero.get(4).getNum() + tablero.get(4).getPalo() + " - " + tablero.get(6).getNum() + tablero.get(6).getPalo());
        System.out.println("-------------");
    }
}
