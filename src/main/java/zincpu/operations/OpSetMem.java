package zincpu.operations;

import zincpu.ZinCPU;

public class OpSetMem implements ZOperation {
    @Override
    public void doOp(ZinCPU cpu) {
        short memIndex = cpu.readShort();
        byte value = cpu.readByte();
        cpu.memory.set(memIndex, value);
    }
}
