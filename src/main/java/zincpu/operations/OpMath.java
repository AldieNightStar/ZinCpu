package zincpu.operations;

import zincpu.ZinCPU;

import java.util.function.BiFunction;

public class OpMath implements ZOperation {

    private static byte PLUS = 0x1;
    private static byte MINUS = 0x2;
    private static byte MULTIPLY = 0x3;
    private static byte DIVISION = 0x4;
    private static byte DIVISION2 = 0x5;

    @Override
    public void doOp(ZinCPU cpu) {
        byte op = cpu.readByte();
        byte reg = cpu.readByte();
        byte cnt = cpu.readByte();
        if (op == PLUS) doMath(cpu, reg, cnt, (a, b) -> (byte) (a + b));
        if (op == MINUS) doMath(cpu, reg, cnt, (a, b) -> (byte) (a - b));
        if (op == MULTIPLY) doMath(cpu, reg, cnt, (a, b) -> (byte) (a * b));
        if (op == DIVISION) doMath(cpu, reg, cnt, (a, b) -> (byte) (a / b));
        if (op == DIVISION2) doMath(cpu, reg, cnt, (a, b) -> (byte) (a % b));
    }

    private void doMath(ZinCPU cpu, byte reg, byte cnt, BiFunction<Byte, Byte, Byte> f) {
        byte n = cpu.registry.get(reg);
        n = f.apply(n, cnt);
        cpu.registry.set(reg, n);
    }
}
