/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domen.Admin;
import domen.Korisnik;
import domen.Pol;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aleksandar Čeganjac
 */
public class DbBroker {

    private Connection konekcija;
    private static DbBroker instanca;

    public static DbBroker vratiIstancu() {
        if (instanca == null) {
            instanca = new DbBroker();
        }
        return instanca;
    }

    private void connect() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/rok2";
        String username = "root";
        String password = "root";
        konekcija = DriverManager.getConnection(url, username, password);

    }

    public void disconnect() throws SQLException {
        konekcija.close();
    }

    public Admin prijavaAdmin(Admin admin) throws SQLException {

        connect();

        String upit = "SELECT * FROM admin "
                + "WHERE mejl = ? AND lozinka = ?";
        Admin rez = null;

        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.setString(1, admin.getMejl());
        ps.setString(2, admin.getLozinka());

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            rez = new Admin();
            rez.setIme(rs.getString("ime"));
            rez.setPrezime(rs.getString("prezime"));
            rez.setMejl(rs.getString("mejl"));
        }

        disconnect();
        return rez;
    }

    public void dodajKorisnika(Korisnik korisnik) throws SQLException {

        connect();

        String upit = "INSERT INTO korisnik(korisnicko_ime,lozinka,"
                + "datum_rodjenja,pol) VALUES (?,?,?,?)";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.setString(1, korisnik.getKorisnickoIme());
        ps.setString(2, korisnik.getLozinka());

        // datum rođenja
        Date datumSQL = Date.valueOf(korisnik.getDatumRodjenja());
        ps.setDate(3, datumSQL);

        // pol
        String polS = korisnik.getPol().name();
        ps.setString(4, polS);

        ps.executeUpdate();

    }

    public List<Korisnik> vratiSveKorisnike() throws SQLException {

        connect();
        String upit = "SELECT * FROM korisnik;";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ResultSet rs = ps.executeQuery();

        List<Korisnik> korisnici = new ArrayList();

        // čitanje podataka upita
        while (rs.next()) {

            Korisnik korisnik = new Korisnik();
            korisnik.setIdKorisnika(rs.getInt("id_korisnika"));
            korisnik.setKorisnickoIme(rs.getString("korisnicko_ime"));
            korisnik.setLozinka(rs.getString("lozinka"));

            // datumRodjenja
            Date datumSQL = rs.getDate("datum_rodjenja");
            LocalDate datumL = datumSQL.toLocalDate();
            korisnik.setDatumRodjenja(datumL);

            // pol
            String polS = rs.getString("pol");
            Pol pol = Pol.valueOf(polS);
            korisnik.setPol(pol);

            // ulogovan
            boolean ulogovan = rs.getBoolean("ulogovan");
            korisnik.setUlogovan(ulogovan);

            korisnici.add(korisnik);
        }

        disconnect();
        return korisnici;

    }

    public Korisnik prijavaKorisnik(Korisnik korisnik) throws SQLException {

        connect();

        String upit = "SELECT * FROM korisnik "
                + "WHERE korisnicko_ime = ? AND lozinka = ?";
        Korisnik rez = null;

        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.setString(1, korisnik.getKorisnickoIme());
        ps.setString(2, korisnik.getLozinka());

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            rez = new Korisnik();
            rez.setIdKorisnika(rs.getInt("id_korisnika"));
            rez.setKorisnickoIme(rs.getString("korisnicko_ime"));
            rez.setLozinka(rs.getString("lozinka"));

            // datum rodjenja
            Date datumSQL = rs.getDate("datum_rodjenja");
            LocalDate datumL = datumSQL.toLocalDate();
            rez.setDatumRodjenja(datumL);

            // pol
            String polS = rs.getString("pol");
            rez.setPol(Pol.valueOf(polS));

            // ulogovan
            rez.setUlogovan(rs.getBoolean("ulogovan"));

        }

        disconnect();
        return rez;
    }

}
