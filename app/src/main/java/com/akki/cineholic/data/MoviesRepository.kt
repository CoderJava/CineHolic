package com.akki.cineholic.data

import com.akki.cineholic.rest.RetrofitClient
import io.reactivex.Observable

class MoviesRepository {

    /*
     * method to call login api
     * */

    fun fetchTopRated(key: String, page: Int): Observable<MoviesItem> {
        return RetrofitClient.getInstance().apiService.getTopRatedMovies(key, page)
    }
}