package es.florida;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int SERVER_PORT =  6789;

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        Socket clientConection;
        clientConection = serverSocket.accept();
        DataInputStream dataInput =  new DataInputStream(clientConection.getInputStream());
        DataOutputStream dataOutput = new DataOutputStream(clientConection.getOutputStream());

        System.out.println("Client connected on port:  " + clientConection.getPort());

        String comando="ENEMY_SPOTTED";

        try{
            DronController dronController = new DronController();
            Thread dronControllerThread = new Thread((Runnable) dronController);
            dronControllerThread.start();
            comando= dataInput.readUTF();
            System.out.println(comando);



        }catch (IOException ex){
            System.out.println(ex);
        }

    }
}
