package com.example.firstjitcomposeproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.firstjitcomposeproject.data.Movie
import com.example.firstjitcomposeproject.data.MovieData
import com.example.firstjitcomposeproject.ui.FirstJitComposeProjectTheme


class MovieListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val themeState = remember { mutableStateOf(false) }
            FirstJitComposeProjectTheme(themeState.value) {
                // PopularMoviesMainPage()

                Scaffold(
                    topBar = {
                        LoginTopBar(
                            title = stringResource(id = R.string.moview),
                            onThemeSwitchClick = { themeState.value = themeState.value.not() }
                        )
                    },

                    //  bottomBar = { LoginBottomBar() },

                    bodyContent = {
                        Column {


                            Column(
                                modifier = Modifier.fillMaxWidth()
                                    .wrapContentHeight(align = Alignment.Bottom),
                                verticalArrangement = Arrangement.Center
                            ) {
                              //  Spacer(modifier = Modifier.preferredHeight(48.dp))
                                PopularMoviesMainPage()
                                //Spacer(modifier = Modifier.preferredHeight(164.dp))

                            }

                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PopularMoviesMainPage() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .wrapContentHeight(align = Alignment.Bottom),
        verticalArrangement = Arrangement.Center
    ) {

        LazyColumnFor(items = MovieData.list) {

            PopularMoviesListItem(it)
        }
       /* LazyColumnFor(items = ) {

        }*/
    }
}
/* Image(
                asset = imageResource(id = movie.image),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.preferredHeight(height = 200.dp),
                alignment = Alignment.TopCenter
            )*/

@Composable
fun PopularMoviesListItem(movie: Movie) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxWidth()
            .height(height = 375.dp)
    ) {

        Column {
            val image = imageResource(id = movie.image)
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                val imageModifier = Modifier
                    .preferredHeight(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp))

                Image(
                    image, modifier = imageModifier,
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.preferredHeight(16.dp))


            }
            Text(
                text = movie.title,
                modifier = Modifier.padding(all = 8.dp),
                style = MaterialTheme.typography.h6
            )
            Row(
                modifier = Modifier.padding(all = 8.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Release Date: ${movie.releaseDate}",
                    style = MaterialTheme.typography.subtitle2
                )
                Text(
                    text = "Vote: ${movie.voteAverage}/10",
                    style = MaterialTheme.typography.subtitle2
                )
            }
            Text(
                text = movie.overview,
                modifier = Modifier.padding(all = 8.dp),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.caption
            )
        }
    }

}

@Composable
fun NewsStory() {
    val image = imageResource(R.drawable.ic_folder)
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        val imageModifier = Modifier
            .preferredHeight(180.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(4.dp))

        Image(
            image, modifier = imageModifier,
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.preferredHeight(16.dp))


    }
}
