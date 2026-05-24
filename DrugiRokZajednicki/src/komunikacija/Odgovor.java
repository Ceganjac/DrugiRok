/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package komunikacija;

import domen.Korisnik;
import java.io.Serializable;

/**
 *
 * @author Aleksandar Čeganjac
 */
public class Odgovor implements Serializable{
    
    Korisnik korisnik;
    Exception ex;    

    public Odgovor() {
    }

    public Odgovor(Korisnik korisnik, Exception ex) {
        this.korisnik = korisnik;
        this.ex = ex;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Exception getEx() {
        return ex;
    }

    public void setEx(Exception ex) {
        this.ex = ex;
    }

    

}
