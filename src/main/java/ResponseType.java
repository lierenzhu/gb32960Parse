public enum ResponseType {

    SUCCESS((short) 1, "成功"),
    FAILURE((short) 2, "失败"),
    VIN_REPEAT((short) 3, "VIN重复"),
    COMMAND((short) 254, "表示数据包为命令包");    //0xFE = 254

    private Short id;
    private String desc;

    ResponseType(Short id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static ResponseType valuesOf(Short id) {
        for (ResponseType enums : ResponseType.values()) {
            if (enums.getId() == id) {
                return enums;
            }
        }
        return null;
    }
}
