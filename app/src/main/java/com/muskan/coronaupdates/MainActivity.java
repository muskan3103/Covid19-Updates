package com.muskan.coronaupdates;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView tvCases, tvRecovered, tvDeaths, tvActive, tvTodayCases, tvTodayDeaths, tvCritical, tvAffectedCountries;
    ScrollView scrollView;
    ProgressBar progressBar;
    PieChart pieChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvActive = findViewById(R.id.tvActive);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvDeaths = findViewById(R.id.tvDeaths);
        tvCases = findViewById(R.id.tvCases);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvTodayDeaths = findViewById(R.id.tvTodayDeath);
        tvAffectedCountries = findViewById(R.id.TvAffected);
        tvCritical = findViewById(R.id.tvCritical);

        progressBar = findViewById(R.id.progressBar);
        scrollView = findViewById(R.id.scrollView);
        pieChart = findViewById(R.id.piechart);

        fetchData();

    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setMessage("Do you really want to exit ?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alert.setCancelable(false);

        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }

    private void fetchData() {

    String url = "https://corona.lmao.ninja/v2/all/";

        progressBar.setVisibility(View.VISIBLE);

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response.toString());

                    tvCases.setText(jsonObject.getString("cases"));
                    tvDeaths.setText(jsonObject.getString("deaths"));
                    tvTodayCases.setText(jsonObject.getString("todayCases"));
                    tvTodayDeaths.setText(jsonObject.getString("todayDeaths"));
                    tvRecovered.setText(jsonObject.getString("recovered"));
                    tvActive.setText(jsonObject.getString("active"));
                    tvCritical.setText(jsonObject.getString("critical"));
                    tvAffectedCountries.setText(jsonObject.getString("affectedCountries"));

                    pieChart.addPieSlice(new PieModel("Cases",Integer.parseInt(tvCases.getText().toString()),
                            Color.parseColor("#FFA726")));
                    pieChart.addPieSlice(new PieModel("Recovered",Integer.parseInt(tvRecovered.getText().toString()),
                            Color.parseColor("#66BB6A")));
                    pieChart.addPieSlice(new PieModel("Deaths",Integer.parseInt(tvDeaths.getText().toString()),
                            Color.parseColor("#EF5350")));
                    pieChart.addPieSlice(new PieModel("Active",Integer.parseInt(tvActive.getText().toString()),
                            Color.parseColor("#29B6F6")));

                    pieChart.startAnimation();

                   progressBar.setVisibility(View.GONE);
                   scrollView.setVisibility(View.VISIBLE);


                } catch (JSONException e) {
                    e.printStackTrace();
                    progressBar.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void goToCountries(View view){
        startActivity(new Intent(MainActivity.this, AffectedCountries.class));
    }

}
