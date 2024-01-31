package com.moraiiiss.appburguer.app

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moraiiiss.appburguer.R
import com.moraiiiss.appburguer.data.Hamburguesas


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PantallaPrincipal(abreHamburguesas: (Int) -> Unit, navegacionFuncion: () -> Unit) {


    Scaffold(
        containerColor = Color(0xFFF5E1DA),
        contentColor = Color(0xFFE6AB30),
        topBar = { TopBarPantallaPrincipal(navegacionFuncion) },
        bottomBar = { NavigationBar() },
        floatingActionButton = { BotonFloating() },
        floatingActionButtonPosition = FabPosition.End,


        ) { innerPadding ->
        ContenidoPaginaPrincipal(modifier = Modifier.padding(innerPadding), abreHamburguesas = abreHamburguesas)
    }


}

@Preview
@Composable
fun ViewPantallaPrincipal() {

    PantallaPrincipal(abreHamburguesas = {}, navegacionFuncion = { })

}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBarPantallaPrincipal(navegacionFuncion: () -> Unit) {
    TopAppBar(modifier = Modifier
        .background(color = Color(0xFF8D6E63))
        .padding(5.dp),


        title = {
            val offset = Offset(4.0f, 6.0f)

            Text(

                text = "App Burger",
                textAlign = TextAlign.Center,
                fontSize = 35.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontSize = 24.sp, shadow = Shadow(
                        color = Color(0xFFE6AB30), offset = offset, blurRadius = 5f
                    )


                )
            )
        }, colors = TopAppBarDefaults.topAppBarColors(
            Color(0xFF8D6E63), navigationIconContentColor = Color(
                0xFF000000
            )
        ),

        actions = {
            IconButton(onClick = { navegacionFuncion() }) {//boton para ver el pedido del cliente
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Pedido cliente",
                    tint = Color(0xFFE6AB30),
                    modifier = Modifier
                        .height(28.dp)
                        .width(50.dp)
                )
            }
            IconButton(onClick = { /*TODO*/ }) { //boton para acceso de la cuenta del cliente
                Icon(
                    imageVector = Icons.Default.AccountCircle,
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
fun NavigationBar() {
    NavigationBar(
        containerColor = Color(0xFF8D6E63), tonalElevation = 40.dp, modifier = Modifier.height(5.dp)

    ) {


    }
}

@Composable
fun BotonFloating() {
    FloatingActionButton(
        onClick = { },
        containerColor = Color(0xFFE6AB30),


        ) {
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = "pedido",
            tint = Color.Black,
            modifier = Modifier
                .height(30.dp)
                .width(40.dp)
        )
    }
}

@Composable
fun ContenidoPaginaPrincipal(modifier: Modifier = Modifier, abreHamburguesas: (Int) -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()

    ) {

        // Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = ShapeDefaults.ExtraLarge,
            border = BorderStroke(1.dp, Color(0xFFE6AB30))


        ) {
            Text(
                text = "Bienvenido a App Burger",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF8D6E63)
            )
        }

        TextoPredeterminado(
            "Pincha dentro de la Hamburguesa ", modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        )

        ListasHamburguesas(abreHamburguesas = abreHamburguesas)
    }
}


@Composable
fun ListasHamburguesas(abreHamburguesas: (Int) -> Unit) {
    val hamburguesasList = gethamburguersas()

    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        items(hamburguesasList) { hamburguesa ->
            VistaHamburguesas(hamburguesas = hamburguesa, abreHamburguesas)
        }
    }
}

@Composable
fun VistaHamburguesas(hamburguesas: Hamburguesas, abreHamburguesas: (Int) -> Unit) {
    Card(modifier = Modifier
        .width(200.dp)
        .clickable { abreHamburguesas(hamburguesas.idNavegacion) }
        .padding(10.dp)
        .border(2.dp, color = Color(0xFFE6AB30), shape = ShapeDefaults.Large)) {
        Column(modifier = Modifier.padding(9.dp)) {
            Image(
                painter = painterResource(id = hamburguesas.imagen),
                contentDescription = "Imagen de la Hamburguesa",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop,

                )
            Text(
                text = hamburguesas.nombre,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontSize = 15.sp)) {
                        append(String.format("%.2f", hamburguesas.precio))
                    }
                    append("€")
                }, modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 8.sp
            )
            Text(
                text = hamburguesas.tipo,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 10.sp
            )
        }

    }
}


fun gethamburguersas(): List<Hamburguesas> {//Lista de hamburguesas
    return listOf(
        Hamburguesas(1, "California", "Carne", 12.5f, R.drawable.california),
        Hamburguesas(2, "King Buffalo", "Carne", 13.5f, R.drawable.kingbuffalo),
        Hamburguesas(3, "The Ultimate", "Carne", 15.0f, R.drawable.theultimate),
        Hamburguesas(4, "Iberian Burger", "Carne", 15.0f, R.drawable.iberianburger),
        Hamburguesas(5, "Le Poulet", "Pollo", 10.5f, R.drawable.poulet),
        Hamburguesas(6, "Vegan Burger", "Vegana", 11.9f, R.drawable.vegana),
    )

}

@Composable
fun TextoPredeterminado(texto: String, modifier: Modifier = Modifier) {
    Text(text = texto, modifier = modifier, color = Color.Black)
}