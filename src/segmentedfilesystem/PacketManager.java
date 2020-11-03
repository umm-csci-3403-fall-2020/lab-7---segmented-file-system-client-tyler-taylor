package segmentedfilesystem;
import java.util.ArrayList;
import java.util.List;

public class PacketManager {
    boolean full;
    List<DataPacket> dataPacketList;
    int maxSize;
    byte ID;

    public PacketManager(byte ID) {
        this.dataPacketList = new ArrayList<DataPacket>();
        this.full = false;
        this.maxSize = 100000;
        this.ID = ID;

    }

    public void allPacketsRecieved(DataPacket dpacket){
        dataPacketList.add(dpacket);
        if (dataPacketList.size() == this.maxSize){
            this.full = true;
        }

    }

    public void setID(byte ID) {
        this.ID = ID;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
}
