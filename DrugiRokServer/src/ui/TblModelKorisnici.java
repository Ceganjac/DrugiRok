/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import domen.Korisnik;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aleksandar Čeganjac
 */
public class TblModelKorisnici extends AbstractTableModel {

    private final List<Korisnik> korisnici;
    private final String[] columnNames = {"Id korisnika", "Korisničko ime", "Lozinka",
        "Datum rođenja", "Pol","Ulogovan"};

    public TblModelKorisnici(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return korisnici.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Korisnik korisnik = korisnici.get(rowIndex);
        switch(columnIndex){
        
            case 0: return korisnik.getIdKorisnika();
            case 1: return korisnik.getKorisnickoIme();
            case 2: return korisnik.getLozinka();
            case 3: return korisnik.getDatumRodjenja();
            case 4: return korisnik.getPol();
            case 5: return korisnik.isUlogovan();
        
        }
        
        return null;
    }

}
