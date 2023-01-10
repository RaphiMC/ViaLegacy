package net.raphimc.vialegacy.protocols.release.protocol1_2_1_3to1_1;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import io.netty.buffer.ByteBuf;
import net.raphimc.vialegacy.api.splitter.PreNettyPacketType;
import net.raphimc.vialegacy.api.splitter.PreNettyTypes;

import java.util.function.BiConsumer;

public enum ClientboundPackets1_1 implements ClientboundPacketType, PreNettyPacketType {

    KEEP_ALIVE(0, (user, buf) -> {
        buf.readInt();
    }),
    JOIN_GAME(1, (user, buf) -> {
        buf.readInt();
        PreNettyTypes.readString(buf);
        buf.readLong();
        PreNettyTypes.readString(buf);
        buf.readInt();
        buf.readByte();
        buf.readByte();
        buf.readByte();
        buf.readByte();
    }),
    HANDSHAKE(2, (user, buf) -> {
        PreNettyTypes.readString(buf);
    }),
    CHAT_MESSAGE(3, (user, buf) -> {
        PreNettyTypes.readString(buf);
    }),
    TIME_UPDATE(4, (user, buf) -> {
        buf.readLong();
    }),
    ENTITY_EQUIPMENT(5, (user, buf) -> {
        buf.readInt();
        buf.readShort();
        buf.readShort();
        buf.readShort();
    }),
    SPAWN_POSITION(6, (user, buf) -> {
        buf.readInt();
        buf.readInt();
        buf.readInt();
    }),
    UPDATE_HEALTH(8, (user, buf) -> {
        buf.readShort();
        buf.readShort();
        buf.readFloat();
    }),
    RESPAWN(9, (user, buf) -> {
        buf.readByte();
        buf.readByte();
        buf.readByte();
        buf.readShort();
        buf.readLong();
        PreNettyTypes.readString(buf);
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
    USE_BED(17, (user, buf) -> {
        buf.readInt();
        buf.readByte();
        buf.readInt();
        buf.readByte();
        buf.readInt();
    }),
    ENTITY_ANIMATION(18, (user, buf) -> {
        buf.readInt();
        buf.readByte();
    }),
    SPAWN_PLAYER(20, (user, buf) -> {
        buf.readInt();
        PreNettyTypes.readString(buf);
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
        buf.readShort();
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
        int i = buf.readInt();
        if (i > 0) {
            buf.readShort();
            buf.readShort();
            buf.readShort();
        }
    }),
    SPAWN_MOB(24, (user, buf) -> {
        buf.readInt();
        buf.readByte();
        buf.readInt();
        buf.readInt();
        buf.readInt();
        buf.readByte();
        buf.readByte();
        PreNettyTypes.readEntityMetadatab1_5(buf);
    }),
    SPAWN_PAINTING(25, (user, buf) -> {
        buf.readInt();
        PreNettyTypes.readString(buf);
        buf.readInt();
        buf.readInt();
        buf.readInt();
        buf.readInt();
    }),
    SPAWN_EXPERIENCE_ORB(26, (user, buf) -> {
        buf.readInt();
        buf.readInt();
        buf.readInt();
        buf.readInt();
        buf.readShort();
    }),
    ENTITY_VELOCITY(28, (user, buf) -> {
        buf.readInt();
        buf.readShort();
        buf.readShort();
        buf.readShort();
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
    ENTITY_STATUS(38, (user, buf) -> {
        buf.readInt();
        buf.readByte();
    }),
    ATTACH_ENTITY(39, (user, buf) -> {
        buf.readInt();
        buf.readInt();
    }),
    ENTITY_METADATA(40, (user, buf) -> {
        buf.readInt();
        PreNettyTypes.readEntityMetadatab1_5(buf);
    }),
    ENTITY_EFFECT(41, (user, buf) -> {
        buf.readInt();
        buf.readByte();
        buf.readByte();
        buf.readShort();
    }),
    REMOVE_ENTITY_EFFECT(42, (user, buf) -> {
        buf.readInt();
        buf.readByte();
    }),
    SET_EXPERIENCE(43, (user, buf) -> {
        buf.readFloat();
        buf.readShort();
        buf.readShort();
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
    BLOCK_ACTION(54, (user, buf) -> {
        buf.readInt();
        buf.readShort();
        buf.readInt();
        buf.readUnsignedByte();
        buf.readUnsignedByte();
    }),
    EXPLOSION(60, (user, buf) -> {
        buf.readDouble();
        buf.readDouble();
        buf.readDouble();
        buf.readFloat();
        int x = buf.readInt();
        for (int i = 0; i < x; i++) {
            buf.readByte();
            buf.readByte();
            buf.readByte();
        }
    }),
    EFFECT(61, (user, buf) -> {
        buf.readInt();
        buf.readInt();
        buf.readByte();
        buf.readInt();
        buf.readInt();
    }),
    GAME_EVENT(70, (user, buf) -> {
        buf.readByte();
        buf.readByte();
    }),
    SPAWN_GLOBAL_ENTITY(71, (user, buf) -> {
        buf.readInt();
        buf.readByte();
        buf.readInt();
        buf.readInt();
        buf.readInt();
    }),
    OPEN_WINDOW(100, (user, buf) -> {
        buf.readByte();
        buf.readByte();
        PreNettyTypes.readString(buf);
        buf.readByte();
    }),
    CLOSE_WINDOW(101, (user, buf) -> {
        buf.readByte();
    }),
    SET_SLOT(103, (user, buf) -> {
        buf.readByte();
        buf.readShort();
        PreNettyTypes.readItemStack1_0(buf);
    }),
    WINDOW_ITEMS(104, (user, buf) -> {
        buf.readByte();
        int x = buf.readShort();
        for (int i = 0; i < x; i++) PreNettyTypes.readItemStack1_0(buf);
    }),
    WINDOW_PROPERTY(105, (user, buf) -> {
        buf.readByte();
        buf.readShort();
        buf.readShort();
    }),
    WINDOW_CONFIRMATION(106, (user, buf) -> {
        buf.readByte();
        buf.readShort();
        buf.readByte();
    }),
    CREATIVE_INVENTORY_ACTION(107, (user, buf) -> {
        buf.readShort();
        PreNettyTypes.readItemStack1_0(buf);
    }),
    UPDATE_SIGN(130, (user, buf) -> {
        buf.readInt();
        buf.readShort();
        buf.readInt();
        PreNettyTypes.readString(buf);
        PreNettyTypes.readString(buf);
        PreNettyTypes.readString(buf);
        PreNettyTypes.readString(buf);
    }),
    MAP_DATA(131, (user, buf) -> {
        buf.readShort();
        buf.readShort();
        short x = buf.readUnsignedByte();
        for (int i = 0; i < x; i++) buf.readByte();
    }),
    STATISTICS(200, (user, buf) -> {
        buf.readInt();
        buf.readByte();
    }),
    PLAYER_INFO(201, (user, buf) -> {
        PreNettyTypes.readString(buf);
        buf.readByte();
        buf.readShort();
    }),
    PLUGIN_MESSAGE(250, (user, buf) -> {
        PreNettyTypes.readString(buf);
        short s = buf.readShort();
        for (int i = 0; i < s; i++) buf.readByte();
    }),
    DISCONNECT(255, (user, buf) -> {
        PreNettyTypes.readString(buf);
    });

    private static final ClientboundPackets1_1[] REGISTRY = new ClientboundPackets1_1[256];

    static {
        for (ClientboundPackets1_1 packet : values()) {
            REGISTRY[packet.id] = packet;
        }
    }

    public static ClientboundPackets1_1 getPacket(final int id) {
        return REGISTRY[id];
    }

    private final int id;
    private final BiConsumer<UserConnection, ByteBuf> packetReader;

    ClientboundPackets1_1(final int id, final BiConsumer<UserConnection, ByteBuf> packetReader) {
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
