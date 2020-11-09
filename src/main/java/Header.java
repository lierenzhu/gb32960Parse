import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Header {

    //起始符，固定0x23,0x23
    private Boolean startSymbol = Boolean.TRUE;

    //命令单元
    private CommandType commandType;

    //应答单元
    private ResponseType responseType;

    //VIN码
    private String vin;

    //数据单元加密方式
    private EncryptionType encryptionType;

    //数据单元长度
    private Integer length;


    public Boolean getStartSymbol() {
        return startSymbol;
    }

    public void setStartSymbol(Boolean startSymbol) {
        this.startSymbol = startSymbol;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public EncryptionType getEncryptionType() {
        return encryptionType;
    }

    public void setEncryptionType(EncryptionType encryptionType) {
        this.encryptionType = encryptionType;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Header decode(ByteBuf byteBuf){
        Header header = new Header();
        Boolean checkBegin =byteBuf.readSlice(2).toString(StandardCharsets.UTF_8).equals(Constants.BEGIN);
        header.setStartSymbol(checkBegin);
        header.setCommandType(CommandType.valuesOf(byteBuf.readUnsignedByte()));
        header.setResponseType(ResponseType.valuesOf(byteBuf.readUnsignedByte()));
        header.setVin(byteBuf.readSlice(17).toString(StandardCharsets.UTF_8));
        header.setEncryptionType(EncryptionType.valuesOf(byteBuf.readUnsignedByte()));

        int length=byteBuf.readUnsignedShort();
        header.setLength(length);
//        if(length>0){
//
//        }
        return header;
    }
}
