import io.netty.buffer.ByteBuf;

public class VehicleData implements IStatus{

    //车辆状态
    private Short vehicleStatus;

    //充电状态
    private Short chargeStatus;

    //运行模式
    private Short operationMode;

    //车速
    private Integer speed;

    //累计里程
    private Long mileAge;

    //总电压
    private Integer totalVoltage;

    //总电流
    private Integer totalCurrent;

    //SOC
    private Short soc;

    //DC-DC状态
    private Short dcStatus;

    //挡位
    private Short gears;

    //绝缘电阻
    private Integer insulationResistance;

    //预留
    private Integer reserve;

    public Short getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(Short vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public Short getChargeStatus() {
        return chargeStatus;
    }

    public void setChargeStatus(Short chargeStatus) {
        this.chargeStatus = chargeStatus;
    }

    public Short getOperationMode() {
        return operationMode;
    }

    public void setOperationMode(Short operationMode) {
        this.operationMode = operationMode;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Long getMileAge() {
        return mileAge;
    }

    public void setMileAge(Long mileAge) {
        this.mileAge = mileAge;
    }

    public Integer getTotalVoltage() {
        return totalVoltage;
    }

    public void setTotalVoltage(Integer totalVoltage) {
        this.totalVoltage = totalVoltage;
    }

    public Integer getTotalCurrent() {
        return totalCurrent;
    }

    public void setTotalCurrent(Integer totalCurrent) {
        this.totalCurrent = totalCurrent;
    }

    public Short getSoc() {
        return soc;
    }

    public void setSoc(Short soc) {
        this.soc = soc;
    }

    public Short getDcStatus() {
        return dcStatus;
    }

    public void setDcStatus(Short dcStatus) {
        this.dcStatus = dcStatus;
    }

    public Short getGears() {
        return gears;
    }

    public void setGears(Short gears) {
        this.gears = gears;
    }

    public Integer getInsulationResistance() {
        return insulationResistance;
    }

    public void setInsulationResistance(Integer insulationResistance) {
        this.insulationResistance = insulationResistance;
    }

    public Integer getReserve() {
        return reserve;
    }

    public void setReserve(Integer reserve) {
        this.reserve = reserve;
    }

    public VehicleData decode(ByteBuf byteBuf){
        VehicleData vehicleData=new VehicleData();
        vehicleData.setVehicleStatus(byteBuf.readUnsignedByte());
        vehicleData.setChargeStatus(byteBuf.readUnsignedByte());
        vehicleData.setOperationMode(byteBuf.readUnsignedByte());
        vehicleData.setSpeed(byteBuf.readUnsignedShort());
        vehicleData.setMileAge(byteBuf.readUnsignedInt());
        vehicleData.setTotalVoltage(byteBuf.readUnsignedShort());
        vehicleData.setTotalCurrent(byteBuf.readUnsignedShort());
        vehicleData.setSoc(byteBuf.readUnsignedByte());
        vehicleData.setDcStatus(byteBuf.readUnsignedByte());
        vehicleData.setGears(byteBuf.readUnsignedByte());
        vehicleData.setInsulationResistance(byteBuf.readUnsignedShort());
        vehicleData.setReserve(byteBuf.readUnsignedShort());
        return vehicleData;
    }
}
