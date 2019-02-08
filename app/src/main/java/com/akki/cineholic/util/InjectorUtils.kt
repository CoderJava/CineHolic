package com.akki.cineholic.util

import com.akki.cineholic.data.MoviesRepository
import com.akki.cineholic.ui.MoviesViewModelFactory

object InjectorUtils {

    // This will be called from QuotesActivity
    fun provideQuotesViewModelFactory(): MoviesViewModelFactory {
        // ViewModelFactory needs a repository, which in turn needs a DAO from a database
        // The whole dependency tree is constructed right here, in one place
        val moviesRepository = MoviesRepository()
        return MoviesViewModelFactory(moviesRepository)
    }
}