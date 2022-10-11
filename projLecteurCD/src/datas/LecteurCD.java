/**
 * @author Linz Pierre
 * @file LecteurCD.java
 * @brief 
 */

package datas;
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
        this.estCharge = false;
        this.indexPlage = 0;
    }
    
    /**
     * method that load a cd
     */
    public void chargerUnCD(){
        this.leCDCourant=new CD("toto","Pierre Linz");
        this.estCharge = true;
    }

    /**
     * Method that load a cd from a file
     * @param leFich
     */
    public void chargerUnCD(String leFich){
        if(leFich!=null && leFich.length()>0){
          this.leCDCourant=new CD(leFich);
          this.estCharge = true;
        } else{
            IllegalArgumentException argExcept = new IllegalArgumentException("ERREUR : chargerUnCD(String leFich) leFich est null ou  longeure =0");
            throw(argExcept);
        }      
    }

    /**
     * Modificateur qui simule la touche STOP
     */
    public void stop(){
        if(this.estCharge) this.indexPlage=1;
    }

    /**
     * Modificateur qui simule la touche PLAY
     */
    public void play(){
        if(this.estCharge) this.indexPlage=1;
    }

    /**
     * Modificateur qui simule la touche NEXT
     */
    public void next(){
        if(this.estCharge) this.indexPlage+=1;

    }    

    /**
     * Modificateur qui simule la touche PREVIOUS
     */
    public void previous(){
        if(this.estCharge) this.indexPlage-=1;

    }

    //setters and getters :
    /**
     * Setter estCharge
     * @param estCharge boolean
     */
    public void setEstCharge(boolean estCharge) {
        this.estCharge = estCharge;
    }

    /**
     * Setter indexPlage
     * @param indexPlage int
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
     * @param leCDCourant CD
     * @throws @throws IllegalArgumentException
     */
    public void setLeCDCourant(CD leCDCourant) {
        if(leCDCourant!=null){
          this.leCDCourant = leCDCourant;  
        }else{
            IllegalArgumentException argExcept = new IllegalArgumentException("ERREUR : setLeCDCourant(CD leCDCourant) leCDCourant est null");
            throw(argExcept);
        }
    }


    /**
     * Getter for temps total
     * @return String
     */
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

    /**
     * Method that get the number of plage
     * @return the number of plage
     */
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

    /**
     * Method that get the current index
     * @return the current index
     */
    public int getIndexCourant(){
        return this.indexPlage;
    }

    /**
     * Fet the current plage
     * @return current plage
     */
    public Plage getPlageCourante(){
        Plage ret = null;
        if(this.leCDCourant!=null){
            ret = this.leCDCourant.getUnePlage(this.indexPlage);
        }
        return ret;
    }

    /**
     * get the status of charge
     * @return estCharge
     */
    public boolean estCharge(){
        return this.estCharge;
    }

    /**
     * get indexPlage
     * @return indexPlage
     */
    public int getIndexPlage() {
        return indexPlage;
    }

    /**
     * get LeCdCourant
     * @return LeCdCourant
     */
    public CD getLeCDCourant() {
        return leCDCourant;
    }

    /**
     * unload the CD
     */
    public void setDecharger(){
        this.indexPlage=0;
        this.leCDCourant=null;
        this.estCharge=false;
    }


}