/*
 * This file is part of ViaLegacy - https://github.com/RaphiMC/ViaLegacy
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
package net.raphimc.vialegacy.protocols.beta.protocolb1_5_0_2tob1_4_0_1.types;

import com.viaversion.viaversion.api.minecraft.metadata.MetaType;
import com.viaversion.viaversion.api.type.Type;
import net.raphimc.vialegacy.protocols.beta.protocolb1_8_0_1tob1_7_0_3.types.Typesb1_7_0_3;
import net.raphimc.vialegacy.protocols.release.protocol1_4_2to1_3_1_2.types.Types1_3_1;

public enum MetaTypeb1_4 implements MetaType {

    Byte(0, Type.BYTE),
    Short(1, Type.SHORT),
    Int(2, Type.INT),
    Float(3, Type.FLOAT),
    String(4, Typesb1_7_0_3.STRING),
    Slot(5, Types1_3_1.NBTLESS_ITEM),
    Position(6, Type.VECTOR);

    private final int typeID;
    private final Type<?> type;

    MetaTypeb1_4(int typeID, Type<?> type) {
        this.typeID = typeID;
        this.type = type;
    }

    public static MetaTypeb1_4 byId(int id) {
        return values()[id];
    }

    public int typeId() {
        return this.typeID;
    }

    public Type<?> type() {
        return this.type;
    }

}
