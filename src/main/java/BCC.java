import io.netty.buffer.ByteBuf;

public class BCC implements IStatus {

private Short bcc;

    public Short getBcc() {
        return bcc;
    }

    public void setBcc(Short bcc) {
        this.bcc = bcc;
    }

    public BCC decode(ByteBuf byteBuf){
        BCC bcc=new BCC();
        bcc.setBcc(byteBuf.readUnsignedByte());
        return bcc;
    }

    public Boolean checkBcc(BCC bcc){
        return Boolean.TRUE;
        //TODO 检查BCC校验 当前假设正确
    }
}
