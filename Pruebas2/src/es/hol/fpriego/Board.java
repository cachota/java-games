package es.hol.fpriego;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Board extends JPanel {

	/**
	 * The Board is a panel where the game takes place
	 */
	private static final long serialVersionUID = 4863606109116906696L;
	
	// The painting is done inside the paintComponent() method
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawDonut(g);
    }
	
	// It is a good programming practice to delegate the actual painting to a specific method
	
	private void drawDonut(Graphics g) {
		
		// The Graphics2D class extends the Graphics class. It provides more sophisticated control over geometry, 
		// coordinate transformations, color management, and text layout
		
        Graphics2D g2d = (Graphics2D) g;
        
        // The rendering hints are used to make the drawing smooth
        
        RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
        
        // We get the height and the width of the window. We need them to center the donut shape on the window. 
        
        Dimension size = getSize();
        double w = size.getWidth();
        double h = size.getHeight();
        
        // Here we create the ellipse
        
        Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.gray);
        
        // Here the ellipse is rotated 72 times to create a donut shape
        
        for (double deg = 0; deg < 360; deg += 5) {
            AffineTransform at
                    = AffineTransform.getTranslateInstance(w/2, h/2);
            at.rotate(Math.toRadians(deg));
            g2d.draw(at.createTransformedShape(e));
        }
    }

}
