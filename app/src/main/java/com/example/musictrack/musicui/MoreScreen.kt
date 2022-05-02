package com.example.musictrack.musicui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.rememberScrollState

import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.musictrack.music_data.MovieData

@Composable
fun MoreScreen(data:MovieData){
    
    Scaffold(topBar = {
        Top_Bar()
    },content = {
        MoreContent(data = data)
    }) 
    
}
@Composable
fun Top_Bar(){
    TopAppBar(title = { Text("MovieTrack",style = TextStyle(fontSize = 16.sp,fontFamily = FontFamily.Serif)) })



}

@Composable
fun MoreContent(data:MovieData){
    Column{
        Image(
            painter = rememberAsyncImagePainter(data.imageUrl),
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)

                .fillMaxWidth(),contentScale = ContentScale.Crop)
        Texts(data)
    }
    
}

@Composable
fun Texts(data:MovieData){

    Column(modifier=Modifier.verticalScroll(rememberScrollState())){
        Text(text=data.name,modifier=Modifier.padding(8.dp))
        Text(text=data.category!!,modifier=Modifier.padding(8.dp))
        Text(text=data.desc!!,modifier=Modifier.padding(8.dp))

        


    }
}