package com.example.mytabata

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
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
                    Counter(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun Counter(modifier: Modifier) {
    var mostrarPantalla by remember { mutableStateOf(true) }
    var mostrarPantallaGetReady by remember { mutableStateOf(true) }
    var mostrarPantallaWork by remember { mutableStateOf(true) }
    var mostrarPantallaRest by remember { mutableStateOf(true) }
    var sets by remember { mutableStateOf(0) }

    var tiempoRest by remember { mutableStateOf(0L) }
    var miConterDownRest by remember{ mutableStateOf(CounterDown(tiempoRest) { newvalue ->
        tiempoRest = newvalue
        if (tiempoRest == 0L) {
            mostrarPantallaRest = false
            sets -= 1
        }
    })}

    var tiempoWork by remember { mutableStateOf(0L) }
    Log.i("Prueba", tiempoWork.toString())
    var miConterDownWork by remember{ mutableStateOf(CounterDown(tiempoWork) { newvalue ->
        tiempoWork = newvalue
        if (tiempoWork == 0L) {
            mostrarPantallaWork = false
        }
    })}

    var theCounter by remember { mutableStateOf(10L) }
    var miConterDown by remember{ mutableStateOf(CounterDown(theCounter) { newvalue ->
        theCounter = newvalue
        if (theCounter == 0L) {
            mostrarPantallaGetReady = false
        }
    })}
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
                        modifier = Modifier.run {
                            clickable{
                                if (sets > 0){
                                    sets--
                                }
                            }
                                .padding(10.dp)
                        },
                        text = "-"
                    )
                    Text(
                        text = sets.toString(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        modifier = Modifier.run {
                            clickable{
                                if (sets >= 0){
                                    sets++
                                }
                            }
                                .padding(10.dp)
                        },
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
                        modifier = Modifier.run {
                            clickable{
                                if (tiempoWork > 0){
                                    tiempoWork--
                                }
                            }
                                .padding(10.dp)
                        },
                        text = "-",
                    )
                    Text(
                        text = tiempoWork.toString(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        modifier = Modifier.run {
                            clickable{
                                if (tiempoWork >= 0){
                                    tiempoWork++
                                }
                            }
                                .padding(10.dp)
                        },
                        text = "+",
                    )
                }
                Row {
                    Text(
                        text = "Rest",
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
                        modifier = Modifier.run {
                            clickable{
                                if (tiempoRest > 0){
                                    tiempoRest--
                                }
                            }
                                .padding(10.dp)
                        },
                        text = "-"
                    )
                    Text(
                        text = tiempoRest.toString(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        modifier = Modifier.run {
                            clickable{
                                if (tiempoRest >= 0){
                                    tiempoRest++
                                }
                            }
                                .padding(10.dp)
                        },
                        text = "+"
                    )
                }
            }
        }
        Row {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    mostrarPantalla = false
                }
            ) {
                Text(
                text = "⚡ START"
                )
            }
       }
    }
    @Composable
    fun PantallaGetReady() {
        Column (
            modifier = Modifier
                .background(Color(0xFFffaf42))
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row {
                Text(
                    text = sets.toString(),
                    fontSize = 40.sp,
                )
            }
            Row {
                Text(
                    text = theCounter.toString(),
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
                        miConterDown.toggle()
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
    fun PantallaWork(modifier: Modifier = Modifier){
        Column (
            modifier = Modifier
                .background(Color(0xFF44e372))
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row {
                Text(
                    text = sets.toString(),
                    fontSize = 40.sp,
                )
            }
            Row {
                Text(
                    text = tiempoWork.toString(),
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
                        miConterDownWork.toggle()
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
    fun PantallaRest(modifier: Modifier = Modifier){
        Column (
            modifier = Modifier
                .background(Color(0xFF2196F3))
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row {
                Text(
                    text = sets.toString(),
                    fontSize = 40.sp,
                )
            }
            Row {
                Text(
                    text = tiempoRest.toString(),
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
                        miConterDownRest.toggle()
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
    if (!mostrarPantalla){
        PantallaGetReady()
    }
    if (!mostrarPantallaGetReady){
        miConterDownWork = CounterDown(tiempoWork) { newvalue ->
            tiempoWork = newvalue
            if (tiempoWork == 0L) {
                mostrarPantallaWork = false
            }
        }
        PantallaWork()
    }
    if (!mostrarPantallaWork){
        miConterDownRest = CounterDown(tiempoRest){ newvalue ->
            tiempoRest = newvalue
            if (tiempoRest == 0L) {
                mostrarPantallaRest = false
                sets -= 1
                if (sets > 0) {
                    mostrarPantallaGetReady = true // Reinicia a la pantalla de preparación si aún hay sets
                    tiempoWork = tiempoWork
                    tiempoRest = tiempoRest
                }
            }
        }
        PantallaRest()
    }
//    if (!mostrarPantallaRest) {
//        PantallaGetReady()
//    }
}


