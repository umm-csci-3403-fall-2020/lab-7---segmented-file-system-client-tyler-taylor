package segmentedfilesystem;
import java.util.Arrays;
import java.net.DatagramPacket;

public class DataPacket {
    byte[] status;
    byte[] ID;
    byte[] packNum;
    byte[] data;
    public DataPacket(DatagramPacket packet){
        this.status = packet.getData();
        this.ID = ID;
        this.packNum = packNum;
        this.data = data;


    }
}
