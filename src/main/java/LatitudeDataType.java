public enum LatitudeDataType {

    //维度类型数据

    NORTH("0","北纬"),
    SOUTH("1","南纬");

    private String binary;
    private String desc;

    LatitudeDataType(String binary,String desc){
        this.binary=binary;
        this.desc=desc;
    }

    public String getBinary() {
        return binary;
    }

    public void setBinary(String binary) {
        this.binary = binary;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static LatitudeDataType valuesOfChar(char aChar) {
        switch (aChar) {
            case (char)48:
                return NORTH;
            case (char)49:
                return SOUTH;
            default:
                throw new NumberFormatException();
        }
    }

    public static LatitudeDataType valuesOfBinary(String binary) {
        switch (binary) {
            case "0":
                return NORTH;
            case "1":
                return SOUTH;
            default:
                throw new NumberFormatException();
        }
    }

    //TODO 处理异常
}
