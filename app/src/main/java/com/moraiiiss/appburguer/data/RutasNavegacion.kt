package com.moraiiiss.appburguer.data

sealed class RutasNavegacion(val ruta: String) {
    object PantallaPrincipal : RutasNavegacion("PantallaPrincipal")
    object PantallaInformacion : RutasNavegacion("PantallaInformacion")
    object pantallaBurguer1 : RutasNavegacion("pantallaBurger1/{idNavegacion}") {

    }
}