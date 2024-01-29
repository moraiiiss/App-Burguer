package com.moraiiiss.appburguer.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.moraiiiss.appburguer.R
import com.moraiiiss.appburguer.data.RutasNavegacion


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = getColor(R.color.marron) //color para la parte de notificaciones del terminal

            val controlNavegacion = rememberNavController()

            NavHost(navController = controlNavegacion , startDestination = RutasNavegacion.PantallaPrincipal.ruta){
                composable(RutasNavegacion.PantallaPrincipal.ruta) { PantallaPrincipal(controlNavegacion)}
                composable(RutasNavegacion.PantallaInformacion.ruta) { PantallaInformation(controlNavegacion)}

            }

        }
    }
}




