package wackyracer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;

public class WackyCharacter implements Observer {
    private int x;
    private int y;
    private int width;
    private int height;
    private BufferedImage image;
    private String name;
    private Color characterColor;
    private int speed;

    public WackyCharacter(int x, int y, int width, int height, String imagePath, Color characterColor, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.characterColor = characterColor;
        this.speed = speed;

        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ex) {
            System.out.println("Error loading image: " + ex.getMessage());
        }
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, null);
    }

    public void move() {
        x -= speed;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String na){
        name=na;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    

    @Override
    public void update(Observable o, Object o1) {
    }
}
