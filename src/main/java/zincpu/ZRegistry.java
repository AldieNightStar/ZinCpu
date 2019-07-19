package zincpu;

public class ZRegistry {
    private byte[] arr = new byte[256];

    public byte get(int n) {
        if (!isLimit(n)) return arr[n];
        return 0x0;
    }

    public void set(int n, byte b) {
        if (!isLimit(n)) arr[n] = b;
    }

    private boolean isLimit(int n) {
        return n < 0 || n > arr.length - 1;
    }
}
