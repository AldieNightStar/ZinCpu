package zincpu.operations;

import zincpu.ZinCPU;

public class OpPopToRegistry implements ZOperation {
    @Override
    public void doOp(ZinCPU cpu) {
        byte reg = cpu.readByte();
        cpu.registry.set(reg, cpu.stack.pop());
    }
}
