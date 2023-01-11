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
package net.raphimc.vialegacy.protocols.classic.protocolc0_0_16a_02to0_0_15a_1;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.remapper.PacketRemapper;
import com.viaversion.viaversion.api.type.Type;
import net.raphimc.vialegacy.api.splitter.PreNettySplitter;
import net.raphimc.vialegacy.protocols.classic.protocola1_0_15toc0_28_30.types.Typesc0_30;
import net.raphimc.vialegacy.protocols.classic.protocolc0_0_20a_27toc0_0_19a_06.ClientboundPacketsc0_19a;
import net.raphimc.vialegacy.protocols.classic.protocolc0_0_20a_27toc0_0_19a_06.ServerboundPacketsc0_19a;

public class Protocolc0_0_16a_02to0_0_15a_1 extends AbstractProtocol<ClientboundPacketsc0_15a, ClientboundPacketsc0_19a, ServerboundPacketsc0_15a, ServerboundPacketsc0_19a> {

    public Protocolc0_0_16a_02to0_0_15a_1() {
        super(ClientboundPacketsc0_15a.class, ClientboundPacketsc0_19a.class, ServerboundPacketsc0_15a.class, ServerboundPacketsc0_19a.class);
    }

    @Override
    protected void registerPackets() {
        this.registerClientbound(ClientboundPacketsc0_15a.JOIN_GAME, new PacketRemapper() {
            @Override
            public void registerMap() {
                handler(wrapper -> {
                    final String username = wrapper.read(Typesc0_30.STRING); // username

                    wrapper.write(Type.BYTE, (byte) 0); // protocol id
                    wrapper.write(Typesc0_30.STRING, "c0.0.15a Server"); // title
                    wrapper.write(Typesc0_30.STRING, "Logged in as: " + username); // motd
                });
            }
        });
        this.registerClientbound(ClientboundPacketsc0_15a.ENTITY_TELEPORT, new PacketRemapper() {
            @Override
            public void registerMap() {
                map(Type.BYTE); // entity id
                map(Type.SHORT); // x
                map(Type.SHORT); // y
                map(Type.SHORT); // z
                map(Type.BYTE); // yaw
                map(Type.BYTE); // pitch
                handler(wrapper -> {
                    final byte entityId = wrapper.get(Type.BYTE, 0);
                    final byte yaw = wrapper.get(Type.BYTE, 1);
                    final byte pitch = wrapper.get(Type.BYTE, 2);

                    final PacketWrapper entityRotation = PacketWrapper.create(ClientboundPacketsc0_19a.ENTITY_ROTATION, wrapper.user());
                    entityRotation.write(Type.BYTE, entityId); // entity id
                    entityRotation.write(Type.BYTE, yaw); // yaw
                    entityRotation.write(Type.BYTE, pitch); // pitch

                    wrapper.send(Protocolc0_0_16a_02to0_0_15a_1.class);
                    entityRotation.send(Protocolc0_0_16a_02to0_0_15a_1.class);
                    wrapper.cancel();
                });
            }
        });

        this.registerServerbound(State.LOGIN, ServerboundPacketsc0_15a.LOGIN.getId(), ServerboundPacketsc0_19a.LOGIN.getId(), new PacketRemapper() {
            @Override
            public void registerMap() {
                handler(wrapper -> {
                    wrapper.clearPacket();
                    wrapper.write(Typesc0_30.STRING, wrapper.user().getProtocolInfo().getUsername()); // username
                });
            }
        });
        this.cancelServerbound(ServerboundPacketsc0_19a.CHAT_MESSAGE);
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.put(new PreNettySplitter(userConnection, Protocolc0_0_16a_02to0_0_15a_1.class, ClientboundPacketsc0_15a::getPacket));
    }

}
