package com.example.carddemo.repositories.TechTalk

import TechTalkService
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.carddemo.Constants
import com.example.carddemo.services.dto.TechTalkDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class TechTalkRepository {
    var techTalks = MutableLiveData<List<TechTalkDto>>()

    init {
        techTalks.value = mutableListOf()
    }

    private fun getRetrofit(): TechTalkService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(TechTalkService::class.java)
    }

    fun getTechTalks() {
        getRetrofit().getTechTalks().enqueue(object : Callback<List<TechTalkDto>> {

            /* The HTTP call failed. This method is run on the main thread */
            override fun onFailure(call: Call<List<TechTalkDto>>, t: Throwable) {
                Log.d("TAG_", "An error happened!")

            }

            /* The HTTP call was successful, we should still check status code and response body
             * on a production app. This method is run on the main thread */
            override fun onResponse(
                call: Call<List<TechTalkDto>>,
                response: Response<List<TechTalkDto>>
            ) {
                /* This will print the response of the network call to the Logcat */
                Log.d("TAG_", response.body().toString())
                techTalks.value = response.body().orEmpty()
            }
        })
    }
}