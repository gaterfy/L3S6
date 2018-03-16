import java.io.*;
import java.net.*;
import java.util.*;

/*
 * envoi question DNS / reception reponse et affichage hexa rapide ...
 */

public class DNSsimple
{
    
    public static void main(String[] args) 
    {
	byte[] message = {(byte) 0x08, (byte) 0xbb,  (byte) 0x01, (byte) 0x00,/* a) 12 octets d'entete : identifiant de requete parametres [RFC1035, 4.1.1]*/
			  (byte) 0x00, (byte) 0x01,  (byte) 0x00, (byte) 0x00, 
			  (byte) 0x00, (byte) 0x00,  (byte) 0x00, (byte) 0x00, 
			  (byte) 0x03, (byte) 0x77,  (byte) 0x77, (byte) 0x77,/* b) QUESTION [RFC1035, 4.1.2] */
			  (byte) 0x04, (byte) 0x6c,  (byte) 0x69, (byte) 0x66,  /* b.1) QNAME : "3www4lifl2fr0" [RFC1035, 3.1]*/
			  (byte) 0x6c, (byte) 0x02,  (byte) 0x66, (byte) 0x72,
			  (byte) 0x00,                                        
			  (byte) 0x00, (byte) 0x01,                             /* b.2) QTYPE : A (a host address) [RFC1035, 3.2.3]*/
			  (byte) 0x00, (byte) 0x01 };                           /* b.3) QCLASS : IN (the Internet) [RFC1035, 3.2.4]*/
		
	
	/* 1) Get DNS server address ... by DNS ... (??!)  */
	System.err.print(" get inetaddress by name ... (on peut bien entendu mieux faire) ");
	InetAddress destination;
	try {
	    destination = InetAddress.getByName("193.49.225.15"/* ou 8.8.8.8 ou celui dans /etc/resolv.conf ... */);
	} catch (Exception e) {
	    System.err.println("[error] :" +  e.getMessage());
	    return;
	}
	System.err.println("[ok]");
	
	/* 2) creation d'un DatagramPacket pour l'envoi de la question DNS */
	System.err.println(" preparing  datagrampacket, message size : "+message.length  );
	DatagramPacket dp = new DatagramPacket(message,message.length,destination,53);
	
	/* 3) creation d'un DatragramSocket (port au choix ) */
	System.err.print(" create datagram socket  ... ");
	DatagramSocket ds ;
	try {
	    ds = new DatagramSocket() ;
	} catch (Exception e) {
	    System.err.println("[error] :" +  e.getMessage());
	    return;
	}
	System.err.println("[ok]");
	
	/* 4) et envoi du packet */
	System.err.print(" send datagram ... ");
	try {
	    ds.send(dp);
	} catch (Exception e) {
	    System.err.println("[error] :" +  e.getMessage());
	    return;
	}
	System.err.println("[ok]");

	/* 5) reception du packet */
	dp = new DatagramPacket(new byte[512],512);
	System.err.print(" receive datagram ... ");
	try {
	    ds.receive(dp);
	} catch (Exception e) {
	    System.err.println("[error] :" +  e.getMessage());
	    return;
	}
	System.err.println("[ok]");
	
	/* affichage complet du packet recu (pas tres lisible ...) */
	byte[] rec = dp.getData();
	System.out.println("- message length : " + dp.getLength());
       	System.out.println("- message : \n" + new String(rec, 0, dp.getLength()));
	
	/* affichage des bytes */
	for(int i = 0; i < dp.getLength(); i++) {
	    System.out.print(","+Integer.toHexString((rec[i])&0xff));
	    if ((i+1)%16 == 0)
		System.out.println("");
	}
	System.out.println("");
    }
class Tp{
	private String label;
	private String[] arg;
    public void createRequestDNS(InetAddress dns) throws Exception{
    	DatagramPacket dp = new DatagramPacket(message,message.length,destination,53);
    	//dns = InetAddress.getByName(label);

	    DatagramSocket socket;
		DatagramPacket packetS;
		DatagramPacket packetR = new DatagramPacket(new byte[512], 512);
		int port = 53;
		byte[] msgS = dns.getAddress();/*doit retourner un tableu de byte*/
		packetS = new DatagramPacket(msgS, msgS.length, dst, port);
		socket = new DatagramSocket();
		socket.send(packetS);
		socket.receive(packetR);
		byte[] msgR = packetR.getData();
		for(int i = 0; i < packetR.getLength(); i++)
    }

    public Tp(String label , String[] arg){
    	/*initialisation*/
    }



    /**
    *@param label : to initialize label 
    * this is a usage function when user don't specifie things
    *with default value or with de argument value
    */
    public void initialize(arg[] , String label){
    	if(arg.length>=1)
    		label = arg[0];/*on recupere l argument*/
    	else
    		label = "www.lifl.com" ; /*on initialise le site */
    }
    // i.e. http://www.facebook.com -> 123.456.789.10
  public static String getIp( String hostname ) throws IOException {
	}
}
    


