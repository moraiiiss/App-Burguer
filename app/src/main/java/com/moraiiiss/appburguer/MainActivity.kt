package com.moraiiiss.appburguer

import android.annotation.SuppressLint
import android.icu.text.ListFormatter.Width
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.TopAppBarDefaults.windowInsets
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moraiiiss.appburguer.ui.theme.AppBurguerTheme
import kotlin.math.E


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

fun Disenho() {
    AppBurguerTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Red,
                        titleContentColor = Color.Black,
                        actionIconContentColor = Color.Black,
                        navigationIconContentColor = Color.Black

                    ),
                    title = {//añadimos titulo
                        Text("App Burger",
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                            )
                    },
                    navigationIcon = {//añadimos iconos de navegacion
                        Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                    },
                    actions = {//añadimos un evento onclick para interactuar
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Search, contentDescription = null)
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Send, contentDescription = null)
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Settings, contentDescription = null)
                        }
                    },



                )
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .background(color = Color.DarkGray)
                ){
                    Spacer(modifier = Modifier.height(16.dp))//separamos con un espacio
                    Text("Bienvenido a App Burguer",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        color = Color.White

                    )
                    Spacer(modifier = Modifier.height(16.dp))//separamos con un espacio
                    Image(//añadimos la imagen
                        painter = painterResource(id = R.drawable.burguer),
                        contentDescription = "Imagen de hamburguesa",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(180.dp)
                            .background(Color.DarkGray)
                            .clip(CircleShape)

                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Lista de especialidades:",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    ListaElementos()
                }
            }
        )
    }
}
@Composable
fun ListaElementos() {
    val elementos = listOf("Hamburguesa California", "Hamburguesa Miami", "Hamburguesa San Francisco", "Hamburguesa The Goat")//añadimos los elementos

    LazyColumn (
        modifier = Modifier
            .fillMaxWidth()


    ){
        items(items = elementos) { elemento: String ->
            Text(elemento,
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    }
}
