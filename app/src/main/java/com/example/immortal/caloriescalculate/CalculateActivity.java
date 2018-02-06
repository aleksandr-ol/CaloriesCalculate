package com.example.immortal.caloriescalculate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class CalculateActivity extends AppCompatActivity {
    int height, weight, years, sex;
    double sportCoef;

    TextView miff_san_georTV, garris_benTV;
    double miff_san_geor_calories, garris_ben_calories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        miff_san_georTV = (TextView) findViewById(R.id.miff_san_geor_text_view);
        garris_benTV = (TextView) findViewById(R.id.garris_ben_text_view);

        Intent intent = getIntent();

        height = intent.getIntExtra("height", 160);
        weight = intent.getIntExtra("weight", 60);
        years = intent.getIntExtra("years", 18);
        sex = intent.getIntExtra("sex", 0);

        sportCoef = intent.getDoubleExtra("sportCoef", 1.2);

        if (sex == 0){
            miff_san_geor_calories = (10 * weight + 6.25 * height - 5 * years + 5) * sportCoef;
            garris_ben_calories = (88.36 + 13.14 * weight + 4.8 * height - 5.7 * years) * sportCoef;
        }
        else {
            miff_san_geor_calories = (10 * weight + 6.25 * height - 5 * years - 161) * sportCoef;
            garris_ben_calories = (447.6 + 9.2 * weight + 3.1 * height - 4.3 * years) * sportCoef;
        }

        miff_san_georTV.setText(String.format(Locale.US, "%.02f", miff_san_geor_calories));
        garris_benTV.setText(String.format(Locale.US, "%.02f", garris_ben_calories));
    }
}
