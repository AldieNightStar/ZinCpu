package zincpu.operations;

import zincpu.ZinCPU;

public class OpSetRegFromMem implements ZOperation {
    @Override
    public void doOp(ZinCPU cpu) {
        byte reg = cpu.readByte();
        short memIndex = cpu.readShort();
        cpu.registry.set(reg, cpu.memory.get(memIndex));
    }
}
