package com.example.artspace
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace () {
    var currentStep by remember { mutableStateOf(1) }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        when (currentStep) {
            1 -> {
                ArtSpaceWithImageDisplay(
                    drawableResourceId = R.drawable.painting1,
                    textLabelResourceId = R.string.painting_select,
                    textResource = R.string.painting_select1
                )
                Row(horizontalArrangement = Arrangement.spacedBy(0.dp,alignment = Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier.padding(bottom = 30.dp)){
                    Button(onClick = { currentStep = 4},
                        modifier = Modifier.padding(start = 0.dp, end = 50.dp)) {
                        Text(text = "Previous")
                    }
                    Button(onClick = { currentStep++},
                        modifier =Modifier.padding(20.dp,0.dp, 20.dp,0.dp)){
                        Text(text = "Next")
                    }
                }
                }
            2 -> {
                ArtSpaceWithImageDisplay(
                    drawableResourceId = R.drawable.painting2,
                    textLabelResourceId = R.string.painting_title,
                    textResource = R.string.painting_name
                )
                Row(horizontalArrangement = Arrangement.spacedBy(0.dp,alignment = Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier.padding(bottom = 30.dp)){
                    Button(onClick = { currentStep--},
                        modifier = Modifier.padding(start = 0.dp, end = 50.dp)) {
                        Text(text = "Previous")
                    }
                    Button(onClick = { currentStep++},
                        modifier =Modifier.padding(20.dp,0.dp, 20.dp,0.dp)){
                        Text(text = "Next")
                    }
                }
            }
            3 -> {
                ArtSpaceWithImageDisplay(
                    drawableResourceId = R.drawable.painting3,
                    textLabelResourceId = R.string.painting_title1,
                    textResource = R.string.painting_name1)
                Row(horizontalArrangement = Arrangement.spacedBy(0.dp,alignment = Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier.padding(bottom = 30.dp)){
                    Button(onClick = { currentStep--},
                        modifier = Modifier.padding(start = 0.dp, end = 50.dp)) {
                        Text(text = "Previous")
                    }
                    Button(onClick = { currentStep++},
                        modifier =Modifier.padding(20.dp,0.dp, 20.dp,0.dp)){
                        Text(text = "Next")
                    }
                }
            }
            4 -> {
                ArtSpaceWithImageDisplay(
                    drawableResourceId = R.drawable.painting4,
                    textLabelResourceId = R.string.painting_title2,
                    textResource = R.string.painting_name2)
                Row(horizontalArrangement = Arrangement.spacedBy(0.dp,alignment = Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier.padding(bottom = 30.dp)){
                    Button(onClick = { currentStep--},
                        modifier = Modifier.padding(start = 0.dp, end = 50.dp)) {
                        Text(text = "Previous")
                    }
                    Button(onClick = { currentStep = 1},
                        modifier =Modifier.padding(20.dp,0.dp, 20.dp,0.dp)){
                        Text(text = "Next")
                    }
                }



            }
            }

        }
    }

@Composable
fun ArtSpaceWithImageDisplay(
    drawableResourceId: Int,
    textLabelResourceId: Int,
    textResource: Int,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        Image(painter = painterResource(drawableResourceId), contentDescription = null,
            modifier
                .padding(20.dp)
                .border(border = BorderStroke(2.dp, Color.Gray), shape = RectangleShape)
                .height(350.dp)
                .width(300.dp)
                .shadow(elevation = 4.dp, shape = RectangleShape)
                .padding(20.dp))
        Card(modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp), elevation = 6.dp) {
            Column(modifier.padding(16.dp)) {
                Text(
                    text = stringResource(textLabelResourceId),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Light,
                )
                Text(
                    text = stringResource(textResource),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpace ()
    }
}