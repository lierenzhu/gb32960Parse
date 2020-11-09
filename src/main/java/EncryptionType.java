public enum EncryptionType {

    NONE((short)1,"不加密"),
    RSA((short)2,"经过RSA加密"),
    AES((short)3,"经过AES加密"),
    INVAILD((short)254,"异常"),   //0xFE = 254
    ERROR((short)255,"无效");     //0xFF = 255

    private Short id;
    private String desc;

    EncryptionType(Short id,String desc){
        this.id=id;
        this.desc=desc;
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

    public static EncryptionType valuesOf(Short id){
        for(EncryptionType enums:EncryptionType.values()){
            if(enums.getId()==id){
                return enums;
            }
        }
        return null;
    }
}
