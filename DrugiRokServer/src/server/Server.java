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
public class Server {

    private boolean signal;

    public void pokreniServer() throws IOException {

        ServerSocket ss = new ServerSocket(9000);
        System.out.println("Server je pokrenut ...");

        while (true) {

            Socket ks = ss.accept();
            System.out.println("Klijent se povezao ...");
            KlijentskaNit nit = new KlijentskaNit(ks);
            nit.start();

        }

    }

    public void zaustaviServer() {
        
        
    }

}
