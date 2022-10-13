/**
 * @author Linz Pierre
 * @file CD.java
 * @brief 
 */

package datas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import datas.Plage;

public class CD {
    //Attributes : 
    private ArrayList<Plage> lesPlages;
    private String leTitreCD;
    private String InterpreteCD;
   

    /**
     * Constructor
     * @param leTitreCD
     * @param InterpreteCD
     * @throws  @throws IllegalArgumentException
     */
    public CD( String leTitreCD, String InterpreteCD){
        if(leTitreCD!=null && leTitreCD.length()>0 ){
            this.leTitreCD = leTitreCD;
        }else{
            IllegalArgumentException argExcept = new IllegalArgumentException("ERREUR : CD( String leTitreCD, String InterpreteCD) leTitreCD null ou = \"\"");
            throw(argExcept);
        }

        if(InterpreteCD!=null && InterpreteCD.length()>0 ){
            this.InterpreteCD = InterpreteCD;
        }else{
            IllegalArgumentException argExcept = new IllegalArgumentException("ERREUR : CD( String leTitreCD, String InterpreteCD) InterpreteCD null ou = \"\"");
            throw(argExcept);
        }
        this.lesPlages = new ArrayList<Plage>();
        this.graverCD();
    }

    /**
     * Constructor
     * @param leFich
     * @throws  @throws IllegalArgumentException
     */
    public CD(String leFich){
        this.lesPlages = new ArrayList<Plage>();
        if(leFich!=null && leFich.length()>0 ){
           try {
            this.graverCD(leFich);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        }else{
            IllegalArgumentException argExcept = new IllegalArgumentException("ERREUR : CD( String leFich) leFich null ou = \"\"");
            throw(argExcept);
        }

    }



    //accesseurs :
    /**
     * Setter for InterpreteCD
     * @param InterpreteCD String
     * @throws  @throws IllegalArgumentException
     */
    public void setInterpreteCD(String InterpreteCD) {
        if(InterpreteCD!=null && InterpreteCD.length()>0){
            this.InterpreteCD = InterpreteCD;
        }else{
            IllegalArgumentException argExcept = new IllegalArgumentException("ERREUR : setInterpreteCD(String InterpreteCD) InterpreteCD null ou = \"\"");
            throw(argExcept);
        }
    }

    /**
     * setter for leTitreCD
     * @param leTitreCD String
     * @throws  @throws IllegalArgumentException
     */
    public void setLeTitreCD(String leTitreCD) {

        if(leTitreCD!=null && leTitreCD.length()>0){
             this.leTitreCD = leTitreCD;
        }else{
            IllegalArgumentException argExcept = new IllegalArgumentException("ERREUR : setLeTitreCD(String leTitreCD) leTitreCD null ou = \"\"");
            throw(argExcept);
        }

       
    }

    /**
     * setter for lesPlages
     * @param lesPlages ArrayList<Plage>
     * @throws  @throws IllegalArgumentException
     */
    public void setLesPlages(ArrayList<Plage> lesPlages) {
        if(lesPlages!=null&& lesPlages.size()>0){
            this.lesPlages = lesPlages;
        }else{
            IllegalArgumentException argExcept = new IllegalArgumentException("ERREUR : setLesPlages(ArrayList lesPlages) lesPlages null ou size=0");
            throw(argExcept);
        }
        
    }

    /**
     * getter for InterpreteCD
     * @return String
     */
    public String getLInterpreteCD() {
        return this.InterpreteCD;
    }

    /**
     * Getter for leTitreCD
     * @return String
     */
    public String getLeTitreCD() {
        return this.leTitreCD;
    }

    /**
     * Getter for lesPlages
     * @return ArrayList<Plage>
     */
    public ArrayList<Plage> getLesPlages() {
        return this.lesPlages;
    }

    /**
     * Get the number of plage
     * @return int
     */
    public int getNbrePlages(){
        return this.lesPlages.size();
    }

    /**
     * get duree totale
     * @return Duree
     */
    public Duree getDureeTotale(){
        Duree ret = new Duree(0);

        for (Plage plage : this.lesPlages) {
            ret.ajoute(plage.getLaDuree());
        }
        return ret;
    }

    /**
     * get a specific plage in les plages
     * @param index the index of the plage
     * @return the plage
     * @throws  @throws IllegalArgumentException
     */
    public Plage getUnePlage(int index){
        Plage ret = null;

        if(index>=0){
            if(this.lesPlages.size()>index){
                ret = this.lesPlages.get(index);
            }else{
                IllegalArgumentException argExcept = new IllegalArgumentException("ERREUR : getUnePlage(int index) index > taille LesPlages");
                throw(argExcept);
            }
        }else{
            IllegalArgumentException argExcept = new IllegalArgumentException("ERREUR : getUnePlage(int index) index <0");
            throw(argExcept);
        }
        return ret;
    }


    /**
     * method that burn a CD
     */
    private void graverCD(){
        Plage nouveau = new Plage("Titre", "Interprete", new Duree(1,10,50));
        this.lesPlages.add(nouveau);
    }

    /**
     * Method that burn a CD form a file
     * @param leFich String
     * @throws FileNotFoundException 
     */
    private void graverCD(String leFich)throws FileNotFoundException {

        String[] tab = new String[4];
        String ligne = "";
        String Interprete="";
        String Titre="";

        Plage nouveau =null;
        int i =0;
        int min=0;
        int sec =0;

        File doc = new File(leFich);
        Scanner obj = new Scanner(doc);

        while (obj.hasNextLine()){
            ligne = obj.nextLine();

            if(i==0) {
                tab=ligne.split("/");
                this.leTitreCD = tab[0];
                this.InterpreteCD = tab[1];

            } else {
            
                tab=ligne.split("/");
                Titre=tab[0];
                Interprete=tab[1];
                min=Integer.valueOf(tab[2]);
                sec=Integer.valueOf(tab[3]);

                nouveau = new Plage(Titre, Interprete, new Duree(0,min,sec));
                this.lesPlages.add(nouveau);       
            }
            i++;
        }
    }
}