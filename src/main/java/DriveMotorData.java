import io.netty.buffer.ByteBuf;

public class DriveMotorData implements IStatus{

    //驱动电机序号
    private Short num;

    //驱动电机状态
    private Short status;

    //驱动电机控制温度
    private Short controllerTemperature;

    //驱动电机转速
    private Integer speed;

    //驱动电机转矩
    private Integer torque;

    //驱动电机温度
    private Short temperature;

    //电机控制器输入电压
    private Integer controllerInputVoltage;

    //电机控制器直流母线电流
    private Integer controllerBusCurrent;

    public Short getNum() {
        return num;
    }

    public void setNum(Short num) {
        this.num = num;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getControllerTemperature() {
        return controllerTemperature;
    }

    public void setControllerTemperature(Short controllerTemperature) {
        this.controllerTemperature = controllerTemperature;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getTorque() {
        return torque;
    }

    public void setTorque(Integer torque) {
        this.torque = torque;
    }

    public Short getTemperature() {
        return temperature;
    }

    public void setTemperature(Short temperature) {
        this.temperature = temperature;
    }

    public Integer getControllerInputVoltage() {
        return controllerInputVoltage;
    }

    public void setControllerInputVoltage(Integer controllerInputVoltage) {
        this.controllerInputVoltage = controllerInputVoltage;
    }

    public Integer getControllerBusCurrent() {
        return controllerBusCurrent;
    }

    public void setControllerBusCurrent(Integer controllerBusCurrent) {
        this.controllerBusCurrent = controllerBusCurrent;
    }

    public DriveMotorData decode(ByteBuf byteBuf){
        DriveMotorData driveMotorData=new DriveMotorData();
        driveMotorData.setNum(byteBuf.readUnsignedByte());
        driveMotorData.setStatus(byteBuf.readUnsignedByte());
        driveMotorData.setControllerTemperature(byteBuf.readUnsignedByte());
        driveMotorData.setSpeed(byteBuf.readUnsignedShort());
        driveMotorData.setTorque(byteBuf.readUnsignedShort());
        driveMotorData.setTemperature(byteBuf.readUnsignedByte());
        driveMotorData.setControllerInputVoltage(byteBuf.readUnsignedShort());
        driveMotorData.setControllerBusCurrent(byteBuf.readUnsignedShort());
        return driveMotorData;

    }
}
