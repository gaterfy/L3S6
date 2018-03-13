package udp2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Class used to send a message
 * It should be used as a thread
 */
public class discUDP implements Runnable {

    //Fields
    protected BufferedReader in;
    protected MulticastSocket socket;
    protected InetAddress dst;
    protected int port;
    protected String nickname;

    //Methods

    /**
     * Constructor for this class
     * @param socket the socket we want to read into
     * @param nickname the name we want the message to be sent with
     */
    public discUDP(MulticastSocket socket, String nickname) throws Exception {
		this.nickname = nickname;
		this.in = new BufferedReader(new InputStreamReader(System.in)); 
		this.socket = socket;
		this.port = 7654;
		this.dst = InetAddress.getByName("224.0.0.1");
    }

    /**
     * Waits for an input message then send it.
     * If we type /part, the program stops.
     */
    public void run () {
	DatagramPacket packet;
	String str = null;
	try {
	    while(!(str = this.in.readLine()).equals("/part") && !(str == null)) {
		byte[] msg = (this.nickname + " > " + str).getBytes();
		packet = new DatagramPacket(msg, msg.length, dst, port);
		socket.setTimeToLive(1);
		socket.send(packet);
	    }	
	} catch (IOException e) {
	    System.out.println("Tchat (SendUDP): Problème rencontré à l'envoi d'un message");
	}
	System.out.println("Fermeture du programme de Tchat.");
    }
    
}
