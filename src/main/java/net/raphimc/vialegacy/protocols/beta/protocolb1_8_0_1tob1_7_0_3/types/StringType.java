package net.raphimc.vialegacy.protocols.beta.protocolb1_8_0_1tob1_7_0_3.types;

import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;

import java.io.IOException;

public class StringType extends Type<String> {

    public StringType() {
        super(String.class);
    }

    public String read(ByteBuf buffer) throws IOException {
        final ByteBufInputStream dis = new ByteBufInputStream(buffer);
        return dis.readUTF();
    }

    public void write(ByteBuf buffer, String s) throws IOException {
        final ByteBufOutputStream dos = new ByteBufOutputStream(buffer);
        dos.writeUTF(s);
    }

}
