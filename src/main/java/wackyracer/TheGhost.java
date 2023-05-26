package wackyracer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;

public class TheGhost extends WackyCharacter implements SpecialPower {

    private boolean isVisible = false;
    public String name="TheGhost";
    
    public TheGhost(int x, int y, int width, int height, String imagePath, Color characterColor, int speed) {
        super(x, y, width, height, imagePath, characterColor, speed);
        super.setName(name);
    }
    
    @Override
    public void usePower() {
        isVisible = !isVisible;
    }

    @Override
    public void move() {
        this.usePower();
        
        if (isVisible) {
            // Move towards the left
            setX(getX() - getSpeed());
        }
        
        // Check if the character is out of the screen
        if (getX() + getWidth() < 0) {
            // Reset the character to the right side of the screen
            setX(JFrame.MAXIMIZED_HORIZ);
        }
    }
    
    @Override
    public void draw(Graphics g) {
        if (isVisible) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.WHITE);
            g2d.fillRect(getX(), getY(), getWidth(), getHeight());
        }
    }
}
