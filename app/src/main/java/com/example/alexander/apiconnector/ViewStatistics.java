package com.example.alexander.apiconnector;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.example.alexander.apiconnector.Objects.Player;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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

    private void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.custom_view_stats, this);
    }

    public void populate(Player player) {
        final String[] fieldNames = new String[]{"nickname", "registered", "battles", "rating", "percentWinRating",
                "percentHitsDeal", "damageFactor", "averageDamage", "percentSurvived", "fragsFactor",
                "maxExperience", "averageExperience", "maxDamage"};

        List<ViewSmall> fields = new ArrayList<ViewSmall>();
        for (String fieldName : fieldNames) {
            ViewSmall field = new ViewSmall(this.getContext());
            try {
                // value retrieve
                Field valueField = player.getClass().getDeclaredField(fieldName);
                String value;
                if (valueField.getType() == String.class) {
                    valueField.setAccessible(true);
                    value = (String) valueField.get(player);
                } else {
                    valueField.setAccessible(true);
                    value = Integer.toString(valueField.getInt(player));
                }
                // key retrieve
                Field keyField = R.string.class.getDeclaredField(fieldName);
//                keyField.setAccessible(true);
                String key = this.getResources().getString(keyField.getInt(null));
                //
                field.populate(key, value);
                fields.add(field);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.custom_view_stats_upper);
        linearLayout.setVisibility(VISIBLE);
        for (ViewSmall viewSmall : fields) {
            linearLayout.addView(viewSmall);
        }
    }
}
