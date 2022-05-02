package com.example.musictrack

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musictrack.music_data.MovieData
import com.example.musictrack.musicui.MoreContent
import com.example.musictrack.musicui.MoreScreen
import com.example.musictrack.ui.theme.MusicTrackTheme

class MoreActivity : ComponentActivity() {
    private val data:MovieData by lazy {
        intent?.getSerializableExtra(tittle) as MovieData
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicTrackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MoreScreen(data =data )
                }
            }

        }

    }
    companion object{
        private const  val tittle = "tittle"

        fun newIntent(context: Context, data:MovieData)= Intent(context,MoreActivity::class.java).apply {
            putExtra(tittle,data)


        }

    }
}

