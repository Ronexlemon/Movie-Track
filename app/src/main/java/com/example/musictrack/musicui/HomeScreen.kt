package com.example.musictrack.musicui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.musictrack.MyViewModel
import com.example.musictrack.music_data.MovieData

@Composable
fun HomeScreen(viewmodel:MyViewModel,onItemClick: (MovieData) -> Unit){

    Scaffold(
        topBar = {
            TopBarr()
        },
        content = {
MainContent(viewmodel.movieListResponse,viewmodel=viewmodel,onItemClick=onItemClick)
            Log.i("Tag",viewmodel.movieListResponse.toString())
        }

    )




}
@Composable
fun TopBarr(modifier: Modifier =Modifier){
    TopAppBar(title = {Text("Movie Track",style = TextStyle(fontSize = 16.sp,fontFamily = FontFamily.Serif))})


}

@Composable
fun MainContent(list:List<MovieData>,viewmodel: MyViewModel,onItemClick: (MovieData) -> Unit){
 viewmodel.getMovieList()
    LazyColumn{
        items(items=list, itemContent = {item->
            DisplayItem(list=item,onItemClick =onItemClick)

        })
    }

}

@Composable
fun DisplayItem(modifier:Modifier=Modifier,list:MovieData,onItemClick:(MovieData)->Unit) {
    Card(
        modifier
            .fillMaxWidth()
            .height(200.dp).padding(16.dp).background(color=Color.Gray),elevation = 15.dp,shape = RoundedCornerShape(15.dp)){
        Column(modifier.fillMaxSize().background(color=Color.DarkGray)){
            Row(modifier.clickable{onItemClick(list)}){
                Image(
                    painter = rememberAsyncImagePainter(list.imageUrl),
                    contentDescription = null,
                    modifier = Modifier.padding(16.dp).clip(CircleShape).size(100.dp),contentScale = ContentScale.Crop
                )
                Column{
                    Text(text=list.name,modifier=Modifier.padding(16.dp))


                }
                //Text(text=list.,modifier=Modifier.padding(16.dp))
            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun ShowAll(){
    //MainContent()
}
