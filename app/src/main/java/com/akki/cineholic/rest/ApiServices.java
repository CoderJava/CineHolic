package com.akki.cineholic.rest;


import com.akki.cineholic.data.MoviesItem;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {

    @GET("movie/top_rated")
    Call<MoviesItem> getTopRatedMovies(@Query("api_key") String apiKey, @Query("page") int page);

}

