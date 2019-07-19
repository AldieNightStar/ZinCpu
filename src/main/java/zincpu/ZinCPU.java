package zincpu;

import zincpu.operations.ZOperationRegistry;
import zincpu.util.DataUtil;

import java.io.EOFException;

public class ZinCPU {
    public ZReader reader;
    public ZRegistry registry;
    public ZMemory memory;
    public ZStack stack;

    public ZinCPU(ZReader reader) {
        this.reader = reader;
        registry = new ZRegistry();
        memory = new ZMemory();
        stack = new ZStack();
    }

    public void setReader(ZReader reader) {
        this.reader = reader;
    }

    public void executeStep() throws EOFException {
        byte cmd = reader.read();
        ZOperationRegistry.get(cmd).doOp(this);
    }

    public void execute() {
        try {
            while (true) {
                executeStep();
            }
        } catch (Exception e) {
        }
    }

    public byte readByte() {
        try {
            return reader.read();
        } catch (EOFException e) {
            return 0x0;
        }
    }

    public short readShort() {
        return DataUtil.getShortFromBytes(new byte[]{readByte(), readByte()});
    }

    public int readInt() {
        return DataUtil.getIntFromBytes(new byte[]{readByte(), readByte(), readByte(), readByte()});
    }
}
