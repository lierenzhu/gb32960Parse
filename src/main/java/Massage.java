import io.netty.buffer.ByteBuf;

public class Massage {

    Header header;

    DataBody dataBody;

    BCC bcc;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public DataBody getDataBody() {
        return dataBody;
    }

    public void setDataBody(DataBody dataBody) {
        this.dataBody = dataBody;
    }

    public BCC getBcc() {
        return bcc;
    }

    public void setBcc(BCC bcc) {
        this.bcc = bcc;
    }

    public Massage decode(ByteBuf byteBuf) {
        Massage massage = new Massage();
        Header header = new Header();
        DataBody dataBody = new DataBody();
        BCC bcc = new BCC();

        massage.setHeader(header.decode(byteBuf));
        int length = massage.getHeader().getLength();
        if (length > 0) {
            massage.setDataBody(dataBody.decode(byteBuf.readSlice(length),massage.getHeader().getCommandType()));
        }
//        massage.setDataBody(dataBody.decode(byteBuf));
        massage.setBcc(bcc.decode(byteBuf));

        return massage;
    }
}
