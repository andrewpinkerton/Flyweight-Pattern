package edu.atu.fw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements KeyListener{
    JLabel character;
    ImageIcon icon;
    boolean up, down, left, right;
    Timer moveTimer;
    int speed = 10;
    int maxX = 800, maxY = 800, minX = 0, minY = 0;


    MyFrame() {
        this.setTitle("Flyweight Pattern Demonstration");
        this.setSize(maxX,maxY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.addKeyListener(this);
        this.setResizable(false);
        this.setLayout(null);

        character = new JLabel();
        icon = new ImageIcon("character.png");

        character.setBounds(0, 550, 250, 250);
        character.setIcon(icon);

        moveTimer = new Timer(20, e -> {
            if (up && !(character.getY() < minY))
                character.setLocation(character.getX(), character.getY() - speed);
            if (down && !(character.getY() > maxY - 225))
                character.setLocation(character.getX(), character.getY() + speed);
            if (left && !(character.getX() < minX))
                character.setLocation(character.getX() - speed, character.getY());
            if (right && !(character.getX() > maxX - 150))
                character.setLocation(character.getX() + speed, character.getY());
        });
        moveTimer.start();

        this.add(character);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w': up = true; break;
            case 'a': left = true; break;
            case 's': down = true; break;
            case 'd': right = true; break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w': up = false; break;
            case 'a': left = false; break;
            case 's': down = false; break;
            case 'd': right = false; break;
        }
    }
}
