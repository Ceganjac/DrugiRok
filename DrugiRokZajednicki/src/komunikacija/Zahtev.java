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
public class Zahtev implements Serializable{
    
    Korisnik korisnik;
    Operacija operacija;

    public Zahtev() {
    }

    public Zahtev(Korisnik korisnik, Operacija operacija) {
        this.korisnik = korisnik;
        this.operacija = operacija;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Operacija getOperacija() {
        return operacija;
    }

    public void setOperacija(Operacija operacija) {
        this.operacija = operacija;
    }

   
    
    

}
