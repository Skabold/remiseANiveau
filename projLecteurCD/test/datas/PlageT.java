/**
 * @author Linz Pierre
 * @file PlageT.java
 * @brief test of datas/Plage.java
 */
package test.datas;
import datas.Plage;
import datas.Duree;
public class PlageT {
    public static void main(String[] args) {

        testConstructorAndGetter1();
        testConstructorAndGetter2();
        testConstructorAndGetter3();
        testConstructorAndGetter4();
        testConstructorAndGetter5();
        testSetter();
        testToSting();

    }

    private static void testToSting() {
        Duree myDuree = new Duree(1000);
        Plage myPlage = new Plage("toto", "tata", myDuree);
        System.out.println("test toString");
        System.out.println("Should be : Titre : upd Interprète : upd2 : Duree : 1.1");
        System.out.println(myPlage.toString());
    }

    private static void testSetter() {
        System.out.println("test setters");
        Duree myDuree = new Duree(1000);
        Plage myPlage = new Plage("toto", "tata", myDuree);
        myPlage.setLeTitre("upd");
        myPlage.setInterprete("upd2");
        myDuree.setLeTemps(1001);
        myPlage.setLaDuree(myDuree);
        if (myPlage.getInterprete()=="upd2" &&
            myPlage.getLaDuree().compareA(myDuree) == 0 &&
            myPlage.getLeTitre()=="upd") {
                
            System.out.println("test setters OK");
        } else {
            System.out.println("test setters FAIL");
        }
    }

    private static void testConstructorAndGetter1() {
        try {
            System.out.println("test constructor and getter (ok)");
            Duree myDuree = new Duree(1000);
            Plage myPlage = new Plage("toto", "tata", myDuree);
            if(myPlage.getInterprete() == "tata" &&
            myPlage.getLaDuree().compareA(myDuree) == 0 &&
            myPlage.getLeTitre() == "toto") {
                System.out.println("test constructor and getter OK");
            } else {
                System.out.println("test constructor and getter FAIL");
            }
        } catch (IllegalArgumentException e){
            System.out.println("test constructor and getter FAIL");
        }      

        
    }
    private static void testConstructorAndGetter2() {
        try {
            System.out.println("test constructor (erreur)");
            Duree myDuree = new Duree(1000);
            Plage myPlage2 = new Plage(null, "toto", myDuree);
            System.out.println("test constructor FAIL");
        } catch (IllegalArgumentException e){
            System.out.println("test constructor OK");
        }
    }


    private static void testConstructorAndGetter3() {
        try {
            System.out.println("test constructor (erreur)");
            Duree myDuree = new Duree(1000);
            Plage myPlage2 = new Plage("toto", "tata", null);
            System.out.println("test constructor FAIL");
        } catch (IllegalArgumentException e){
            System.out.println("test constructor OK");
        }
    }

    private static void testConstructorAndGetter4() {
        try {
            System.out.println("test constructor (erreur)");
            Duree myDuree = new Duree(1000);
            Plage myPlage2 = new Plage("toto", null, myDuree);
            System.out.println("test constructor FAIL");
        } catch (IllegalArgumentException e){
            System.out.println("test constructor OK");
        }
    }

    private static void testConstructorAndGetter5() {
        try {
            System.out.println("test constructor (erreur)");
            Plage myPlage2 = new Plage(null, null, null);
            System.out.println("test constructor FAIL");
        } catch (IllegalArgumentException e){
            System.out.println("test constructor OK");
        }
    }
}