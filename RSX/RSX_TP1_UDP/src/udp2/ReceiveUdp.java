package udp2;

import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.lang.String;
import java.lang.Runnable;
import java.io.IOException;

/**
 * Class used to receive a message
 * It should be used as a thread
 */
public class ReceiveUdp implements Runnable{

    //Fields
    protected MulticastSocket socket;
    protected int port;
    protected InetAddress dst;

    //Methods

    /**
     * Constructor for this class
     * @param socket the socket we want to read into
     */
    public ReceiveUdp(MulticastSocket socket) throws Exception {
	this.port = 7654;
	this.dst = InetAddress.getByName("224.0.0.1");
	this.socket = socket;
    }

    @Override
    /**
     * Receive a message from the socket while the socket is opened
     */
    public void run () {
	DatagramPacket packet; 
	byte[] msg;
	String str;
	while(!this.socket.isClosed()) {
	    packet = new DatagramPacket(new byte[512], 512);

	    try {
		this.socket.receive(packet);

		if(!packet.getAddress().equals(this.dst)) {
		    System.out.println("paquet reçu de " + packet.getAddress() + " port " + packet.getPort() + " taille " + packet.getLength());
		
		    msg = packet.getData();
		    str = new String(msg);
		    System.out.println(str);
		    System.out.print("> ");
		}
	    } catch(IOException e) {
		if(!this.socket.isClosed()) {
		   System.out.println("Tchat (ReceiveUDP): Problème rencontré à la réception d'un message");
		}
	    }
	}
    }

}
