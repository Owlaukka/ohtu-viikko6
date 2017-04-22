/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author ola
 */
public class Summa implements Komento {
    
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinen;

    Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.edellinen = 0;
    }

    @Override
    public void suorita() {
        this.edellinen = Integer.parseInt(syotekentta.getText());
        sovellus.plus(Integer.parseInt(syotekentta.getText()));
        this.tuloskentta.setText(Integer.toString(sovellus.tulos()));
        this.syotekentta.setText("");
    }

    @Override
    public void peru() {
        this.sovellus.miinus(this.edellinen);
        this.tuloskentta.setText(Integer.toString(this.sovellus.tulos()));
        this.syotekentta.setText("");
    }
    
}
