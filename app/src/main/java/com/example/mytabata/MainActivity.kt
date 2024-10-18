package com.example.mytabata

import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytabata.ui.theme.MytabataTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MytabataTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TerceraPantalla(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Counter(modifier: Modifier = Modifier) {
    var theCounter by remember { mutableStateOf(0L) }
    var miConterDown by remember{ mutableStateOf(CounterDown(99, {newvalue -> theCounter = newvalue}))}
    Column (
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
    ){
        Row {
            Text(
                text = "QuickStart",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }
        Row {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ){
                Row {
                    Text(
                        text = "Sets",
                        fontSize = 15.sp,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
                Row (
                    modifier = Modifier
                        .padding(bottom = 30.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ){
                    Text(
                        text = "-"
                    )
                    Text(
                        text = "6",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "+"
                    )
                }
                Row {
                    Text(
                        text = "Work",
                        fontSize = 15.sp,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
                Row (
                    modifier = Modifier
                        .padding(bottom = 30.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ){
                    Text(
                        text = "-"
                    )
                    Text(
                        text = "6",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "+"
                    )
                }
                Row {
                    Text(
                        text = "Reset",
                        fontSize = 15.sp,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
                Row (
                    modifier = Modifier
                        .padding(bottom = 30.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ){
                    Text(
                        text = "-"
                    )
                    Text(
                        text = "6",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "+"
                    )
                }
            }
        }
        Row {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    miConterDown.toggle()
                }
            ) {
                Text(
                text = "⚡ START"
                )
            }
       }
    }
}

@Composable
fun PrimeraPantalla(modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier
            .background(Color(0xFFffaf42))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row {
            Text(
                text = "6",
                fontSize = 40.sp,
            )
        }
        Row {
            Text(
                text = "10:00",
                fontSize = 80.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row {
            Text(
                text = "GET READY",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.alpha(0.5f)
            )
        }
        Row (
            modifier = Modifier
                .width(90.dp)
                .height(90.dp)
        ){
            TextButton(
                onClick = {
                    println("hola")
                }
            ) {
                Text(
                    modifier = Modifier,
                    text = "⏸",
                    fontSize = 65.sp,
                    textAlign = TextAlign.Center

                )
            }
        }
    }
}
@Composable
fun SegundaPantalla(modifier: Modifier = Modifier){
    Column (
        modifier = Modifier
            .background(Color(0xFF44e372))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row {
            Text(
                text = "6",
                fontSize = 40.sp,
            )
        }
        Row {
            Text(
                text = "10:00",
                fontSize = 80.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row {
            Text(
                text = "WORK",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.alpha(0.5f)
            )
        }
        Row (
            modifier = Modifier
                .width(90.dp)
                .height(90.dp)
        ){
            TextButton(
                onClick = {
                    println("hola")
                }
            ) {
                Text(
                    modifier = Modifier,
                    text = "⏸",
                    fontSize = 65.sp,
                    textAlign = TextAlign.Center

                )
            }
        }
    }
}
@Composable
fun TerceraPantalla(modifier: Modifier = Modifier){
    Column (
        modifier = Modifier
            .background(Color(0xFF2196F3))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row {
            Text(
                text = "6",
                fontSize = 40.sp,
            )
        }
        Row {
            Text(
                text = "10:00",
                fontSize = 80.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row {
            Text(
                text = "REST",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.alpha(0.5f)
            )
        }
        Row (
            modifier = Modifier
                .width(90.dp)
                .height(90.dp)
        ){
            TextButton(
                onClick = {
                    println("hola")
                }
            ) {
                Text(
                    modifier = Modifier,
                    text = "⏸",
                    fontSize = 65.sp,
                    textAlign = TextAlign.Center

                )
            }
        }
    }
}






//    Column {
//        Text(
//            text = theCounter.toString(),
//            modifier = Modifier,
//        )
//        Button(
//            onClick = {
//                miConterDown.toggle()
//            }
//        ) {
//            Text(
//                text = "Iniciar"
//            )
//        }
//    }




