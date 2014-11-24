package com.example.alexander.apiconnector;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.alexander.apiconnector.Objects.Player;

/**
 * Created by Alexander on 20.11.2014.
 */
public class ViewSmall extends LinearLayout {

    public ViewSmall(Context context) {
        super(context);
        init(null);
    }

    public ViewSmall(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ViewSmall(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public void populate(String fieldName, String fieldValue) {
//        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.custom_view_stats_upper);
//        relativeLayout.setVisibility(View.VISIBLE);
        ((TextView)findViewById(R.id.custom_view_small_key)).setText(fieldName);
        ((TextView)findViewById(R.id.custom_view_small_value)).setText(fieldValue);
    }

    private void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.custom_view_small, this);

        TextView key = (TextView) findViewById(R.id.custom_view_small_key);
        TextView value = (TextView) findViewById(R.id.custom_view_small_value);

        if (attrs != null) {
            TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.custom_view_small_attrs, 0, 0);
            try {
                String resKey = a.getString(R.styleable.custom_view_small_attrs_attr_key);
                String resValue = a.getString(R.styleable.custom_view_small_attrs_attr_value);

                key.setText(resKey);
                value.setText(resValue);
            } finally {
                a.recycle();
            }
        }
    }
}
