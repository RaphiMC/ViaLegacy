/*
 * This file is part of ViaProtocolHack - https://github.com/RaphiMC/ViaProtocolHack
 * Copyright (C) 2023 RK_01/RaphiMC and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.raphimc.vialegacy.protocols.release.protocol1_3_1_2to1_2_4_5;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import io.netty.buffer.ByteBuf;
import net.raphimc.vialegacy.api.splitter.PreNettyPacketType;

import java.util.function.BiConsumer;

import static net.raphimc.vialegacy.api.splitter.PreNettyTypes.*;

public enum ClientboundPackets1_2_4 implements ClientboundPacketType, PreNettyPacketType {

    KEEP_ALIVE(0, (user, buf) -> {
        buf.readInt();
    }),
    JOIN_GAME(1, (user, buf) -> {
        buf.readInt();
        readString(buf);
        readString(buf);
        buf.readInt();
        buf.readInt();
        buf.readByte();
        buf.readByte();
        buf.readByte();
    }),
    HANDSHAKE(2, (user, buf) -> {
        readString(buf);
    }),
    CHAT_MESSAGE(3, (user, buf) -> {
        readString(buf);
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
        buf.readInt();
        buf.readByte();
        buf.readByte();
        buf.readShort();
        readString(buf);
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
        readString(buf);
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
        buf.readByte();
        readEntityMetadatab1_5(buf);
    }),
    SPAWN_PAINTING(25, (user, buf) -> {
        buf.readInt();
        readString(buf);
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
    ENTITY_HEAD_LOOK(35, (user, buf) -> {
        buf.readInt();
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
        readEntityMetadatab1_5(buf);
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
        buf.readInt();
        buf.readBoolean();
        buf.readShort();
        buf.readShort();
        int x = buf.readInt();
        buf.readInt();
        for (int i = 0; i < x; i++) buf.readByte();
    }),
    MULTI_BLOCK_CHANGE(52, (user, buf) -> {
        buf.readInt();
        buf.readInt();
        buf.readShort();
        int x = buf.readInt();
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
        readString(buf);
        buf.readByte();
    }),
    CLOSE_WINDOW(101, (user, buf) -> {
        buf.readByte();
    }),
    SET_SLOT(103, (user, buf) -> {
        buf.readByte();
        buf.readShort();
        readItemStack1_0(buf);
    }),
    WINDOW_ITEMS(104, (user, buf) -> {
        buf.readByte();
        int x = buf.readShort();
        for (int i = 0; i < x; i++) readItemStack1_0(buf);
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
        readItemStack1_0(buf);
    }),
    UPDATE_SIGN(130, (user, buf) -> {
        buf.readInt();
        buf.readShort();
        buf.readInt();
        readString(buf);
        readString(buf);
        readString(buf);
        readString(buf);
    }),
    MAP_DATA(131, (user, buf) -> {
        buf.readShort();
        buf.readShort();
        short x = buf.readUnsignedByte();
        for (int i = 0; i < x; i++) buf.readByte();
    }),
    BLOCK_ENTITY_DATA(132, (user, buf) -> {
        buf.readInt();
        buf.readShort();
        buf.readInt();
        buf.readByte();
        buf.readInt();
        buf.readInt();
        buf.readInt();
    }),
    STATISTICS(200, (user, buf) -> {
        buf.readInt();
        buf.readByte();
    }),
    PLAYER_INFO(201, (user, buf) -> {
        readString(buf);
        buf.readByte();
        buf.readShort();
    }),
    PLAYER_ABILITIES(202, (user, buf) -> {
        buf.readBoolean();
        buf.readBoolean();
        buf.readBoolean();
        buf.readBoolean();
    }),
    PLUGIN_MESSAGE(250, (user, buf) -> {
        readString(buf);
        short s = buf.readShort();
        for (int i = 0; i < s; i++) buf.readByte();
    }),
    DISCONNECT(255, (user, buf) -> {
        readString(buf);
    });

    private static final ClientboundPackets1_2_4[] REGISTRY = new ClientboundPackets1_2_4[256];

    static {
        for (ClientboundPackets1_2_4 packet : values()) {
            REGISTRY[packet.id] = packet;
        }
    }

    public static ClientboundPackets1_2_4 getPacket(final int id) {
        return REGISTRY[id];
    }

    private final int id;
    private final BiConsumer<UserConnection, ByteBuf> packetReader;

    ClientboundPackets1_2_4(final int id, final BiConsumer<UserConnection, ByteBuf> packetReader) {
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
