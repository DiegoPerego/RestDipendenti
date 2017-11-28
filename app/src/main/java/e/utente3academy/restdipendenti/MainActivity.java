package e.utente3academy.restdipendenti;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements TaskDelegate{

    private ListView lista;
    private List<Dipendente> dip;
    List<String> array;
    private ProgressDialog dialog;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TaskDelegate delegate = this;
        activeRestCall(delegate);

    }

    public void activeRestCall(final  TaskDelegate delegate){
        dialog = new ProgressDialog(MainActivity.this);
        dialog.setMessage("Loading utenti");
        dialog.show();

        dip = new ArrayList<>();
        lista = findViewById(R.id.listView);
        array = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);

        FirebaseRestClient.get("Dipendenti", null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode == 200){
                    String s = new String(responseBody);
                    Log.i("Tag", s);
                    dip = JsonParser.jsonParser(s);
                    toArray();
                    lista.setAdapter(adapter);
                    delegate.TaskCompleto("Caricamento completato");
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                delegate.TaskCompleto("Errore...Riprova");
            }
        });

    }

    public void toArray(){
        for(int i=0; i<dip.size(); i++){
            array.add("" + dip.get(i).getMatricola());
        }
    }

    @Override
    public void TaskCompleto(String s) {
        dialog.dismiss();
        dialog.cancel();
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }
}
