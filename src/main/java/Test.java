import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {

        String path = "E:\\code\\JAVA\\gb32960Parse\\testData.txt";
        byte[] buf = Util.readTxt(path);
        ByteBuf byteBuf = Unpooled.copiedBuffer(buf);
//        Header header=new Header().decode(byteBuf);
//        System.out.println(header.getVin());
//        System.out.println(header.getLength());
//        System.out.println(header.getEncryptionType());

        Massage massage = new Massage().decode(byteBuf);
        System.out.println(massage.getHeader().getCommandType());
        System.out.println(massage.getDataBody().getRealTimeData().getExtremeData().getBatteryMaxVoltage());
    }
}
