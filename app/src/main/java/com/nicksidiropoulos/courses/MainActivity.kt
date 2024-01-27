package com.nicksidiropoulos.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nicksidiropoulos.courses.model.Course
import com.nicksidiropoulos.courses.model.DataSource
import com.nicksidiropoulos.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                TopicsList(courseList = DataSource.Courses)
            }
        }
    }
}

@Composable
fun TopicsList(courseList: List<Course>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 150.dp), modifier = modifier){
        items(courseList){course->
            Topic(course = course,
                modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun Topic(course: Course, modifier: Modifier = Modifier){
    Card(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(id = course.imageResource),
                contentDescription = stringResource(id = course.stringResource),
                modifier = Modifier
                    .height(68.dp),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = stringResource(id = course.stringResource),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(16.dp,16.dp,16.dp,8.dp)
                )
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                        modifier = Modifier.padding(16.dp,0.dp,8.dp,0.dp)
                    )
                    Text(
                        text = course.lessonsNumber.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(0.dp,4.dp,0.dp,0.dp)
                    )
                }
            }
        }

    }
}

@Preview
@Composable
fun TopicListPreview(){
    TopicsList(courseList = DataSource.Courses)
}

@Preview(showBackground = true)
@Composable
fun TopicPreview() {
    Topic(Course(R.string.architecture, 58, R.drawable.architecture))
}