package com.diamoncode.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diamoncode.businesscard.ui.theme.BusinesscardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinesscardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        name = "Wladimir Lopez", description = "Best Software Developer",
                        "+573 968 407668", "@chamoW", "warriorwl86@gmail.com"
                    )
                }
            }
        }
    }
}

@Composable
fun IconText(text: String, icon: ImageVector) {
    Row(modifier = Modifier.padding(top = 16.dp)) {
        Icon(imageVector = icon, contentDescription = null, tint = Color(0, 128, 255))
        Text(text = text, modifier = Modifier.padding(start = 4.dp))
    }
}

@Composable
fun ContactInfo(
    phone: String,
    social: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        IconText(phone, Icons.Rounded.Phone)
        IconText(social, Icons.Rounded.Share)
        IconText(email, Icons.Rounded.Email)
    }
}

@Composable
fun UserInfo(
    name: String, description: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = image, contentDescription = null,
            modifier = Modifier
                .background(color = Color(0, 102, 204))
                .height(120.dp)
                .width(120.dp)
        )

        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
        )
        Text(text = description, color = Color(0, 128, 255))
    }
}

@Composable
fun BusinessCard(
    name: String, description: String,
    phone: String,
    social: String,
    email: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = Color(153, 204, 255))
            .fillMaxSize()
    ) {

        Row(Modifier.weight(1f)) {
            UserInfo(
                name = name, description = description,
                modifier = Modifier
                    .align(alignment = Alignment.Bottom)
            )
        }

        Row(modifier = Modifier.weight(1f)) {
            ContactInfo(
                phone, social = social, email,
                Modifier
                    .padding(bottom = 36.dp)
                    .align(alignment = Alignment.Bottom)
            )
        }


    }


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinesscardTheme {
        //IconText("hola", Icons.Rounded.Menu)
        //ContactInfo("+573 968 407668", "@chamoW", "warriorwl86@gmail.com")

        //UserInfo(name = "Wladimir Lopez", description = "Best Software Developer")

        BusinessCard(
            name = "Wladimir Lopez", description = "Best Software Developer",
            "+573 968 407668", "@chamoW", "warriorwl86@gmail.com"
        )
    }
}