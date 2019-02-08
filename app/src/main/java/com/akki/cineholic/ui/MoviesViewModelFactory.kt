package com.akki.cineholic.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akki.cineholic.data.MoviesRepository

class MoviesViewModelFactory(private val moveRepository: MoviesRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(moveRepository) as T
    }
}