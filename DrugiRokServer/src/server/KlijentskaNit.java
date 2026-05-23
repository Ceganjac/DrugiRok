/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Aleksandar Čeganjac
 */
public class KlijentskaNit extends Thread {

    Socket socket;

    public KlijentskaNit(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {
        
        try {
            ObjectOutputStream izlaznim = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ulazni = new ObjectInputStream(socket.getInputStream());
            
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        

    }

}
