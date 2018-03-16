import java.io.*;
import java.net.*;
import java.util.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TpDns{
	private String label;
	private String[] arg; /*les arguments depuis le main*/
  InetAddress dest ;

  /**
  *@param label
  *@param arg
  *@param dest
  */
  public TpDns(String label , String[] arg, InetAddress dest ){
    /*initialisation*/
    initialize(arg,label);
    this.label=label ;
    this.arg=arg;
    this.dest=dest;

  }


  public void createRequestDNS(String message) throws Exception{
    	
    	//dns = InetAddress.getByName(label);

	  DatagramSocket socket;
		DatagramPacket packetS;
		DatagramPacket packetR = new DatagramPacket(new byte[512], 512);
		int port = 53;
		byte[] msgS = new byte[512];/*doit retourner un tableu de byte en prenant label*/
		packetS = new DatagramPacket(msgS, msgS.length, dest, port);
		socket = new DatagramSocket();
		socket.send(packetS);
		socket.receive(packetR);

    }





    /**
    *@param label : to initialize label
    * this is a usage function when user don't specifie things
    *with default value or with de argument value
    */
    public void initialize(String arg[] , String label){
    	if(arg.length>=1)
    		label = arg[0];/*on recupere l argument*/
    	else
    		label = "www.lifl.com" ; /*on initialise le site */
    }

    // i.e. first version
  public static String getIp( String host ) throws IOException {
    String result = "";
      try {
         //Il s'agit d'un nom de domaine et non d'une adresse IPV4
         if(host.matches("[a-zA-Z\\.]+")){ /*expression reguliere*/
            result = InetAddress.getByName(host).getHostAddress();
         }
         //IP V4
         else{
            result = InetAddress.getByName(host).getHostName();
         }

      } catch (UnknownHostException e) {
         return "Erreur : impossible de trouver une correspondance pour l'entrée " + host;
      }
      return result;
   }
	}
