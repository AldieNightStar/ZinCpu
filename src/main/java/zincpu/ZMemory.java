package zincpu;

import java.util.HashMap;

public class ZMemory {
    private HashMap<Integer, Byte> map = new HashMap<>(50);

    public void set(int i, byte b) {
        map.put(i, b);
    }

    public byte get(int i) {
        return map.get(i);
    }
}
