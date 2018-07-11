package com.errne.countrylistgenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    Button btnStart, btnContinue, btnStartList ;
    TextView tvWelcome, tvQuestion;
    EditText etArrayLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnStartList = findViewById(R.id.btnStartList);
        btnStartList.setVisibility(View.GONE);
        btnContinue = findViewById(R.id.btnContinue);
        btnContinue.setVisibility(View.GONE);
        tvQuestion = findViewById(R.id.tvQuestion);
        tvQuestion.setVisibility(View.GONE);
        tvWelcome= findViewById(R.id.tvWelcome);
        etArrayLength = findViewById(R.id.etArrayLength);
        etArrayLength.setVisibility(View.GONE);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStart.setVisibility(View.GONE);
                tvWelcome.setVisibility(View.GONE);
                tvQuestion.setVisibility(View.VISIBLE);
                etArrayLength.setVisibility(View.VISIBLE);
                btnStartList.setVisibility(View.VISIBLE);
            }
        });

        btnStartList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(etArrayLength.getText().toString()))
                {
                    Toast.makeText(MainActivity.this, "Please  enter a number between 1 and 32", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(Integer.parseInt(etArrayLength.getText().toString().trim())<1 || Integer.parseInt(etArrayLength.getText().toString().trim())>32){
                    Toast.makeText(MainActivity.this,"Please choose a number between 1 and 32", LENGTH_LONG).show();
                } else {
                    btnStart.setVisibility(View.VISIBLE);
                    tvWelcome.setVisibility(View.GONE);
                    tvQuestion.setVisibility(View.GONE);
                    etArrayLength.setVisibility(View.GONE);
                    btnStartList.setVisibility(View.GONE);

                    Intent mIntent = new Intent(MainActivity.this,
                            ListActivity.class);
                    int length = Integer.parseInt(etArrayLength.getText().toString().trim());
                    mIntent.putExtra("listlength", length);
                    startActivity(mIntent);
                }
            }
        });
    }
}
