package zincpu.operations;

import zincpu.ZinCPU;

public class OpCopyReg implements ZOperation {
    @Override
    public void doOp(ZinCPU cpu) {
        byte fromReg = cpu.readByte();
        byte toReg = cpu.readByte();
        cpu.registry.set(toReg, cpu.registry.get(fromReg));
    }
}
