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
public class Zahtev {
    
    Admin korisnik;
    Operacija operacija;

    public Zahtev() {
    }

    public Zahtev(Admin korisnik, Operacija operacija) {
        this.korisnik = korisnik;
        this.operacija = operacija;
    }

    public Admin getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Admin korisnik) {
        this.korisnik = korisnik;
    }

    public Operacija getOperacija() {
        return operacija;
    }

    public void setOperacija(Operacija operacija) {
        this.operacija = operacija;
    }
    
    

}
