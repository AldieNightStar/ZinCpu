package zincpu;

public class ZStack {
    private byte[] arr = new byte[500];
    private int ptr = 0;

    public void push(byte b) {
        try {
            arr[ptr++] = b;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("[!] Stack Overflow");
        }
    }

    public byte pop() {
        try {
            return arr[--ptr];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("[!] Stack already on NULL pos");
            return 0x0;
        }
    }

    public void reset() {
        ptr = 0;
    }
}
