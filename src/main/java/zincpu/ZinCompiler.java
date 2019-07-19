package zincpu;

import zincpu.operations.ZOperationRegistry;
import zincpu.util.DataUtil;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class ZinCompiler {

    public static byte[] compile(File file) {
        try {
            byte[] data = Files.readAllBytes(file.toPath());
            String code = new String(data, StandardCharsets.UTF_8);
            return compile(code);
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[]{};
        }
    }

    public static byte[] compile(String code) {
        code += "\n";
        String[] lines = code.split(Pattern.quote("\n"));
        List<Byte> byteList = new LinkedList<>();
        for (String line : lines) {
            byte[] compiledChunkOfBytes = compileLine(line);
            for (byte b : compiledChunkOfBytes) {
                byteList.add(b);
            }
        }
        byte[] resultBytes = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            resultBytes[i] = byteList.get(i);
        }
        return resultBytes;
    }

    public static byte[] compileLine(String line) {
        Token token = new Token(line);
        ArrayList<Byte> byteList = new ArrayList<>();
        byteList.add(ZOperationRegistry.getOpCodeOf(token.cmd));

        for (String arg : token.args) {
            byte[] generatedNumberBytes = genNumber(arg);
            for (byte b : generatedNumberBytes) {
                byteList.add(b);
            }
        }
        byte[] resultBytes = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            resultBytes[i] = byteList.get(i);
        }
        return resultBytes;
    }

    private static String[] split(String line) {
        if (line == null || line.trim().isEmpty()) return new String[]{""};
        return line.split(Pattern.quote(" "));
    }

    private static class Token {
        String cmd;
        List<String> args;

        public Token(String line) {
            String[] arr = split(line);
            cmd = arr[0];
            args = new ArrayList<>();
            if (arr.length > 1) {
                for (int i = 1; i < arr.length; i++) {
                    args.add(arr[i]);
                }
            }
        }
    }

    private static byte[] genNumber(String n) {
        if (n.endsWith("i")) return DataUtil.getBytesFromInt(Integer.valueOf(n.substring(0, n.length() - 1)));
        if (n.endsWith("s")) return DataUtil.getBytesFromShort(Short.valueOf(n.substring(0, n.length() - 1)));
        return new byte[]{Byte.valueOf(removeRetSym(n))};
    }

    private static String removeRetSym(String s) {
        return s.replace("\r", "");
    }
}
