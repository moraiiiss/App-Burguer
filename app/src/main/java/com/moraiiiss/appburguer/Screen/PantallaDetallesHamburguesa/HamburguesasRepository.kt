package com.moraiiiss.appburguer.Screen.PantallaDetallesHamburguesa

import android.annotation.SuppressLint
import android.database.sqlite.SQLiteDatabase
import com.moraiiiss.appburguer.R
import com.moraiiiss.appburguer.data.Hamburguesas
import com.moraiiiss.appburguer.data.HamburguesasDBScheme
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
            4, "Hamburguesa VEGANAAA", "Vegana", 12.5f, R.drawable.vegana
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
    @SuppressLint("Range")
    fun obtenerTodasHamburguesas(): List<Hamburguesas> {
        val hamburguesas = mutableListOf<Hamburguesas>()
        val cursor = db.rawQuery("SELECT * FROM ${HamburguesasDBScheme.TABLE_NAME}", null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(HamburguesasDBScheme.COLUMN_ID))
                val nombre = cursor.getString(cursor.getColumnIndex(HamburguesasDBScheme.COLUMN_NOMBRE))
                val tipo = cursor.getString(cursor.getColumnIndex(HamburguesasDBScheme.COLUMN_TIPO))
                val precio = cursor.getFloat(cursor.getColumnIndex(HamburguesasDBScheme.COLUMN_PRECIO))
                val imagen = cursor.getInt(cursor.getColumnIndex(HamburguesasDBScheme.COLUMN_IMAGEN))

                val hamburguesa = Hamburguesas(id, nombre, tipo, precio, imagen)
                hamburguesas.add(hamburguesa)
            } while (cursor.moveToNext())
        }

        cursor.close()

        return hamburguesas
    }




}
