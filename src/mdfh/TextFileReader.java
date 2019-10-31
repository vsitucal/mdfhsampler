package mdfh;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 88119g
 */
import java.nio.channels.FileChannel;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.io.FileNotFoundException;
import java.util.*;


public class TextFileReader {
    
    public String path;
    
    public TextFileReader(String path){
        this.path = path;
    }
    
    public List<Character> readFileData()/*throws IOException,FileNotFoundException*/{
        
        List<Character> message = new ArrayList<>();
        try{    
            RandomAccessFile aFile = new RandomAccessFile(path,"r");
            FileChannel inChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            
            int bytesRead = inChannel.read((ByteBuffer) buf);
            while(bytesRead != -1){
                
                buf.flip();
                
                while(buf.hasRemaining()){
                    message.add((char)buf.get());
                }
                
                buf.clear();
                bytesRead = inChannel.read(buf);
                
            }

            aFile.close();
            
        }catch(FileNotFoundException e){
            System.out.println("No file");
        }catch(IOException e){
            System.out.println("IOexception");
        }
        return message;
    }
    
}
