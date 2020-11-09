import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

public class FuelCellData implements IStatus {

    //燃料电池电压
    private Integer voltage;

    //燃料电池电流
    private Integer current;

    //燃料消耗率
    private Integer fuelConsumption;

    //燃料电池温度探针总数
    private Integer temperatureProbeCount;

    //探针温度值集合
    private List<Short> probeTemperature;

    //氢系统中最高温度
    private Integer hydrogenSystemMaxTemperature;

    //氢系统中最高温度探针代号
    private Short hydrogenSystemTemperatureProbeNum;

    //氢气最高浓度
    private Integer hydrogenSystemMaxConcentration;

    //氢气最高浓度传感器代号
    private Short hydrogenSystemConcentrationProbeNum;

    //氢气最高压力
    private Integer hydrogenSystemMaxPressure;

    //氢气最高压力传感器代号
    private Short hydrogenSystemPressureProbeNum;

    //高压DC/DC状态
    private Short dcStatus;

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

    public Integer getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Integer fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public Integer getTemperatureProbeCount() {
        return temperatureProbeCount;
    }

    public void setTemperatureProbeCount(Integer temperatureProbeCount) {
        this.temperatureProbeCount = temperatureProbeCount;
    }

    public List<Short> getProbeTemperature() {
        return probeTemperature;
    }

    public void setProbeTemperature(List<Short> probeTemperature) {
        this.probeTemperature = probeTemperature;
    }

    public Integer getHydrogenSystemMaxTemperature() {
        return hydrogenSystemMaxTemperature;
    }

    public void setHydrogenSystemMaxTemperature(Integer hydrogenSystemMaxTemperature) {
        this.hydrogenSystemMaxTemperature = hydrogenSystemMaxTemperature;
    }

    public Short getHydrogenSystemTemperatureProbeNum() {
        return hydrogenSystemTemperatureProbeNum;
    }

    public void setHydrogenSystemTemperatureProbeNum(Short hydrogenSystemTemperatureProbeNum) {
        this.hydrogenSystemTemperatureProbeNum = hydrogenSystemTemperatureProbeNum;
    }

    public Integer getHydrogenSystemMaxConcentration() {
        return hydrogenSystemMaxConcentration;
    }

    public void setHydrogenSystemMaxConcentration(Integer hydrogenSystemMaxConcentration) {
        this.hydrogenSystemMaxConcentration = hydrogenSystemMaxConcentration;
    }

    public Short getHydrogenSystemConcentrationProbeNum() {
        return hydrogenSystemConcentrationProbeNum;
    }

    public void setHydrogenSystemConcentrationProbeNum(Short hydrogenSystemConcentrationProbeNum) {
        this.hydrogenSystemConcentrationProbeNum = hydrogenSystemConcentrationProbeNum;
    }

    public Integer getHydrogenSystemMaxPressure() {
        return hydrogenSystemMaxPressure;
    }

    public void setHydrogenSystemMaxPressure(Integer hydrogenSystemMaxPressure) {
        this.hydrogenSystemMaxPressure = hydrogenSystemMaxPressure;
    }

    public Short getHydrogenSystemPressureProbeNum() {
        return hydrogenSystemPressureProbeNum;
    }

    public void setHydrogenSystemPressureProbeNum(Short hydrogenSystemPressureProbeNum) {
        this.hydrogenSystemPressureProbeNum = hydrogenSystemPressureProbeNum;
    }

    public Short getDcStatus() {
        return dcStatus;
    }

    public void setDcStatus(Short dcStatus) {
        this.dcStatus = dcStatus;
    }

    @Override
    public Object decode(ByteBuf byteBuf) {
        FuelCellData fuelCellData = new FuelCellData();
        fuelCellData.setVoltage(byteBuf.readUnsignedShort());
        fuelCellData.setCurrent(byteBuf.readUnsignedShort());
        fuelCellData.setFuelConsumption(byteBuf.readUnsignedShort());
        fuelCellData.setTemperatureProbeCount(byteBuf.readUnsignedShort());
        List<Short> temperatureList = new ArrayList<Short>(fuelCellData.getTemperatureProbeCount());
        if(fuelCellData.getTemperatureProbeCount()>0){
            for (int i=0;i<fuelCellData.getTemperatureProbeCount();i++){
                temperatureList.add(byteBuf.readUnsignedByte());
            }
        }
        fuelCellData.setProbeTemperature(temperatureList);
        fuelCellData.setHydrogenSystemMaxTemperature(byteBuf.readUnsignedShort());
        fuelCellData.setHydrogenSystemTemperatureProbeNum(byteBuf.readUnsignedByte());
        fuelCellData.setHydrogenSystemMaxConcentration(byteBuf.readUnsignedShort());
        fuelCellData.setHydrogenSystemConcentrationProbeNum(byteBuf.readUnsignedByte());
        fuelCellData.setHydrogenSystemMaxPressure(byteBuf.readUnsignedShort());
        fuelCellData.setHydrogenSystemPressureProbeNum(byteBuf.readUnsignedByte());
        fuelCellData.setDcStatus(byteBuf.readUnsignedByte());

        return fuelCellData;
    }

}
