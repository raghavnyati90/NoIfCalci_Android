package com.example.noifcalculator.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.noifcalculator.R;
import com.example.noifcalculator.util.Util;

public class MainActivity extends Activity{

    private StringBuilder mInputText;
    private ButtonClickListener mClickListener;
    private TextView textView;
    private Button mBtnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        mInputText = new StringBuilder();
        textView = (TextView) findViewById(R.id.txt_input);
        mClickListener = new ButtonClickListener();
        mBtnEnter = (Button) findViewById(R.id.btn_enter);

        int listButtons[] = {R.id.btn_0, R.id.btn_1, R.id.btn_2,
                R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6,
                R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_add,
                R.id.btn_divide, R.id.btn_multiply, R.id.btn_subtract
        };

        for(int btn: listButtons){
            View v = findViewById(btn);
            v.setOnClickListener(mClickListener);
        }

        mBtnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String result = Util.evaluateExpression(textView.getText().toString());
                mInputText.setLength(0);
                mInputText.append(result);
                textView.setText(mInputText.toString());
            }
        });

    }

    private class ButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v){
            mInputText.append(((Button) v).getText());
            textView.setText(mInputText + " ");
        }
    }
}
