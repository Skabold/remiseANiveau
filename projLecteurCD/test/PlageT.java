/**
 * @author Linz Pierre
 * @file PlageT.java
 * @brief test of datas/Plage.java
 */
package test;
import datas.Plage;
import datas.Duree;
public class PlageT {
    public static void main(String[] args) {

        //tests constructor and getter
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

        try {
            System.out.println("test constructor (erreur)");
            Plage myPlage2 = new Plage(null, null, null);
            System.out.println("test constructor FAIL");
        } catch (IllegalArgumentException e){
            System.out.println("test constructor OK");
        }

        try {
            System.out.println("test constructor (erreur)");
            Duree myDuree = new Duree(1000);
            Plage myPlage2 = new Plage("toto", null, myDuree);
            System.out.println("test constructor FAIL");
        } catch (IllegalArgumentException e){
            System.out.println("test constructor OK");
        }

        try {
            System.out.println("test constructor (erreur)");
            Duree myDuree = new Duree(1000);
            Plage myPlage2 = new Plage(null, "toto", myDuree);
            System.out.println("test constructor FAIL");
        } catch (IllegalArgumentException e){
            System.out.println("test constructor OK");
        }

        try {
            System.out.println("test constructor (erreur)");
            Duree myDuree = new Duree(1000);
            Plage myPlage2 = new Plage("toto", "tata", null);
            System.out.println("test constructor FAIL");
        } catch (IllegalArgumentException e){
            System.out.println("test constructor OK");
        }

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

        System.out.println("test toString");
        System.out.println("Should be : Titre : upd Interprète : upd2 : Duree : 1.1");
        System.out.println(myPlage.toString());


    }
}