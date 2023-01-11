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
package net.raphimc.vialegacy.protocols.beta.protocolb1_4_0_1tob1_3_0_1;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import net.raphimc.vialegacy.api.splitter.PreNettySplitter;
import net.raphimc.vialegacy.protocols.beta.protocolb1_5_0_2tob1_4_0_1.ClientboundPacketsb1_4;
import net.raphimc.vialegacy.protocols.beta.protocolb1_5_0_2tob1_4_0_1.ServerboundPacketsb1_4;

public class Protocolb1_4_0_1tob1_3_0_1 extends AbstractProtocol<ClientboundPacketsb1_3, ClientboundPacketsb1_4, ServerboundPacketsb1_4, ServerboundPacketsb1_4> {

    public Protocolb1_4_0_1tob1_3_0_1() {
        super(ClientboundPacketsb1_3.class, ClientboundPacketsb1_4.class, ServerboundPacketsb1_4.class, ServerboundPacketsb1_4.class);
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.put(new PreNettySplitter(userConnection, Protocolb1_4_0_1tob1_3_0_1.class, ClientboundPacketsb1_3::getPacket));
    }

}
