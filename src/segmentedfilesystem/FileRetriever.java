package segmentedfilesystem;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

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
		address = InetAddress.getByName(server);
		socket = new DatagramSocket(port, address);
		socket.send(packet);
		try {
			while(true) {
				socket.receive(packet);
				byte[] temp = packet.getData();

				if (temp[0] % 2 == 1) {
					DataPacket data = new DataPacket(packet);
				} else {
					//HeaderFile header = new HeaderFile(packet);
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




