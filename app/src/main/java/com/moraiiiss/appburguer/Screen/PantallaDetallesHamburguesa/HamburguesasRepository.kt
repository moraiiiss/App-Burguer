package com.moraiiiss.appburguer.Screen.PantallaDetallesHamburguesa

import android.database.sqlite.SQLiteDatabase
import com.moraiiiss.appburguer.R
import com.moraiiiss.appburguer.data.Hamburguesas
import javax.inject.Inject

class HamburguesasRepository @Inject constructor(
    private val db: SQLiteDatabase
) {

    //Creacion de Hamburguesas
    var hamburguesas = mutableListOf(
        Hamburguesas(
            1, "Hamburguesa Poulet", "Pollo", 5.5f, R.drawable.poulet
        ),
        Hamburguesas(
            2, "Hamburguesa California", "Ternera", 8.5f, R.drawable.california
        ),
        Hamburguesas(
            3, "Hamburguesa Buffalo", "Carne", 9.5f, R.drawable.kingbuffalo
        ),
        Hamburguesas(
            4, "Hamburguesa Vegana", "Vegana", 12.5f, R.drawable.vegana
        ),
        Hamburguesas(
            5, "Hamburguesa TheUltimate", "Ternera", 10.5f, R.drawable.theultimate
        ),
        Hamburguesas(
            6, "Hamburguesa IberianBurger", "Verduras", 13.9f, R.drawable.iberianburger
        )
    )
    //Funcion para obtener una hamburguesa
    fun obtenerHamburguesa(id: Int): Hamburguesas {
        return hamburguesas[id - 1]
    }

    //Funcion para obtener todas las hamburguesas
    fun obtenerTodasHamburguesas(): List<Hamburguesas> {
        return hamburguesas
    }




}
