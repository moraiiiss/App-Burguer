package com.moraiiiss.appburguer.Screen.PantallaDetallesHamburguesa

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.moraiiiss.appburguer.Screen.PantallaPrincipal.NavigationBar
import com.moraiiiss.appburguer.Screen.PantallaPrincipal.PrincipalViewModel

@Composable
fun DetallesHamburguesaScreen(navegacionFuncion: () -> Unit, viewModelDetallesHamburguesas: ViewModelDetallesHamburguesas = hiltViewModel()) {
    Scaffold(
        containerColor = Color(0xFFF5E1DA),
        contentColor = Color(0xFFE6AB30),
        topBar = { TopBarPantallaDetalles(navegacionFuncion) },
        bottomBar = { NavigationBar() },

        ) { innerPadding ->
        DetallesHamburguesaContent(
            modifier = Modifier.padding(innerPadding),
            viewModelDetallesHamburguesas = hiltViewModel()
        )
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
            IconButton(onClick = {navegacionFuncion()}) {
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


@Composable
fun DetallesHamburguesaContent(modifier: Modifier, viewModelDetallesHamburguesas: ViewModelDetallesHamburguesas = hiltViewModel()) {
    Text(text = "Detalles de la hamburguesa", modifier = modifier)

}

@Preview
@Composable
fun ViewDetallesHamburguesa() {
    DetallesHamburguesaScreen(navegacionFuncion = {})
}