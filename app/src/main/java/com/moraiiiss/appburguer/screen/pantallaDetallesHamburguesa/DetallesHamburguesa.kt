package com.moraiiiss.appburguer.screen.pantallaDetallesHamburguesa

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.moraiiiss.appburguer.data.Hamburguesas
import com.moraiiiss.appburguer.screen.pantallaPrincipal.NavigationBar

@Composable
fun DetallesHamburguesaScreen(
    navegacionFuncion: () -> Unit,
    viewModelDetallesHamburguesas: ViewModelDetallesHamburguesas = hiltViewModel()
) {
    val state by viewModelDetallesHamburguesas.state.collectAsState()
    Scaffold(
        containerColor = Color(0xFFF5E1DA),
        contentColor = Color(0xFFE6AB30),
        topBar = { TopBarPantallaDetalles(navegacionFuncion) },
        bottomBar = { NavigationBar() },
    ) { innerPadding ->
        DetallesHamburguesaContent(
            modifier = Modifier.padding(innerPadding),
            burger = state
        )
    }
}

@Composable
fun DetallesHamburguesaContent(modifier: Modifier, burger: Hamburguesas) {
    val count = remember { mutableStateOf(0) } // Estado para llevar la cuenta de hamburguesas

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .border(2.dp, color = Color(0xFFE6AB30), shape = ShapeDefaults.Large)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Column {
                    Image(
                        painter = painterResource(id = burger.imagen),
                        contentDescription = "Imagen de la Hamburguesa",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "Selecciona la cantidad de Hamburguesas para añadirlo a tu pedido",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(8.dp),
                        fontSize = 20.sp // Ajusta el tamaño del texto a 20.sp
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        IconButton(onClick = { if (count.value > 0) count.value-- }) {
                            Text("-")
                        }
                        Text(text = count.value.toString())
                        IconButton(onClick = { count.value++ }) {
                            Text("+")
                        }
                    }
                    Button(
                        onClick = { /* TODO: Añadir al pedido */ },
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .height(50.dp)
                            .width(250.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Red,
                            contentColor = Color.Black
                        )
                    ) {
                        Text("Añadir al pedido", fontSize = 26.sp)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarPantallaDetalles(navegacionFuncion: () -> Unit) {

    TopAppBar(modifier = Modifier
        .background(color = Color(0xFF8D6E63))
        .padding(5.dp),


        title = {
            val offset = Offset(4.0f, 6.0f)

            Text(

                text = "Detalles de la hamburguesa",
                textAlign = TextAlign.Center,
                fontSize = 27.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontSize = 20.sp, shadow = Shadow(
                        color = Color(0xFFE6AB30), offset = offset, blurRadius = 5f
                    )


                )
            )
        }, colors = TopAppBarDefaults.topAppBarColors(
            Color(0xFF8D6E63), navigationIconContentColor = Color(
                0xFF000000
            )
        ),
        navigationIcon = {
            IconButton(onClick = { navegacionFuncion() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Atrás",
                    modifier = Modifier
                        .height(30.dp)
                        .width(40.dp)
                )
            }

        },

        actions = {

            IconButton(onClick = { /*TODO*/ }) { //boton para acceso de la cuenta del cliente
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Pedido cliente",
                    tint = Color(0xFFE6AB30),
                    modifier = Modifier
                        .height(28.dp)
                        .width(50.dp)
                )
            }


        })

}


@Preview
@Composable
fun ViewDetallesHamburguesa() {
    DetallesHamburguesaScreen(navegacionFuncion = {})
}