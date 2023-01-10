package net.raphimc.vialegacy.protocols.release.protocol1_2_1_3to1_1.model;

import com.viaversion.viaversion.api.minecraft.BlockChangeRecord;
import com.viaversion.viaversion.api.minecraft.BlockChangeRecord1_8;
import com.viaversion.viaversion.api.minecraft.Position;
import com.viaversion.viaversion.api.minecraft.chunks.BaseChunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.CompoundTag;

import java.util.ArrayList;
import java.util.List;

public class NonFullChunk1_1 extends BaseChunk {

    private final Position startPos;
    private final Position endPos;

    public NonFullChunk1_1(int x, int z, int bitmask, ChunkSection[] sections, Position startPos, Position endPos) {
        super(x, z, false, false, bitmask, sections, null, new CompoundTag(), new ArrayList<>());

        this.startPos = startPos;
        this.endPos = endPos;
    }

    public Position getStartPos() {
        return this.startPos;
    }

    public Position getEndPos() {
        return this.endPos;
    }

    public List<BlockChangeRecord> asBlockChangeRecords() {
        final List<BlockChangeRecord> blockChangeRecords = new ArrayList<>();

        for (int y = this.startPos.y(); y < this.endPos.y(); y++) {
            final ChunkSection section = this.getSections()[y >> 4];
            for (int x = this.startPos.x(); x < this.endPos.x(); x++) {
                for (int z = this.startPos.z(); z < this.endPos.z(); z++) {
                    blockChangeRecords.add(new BlockChangeRecord1_8(x, y, z, section.palette(PaletteType.BLOCKS).idAt(x, y & 15, z)));
                }
            }
        }

        return blockChangeRecords;
    }

}
