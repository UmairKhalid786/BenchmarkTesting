package com.techlads.testing.ui.compose.gallery

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techlads.tmdbmobileapi.remote.NetworkClient
import com.techlads.tmdbmobileapi.remote.datasource.TrendingTodayMoviesDataSource
import com.techlads.tmdbmobileapi.remote.dto.Movie
import com.techlads.tmdbmobileapi.usecase.TrendingTodayMoviesUseCae
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {

    val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies : StateFlow<List<Movie>> = _movies

    init {
        viewModelScope.launch {
            val result = TrendingTodayMoviesUseCae(TrendingTodayMoviesDataSource(NetworkClient)).invoke()
            _movies.value = result.data?.searches ?: emptyList()
            Log.e("Result", result.data?.toString() ?: "No Data")
        }
    }
}