package com.example.covid_update

import androidx.recyclerview.widget.RecyclerView

public  class CountryModel  {


    var flag:String
        get() = this.toString()
        set(value) {
            flag=value
        }


    var country:String
        get() = this.toString()
        set(value) {
            country=value
        }


    var cases:String
        get() = this.toString()
        set(value) {
            cases=value
        }


   var todaycases:String
        get() = this.toString()
        set(value) {
            todaycases=value
        }

    var deaths:String
        get() = this.toString()
        set(value) {
            deaths=value
        }

    var todaydeaths:String
        get() = this.toString()
        set(value) {
            todaydeaths=value
        }


    var recovered:String
        get() = this.toString()
        set(value) {
            recovered=value
        }

    var active:String
        get() = this.toString()
        set(value) {
            active=value
        }

    var critical:String
        get() = this.toString()
        set(value) {
            critical=value
        }

constructor(flag:String ,country:String, cases:String, todaycases:String, deaths:String ,todaydeaths:String
            ,recovered:String ,active:String ,critical:String)
    {
            this.flag=flag
            this.country=country
            this.cases= cases
            this.todaycases =todaycases
            this.deaths=deaths
            this.todaydeaths=todaydeaths
            this.recovered= recovered
            this.active=active
            this.critical =critical

    }







}