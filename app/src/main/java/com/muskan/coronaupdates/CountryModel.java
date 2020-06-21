package com.muskan.coronaupdates;

import com.android.volley.toolbox.StringRequest;

public class CountryModel {
    private String flag;
    private String country;
    private  String critical;
    private String Cases;
    private String todayCases;
    private String deaths;
    private String todayDeaths;
    private String Recovered;
    private String active;
    private String Population;


    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public String getCases() {
        return Cases;
    }

    public void setCases(String cases) {
        Cases = cases;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public String getRecovered() {
        return Recovered;
    }

    public String getPopulation() {
        return Population;
    }

    public void setPopulation(String population) {
        Population = population;
    }

    public void setRecovered(String recovered) {
        Recovered = recovered;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }


    public CountryModel(String flag, String country, String critical, String cases, String todayCases, String deaths, String todayDeaths, String recovered, String active, String population) {
        this.flag = flag;
        this.country = country;
        this.critical = critical;
        this.Cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.Recovered = recovered;
        this.active = active;
        this.Population = population;
    }

  /*  public CountryModel(String flag, String country, String todayCases, String deaths, String todayDeaths, String recovered, String active, String Population) {
        this.flag = flag;
        this.country = country;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.Recovered = recovered;
        this.active = active;
        this.Population = Population;
    }*/
}
