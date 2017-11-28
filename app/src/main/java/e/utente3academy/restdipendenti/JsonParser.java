package e.utente3academy.restdipendenti;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by utente3.academy on 28-Nov-17.
 */

public class JsonParser {

    public static List<Dipendente> jsonParser(String json){
        List<Dipendente> lista = new ArrayList<>();

        JSONObject userCom = null;
        try {
            userCom = new JSONObject(json);
            Iterator iterator = userCom.keys();

            while (iterator.hasNext()){

                String getKey = (String) iterator.next();
                JSONObject dipCom = userCom.getJSONObject(getKey);
                Iterator iterat = dipCom.keys();
                Dipendente dip = new Dipendente();

                while(iterat.hasNext()){
                    String key = (String) iterat.next();
                    String s = dipCom.getString(key);

                    if(key.equals("matricola")){
                        dip.setMatricola(Integer.parseInt(s));
                    }
                    if(key.equals("cognome")){
                        dip.setCognome(s);
                    }
                    if(key.equals("nome")){
                        dip.setNome(s);
                    }
                }
                lista.add(dip);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;
    }

}
