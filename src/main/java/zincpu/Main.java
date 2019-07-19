package zincpu;

import zincpu.impl.ZByteReader;

public class Main {
    public static void main(String[] args) {
        byte[] data = ZinCompiler.compile(
                "mov 1 33\n"
                        + "pushr 1\n"
                        + "pop 2\n"
                        + "math 1 2 10\n"
                        + "out 1\n"
                        + "out 2\n"
        );
        ZByteReader reader = new ZByteReader(data);
        ZinCPU cpu = new ZinCPU(reader);
        cpu.execute();
    }
}
