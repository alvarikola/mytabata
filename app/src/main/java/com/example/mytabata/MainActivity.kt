package com.example.mytabata

import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
fun Counter(modifier: Modifier = Modifier) {
    var theCounter by remember { mutableStateOf("30") } // Estado del contador como String
    var counterState by remember { mutableStateOf(false) } // Para controlar el estado de ejecución del contador
    var myCounter: CountDownTimer? by remember { mutableStateOf(null) } // Temporizador declarado a nivel superior

    LaunchedEffect(Unit) {
        myCounter = object : CountDownTimer(30000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                theCounter = (theCounter.toInt() - 1).toString()
            }

            override fun onFinish() {
                counterState = false
            }
        }

        if (!counterState) {
            counterState = true
        }
    }

    Column(
        modifier = Modifier.padding(top = 20.dp)
            .fillMaxSize(),
    ) {
        Text(
            text = theCounter,
            modifier = Modifier,
        )
        Button(
            onClick = {
                if (counterState) {
                    myCounter?.cancel()
                    counterState = false
                } else {
                    myCounter?.start()
                    counterState = true
                }
            }
        ) {
            Text(
                text = "Iniciar"
            )
        }
    }
}