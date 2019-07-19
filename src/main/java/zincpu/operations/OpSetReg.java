package zincpu.operations;

import zincpu.ZinCPU;

public class OpSetReg implements ZOperation {
    public void doOp(ZinCPU cpu) {
        byte reg = cpu.readByte();
        byte num = cpu.readByte();
        cpu.registry.set(reg, num);
    }
}
