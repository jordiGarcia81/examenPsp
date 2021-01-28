package es.florida;

import java.net.Socket;

public class DronController {

    public Socket connect() {
        // FIXME please implement solution or remove this method
        return new Socket();
    }

    public void takeOff() {
        System.out.println("Taking off...");
    }

    public void land() {
        System.out.println("Landing");
    }

    public void firePrimaryCannon() {
        System.out.println("Ratatatatatatata!");
    }

    public void fireSecondaryWeapon() {
        System.out.println("Piñau! Piñau!");
    }

    public void shutDown() {
        System.out.println("Shutting down system...");
    }

}
