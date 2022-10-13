/**
 * @auhtor Linz Pierre
 */

package Control;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import IHM.InterfaceGraphique;
public class Reaction implements ActionListener  {
    
    private InterfaceGraphique myFrame;
    /**
     * constructor
     * @param myFrame2 the frame
     */
    public Reaction(InterfaceGraphique myFrame2) {
        this.myFrame = myFrame2;
    }

    /**
     * method that do all the actions
     */
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == myFrame.getChargerCDButton()) {
            if(myFrame.getChargerCDButton().getText().equals("Charger CD - Off")) {
                myFrame.getLcd().chargerUnCD("../rss/test_graverCD.txt");
                myFrame.getNombreDePlages().setText(""+ myFrame.getLcd().getNbrePlages());
                myFrame.getTempsTot().setText("" + myFrame.getLcd().getLeCDCourant().getDureeTotale().enTexte('H'));
                myFrame.getIndexPlageCD().setText("" + (myFrame.getLcd().getIndexCourant()+1));
                myFrame.getTitrePlageCD().setText("" + myFrame.getLcd().getPlageCourante().getLeTitre() + " de " + myFrame.getLcd().getPlageCourante().getInterprete());
                myFrame.getDureePlageCD().setText("" + myFrame.getLcd().getPlageCourante().getLaDuree().enTexte('H'));
                myFrame.getChargerCDButton().setText("Charger CD - ON");
                myFrame.setTitle("" + myFrame.getLcd().getLeCDCourant().getLeTitreCD() + " de " + myFrame.getLcd().getLeCDCourant().getLInterpreteCD());

                try {
                    BufferedImage myPicture = ImageIO.read(new File("../rss/imageMusique.png"));
                    JLabel image = new JLabel(new ImageIcon(myPicture));
                    myFrame.setImage(image);
                } catch(IOException ee) {
                    ee.printStackTrace();
                }
                

            } else {
                myFrame.getChargerCDButton().setText("Charger CD - Off");
                myFrame.getLcd().setDecharger();
                myFrame.getNombreDePlages().setText("");
                myFrame.getTempsTot().setText("");
                myFrame.getIndexPlageCD().setText("");
                myFrame.getTitrePlageCD().setText("");
                myFrame.getDureePlageCD().setText("");
                myFrame.setTitle("");

                try {
                    BufferedImage myPicture = ImageIO.read(new File("../rss/image.png"));
                    ImageIcon img = new ImageIcon(myPicture);
                    JLabel image = new JLabel(img);
                    myFrame.setImage(image);
                } catch(IOException ee) {
                    ee.printStackTrace();
                }
            }

        } else if ( e.getSource() == myFrame.getPlay()
        && myFrame.getLcd().getIndexCourant()!=1) {

            myFrame.getLcd().play();
            myFrame.getIndexPlageCD().setText("" + (myFrame.getLcd().getIndexCourant()+1));
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
            myFrame.getIndexPlageCD().setText("" + (myFrame.getLcd().getIndexCourant()+1));
            myFrame.getTitrePlageCD().setText("" + myFrame.getLcd().getPlageCourante().getLeTitre() + " de " + myFrame.getLcd().getPlageCourante().getInterprete());
            myFrame.getDureePlageCD().setText("" + myFrame.getLcd().getPlageCourante().getLaDuree().enTexte('H'));

        } else if ( e.getSource() == myFrame.getPrevious()
        && myFrame.getLcd().getIndexCourant()>0) {

            myFrame.getLcd().previous();
            myFrame.getIndexPlageCD().setText("" + (myFrame.getLcd().getIndexCourant()+1));
            myFrame.getTitrePlageCD().setText("" + myFrame.getLcd().getPlageCourante().getLeTitre() + " de " + myFrame.getLcd().getPlageCourante().getInterprete());
            myFrame.getDureePlageCD().setText("" + myFrame.getLcd().getPlageCourante().getLaDuree().enTexte('H'));

        }
        
    }
    
}
