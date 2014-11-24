package com.example.alexander.apiconnector;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import com.example.alexander.apiconnector.Objects.IdPlayer;
import com.example.alexander.apiconnector.Objects.Player;

import javax.net.ssl.HttpsURLConnection;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;


public class MainActivity extends Activity {

    public final Player PLAYER = new Player();
    public final IdPlayer IDPLAYER = new IdPlayer();
    Connection connectorForFirstRequest;
    SecondConnection connectorForSecondRequest;

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

    //WRITE METHOD POPULATE TODO

    public void ButtonClickSearch(View v) {
        EditText nickHere = (EditText) findViewById(R.id.main_activity_player_name);
        String nickname = nickHere.getText().toString();
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.main_activity_progress_bar);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            System.out.print("\n Connecting \n");
        } else {
            System.out.print("\n No connection \n"); //log
        }
        connectorForFirstRequest = new Connection();
        progressBar.setVisibility(View.VISIBLE);
        connectorForFirstRequest.execute(nickname);
    }


    public class Connection extends AsyncTask<String, Void, String> {

        public final static int READ_TIMEOUT = 10000;
        public final static int CONNECT_TIMEOUT = 15000;
        public final static String REQUEST_METHOD = "GET";
        public final static String APPLICATION_ID = "297d31a41c65a8a7c4c10bd5c5d4200d";
        String result;

        public Connection() {
            super();
        }

        @Override
        protected String doInBackground(String... nickname) {
            String str = "";
            try {
                StringBuilder s = new StringBuilder("https://api.worldoftanks.ru/wot/account/list/?application_id=297d31a41c65a8a7c4c10bd5c5d4200d&search=");
                s.append(nickname[0]);
                String urlRequest = s.toString();
                URL url = new URL(urlRequest);
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                connection.setConnectTimeout(CONNECT_TIMEOUT);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setDoInput(true);
                connection.connect();
                InputStream is = connection.getInputStream();

                Scanner scanner = new Scanner(is);


                str += scanner.nextLine();

                return str;
            } catch (java.io.IOException e) {
                e.printStackTrace();
            } finally {

            }

            return "No connection";
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String str) {
            result = str;
            IDPLAYER.Parse(str);
            PLAYER.setId(IDPLAYER.getAccountId());
            connectorForSecondRequest = new SecondConnection();
            connectorForSecondRequest.execute(PLAYER.getId());
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

        public final static int READ_TIMEOUT = 10000;
        public final static int CONNECT_TIMEOUT = 15000;
        public final static String REQUEST_METHOD = "GET";
        public final static String APPLICATION_ID = "297d31a41c65a8a7c4c10bd5c5d4200d";
        public final static String URL_REQUEST_INFO = "https://api.worldoftanks.ru/wot/account/info/?application_id=" + APPLICATION_ID + "&account_id=";
        String result;

        public SecondConnection() {
            super();
        }

        @Override
        protected String doInBackground(Integer... id) {
            StringBuilder s = new StringBuilder("https://api.worldoftanks.ru/wot/account/info/?application_id=297d31a41c65a8a7c4c10bd5c5d4200d&account_id=");
            s.append(id[0]);
            String urlRequest = s.toString();
            try {
                URL url = new URL(urlRequest);
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

            return "No connection";
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String str) {

            EditText nickHere = (EditText) findViewById(R.id.main_activity_player_name);
            ViewStatistics stat = (ViewStatistics) findViewById(R.id.main_activity_view_statistics);
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.main_activity_progress_bar);

            result = str;
            PLAYER.Parse(str, IDPLAYER);
            StringBuilder sb = new StringBuilder();
            sb.append(PLAYER.error);
            sb.append(IDPLAYER.error);
            String error = sb.toString();
            if (error.equals("")) {
                stat.setVisibility(View.VISIBLE);
                //populate должен быть и у viewSmall и у ViewStatistics
                stat.populate(PLAYER);//TODO visibility of ViewStatistics
                progressBar.setVisibility(View.INVISIBLE);
            } else {
                nickHere.setText(error);
            }
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
