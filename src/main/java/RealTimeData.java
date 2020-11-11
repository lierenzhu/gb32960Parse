import io.netty.buffer.ByteBuf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RealTimeData {

    private static final Logger LOGGER = LoggerFactory.getLogger(RealTimeData.class);

    private static final BeanTime producer = new BeanTime();

    //数据采集时间
    private BeanTime beanTime;

    //整车数据
    private VehicleData vehicleData;

    //驱动电机个数
    private Short driveMotorCount;

    //驱动电机数据列表
    private List<DriveMotorData> driveMotorDatas;

    //燃料电池数据
    private FuelCellData fuelCellData;

    //发动机数据
    private EngineData engineData;

    //位置数据
    private LocationData locationData;

    //极值数据
    private ExtremeData extremeData;

    //报警数据
    private AlarmData alarmData;

    //可充电储能装置电压数据个数
    private Short subsystemVoltageCount;

    //可充电储能装置电压数据列表
    private List<SubSystemVoltageData> subSystemVoltageDatas;

    //可充电储能装置温度数据个数
    private Short subsystemTemperatureCount;

    //可充电储能装置温度数据列表
    private List<SubSystemTemperature> subSystemTemperatures;

    public static BeanTime getProducer() {
        return producer;
    }

    public BeanTime getBeanTime() {
        return beanTime;
    }

    public void setBeanTime(BeanTime beanTime) {
        this.beanTime = beanTime;
    }

    public VehicleData getVehicleData() {
        return vehicleData;
    }

    public void setVehicleData(VehicleData vehicleData) {
        this.vehicleData = vehicleData;
    }

    public Short getDriveMotorCount() {
        return driveMotorCount;
    }

    public void setDriveMotorCount(Short driveMotorCount) {
        this.driveMotorCount = driveMotorCount;
    }

    public List<DriveMotorData> getDriveMotorDatas() {
        return driveMotorDatas;
    }

    public void setDriveMotorDatas(List<DriveMotorData> driveMotorDatas) {
        this.driveMotorDatas = driveMotorDatas;
    }

    public FuelCellData getFuelCellData() {
        return fuelCellData;
    }

    public void setFuelCellData(FuelCellData fuelCellData) {
        this.fuelCellData = fuelCellData;
    }

    public EngineData getEngineData() {
        return engineData;
    }

    public void setEngineData(EngineData engineData) {
        this.engineData = engineData;
    }

    public LocationData getLocationData() {
        return locationData;
    }

    public void setLocationData(LocationData locationData) {
        this.locationData = locationData;
    }

    public ExtremeData getExtremeData() {
        return extremeData;
    }

    public void setExtremeData(ExtremeData extremeData) {
        this.extremeData = extremeData;
    }

    public AlarmData getAlarmData() {
        return alarmData;
    }

    public void setAlarmData(AlarmData alarmData) {
        this.alarmData = alarmData;
    }

    public Short getSubsystemVoltageCount() {
        return subsystemVoltageCount;
    }

    public void setSubsystemVoltageCount(Short subsystemVoltageCount) {
        this.subsystemVoltageCount = subsystemVoltageCount;
    }

    public List<SubSystemVoltageData> getSubSystemVoltageDatas() {
        return subSystemVoltageDatas;
    }

    public void setSubSystemVoltageDatas(List<SubSystemVoltageData> subSystemVoltageDatas) {
        this.subSystemVoltageDatas = subSystemVoltageDatas;
    }

    public Short getSubsystemTemperatureCount() {
        return subsystemTemperatureCount;
    }

    public void setSubsystemTemperatureCount(Short subsystemTemperatureCount) {
        this.subsystemTemperatureCount = subsystemTemperatureCount;
    }

    public List<SubSystemTemperature> getSubSystemTemperatures() {
        return subSystemTemperatures;
    }

    public void setSubSystemTemperatures(List<SubSystemTemperature> subSystemTemperatures) {
        this.subSystemTemperatures = subSystemTemperatures;
    }

    public RealTimeData decode(ByteBuf byteBuf) {

        RealTimeData realTimeData = new RealTimeData();
        BeanTime beanTime = producer.decode(byteBuf);
        realTimeData.setBeanTime(beanTime);
        while (byteBuf.isReadable()) {
            decodeByType(byteBuf, realTimeData);
        }
        return realTimeData;
    }

    private void decodeByType(ByteBuf byteBuf, RealTimeData realTimeData) {
        RealTimeDataType type = RealTimeDataType.valuesOf(byteBuf.readUnsignedByte());
        switch (type) {
            case VEHICLE: {
                IStatus<VehicleData> status = type.getStatus();
                realTimeData.setVehicleData(status.decode(byteBuf.readSlice(20)));
                break;
            }
            case DRIVEMOTOR: {
                IStatus<DriveMotorData> status = type.getStatus();
                realTimeData.setDriveMotorCount(byteBuf.readUnsignedByte());
                List<DriveMotorData> motorDatas = new ArrayList<>();
                if (realTimeData.getDriveMotorCount() > 0 && realTimeData.getDriveMotorCount() < 253) {
                    for (int i = 0; i < realTimeData.getDriveMotorCount(); i++) {
                        motorDatas.add(status.decode(byteBuf));
                    }
                } else {
                    LOGGER.error("decodeByType {} count:{}", type.getDesc(), realTimeData.getDriveMotorCount());
                }
                realTimeData.setDriveMotorDatas(driveMotorDatas);
                break;
            }
            case FUELCELL: {
                IStatus<FuelCellData> status = type.getStatus();
                realTimeData.setFuelCellData(status.decode(byteBuf));
                break;
            }
            case ENGINE: {
                IStatus<EngineData> status = type.getStatus();
                realTimeData.setEngineData(status.decode(byteBuf));
                break;
            }
            case LOCATION: {
                IStatus<LocationData> status = type.getStatus();
                realTimeData.setLocationData(status.decode(byteBuf));
                break;
            }
            case EXTREME: {
                IStatus<ExtremeData> status = type.getStatus();
                realTimeData.setExtremeData(status.decode(byteBuf));
                break;
            }
            case ALARM: {
                IStatus<AlarmData> status = type.getStatus();
                realTimeData.setAlarmData(status.decode(byteBuf));
                break;
            }
            case VOLTAGE: {
                IStatus<SubSystemVoltageData> status = type.getStatus();
                realTimeData.setSubsystemVoltageCount(byteBuf.readUnsignedByte());
                List<SubSystemVoltageData> voltageData = new ArrayList<>();
                if (realTimeData.getSubsystemVoltageCount() > 0 && realTimeData.getSubsystemVoltageCount() < 250) {
                    for (int i = 0; i < realTimeData.getSubsystemVoltageCount(); i++) {
                        byteBuf.markReaderIndex();
                        byteBuf.skipBytes(9);
                        short j = byteBuf.readUnsignedByte();
                        byteBuf.resetReaderIndex();
                        voltageData.add(status.decode(byteBuf.readSlice(10 + j * 2)));
                    }
                } else {
                    LOGGER.error("decodeByType {} count:{}", type.getDesc(), realTimeData.getSubsystemVoltageCount());
                }
                realTimeData.setSubSystemVoltageDatas(voltageData);
                break;
            }
            case TEMPERATURE: {
                IStatus<SubSystemTemperature> status = type.getStatus();
                realTimeData.setSubsystemTemperatureCount(byteBuf.readUnsignedByte());
                List<SubSystemTemperature> temperatureData = new ArrayList<>();
                if (realTimeData.getSubsystemTemperatureCount() > 0 && realTimeData.getSubsystemTemperatureCount() <= 250) {
                    for (int i = 0; i < realTimeData.getSubsystemTemperatureCount(); i++) {
                        byteBuf.markReaderIndex();
                        byteBuf.skipBytes(1);
                        int j = byteBuf.readUnsignedShort();
                        byteBuf.resetReaderIndex();
                        temperatureData.add(status.decode(byteBuf.readSlice(3 + j * 1)));
                    }
                } else {
                    LOGGER.error("decodeByType {} count:{}", type.getDesc(), realTimeData.getSubsystemTemperatureCount());
                }
                realTimeData.setSubSystemTemperatures(temperatureData);
                break;
            }
            default:
                LOGGER.warn("decode RealtimeData error");
        }

    }
}
