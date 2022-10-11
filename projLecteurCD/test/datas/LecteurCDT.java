package test.datas;

import datas.CD;
import datas.LecteurCD;

public class LecteurCDT {
    public static void main(String[] args) {

        //call tests methods
        testLecteurCD();
        testGet();
        testSet();
        testChargerUnCD();
        testModificateur();
 
    }

    private static void testModificateur() {
        System.out.println("test modificateurs (ok) ");
        boolean isOk = true; 
        LecteurCD lcd = new LecteurCD();
        lcd.chargerUnCD();
        int indexPlage = lcd.getIndexPlage();
        lcd.stop();
        indexPlage = lcd.getIndexPlage();
        if(indexPlage != 1) isOk = false;
        lcd.play();
        indexPlage = lcd.getIndexPlage();
        if(indexPlage != 1) isOk = false;
        lcd.next();
        indexPlage = lcd.getIndexPlage();
        if(indexPlage != 2) isOk = false;
        lcd.previous();
        indexPlage = lcd.getIndexPlage();
        if(indexPlage != 1) isOk = false;
        if(isOk) {
            System.out.println("test modificateurs (ok) : OK");
        } else {
            System.out.println("test modificateurs (ok) FAIL");
        }
    }


    private static void testChargerUnCD() {
        System.out.println("test charger un CD (ok) ");
        LecteurCD lcd = new LecteurCD();
        lcd.chargerUnCD();
        lcd.getLeCDCourant();
        System.out.println("Should be : ");
        System.out.println("Pierre Linz toto");
        System.out.println(lcd.getLeCDCourant().getLInterpreteCD() + " " +lcd.getLeCDCourant().getLeTitreCD());
        System.out.println("- - - - - - - - - - - - - - - ");
        lcd.chargerUnCD("../rss/test_graverCD.txt");
        System.out.println("test graverCD() should be the same");
        System.out.println(lcd.getLeCDCourant().getLesPlages().get(0));
        System.out.println("Titre : Toto Interprète : Titi Duree : 121.0");


    }

    private static void testSet() {
        System.out.println("test setters (ok) ");
        LecteurCD lcd = new LecteurCD();
        lcd.setDecharger();
        System.out.println("Should be : 0 , null , false");
        System.out.println(lcd.getIndexPlage() + "" +  lcd.getLeCDCourant() + "" + lcd.estCharge());
        lcd.setEstCharge(true);
        lcd.setIndexPlage(10);
        lcd.setLeCDCourant(new CD("../rss/test_graverCD.txt"));
        System.out.println("Should be : 10 , null , null , true");
        System.out.println(lcd.getIndexPlage() + " " +lcd.getLeCDCourant().getLeTitreCD() + " " + lcd.getLeCDCourant().getLInterpreteCD() + " " + lcd.estCharge());

    }

    private static void testGet() {
        System.out.println("test getter (ok) ");
        LecteurCD lcd = new LecteurCD();   
        lcd.getIndexCourant();
        lcd.getNbrePlages();
        lcd.getTempsTotal();
        System.out.println("should be : 0 0 0");
        System.out.println(lcd.getIndexCourant() + " " + lcd.getNbrePlages() + " " + lcd.getTempsTotal());
    }

    private static void testLecteurCD(){
        LecteurCD lcd = new LecteurCD();
        if (lcd.getLeCDCourant() == null &&
            lcd.getIndexPlage() == 0 &&
            !lcd.estCharge()) {
                System.out.println("TEST CONSTRUCTOR OK");
            } else {
                System.out.println("TEST CONSTRUCTOR FAIL");
            }

    }
}
