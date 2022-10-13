/**
 * @auhtor Linz Pierre
 */

package Control;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import IHM.InterfaceGraphique;
import datas.Duree;
public class Reaction implements ActionListener  {

    private InterfaceGraphique myFrame;
    public Reaction(InterfaceGraphique myFrame2) {
        this.myFrame = myFrame2;
    }

    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == myFrame.getChargerCDButton()) {
            if(myFrame.getChargerCDButton().getText().equals("Charger CD - Off")) {
                myFrame.getLcd().chargerUnCD("../rss/test_graverCD.txt");
                myFrame.getNombreDePlages().setText(""+ myFrame.getLcd().getNbrePlages());
                myFrame.getTempsTot().setText("" + myFrame.getLcd().getLeCDCourant().getDureeTotale().enTexte('H'));
                myFrame.getIndexPlageCD().setText("" + myFrame.getLcd().getIndexCourant());
                myFrame.getTitrePlageCD().setText("" + myFrame.getLcd().getPlageCourante().getLeTitre() + " de " + myFrame.getLcd().getPlageCourante().getInterprete());
                myFrame.getDureePlageCD().setText("" + myFrame.getLcd().getPlageCourante().getLaDuree().enTexte('H'));
                myFrame.getChargerCDButton().setText("Charger CD - ON");
                myFrame.setTitle("" + myFrame.getLcd().getLeCDCourant().getLeTitreCD() + " de " + myFrame.getLcd().getLeCDCourant().getLInterpreteCD());

            } else {
                myFrame.getChargerCDButton().setText("Charger CD - Off");
                myFrame.getLcd().setDecharger();
                myFrame.getNombreDePlages().setText("");
                myFrame.getTempsTot().setText("");
                myFrame.getIndexPlageCD().setText("");
                myFrame.getTitrePlageCD().setText("");
                myFrame.getDureePlageCD().setText("");
                myFrame.setTitle("");
            }

        } else if ( e.getSource() == myFrame.getPlay()
        && myFrame.getLcd().getIndexCourant()!=1) {

            myFrame.getLcd().play();
            myFrame.getIndexPlageCD().setText("" + myFrame.getLcd().getIndexCourant());
            myFrame.getTitrePlageCD().setText("" + myFrame.getLcd().getPlageCourante().getLeTitre() + " de " + myFrame.getLcd().getPlageCourante().getInterprete());
            myFrame.getDureePlageCD().setText("" + myFrame.getLcd().getPlageCourante().getLaDuree().enTexte('H'));

        } else if ( e.getSource() == myFrame.getStop()) {
            myFrame.getLcd().stop();
            myFrame.getIndexPlageCD().setText("");
            myFrame.getTitrePlageCD().setText("");
            myFrame.getDureePlageCD().setText("");

        } else if ( e.getSource() == myFrame.getNext()
        && myFrame.getLcd().getIndexCourant() +1 <myFrame.getLcd().getNbrePlages()) {
            myFrame.getLcd().next();
            myFrame.getIndexPlageCD().setText("" + myFrame.getLcd().getIndexCourant());
            myFrame.getTitrePlageCD().setText("" + myFrame.getLcd().getPlageCourante().getLeTitre() + " de " + myFrame.getLcd().getPlageCourante().getInterprete());
            myFrame.getDureePlageCD().setText("" + myFrame.getLcd().getPlageCourante().getLaDuree().enTexte('H'));

        } else if ( e.getSource() == myFrame.getPrevious()
        && myFrame.getLcd().getIndexCourant()>0) {

            myFrame.getLcd().previous();
            myFrame.getIndexPlageCD().setText("" + myFrame.getLcd().getIndexCourant());
            myFrame.getTitrePlageCD().setText("" + myFrame.getLcd().getPlageCourante().getLeTitre() + " de " + myFrame.getLcd().getPlageCourante().getInterprete());
            myFrame.getDureePlageCD().setText("" + myFrame.getLcd().getPlageCourante().getLaDuree().enTexte('H'));

        }
        
    }
    
}
