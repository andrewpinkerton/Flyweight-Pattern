package edu.atu.fw;

import javax.swing.*;


public class Steve extends JLabel {
    private final ImageIcon icon = new ImageIcon("steve.png");
    private final int speed = 5;
    private final int jumpSpeed = 10;
    private final int jumpHeight = 100;
    private final int groundY;

    private boolean left, right, jumping;
    private int currentJumpHeight = 0;

    private final Timer moveTimer;
    private final Timer jumpTimer;
    private final int worldWidth;
    private final int worldHeight;

    public Steve(int worldWidth, int worldHeight) {
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        this.setIcon(icon);
        this.setBounds(0, 405, 100, 100);
        this.groundY = this.getY();

        moveTimer = new Timer(20, e -> moveCharacter());
        jumpTimer = new Timer(20, e -> handleJump());

        moveTimer.start();
        jumpTimer.start();
    }

    private void moveCharacter() {
        if (left && getX() > 10)
            setLocation(getX() - speed, getY());
        if (right && getX() < worldWidth - 180)
            setLocation(getX() + speed, getY());
    }

    private void handleJump() {
        if (jumping) {
            if (currentJumpHeight < jumpHeight) {
                setLocation(getX(), getY() - jumpSpeed);
                currentJumpHeight += jumpSpeed;
            } else {
                jumping = false;
            }
        } else if (getY() < groundY) {
            setLocation(getX(), getY() + jumpSpeed);
            if (getY() >= groundY) {
                setLocation(getX(), groundY);
                currentJumpHeight = 0;
            }
        }
    }

    public void keyPressed(char keyChar) {
        switch (keyChar) {
            case 'w':
                if (!jumping && getY() >= groundY) {
                    jumping = true;
                    currentJumpHeight = 0;
                }
                break;
            case 'a': left = true; break;
            case 'd': right = true; break;
        }
    }

    public void keyReleased(char keyChar) {
        switch (keyChar) {
            case 'a': left = false; break;
            case 'd': right = false; break;
        }
    }
}
