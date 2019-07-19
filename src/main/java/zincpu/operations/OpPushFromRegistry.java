package zincpu.operations;

import zincpu.ZinCPU;

public class OpPushFromRegistry implements ZOperation {
    @Override
    public void doOp(ZinCPU cpu) {
        byte reg = cpu.readByte();
        cpu.stack.push(cpu.registry.get(reg));
    }
}
