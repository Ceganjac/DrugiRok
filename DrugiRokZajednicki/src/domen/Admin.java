/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package domen;

/**
 *
 * @author Aleksandar Čeganjac
 */
public class Admin {
    
    int idKorisnika;
    String mejl;
    String lozinka;
    String ime;
    String prezime;

    public Admin() {
    }

    public Admin(int idKorisnika, String mejl, String lozinka, String ime, String prezime) {
        this.idKorisnika = idKorisnika;
        this.mejl = mejl;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
    }

    public int getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(int idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public String getMejl() {
        return mejl;
    }

    public void setMejl(String mejl) {
        this.mejl = mejl;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    
    

}
