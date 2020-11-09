import io.netty.buffer.ByteBuf;

public class PlatformLogout implements IStatus {

    private static final BeanTime producer = new BeanTime();

    //平台登出时间
    private BeanTime beanTime;

    //平台登出序列号
    private Integer serialNum;

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

    public PlatformLogout decode(ByteBuf byteBuf){
        PlatformLogout platformLogout=new PlatformLogout();
        BeanTime beanTime=producer.decode(byteBuf);
        platformLogout.setBeanTime(beanTime);
        platformLogout.setSerialNum(byteBuf.readUnsignedShort());
        return platformLogout;
    }

}
