import io.netty.buffer.ByteBuf;

public class LocationData implements IStatus{

    //定位状态
    private Short status;

    //是否有效定位
    private Boolean valid;

    //经度类型
    private LongitudeDataType longitudeDataType;

    //纬度类型
    private LatitudeDataType latitudeDataType;

    //经度
    private Long longitude;

    //纬度
    private Long latitude;

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public LongitudeDataType getLongitudeDataType() {
        return longitudeDataType;
    }

    public void setLongitudeDataType(LongitudeDataType longitudeDataType) {
        this.longitudeDataType = longitudeDataType;
    }

    public LatitudeDataType getLatitudeDataType() {
        return latitudeDataType;
    }

    public void setLatitudeDataType(LatitudeDataType latitudeDataType) {
        this.latitudeDataType = latitudeDataType;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public LocationData decode(ByteBuf byteBuf){
        LocationData locationData=new LocationData();
        locationData.setStatus(byteBuf.readUnsignedByte());
        locationData.setLongitude(byteBuf.readUnsignedInt());
        locationData.setLatitude(byteBuf.readUnsignedInt());
        char[] chars=Util.to32BinaryString(locationData.getStatus()).toCharArray();
        locationData.setValid(Constants.CHAR_48==(chars[chars.length-1]));  //TODO 检查读取顺序是否正确
        locationData.setLatitudeDataType(LatitudeDataType.valuesOfChar(chars[chars.length-2]));
        locationData.setLongitudeDataType(LongitudeDataType.valuesOfChar(chars[chars.length-3]));
        return locationData;
    }
}

