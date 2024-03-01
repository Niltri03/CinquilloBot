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
}
