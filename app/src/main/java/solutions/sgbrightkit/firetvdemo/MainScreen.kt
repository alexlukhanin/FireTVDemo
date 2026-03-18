package solutions.sgbrightkit.firetvdemo

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.tv.material3.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.compose.foundation.layout.Arrangement

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun MainScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(48.dp)
        ) {
            Text(
                text = "🔥 FireTV Demo",
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                items(MovieList.categories.size) { index ->
                    val (categoryName, movies) = MovieList.categories[index]
                    Text(
                        text = categoryName,
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }
        }
    }
}