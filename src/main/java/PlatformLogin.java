import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class PlatformLogin implements IStatus {

    private static final BeanTime producer = new BeanTime();

    //平台登入时间
    private BeanTime beanTime;

    //登入流水号
    private Integer serialNum;

    //平台用户名
    private String userName;

    //平台登入密码
    private String password;

    //加密规则
    private EncryptionType encryptionType;

    public static BeanTime getProducer() {
        return producer;
    }

    public BeanTime getBeanTime() {
        return beanTime;
    }

    public void setBeanTime(BeanTime beanTime) {
        this.beanTime = beanTime;
    }

    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EncryptionType getEncryptionType() {
        return encryptionType;
    }

    public void setEncryptionType(EncryptionType encryptionType) {
        this.encryptionType = encryptionType;
    }

    public PlatformLogin decode(ByteBuf byteBuf){
        PlatformLogin platformLogin=new PlatformLogin();
        BeanTime beanTime=producer.decode(byteBuf);
        platformLogin.setBeanTime(beanTime);
        platformLogin.setSerialNum(byteBuf.readUnsignedShort());
        platformLogin.setUserName(byteBuf.readSlice(12).toString(StandardCharsets.UTF_8));
        platformLogin.setPassword(byteBuf.readSlice(20).toString(StandardCharsets.UTF_8));
        platformLogin.setEncryptionType(EncryptionType.valuesOf(byteBuf.readUnsignedByte()));
        return platformLogin;
    }
}
