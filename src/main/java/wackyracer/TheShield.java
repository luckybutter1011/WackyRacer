package wackyracer;

import java.awt.Color;
import javax.swing.JFrame;


public class TheShield extends WackyCharacter implements SpecialPower {

    
    public String name="Shield";
    private boolean isHopping = false;
    private int hopHeight = 50;
    private int hopCounter = 0;

    public TheShield(int x, int y, int width, int height, String imagePath, Color characterColor, int speed) {
        super(x, y, width, height, imagePath, characterColor, speed);
        super.setName(name);
    }

    @Override
    public void usePower() {
        if (!isHopping) {
            isHopping = true;
            hopCounter = 0;
        } else {
            hopCounter++;
            if (hopCounter > hopHeight) {
                isHopping = false;
                hopCounter = 0;
            }
        }
        // Move up or down depending on hop status
        int newY = getY() - (isHopping ? 2 : -2);
        // Check if new Y coordinate is within the bounds of the track
        if (newY < 0) {
            newY = 0;
        } else if (newY + getHeight() > 1000) {
            newY = 1000;
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

