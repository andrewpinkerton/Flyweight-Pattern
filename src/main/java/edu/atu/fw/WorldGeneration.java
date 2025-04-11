package edu.atu.fw;

import javax.swing.*;

public class WorldGeneration {
    static int blockOffset = 51;
    static int trunkHeight = 3;
    static int blockSpacing = 50;
    static final int[] horizontalOffsets = {-2, -1, 1, 2};

    public static void tree(JFrame frame, int x, int y) {
        Block woodBlock = BlockFactory.getBlock(BlockFactory.BlockType.wood);
        Block leafBlock = BlockFactory.getBlock(BlockFactory.BlockType.leaf);

        for (int i = 1; i <= trunkHeight; i++) {
            int trunkY = y - (blockSpacing * i);
            woodBlock.placeBlock(frame, x, trunkY);

            if (i == trunkHeight) {
                for (int offset : horizontalOffsets) {
                    leafBlock.placeBlock(frame, x + (offset * blockOffset), trunkY);
                }

                leafBlock.placeBlock(frame, x, trunkY - blockOffset);
                leafBlock.placeBlock(frame, x - blockOffset, trunkY - blockOffset);
                leafBlock.placeBlock(frame, x + blockOffset, trunkY - blockOffset);
                leafBlock.placeBlock(frame, x, trunkY - (blockOffset * 2));
            }
        }
    }

    public static void generateWorld(JFrame frame) {
        Block dirtBlock = BlockFactory.getBlock(BlockFactory.BlockType.dirt);
        Block cobblestoneBlock = BlockFactory.getBlock(BlockFactory.BlockType.cobblestone);

        for (int i = 0; i < 20; i++) {
            int x = i * blockOffset;
            dirtBlock.placeBlock(frame, x, 500);

            if (i == 13) {
                tree(frame, x, 500);
            }

            for (int j = 1; j <= 3; j++) {
                cobblestoneBlock.placeBlock(frame, x, 500 + (j * blockOffset));
            }
        }
    }
}
