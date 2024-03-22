package com.moraiiiss.appburguer.screen.pantallaDetallesHamburguesa

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

    fun obtenerHamburguesasLocal() = hamburguesas

    //Funcion para obtener todas las hamburguesas
    @SuppressLint("Range")
    fun obtenerTodasHamburguesas(): List<Hamburguesas> {
        val cursor = db.query(
            HamburguesasDBScheme.TABLE_NAME,
            arrayOf(
                HamburguesasDBScheme.COLUMN_ID,
                HamburguesasDBScheme.COLUMN_NOMBRE,
                HamburguesasDBScheme.COLUMN_TIPO,
                HamburguesasDBScheme.COLUMN_PRECIO,
                HamburguesasDBScheme.COLUMN_IMAGEN
            ),
            null,null,null,null,null
            )
        val hamburguesas = mutableListOf<Hamburguesas>()
        with(cursor) {
            while (moveToNext()) {
                val itemId = Hamburguesas(
                    getInt(getColumnIndexOrThrow(HamburguesasDBScheme.COLUMN_ID)),
                    getString(getColumnIndexOrThrow(HamburguesasDBScheme.COLUMN_NOMBRE)),
                    getString(getColumnIndexOrThrow(HamburguesasDBScheme.COLUMN_TIPO)),
                    getFloat(getColumnIndexOrThrow(HamburguesasDBScheme.COLUMN_PRECIO)),
                    getInt(getColumnIndexOrThrow(HamburguesasDBScheme.COLUMN_IMAGEN))
                )
                hamburguesas.add(itemId)
            }
        }
        cursor.close()

        return hamburguesas.toList()


    }




}
