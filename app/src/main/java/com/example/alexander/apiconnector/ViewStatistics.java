package com.example.alexander.apiconnector;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Alexander on 30.10.2014.
 */
public class ViewStatistics extends RelativeLayout{

    public ViewStatistics(Context context) {
        super(context);
        init(null);
    }

    public ViewStatistics(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ViewStatistics(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs){
        inflate(getContext(), R.layout.custom_view_stats_info,this);

        TextView leftNickname = (TextView) findViewById(R.id.view_left_linear_nickname);
        TextView leftRegistered = (TextView) findViewById(R.id.view_left_linear_registered);
        TextView leftBattles = (TextView) findViewById(R.id.view_left_linear_battles);
        TextView leftRating = (TextView) findViewById(R.id.view_left_linear_rating);
        TextView leftPercentWinRating = (TextView) findViewById(R.id.view_left_linear_percent_win_rating);
        TextView leftPercentHitsDeal = (TextView) findViewById(R.id.view_left_linear_percent_hits_deal);
        TextView leftDamageFactor = (TextView) findViewById(R.id.view_left_linear_damage_factor);
        TextView leftAverageDamage = (TextView) findViewById(R.id.view_left_linear_avg_damage);
        TextView leftPercentSurvived = (TextView) findViewById(R.id.view_left_linear_percent_survived);
        TextView leftFragsFactor = (TextView) findViewById(R.id.view_left_linear_frags_factor);
        TextView leftMaxExperience = (TextView) findViewById(R.id.view_left_linear_max_exp);
        TextView leftAverageExperience = (TextView) findViewById(R.id.view_left_linear_avg_exp);
        TextView leftMaxDamage = (TextView) findViewById(R.id.view_left_linear_max_damage);

        TextView rightNickname = (TextView) findViewById(R.id.view_right_linear_nickname);
        TextView rightRegistered = (TextView) findViewById(R.id.view_right_linear_registered);
        TextView rightBattles = (TextView) findViewById(R.id.view_right_linear_battles);
        TextView rightRating = (TextView) findViewById(R.id.view_right_linear_rating);
        TextView rightPercentWinRating = (TextView) findViewById(R.id.view_right_linear_percent_win_rating);
        TextView rightPercentHitsDeal = (TextView) findViewById(R.id.view_right_linear_percent_hits_deal);
        TextView rightDamageFactor = (TextView) findViewById(R.id.view_right_linear_damage_factor);
        TextView rightAverageDamage = (TextView) findViewById(R.id.view_right_linear_avg_damage);
        TextView rightPercentSurvived = (TextView) findViewById(R.id.view_right_linear_percent_survived);
        TextView rightFragsFactor = (TextView) findViewById(R.id.view_right_linear_frags_factor);
        TextView rightMaxExperience = (TextView) findViewById(R.id.view_right_linear_max_exp);
        TextView rightAverageExperience = (TextView) findViewById(R.id.view_right_linear_avg_exp);
        TextView rightMaxDamage = (TextView) findViewById(R.id.view_right_linear_max_damage);

        if (attrs != null){
            TypedArray a=getContext().getTheme().obtainStyledAttributes(attrs,R.styleable.view_attrs,0,0);
            try{
                String resLeftNickname=a.getString(R.styleable.view_attrs_left_attr_nickname);
                String resLeftRegistered=a.getString(R.styleable.view_attrs_left_attr_registered);
                String resLeftBattles=a.getString(R.styleable.view_attrs_left_attr_battles);
                String resLeftRating=a.getString(R.styleable.view_attrs_left_attr_rating);
                String resLeftPercentWinRating=a.getString(R.styleable.view_attrs_left_attr_percent_win_rating);
                String resLeftPercentHitsDeal=a.getString(R.styleable.view_attrs_left_attr_percent_hits_deal);
                String resLeftDamageFactor=a.getString(R.styleable.view_attrs_left_attr_damage_factor);
                String resLeftAverageDamage=a.getString(R.styleable.view_attrs_left_attr_avg_damage);
                String resLeftPercentSurvived=a.getString(R.styleable.view_attrs_left_attr_percent_survived);
                String resLeftFragsFactor=a.getString(R.styleable.view_attrs_left_attr_frags_factor);
                String resLeftMaxExperience=a.getString(R.styleable.view_attrs_left_attr_max_exp);
                String resLeftAverageExperience=a.getString(R.styleable.view_attrs_left_attr_avg_exp);
                String resLeftMaxDamage=a.getString(R.styleable.view_attrs_left_attr_max_dmg);

                String resRightNickname=a.getString(R.styleable.view_attrs_right_attr_nickname);
                String resRightRegistered=a.getString(R.styleable.view_attrs_right_attr_registered);
                String resRightBattles=a.getString(R.styleable.view_attrs_right_attr_battles);
                String resRightRating=a.getString(R.styleable.view_attrs_right_attr_rating);
                String resRightPercentWinRating=a.getString(R.styleable.view_attrs_right_attr_percent_win_rating);
                String resRightPercentHitsDeal=a.getString(R.styleable.view_attrs_right_attr_percent_hits_deal);
                String resRightDamageFactor=a.getString(R.styleable.view_attrs_right_attr_damage_factor);
                String resRightAverageDamage=a.getString(R.styleable.view_attrs_right_attr_avg_damage);
                String resRightPercentSurvived=a.getString(R.styleable.view_attrs_right_attr_percent_survived);
                String resRightFragsFactor=a.getString(R.styleable.view_attrs_right_attr_frags_factor);
                String resRightMaxExperience=a.getString(R.styleable.view_attrs_right_attr_max_exp);
                String resRightAverageExperience=a.getString(R.styleable.view_attrs_right_attr_avg_exp);
                String resRightMaxDamage=a.getString(R.styleable.view_attrs_right_attr_max_dmg);

                leftNickname.setText(resLeftNickname);
                leftRegistered.setText(resLeftRegistered);
                leftBattles.setText(resLeftBattles);
                leftRating.setText(resLeftRating);
                leftPercentWinRating.setText(resLeftPercentWinRating);
                leftPercentHitsDeal.setText(resLeftPercentHitsDeal);
                leftDamageFactor.setText(resLeftDamageFactor);
                leftAverageDamage.setText(resLeftAverageDamage);
                leftPercentSurvived.setText(resLeftPercentSurvived);
                leftFragsFactor.setText(resLeftFragsFactor);
                leftMaxExperience.setText(resLeftMaxExperience);
                leftAverageExperience.setText(resLeftAverageExperience);
                leftMaxDamage.setText(resLeftMaxDamage);

                rightNickname.setText(resRightNickname);
                rightRegistered.setText(resRightRegistered);
                rightBattles.setText(resRightBattles);
                rightRating.setText(resRightRating);
                rightPercentWinRating.setText(resRightPercentWinRating);
                rightPercentHitsDeal.setText(resRightPercentHitsDeal);
                rightDamageFactor.setText(resRightDamageFactor);
                rightAverageDamage.setText(resRightAverageDamage);
                rightPercentSurvived.setText(resRightPercentSurvived);
                rightFragsFactor.setText(resRightFragsFactor);
                rightMaxExperience.setText(resRightMaxExperience);
                rightAverageExperience.setText(resRightAverageExperience);
                rightMaxDamage.setText(resRightMaxDamage);
            } finally {
                a.recycle();
            }
        }

    }

}
