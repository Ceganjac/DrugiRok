/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import db.DbBroker;
import domen.Korisnik;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import komunikacija.Odgovor;
import komunikacija.Operacija;
import komunikacija.Zahtev;

/**
 *
 * @author Aleksandar Čeganjac
 */
public class KlijentskaNit extends Thread {

    private final Socket socket;
    private final ObjectInputStream ulazni;
    private final ObjectOutputStream izlazni;

    public KlijentskaNit(Socket socket) throws IOException {
        this.socket = socket;
        izlazni = new ObjectOutputStream(socket.getOutputStream());
        ulazni = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void run() {

        while (true) {

            // kreiranje odgovora
            Odgovor odgovor = new Odgovor();

            try {
                //čitanje zahteva
                Zahtev zahtev = (Zahtev) ulazni.readObject();
                Korisnik korisnik = zahtev.getKorisnik();
                Operacija op = zahtev.getOperacija();

                switch (op) {

                    case PRIJAVA:
                        Korisnik korisnikRez = DbBroker.vratiIstancu()
                                .prijavaKorisnik(korisnik);
                        odgovor.setKorisnik(korisnikRez);
                        System.out.println("Dolazi dovde");

                }

            } catch (IOException | ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
                odgovor.setEx(ex);
            }

            try {
                // pisanje zahteva na izlaz
                izlazni.writeObject(odgovor);
                izlazni.flush();
            } catch (IOException ex) {
                ex.printStackTrace();

            }

        }

    }

}
