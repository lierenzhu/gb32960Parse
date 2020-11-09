import io.netty.buffer.ByteBuf;

public interface IStatus<T> {
    T decode(ByteBuf byteBuf);
}
