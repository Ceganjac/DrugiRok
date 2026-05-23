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
        "Datum rođenja", "Pol"};

    public TblModelKorisnici(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return 5;
    }

    @Override
    public int getColumnCount() {
        return korisnici.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Korisnik korisnik = korisnici.get(rowIndex);
        switch(columnIndex){
        
            
        
        }
        
        return null;
    }

}
