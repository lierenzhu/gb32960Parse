import io.netty.buffer.ByteBuf;

public class EngineData implements IStatus{

    //发动机状态
    private Short Status;

    //曲轴转速
    private Integer crankshaftSpeed;

    //燃料消耗率
    private Integer fuelConsumption;

    public Short getStatus() {
        return Status;
    }

    public void setStatus(Short status) {
        Status = status;
    }

    public Integer getCrankshaftSpeed() {
        return crankshaftSpeed;
    }

    public void setCrankshaftSpeed(Integer crankshaftSpeed) {
        this.crankshaftSpeed = crankshaftSpeed;
    }

    public Integer getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Integer fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public EngineData decode(ByteBuf byteBuf){
        EngineData engineData=new EngineData();
        engineData.setStatus(byteBuf.readUnsignedByte());
        engineData.setCrankshaftSpeed(byteBuf.readUnsignedShort());
        engineData.setFuelConsumption(byteBuf.readUnsignedShort());
        return engineData;
    }
}

