package devFrame;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class main {
	
	public static void main(String[] args){
		
		JFrame frame = new JFrame();
		frame.setTitle("Draw01");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    System.out.println("Frame wurde initialisiert");
		
		PictureCreator drawPanel = new PictureCreator("res/kaempfer.pix");
//		System.out.println("PictureCreator wurde initialisiert");
		
		frame.getContentPane().add(drawPanel);
//		System.out.println("übergeben drawPanel an den Frame");
		frame.setSize(500,500);		
//		System.out.println("Frame set 500 x 500");
		
		frame.setVisible(true);
//		System.out.println("Frame set sichtbar"); 
	}
}


