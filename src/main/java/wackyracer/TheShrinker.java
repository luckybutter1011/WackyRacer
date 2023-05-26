package wackyracer;

import java.awt.Color;

public class TheShrinker extends WackyCharacter implements SpecialPower{
    private String name="Shrinker";
    public TheShrinker(int x, int y, int width, int height, String imagePath, Color characterColor, int speed) {
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
