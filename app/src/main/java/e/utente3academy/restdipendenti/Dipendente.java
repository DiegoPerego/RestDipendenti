package e.utente3academy.restdipendenti;

import java.io.Serializable;

/**
 * Created by utente3.academy on 28-Nov-17.
 */

public class Dipendente implements Serializable{

    private int matricola;
    private String nome;
    private String cognome;

    public Dipendente(int matricola, String nome, String cognome) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
    }

    public Dipendente() {
        this.matricola = 0;
        this.nome = null;
        this.cognome = null;
    }


    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
}
