/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import domen.Admin;
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

    public Admin prijava(Admin korisnik) {

        Zahtev zahtev = new Zahtev();
        zahtev.setKorisnik(korisnik);
        zahtev.setOperacija(Operacija.PRIJAVA);
        Admin korisnikRez = null;

        try {
            // slanje zahteva
            izlazni.writeObject(zahtev);
            izlazni.flush();

            // primanje odgovora
            korisnikRez = (Admin) ulazni.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();

        }

        return korisnikRez;

    }

}
