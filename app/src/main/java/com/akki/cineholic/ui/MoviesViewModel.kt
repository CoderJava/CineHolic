package com.akki.cineholic.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akki.cineholic.data.MoviesItem
import com.akki.cineholic.data.MoviesRepository


class MoviesViewModel(val repo: MoviesRepository) : ViewModel() {


    fun getTopRatedMovies(key: String, page: Int):MutableLiveData<MoviesItem> {
       return repo.fetchTopRated(key,page)
    }


}