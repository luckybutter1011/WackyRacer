package wackyracer;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TheTeleporter extends WackyCharacter implements SpecialPower{
    
    
    public String name="Teleporter";
    public TheTeleporter(int x, int y, int width, int height, String imagePath, Color characterColor, int speed) {
        super(x, y, width, height, imagePath, characterColor, speed);
        super.setName(name);
    }

    @Override
    public void usePower() {
        // Teleport to a random location on the screen
        double randomValue = Math.random(); // random value between 0.0 and 1.0
        int scaledValue = (int) (randomValue * 90) + 10; // scale to range 10-100
        setX(( getX() - scaledValue));
    }
    
    @Override
    public void move() {
        this.usePower();
    }
}
