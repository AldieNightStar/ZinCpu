package zincpu.operations;

import zincpu.ZinCPU;

public class OpOutput implements ZOperation {
    @Override
    public void doOp(ZinCPU cpu) {
        byte regNum = cpu.readByte();
        System.out.println( cpu.registry.get(regNum) );
    }
}
