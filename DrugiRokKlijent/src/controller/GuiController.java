/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import domen.Korisnik;
import java.net.Socket;
import komunikacija.Odgovor;
import komunikacija.Operacija;
import komunikacija.Zahtev;

/**
 *
 * @author Aleksandar Čeganjac
 */
public class GuiController {

    static private GuiController instanca;
    private Socket socket;
    private ObjectOutputStream izlazni;
    private ObjectInputStream ulazni;

    // singlton
    public static GuiController vratiInstancu() {
        if (instanca == null) {
            instanca = new GuiController();
        }
        return instanca;
    }

    public GuiController() {
        try {
            socket = new Socket("localhost", 9000);
            izlazni = new ObjectOutputStream(socket.getOutputStream());
            ulazni = new ObjectInputStream(socket.getInputStream());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Korisnik prijava(Korisnik korisnik) throws Exception {

        Zahtev zahtev = new Zahtev();
        zahtev.setKorisnik(korisnik);
        zahtev.setOperacija(Operacija.PRIJAVA);
        Korisnik korisnikRez = null;

        // slanje zahteva
        izlazni.writeObject(zahtev);
        izlazni.flush();

        // primanje i rastavljanje odgovora
        Odgovor odg = (Odgovor) ulazni.readObject();
        if (odg.getEx() == null) {
            korisnikRez = odg.getKorisnik();
            return korisnikRez;
        } else {
            throw odg.getEx();
        }

    }

}
