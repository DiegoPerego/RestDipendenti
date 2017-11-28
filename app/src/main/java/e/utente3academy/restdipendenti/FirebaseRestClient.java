package e.utente3academy.restdipendenti;

import com.loopj.android.http.*;

/**
 * Created by utente3.academy on 28-Nov-17.
 */

public class FirebaseRestClient {

    private static final String baseUrl = "https://hello-6d8d0.firebaseio.com/Azienda/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler asyncHttpResponseHandler){
        client.get(getTotalUrl(url), params, asyncHttpResponseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler asyncHttpResponseHandler){
        client.get(getTotalUrl(url), params, asyncHttpResponseHandler);
    }

    private static String getTotalUrl(String relativeUrl){
        return baseUrl + relativeUrl + ".json";
    }
}
