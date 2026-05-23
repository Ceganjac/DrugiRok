/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domen.Admin;
import java.sql.*;

/**
 *
 * @author Aleksandar Čeganjac
 */
public class DbBroker {

    private Connection konekcija;
    private static DbBroker instanca;
    
    public static DbBroker vratiIstancu(){
        if (instanca == null) instanca = new DbBroker();
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
        Admin rez = new Admin();

        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.setString(1, admin.getMejl());
        ps.setString(2, admin.getLozinka());

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            rez.setIme(rs.getString("ime"));
            rez.setPrezime(rs.getString("prezime"));
            rez.setMejl(rs.getString("mejl"));

        }

        disconnect();
        return rez;
    }

}
