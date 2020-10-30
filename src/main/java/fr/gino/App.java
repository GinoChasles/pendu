package fr.gino;

import java.util.Scanner;

/**
 * Hello world!
 */
public final class App {

  private App() {}

  /**
   * Says hello to the world.
   * @param args The arguments of the program.
   */
  public static void main(String[] args) {
    System.out.println("***************************");
    System.out.println("****** Jeux du Pendu ******");
    System.out.println("***************************");
    System.out.println("***** Moins de points *****");
    System.out.println("******** tu auras *********");
    System.out.println("****** Mieux ce sera ******");
    System.out.println("***************************");
    System.out.println("***************************");

    //init tableau de mots
    String[] listeDeMots = { "css", "html", "diagramme", "linux", "windows" };

    boolean victory = false;
    int nbErreur = 0;
    //choix random dans la liste de mots
    String motCache = listeDeMots[(int) (Math.random() * listeDeMots.length)];

    //transformation des caractères du mot en underscore
    char[] tabMotCache = new char[motCache.length()];
    for (int i = 0; i < motCache.length(); i++) {
      tabMotCache[i] = '_';
    }
    System.out.println(
      "Le mot caché contient " + motCache.length() + " lettres."
    );
    System.out.println(tabMotCache);

    Scanner lettre = new Scanner(System.in);
    while ((victory == false) || (nbErreur <= 7)) {
      String lettreChoisie = lettre.next();

      System.out.println("Veuillez saisir une lettre !");
      // prend la première lettre saisi par l'user
      if (lettreChoisie.length() > 1) {
        lettreChoisie = lettreChoisie.substring(0, 1);
      }
      // si la lettre tapée est dans le mot remplace l'underscore par la lettre
      // et répète l'occurence pour plusieurs fois la même lettre dans le mot
      if (motCache.contains(lettreChoisie)) {
        int index = motCache.indexOf(lettreChoisie);

        while (index >= 0) {
          tabMotCache[index] = lettreChoisie.charAt(0);
          index = motCache.indexOf(lettreChoisie, index + 1);
          System.out.println(tabMotCache);
        }
      } else {
        nbErreur++;
        System.out.println("Tu as commis " + nbErreur + " erreurs..");
        System.out.println("Il te reste " + (7 - nbErreur) + " essais !");
        System.out.println(tabMotCache);
      }

      // on récupère le tableau de caractère en string  pour vérifier l'égalité
      // avec le mot caché et déclarer la victoire
      String motDeviner = new String(tabMotCache);
      if (motDeviner.equals(motCache)) {
        victory = true;
        System.out.println("You win !");
        System.out.println("Tu as commis " + nbErreur + " erreur !");
        System.out.println("Tu as obtenu " + (nbErreur * 5) + " points !");
        break;
      }
      if (nbErreur == 7) {
        System.out.println(
          "You looose ! Le mot à deviner était : " + motCache + " !"
        );
        System.out.println("Tu as obtenu " + (nbErreur * 5) + " points !");
        break;
      }
    }
    lettre.close();
  }
}
