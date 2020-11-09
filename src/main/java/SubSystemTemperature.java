import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

public class SubSystemTemperature implements IStatus{

    /**
     * 子系统号
     */
    private Short num;

    /**
     * 温度探针个数
     */
    private Integer temperatureProbeCount;

    /**
     * 探针温度值列表
     */
    private List<Short> probeTemperatures;

    public Short getNum() {
        return num;
    }

    public void setNum(Short num) {
        this.num = num;
    }

    public Integer getTemperatureProbeCount() {
        return temperatureProbeCount;
    }

    public void setTemperatureProbeCount(Integer temperatureProbeCount) {
        this.temperatureProbeCount = temperatureProbeCount;
    }

    public List<Short> getProbeTemperatures() {
        return probeTemperatures;
    }

    public void setProbeTemperatures(List<Short> probeTemperatures) {
        this.probeTemperatures = probeTemperatures;
    }


    @Override
    public SubSystemTemperature decode(ByteBuf byteBuf) {
        SubSystemTemperature subSystemTemperature=new SubSystemTemperature();
        subSystemTemperature.setNum(byteBuf.readUnsignedByte());
        int i1=byteBuf.readUnsignedShort();
        subSystemTemperature.setTemperatureProbeCount(i1);
        if(i1>0){
            List<Short> list=new ArrayList<>();
            for (int i=0;i<i1;i++){
                short i2=byteBuf.readUnsignedByte();
                list.add(i2);
            }
            subSystemTemperature.setProbeTemperatures(list);
        }
        return subSystemTemperature;
    }
}
