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
package net.raphimc.vialegacy.api.model;

import java.util.Objects;

public class IdAndData {

    public int id;
    public int data;

    public IdAndData(final int id, final int data) {
        if (data < 0 || data > 15) throw new IllegalArgumentException("Block data out of bounds (id:" + id + " data:" + data + ")");
        this.id = id;
        this.data = data;
    }

    public static IdAndData fromCompressedData(final int idAndData) {
        return new IdAndData(idAndData >> 4, idAndData & 15);
    }

    public static int toCompressedData(final int id, final int data) {
        return id << 4 | data & 15;
    }

    public int toCompressedData() {
        return toCompressedData(this.id, this.data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdAndData idAndData = (IdAndData) o;
        return id == idAndData.id &&
                data == idAndData.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data);
    }

    @Override
    public String toString() {
        return "IdAndData{" +
                "id=" + id +
                ", data=" + data +
                '}';
    }

}
