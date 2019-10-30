/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdfh;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 *
 * @author 88119g
 */


public class ThreadSample {
    static Thread thread1 = new Thread(){

        public void run(){
            
            try{
            UdpReceiver udpr = new UdpReceiver();
            udpr.udprec();
            }catch (IOException e){
            
            }
            
        }
        
    };
    
    static Thread thread2 = new Thread(){
        
        public void run(){
         
            try{
            UdpSender udps = new UdpSender();
            udps.udpsen();
            }catch (IOException e){
            
            }
            
        }
        
        
    };
    
    public static void main(String[] args){
        thread1.start();
        thread2.start();
    }
}
