package com.moraiiiss.appburguer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moraiiiss.appburguer.ui.theme.AppBurguerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Disenho()
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable

fun Disenho() { //funcion para el diseño de la página

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "App Burguer",
                        color = Color.Black
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Red,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )


            )

        }
    ) {padding ->
        Contenido(modifier = Modifier.padding(padding))
    }
}




@Composable
fun Contenido(modifier: Modifier = Modifier.padding(100.dp)) {
    Column(
        modifier = Modifier.run {
            fillMaxSize()
                .padding(16.dp)
        }
    ) {
        Text(
            text = "ssssssssssssssssssssssssssssssssssssss!",
            modifier = Modifier.padding(8.dp)
        )

        // Añadir texto adicional
        Text(
            text = "Texto adicional en el cuerpo de la aplicación.",
            modifier = Modifier.padding(8.dp)
        )
    }
}

