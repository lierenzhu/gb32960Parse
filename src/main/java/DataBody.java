import io.netty.buffer.ByteBuf;

public class DataBody implements IStatus {

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

    public DataBody decode(ByteBuf byteBuf){
        DataBody dataBody=new DataBody();
        VehicleLogin vehicleLogin=new VehicleLogin();
        RealTimeData realTimeData=new RealTimeData();
        VehicleLogout vehicleLogout=new VehicleLogout();
        PlatformLogin platformLogin=new PlatformLogin();
        PlatformLogout platformLogout=new PlatformLogout();
        dataBody.setVehicleLogin(vehicleLogin.decode(byteBuf));
        dataBody.setRealTimeData(realTimeData.decode(byteBuf));
        dataBody.setVehicleLogout(vehicleLogout.decode(byteBuf));
        dataBody.setPlatformLogin(platformLogin.decode(byteBuf));
        dataBody.setPlatformLogout(platformLogout.decode(byteBuf));

        return dataBody;
    }

}
