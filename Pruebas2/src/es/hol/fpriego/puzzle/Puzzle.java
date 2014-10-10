package es.hol.fpriego.puzzle;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// The goal of this little game is to form the original picture. We move the buttons by clicking on them. 
// Only buttons adjacent to the label can be moved

public class Puzzle extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel centerPanel;
    private JButton button;
    private JLabel label;
    private Image source;
    private Image image;
    int[][] pos;
    int width, height;

    public Puzzle() {
    	
    	// These are the positions of the image parts
    	
        pos = new int[][] {
                            {0, 1, 2}, 
                            {3, 4, 5}, 
                            {6, 7, 8}, 
                            {9, 10, 11}
                        };


        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 4, 0, 0));
        
        // We use the ImageIcon class to load the image
        
        ImageIcon sid = new ImageIcon("icesid.jpg");
        source = sid.getImage();

        width = sid.getIconWidth();
        height = sid.getIconHeight();


        add(Box.createRigidArea(new Dimension(0, 5)), BorderLayout.NORTH);    
        add(centerPanel, BorderLayout.CENTER);

        // The code creates 11 buttons and one label. We crop the image into pieces and place them on the buttons
        
        for ( int i = 0; i < 4; i++) {
            for ( int j = 0; j < 3; j++) {
                if ( j == 2 && i == 3) {
                    label = new JLabel("");
                    centerPanel.add(label);
                } else {
                    button = new JButton();
                    button.addActionListener(this);
                    centerPanel.add(button);
                    image = createImage(new FilteredImageSource(source.getSource(),
                        new CropImageFilter(j*width/3, i*height/4, 
                            (width/3)+1, height/4)));
                    button.setIcon(new ImageIcon(image));
                }
            }
        }

        setSize(325, 275);
        setTitle("Puzzle");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args) {

        new Puzzle();

    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        Dimension size = button.getSize();

        // We get the x, y coordinates of the button that we hit and an empty label. 
        // The x, y coordinates are important in the logic of the program
        
        int labelX = label.getX();
        int labelY = label.getY();
        int buttonX = button.getX();
        int buttonY = button.getY();
        
        // Here we get the index of the button in the two dimensional array of the button positions
        
        int buttonPosX = buttonX / size.width;
        int buttonPosY = buttonY / size.height;
        int buttonIndex = pos[buttonPosY][buttonPosX];

        // In this case, we check if we clicked on the button, that is right above the empty label. 
        // If it is above the label, they share the x coordinate. If the button is right above the label, 
        // the equation (labelY - buttonY) == size.height is true

        if (labelX == buttonX && (labelY - buttonY) == size.height ) {

             int labelIndex = buttonIndex + 3;

             centerPanel.remove(buttonIndex);
             centerPanel.add(label, buttonIndex);
             centerPanel.add(button,labelIndex);
             centerPanel.validate();
        }

        if (labelX == buttonX && (labelY - buttonY) == -size.height ) {

             int labelIndex = buttonIndex - 3;
             centerPanel.remove(labelIndex);
             centerPanel.add(button,labelIndex);
             centerPanel.add(label, buttonIndex);
             centerPanel.validate();
        }

        if (labelY == buttonY && (labelX - buttonX) == size.width ) {

             int labelIndex = buttonIndex + 1;

             centerPanel.remove(buttonIndex);
             centerPanel.add(label, buttonIndex);
             centerPanel.add(button,labelIndex);
             centerPanel.validate();
        }

        if (labelY == buttonY && (labelX - buttonX) == -size.width ) {

             int labelIndex = buttonIndex - 1;

             centerPanel.remove(buttonIndex);
             centerPanel.add(label, labelIndex);
             centerPanel.add(button,labelIndex);
             centerPanel.validate();
        }
    }
}
