package devFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JPanel;

class PictureCreator extends JPanel{
	public static String strPixPath; 
	public PictureCreator(String strPixPathInBound){
		strPixPath = strPixPathInBound;
		repaint();
	}
	public void paintGraphic(Graphics g) throws IOException{
		
		System.out.println("paintGraphic wurde initialisiert");
		super.paintComponent(g);
		
		//DateiPfad setzen und .pix auslesen
		System.out.println("Pfad wurde übernommen: " + strPixPath);
		File doc = new File(strPixPath); 
		BufferedReader obj = new BufferedReader(new FileReader(doc));
		String strPixData;
		//auf Inhaltprüfen
		while ((strPixData = obj.readLine()) != null);
		System.out.println(strPixData);
		
		//hier der pfad ausgelsen werden kann
		String[] Colors = new String[] {strPixData};
	
		int intColorleght = Colors.length;
		int intLineCheck = 0;
		int intINTLC = 0;
		System.out.println(intColorleght);
		
		int intPixBiggness = 50;
		
		int intCooX = 0;
		int intCooY = intCooX;
		//Checken des Strings auf Rastergröße
		boolean booRasterCheck = true;
		while (true)
		{
			intINTLC = intINTLC + 1 ;
			intLineCheck = intColorleght / intINTLC;
		    if (intLineCheck == intINTLC) 
		    {
		    	System.out.println("Feld " + intLineCheck + " x " + intINTLC);
		        break;
		    }
		    System.out.println("Feld " + intLineCheck + " x " + intINTLC);
		    if (intColorleght < intINTLC) 
		    {
		    	System.out.println("Fehler Daten nicht kompatible.");
		    	System.out.println("Raster konnte nicht errechnet werden.");
		    	booRasterCheck = false;
		        break;
		    }
		   
		}
	
		BufferedImage bufImg = new BufferedImage(500,500,BufferedImage.TYPE_INT_RGB);
		Graphics gBuf = bufImg.createGraphics();
		booRasterCheck = true;
		if (booRasterCheck) {
			boolean booFirstCheck = false;
			
			for (int i = 0; i < intColorleght; i++) {
				
				System.out.println(Colors[i]);
				g.setColor(Color.decode(Colors[i]));
				
//				intCooY = intCooY + 50;
				
				 
				if ( (i%intINTLC) == 0 && booFirstCheck ) {
					intCooX = 0;
					booFirstCheck = false;
					intCooY = intCooY + 50;
//					intCooX = intCooX + 50;
					System.out.println("2.a Check == 0" + intINTLC + " Check == 0" + (i%intINTLC) );
				}
				//Ausgefülltes Viereck zeichnen
				gBuf.fillRect(intCooX, intCooY, intPixBiggness, intPixBiggness);
				intCooX = intCooX + 50;
				System.out.println("A Check == 0" + intINTLC + " Check == 0" + (i%intINTLC)  );
				
				booFirstCheck = true;
			}
			
		}
		JPanel panelBufImg = new JPanel(); 
		panelBufImg.setBounds(200,0,500,500);
		if (panelBufImg.equals(null)) System.out.println("Hat nicht geklappt NULL, Mann");
		Graphics g2 = bufImg.createGraphics();
		
	    g2.drawImage(bufImg, 0, 0, null);
	    //return g2;
		 

	}
}