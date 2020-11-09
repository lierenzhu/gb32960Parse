import io.netty.buffer.ByteBuf;

public class Error implements IStatus {

    private String error="上报数据格式错误";

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String decode(ByteBuf byteBuf){
        Error error=new Error();
        return error.getError();
    }
}
