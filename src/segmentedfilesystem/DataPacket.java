package segmentedfilesystem;
import java.util.Arrays;
import java.net.DatagramPacket;

public class DataPacket {
    String stat = "data"; 
    byte status;
    byte[] data;
    int packNum;
    byte ID;
    byte[] info;
    boolean added;
    
    public DataPacket(DatagramPacket packet){
        this.data = packet.getData();
        this.setPackNum();
	    this.ID = data[1];
	    this.status = data[0];
	    int length = packet.getLength();
	    this.info = Arrays.copyOfRange(packet.getData(), 4, length);
	    this.added = false;
    }
    public void setPackNum() {
	    int x = Byte.toUnsignedInt(data[2]);
	    int y = Byte.toUnsignedInt(data[3]);
	    this.packNum = (256 * x + y);
    }
    public byte getID() {
        return ID;
    }
}
