import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Card extends JComponent{
    private int value;
    private int storyPoints;
    private int xPos;
    private int yPos;
    private Random rand;
    private BufferedImage image;
    
    public Card(int x , int y) {
    	this.xPos = x;
    	this.yPos = y;
        rand = new Random();
        // Value is a random number between 1 and 20
        value = rand.nextInt(20) + 1;
        // Story points is a random number between 1 and 12
        storyPoints = rand.nextInt(12) + 1;
        try {
    		image = ImageIO.read(new File("src/BlankCard.jpg"));
    	} catch (IOException ex) {
    		ex.printStackTrace();
    	}
    }
    
    public int getValue() {
        return value;
    }
    
    public void setX(int x) {
    	this.xPos = x;
    }
    
    public void setY(int y) {
    	this.yPos = y;
    }
    
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.drawImage(image, xPos, yPos, null);
    	g.setFont(new Font("TimesRoman" , Font.PLAIN,18));
    	String displaySP = "Story Points: " + storyPoints;
    	g.drawString(displaySP, xPos + 15, yPos + 50);
    	String displayVal = "Value: " + value;
    	g.drawString(displayVal, xPos + 15, yPos + 100);
    }
    
    public int getStoryPoints() {
        return storyPoints;
    }
    
    public int cardFailed() {
        storyPoints -= 1;
        return storyPoints;
    }
}
