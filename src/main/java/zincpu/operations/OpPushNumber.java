package zincpu.operations;

import zincpu.ZinCPU;

public class OpPushNumber implements ZOperation {
    @Override
    public void doOp(ZinCPU cpu) {
        byte num = cpu.readByte();
        cpu.stack.push(num);
    }
}
