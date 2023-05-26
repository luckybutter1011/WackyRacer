package wackyracer;

import java.awt.Color;

public class TheFreezer extends WackyCharacter implements SpecialPower{
    private static final int JUMP_DISTANCE = 100;
    private static final int JUMP_DELAY = 200;
    private long lastJumpTime = System.currentTimeMillis() - JUMP_DELAY;
    private boolean jumping = false;
    public String name="TheFreezer";
    
    public TheFreezer(int x, int y, int width, int height, String imagePath, Color characterColor, int speed) {
        super(x, y, width, height, imagePath, characterColor, speed);
        super.setName(name);
    }
    
    @Override
    public void usePower() {
        if (!jumping && System.currentTimeMillis() - lastJumpTime >= JUMP_DELAY) {
            jumping = true;
            lastJumpTime = System.currentTimeMillis();
        }
        
        if (jumping) {
         // Move character up by JUMP_DISTANCE
         setY(getY() - JUMP_DISTANCE);
         jumping = false;
        } else {
            // Move character down by its speed
            setY(getY() + JUMP_DISTANCE);
        }
        
         if (getY() < 0) {
             setY(0);
        } else if (getY() + getHeight() > 1000) {
             setY(1000);
        }
         
        setX(getX()-getSpeed());
    }
    
    @Override
    public void move() {
        this.usePower();
    }
}
