package com.example.alexander.apiconnector.Server;

import com.example.alexander.apiconnector.Objects.IdPlayer;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Alexander on 31.10.2014.
 */
public class Parser {

    private IdPlayer currentPlayer;
    public IdPlayer getCurrentPlayer(){return currentPlayer;}
    public void setCurrentPlayer(IdPlayer currentPlayer){this.currentPlayer=currentPlayer;}

    public void parseID(String in){
        try{
            JSONObject reader=new JSONObject(in);
            if (reader.getString("status")=="ok"){
                currentPlayer.setStatus(true);
                JSONArray data=reader.getJSONArray("data");
                JSONObject obj=data.getJSONObject(0);
                currentPlayer.setNickname(obj.getString("nickname"));
                currentPlayer.setAccountId(obj.getInt("account_id"));
            } else{
                currentPlayer.setStatus(false);
            }
        } catch (Exception e){
            //TODO
        }
    }

}
