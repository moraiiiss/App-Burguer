package com.moraiiiss.appburguer.data

import androidx.annotation.DrawableRes

data class Hamburguesas(
    var nombre: String,
    var tipo: String,
    var precio: Float,
    @DrawableRes var imagen: Int
) {


}
