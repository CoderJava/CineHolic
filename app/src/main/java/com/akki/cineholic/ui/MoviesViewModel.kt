package com.akki.cineholic.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akki.cineholic.data.MoviesItem
import com.akki.cineholic.data.MoviesRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class MoviesViewModel(val repo: MoviesRepository) : ViewModel() {

    private val responseLiveData = MutableLiveData<MoviesItem>()

    var disposable: Disposable? = null


    fun apiResponse(): MutableLiveData<MoviesItem> {
        return responseLiveData
    }


    public fun getTopRatedMovies(key: String, page: Int) {
        disposable = repo.fetchTopRated(key, page).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(
                { s -> display(s) },
                { throwable -> throwError(throwable) })
    }

    private fun throwError(throwable: Throwable?) {
        Log.e("tag", throwable.toString())
    }

    private fun display(moviesItem: MoviesItem?) {
        apiResponse().value = moviesItem
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}