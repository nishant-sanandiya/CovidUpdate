package com.example.covid_update

import android.app.DownloadManager
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import org.eazegraph.lib.models.PieModel
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchdata()
    }

    private fun fetchdata() {
         val url:String ="https://corona.lmao.ninja/v2/all"  //api url

        loader.start() // loader is a id in xml  and start when fechdata fun call

        val request = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->

                val jsonobject = JSONObject(response.toString())
                tvCases.setText(jsonobject.getString("cases"))
                tvActive.setText(jsonobject.getString("active"))
                tvAffectedCountries.setText(jsonobject.getString("affectedCountries"))
                tvCritical.setText(jsonobject.getString("critical"))
                tvTodayCases.setText(jsonobject.getString("todayCases"))
                tvRecovered.setText(jsonobject.getString("recovered"))
                tvTodayDeaths.setText(jsonobject.getString("todayDeaths"))
                tvTotalDeaths.setText(jsonobject.getString("deaths"))

                piechart.addPieSlice(PieModel("Total cases", Integer.parseInt(tvCases.text.toString()).toFloat(),Color.parseColor("#FFA726")))
                piechart.addPieSlice(PieModel("Recovered", Integer.parseInt(tvRecovered.text.toString()).toFloat(),Color.parseColor("#66BB6A")))
                piechart.addPieSlice(PieModel("Deaths", Integer.parseInt(tvTotalDeaths.text.toString()).toFloat(),Color.parseColor("#EF5350")))
                piechart.addPieSlice(PieModel("Active Cases", Integer.parseInt(tvActive.text.toString()).toFloat(),Color.parseColor("#29B6F2")))
                piechart.startAnimation()

                loader.stop()
                 loader.visibility = View.GONE   //loader invisible
                scrollStats.visibility= View.VISIBLE//scrollview visible




                // Display the first 500 characters of the response string.
               // textView.text = "Response is: ${response.substring(0, 500)}"
            },
            Response.ErrorListener { Toast.makeText(this, "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show()
                })


               val requestqueue = Volley.newRequestQueue(this)
               requestqueue.add(request)
    }


    fun goTrackCountries(view: View) {

     //  val intent:Intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }
}