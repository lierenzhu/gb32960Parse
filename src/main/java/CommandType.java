public enum CommandType {

    //上行数据
    VEHICLE_LOGIN((short) 1, "车辆登入"),
    REALTIME_DATA_REPORTING((short) 2, "实时信息上报"),
    REPLACEMENT_DATA_REPORTING((short) 3, "补发信息上报"),
    VEHICLE_LOGOUT((short) 4, "车辆登出"),
    PLATFORM_LOGIN((short) 5, "平台登入"),
    PLATFORM_LOGOUT((short) 6, "平台登出");
    //7             终端数据预留
    //8             终端数据预留
    //0x09~0x7F     上行数据系统预留

    //下行数据
    //0x80~0x82     终端数据预留
    //0x83~0xBF     下行数据系统预留
    //0xC0~0xFE     平台交换自定义数据


    private Short id;
    private String desc;

    CommandType(Short id, String desc) {
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

    public static CommandType valuesOf(Short id) {
        for (CommandType enums : CommandType.values()) {
            if (enums.getId() == id)
                return enums;
        }
        return null;
    }

    public static CommandType valuesOf(String name) {
        for (CommandType enums : CommandType.values()) {
            if (enums.name().equals(name))
                return enums;
        }
        return null;
    }
}
