import java.util.ArrayList;

public class Joueur {
    private int num;
    private ArrayList<Carte> main = new ArrayList<>();

    public Joueur(int numero) {
        this.num = numero;
    }

    public int getNum() {
        return num;
    }

    public ArrayList<Carte> getMain() {
        return this.main;
    }

    public void ajouteCarte(Carte c) {
        main.add(c);
    }

    public void retireCarte(Carte c) {
        main.remove(c);
    }
}
