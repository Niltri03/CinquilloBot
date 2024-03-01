public class Carta {
    private final Integer num;
    private final Character palo;

    public Carta(Integer a, Character c){
        num = a;
        palo = c;
    }
    public void escribe(){
        System.out.println("Carta: " + num + " de " + palo() + ".");
    }

    private String palo(){
        if(palo == 'O') return "Oros";
        else if (palo == 'C') return "Copas";
        else if (palo == 'E') return "Espadas";
        else return "Bastos";
    }

    public char getPalo(){
        return palo;
    }
    public Integer getNum(){
        return num;
    }
}
