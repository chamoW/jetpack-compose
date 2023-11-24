package com.diamoncode.artspace

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diamoncode.artspace.model.ResourcesData
import com.diamoncode.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    renderArtSpace()
                }
            }
        }
    }
}

@Composable
fun renderArtSpace(context: Context = LocalContext.current) {

    var idImage by remember { mutableStateOf(1) }
    var objectResource by remember {
        mutableStateOf<ResourcesData>(ResourcesData(idImage, context))
    }

    Column(
        modifier = Modifier
            .padding(25.dp)
            .fillMaxSize()
            .safeDrawingPadding()
            .verticalScroll(rememberScrollState())
        //.wrapContentSize(Alignment.Center)
        //.border(width = 1.dp, color = Color.Black),
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween


    ) {


        Row(
            modifier = Modifier
                // .border(width = 1.dp, color = Color.Blue)
                //.padding(10.dp)
                //  .align(alignment = Alignment.TopCenter)

                .fillMaxWidth(),
            //.fillMaxHeight(1f)
            //.weight(1f)
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,


            ) {
            Surface(
                modifier = Modifier, shadowElevation = 8.dp,
            ) {
                RenderImageSection(objectResource)
            }
        }

        Row() {
            Text(
                text = "-" + objectResource.id + "-",
                fontSize = 45.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }

        Row(
            modifier = Modifier.background(color = Color.LightGray)
        ) {
            RenderTextSection(objectResource)
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RenderButton(onClick = {
                if (idImage > 1) {
                    idImage--
                }
            }, R.string.btn_previous, isEnable = idImage > 1)

            RenderButton(onClick = {
                if (idImage < 4) {
                    idImage++
                }
            }, R.string.btn_next, isEnable = idImage < 4)

            objectResource = ResourcesData(idImage, context)
        }
    }
}

@Composable
fun RenderImageSection(objectResource: ResourcesData) {

    Column(
        modifier = Modifier
            //.border(width = 2.dp, color= Color.Green)
            .padding(20.dp)
    ) {
        Image(
            painter = painterResource(id = objectResource.imageResourceId),
            contentDescription = "text",
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            contentScale = ContentScale.Crop

        )
    }
}

@Composable
fun RenderTextSection(objectResource: ResourcesData) {
    Column(
        modifier = Modifier
            //.border(width = 1.dp, color = Color.Green)
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Text(text = stringResource(id = objectResource.mainTextId), fontSize = 25.sp)

        Text(
            text = stringResource(id = objectResource.subTextId),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Text(
            text = "(" + stringResource(id = objectResource.yearTextId) + ")",
            fontStyle = FontStyle.Italic,
            fontSize = 15.sp
        )
    }
}

@Composable
fun RenderButton(onClick: () -> Unit, idText: Int, isEnable: Boolean = true) {
    Button(onClick = onClick, modifier = Modifier.width(150.dp), enabled = isEnable) {
        Text(text = stringResource(id = idText))
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        renderArtSpace()
    }
}