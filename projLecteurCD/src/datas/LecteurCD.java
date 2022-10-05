/**
 * @author Linz Pierre
 * @file LecteurCD.java
 * @brief 
 */

package datas;
import datas.CD;
public class LecteurCD {
    //Attributes :
    private boolean estCharge;
    private CD leCDCourant;
    private int indexPlage;
    

    /**
     * Constructor
     */
    public LecteurCD(){
        this.leCDCourant = null;
        //chargerUnCD();
    }


    public String getTempsTotal(){
        String ret="";
        if(this.leCDCourant==null){
            ret="0";
        }
        else{
           ret= this.leCDCourant.getDureeTotale().enTexte('J');
        }
        return ret;
    }

    public int getNbrePlages(){
        int ret=0;
        if(this.leCDCourant==null){
            ret=0;
        }
        else{
            ret=this.leCDCourant.getNbrePlages();
        }
        return ret;
    }

    public int getIndexCourant(){
        return this.indexPlage;
    }

    public Plage getPlageCourante(){
        Plage ret = null;
        if(this.leCDCourant!=null){
            ret = this.leCDCourant.getUnePlage(this.indexPlage);
        }
        return ret;
    }

    public boolean estCharge(){
        return this.leCDCourant!=null;
    }

    public CD getCD(){
        return this.leCDCourant;
    }

    public void setDecharger(){
        this.indexPlage=0;
        this.leCDCourant=null;
        this.estCharge=false;
    }


    public void chargerUnCD(){
        this.leCDCourant=new CD("toto","Pierre Linz");
    }

    public void chargerUnCD(String leFich){

        if(leFich!=null && leFich.length()>0){
          this.leCDCourant=new CD(leFich);  
        }else{
            IllegalArgumentException argExcept = new IllegalArgumentException("ERREUR : chargerUnCD(String leFich) leFich est null ou  longeure =0");
            throw(argExcept);
        }

        
    }

    public void stop(){
        if(this.estCharge) indexPlage=1;
    }

    public void play(){
        if(this.estCharge) indexPlage=1;
    }

    public void next(){
        if(this.estCharge) indexPlage+=1;

    }    

    public void previous(){
        if(this.estCharge) indexPlage-=1;

    }



    //setters and getters :
    /**
     * Setter estCharge
     * @param estCharge
     */
    public void setEstCharge(boolean estCharge) {
        this.estCharge = estCharge;
    }

    /**
     * Setter indexPlage
     * @param indexPlage
     */
    public void setIndexPlage(int indexPlage) {
        if(indexPlage>=0){
          this.indexPlage = indexPlage;  
        }else{
            IllegalArgumentException argExcept = new IllegalArgumentException("ERREUR : setIndexPlage(int indexPlage) indexPlage est <0");
            throw(argExcept);
        }
        
    }

    /**
     * Setter leCDCourant
     * @param leCDCourant
     */
    public void setLeCDCourant(CD leCDCourant) {
        if(leCDCourant!=null){
          this.leCDCourant = leCDCourant;  
        }else{
            IllegalArgumentException argExcept = new IllegalArgumentException("ERREUR : setIndexPlage(int indexPlage) indexPlage est <0");
            throw(argExcept);
        }
    }

    /**
     * getter for indexPlage
     * @return
     */
    public int getIndexPlage() {
        return this.indexPlage;
    }

    /**
     * getter fir leCDCourant
     * @return
     */
    public CD getLeCDCourant() {
        return this.leCDCourant;
    }

    /**
     * getter for estCharge
     * @return
     */
    public boolean isEstCharge() {
        return this.estCharge;
    }

}