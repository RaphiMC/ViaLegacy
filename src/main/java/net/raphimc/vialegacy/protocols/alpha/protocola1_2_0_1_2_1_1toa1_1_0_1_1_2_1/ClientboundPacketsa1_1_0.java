package net.raphimc.vialegacy.protocols.alpha.protocola1_2_0_1_2_1_1toa1_1_0_1_1_2_1;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import io.netty.buffer.ByteBuf;
import net.raphimc.vialegacy.api.splitter.PreNettyPacketType;

import java.util.function.BiConsumer;

import static net.raphimc.vialegacy.api.splitter.PreNettyTypes.readItemStackb1_2;
import static net.raphimc.vialegacy.api.splitter.PreNettyTypes.readUTF;

public enum ClientboundPacketsa1_1_0 implements ClientboundPacketType, PreNettyPacketType {

    KEEP_ALIVE(0, (user, buf) -> {
    }),
    JOIN_GAME(1, (user, buf) -> {
        buf.readInt();
        readUTF(buf);
        readUTF(buf);
    }),
    HANDSHAKE(2, (user, buf) -> {
        readUTF(buf);
    }),
    CHAT_MESSAGE(3, (user, buf) -> {
        readUTF(buf);
    }),
    TIME_UPDATE(4, (user, buf) -> {
        buf.readLong();
    }),
    PLAYER_INVENTORY(5, (user, buf) -> {
        buf.readInt();
        int x = buf.readShort();
        for (int i = 0; i < x; i++) readItemStackb1_2(buf);
    }),
    SPAWN_POSITION(6, (user, buf) -> {
        buf.readInt();
        buf.readInt();
        buf.readInt();
    }),
    PLAYER_POSITION_ONLY_ONGROUND(10, (user, buf) -> {
        buf.readUnsignedByte();
    }),
    PLAYER_POSITION_ONLY_POSITION(11, (user, buf) -> {
        buf.readDouble();
        buf.readDouble();
        buf.readDouble();
        buf.readDouble();
        buf.readUnsignedByte();
    }),
    PLAYER_POSITION_ONLY_LOOK(12, (user, buf) -> {
        buf.readFloat();
        buf.readFloat();
        buf.readUnsignedByte();
    }),
    PLAYER_POSITION(13, (user, buf) -> {
        buf.readDouble();
        buf.readDouble();
        buf.readDouble();
        buf.readDouble();
        buf.readFloat();
        buf.readFloat();
        buf.readUnsignedByte();
    }),
    HELD_ITEM_CHANGE(16, (user, buf) -> {
        buf.readInt();
        buf.readShort();
    }),
    ADD_TO_INVENTORY(17, (user, buf) -> {
        buf.readShort();
        buf.readByte();
        buf.readShort();
    }),
    ENTITY_ANIMATION(18, (user, buf) -> {
        buf.readInt();
        buf.readByte();
    }),
    SPAWN_PLAYER(20, (user, buf) -> {
        buf.readInt();
        readUTF(buf);
        buf.readInt();
        buf.readInt();
        buf.readInt();
        buf.readByte();
        buf.readByte();
        buf.readShort();
    }),
    SPAWN_ITEM(21, (user, buf) -> {
        buf.readInt();
        buf.readShort();
        buf.readByte();
        buf.readInt();
        buf.readInt();
        buf.readInt();
        buf.readByte();
        buf.readByte();
        buf.readByte();
    }),
    COLLECT_ITEM(22, (user, buf) -> {
        buf.readInt();
        buf.readInt();
    }),
    SPAWN_ENTITY(23, (user, buf) -> {
        buf.readInt();
        buf.readByte();
        buf.readInt();
        buf.readInt();
        buf.readInt();
    }),
    SPAWN_MOB(24, (user, buf) -> {
        buf.readInt();
        buf.readByte();
        buf.readInt();
        buf.readInt();
        buf.readInt();
        buf.readByte();
        buf.readByte();
    }),
    DESTROY_ENTITIES(29, (user, buf) -> {
        buf.readInt();
    }),
    ENTITY_MOVEMENT(30, (user, buf) -> {
        buf.readInt();
    }),
    ENTITY_POSITION(31, (user, buf) -> {
        buf.readInt();
        buf.readByte();
        buf.readByte();
        buf.readByte();
    }),
    ENTITY_ROTATION(32, (user, buf) -> {
        buf.readInt();
        buf.readByte();
        buf.readByte();
    }),
    ENTITY_POSITION_AND_ROTATION(33, (user, buf) -> {
        buf.readInt();
        buf.readByte();
        buf.readByte();
        buf.readByte();
        buf.readByte();
        buf.readByte();
    }),
    ENTITY_TELEPORT(34, (user, buf) -> {
        buf.readInt();
        buf.readInt();
        buf.readInt();
        buf.readInt();
        buf.readByte();
        buf.readByte();
    }),
    PRE_CHUNK(50, (user, buf) -> {
        buf.readInt();
        buf.readInt();
        buf.readByte();
    }),
    CHUNK_DATA(51, (user, buf) -> {
        buf.readInt();
        buf.readShort();
        buf.readInt();
        buf.readByte();
        buf.readByte();
        buf.readByte();
        int x = buf.readInt();
        for (int i = 0; i < x; i++) buf.readByte();
    }),
    MULTI_BLOCK_CHANGE(52, (user, buf) -> {
        buf.readInt();
        buf.readInt();
        short x = buf.readShort();
        for (int i = 0; i < x; i++) buf.readShort();
        for (int i = 0; i < x; i++) buf.readByte();
        for (int i = 0; i < x; i++) buf.readByte();
    }),
    BLOCK_CHANGE(53, (user, buf) -> {
        buf.readInt();
        buf.readUnsignedByte();
        buf.readInt();
        buf.readUnsignedByte();
        buf.readUnsignedByte();
    }),
    COMPLEX_ENTITY(59, (user, buf) -> {
        buf.readInt();
        buf.readShort();
        buf.readInt();
        int x = buf.readUnsignedShort();
        for (int i = 0; i < x; i++) buf.readByte();
    }),
    DISCONNECT(255, (user, buf) -> {
        readUTF(buf);
    });

    private static final ClientboundPacketsa1_1_0[] REGISTRY = new ClientboundPacketsa1_1_0[256];

    static {
        for (ClientboundPacketsa1_1_0 packet : values()) {
            REGISTRY[packet.id] = packet;
        }
    }

    public static ClientboundPacketsa1_1_0 getPacket(final int id) {
        return REGISTRY[id];
    }

    private final int id;
    private final BiConsumer<UserConnection, ByteBuf> packetReader;

    ClientboundPacketsa1_1_0(final int id, final BiConsumer<UserConnection, ByteBuf> packetReader) {
        this.id = id;
        this.packetReader = packetReader;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return name();
    }

    @Override
    public BiConsumer<UserConnection, ByteBuf> getPacketReader() {
        return this.packetReader;
    }

}
