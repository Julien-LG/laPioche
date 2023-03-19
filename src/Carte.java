public class Carte {
    public enum numero {
        //"as", "2", "3", "4", "5", "6", "7", "8", "9", "10", "valet", "dame", "roi";
        as, deux, trois, quatre, cinq, six, sept, huit, neuf, dix, valet, dame, roi;
    }
    private numero numero;
    //private String couleur;
    public enum couleur {
        trefle, carreau, coeur, pique;
    }

    private couleur couleur;

    public Carte(numero numero, couleur couleur) {
        this.numero = numero;
        this.couleur = couleur;
    }

    public Carte.numero getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        //return super.toString();
        return this.numero + " de " + this.couleur;
    }
}
