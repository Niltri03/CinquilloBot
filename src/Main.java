import java.util.ArrayList;


public class Main {

    static final Integer NUM_GAMES = 1;
    public static void main(String[] args) {
        Partida game = Partida.getInstance();
        int turno;



        //start singleton

        for(int gameID = 0; gameID < NUM_GAMES; ++gameID){//Jugamos la cantidad de games deseada.
            System.out.println("PARTIDA " + gameID + ":");

            //cada string de este arraylist tiene las estadisticas de una partida:
            //Los índices pares (0 incluido) corresponden a estadísticas de J1.
            //Los índices impares corresponden a estadísticas de J2.
            //(0,1) -> Número de 5s en la mano inicial.
            //(2,3) -> Número de reyes en la mano inicial.
            //(4,5) -> Número de otras figuras en la mano inicial.
            //(6) -> Quien tiene el 5 de oros? ( 1 o 2 )
            //(7) -> Ganador de la partida. ( 1 o 2 )
            ArrayList<String> estadisticas = new ArrayList<>();

            //Creamos dos players
            Player p1 = new Player(game, new RandomAI());
            Player p2 = new Player(game, new RandomAI());
            //Dividimos el mazo en 2 partes aleatorias
            p1.roba20();
            p2.roba20();

            game.writeTablero();
            String curRes = calculosIniciales(p1, p2);

            //El 5 de oros comienza.
            Carta coros = new Carta(5, 'O');
            if(p1.primerMove()){
                curRes += '1';
                turno = -1;
            }
            else{
                curRes += '2';
                turno = 1;
            }
            game.writeTablero();
            while(game.notFinished(p1, p2)){
                if(turno == 1){
                    turno = p1.turno();
                    if (turno != -1) p1.juegaCarta(turno);
                }
                else{

                }
                turno *= -1;
            }


            System.out.println("PARTIDA " + gameID + ": " + curRes);
            game.reset();

        }

    }

    //Hace los cálculos iniciales de las estadísticas.
    private static String calculosIniciales(Player p1, Player p2) {
        Character c;
        String s = new String();
        c = p1.calcCincos();
        s += c;
        c = p2.calcCincos();
        s += c;
        c = p1.calcReyes();
        s += c;
        c = p2.calcReyes();
        s += c;
        c = p1.calcOtros();
        s += c;
        c = p2.calcOtros();
        s += c;
        return s;
    }
}