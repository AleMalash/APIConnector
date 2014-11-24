package com.example.alexander.apiconnector;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by Alexander on 20.11.2014.
 */
public class ViewStatistics extends ScrollView {

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
        inflate(getContext(),R.layout.custom_view_stats,this);

        com.example.alexander.apiconnector.ViewSmall nickname=(com.example.alexander.apiconnector.ViewSmall) findViewById(R.id.custom_view_stats_nickname);
        com.example.alexander.apiconnector.ViewSmall registered=(com.example.alexander.apiconnector.ViewSmall) findViewById(R.id.custom_view_stats_registered);
        com.example.alexander.apiconnector.ViewSmall battles=(com.example.alexander.apiconnector.ViewSmall) findViewById(R.id.custom_view_stats_battles);
        com.example.alexander.apiconnector.ViewSmall rating=(com.example.alexander.apiconnector.ViewSmall) findViewById(R.id.custom_view_stats_rating);
        com.example.alexander.apiconnector.ViewSmall percentWinRating=(com.example.alexander.apiconnector.ViewSmall) findViewById(R.id.custom_view_stats_percent_win_rating);
        com.example.alexander.apiconnector.ViewSmall percentHitsDeal=(com.example.alexander.apiconnector.ViewSmall) findViewById(R.id.custom_view_stats_percent_hits_deal);
        com.example.alexander.apiconnector.ViewSmall damageFactor=(com.example.alexander.apiconnector.ViewSmall) findViewById(R.id.custom_view_stats_damage_factor);
        com.example.alexander.apiconnector.ViewSmall averageDamage=(com.example.alexander.apiconnector.ViewSmall) findViewById(R.id.custom_view_stats_average_damage);
        com.example.alexander.apiconnector.ViewSmall percentSurvived=(com.example.alexander.apiconnector.ViewSmall) findViewById(R.id.custom_view_stats_percent_survived);
        com.example.alexander.apiconnector.ViewSmall fragsFactor=(com.example.alexander.apiconnector.ViewSmall) findViewById(R.id.custom_view_stats_frags_factor);
        com.example.alexander.apiconnector.ViewSmall maxExperience=(com.example.alexander.apiconnector.ViewSmall) findViewById(R.id.custom_view_stats_max_experience);
        com.example.alexander.apiconnector.ViewSmall averageExperience=(com.example.alexander.apiconnector.ViewSmall) findViewById(R.id.custom_view_stats_average_experience);
        com.example.alexander.apiconnector.ViewSmall maxDamage=(com.example.alexander.apiconnector.ViewSmall) findViewById(R.id.custom_view_stats_max_damage);

        if (attrs!=null){
            TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs,R.styleable.custom_view_stats_attrs,0,0);

            String resNicknameKey=a.getString(R.styleable.custom_view_stats_attrs_attr_nickname_key);
            String resNicknameValue=a.getString(R.styleable.custom_view_stats_attrs_attr_nickname_value);

            String resRegisteredKey=a.getString(R.styleable.custom_view_stats_attrs_attr_registered_key);
            String resRegisteredValue=a.getString(R.styleable.custom_view_stats_attrs_attr_registered_value);

            String resBattlesKey=a.getString(R.styleable.custom_view_stats_attrs_attr_battles_key);
            String resBattlesValue=a.getString(R.styleable.custom_view_stats_attrs_attr_battles_value);

            String resRatingKey=a.getString(R.styleable.custom_view_stats_attrs_attr_rating_key);
            String resRatingValue=a.getString(R.styleable.custom_view_stats_attrs_attr_rating_value);
        }
    }
}
