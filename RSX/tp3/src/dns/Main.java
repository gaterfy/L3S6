import java.io.*;
import java.net.*;
import java.util.*;

public class Main
{

    public static void main(String[] args)
    {
      InetAddress inet ;
      String label = null; /*initialiser dans tpDNS*/
      TpDns tp = new TpDns(label , args ,null);
      try{
      System.out.println(  tp.getIp("www.google.com"));}
      catch(Exception e){System.out.println("test4");}
      System.out.println("test");

    }
}
