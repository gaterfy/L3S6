package udp1;
import java.net.*;
import java.io.*;

public class ReceiveUdp {

	public static void main(String[] args) throws IOException {
		
		int port = 1500;/*args[1]*/;
		//int port = Integer.parseInt(pport);
		
		while(true){
			sender(port);
		}

	}
	
	public static void sender(int port) throws IOException{
		DatagramSocket s;
		DatagramPacket p;
		
		s = new DatagramSocket(port);
		p = new DatagramPacket(new byte[512],512);
		
		s.receive(p);
		
		System.out.println("paquet reçu de :"+ p.getAddress()+
		"port "+            p.getPort()+
		"taille" +          p.getLength());
		
		byte array[] = p.getData();
		
		/*for(i=0;i<p.getLength();i++)
			System.out.println("array["+i+"] = "+array[i]);
		*/
		System.out.println(new String(array));
		s.close();

	}
	
}
