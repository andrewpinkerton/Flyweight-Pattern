package edu.atu.fw;

import javax.swing.*;

public class WorldGeneration {
    static int blockSize = 51;

    public static void tree(JFrame frame, int x, int y) {
        Block woodBlock = BlockFactory.getBlock(BlockFactory.BlockType.wood);
        Block leafBlock = BlockFactory.getBlock(BlockFactory.BlockType.leaf);

        final int trunkHeight = 3;
        final int blockSpacing = 50;
        final int leafOffset = 51;
        final int leafTopOffset = 102;
        final int[] horizontalOffsets = {-2, -1, 1, 2};

        for (int i = 1; i <= trunkHeight; i++) {
            int trunkY = y - (blockSpacing * i);
            woodBlock.placeBlock(frame, x, trunkY);

            if (i == trunkHeight) {
                for (int offset : horizontalOffsets) {
                    leafBlock.placeBlock(frame, x + (offset * blockSize), trunkY);
                }

                leafBlock.placeBlock(frame, x, trunkY - leafOffset);
                leafBlock.placeBlock(frame, x - blockSize, trunkY - leafOffset);
                leafBlock.placeBlock(frame, x + blockSize, trunkY - leafOffset);

                // Top leaf
                leafBlock.placeBlock(frame, x, trunkY - leafTopOffset);
            }
        }
    }

    public static void generateWorld(JFrame frame) {
        for (int i = 0; i < 20; i ++) {
            int x = i * blockSize;
            Block dirtblock = BlockFactory.getBlock(BlockFactory.BlockType.dirt);

            dirtblock.placeBlock(frame, x, 500);

            if (i == 13) {
                tree(frame, x, 500);
            }

            for (int j = 1; j <= 3; j ++) {
                Block cobblestoneblock = BlockFactory.getBlock(BlockFactory.BlockType.cobblestone);
                cobblestoneblock.placeBlock(frame, (i * blockSize), 500 + (j * blockSize));
            }
        }
    }
}
