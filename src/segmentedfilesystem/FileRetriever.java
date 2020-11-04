package segmentedfilesystem;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class FileRetriever {

	String server;
	int port;
	DatagramSocket socket;
	InetAddress address;
	DatagramPacket packet;

	public FileRetriever(String server, int port){
        // Save the server and port for use in `downloadFiles()`
        //...
		this.server = server;
		this.port = port;
		this.socket = socket;
		this.address = address;
		this.packet = packet;

	}

	public void downloadFiles() throws IOException {
		byte[] buffer = new byte[1028];
		int length = 1028;
		address = InetAddress.getByName(server);
		socket = new DatagramSocket();
		packet = new DatagramPacket(buffer, length, address, port);
		socket.send(packet);
		try {
			ArrayList<HeaderPacket> head = new ArrayList<>();
			ArrayList<DataPacket> dataList = new ArrayList<>();
			while(true) {
				socket.receive(packet);
				byte[] temp = packet.getData();


				if (temp[0] % 2 == 1) {
					DataPacket data = new DataPacket(packet);
					dataList.add(data);
				}
				else {
					HeaderPacket header = new HeaderPacket(packet);
					PacketManager headManage = new PacketManager(header.getID());
					head.add(header);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


        // Do all the heavy lifting here.
        // This should
        //   * Connect to the server
        //   * Download packets in some sort of loop
        //   * Handle the packets as they come in by, e.g.,
        //     handing them to some PacketManager class
        // Your loop will need to be able to ask someone
        // if you've received all the packets, and can thus
        // terminate. You might have a method like
        // PacketManager.allPacketsReceived() that you could
        // call for that, but there are a bunch of possible
        // ways.
	}




