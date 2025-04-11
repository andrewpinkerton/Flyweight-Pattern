package edu.atu.fw.blocks;

import edu.atu.fw.Block;

import javax.swing.*;

// Concrete Flyweight
public class WoodBlock implements Block {
    private ImageIcon woodTexture = new ImageIcon("wood.png");
    private int height = 50, width = 50;


    @Override
    public JFrame placeBlock(JFrame frame, int x, int y) {
        JLabel label = new JLabel();
        label.setBounds(x, y, width, height);
        label.setIcon(woodTexture);
        frame.add(label, 0);
        return frame;
    }
}
