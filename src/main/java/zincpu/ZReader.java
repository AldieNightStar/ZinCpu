package zincpu;

import java.io.EOFException;

public interface ZReader {
    int getPos();
    void setPos(int p);
    byte read() throws EOFException;
}
