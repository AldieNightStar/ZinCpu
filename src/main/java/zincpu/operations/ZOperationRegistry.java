package zincpu.operations;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ZOperationRegistry {
    private static HashMap<Byte, Keeper> opsMap = new HashMap<>();
    private static ZOperation NOP = cpu -> {};

    static {
        addOp((byte) 0x1, "mov", new OpSetReg());
        addOp((byte) 0x2, "mem", new OpSetRegFromMem());
        addOp((byte) 0x3, "memw", new OpSetMemFromRegistry());
        addOp((byte) 0x4, "cp", new OpCopyReg());
        addOp((byte) 0x5, "math", new OpMath());

        addOp((byte) 0x6, "out", new OpOutput());
        addOp((byte) 0x7, "push", new OpPushNumber());
        addOp((byte) 0x8, "pushr", new OpPushFromRegistry());
        addOp((byte) 0x9, "pop", new OpPopToRegistry());
    }

    public static ZOperation get(byte n) {
        Keeper keeper = opsMap.get(n);
        return keeper != null ? keeper.operation : NOP;
    }

    public static byte getOpCodeOf(String opName) {
        Set<Map.Entry<Byte, Keeper>> entries = opsMap.entrySet();
        for (Map.Entry<Byte, Keeper> entry : entries) {
            if (entry.getValue().opName.equalsIgnoreCase(opName)) return entry.getKey();
        }
        return 0x0;
    }

    private static void addOp(byte opCode, String opName, ZOperation op) {
        opsMap.put(opCode, new Keeper(opName, op));
    }

    private static class Keeper {
        public ZOperation operation;
        public String opName;

        public Keeper(String name, ZOperation op) {
            opName = name;
            operation = op;
        }
    }

}
