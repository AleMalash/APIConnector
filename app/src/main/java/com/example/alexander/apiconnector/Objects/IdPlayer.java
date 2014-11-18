package com.example.alexander.apiconnector.Objects;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Alexander on 31.10.2014.
 */
public class IdPlayer {

    public String error="";

    private boolean status;
    public boolean getStatus(){return status;}
    public void setStatus(boolean status){this.status=status;}

    private String nickname;
    public String getNickname(){return nickname;}
    public void setNickname(String nickname){this.nickname=nickname;}

    private int accountId;
    public int getAccountId(){return accountId;}
    public void setAccountId(int accountId){this.accountId=accountId;}

    public void Parse(String in){ //todo
        try{
            JSONObject reader=new JSONObject(in);
            String currentStatus=reader.getString("status");
            if (currentStatus.equals("ok")){
                this.setStatus(true);
                JSONArray dataArray=reader.getJSONArray("data");
                JSONObject data=dataArray.getJSONObject(0);
                this.setNickname(data.getString("nickname"));
                this.setAccountId(data.getInt("account_id"));
            } else{
                this.setStatus(false);
                this.error+=" Wrong request searching id";
            }
        } catch (Exception e){

        }
    }
}
