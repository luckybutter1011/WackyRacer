package wackyracer;

import java.awt.Color;
import javax.swing.JFrame;

public class TheHulk extends WackyCharacter implements SpecialPower{

    
    public String name="Hulk";
    public TheHulk(int x, int y, int width, int height, String imagePath, Color characterColor, int speed) {
        super(x, y, width, height, imagePath, characterColor, speed);
        super.setName(name);
    }

    @Override
    public void usePower() {
        // Move randomly in different directions
        int dx = (int) (Math.random() * 21) - 10; // random value between -10 and 10
        int dy = (int) (Math.random() * 21) - 10; // random value between -10 and 10
        int newX = getX() + dx*getSpeed();
        int newY = getY() + dy*getSpeed();

        // Check if new position is within bounds of the track
 
        if (newX + getWidth() > 1800) {
            newX = 1800 - getWidth();
        }
        if (newY < 0) {
            newY = 0;
        } else if (newY + getHeight() >= 1000) {
            newY = 1000;
        }
        // Set the new position
        setX(newX);
        setY(newY);
    }

    @Override
    public void move() {
        this.usePower();
    }
}
