package com.example.immortal.caloriescalculate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    Button submitBtn;
    EditText heigtET, weightET, yersET;
    RadioGroup sportRG, sexRG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heigtET = (EditText) findViewById(R.id.height_editText);
        weightET = (EditText) findViewById(R.id.weight_editText);
        yersET = (EditText) findViewById(R.id.years_editText);

        sportRG = (RadioGroup) findViewById(R.id.sport_radio_group);
        sexRG = (RadioGroup) findViewById(R.id.sex_radio_group);

        submitBtn = (Button) findViewById(R.id.submit_button);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculateActivity.class);
                intent.putExtra("height", Integer.parseInt(heigtET.getText().toString()));
                intent.putExtra("weight", Integer.parseInt(weightET.getText().toString()));
                intent.putExtra("years", Integer.parseInt(yersET.getText().toString()));

                double sportCoef;
                switch (sportRG.getCheckedRadioButtonId()) {
                    case R.id.radio_btn_min:
                        sportCoef = 1.2;
                        break;
                    case R.id.radio_btn_low:
                        sportCoef = 1.375;
                        break;
                    case R.id.radio_btn_middle:
                        sportCoef = 1.55;
                        break;
                    case R.id.radio_btn_hight:
                        sportCoef = 1.725;
                        break;
                    case R.id.radio_btn_very_hight:
                        sportCoef = 1.9;
                        break;
                    default:
                        sportCoef = 1.2;
                        break;
                }

                int sex;
                switch (sexRG.getCheckedRadioButtonId()) {
                    case R.id.male_radio_button:
                        sex = 0;
                        break;
                    case R.id.female_radio_button:
                        sex = 1;
                        break;
                    default:
                        sex = 0;
                        break;
                }

                intent.putExtra("sex", sex);

                intent.putExtra("sportICoef", sportCoef);
                startActivity(intent);
            }
        });
    }
}
