package wackyracer;

import 
        javax.swing.JButton;

import 
        javax.swing.JFrame;

import 
        java.awt.BorderLayout;

import 
        java.awt.Color;

import 
        java.awt.event.ActionEvent;

import wackyracer.WackyCharacter;

public class WackyRacer {

    public static void 
        main(String args[]){
        
    Boolean isRunning=false;
    JFrame frame = new JFrame("Wacky Racer Game");

    //-------- Set the size of the frame to fullscreen ----------//
    
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);

    //--------------- Create a new RaceTrack object ------------//
    RaceTrack track = new RaceTrack();

    //-------------- Create characters-------------------------
    createCharacters(track);

    //------- Add the race track to the frame--------------------------//
    frame.add(track);
    
    //------------ Add a start button------------------//
    JButton 
            startButton = new JButton("Start") ;
    
    startButton.addActionListener((ActionEvent e) -> {
        initPlayers(track);
        track.startRace();
    });
    
    frame.
            add(startButton, 
            BorderLayout.NORTH);
    frame.
            setVisible(true);
}

    private static void initPlayers(RaceTrack track){
        WackyCharacter character;
        int y=1100;
        
        for(int i=0 ;i < track.getCharacters().size(); i++){
            character=track.getCharacters().get(i);
            character.setX(1800);
            character.setY(y-=100);
        }
    }
    
    private static void createCharacters(RaceTrack track) {
        String imagePath[] = 
        {
        "images/speeder.png",//Teleporter
        "images/wiz.png",//Dragon
        "images/hk.png",//Hulk
        "images/shrinkk.png",//Flash
        "images/shil.png",//Freezer
        "images/rs.png",//Rocket
        "images/tr.png", //Inverter
        "images/turtle.png",//Shield
        "images/tk.png",//Shrinker
        "images/shifter.png"//Ghost
        };
        
        int speed[] =
        {
        1,
        20,
        20,
        20,
        20,
        20,
        20, 
        20,
        20,
        30//----------------  Ghost -------------------------//10
        };
        
        //-------------- add character ------------//
        track.addCharacter(new TheTeleporter(JFrame.MAXIMIZED_HORIZ+1600, 1000, 50, 30, imagePath[0], Color.BLUE, speed[0]));
        track.addCharacter(new TheDragon(JFrame.MAXIMIZED_HORIZ+1600, 900, 50, 30, imagePath[1], Color.WHITE, speed[1]));
        track.addCharacter(new TheHulk(JFrame.MAXIMIZED_HORIZ+1600, 800, 50, 30, imagePath[2], Color.WHITE, speed[2]));
        track.addCharacter(new TheFlash(JFrame.MAXIMIZED_HORIZ+1600, 700, 50, 30, imagePath[3], Color.WHITE, speed[3]));
        track.addCharacter(new TheFreezer(JFrame.MAXIMIZED_HORIZ+1600, 600, 50, 30, imagePath[4], Color.WHITE, speed[4]));
        track.addCharacter(new TheRocket(JFrame.MAXIMIZED_HORIZ+1600, 500, 50, 30, imagePath[5], Color.WHITE, speed[5]));
        track.addCharacter(new TheInverter(JFrame.MAXIMIZED_HORIZ+1600 , 400, 50, 30, imagePath[6], Color.WHITE, speed[6]));
        track.addCharacter(new TheShield(JFrame.MAXIMIZED_HORIZ+1600 , 300, 50, 30, imagePath[7], Color.WHITE, speed[7]));//fdsafsafds
        track.addCharacter(new TheShrinker(JFrame.MAXIMIZED_HORIZ+1600 , 200, 50, 30, imagePath[8], Color.WHITE, speed[8]));//dfsadsfdsfds
        track.addCharacter(new TheGhost(JFrame.MAXIMIZED_HORIZ+1600, 0, 100, 30, imagePath[9], Color.WHITE, speed[9]));
    }
}
