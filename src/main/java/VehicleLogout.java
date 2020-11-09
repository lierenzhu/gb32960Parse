import io.netty.buffer.ByteBuf;

public class VehicleLogout implements IStatus {

    private static final BeanTime producer = new BeanTime();

    //车辆登出时间
    private BeanTime beanTime;

    //车辆登出流水号
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

    public VehicleLogout decode(ByteBuf byteBuf){
        VehicleLogout vehicleLogout=new VehicleLogout();
        BeanTime beanTime=producer.decode(byteBuf);
        vehicleLogout.setBeanTime(beanTime);
        vehicleLogout.setSerialNum(byteBuf.readUnsignedShort());
        return vehicleLogout;
    }
}
