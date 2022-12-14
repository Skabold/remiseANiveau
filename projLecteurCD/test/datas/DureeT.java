/**
 * @author Linz Pierre
 * @file DureeT.java
 * @brief test of datas/Duree.java
 */
package test.datas;
import datas.Duree;
public class DureeT {
    public static void main(String[] args) {
        testConstructor();
        testConstructor2();
        testSetter();
        testSetter2();
        testAjoute();
        testAjoute2();
        testCompare();
        testEnTexte();
        
    }

    private static void testEnTexte() {
        //enTexte
        System.out.println("_________________________________________");
        Duree myDuree7 = new Duree(172800000 + 3600000);
        System.out.println("Sould be 2 days and 1 hour:");
        System.out.println(myDuree7.enTexte('J'));
        myDuree7.setLeTemps(3600000 + 60000 + 1000);
        System.out.println("Sould be 1h1m1s :");
        System.out.println(myDuree7.enTexte('H'));
        myDuree7.setLeTemps(1000 + 1);
        System.out.println("Sould be 1s1m :");
        System.out.println(myDuree7.enTexte('S'));
        myDuree7.setLeTemps(1);
        System.out.println("Sould be 1 :");
        System.out.println(myDuree7.enTexte('M'));
        System.out.println("_________________________________________");
    }

    private static void testCompare() {
        //compare
        long temps = 1000000000;
        Duree myDuree = new Duree(temps);
        Duree myDuree6 = new Duree(0);
        System.out.println("Test compare (duree)");
        if(myDuree.compareA(myDuree6) == 1) {
            System.out.println("Test compare (duree) OK");
        } else {
            System.out.println("Test compare (duree) FAIL");
        }
        System.out.println("Test compare (duree)");
        if(myDuree6.compareA(myDuree6) == 0) {
            System.out.println("Test compare (duree) OK");
        } else {
            System.out.println("Test compare (duree) FAIL");
        }
        System.out.println("Test compare (duree)");
        if(myDuree6.compareA(myDuree) == -1) {
            System.out.println("Test compare (duree) OK");
        } else {
            System.out.println("Test compare (duree) FAIL");
        }
    }

    private static void testAjoute2() {
        //ajoute :
        Duree myDuree5 = new Duree(2);
        Duree myDuree6 = new Duree(0);
        myDuree5.ajoute(myDuree6);
        System.out.println("Test ajoute (temps)");
        if (myDuree5.getLeTemps() == 2) {
            System.out.println("Test ajoute (temps) OK");
        } else {
            System.out.println("Test ajoute (temps) FAIL");
        }
        
    }

    private static void testAjoute() {
        //ajoute :
        Duree myDuree5 = new Duree(2);
        myDuree5.ajoute(myDuree5);
        System.out.println("Test ajoute (temps)");
        if (myDuree5.getLeTemps() == 4) {
            System.out.println("Test ajoute (temps) OK");
        } else {
            System.out.println("Test ajoute (temps) FAIL");
        }
    }

    private static void testSetter2() {
        long temps = 1000000000;
        Duree myDuree3 = new Duree(temps);
        System.out.println("Test setLeTemps (erreur)");
        try {
            myDuree3.setLeTemps(-1);
            System.out.println("Test setLeTemps (erreur) FAIL");
        } catch (IllegalArgumentException e) {
            System.out.println("Test setLeTemps (erreur) OK");

        }
    }

    private static void testSetter() {
        //test accesseurs :
        long temps = 1000000000;
        Duree myDuree3 = new Duree(temps);
        System.out.println("Test setLeTemps (temps)");
        myDuree3.setLeTemps(1);
        if (myDuree3.getLeTemps() == 1) {
            System.out.println("Test setLeTemps (temps) OK");
        } else {
            System.out.println("Test setLeTemps (temps) FAIL");
        }

    }

    private static void testConstructor2() {
        long temps = 1000000000;
        Duree myDuree2 = new Duree(temps);
        Duree myDuree = new Duree (myDuree2);
        System.out.println("Test constructeur (Duree)");
        if (myDuree.getLeTemps() == temps) {
            System.out.println("Test constructeur (Duree) OK");
        } else {
            System.out.println("Test constructeur (Duree) FAIL");
        }

        System.out.println("Test constructeur (erreur)");
        try {
            Duree myDuree4 = new Duree(-1);
            System.out.println("Test constructeur (erreur) FAIL");
        } catch (IllegalArgumentException e) {
            System.out.println("Test constructeur (erreur) OK");
        }
    }

    private static void testConstructor() {
        //Tests constructor :
        long temps = 1000000000;
        Duree myDuree = new Duree(temps);
        System.out.println("Test constructeur (milisec)");
        if (myDuree.getLeTemps() == temps) {
            System.out.println("Test constructeur (milisec) OK");
        } else {
            System.out.println("Test constructeur (milisec) FAIL");
        }
        int h = 1;
        int m = 1;
        int s = 1;
        myDuree = new Duree (h,m,s);
        System.out.println("Test constructeur (h,m,s)");
        if (myDuree.getLeTemps() == 3600000 + 60000 + 1000) {
            System.out.println("Test constructeur (h,m,s) OK");
        } else {
            System.out.println("Test constructeur (h,m,s) FAIL");
            System.out.println(myDuree.getLeTemps());
        }
    }
}

        
    
