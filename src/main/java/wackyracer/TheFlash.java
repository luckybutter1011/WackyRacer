package wackyracer;

import java.awt.Color;
import javax.swing.JFrame;

public class TheFlash extends WackyCharacter implements SpecialPower{

    private boolean isVisible;
    public String name="TheFlash";
    public TheFlash(int x, int y, int width, int height, String imagePath, Color characterColor, int speed) {
        super(x, y, width, height, imagePath, characterColor, speed);
        super.setName(name);
        isVisible = true;
    }

    @Override
    public void usePower() {
        super.move();
    }

    @Override
    public void move() {
        usePower();
    }
}
