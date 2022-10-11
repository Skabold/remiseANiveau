/**
 * @file MainFrame.java
 * @author Linz Pierre
 * @brief the MainFrame
 */

package IHM;
import javax.swing.*;
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
    GridLayout mainLayout = new GridLayout(1,2);

    //0ed pannel elements    :
    JPanel zeroPannel = new JPanel();
    GridLayout zeroLayout = new GridLayout(3,1);
    JLabel image = new JLabel("loading image fail");
    
    //first pannel elements
    JPanel firstPannel = new JPanel();
    GridLayout firstLayout = new GridLayout(3,2);
    JButton chargerCDButton = new JButton("Charger CD - Off");
    JLabel tempsTotLabel = new JLabel("Temps totale :");
    JLabel nombreDePlagesLabel = new JLabel("Nombre de plage :");
    JTextField tempsTot = new JTextField("00:00:00");
    JTextField nombreDePlages = new JTextField("0");

    //second pannel elements
    JPanel secondPannel = new JPanel();
    BorderLayout secondLayout = new BorderLayout();
    JTextField indexPlageCD  = new JTextField("0");
    JTextField titrePlageCD = new JTextField("titre du morceau");
    JTextField dureePlageCD = new JTextField("00:00:00");

    //third pannel elements
    JPanel thirdPannel = new JPanel();
    GridLayout thirdLayout = new GridLayout(1,4);
    JButton stop = new JButton("Stop");
    JButton play = new JButton("Play");
    JButton next = new JButton("Next");
    JButton previous = new JButton("Previous");

    

    // Constructeur
    public InterfaceGraphique ( String titre ) {
        super(titre);
        miseEnPlaceDuDecort();
        ecouterLesEvenements();
        this.setSize(400,600);
        this.setVisible(true); 
        this.pack();
    }

    private void miseEnPlaceDuDecort() {
        this.setLayout (this.mainLayout);
        //main frame pannel
        this.add(zeroPannel);
        this.zeroPannel.setLayout(zeroLayout);

        //try to load the image :
        try {
            BufferedImage myPicture = ImageIO.read(new File("../rss/image.png"));
            image = new JLabel(new ImageIcon(myPicture));
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

    private void ecouterLesEvenements() {}

}