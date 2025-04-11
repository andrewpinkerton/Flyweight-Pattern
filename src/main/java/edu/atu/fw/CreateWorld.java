package edu.atu.fw;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Client
public class CreateWorld extends JFrame implements KeyListener {
    Steve character;
    int width;
    int height;

    public CreateWorld(int width, int height) {
        this.width = width;
        this.height = height;

        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        addKeyListener(this);

        ImageIcon backgroundImage = new ImageIcon("background.png");
        JLabel background = new JLabel();
        background.setIcon(backgroundImage);
        background.setBounds(0,0,width, height);
        add(background, -1);

        WorldGeneration.generateWorld(this);

        character = new Steve(width, height);
        add(character, 0);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CreateWorld(1035, 742);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        character.keyPressed(e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        character.keyReleased(e.getKeyChar());
    }
}
