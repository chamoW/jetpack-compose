package com.diamoncode.lemonademaker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diamoncode.lemonademaker.ui.theme.LemonadeMakerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeMakerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    LeamodeMaker()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeMakerTheme {
        LeamodeMaker()
    }
}

@Composable
fun LeamodeMaker(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
) {
    var step by remember { mutableStateOf(1) }
    var squeze by remember { mutableStateOf(4) }

    when (step) {
        1 -> LeamonAndText(modifier, R.drawable.lemon_tree, R.string.step1, onImageClick = {
            step = 2
        })

        2 -> LeamonAndText(modifier, R.drawable.lemon_squeeze, R.string.step2,
            onImageClick = {
                squeze--
                if (squeze == 0) {
                    step = 3
                }
            })

        3 -> LeamonAndText(modifier, R.drawable.lemon_drink, R.string.step3, onImageClick = {
            step = 4
        })

        4 -> LeamonAndText(modifier, R.drawable.lemon_restart, R.string.step4, onImageClick = {
            step = 1
        })
    }

}

@Composable
fun LeamonAndText(
    modifier: Modifier = Modifier, imageId: Int, textId: Int, onImageClick: () -> Unit
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = onImageClick,
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_corner_radius)),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = stringResource(id = textId),
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(id = textId), fontSize = 18.sp)

    }


}
