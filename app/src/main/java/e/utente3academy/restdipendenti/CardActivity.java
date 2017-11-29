package e.utente3academy.restdipendenti;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CardActivity extends AppCompatActivity {

    private TextView matricola;
    private TextView cognome;
    private TextView nome;
    private String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        Intent intent = getIntent();
        s = intent.getStringExtra("Card");
        matricola = findViewById(R.id.tValM);
        cognome = findViewById(R.id.tValC);
        nome = findViewById(R.id.tValN);

        int id = Integer.parseInt(s);

        Object obj = InternalStorage.readObject(getApplicationContext(),"Dip");
        List<Dipendente> dip = (List<Dipendente>) obj;

        for (int i = 0; i<dip.size(); i++){
            if (dip.get(i).getMatricola() == id){
                matricola.setText(""+dip.get(i).getMatricola());
                cognome.setText(dip.get(i).getCognome());
                nome.setText(dip.get(i).getNome());
            }
        }

    }
}
