package com.akki.cineholic.util

import com.akki.cineholic.data.MoviesRepository
import com.akki.cineholic.ui.MoviesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): MoviesViewModelFactory {
        val moviesRepository = MoviesRepository()
        return MoviesViewModelFactory(moviesRepository)
    }
}