package segmentedfilesystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceivedPackets {
    boolean used =false;
    public ReceivedPackets() {
}
    public List<DataPacket> sortPackets(Map<Integer, DataPacket> dataPacketList) {
        List<Integer> sortedKeys = new ArrayList<Integer>(dataPacketList.keySet());
        Collections.sort(sortedKeys);
        List<DataPacket> sortedData = new ArrayList<DataPacket>();
        for (Integer key : sortedKeys) {
            sortedData.add(dataPacketList.get(key));
        }
        for(int i =0; i<sortedData.size(); i++){
            System.out.println(sortedData.get(i).packetNumber + "Packet Number");
        }
        return sortedData;
    }

    public void assembleFile(List<DataPacket> dataPackets, HeaderPacket header) throws IOException {
        String name = new String(header.getName());
        Map<Integer, DataPacket> dataPacketList = new HashMap<Integer, DataPacket>();
        for (int j = 0; j < dataPackets.size(); j++) {
            DataPacket dataPacket = dataPackets.get(j);
            dataPacketList.put(dataPacket.packetNumber, dataPacket);
        }
        List<DataPacket> sorted = sortPackets(dataPacketList);
        writeToFile(sorted, name);
    }
    public void packagePackets(List<HeaderPacket> headers, List<PacketManager> packetList) throws IOException {
        for (int i = 0; i < headers.size(); i++) {
            HeaderPacket header = headers.get(i);
            byte ID = header.ID;
            PacketManager chosenOne = new PacketManager((byte ) 1);
            for(int j =0; j<packetList.size(); j++){
                if(ID == packetList.get(j).ID){
                    chosenOne = packetList.get(j);
                }
            }
            System.out.println(chosenOne.dataPacketList.size());
            ReceivedPackets receivedPackets = new ReceivedPackets();
            receivedPackets.assembleFile(chosenOne.dataPacketList, header);
            System.out.println("FILE COMPLETED");

        }



    }

    public void writeToFile(List<DataPacket> sorted, String name) throws IOException {
        File file = new File(name);
        FileOutputStream out = new FileOutputStream(file);
        for (int i = 0; i < sorted.size(); i++) {
            out.write(sorted.get(i).info);

        }
        out.flush();
        out.close();

    }
}
