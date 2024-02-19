package com.moraiiiss.appburguer.app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.moraiiiss.appburguer.R
import com.moraiiiss.appburguer.app.Screen.PantallaBurguerCalifornia
import com.moraiiiss.appburguer.app.Screen.PantallaBurguerKingBuffalo
import com.moraiiiss.appburguer.app.Screen.PantallaInformacion.PantallaInformation
import com.moraiiiss.appburguer.app.Screen.PantallaPrincipal.PantallaPrincipal
import com.moraiiiss.appburguer.app.Screen.PantallaPrincipal.PrincipalViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val principalViewModel: PrincipalViewModel by viewModels()
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
                        abreHamburguesas = { id -> controlNavegacion.navigate("${RutasNavegacion.PantallaBurguerCalifornia.ruta}/$id") },
                        principalViewModel = principalViewModel
                    )
                }
                composable(RutasNavegacion.PantallaInformacion.ruta) {
                    PantallaInformation(navegacionFuncion = {
                        controlNavegacion.navigate(RutasNavegacion.PantallaPrincipal.ruta)
                    })
                }
                composable(
                    route = "${RutasNavegacion.PantallaBurguerCalifornia.ruta}/{id}",
                    arguments = listOf(navArgument("id") { type = NavType.IntType })
                ) { backStackEntry ->
                    val id = backStackEntry.arguments?.getInt("id") ?: 99
                    Log.d("MainActivity", "id: $id")
                    if (id % 2 == 0) {
                        PantallaBurguerCalifornia(id)
                    } else {
                        PantallaBurguerKingBuffalo(id)
                    }
                }
            }

        }
    }
}


