package se.lexicon.io;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

public class IOManager {

    public void copy(File source, File destination) {

        try(InputStream in = new FileInputStream(source);
        OutputStream out = new FileOutputStream(destination)){

            int b;
            while((b = in.read()) != -1){
                out.write(b);
            }

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void bufferCopy(File source, File destination){
        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destination))){

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) > 0){
                out.write(buffer, 0, bytesRead);
                out.flush();
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }





}
