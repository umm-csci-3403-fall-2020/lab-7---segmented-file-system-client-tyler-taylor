package segmentedfilesystem;

import java.io.*;
import java.net.Socket;

public class FileRetriever {

	String server;
	int port;

	public FileRetriever(String server, int port){
        // Save the server and port for use in `downloadFiles()`
        //...
		this.server = server;
		this.port = port;

	}

	public void downloadFiles() throws IOException {
		Socket socket = new Socket(server, port);
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		PacketManager manage = new PacketManager(pack);
		try {
			int download;
			while(((download = in.read()) != 1)){
				download

			}

		}
		catch (IOException e){
		e.printStackTrace();
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



}
