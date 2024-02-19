package com.moraiiiss.appburguer.app.Screen.PantallaInformacion

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun PantallaInformation(navegacionFuncion: () -> Unit) {
    Scaffold(
        containerColor = Color(0xFFF5E1DA),
        contentColor = Color(0xFFE6AB30),
        topBar = { TopBarPantallaInformation(navegacionFuncion) },

    ) { innerPadding ->
        // Contenido de la pantalla

        ContenidoPaginaInformacion( modifier = Modifier.padding(innerPadding))
    }
}
@Preview
@Composable

fun ViewPantallaInformation() {
    PantallaInformation {

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarPantallaInformation(navegacionFuncion: () -> Unit) {
    TopAppBar(
        title = {
            val offset = Offset(4.0f, 6.0f)

            Text(
                text = "Sobre Nosotros",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(
                        Alignment.Center
                    ),
                fontSize = 35.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontSize = 24.sp, shadow = Shadow(
                        color = Color(0xFFE6AB30), offset = offset, blurRadius = 5f
                    )


                )
            )
        },
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
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF8D6E63),
            navigationIconContentColor = Color(0xFF000000)
        )


    )
}

@Composable
fun ContenidoPaginaInformacion(modifier: Modifier = Modifier) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Card(
            modifier = Modifier
                .width(350.dp)
                .clip(shape = RoundedCornerShape(5.dp))
                .verticalScroll(state = ScrollState(0))

        ) {


            Text(
                modifier = Modifier.padding(10.dp),
                fontSize = 20.sp,
                text = "Bienvenidos a \"AppBurger\", nuestro rincón delicioso en el mundo de las hamburguesas. Somos un equipo apasionado por la creación de experiencias gastronómicas únicas y deliciosas.\n" +
                        "\n" +
                        "En \"AppBurger\", no solo se trata de hamburguesas, sino de una fusión de sabores, texturas y emociones que te transportarán a un viaje culinario inolvidable. Cada hamburguesa que preparamos es el resultado de cuidadosa selección de ingredientes frescos y de la dedicación de nuestro talentoso equipo de chefs.\n" +
                        "\n" +
                        "Nos enorgullece ofrecer una variedad de opciones, desde las clásicas hamburguesas americanas hasta creaciones innovadoras y saludables para satisfacer todos los gustos y preferencias. Nuestro compromiso con la calidad, la creatividad y la hospitalidad es lo que nos impulsa a brindarte la mejor experiencia de hamburguesas.\n" +
                        "\n" +
                        "Agradecemos tu visita y esperamos que disfrutes cada bocado tanto como disfrutamos nosotros al crear estas delicias. ¡Bienvenido a \"AppBurger\", donde cada hamburguesa cuenta una historia única de sabor y pasión!\n"
            )
        }
    }

}

