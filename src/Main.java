public class Main {
    public static void main(String[] args) {
        //start singleton
        Partida game = Partida.getInstance();
        System.out.println("Jugadores IA? (0/1)");
        Player p1;
        int num = 0;
        //num = cin >> num;
        if(num == 1) {
            p1 = new Player(game);
        }
        else{
            p1 = new Player(game, new RandomAI());
        }
        Player p2 = new Player(game);
        p1.roba20();
        p2.roba20();

    }
}