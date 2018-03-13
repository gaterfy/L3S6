package udp;
import java.net.*;
import java.io.*;

public class ReceiveUdp {

	public static void main(String[] args) throws IOException {
		while(true){
			sender();
		}

	}
	
	public static void sender() throws IOException{
		int i;
		DatagramSocket s;
		DatagramPacket p;
		
		s = new DatagramSocket(1500);
		p = new DatagramPacket(new byte[512],512);
		
		s.receive(p);
		
		System.out.println("paquet reçu de :"+ p.getAddress()+
		"port "+            p.getPort()+
		"taille" +          p.getLength());
		
		byte array[] = p.getData();
		
		for(i=0;i<p.getLength();i++)
			System.out.println("array["+i+"] = "+array[i]);
		
		s.close();

	}
	
}
