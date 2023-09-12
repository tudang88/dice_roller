package com.composebootcamp.dicee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.composebootcamp.dicee.ui.theme.DiceeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceeApp(Modifier)
                }
            }
        }
    }
}

@Composable
fun DiceeApp(modifier: Modifier = Modifier) {
    val lastNumber = remember{
        mutableStateOf(1)
    }
    val diceImageResource = when (lastNumber.value) {
        1->R.drawable.dice_1
        2->R.drawable.dice_2
        3->R.drawable.dice_3
        4->R.drawable.dice_4
        5->R.drawable.dice_5
        6->R.drawable.dice_6
        else->R.drawable.dice_1
    }
   Column(verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally) {
       Text(text = "Your Number:" + lastNumber.value)
       Image(painter = painterResource(id = diceImageResource), contentDescription = "dice image")
       Text(text = "Roll", modifier = Modifier
           .background(Color.Green, shape = RoundedCornerShape(5.dp)).padding(10.dp)
           .clickable { lastNumber.value = (1..6).random() }

       )
   }
}

@Preview(showBackground = true)
@Composable
fun DiceePreview() {
    DiceeTheme {
        DiceeApp()
    }
}