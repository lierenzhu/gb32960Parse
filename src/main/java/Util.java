import java.io.*;

public class Util {

    private final static char[] digits = {'0', '1'};

    static byte[] hexToByteArray2(String hex) {
        int l = hex.length();
        byte[] data = new byte[l / 2];
        for (int i = 0; i < l; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }

    static byte[] readTxt(String path) throws IOException {
        File file = new File(path);
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
        BufferedReader br = new BufferedReader(reader);
        String msg = "";
        msg = br.readLine();
        byte[] result = hexToByteArray2(msg);
        return result;
    }

    public static String to32BinaryString(int num) {
        char[] buf = new char[32];
        int pos = 32;
        int mask = 1;
        do {
            buf[--pos] = digits[num & mask];
            num >>>= 1;
        }
        while (pos > 0);
        return new String(buf, pos, 32);
    }
}
