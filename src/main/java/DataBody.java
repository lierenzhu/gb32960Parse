import io.netty.buffer.ByteBuf;

public class DataBody implements IStatus {

    //命令种类
    private CommandType commandType;

    //车辆登入
    private VehicleLogin vehicleLogin;

    //信息上报
    private RealTimeData realTimeData;

    //车辆登出
    private VehicleLogout vehicleLogout;

    //平台登入
    private PlatformLogin platformLogin;

    //平台登出
    private PlatformLogout platformLogout;

    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public VehicleLogin getVehicleLogin() {
        return vehicleLogin;
    }

    public void setVehicleLogin(VehicleLogin vehicleLogin) {
        this.vehicleLogin = vehicleLogin;
    }

    public RealTimeData getRealTimeData() {
        return realTimeData;
    }

    public void setRealTimeData(RealTimeData realTimeData) {
        this.realTimeData = realTimeData;
    }

    public VehicleLogout getVehicleLogout() {
        return vehicleLogout;
    }

    public void setVehicleLogout(VehicleLogout vehicleLogout) {
        this.vehicleLogout = vehicleLogout;
    }

    public PlatformLogin getPlatformLogin() {
        return platformLogin;
    }

    public void setPlatformLogin(PlatformLogin platformLogin) {
        this.platformLogin = platformLogin;
    }

    public PlatformLogout getPlatformLogout() {
        return platformLogout;
    }

    public void setPlatformLogout(PlatformLogout platformLogout) {
        this.platformLogout = platformLogout;
    }

    public DataBody decode(ByteBuf byteBuf,CommandType commandType){
        DataBody dataBody=new DataBody();
        VehicleLogin vehicleLogin=new VehicleLogin();
        RealTimeData realTimeData=new RealTimeData();
        VehicleLogout vehicleLogout=new VehicleLogout();
        PlatformLogin platformLogin=new PlatformLogin();
        PlatformLogout platformLogout=new PlatformLogout();
        if (commandType==CommandType.VEHICLE_LOGIN){
            dataBody.setVehicleLogin(vehicleLogin.decode(byteBuf));
        }else if(commandType==CommandType.REALTIME_DATA_REPORTING){
            dataBody.setRealTimeData(realTimeData.decode(byteBuf));
        }else if(commandType==CommandType.REPLACEMENT_DATA_REPORTING){
            //TODO 补发报文未解析
        }else if(commandType==CommandType.VEHICLE_LOGOUT){
            dataBody.setVehicleLogout(vehicleLogout.decode(byteBuf));
        }else if(commandType==CommandType.PLATFORM_LOGIN){
            dataBody.setPlatformLogin(platformLogin.decode(byteBuf));
        }else if(commandType==CommandType.PLATFORM_LOGOUT){
            dataBody.setPlatformLogout(platformLogout.decode(byteBuf));
        }

        return dataBody;
    }

    @Override
    public Object decode(ByteBuf byteBuf) {
        return null;
    }
}
