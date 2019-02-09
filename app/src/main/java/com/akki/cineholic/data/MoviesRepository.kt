package com.akki.cineholic.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.akki.cineholic.rest.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MoviesRepository {

    /*
     * method to call login api
     * */

    fun fetchTopRated(key: String, page: Int): MutableLiveData<MoviesItem> {
        val data = MutableLiveData<MoviesItem>()
        RetrofitClient.getInstance().apiService.getTopRatedMovies(key, page).enqueue(object : Callback<MoviesItem> {
            override fun onFailure(call: Call<MoviesItem>, t: Throwable) {
            }

            override fun onResponse(call: Call<MoviesItem>, response: Response<MoviesItem>) {
                data.value = response.body()
            }

        })

        return data
    }

    private fun throwError(throwable: Throwable?) {
        Log.e("tag", throwable.toString())
    }


}