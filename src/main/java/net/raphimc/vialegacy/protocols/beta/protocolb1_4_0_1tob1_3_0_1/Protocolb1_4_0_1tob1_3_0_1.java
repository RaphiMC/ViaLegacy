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
