public class Carta {
    private Integer num;
    private Character palo;

    public Carta(Integer a, Character c){
        num = a;
        palo = c;
    }
    public void escribe(){
        System.out.println("Carta: " + num + " de " + palo() + ".");
    }

    public String palo(){
        if(palo == 'O') return "Oros";
        else if (palo == 'C') return "Copas";
        else if (palo == 'E') return "Espadas";
        else return "Bastos";
    }
}
