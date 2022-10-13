/**
 * @file MainFrame.java
 * @author Linz Pierre
 * @brief the MainFrame
 */

package IHM;
import javax.swing.*;

import Control.Reaction;
import datas.LecteurCD;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class InterfaceGraphique extends JFrame {
    //Attributes :
    private LecteurCD lcd = new LecteurCD();

    //mainFrame
    private GridLayout mainLayout = new GridLayout(1,2);

    //0ed pannel elements    :
    private JPanel zeroPannel = new JPanel();
    private GridLayout zeroLayout = new GridLayout(3,1);
    private JLabel image = new JLabel("loading image fail");
    
    //first pannel elements
    private JPanel firstPannel = new JPanel();
    private GridLayout firstLayout = new GridLayout(3,2);
    private JButton chargerCDButton = new JButton("Charger CD - Off");
    private JLabel tempsTotLabel = new JLabel("Temps totale :");
    private JLabel nombreDePlagesLabel = new JLabel("Nombre de plage :");
    private JTextField tempsTot = new JTextField("");
    private JTextField nombreDePlages = new JTextField("");

    //second pannel elements
    private JPanel secondPannel = new JPanel();
    private BorderLayout secondLayout = new BorderLayout();
    private JTextField indexPlageCD  = new JTextField("");
    private JTextField titrePlageCD = new JTextField("");
    private JTextField dureePlageCD = new JTextField("");

    //third pannel elements
    private JPanel thirdPannel = new JPanel();
    private GridLayout thirdLayout = new GridLayout(1,4);
    private JButton stop = new JButton("Stop");
    private JButton play = new JButton("Play");
    private JButton next = new JButton("Next");
    private JButton previous = new JButton("Previous");

    

    // Constructeur
    /**
     * Constructor
     * @param titre
     */
    public InterfaceGraphique ( String titre ) {
        super(titre);
        miseEnPlaceDuDecort();
        ecouterLesEvenements();
        this.setSize(400,600);
        this.setVisible(true); 
        this.pack();
    }

    /**
     * Method that setup the IHM
     */
    private void miseEnPlaceDuDecort() {
        this.setLayout (this.mainLayout);
        //main frame pannel
        this.add(zeroPannel);
        this.zeroPannel.setLayout(zeroLayout);

        //try to load the image :
        try {
            BufferedImage myPicture = ImageIO.read(new File("../rss/image.png"));
            ImageIcon img = new ImageIcon(myPicture);
            image = new JLabel(img);
        } catch(IOException e) {
            e.printStackTrace();
        }
        this.add(image);

        //zero pannel
        this.zeroPannel.add(firstPannel);
        this.firstPannel.setLayout(firstLayout);
        this.zeroPannel.add(secondPannel);
        this.secondPannel.setLayout(secondLayout);
        this.zeroPannel.add(thirdPannel);
        this.thirdPannel.setLayout(thirdLayout);

        //first pannel 
        this.firstPannel.add(chargerCDButton);
        this.firstPannel.add(new JLabel("")); //empty cell

        this.firstPannel.add(tempsTotLabel);
        this.firstPannel.add(tempsTot);

        this.firstPannel.add(nombreDePlagesLabel);
        this.firstPannel.add(nombreDePlages);

        //second pannel
        this.secondPannel.add(indexPlageCD,BorderLayout.WEST);
        this.secondPannel.add(titrePlageCD,BorderLayout.CENTER);
        this.secondPannel.add(dureePlageCD,BorderLayout.EAST);

        //third pannel
        this.thirdPannel.add(stop);
        this.thirdPannel.add(play);
        this.thirdPannel.add(next);
        this.thirdPannel.add(previous);


    }

    /**
     * Method that set up the listenners
     */
    private void ecouterLesEvenements() {
        this.chargerCDButton.addActionListener(new Reaction(this));
        this.stop.addActionListener(new Reaction(this));
        this.next.addActionListener(new Reaction(this));
        this.play.addActionListener(new Reaction(this));
        this.previous.addActionListener(new Reaction(this));

    }

    /**
     * get next
     * @return next
     */
    public JButton getNext() {
        return next;
    }

    /**
     * get stop
     * @return stop
     */
    public JButton getStop() {
        return stop;
    }

    /**
     * get play
     * @return play
     */
    public JButton getPlay() {
        return play;
    }

    /**
     * get previous 
     * @return previous
     */
    public JButton getPrevious() {
        return previous;
    }

    /**
     * get tempsTotLabel
     * @return tempsTotLabel
     */
    public JLabel getTempsTotLabel() {
        return tempsTotLabel;
    }

    /**
     * get tempsTot
     * @return tempsTot
     */
    public JTextField getTempsTot() {
        return tempsTot;
    }

    /**
     * get NombreDePlagesLabel
     * @return NombreDePlagesLabel
     */
    public JLabel getNombreDePlagesLabel() {
        return nombreDePlagesLabel;
    }

    /**
     * get NombreDePlages
     * @return NombreDePlages
     */
    public JTextField getNombreDePlages() {
        return nombreDePlages;
    }

    /**
     * get ChargerCDButton
     * @return ChargerCDButton
     */
    public JButton getChargerCDButton() {
        return chargerCDButton;
    }

    /**
     * get IntexPlageCD
     * @return IntexPlageCD
     */
    public JTextField getIndexPlageCD() {
        return indexPlageCD;
    }

    /**
     * get TitrePlageCD
     * @return TitrePlageCD
     */
    public JTextField getTitrePlageCD() {
        return titrePlageCD;
    }

    /**
     * get dureePlageCD
     * @return dureePlageCD
     */
    public JTextField getDureePlageCD() {
        return dureePlageCD;
    }
    /**
     * get lcd
     * @return lecteurCDs
     */
    public LecteurCD getLcd() {
        return lcd;
    }

    /**
     * get image
     * @return image
     */
    public JLabel getImage() {
        return image;
    }

    /**
     * set image
     * @param image l'image
     */
    public void setImage(JLabel image) {
        this.remove(this.image);
        this.image = image;
        this.add(image);
    }

}