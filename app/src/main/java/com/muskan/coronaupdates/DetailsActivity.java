package com.muskan.coronaupdates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Objects;

public class DetailsActivity extends AppCompatActivity {

    private int positionCountry;
    TextView tvCases, tvRecovered, tvDeaths, tvActive, tvTodayCases, tvTodayDeaths, tvCritical, Population;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home)
        {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position",0);

        getSupportActionBar().setTitle("Details of "+AffectedCountries.countryModelList.get(positionCountry).getCountry());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        tvActive = findViewById(R.id.tvDetailActive);
        tvRecovered = findViewById(R.id.tvDetailRecovered);
        tvDeaths = findViewById(R.id.tvDetailDeaths);
        tvCases = findViewById(R.id.tvDetailCases);
        tvTodayCases = findViewById(R.id.tvDetailTodayCases);
        tvTodayDeaths = findViewById(R.id.tvDetailTodayDeath);
        Population = findViewById(R.id.Population);
        tvCritical = findViewById(R.id.tvDetailCritical);

        tvActive.setText(AffectedCountries.countryModelList.get(positionCountry).getActive());
        tvRecovered.setText(AffectedCountries.countryModelList.get(positionCountry).getRecovered());
        tvDeaths.setText(AffectedCountries.countryModelList.get(positionCountry).getDeaths());
        tvCases.setText(AffectedCountries.countryModelList.get(positionCountry).getCases());
        tvTodayCases.setText(AffectedCountries.countryModelList.get(positionCountry).getTodayCases());
        tvTodayDeaths.setText(AffectedCountries.countryModelList.get(positionCountry).getTodayDeaths());
        Population.setText(AffectedCountries.countryModelList.get(positionCountry).getPopulation());
        tvCritical.setText(AffectedCountries.countryModelList.get(positionCountry).getCritical());

    }
}
