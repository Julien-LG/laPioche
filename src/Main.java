public class Main {


    public static void main(String[] args) {
        Jeu partie = new Jeu();

        /*while(!partie.partieFinie()) {
            partie.afficheCartes(partie.joueur1);
        }*/
        partie.afficheCartes(partie.joueur1);
        partie.afficheCartes(partie.joueur2);
        partie.tour(partie.joueur1);
        partie.afficheCartes(partie.joueur1);
        partie.afficheCartes(partie.joueur2);
    }
}
