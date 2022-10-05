/**
 * @author Linz Pierre
 * @file Plage.java
 * @brief 
 */

package datas;
import datas.Duree;

public class Plage {
    //attributes :
    private Duree laDuree;
    private String leTitre;
    private String Interprete;
    


    
    /**
     * Constructor
     * @param leTitre String
     * @param Interprete String
     */
    public Plage (String leTitre, String Interprete, Duree laDuree){

        if(leTitre!=null && leTitre.length() >0){
            this.leTitre = leTitre;
        }else{
            IllegalArgumentException argExcept = new IllegalArgumentException("ERREUR : Plage (String leTitre, String Interprete, Duree laDuree) leTitre est null ou = \"\"");
            throw(argExcept);
        }
        if(Interprete!=null && Interprete.length() >0){
            this.Interprete = Interprete;
        }else{
            IllegalArgumentException argExcept = new IllegalArgumentException("ERREUR : Plage (String leTitre, String Interprete, Duree laDuree) Interprete est null ou = \"\"");
            throw(argExcept);
        }
        if(laDuree!=null){
            this.laDuree = laDuree;
        }else{
            IllegalArgumentException argExcept = new IllegalArgumentException("ERREUR : Plage (String leTitre, String Interprete, Duree laDuree) laDuree est null");
            throw(argExcept);
        }
    }

    /**
    *
    *
    *
    */
    public String getFicheComplete(){
        String ret="";

        ret ="Titre : " +this.getLeTitre() + " Interprète : " + this.getInterprete()+" Duree : "+ this.laDuree.enTexte('H');

        return ret;
    }


    /** 
     * Getter for laDuree
     * @return
     */
    public Duree getLaDuree() {
        return this.laDuree;
    }

    /**
     * getter for titre
     * @return
     */
    public String getLeTitre() {
        return this.leTitre;
    }

    //getters and setter
    /**
     * Getter for Interprete
     * @return
     */
    public String getInterprete() {
        return this.Interprete;
    }


    /**
     *
     *
     */
    public String toString(){
         String ret="";

        ret ="Titre : " +this.getLeTitre() + " Interprète : " + this.getInterprete()+" Duree : "+ this.laDuree.enTexte('S');

        return ret;
    }



    /**
     * Setter for Interprete
     * @param interprete
     */
    public void setInterprete(String interprete) {
        if(interprete!=null && interprete.length()>0){
            this.Interprete = interprete;
        }
        else{
            IllegalArgumentException argExcept = new IllegalArgumentException("ERREUR : setInterprete(String interprete) interprete est null ou = \"\"");
            throw(argExcept);
        }
        
    }

    /**
     * setter for titre
     * @param leTitre
     */
    public void setLeTitre(String leTitre) {
        if(leTitre!=null && leTitre.length()>0){
            this.leTitre = leTitre;
        }
        else{
            IllegalArgumentException argExcept = new IllegalArgumentException("ERREUR : setLeTitre(String leTitre) leTitre est null ou = \"\"");
            throw(argExcept);
        }
    } 

    

    

    /**
     * setter for laDuree
     * @param laDuree
     */
    public void setLaDuree(Duree laDuree) {
        if(laDuree!=null){
            this.laDuree = laDuree;
        }
        else{
            IllegalArgumentException argExcept = new IllegalArgumentException("ERREUR : setLaDuree(Duree laDuree) laDuree est null");
            throw(argExcept);
        }
    }
}