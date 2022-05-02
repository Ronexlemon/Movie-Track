package com.example.musictrack

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musictrack.music_data.ApiService

import com.example.musictrack.music_data.MovieData

import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {

    var movieListResponse:List<MovieData> by mutableStateOf(mutableListOf())
    var errorMessage: String by mutableStateOf("")





    fun getMovieList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val movieList = apiService.getMovies()
                movieListResponse =movieList


            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

}