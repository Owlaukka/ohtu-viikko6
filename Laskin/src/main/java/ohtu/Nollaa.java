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
public class Nollaa implements Komento {
    
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinen;

    Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        this.edellinen = Integer.parseInt(this.tuloskentta.getText());
        sovellus.nollaa();
        this.tuloskentta.setText(Integer.toString(sovellus.tulos()));
        this.syotekentta.setText("");
    }

    @Override
    public void peru() {
        this.sovellus.nollaa();
        this.sovellus.plus(edellinen);
        this.tuloskentta.setText(Integer.toString(this.edellinen));
        this.syotekentta.setText("");
    }
    
}