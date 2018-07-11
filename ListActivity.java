package com.errne.countrylistgenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    TextView tvListInfo, tvCountry;
    Button btnEurope, btnAsia, btnAfrica, btnOceania, btnNAmerica, btnSAmerica, btnViewList, btnNext;
    String[] currentList;
    int length;
    CountryList newList;
    List europe = new ArrayList<>(Arrays.asList(CountryList.EUROPE));
    List asia = new ArrayList<>(Arrays.asList(CountryList.ASIA));
    List africa = new ArrayList<>(Arrays.asList(CountryList.AFRICA));
    List oceania = new ArrayList<>(Arrays.asList(CountryList.OCEANIA));
    List northAmerica = new ArrayList<>(Arrays.asList(CountryList.NAMERICA));
    List southAmerica = new ArrayList<>(Arrays.asList(CountryList.SAMERICA));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        tvListInfo = findViewById(R.id.tvListInfo);
        btnEurope = findViewById(R.id.btnEurope);
        btnAsia = findViewById(R.id.btnAsia);
        btnAfrica = findViewById(R.id.btnAfrica);
        btnOceania = findViewById(R.id.btnOceania);
        btnNAmerica = findViewById(R.id.btnNAmerica);
        btnSAmerica = findViewById(R.id.btnSAmerica);
        btnViewList =findViewById(R.id.btnViewList);
        btnViewList.setVisibility(View.GONE);
        btnNext = findViewById(R.id.btnNext);
        btnNext.setVisibility(View.GONE);
        tvCountry = findViewById(R.id.tvCountry);
        tvCountry.setVisibility(View.GONE);

        Intent mIntent = getIntent();
        length = mIntent.getIntExtra("listlength", 0);
        tvListInfo.setText(""+ length + " countries left to choose");

        newList = new CountryList(length);
        currentList = newList.getCountryList();

        btnEurope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String country = generateCountry(europe);
                makeList(country, europe);
            }
        });
        btnAfrica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String country = generateCountry(africa);
                makeList(country, africa);
            }
        });
        btnAsia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String country = generateCountry(asia);
                makeList(country, asia);
            }
        });
        btnOceania.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oceania.size()<1){
                    Toast.makeText(ListActivity.this, "No more countries left to choose in South America", Toast.LENGTH_LONG).show();
                    return;
                }   else {
                    String country = generateCountry(oceania);
                    makeList(country, oceania);
                }
            }
        });
        btnNAmerica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(northAmerica.size()<1){
                    Toast.makeText(ListActivity.this, "No more countries left to choose in South America", Toast.LENGTH_LONG).show();
                    return;
                }   else {
                    String country = generateCountry(northAmerica);
                    makeList(country, northAmerica);
                };
            }
        });
        btnSAmerica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(southAmerica.size()<1){
                    Toast.makeText(ListActivity.this, "No more countries left to choose in South America", Toast.LENGTH_LONG).show();
                    return;
                }   else {
                    String country = generateCountry(southAmerica);
                    makeList(country, southAmerica);
                }
            }
        });
        btnViewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m2Intent = new Intent(ListActivity.this,
                        StorageActivity.class);
                m2Intent.putExtra("currentList", currentList);
                startActivity(m2Intent);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unHideButtons();
            }
        });
    }

    public String generateCountry(List continent){
        String answer;
        Random random = new Random();
        int rr = random.nextInt(continent.size());
        answer = continent.get(rr).toString();
        return answer;
    }
    public void makeList(String country, List continent){
        tvCountry.setText(country);
        newList.addCountry(country);
        continent.remove(country);
        length--;
        hideButtons();
    }

    public void hideButtons(){
        btnEurope.setVisibility(View.GONE);
        btnAsia.setVisibility(View.GONE);
        btnAfrica.setVisibility(View.GONE);
        btnOceania.setVisibility(View.GONE);
        btnNAmerica.setVisibility(View.GONE);
        btnSAmerica.setVisibility(View.GONE);
        tvCountry.setVisibility(View.VISIBLE);
        tvCountry.setTextSize(24);
        btnViewList.setVisibility(View.VISIBLE);
        tvListInfo.setText(""+ length + " countries left to choose");
        if (length ==0) {
            btnNext.setVisibility(View.GONE);
        }else{
            btnNext.setVisibility(View.VISIBLE);
        }
    }
    public void unHideButtons(){
        btnEurope.setVisibility(View.VISIBLE);
        btnAsia.setVisibility(View.VISIBLE);
        btnAfrica.setVisibility(View.VISIBLE);
        btnOceania.setVisibility(View.VISIBLE);
        btnNAmerica.setVisibility(View.VISIBLE);
        btnSAmerica.setVisibility(View.VISIBLE);
        tvCountry.setVisibility(View.GONE);
        btnNext.setVisibility(View.GONE);
    }
}
