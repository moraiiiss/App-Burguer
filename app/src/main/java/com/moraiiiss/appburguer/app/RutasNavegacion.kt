package com.moraiiiss.appburguer.app

sealed class RutasNavegacion(val ruta: String) {


    object PantallaPrincipal : RutasNavegacion("PantallaPrincipal")
    object PantallaInformacion : RutasNavegacion("PantallaInformacion")
    object PantallaDetallesHambuguesa : RutasNavegacion("PantallaDetallesHambuguesa")
    object PantallaPedido : RutasNavegacion("PantallaPedido")

}