import io.netty.buffer.ByteBuf;

public class BeanTime {

    private short year;

    private short month;

    private short day;

    private short hours;

    private short minutes;

    private short seconds;


    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public short getMonth() {
        return month;
    }

    public void setMonth(short month) {
        this.month = month;
    }

    public short getDay() {
        return day;
    }

    public void setDay(short day) {
        this.day = day;
    }

    public short getHours() {
        return hours;
    }

    public void setHours(short hours) {
        this.hours = hours;
    }

    public short getMinutes() {
        return minutes;
    }

    public void setMinutes(short minutes) {
        this.minutes = minutes;
    }

    public short getSeconds() {
        return seconds;
    }

    public void setSeconds(short seconds) {
        this.seconds = seconds;
    }

    public BeanTime decode(ByteBuf byteBuf) {
        BeanTime beanTime = new BeanTime();
        beanTime.setYear(byteBuf.readUnsignedByte());
        beanTime.setMonth(byteBuf.readUnsignedByte());
        beanTime.setDay(byteBuf.readUnsignedByte());
        beanTime.setHours(byteBuf.readUnsignedByte());
        beanTime.setMinutes(byteBuf.readUnsignedByte());
        beanTime.setSeconds(byteBuf.readUnsignedByte());
        return beanTime;
    }
}
