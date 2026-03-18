package solutions.sgbrightkit.firetvdemo

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.tv.material3.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.tv.material3.Card

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun MainScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(48.dp, 40.dp)
        ) {
            Text(
                text = "🔥 FireTV Demo",
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                contentPadding = PaddingValues(bottom = 40.dp)
            ) {
                items(MovieList.categories.size) { index ->
                    val (categoryName, movies) = MovieList.categories[index]
                    MovieCategory(
                        categoryName = categoryName,
                        movies = movies
                    )
                }
            }
        }
    }
}

@Composable
fun MovieCategory(
    categoryName: String,
    movies: List<Movie>
) {
    Column {
        Text(
            text = categoryName,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(movies.size) { index ->
                MovieCard(
                    movie = movies[index],
                    onClick = {
                        // We'll handle clicks later
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun MovieCard(
    movie: Movie,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .width(240.dp)
            .height(135.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = movie.title)
        }
    }
}