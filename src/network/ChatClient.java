package network;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	ChatClient() throws UnknownHostException, IOException
	{
		Socket socket = new Socket("localhost", 4444);
		
	}
	void communicate()
	{
		Sender senderThread=new senderThread();
		senderThread.start();
		
		Receiver receverThread = new eceiver();
		receiverThread.start();
		
	}

}
