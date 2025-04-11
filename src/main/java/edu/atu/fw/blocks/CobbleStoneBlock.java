package edu.atu.fw.blocks;

import edu.atu.fw.Block;

import javax.swing.*;

// Concrete Flyweight
public class CobbleStoneBlock implements Block {
    private ImageIcon cobblestoneTexture = new ImageIcon("cobblestone.png");
    private int height = 50, width = 50;


    @Override
    public JFrame placeBlock(JFrame frame, int x, int y) {
        JLabel label = new JLabel();
        label.setBounds(x, y, width, height);
        label.setIcon(cobblestoneTexture);

        frame.add(label, 0);


        return frame;
    }
}
