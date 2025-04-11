package edu.atu.fw;

import java.util.HashMap;

public class BlockFactory {
    private static final HashMap<BlockType, Block> blocks = new HashMap<BlockType, Block>();

    public static Block getBlock(BlockType blockType) {
        Block block = blocks.get(blockType);

        if (block == null) {
            if (blockType.equals(BlockType.dirt)){
                block = new DirtBlock();
                System.out.println("Created new DirtBlock");

            } else if (blockType.equals(BlockType.cobblestone)) {
                block = new CobbleStoneBlock();
                System.out.println("Created new Cobble stone Block");

            } else if (blockType.equals(BlockType.wood)) {
                block = new WoodBlock();
                System.out.println("Created new Wood Block");

            } else if (blockType.equals(BlockType.leaf)) {
                block = new LeafBlock();
                System.out.println("Created new Wood Block");
            }


            blocks.put(blockType, block);
        }

        return block;
    }






    public enum BlockType{
        dirt, cobblestone, wood, leaf;
    }
}
