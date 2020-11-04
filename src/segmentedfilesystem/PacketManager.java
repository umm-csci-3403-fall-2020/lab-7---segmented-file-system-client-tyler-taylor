package segmentedfilesystem;
import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.List;

public class PacketManager {
    boolean full;
    List<DataPacket> dataPacketList;
    int maxSize;
    byte ID;
    DatagramPacket packet;

    public PacketManager(byte ID) {
        this.dataPacketList = new ArrayList<DataPacket>();
        this.full = false;
        this.maxSize = 100000;
        this.ID = ID;
        this.packet = packet;

    }

    public void allPacketsRecieved(DataPacket dpacket){
        dataPacketList.add(dpacket);
        if (dataPacketList.size() == this.maxSize){
            this.full = true;
        }

    }
    public void createFile(ArrayList<DataPacket> data, ArrayList<HeaderPacket> head){
        
    }

    public void setID(byte ID) {
        this.ID = ID;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
}
