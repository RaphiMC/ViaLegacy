package net.raphimc.vialegacy.protocols.classic.protocolc0_0_19a_06toc0_0_18a_02;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import net.raphimc.vialegacy.protocols.classic.protocola1_0_15toc0_28_30.data.ClassicBlocks;
import net.raphimc.vialegacy.protocols.classic.protocola1_0_15toc0_28_30.storage.ClassicBlockRemapper;
import net.raphimc.vialegacy.protocols.classic.protocolc0_0_20a_27toc0_0_19a_06.ClientboundPacketsc0_19a;
import net.raphimc.vialegacy.protocols.classic.protocolc0_0_20a_27toc0_0_19a_06.ServerboundPacketsc0_19a;

public class Protocolc0_0_19a_06toc0_0_18a_02 extends AbstractProtocol<ClientboundPacketsc0_19a, ClientboundPacketsc0_19a, ServerboundPacketsc0_19a, ServerboundPacketsc0_19a> {

    public Protocolc0_0_19a_06toc0_0_18a_02() {
        super(ClientboundPacketsc0_19a.class, ClientboundPacketsc0_19a.class, ServerboundPacketsc0_19a.class, ServerboundPacketsc0_19a.class);
    }

    @Override
    public void init(UserConnection userConnection) {
        final ClassicBlockRemapper previousRemapper = userConnection.get(ClassicBlockRemapper.class);
        userConnection.put(new ClassicBlockRemapper(userConnection, previousRemapper.getMapper(), o -> {
            int block = previousRemapper.getReverseMapper().getInt(o);

            if (userConnection.getProtocolInfo().getPipeline().contains(Protocolc0_0_19a_06toc0_0_18a_02.class)) {
                if (block != ClassicBlocks.STONE && block != ClassicBlocks.DIRT && block != ClassicBlocks.WOOD && block != ClassicBlocks.SAPLING && block != ClassicBlocks.GRAVEL && block != ClassicBlocks.LOG && block != ClassicBlocks.LEAVES && block != ClassicBlocks.SAND && block != ClassicBlocks.COBBLESTONE) {
                    block = ClassicBlocks.STONE;
                }
            }

            return block;
        }));
    }

}
