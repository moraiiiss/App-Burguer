package com.moraiiiss.appburguer.app

sealed class RutasNavegacion(val ruta: String) {
    object PantallaPrincipal : RutasNavegacion("PantallaPrincipal")
    object PantallaInformacion : RutasNavegacion("PantallaInformacion")
    object PantallaBurguerCalifornia : RutasNavegacion("PantallaBurguerCalifornia")

    object PantallaBurguerKingBuffalo : RutasNavegacion("PantallaBurguerKingBuffalo")
    object PantallaDetallesHambuguesa : RutasNavegacion("PantallaDetallesHambuguesa")

}