package com.example.alexander.apiconnector;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alexander.apiconnector.Objects.IdPlayer;
import com.example.alexander.apiconnector.Objects.Player;

import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;


public class MainActivity extends Activity {

    public final Player PLAYER = new Player();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    Connection connector;
    SecondConnection connectorForSecondRequest;

    public void ButtonClickSearch(View v){
        EditText nickHere = (EditText) findViewById(R.id.main_activity_player_name);
        String nickname=nickHere.getText().toString();

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info != null && info.isConnected()){
            System.out.print("\n Connecting \n");
        }
        else {
            System.out.print("\n Is not connecting \n");
        }
        connector = new Connection();
        connector.execute(nickname);
        //String a=connector.result;
        //IdPlayer player = new IdPlayer();
        //player.Parse(a);
        //PLAYER.setId(player.getAccountId());
        connectorForSecondRequest = new SecondConnection();
        connectorForSecondRequest.execute(PLAYER.getId());
        //String b=connectorForSecondRequest.result;
        //PLAYER.Parse(b,player);
    }


    public class Connection extends AsyncTask<String, Void, String> {

        String result;

        public final static int READ_TIMEOUT = 10000;
        public final static int CONNECT_TIMEOUT = 15000;

        public final static String REQUEST_METHOD = "GET";

        public final static String APPLICATION_ID = "297d31a41c65a8a7c4c10bd5c5d4200d";
        public final static String URL_REQUEST_LIST = "https://api.worldoftanks.ru/wot/account/list/?application_id=" + APPLICATION_ID + "&rearch=";

        public Connection() {
            super();
        }

        @Override
        protected String doInBackground(String... nickname) {


            try {
                URL url = new URL("https://api.worldoftanks.ru/wot/account/list/?application_id=297d31a41c65a8a7c4c10bd5c5d4200d&search=Ale_Malash");
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                connection.setConnectTimeout(CONNECT_TIMEOUT);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setDoInput(true);
                connection.connect();
                InputStream is = connection.getInputStream();

                Scanner scanner = new Scanner(is);
                String str = "";

                str += scanner.nextLine();

                return str;
            } catch (java.io.IOException e) {
                e.printStackTrace();
            } finally {

            }

            return "Not working";
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String str) {
            result=str;
            IdPlayer player = new IdPlayer();
            player.Parse(str);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(String str) {
            super.onCancelled(str);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }


    }

    public class SecondConnection extends AsyncTask<Integer, Void, String> {

        String result;

        public final static int READ_TIMEOUT = 10000;
        public final static int CONNECT_TIMEOUT = 15000;

        public final static String REQUEST_METHOD = "GET";

        public final static String APPLICATION_ID = "297d31a41c65a8a7c4c10bd5c5d4200d";
        public final static String URL_REQUEST_INFO = "https://api.worldoftanks.ru/wot/account/info/?application_id=" + APPLICATION_ID + "&account_id=";

        public SecondConnection() {
            super();
        }

        @Override
        protected String doInBackground(Integer... id) {


            try {
                URL url = new URL(URL_REQUEST_INFO + id);
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                connection.setConnectTimeout(CONNECT_TIMEOUT);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setDoInput(true);
                connection.connect();
                InputStream is = connection.getInputStream();

                Scanner scanner = new Scanner(is);
                String str = "";

                str += scanner.nextLine();

                return str;
            } catch (java.io.IOException e) {
                e.printStackTrace();
            } finally {

            }

            return "Not working";
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String str) {
            result=str;

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(String str) {
            super.onCancelled(str);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }


    }

}
