/**
 * @author Linz Pierre
 * @file Duree.java
 * @brief 
 */

package datas;

import java.util.concurrent.TimeUnit;

public class Duree {
    //attributes :
    //in millisecond
    private long leTemps;
    
    /**
     * Constructor
     * @param milisec long
     * @throws  @throws IllegalArgumentException
     */
    public Duree (long milisec){
        if(milisec >=0){
           this.leTemps = milisec; 
        }else{
            IllegalArgumentException argException = new IllegalArgumentException("ERREUR : Duree (long milisec) la duree en Milisecondes");
            throw(argException);
        }
        
    }
    /**
     * Constructor
     * @param heures int
     * @param minutes int
     * @param secondes int
     * @throws  @throws IllegalArgumentException
     */
    public Duree(int heures, int minutes, int secondes){
        // variable locale qui sera mise dans this.leTemps
        long Temps = 0; 
        // est-ce que l'heure est bien saisie ?
        if(heures>=0){ 
            Temps = heures * 3600000;  
        } else{
            IllegalArgumentException argException = new IllegalArgumentException("ERREUR : Durree.java : Duree(int heures, int minutes, int secondes) , heure < 0");
            throw(argException);
        }
        // est-ce que les minutes sont bien saisie ?
        if(minutes >=0){
            Temps += minutes * 60000;
        } else{
            IllegalArgumentException argException = new IllegalArgumentException("ERREUR : Durree.java : Duree(int heures, int minutes, int secondes) , minutes < 0");
            throw(argException);
        }
        // est-ce que les secondes sont bien saisie ?
        if(secondes >=0){
            Temps += secondes * 1000;
        } else{
            IllegalArgumentException argException = new IllegalArgumentException("ERREUR : Durree.java : Duree(int heures, int minutes, int secondes) , secondes < 0");
            throw(argException);
        }

        this.leTemps = Temps;
    }

    /**
     * Constructor
     * @throws  @throws IllegalArgumentException
     * @param autreDuree Duree
     */
    public Duree (Duree autreDuree){
        if(autreDuree!=null){
            this.setLeTemps(autreDuree.getLeTemps());
        }else{
            IllegalArgumentException argException = new IllegalArgumentException("ERREUR :Duree (Duree autreDuree) autreDuree est null");
            throw(argException);
        }
    }
    // getters and setter
    /**
     * Getter for leTemps
     * @return
     */
    public long getLeTemps() {
        return this.leTemps;
    }

    /**
     * Setter for leTemps
     * @param leTemps long
     * @throws  @throws IllegalArgumentException
     *///
    public void setLeTemps(long leTemps) {

        if(leTemps>=0){
            this.leTemps = leTemps;
        }else{
           IllegalArgumentException argException = new IllegalArgumentException("ERREUR :Duree setLeTemps(long leTemps) leTemps est < 0");
            throw(argException); 
        }
        
    }
    /**
     * Modificateur qui ajoute une dur??e ?? la dur??e courante
     * @param autreDuree Duree
     */
    public void ajoute(Duree autreDuree) {
        long tps = getLeTemps() + autreDuree.getLeTemps();
        setLeTemps(tps);
        }

    /**
     * Accesseur qui effectue une comparaison entre la dur??e courante et une autre dur??e.
     * @param autreDuree
     * @return int
     * un entier qui prend les valeurs suivantes :
     * -1 : si la dur??e courante est + petite que autreDuree
     * 0 : si la dur??e courante est ??gale ?? autreDuree
     * 1 : si la dur??e courante est + grande que autreDuree
     */
    public int compareA(Duree autreDuree) {
        int ret;
        if (autreDuree.getLeTemps() > getLeTemps()) {
            ret = -1;
        } else if (autreDuree.getLeTemps() < getLeTemps()){
            ret = 1 ;
        } else {
            ret = 0;
        }
        return ret;
    }

    /**
     * Accesseur qui renvoie sous la forme d'une cha??ne de caract??res la dur??e
     * courante.
     * @param mode d??cide de la forme donn??e ?? la cha??ne de caract??res
     * La forme de la cha??ne de caract??res d??pend du "mode" (caract??re pass?? en param??tre) choisi :
     * si mode == 'J' = cha??ne de caract??res de la forme "JJJ jours HH h"
     * si mode == 'H' = cha??ne de caract??res de la forme "HHH:MM:SS"
     * si mode == 'S' = cha??ne de caract??res de la forme "SSS.MMM sec"
     * si mode == 'M' = cha??ne de caract??res de la forme "MMMMMM millisec"
     * @return
     */
    public String enTexte(char mode){
        String ret = "";
        int[] JHMS = enJHMS();
        int milliseconds = JHMS[4] ;
        int seconds = JHMS[3] ;
        int minutes = JHMS[2] ;
        int hours   = JHMS[1] ;
        int days = JHMS[0] ;

        switch(mode) {
            case 'J':
                ret = days + " jours " + hours + "h";
                break;
            case 'H':
                hours = hours + (days * 24);
                ret = hours + ":" + minutes + ":" + seconds;
                break;
            case 'S':
                hours = hours + (days * 24);
                minutes = minutes + (hours * 60);
                seconds = seconds + (minutes * 60);
                ret = seconds + "." + milliseconds;
                break;
            case 'M':
                ret = this.leTemps + " millisec";
                break;
          }
          

        return ret ;
    }

    /**
     * M??thode priv??e qui effectue un d??coupage de la dur??e courante en intervalles (jours, heures,
     * minutes, secondes, millisecondes). La dur??e courante (leTemps) est analys??e pour fabriquer un
     * tableau d'entiers (taille 5) dont chaque ??l??ment a la signification suivante :
     * @return ret[0] contient le nbre de jours
     * ret[1] contient le nbre d'heures (inf 24h)
     * ret[2] contient le nbre de minutes (inf 60min)
     * ret[3] contient le nbre de secondes (inf 60sec)
     * ret[4] contient le nbre de millisecondes (inf 1000millisec)
     */
    private int[] enJHMS() {   
        long milliseconds = getLeTemps();
        long days =  (int) (milliseconds / (1000*60*60*24));
        milliseconds -= TimeUnit.DAYS.toMillis(days);
        long hours   = (int) ((milliseconds / (1000*60*60)) % 24);
        milliseconds -= TimeUnit.HOURS.toMillis(hours);
        long minutes = (int) ((milliseconds / (1000*60)) % 60);
        milliseconds -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = ((int) (milliseconds / 1000) % 60 );
        milliseconds -= TimeUnit.SECONDS.toMillis(seconds); 
        
        int[] ret = {(int)days,(int)hours,(int)minutes,(int)seconds,(int)milliseconds};
        return ret;
    }
}