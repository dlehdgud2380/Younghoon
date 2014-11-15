package com.scoutlee.younghoon;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;


public class CaculatorActivity extends ActionBarActivity {

    EditText editText, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16, editText17;
    Button button;
    TextView textView10, textView11;
    int num1, num2, num3, num4, num5, num6, num7, num8, num9, num10, num11, num12, num13, num14, num15, num16;
    Integer Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caculator);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText10 = (EditText) findViewById(R.id.editText10);
        editText16 = (EditText) findViewById(R.id.editText11);
        editText12 = (EditText) findViewById(R.id.editText12);
        editText13 = (EditText) findViewById(R.id.editText13);
        editText14 = (EditText) findViewById(R.id.editText14);
        editText15 = (EditText) findViewById(R.id.editText15);
        editText16 = (EditText) findViewById(R.id.editText16);
        editText17 = (EditText) findViewById(R.id.editText17);
        textView10 = (TextView) findViewById(R.id.textView10);
        textView11 = (TextView) findViewById(R.id.textView11);//계산결과
        button = (Button) findViewById(R.id.button); //계산버튼

        View.OnClickListener clisten = new View.OnClickListener() {
            public void onClick(View v) {

                num1=Integer.parseInt(editText.getText().toString());
                num2=Integer.parseInt(editText2.getText().toString());
                num3=Integer.parseInt(editText3.getText().toString());
                num4=Integer.parseInt(editText4.getText().toString());
                num5=Integer.parseInt(editText5.getText().toString());
                num6=Integer.parseInt(editText6.getText().toString());
                num7=Integer.parseInt(editText7.getText().toString());
                num8=Integer.parseInt(editText8.getText().toString());
                num9=Integer.parseInt(editText9.getText().toString());
                num10=Integer.parseInt(editText10.getText().toString());
                num11=Integer.parseInt(editText12.getText().toString());
                num12=Integer.parseInt(editText13.getText().toString());
                num13=Integer.parseInt(editText14.getText().toString());
                num14=Integer.parseInt(editText15.getText().toString());
                num15=Integer.parseInt(editText17.getText().toString());
                num16=Integer.parseInt(editText16.getText().toString());

                switch(v.getId()){
                    case R.id.button:
                        Result=(num1+num2+num3+num4+num5+num6+num7+num8+num9+num10+num11+num12+num13+num14+num15)/num16;
                        break;
                }

                textView11.setText(""+Result);


            }


        };

        button.setOnClickListener(clisten);
    }
}