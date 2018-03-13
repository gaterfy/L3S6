package udp2;

import java.net.InetAddress;
import java.net.MulticastSocket;


public class ChatReceive extends Thread{
	//Fields
    protected MulticastSocket socket;
    protected String nickname;

    //Methods

    /**
     * Constructor of this class
     * @param nickname the name we want the message to be sent with
     */
    public ChatReceive(String nickname) throws Exception{
	this.nickname = nickname;
	
	int port = 7654;
	InetAddress dst = InetAddress.getByName("224.0.0.1");

	socket = new MulticastSocket(port);
	socket.joinGroup(dst);
    }

    /**
     * Runs the program.
     * Creates a thread for receiving the messages and another to send them.
     * Closes the socket when terminated
     */
    public void run(){
	ReceiveUdp receive = null;
	try {
		receive = new ReceiveUdp(this.socket);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	discUDP send = null;
	try {
		send = new discUDP(this.socket, this.nickname);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Thread trReceive = new Thread(receive);
	Thread trSend = new Thread(send);

	
	trReceive.start();
	trSend.start();
	try {
		trSend.join();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	this.socket.close();
    }

    /**
     * Runs the tchat program in a shell
     */
    public static void main (String[] args) throws Exception {
	String nickname;
	
	System.out.println("Bienvenue dans ce Tchat !");
	System.out.print("> ");
	if(args.length >= 1 && !args[0].equals(""))
	    nickname = args[0];
	else
	    nickname = "Osm";
	
	ChatReceive tchat = new ChatReceive(nickname);
	tchat.run();
    }

}
