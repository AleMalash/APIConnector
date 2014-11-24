package com.example.alexander.apiconnector.Objects;

import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Alexander on 30.10.2014.
 */
public class Player {

    public String error="";
    private int id;
    private boolean exist;
    private String nickname;
    private String registered;
    private int battles;
    private int rating;
    private int percentWinRating;
    private int percentHitsDeal;
    private int damageFactor;
    private int averageDamage;
    private int percentSurvived;
    private int fragsFactor;
    private int maxExperience;
    private int averageExperience;
    private int maxDamage;
    public Player(){}

    public boolean isExist() {
        return exist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getExist(){return exist;}

    public void setExist(boolean exist){this.exist=exist;}

    public String getNickname(){return nickname;}

    public void setNickname(String nickname){this.nickname=nickname;}

    public String getRegistered(){return registered;}

    public void setRegistered(String registered){this.registered=registered;}

    public int getBattles(){return battles;}

    public void setBattles(int battles){this.battles=battles;}

    public int getRating(){return rating;}

    public void setRating(int rating){this.rating=rating;}

    public int getPercentWinRating(){return percentWinRating;}

    public void setPercentWinRating(int percentWinRating){this.percentWinRating=percentWinRating;}

    public int getPercentHitsDeal(){return percentHitsDeal;}

    public void setPercentHitsDeal(int percentHitsDeal){this.percentHitsDeal=percentHitsDeal;}

    public int getDamageFactor(){return damageFactor;}

    public void setDamageFactor(int damageFactor){this.damageFactor=damageFactor;}

    public int getAverageDamage(){return averageDamage;}

    public void setAverageDamage(int averageDamage){this.averageDamage=averageDamage;}

    public int getPercentSurvived(){return percentSurvived;}

    public void setPercentSurvived(int percentSurvived){this.percentSurvived=percentSurvived;}

    public int getFragsFactor(){return fragsFactor;}

    public void setFragsFactor(int fragsFactor){this.fragsFactor=fragsFactor;}

    public int getMaxExperience(){return maxExperience;}

    public void setMaxExperience(int maxExperience){this.maxExperience=maxExperience;}

    public int getAverageExperience(){return averageExperience;}

    public void setAverageExperience(int averageExperience){this.averageExperience=averageExperience;}

    public int getMaxDamage(){return maxDamage;}
    public void setMaxDamage(int maxDamage){this.maxDamage=maxDamage;}

    public void Parse(String in,IdPlayer player){
        try{

            JSONObject reader=new JSONObject(in);

            String status=reader.getString("status");
            if (status.equals("ok")){
                this.setExist(true);

                JSONObject data=reader.getJSONObject("data");
                JSONObject id=data.getJSONObject(Integer.toString(player.getAccountId()));

                this.setRegistered(id.getString("created_at"));
                this.setRating(id.getInt("global_rating"));
                this.setNickname(id.getString("nickname"));

                JSONObject statistics=id.getJSONObject("statistics");
                this.setMaxDamage(statistics.getInt("max_damage"));
                this.setMaxExperience(statistics.getInt("max_xp"));

                JSONObject all=statistics.getJSONObject("all");
                this.setBattles(all.getInt("battles"));
                this.setPercentHitsDeal(all.getInt("hits_percent"));
                this.setPercentWinRating(all.getInt("wins")/this.getBattles());
                this.setDamageFactor(all.getInt("hits")/all.getInt("shots"));
                this.setAverageDamage(all.getInt("damage_dealt")/this.getBattles());
                this.setPercentSurvived(all.getInt("survived_battles")/this.getBattles());
                this.setFragsFactor(all.getInt("frags")/this.getBattles());
                this.setAverageExperience(all.getInt("battle_avg_xp"));
            } else{
                this.setExist(false);
                this.error+=" Wrong request searching info";
            }
        } catch (Exception e){

        }
    }

}
