@file:OptIn(ExperimentalComposeUiApi::class)

package com.techlads.testing.ui.compose.gallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.techlads.testing.ui.compose.gallery.ui.theme.TestingTheme
import com.techlads.tmdbmobileapi.remote.dto.Movie

class ComposeGalleryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val moviesViewModel by viewModels<MoviesViewModel>()

        setContent {
            TestingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .semantics {
                            testTagsAsResourceId = true
                        },
                    color = MaterialTheme.colorScheme.background
                ) {
                    val movies = moviesViewModel.movies.collectAsState()
                    ImagesList(movies.value)
                }
            }
        }
    }
}

@Composable
fun ImagesList(movies: List<Movie>) {
    LazyColumn(modifier = Modifier.fillMaxSize().testTag("images_list")) {
        items(movies) {
            ImageItem(it)
        }
    }
}

@Composable
fun ImageItem(movie: Movie) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .aspectRatio(1.5f),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        AsyncImage(
            model =  "https://image.tmdb.org/t/p/w500" + movie.posterPath,
            contentDescription = "icons"
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestingTheme {
        Greeting("Android")
    }
}