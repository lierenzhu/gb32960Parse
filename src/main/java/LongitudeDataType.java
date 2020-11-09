public enum LongitudeDataType {

    //经度类型数据

    EAST("0","东经"),
    WEST("1","西经");

    private String binary;
    private String desc;

    LongitudeDataType(String binary, String desc) {
        this.binary = binary;
        this.desc = desc;
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

    public static LongitudeDataType valuesOfChar(char aChar) {
        switch (aChar) {
            case (char)48:
                return EAST;
            case (char)49:
                return WEST;
            default:
                throw new NumberFormatException();
        }
    }

    public static LongitudeDataType valuesOfBinary(String binary) {
        switch (binary) {
            case "0":
                return EAST;
            case "1":
                return WEST;
            default:
                throw new NumberFormatException();
        }
    }

    //TODO 处理异常
}
