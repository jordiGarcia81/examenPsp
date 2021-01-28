package es.florida;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class App {
    private static final int PORT = 9876;


    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket clientConection;
        clientConection = serverSocket.accept();

        DataInputStream dataInput =  new DataInputStream(clientConection.getInputStream());
        DataOutputStream dataOutput = new DataOutputStream(clientConection.getOutputStream());

        System.out.println("Client connected on port" + clientConection.getPort());

        String accion = "";

        try {
            accion = dataInput.readUTF();

            System.out.println("accion: "+accion);
            if (accion.equals("acciones")) {
                System.out.println("1.takeOff");
                System.out.println("2.land");
                System.out.println("3.firePrimaryCannon");
                System.out.println("4.fireSecondaryWeapon");
                System.out.println("5.shutDown");
                dataOutput.writeUTF("1.takeOff 2.land 3.firePrimaryCannon 4.Bloquear Servidor 5.fireSecondaryWeapon 6.shutDown");



            }
            if (accion.equals("takeOff")) {
                DronController dronController = new DronController();
                Thread dronControllerThread = new Thread((Runnable) dronController);
                dronControllerThread.start();
                dataOutput.writeUTF("1.takeOff");

            }if (accion.equalsIgnoreCase("land")) {
                DronController dronController = new DronController();
                Thread dronControllerThread = new Thread((Runnable) dronController);
                dronControllerThread.start();
                dataOutput.writeUTF("2.land");

            }if (accion.equalsIgnoreCase("firePrimaryCannon")) {
                DronController dronController = new DronController();
                Thread dronControllerThread = new Thread((Runnable) dronController);
                dronControllerThread.start();
                dataOutput.writeUTF("3.firePrimaryCannon");


            }if (accion.equalsIgnoreCase("fireSecondaryWeapon")) {
                DronController dronController = new DronController();
                Thread dronControllerThread = new Thread((Runnable) dronController);
                dronControllerThread.start();
                dataOutput.writeUTF("4.fireSecondaryWeapon");

            }if (accion.equalsIgnoreCase("shutDown")) {
                DronController dronController = new DronController();
                Thread dronControllerThread = new Thread((Runnable) dronController);
                dronControllerThread.start();
                System.out.println("5.shutDown");

            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }
}
