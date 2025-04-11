package edu.atu.fw;

import javax.swing.*;

public class DirtBlock implements Block {
    private ImageIcon dirtTexture = new ImageIcon("dirt.png");
    private int height = 50, width = 50;


    @Override
    public JFrame placeBlock(JFrame frame, int x, int y) {
        JLabel label = new JLabel();
        label.setBounds(x, y, width, height);
        label.setIcon(dirtTexture);

        frame.add(label, 0);


        return frame;
    }
}
