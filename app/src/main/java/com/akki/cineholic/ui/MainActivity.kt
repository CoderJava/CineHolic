package com.akki.cineholic.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.akki.cineholic.R
import com.akki.cineholic.data.MoviesItem
import com.akki.cineholic.util.ApiConstants
import com.akki.cineholic.util.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //private lateinit var adapter: MoviesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUI()
    }

    private fun initializeUI() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(MoviesViewModel::class.java)

        viewModel.getTopRatedMovies(ApiConstants.API_KEY, 10).observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.results.forEach { quote ->
                Log.e("TAG", quote.originalTitle)
                stringBuilder.append("${quote.title}\n\n")
            }
            text.text = stringBuilder.toString()
        })
    }


    private fun setAdapter(moviesItem: MoviesItem) {
//        adapter = MoviesListAdapter(moviesItem.results)
//        rcl_view.adapter = adapter
//        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
//        rcl_view.layoutManager = layoutManager
//        adapter.notifyDataSetChanged()
    }
}
