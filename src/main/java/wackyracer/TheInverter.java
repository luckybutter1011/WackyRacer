package wackyracer;

import java.awt.Color;
import javax.swing.JFrame;

public class TheInverter extends WackyCharacter implements SpecialPower{
    private int direction = 1;
    
    public String name="Inverter";
    public TheInverter(int x, int y, int width, int height, String imagePath, Color characterColor, int speed) {
        super(x, y, width, height, imagePath, characterColor, speed);
        super.setName(name);
    }
    
    @Override
    public void usePower() {
        // Move up or down based on the current direction
        int newY = getY() + (direction * 10);

        // Check if new Y coordinate is within the bounds of the track
        if (newY < 0) {
            newY = 0;
            direction = 1; // Change direction to move down
        } else if (newY + getHeight() > 1000) {
            newY = 1000 - getHeight();
            direction = -1; // Change direction to move up
        }
        // Set the new Y coordinate
        setY(newY);
        setX(getX()-getSpeed());
    }
    
    @Override
    public void move() {
        this.usePower();
    }
}
