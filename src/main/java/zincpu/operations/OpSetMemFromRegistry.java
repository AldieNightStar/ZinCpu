package zincpu.operations;

import zincpu.ZinCPU;

public class OpSetMemFromRegistry implements ZOperation {
    @Override
    public void doOp(ZinCPU cpu) {
        byte reg = cpu.readByte();
        short memIndex = cpu.readShort();
        cpu.memory.set(memIndex, cpu.registry.get(reg));
    }
}
