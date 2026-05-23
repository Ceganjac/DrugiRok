/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package komunikacija;

import domen.Admin;

/**
 *
 * @author Aleksandar Čeganjac
 */
public class Odgovor {
    
    Admin korisnik;
    Exception ex;    

    public Odgovor() {
    }
    

    public Odgovor(Admin korisnik, Exception ex) {
        this.korisnik = korisnik;
        this.ex = ex;
    }

    public Admin getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Admin korisnik) {
        this.korisnik = korisnik;
    }

    public Exception getEx() {
        return ex;
    }

    public void setEx(Exception ex) {
        this.ex = ex;
    }
    
    
    

}
