package com.doanburak.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class cityFinderActivity extends AppCompatActivity {

    EditText et_cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_finder);

        et_cityName = findViewById(R.id.et_cityName);
    }

    public void enterCity(View view){

        if (!et_cityName.getText().toString().isEmpty()){

            String newCity = et_cityName.getText().toString();
            Intent toMainPage = new Intent(cityFinderActivity.this, MainActivity.class);
            toMainPage.putExtra("City", newCity);
            startActivity(toMainPage);

        }else{
            Toast.makeText(this, "Please fill the city name area!", Toast.LENGTH_SHORT).show();
        }
    }
}