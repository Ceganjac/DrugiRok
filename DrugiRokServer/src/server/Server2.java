/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Aleksandar Čeganjac
 */
public class Server2 {

    private ServerSocket ss;
    private boolean signal = false;
    
    

    public void pokreniServer() throws IOException {

        ss = new ServerSocket(9000);
        System.out.println("Server je pokrenut !");
        while (signal) {
            Socket socket = ss.accept();
            System.out.println("Klijent je povezan !");
            
            KlijentskaNit nit = new KlijentskaNit(socket);
            nit.start();
        }

    }

    public void zaustaviServer() throws IOException {

        signal = false;
        ss.close();
    }

}
