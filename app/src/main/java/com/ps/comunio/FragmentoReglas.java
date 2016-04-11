package com.ps.comunio;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;

import cz.msebera.android.httpclient.Header;


public class FragmentoReglas extends Fragment {

    private Button sald;
    private View rootView;
    private int saldo;
    private String user;

    public FragmentoReglas() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_fragmento_reglas, container, false);
        user = getGlobalUsuario();
        obtSaldo();
        return rootView;
    }
    public String getGlobalUsuario(){
        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        return globalVariable.getUsuario();
    }

    public void obtSaldo(){
        AsyncHttpClient client =new AsyncHttpClient();
        String url="http://cumunio.esy.es/saldo.php";

        RequestParams parametros = new RequestParams();
        parametros.put("usuario",user);
        client.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    obtSaldoJson(new String(responseBody));
                    botonSaldo();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }
    public void obtSaldoJson(String response){
        saldo = 0;
        try{
            JSONArray jsonArray = new JSONArray(response);
            int longitudArray = jsonArray.length();
            for(int i=0;i<longitudArray;i++){
                saldo = jsonArray.getJSONObject(i).getInt("Saldo");
            }
        }catch (JSONException e){

        }

    }
    public void botonSaldo(){
        sald = (Button) rootView.findViewById(R.id.floating_button4);
        sald.setText(Integer.toString(saldo));
    }


}
