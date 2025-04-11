package edu.atu.fw.blocks;

import edu.atu.fw.Block;

import javax.swing.*;

// Concrete Flyweight
public class LeafBlock implements Block {
    private ImageIcon leafTexture = new ImageIcon("leaf.png");
    private int height = 50, width = 50;


    @Override
    public JFrame placeBlock(JFrame frame, int x, int y) {
        JLabel label = new JLabel();
        label.setBounds(x, y, width, height);
        label.setIcon(leafTexture);

        frame.add(label, 0);


        return frame;
    }
}
