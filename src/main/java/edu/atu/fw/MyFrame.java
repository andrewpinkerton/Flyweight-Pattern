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
    int speed = 15;
    int maxX = 1800, maxY = 800, minX = 0, minY = 0;


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

        moveTimer = new Timer(0, e -> {
            if (up && !(character.getY() < minY - 50))
                character.setLocation(character.getX(), character.getY() - speed);
            if (down && !(character.getY() > maxY - 250))
                character.setLocation(character.getX(), character.getY() + speed);
            if (left && !(character.getX() < minX + 10))
                character.setLocation(character.getX() - speed, character.getY());
            if (right && !(character.getX() > maxX - 180))
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
            case ' ': shoot(); break;
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

    void shoot(){
        JLabel bullet = new JLabel();
        ImageIcon bulletIcon = new ImageIcon("bullet.png");
        bullet.setBounds(character.getX() + 150, character.getY() + 93, 76,76);
        bullet.setIcon(bulletIcon);

        this.add(bullet);
        this.repaint();

        Timer bulletTimer = new Timer(10, null);
        bulletTimer.addActionListener(e -> {
            bullet.setLocation(bullet.getX()+20, bullet.getY());

            if (bullet.getX() > maxX) {
                bulletTimer.stop();
                this.remove(bullet);
                this.repaint();
            }
        });

        bulletTimer.start();
    }
}
