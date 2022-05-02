package com.example.musictrack.music_data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieData(val name: String,
                     val imageUrl: String,
                     val desc: String,
                     val category: String,
                     val id:Int):Serializable
