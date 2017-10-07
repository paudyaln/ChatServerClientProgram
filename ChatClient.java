/**
 * Nischal Paudyal
 * ChatClient.java
 * Oct 06, 2017
 * Session ends with "end" message
 */

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws IOException{
        //connect to local server at given port number
        Socket clientsocket = new Socket("", 6789);
        //input and output stream
        InputStream sin = clientsocket.getInputStream();
        DataInputStream din = new DataInputStream(sin);
        DataOutputStream dout = new DataOutputStream(clientsocket.getOutputStream());

        //session end with end message
        while(true){
            String msgin = din.readUTF();
            System.out.println(msgin);
            if(msgin.equals("end")){
                break;
            }
            System.out.print("Client: ");

            Scanner read = new Scanner(System.in);
            String msgout = read.nextLine();
            dout.writeUTF(msgout);
            if(msgout.equals("end")){
		System.out.println("The Session Ended");
                break;
            }


        }
        //close connection
        dout.close();
        din.close();
        clientsocket.close();
    }
}
