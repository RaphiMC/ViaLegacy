package net.raphimc.vialegacy.protocols.beta.protocolb1_2_0_2tob1_1_2.rewriter;

import net.raphimc.vialegacy.api.data.BlockList1_6;
import net.raphimc.vialegacy.api.model.IdAndData;
import net.raphimc.vialegacy.api.remapper.AbstractBlockRemapper;

public class BlockDataRewriter extends AbstractBlockRemapper {

    public BlockDataRewriter() {
        for (int i = 1; i < 16; i++) { // cobblestone
            this.registerReplacement(new IdAndData(BlockList1_6.cobblestone.blockID, i), new IdAndData(BlockList1_6.cobblestone.blockID, 0));
        }
        for (int i = 1; i < 16; i++) { // sand
            this.registerReplacement(new IdAndData(BlockList1_6.sand.blockID, i), new IdAndData(BlockList1_6.sand.blockID, 0));
        }
        for (int i = 1; i < 16; i++) { // gravel
            this.registerReplacement(new IdAndData(BlockList1_6.gravel.blockID, i), new IdAndData(BlockList1_6.gravel.blockID, 0));
        }
        for (int i = 1; i < 16; i++) { // obsidian
            this.registerReplacement(new IdAndData(BlockList1_6.obsidian.blockID, i), new IdAndData(BlockList1_6.obsidian.blockID, 0));
        }
    }

}
