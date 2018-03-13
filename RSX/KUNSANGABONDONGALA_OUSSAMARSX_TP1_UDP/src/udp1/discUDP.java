package udp1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class discUDP {
	

	public static void main(String[] args) throws IOException{
		String message = new String("Bienvenue su notre session");
		DatagramPacket p;
		DatagramSocket s;
		
		InetAddress dst = InetAddress.getByName("a11p12");
		
		int port = 1500 ;
		
		byte array[] = message.getBytes();
		
		
		p = new DatagramPacket(array, array.length, dst, port);
		s = new DatagramSocket();
		
		s.send(p);
		s.close();
	}
}

//1xq7 le nom de machine