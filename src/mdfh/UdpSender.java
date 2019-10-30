package mdfh;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class UdpSender {
    
    static String out="";
    
    public void udpsen() throws IOException {
      TextFileReader tfr = new TextFileReader("sample.txt");  
      
      
      DatagramChannel client = null;
      client = DatagramChannel.open();

      client.bind(null);
      
      for(char a:tfr.readFileData()){
        out += a;
      }

      String msg =  out;
      //System.out.println(out);
      ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
      InetSocketAddress serverAddress = new InetSocketAddress("localhost",8989);

      client.send(buffer, serverAddress);
      buffer.clear();
      client.receive(buffer);
      buffer.flip();
    
      //client.close();
   }
}