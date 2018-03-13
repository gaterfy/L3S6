package udp2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Multi {
	public static void main(String[] args) throws IOException{
		String message =new String("ok");
		DatagramPacket p;
		DatagramSocket s;
		
		InetAddress dst = InetAddress.getByName("224.0.0.1");
		
		int port = 7654;
		byte array[] = message.getBytes();
		
		
		p = new DatagramPacket(array, array.length, dst, port);
		s = new DatagramSocket();
		
		s.send(p);
		s.close();
	}
}
