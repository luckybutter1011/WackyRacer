package wackyracer;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TheDragon extends WackyCharacter implements SpecialPower{
    
    private int direction = -1; // 1 for moving right, -1 for moving left
    public String name="TheDragon";
    public TheDragon(int x, int y, int width, int height, String imagePath, Color characterColor, int speed) {
        super(x, y, width, height, imagePath, characterColor, speed);
        super.setName(name);
    } 
    
    @Override
    public void usePower() {
       int dx = this.getSpeed() * direction;
        this.setX(this.getX() + dx);
        
        // Check if the dragon has reached the left or right edge of the screen
        int leftEdge = 0;
        int rightEdge = 1800 - this.getWidth();
        if (this.getX() <= leftEdge || this.getX() >= rightEdge) {
            // Change direction
            
        } 
    }
    
    @Override
    public void move() {
        usePower();
    }
}
