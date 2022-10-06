/**
 * @author Linz Pierre
 * @file CDT.java
 * @brief test of datas/CD.java
 */
package test.datas;

import java.util.ArrayList;

import datas.CD;
import datas.Plage;
import datas.Duree;

public class CDT {
    public static void main(String[] args) {
        testConstructorAndGetter1();
        testSetters1();
        testSetters2();
        testSetters3();
        testSetters4();
        testGraverCD();
        testGraverCDFichier();
    }

    private static void testConstructorAndGetter1() {
        try {
            System.out.println("test constructor (cd vide) and getter");
            // Duree myDuree = new Duree(1000);
            CD myCD = new CD("leTitreCD","InterpreteCD");
            if(myCD.getLeTitreCD() == "leTitreCD" &&
               myCD.getLInterpreteCD() == "InterpreteCD") {
                System.out.println("test constructor and getter OK");
            } else {
                System.out.println("test constructor and getter FAIL");
            }
        } catch (IllegalArgumentException e){
            System.out.println("test constructor and getter FAIL");
        }
    }

    private static void testSetters1() {
        try {
            System.out.println("test setters (ok)");
            CD myCD = new CD("leTitreCD","InterpreteCD");
            myCD.setInterpreteCD("upd");
            myCD.setLeTitreCD("upd2");
            if (myCD.getLeTitreCD() == "upd2" &&
                myCD.getLInterpreteCD() == "upd") {
                 
                System.out.println("test setters OK");
            } else {
                System.out.println("test setters FAIL");
            }
        } catch (IllegalArgumentException e){
            System.out.println("test setters FAIL");
        }
    }

    private static void testSetters2() {
        try {
            System.out.println("test setters (erreur)");
            CD myCD = new CD("leTitreCD","InterpreteCD");
            myCD.setInterpreteCD(null);
            myCD.setLeTitreCD("upd2");
            ArrayList<Plage> lesPlages = new ArrayList<Plage>();
            myCD.setLesPlages(lesPlages);
            if (myCD.getLeTitreCD() == "upd2" &&
                myCD.getLInterpreteCD() == "upd" &&
                myCD.getLesPlages().equals(lesPlages) == true) {
                 
                System.out.println("test setters FAIL");
            } else {
                System.out.println("test setters OK");
            }
        } catch (IllegalArgumentException e){
            System.out.println("test setters OK");
        }
    }

    private static void testSetters3() {
        try {
            System.out.println("test setters (erreur)");
            CD myCD = new CD("leTitreCD","InterpreteCD");
            myCD.setInterpreteCD("upd");
            myCD.setLeTitreCD(null);
            ArrayList<Plage> lesPlages = new ArrayList<Plage>();
            myCD.setLesPlages(lesPlages);
            if (myCD.getLeTitreCD() == "upd2" &&
                myCD.getLInterpreteCD() == "upd" &&
                myCD.getLesPlages().equals(lesPlages) == true) {
                 
                System.out.println("test setters FAIL");
            } else {
                System.out.println("test setters OK");
            }
        } catch (IllegalArgumentException e){
            System.out.println("test setters OK");
        }
    }

    private static void testSetters4(){
        try {
            System.out.println("test setters (erreur)");
            CD myCD = new CD("leTitreCD","InterpreteCD");
            myCD.setInterpreteCD("upd");
            myCD.setLeTitreCD("upd2");
            ArrayList<Plage> lesPlages = null;
            myCD.setLesPlages(lesPlages);
            if (myCD.getLeTitreCD() == "upd2" &&
                myCD.getLInterpreteCD() == "upd" &&
                myCD.getLesPlages().equals(lesPlages) == true) {
                 
                System.out.println("test setters FAIL");
            } else {
                System.out.println("test setters OK");
            }
        } catch (IllegalArgumentException e){
            System.out.println("test setters OK");
        }

    }

    private static void testGraverCD(){
        System.out.println("test graverCD()");
        Duree duree = new Duree (1,10,50);
        Plage plage = new Plage ("Titre", "Interprete", duree);
        CD myCD = new CD("leTitreCD","InterpreteCD");

        System.out.println("test graverCD() should be the same");
        System.out.println(myCD.getLesPlages().get(0));
        System.out.println(plage);
    }
    
    private static void testGraverCDFichier() {
        System.out.println("test graverCD(fichier)");
        CD myCD2 = new CD("../rss/test_graverCD.txt");

        Duree duree = new Duree (0,2,1);
        Plage plage = new Plage ("Toto", "Titi", duree);

        System.out.println("test graverCD() should be the same");
        System.out.println(myCD2.getLesPlages().get(0));
        System.out.println(plage);        

    }


}