package segmentedfilesystem;
import java.util.Arrays;
import java.net.DatagramPacket;

public class HeaderPacket {
    String stat = "header";
    DatagramPacket packet;
    byte[] name;
    byte ID;

    public HeaderPacket(DatagramPacket packet){
        this.packet = packet;
        ID = packet.getData()[1];
        int nameLength = packet.getLength();
        name = Arrays.copyOfRange(packet.getData(), 2, nameLength);
    }
    public byte[] getName() {
        return name;
    }
    public byte getID() {
        return ID;
    }
}
