package wackyracer;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RaceTrack extends JPanel implements Runnable {
    private final List<WackyCharacter> characters;
    private Thread thread;

    public RaceTrack() {
        setBackground(Color.WHITE);
        characters = new ArrayList<>();
    }

    public void addCharacter(WackyCharacter character) {
        characters.add(character);
    }
    
    public List<WackyCharacter> getCharacters(){
        return characters;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the track with a color that changes with each repaint
        setBackground(Color.WHITE);
        // Decrement the track color value to simulate motion
        for (WackyCharacter character : characters) {
            character.draw(g);
        }
    }

    @Override
    public void run() {
        while (true) {
            for (WackyCharacter character : characters) {
                character.move();
                // Stop the character at the edge of the screen
                if (character.getX() < 0) {
                    String message=character.getName()+" win!!!";
                    JOptionPane.showMessageDialog(null, message,"Game Over",JOptionPane.INFORMATION_MESSAGE);
                    thread.stop();
                }
            }
            repaint();

            try {
                // Add a small delay to reduce the speed of the characters
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void startRace() {
        thread = new Thread(this);
        thread.start();
    }

    public void stopRace() {
        thread.stop();
    }
}
