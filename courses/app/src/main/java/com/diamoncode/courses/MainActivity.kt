package com.diamoncode.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.diamoncode.courses.datasource.DataSource
import com.diamoncode.courses.model.Topic
import com.diamoncode.courses.ui.theme.CoursesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseApp()
                }
            }
        }
    }
}

val topics = listOf(
    Topic(R.string.architecture, 58, R.drawable.architecture),
    Topic(R.string.crafts, 121, R.drawable.crafts),
    Topic(R.string.business, 78, R.drawable.business),
    Topic(R.string.culinary, 118, R.drawable.culinary),
    Topic(R.string.design, 423, R.drawable.design),
    Topic(R.string.fashion, 92, R.drawable.fashion),
    Topic(R.string.film, 165, R.drawable.film),
    Topic(R.string.gaming, 164, R.drawable.gaming),
    Topic(R.string.drawing, 326, R.drawable.drawing),
    Topic(R.string.lifestyle, 305, R.drawable.lifestyle),
    Topic(R.string.music, 212, R.drawable.music),
    Topic(R.string.painting, 172, R.drawable.painting),
    Topic(R.string.photography, 321, R.drawable.photography),
    Topic(R.string.tech, 118, R.drawable.tech)
)

@Composable
fun CourseApp() {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2), verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier
            .padding(8.dp)
    ) {
        items(DataSource.topics) { topic -> CourseItem(topic = topic) }
    }

}

@Composable
fun CourseItem(topic: Topic, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
    ) {
        Row(modifier = Modifier) {
            Image(
                modifier = Modifier
                    .size(width = 68.dp, height = 68.dp)
                    .aspectRatio(1f),
                painter = painterResource(id = topic.idImage),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(top = 16.dp, end = 16.dp, start = 16.dp)) {
                Text(
                    text = stringResource(id = topic.courseTitle),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(
                    modifier = Modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier.padding(end = 8.dp)
                    )

                    Text(text = "56", style = MaterialTheme.typography.labelMedium)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoursesTheme (darkTheme = false) {

        //CourseItem(topic = DataSource.topics[1])
        CourseApp()
    }
}