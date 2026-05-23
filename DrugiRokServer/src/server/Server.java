/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JLabel;

/**
 *
 * @author Aleksandar Čeganjac
 */
public class Server {

    private boolean signal = false;
    private ServerSocket ss;
    private static Server instance;

    public static Server getInstance() {
        if (instance == null) {
            instance = new Server();
        }
        return instance;
    }

    public void pokreniServer(JLabel lblStatus) throws IOException {

        ss = new ServerSocket(9000);
        System.out.println("Server je pokrenut ...");
        lblStatus.setText("POKRENUT");

        while (signal) {

            Socket ks = ss.accept();
            System.out.println("Klijent se povezao ...");
            KlijentskaNit nit = new KlijentskaNit(ks);
            nit.start();

        }

    }

    public void zaustaviServer(JLabel lblStatus) throws IOException {

        signal = false;
        ss.close();
        System.out.println("Server je zaustavljen ...");
        lblStatus.setText("ZAUSTAVLJEN");

    }

}
