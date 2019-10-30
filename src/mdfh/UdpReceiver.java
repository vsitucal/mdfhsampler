/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdfh;

/**
 *
 * @author 88119g
 */

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class UdpReceiver {
   public void udprec() throws IOException {
      TextFileReader tfr = new TextFileReader("sample.txt");  
       
      //System.out.println(tfr.readFileData()); 
        
      DatagramChannel server = DatagramChannel.open();
      InetSocketAddress iAdd = new InetSocketAddress("localhost", 8989);
      server.bind(iAdd);
      System.out.println("Server Started: " + iAdd);
      ByteBuffer buffer = ByteBuffer.allocate(1024);
      //receive buffer from client.
      SocketAddress remoteAdd = server.receive(buffer);
      //change mode of buffer
      buffer.flip();
      int limits = buffer.limit();
      byte bytes[] = new byte[limits];
      buffer.get(bytes, 0, limits);
      String msg = new String(bytes);
      System.out.println("Client at " + remoteAdd + " sent:");
      System.out.println(msg);
      server.send(buffer,remoteAdd);
      remoteAdd = server.receive(buffer);
      server.close();
   }
}
    

