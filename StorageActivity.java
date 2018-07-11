package com.errne.countrylistgenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StorageActivity extends AppCompatActivity {
    TextView tvList, tvListname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        tvList = findViewById(R.id.tvList);
        tvListname = findViewById(R.id.tvListname);

        Intent m2Intent = getIntent();
        String[] array = m2Intent.getStringArrayExtra("currentList");
        tvList.setText("1. " + array[0] + "\n");

       int arraySize = array.length;
        for (int i = 1; i < arraySize; i++) {
            if(array[i]==null){
                tvList.append("not chosen yet");
                tvList.append("\n");
            } else {
                tvList.append("" + (i+1) + ". ");
                tvList.append(array[i]);
                tvList.append("\n");
            }
        }
    }
}
