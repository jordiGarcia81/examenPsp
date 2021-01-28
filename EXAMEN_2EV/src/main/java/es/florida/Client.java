package es.florida;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static final int PORT_HTTP = 9876;

    public static void  main(String[]args) throws IOException {

        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1",PORT_HTTP));
        DataInputStream dataInput =  new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutput = new DataOutputStream(socket.getOutputStream());


        dataOutput.writeUTF("acciones");
        String respuesta="";
        respuesta = dataInput.readUTF();
        System.out.println(" El comando recibido del dron es : " + respuesta);



        dataInput.close();
        dataOutput.close();
        socket.close();

    }
}
