package com.moraiiiss.appburguer.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.fragment.app.FragmentManager.BackStackEntry
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.moraiiiss.appburguer.R
import com.moraiiiss.appburguer.data.RutasNavegacion


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor =
                getColor(R.color.marron) //color para la parte de notificaciones del terminal

            val controlNavegacion = rememberNavController()

            NavHost(
                navController = controlNavegacion,
                startDestination = RutasNavegacion.PantallaPrincipal.ruta
            ) {
                composable(RutasNavegacion.PantallaPrincipal.ruta) {
                    PantallaPrincipal(
                        navegacionFuncion = { controlNavegacion.navigate(RutasNavegacion.PantallaInformacion.ruta) },
                        abreHamburguesas = { idNavegacion -> controlNavegacion.navigate("${RutasNavegacion.PantallaInformacion.ruta}/$it") }

                    )
                }
                composable(RutasNavegacion.PantallaInformacion.ruta) {
                    PantallaInformation(navegacionFuncion = {
                        controlNavegacion.navigate(
                            RutasNavegacion.PantallaPrincipal.ruta
                        )
                    })
                }

                composable(
                    route = RutasNavegacion.pantallaBurguer1.ruta,
                    arguments = listOf(navArgument("idNavegacion"){ type = NavType.IntType})
                ) {backStackEntry ->
                    backStackEntry.arguments?.getInt("idNavegacion")
                    RutasNavegacion.pantallaBurguer1.ruta
                }


            }

        }
    }
}


