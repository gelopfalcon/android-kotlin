package com.example.carddemo.activities

import TechTalkService
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carddemo.R
import com.example.carddemo.RecyclerAdapter
import com.example.carddemo.services.dto.TechTalkDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("activities", "onCreate")
        setContentView(R.layout.activity_main)
    }

    override fun onPause() {
        super.onPause()
        Log.i("activities", "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.i("activities", "onResume")

        if (!isNetworkConnected()) {
            AlertDialog.Builder(this).setTitle("No Internet Connection")
                    .setMessage(R.string.internet_connection)
                    .setPositiveButton(android.R.string.ok) { _, _ -> }
                    .setIcon(android.R.drawable.ic_dialog_alert).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("activities", "onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.i("activities", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("activities", "onDestroy")
    }

    private fun isNetworkConnected(): Boolean {
        //1
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        //2
        val activeNetwork = connectivityManager.activeNetwork
        //3
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        //4
        return networkCapabilities != null &&
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

}