import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

public class SubSystemVoltageData implements IStatus {

    /**
     * 子系统号
     */
    private Short num;

    /**
     * 电压
     */
    private Integer voltage;

    /**
     * 电流
     */
    private Integer current;

    /**
     * 单体电池个数
     */
    private Integer cellCount;

    /**
     * 本帧起始电池序号
     */
    private Integer batteryNumber;

    /**
     * 本帧单体电池总数
     */
    private Short batteryCount;

    /**
     * 单体电池电压列表
     */
    private List<Integer> cellVoltages;

    public Short getNum() {
        return num;
    }

    public void setNum(Short num) {
        this.num = num;
    }

    public Integer getVoltage() {
        return voltage;
    }

    public void setVoltage(Integer voltage) {
        this.voltage = voltage;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getCellCount() {
        return cellCount;
    }

    public void setCellCount(Integer cellCount) {
        this.cellCount = cellCount;
    }

    public Integer getBatteryNumber() {
        return batteryNumber;
    }

    public void setBatteryNumber(Integer batteryNumber) {
        this.batteryNumber = batteryNumber;
    }

    public Short getBatteryCount() {
        return batteryCount;
    }

    public void setBatteryCount(Short batteryCount) {
        this.batteryCount = batteryCount;
    }

    public List<Integer> getCellVoltages() {
        return cellVoltages;
    }

    public void setCellVoltages(List<Integer> cellVoltages) {
        this.cellVoltages = cellVoltages;
    }

    @Override
    public SubSystemVoltageData decode(ByteBuf byteBuf) {
        SubSystemVoltageData subSystemVoltageData = new SubSystemVoltageData();
        subSystemVoltageData.setNum(byteBuf.readUnsignedByte());
        subSystemVoltageData.setVoltage(byteBuf.readUnsignedShort());
        subSystemVoltageData.setCurrent(byteBuf.readUnsignedShort());
        subSystemVoltageData.setCellCount(byteBuf.readUnsignedShort());
        subSystemVoltageData.setBatteryNumber(byteBuf.readUnsignedShort());
        short i = byteBuf.readUnsignedByte();
        subSystemVoltageData.setBatteryCount(i);
        if (i > 0) {
            List<Integer>list=new ArrayList();
            for (int j=0;j<i;j++){
                int i1=byteBuf.readUnsignedShort();
                list.add(i1);
            }
            subSystemVoltageData.setCellVoltages(list);
        }
        return subSystemVoltageData;
    }
}
