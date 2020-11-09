import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class VehicleLogin implements IStatus{

    private static final BeanTime producer=new BeanTime();

    //车辆登入时间
    private BeanTime beanTime;

    //登入流水号
    private Integer serialNum;

    //ICCID
    private  String iccid;

    //可充电储能子系统数
    private Short count;

    //可充电子系统编码长度
    private Short length;

    //可充电储能系统编码集合
    private List<String> codes;

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

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public Short getCount() {
        return count;
    }

    public void setCount(Short count) {
        this.count = count;
    }

    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    public List<String> getCodes() {
        return codes;
    }

    public void setCodes(List<String> codes) {
        this.codes = codes;
    }

    @Override
    public VehicleLogin decode(ByteBuf byteBuf) {
        VehicleLogin vehicleLogin=new VehicleLogin();
        BeanTime beanTime=producer.decode(byteBuf);
        vehicleLogin.setBeanTime(beanTime);
        vehicleLogin.setSerialNum(byteBuf.readUnsignedShort());
        vehicleLogin.setIccid(byteBuf.readSlice(20).toString(StandardCharsets.UTF_8));
        vehicleLogin.setCount(byteBuf.readUnsignedByte());
        vehicleLogin.setLength(byteBuf.readUnsignedByte());
        if(vehicleLogin.getCount()>0&&vehicleLogin.getLength()>0){
            List<String> codeList=new ArrayList<>();
            for (int i=0;i<vehicleLogin.getCount();i++){
                String code=byteBuf.readSlice(vehicleLogin.getLength()).toString(StandardCharsets.UTF_8);
                codeList.add(code);
            }
            vehicleLogin.setCodes(codeList);
        }
        return vehicleLogin;
    }
}
