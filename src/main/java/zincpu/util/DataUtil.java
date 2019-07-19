package zincpu.util;

import zincpu.ZReader;

import java.io.EOFException;
import java.nio.ByteBuffer;

public class DataUtil {
    public static int getIntFromBytes(byte[] b) {
        return ByteBuffer.wrap(b).getInt();
    }

    public static short getShortFromBytes(byte[] b) {
        return ByteBuffer.wrap(b).getShort();
    }

    public static byte[] getBytesFromInt(int n) {
        return ByteBuffer.allocate(4).putInt(n).array();
    }

    public static byte[] getBytesFromShort(short n) {
        return ByteBuffer.allocate(2).putShort(n).array();
    }

    public static byte[] readBytes(ZReader reader, int cnt) {
        byte[] b = new byte[cnt];
        for (int i = 0; i < cnt; i++) {
            try {
                b[i] = reader.read();
            } catch (EOFException e) {
                return b;
            }
        }
        return b;
    }
}
