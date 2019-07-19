package zincpu.impl;

import zincpu.ZReader;

import java.io.EOFException;
import java.io.File;
import java.nio.file.Files;

public class ZByteReader implements ZReader {
    private byte[] b;
    private int pos;

    public ZByteReader(File f) {
        try {
            b = Files.readAllBytes(f.toPath());
            pos = 0;
        } catch (Exception e) {
            b = new byte[]{0x0};
            pos = 0;
            System.out.println("Can't load file: " + f.toPath().toString());
        }
    }

    public ZByteReader(byte[] data) {
        b = data;
        pos = 0;
    }

    @Override
    public int getPos() {
        return pos;
    }

    @Override
    public void setPos(int p) {
        pos = p;
    }

    @Override
    public byte read() throws EOFException {
        try {
            return b[pos++];
        } catch (Exception e) {
            throw new EOFException();
        }
    }
}
