package com.oscargonles.bizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oscargonles.bizcard.ui.theme.BizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    SurfaceFullScreen {
        MainCard {
            ColumnTopCenterHorizontally {
                ImageProfile()
                Divider()
                CreateInfo()
            }
        }
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Oscar G.",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant
        )
        Text(
            text = "Android Compose Programmer",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            text = "oscargonles@gmail.com",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Composable
private fun ColumnTopCenterHorizontally(content: @Composable () -> Unit) {
    Column(
        modifier = Modifier.height(300.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
    }
}

@Composable
private fun ImageProfile() {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f),
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "Profile Image",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun MainCard(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
        shape = RoundedCornerShape(corner = CornerSize(size = 15.dp)),
        backgroundColor = Color.White,
        elevation = 4.dp
    ) {
        content()
    }
}

@Composable
private fun SurfaceFullScreen(content: @Composable () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BizCardTheme {
        CreateBizCard()
    }
}