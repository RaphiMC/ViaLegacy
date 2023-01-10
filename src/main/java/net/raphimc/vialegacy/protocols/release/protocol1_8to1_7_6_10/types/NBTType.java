package net.raphimc.vialegacy.protocols.release.protocol1_8to1_7_6_10.types;

import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.libs.opennbt.NBTIO;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class NBTType extends Type<CompoundTag> {

    private final boolean compressed;

    public NBTType(final boolean compressed) {
        super(CompoundTag.class);
        this.compressed = compressed;
    }

    @Override
    public CompoundTag read(ByteBuf buffer) throws IOException {
        final short length = buffer.readShort();
        if (length <= 0) {
            return null;
        }

        final ByteBuf data = buffer.readSlice(length);
        try (InputStream in = this.compressed ? new GZIPInputStream(new ByteBufInputStream(data)) : new ByteBufInputStream(data)) {
            return NBTIO.readTag(in);
        }
    }

    @Override
    public void write(ByteBuf buffer, CompoundTag nbt) throws Exception {
        if (nbt == null) {
            buffer.writeShort(-1);
            return;
        }

        final ByteBuf data = buffer.alloc().buffer();
        try {
            try (OutputStream out = this.compressed ? new GZIPOutputStream(new ByteBufOutputStream(data)) : new ByteBufOutputStream(data)) {
                NBTIO.writeTag(out, nbt);
            }

            buffer.writeShort(data.readableBytes());
            buffer.writeBytes(data);
        } finally {
            data.release();
        }
    }

}
