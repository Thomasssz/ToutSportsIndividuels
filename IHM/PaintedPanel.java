package IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
 
public class PaintedPanel extends JPanel {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 3646926884628058682L;
	
	private Color background = new Color(63, 149, 245);
	private BufferedImage image;
	
	private int id_utilisateur;
     
    public PaintedPanel(URL  url , JButton btn){
    	this.setPreferredSize(new Dimension(400,160));
    	//this.setBorder(BorderFactory.createLineBorder(background,10));
    	this.setLayout(new FlowLayout(FlowLayout.CENTER,0 , 30));
    	this.setBackground(background);
    	
    	 try {
             image = ImageIO.read(url);
         } catch (IOException e) {
             e.printStackTrace();
         }
        
        Font police = new Font("Arial", Font.BOLD, 50);
        
        btn.setFont(police);
        //btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);	
        
        this.add(btn);
        
        btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Menu(id_utilisateur);
			}
		});
    }
     
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
        g.drawImage(image, 50, 0, this);
    }
}