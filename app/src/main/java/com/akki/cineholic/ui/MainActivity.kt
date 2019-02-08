package com.akki.cineholic.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.akki.cineholic.R
import com.akki.cineholic.util.ApiConstants
import com.akki.cineholic.util.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUI()
    }

    private fun initializeUI() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(MoviesViewModel::class.java)
        viewModel.getTopRatedMovies(ApiConstants.API_KEY, 200)
        viewModel.apiResponse().observe(this, Observer { quotes ->
              val stringBuilder = StringBuilder()
            quotes.results.forEach { quote ->
                Log.e("TAG", quote.originalTitle)
                 stringBuilder.append("${quote.title}\n\n")
            }
            text.text = stringBuilder.toString()
        })

    }
}
