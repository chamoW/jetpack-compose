package com.diamoncode.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diamoncode.taskmanager.ui.theme.TaskmanagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskmanagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(
                        stringResource(R.string.message1_text),
                        stringResource(R.string.message2_text)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(message: String, message2: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.ic_task_completed)
    Box(modifier = modifier) {
        Column(modifier = modifier.align(Alignment.Center)) {
            Image(painter = image, contentDescription = null)


            Text(
                text = message,
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .padding(top = 24.dp, bottom = 8.dp)
                    .align(alignment = Alignment.CenterHorizontally)

            )

            Text(
                text = message2,
                fontSize = 16.sp,
                modifier = modifier.align(alignment = Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskmanagerTheme {
        Greeting(stringResource(R.string.message1_text), stringResource(R.string.message2_text))
    }
}