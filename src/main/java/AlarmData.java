import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

public class AlarmData implements IStatus {

    //报警等级
    private Short level;

    //通用报警标志
    private Long alarmInfo;

    /**
     * 温度差异报警
     */
    private Boolean temperatureDifferential;

    /**
     * 电池高温报警
     */
    private Boolean batteryHighTemperature;

    /**
     * 车载储能装置类型过压报警
     */
    private Boolean deviceTypeOverVoltage;

    /**
     * 车载储能装置类型欠压报警
     */
    private Boolean deviceTypeUnderVoltage;

    /**
     * SOC过低报警
     */
    private Boolean socLow;

    /**
     * 单体电池过压报警
     */
    private Boolean monomerBatteryOverVoltage;

    /**
     * 单体电池欠压报警
     */
    private Boolean monomerBatteryUnderVoltage;

    /**
     * SOC过高报警
     */
    private Boolean socHigh;

    /**
     * SOC跳变报警
     */
    private Boolean socJump;

    /**
     * 车载储能装置类型不匹配报警
     */
    private Boolean deviceTypeDontMatch;

    /**
     * 单体电池一致性差报警
     */
    private Boolean batteryConsistencyPoor;

    /**
     * 绝缘报警
     */
    private Boolean insulation;

    /**
     * DC温度报警
     */
    private Boolean dcTemperature;

    /**
     * 制动系统报警
     */
    private Boolean brakingSystem;

    /**
     * DC状态报警
     */
    private Boolean dcStatus;

    /**
     * 驱动电机控制器温度报警
     */
    private Boolean driveMotorControllerTemperature;

    /**
     * 高压互锁报警
     */
    private Boolean highPressureInterlock;

    /**
     * 驱动电机温度报警
     */
    private Boolean driveMotorTemperature;

    /**
     * 车载储能装置过充报警
     */
    private Boolean deviceTypeOverFilling;

    //可储能装置故障总数
    private Short deviceFailureCount;

    //可储能装置故障信息列表
    private List<Long> deviceFailureCodes;

    //驱动电机故障总数
    private Short driveMotorFailureCount;

    //驱动电机故障信息列表
    private List<Long> driveMotorFailureCodes;

    //发动机故障总数
    private Short engineFailureCount;

    //发动机故障信息列表
    private List<Long> engineFailureCodes;

    //其他故障总数
    private Short otherFailure;

    //其他故障信息列表
    private List<Long> otherFailureCodes;

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public Long getAlarmInfo() {
        return alarmInfo;
    }

    public void setAlarmInfo(Long alarmInfo) {
        this.alarmInfo = alarmInfo;
    }

    public Boolean getTemperatureDifferential() {
        return temperatureDifferential;
    }

    public void setTemperatureDifferential(Boolean temperatureDifferential) {
        this.temperatureDifferential = temperatureDifferential;
    }

    public Boolean getBatteryHighTemperature() {
        return batteryHighTemperature;
    }

    public void setBatteryHighTemperature(Boolean batteryHighTemperature) {
        this.batteryHighTemperature = batteryHighTemperature;
    }

    public Boolean getDeviceTypeOverVoltage() {
        return deviceTypeOverVoltage;
    }

    public void setDeviceTypeOverVoltage(Boolean deviceTypeOverVoltage) {
        this.deviceTypeOverVoltage = deviceTypeOverVoltage;
    }

    public Boolean getDeviceTypeUnderVoltage() {
        return deviceTypeUnderVoltage;
    }

    public void setDeviceTypeUnderVoltage(Boolean deviceTypeUnderVoltage) {
        this.deviceTypeUnderVoltage = deviceTypeUnderVoltage;
    }

    public Boolean getSocLow() {
        return socLow;
    }

    public void setSocLow(Boolean socLow) {
        this.socLow = socLow;
    }

    public Boolean getMonomerBatteryOverVoltage() {
        return monomerBatteryOverVoltage;
    }

    public void setMonomerBatteryOverVoltage(Boolean monomerBatteryOverVoltage) {
        this.monomerBatteryOverVoltage = monomerBatteryOverVoltage;
    }

    public Boolean getMonomerBatteryUnderVoltage() {
        return monomerBatteryUnderVoltage;
    }

    public void setMonomerBatteryUnderVoltage(Boolean monomerBatteryUnderVoltage) {
        this.monomerBatteryUnderVoltage = monomerBatteryUnderVoltage;
    }

    public Boolean getSocHigh() {
        return socHigh;
    }

    public void setSocHigh(Boolean socHigh) {
        this.socHigh = socHigh;
    }

    public Boolean getSocJump() {
        return socJump;
    }

    public void setSocJump(Boolean socJump) {
        this.socJump = socJump;
    }

    public Boolean getDeviceTypeDontMatch() {
        return deviceTypeDontMatch;
    }

    public void setDeviceTypeDontMatch(Boolean deviceTypeDontMatch) {
        this.deviceTypeDontMatch = deviceTypeDontMatch;
    }

    public Boolean getBatteryConsistencyPoor() {
        return batteryConsistencyPoor;
    }

    public void setBatteryConsistencyPoor(Boolean batteryConsistencyPoor) {
        this.batteryConsistencyPoor = batteryConsistencyPoor;
    }

    public Boolean getInsulation() {
        return insulation;
    }

    public void setInsulation(Boolean insulation) {
        this.insulation = insulation;
    }

    public Boolean getDcTemperature() {
        return dcTemperature;
    }

    public void setDcTemperature(Boolean dcTemperature) {
        this.dcTemperature = dcTemperature;
    }

    public Boolean getBrakingSystem() {
        return brakingSystem;
    }

    public void setBrakingSystem(Boolean brakingSystem) {
        this.brakingSystem = brakingSystem;
    }

    public Boolean getDcStatus() {
        return dcStatus;
    }

    public void setDcStatus(Boolean dcStatus) {
        this.dcStatus = dcStatus;
    }

    public Boolean getDriveMotorControllerTemperature() {
        return driveMotorControllerTemperature;
    }

    public void setDriveMotorControllerTemperature(Boolean driveMotorControllerTemperature) {
        this.driveMotorControllerTemperature = driveMotorControllerTemperature;
    }

    public Boolean getHighPressureInterlock() {
        return highPressureInterlock;
    }

    public void setHighPressureInterlock(Boolean highPressureInterlock) {
        this.highPressureInterlock = highPressureInterlock;
    }

    public Boolean getDriveMotorTemperature() {
        return driveMotorTemperature;
    }

    public void setDriveMotorTemperature(Boolean driveMotorTemperature) {
        this.driveMotorTemperature = driveMotorTemperature;
    }

    public Boolean getDeviceTypeOverFilling() {
        return deviceTypeOverFilling;
    }

    public void setDeviceTypeOverFilling(Boolean deviceTypeOverFilling) {
        this.deviceTypeOverFilling = deviceTypeOverFilling;
    }

    public Short getDeviceFailureCount() {
        return deviceFailureCount;
    }

    public void setDeviceFailureCount(Short deviceFailureCount) {
        this.deviceFailureCount = deviceFailureCount;
    }

    public List<Long> getDeviceFailureCodes() {
        return deviceFailureCodes;
    }

    public void setDeviceFailureCodes(List<Long> deviceFailureCodes) {
        this.deviceFailureCodes = deviceFailureCodes;
    }

    public Short getDriveMotorFailureCount() {
        return driveMotorFailureCount;
    }

    public void setDriveMotorFailureCount(Short driveMotorFailureCount) {
        this.driveMotorFailureCount = driveMotorFailureCount;
    }

    public List<Long> getDriveMotorFailureCodes() {
        return driveMotorFailureCodes;
    }

    public void setDriveMotorFailureCodes(List<Long> driveMotorFailureCodes) {
        this.driveMotorFailureCodes = driveMotorFailureCodes;
    }

    public Short getEngineFailureCount() {
        return engineFailureCount;
    }

    public void setEngineFailureCount(Short engineFailureCount) {
        this.engineFailureCount = engineFailureCount;
    }

    public List<Long> getEngineFailureCodes() {
        return engineFailureCodes;
    }

    public void setEngineFailureCodes(List<Long> engineFailureCodes) {
        this.engineFailureCodes = engineFailureCodes;
    }

    public Short getOtherFailure() {
        return otherFailure;
    }

    public void setOtherFailure(Short otherFailure) {
        this.otherFailure = otherFailure;
    }

    public List<Long> getOtherFailureCodes() {
        return otherFailureCodes;
    }

    public void setOtherFailureCodes(List<Long> otherFailureCodes) {
        this.otherFailureCodes = otherFailureCodes;
    }

    public AlarmData decode(ByteBuf byteBuf) {
        AlarmData alarmData = new AlarmData();
        alarmData.setLevel(byteBuf.readUnsignedByte());
        Long l = byteBuf.readUnsignedInt();
        alarmData.setAlarmInfo(l);
        char[] chars = Util.to32BinaryString(l.intValue()).toCharArray();
        //TODO 检查读取顺序是否正确
        alarmData.setTemperatureDifferential(Constants.CHAR_49 == (chars[chars.length - 1]));
        alarmData.setBatteryHighTemperature(Constants.CHAR_49 == (chars[chars.length - 2]));
        alarmData.setDeviceTypeOverVoltage(Constants.CHAR_49 == (chars[chars.length - 3]));
        alarmData.setDeviceTypeUnderVoltage(Constants.CHAR_49 == (chars[chars.length - 4]));
        alarmData.setSocLow(Constants.CHAR_49 == (chars[chars.length - 5]));
        alarmData.setMonomerBatteryOverVoltage(Constants.CHAR_49 == (chars[chars.length - 6]));
        alarmData.setMonomerBatteryUnderVoltage(Constants.CHAR_49 == (chars[chars.length - 7]));
        alarmData.setSocHigh(Constants.CHAR_49 == (chars[chars.length - 8]));
        alarmData.setSocJump(Constants.CHAR_49 == (chars[chars.length - 9]));
        alarmData.setDeviceTypeDontMatch(Constants.CHAR_49 == (chars[chars.length - 10]));
        alarmData.setBatteryConsistencyPoor(Constants.CHAR_49 == (chars[chars.length - 11]));
        alarmData.setInsulation(Constants.CHAR_49 == (chars[chars.length - 12]));
        alarmData.setDcTemperature(Constants.CHAR_49 == (chars[chars.length - 13]));
        alarmData.setBrakingSystem(Constants.CHAR_49 == (chars[chars.length - 14]));
        alarmData.setDcStatus(Constants.CHAR_49 == (chars[chars.length - 15]));
        alarmData.setDriveMotorControllerTemperature(Constants.CHAR_49 == (chars[chars.length - 16]));
        alarmData.setHighPressureInterlock(Constants.CHAR_49 == (chars[chars.length - 17]));
        alarmData.setDriveMotorTemperature(Constants.CHAR_49 == (chars[chars.length - 18]));
        alarmData.setDeviceTypeOverFilling(Constants.CHAR_49 == (chars[chars.length - 19]));
        short deviceFailureTotal = byteBuf.readUnsignedByte();
        alarmData.setDeviceFailureCount(deviceFailureTotal);
        List<Long> deviceFailuresList = new ArrayList<>(deviceFailureTotal);
        for (int i = 0; i < deviceFailureTotal; i++) {
            deviceFailuresList.add(byteBuf.readUnsignedInt());
        }
        alarmData.setDeviceFailureCodes(deviceFailuresList);
        short driveMotorFailureTotal = byteBuf.readUnsignedByte();
        alarmData.setEngineFailureCount(driveMotorFailureTotal);
        List<Long> driveMotorFailuresList = new ArrayList<>(driveMotorFailureTotal);
        for (int i = 0; i < driveMotorFailureTotal; i++) {
            driveMotorFailuresList.add(byteBuf.readUnsignedInt());
        }
        alarmData.setDriveMotorFailureCodes(driveMotorFailuresList);
        short engineFailureTotal=byteBuf.readUnsignedByte();
        alarmData.setEngineFailureCount(engineFailureTotal);
        List<Long> engineFailuresList = new ArrayList<>(engineFailureTotal);
        for (int i=0;i<engineFailureTotal;i++){
            engineFailuresList.add(byteBuf.readUnsignedInt());
        }
        alarmData.setDeviceFailureCodes(engineFailuresList);
        short otherFailureTotal=byteBuf.readUnsignedByte();
        alarmData.setOtherFailure(otherFailureTotal);
        List<Long> otherFailuresList=new ArrayList<>(otherFailureTotal);
        for(int i=0;i<otherFailureTotal;i++){
            otherFailuresList.add(byteBuf.readUnsignedInt());
        }
        alarmData.setOtherFailureCodes(otherFailuresList);
        return alarmData;
    }

}

