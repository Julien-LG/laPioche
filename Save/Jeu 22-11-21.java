import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Jeu {
    ArrayList<Carte> pioche = new ArrayList<>();
    /*ArrayList<Carte> joueur1 = new ArrayList<>();
    ArrayList<Carte> joueur2 = new ArrayList<>();

    public enum joueur {
        joueur1, joueur2;
    }*/
    Joueur joueur1 = new Joueur(1);
    Joueur joueur2 = new Joueur(2);

    public int nbCartesParJoueur = 5;

    Random random = new Random();


    //Génération de l'ensemble du jeu de carte
    public Jeu() {
        //Crée un tableau des nombres possibles
        Carte.numero[] numeros = Carte.numero.values();

        //Crée la pioche avec un jeu de 52 cartes
        for (Carte.numero n: numeros) {
            pioche.add(new Carte(n, Carte.couleur.trefle));
        }
        for (Carte.numero n: numeros) {
            pioche.add(new Carte(n, Carte.couleur.pique));
        }
        for (Carte.numero n: numeros) {
            pioche.add(new Carte(n, Carte.couleur.carreau));
        }
        for (Carte.numero n: numeros) {
            pioche.add(new Carte(n, Carte.couleur.coeur));
        }
        /*for (Carte c: pioche) {
            System.out.println(c);
        }*/
        /*System.out.println(random.nextInt(3));
        System.out.println(random.nextInt(3));
        System.out.println(random.nextInt(3));*/
        distributionCartes();
        /*for (Carte c: joueur1.getMain()) {
            System.out.println(c);
        }*/
    }

    //Distribution de 5? cartes random (de la pioche) à chaques joueur
    public void distributionCartes() {
        //pioche.
        //Carte carte = pioche.get(random.nextInt(pioche.size()));
        /*System.out.println(pioche.size());
        for (int i = 0; i < nbCartesParJoueur; i++) {
            Carte carte = pioche.get(random.nextInt(pioche.size()));
            joueur1.getMain().add(carte);
            pioche.remove(carte);
        }
        System.out.println(pioche.size());
        for (int i = 0; i < nbCartesParJoueur; i++) {
            Carte carte = pioche.get(random.nextInt(pioche.size()));
            joueur2.getMain().add(carte);
            pioche.remove(carte);
        }
        System.out.println(pioche.size());*/

        //System.out.println(pioche.size());
        for (int i = 0; i < nbCartesParJoueur; i++) {
            Carte carte = pioche.get(random.nextInt(pioche.size()));
            joueur1.ajouteCarte(carte);
            pioche.remove(carte);
        }
        //System.out.println(pioche.size());
        for (int i = 0; i < nbCartesParJoueur; i++) {
            Carte carte = pioche.get(random.nextInt(pioche.size()));
            joueur2.ajouteCarte(carte);
            pioche.remove(carte);
        }
        //System.out.println(pioche.size());

    }

    public void afficheCartes(Joueur j) {
        System.out.println("Liste des cartes du joueur " + j.getNum() + " :" );
        for (Carte c : j.getMain()){
            System.out.println(c);
        }
    }

    /**
     * Le joueur pioche une carte
     * @param j le joueur qui doit piocher une carte
     */
    public void pioche(Joueur j) {
        Carte carte = pioche.get(random.nextInt(pioche.size()));
        /*if (j.getNum() == 1) {
            joueur1.getMain().add(carte);
            pioche.remove(carte);
        }
        else {
            joueur2.getMain().add(carte);
            pioche.remove(carte);
        }*/
        j.getMain().add(carte);
        pioche.remove(carte);
    }

    public ArrayList<Carte.numero> cartesDemandables(Joueur j) {
        ArrayList<Carte.numero> cartesDemandables = new ArrayList<>();
        /*if (j == joueur.joueur1) {
            for (Carte c: joueur1) {
                if (!cartesDemandables.contains(c.getNumero())) {
                    cartesDemandables.add(c.getNumero());
                }
            }
        }
        else {
            for (Carte c: joueur2) {
                if (!cartesDemandables.contains(c.getNumero())) {
                    cartesDemandables.add(c.getNumero());
                }
            }
        }*/
        for (Carte c: j.getMain()) {
            if (!cartesDemandables.contains(c.getNumero())) {
                cartesDemandables.add(c.getNumero());
            }
        }
        return cartesDemandables;
    }

    /**
     * Le joueur demande une carte à l'autre joueur
     * @param num le numero de la carte demandé
     * @param j1 le joueur qui demande une carte
     * @param j2 le joueur qui se voit demander une carte
     */
    public boolean demandeCarte(Carte.numero num, Joueur j1, Joueur j2) {
        //CREER une autre fonction car repetition
        // Et creer une classe joueur

        /*if (j == joueur.joueur1) {
            int nbCartesTrouvee = 0;
            for (Carte c : joueur2) {
                if (c.getNumero() == num) {
                    joueur1.add(c);
                    joueur2.remove(c);
                    nbCartesTrouvee++;
                }
            }
            System.out.println(nbCartesTrouvee + " cartes trouvée.");
        }
        else {
            int nbCartesTrouvee = 0;
            for (Carte c : joueur1) {
                if (c.getNumero() == num) {
                    joueur2.add(c);
                    joueur1.remove(c);
                    nbCartesTrouvee++;
                }
            }
            System.out.println(nbCartesTrouvee + " cartes trouvée.");
        }*/

        int nbCartesTrouvee = 0;
        for (Carte c : j2.getMain()) {
            if (c.getNumero() == num) {
                j1.getMain().add(c);
                j2.getMain().remove(c);
                nbCartesTrouvee++;
            }
        }

        if (nbCartesParJoueur != 0) {
            return true;
        }
        return false;
    }

    public boolean partieFinie() {
        //En fonction des points des joueurs
        return false;
    }

    public void tour(Joueur j){
        //On récupere l'info sur les cartes que le joueur j peut demander
        ArrayList<Carte.numero> cartesDemandables= cartesDemandables(j);

        //On affiche au joueur les cartes qu'il peut demander
        int num = 1;
        for (Carte.numero n : cartesDemandables) {
            System.out.println(num + " - " + n);
            num++;
        }
        boolean rejoue = false;
        while (!rejoue) {
            Scanner sc = new Scanner(System.in);
            int entree = 0;
            //while (!(entree > num && entree < num)) {
            while (entree >= num || entree <= 0) {
                System.out.println("Entrez le numero de la carte à demander ");
                entree = sc.nextInt();
                System.out.println("L'entree est : " + entree);
                if (entree < num && entree > 0) {
                    System.out.println("L'entrée clavier est ok");
                    //rejoue = true;
                }
            }

            rejoue = demandeCarte(cartesDemandables.get(entree-1), joueur1, joueur2);

            /*while (etat) {

            }*/
            //cartesDemandables.get(entree-1);
            /*
            if (joueur1.getMain().contains((Carte.numero)entree)) {
                demandeCarte((Carte.numero)entree, j);
            }*/
        }

    }
}
