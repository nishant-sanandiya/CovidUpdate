package com.example.covid_update

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.loader
import kotlinx.android.synthetic.main.activity_main2.*
import org.json.JSONArray
import org.json.JSONObject
import java.util.*


class MainActivity2 : AppCompatActivity() {


    companion object { public  val countrymodellist = ArrayList<CountryModel>()  }
        lateinit var countrymodel :CountryModel
        lateinit var countryadapter: CountryAdapter

    private lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        linearLayoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = linearLayoutManager
        recyclerview.adapter = countryadapter



        fetchdata()
    }

    private fun fetchdata() {

        val url:String ="https://corona.lmao.ninja/v2/countries"  //api url

        loader.start() // loader is a id in xml  and start when fechdata fun call

        val request = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->

                val jsonarray=JSONArray(response)
                val size = jsonarray.length()

                for(item in 1..size) {
                    val jsonobject = JSONObject()
                    val countryname = jsonobject.getString("country")
                    val cases = jsonobject.getString("case")
                    val todaycases = jsonobject.getString("todayCases")
                    val deaths = jsonobject.getString("deaths")
                    val todaydeaths = jsonobject.getString("todayDeaths")
                    val recovered = jsonobject.getString("recovered")
                    val active = jsonobject.getString("active")
                    val critical = jsonobject.getString("critical")

                    val object1 = JSONObject("countryInfo")
                    val flagurl = object1.getString("flag")

                    countrymodel = CountryModel(flagurl,countryname,cases,todaycases,deaths,todaydeaths,recovered,active,critical)
                    countrymodellist.add(countrymodel)
                }

                countryadapter = CountryAdapter(countrymodellist)


                    loader.stop()
                loader.visibility = View.GONE   //loader invisible

            },
            Response.ErrorListener {
                loader.stop()
                loader.visibility = View.GONE   //loader invisible
            })


        val requestqueue = Volley.newRequestQueue(this)
        requestqueue.add(request)
    }
}