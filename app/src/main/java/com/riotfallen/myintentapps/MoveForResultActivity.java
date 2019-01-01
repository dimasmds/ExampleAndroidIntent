package com.riotfallen.myintentapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MoveForResultActivity extends AppCompatActivity implements View.OnClickListener {

    public static String EXTRA_SELECTED_VALUE = "extraSelectedValue";
    public static int RESULT_CODE = 100;

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_for_result);

        Button buttonSubmit = findViewById(R.id.resultActivityButtonSubmit);
        radioGroup = findViewById(R.id.resultActivityRadioGroup);

        buttonSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.resultActivityButtonSubmit:
                if(radioGroup.getCheckedRadioButtonId() != 0){
                    int value = 0;
                    switch (radioGroup.getCheckedRadioButtonId()){
                        case R.id.resultActivityRadioButton50:
                            value = 50;
                            break;
                        case R.id.resultActivityRadioButton100:
                            value = 100;
                            break;
                        case R.id.resultActivityRadioButton150:
                            value = 150;
                            break;
                        case R.id.resultActivityRadioButton200:
                            value = 200;
                            break;
                    }

                    Intent resultIntet = new Intent();
                    resultIntet.putExtra(EXTRA_SELECTED_VALUE, value);
                    setResult(RESULT_CODE, resultIntet);
                    finish();
                }
        }
    }
}
