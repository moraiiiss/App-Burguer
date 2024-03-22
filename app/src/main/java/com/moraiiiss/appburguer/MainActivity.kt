package com.moraiiiss.appburguer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.moraiiiss.appburguer.screen.RutasNavegacion
import com.moraiiiss.appburguer.screen.pantallaDetallesHamburguesa.DetallesHamburguesaScreen
import com.moraiiiss.appburguer.screen.pantallaInformacion.PantallaInformation
import com.moraiiiss.appburguer.screen.pantallaPedido.PantallaPedidoScreen
import com.moraiiiss.appburguer.screen.pantallaPrincipal.PantallaPrincipalScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
                    PantallaPrincipalScreen(
                        navegacionFuncion = { controlNavegacion.navigate(RutasNavegacion.PantallaInformacion.ruta) },
                        navegacionFuncionPedido = { controlNavegacion.navigate(RutasNavegacion.PantallaPedido.ruta) },
                        abreHamburguesas = { id -> controlNavegacion.navigate("${RutasNavegacion.PantallaDetallesHambuguesa.ruta}/$id") },
                        viewModel = hiltViewModel()
                    )
                }
                composable(RutasNavegacion.PantallaInformacion.ruta) {
                    PantallaInformation(navegacionFuncion = {
                        controlNavegacion.navigate(RutasNavegacion.PantallaPrincipal.ruta)
                    })
                }
                composable(RutasNavegacion.PantallaPedido.ruta) {
                    PantallaPedidoScreen(
                        navegacionFuncion =
                        { controlNavegacion.navigate(RutasNavegacion.PantallaPrincipal.ruta) },
                    )
                }
                composable(
                    route = "${RutasNavegacion.PantallaDetallesHambuguesa.ruta}/{id}",
                    arguments = listOf(navArgument("id") { type = NavType.IntType })
                ) { backStackEntry ->
                    val id = backStackEntry.arguments?.getInt("id") ?: 99
                    Log.d("MainActivity", "id: $id")
                    DetallesHamburguesaScreen(navegacionFuncion = {
                        controlNavegacion.navigate(
                            RutasNavegacion.PantallaPrincipal.ruta
                        )
                    })
                }
            }
        }
    }
}



