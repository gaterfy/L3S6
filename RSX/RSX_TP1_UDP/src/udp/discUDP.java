package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class discUDP {
	public static void main(String[] args) throws IOException{
		DatagramPacket p;
		DatagramSocket s;
		
		InetAddress dst = InetAddress.getByName("a11p12");
		
		int port = 1500 ;
		
		byte array[] = new byte[2];
		array[0] = 1;
		array[1] = 2;
		
		p = new DatagramPacket(array, 2, dst, port);
		s = new DatagramSocket();
		
		s.send(p);
		s.close();
	}
}
