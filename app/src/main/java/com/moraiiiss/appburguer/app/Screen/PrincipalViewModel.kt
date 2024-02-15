package com.moraiiiss.appburguer.app.Screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.moraiiiss.appburguer.R
import com.moraiiiss.appburguer.data.BaseDatos
import com.moraiiiss.appburguer.data.Hamburguesas
import com.moraiiiss.appburguer.data.HamburguesasEntry
import com.moraiiiss.appburguer.data.RutasNavegacion
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PrincipalViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {

    private val dbHelper = BaseDatos(application)

    private val _hamburguesas = MutableLiveData<List<Hamburguesas>>()//creamos un livedata mutable
    val hamburguesas: LiveData<List<Hamburguesas>> = _hamburguesas//creamos un livedata inmutable

    private val _navegacion = MutableLiveData<RutasNavegacion>()//creamos un livedata mutable
    val navegacion: LiveData<RutasNavegacion> = _navegacion //creamos un livedata inmutable

    init {//inicializamos el livedata
        _hamburguesas.value = getHamburguersas()//le damos el valor de la lista de hamburguesas
    }

    private fun getHamburguersas(): List<Hamburguesas> {
        val db = dbHelper.readableDatabase

        val projection = arrayOf( //creamos un array con las columnas de la base de datos
            HamburguesasEntry.COLUMN_ID,
            HamburguesasEntry.COLUMN_NOMBRE,
            HamburguesasEntry.COLUMN_TIPO,
            HamburguesasEntry.COLUMN_PRECIO,
            HamburguesasEntry.COLUMN_IMAGEN
        )

        val cursor = db.query( //creamos un cursor para recorrer la base de datos
            HamburguesasEntry.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null
        )

        val hamburguesas = mutableListOf<Hamburguesas>()//creamos una lista mutable de hamburguesas
        with(cursor) {//creamos un bucle para recorrer el cursor
            while (moveToNext()) {//recorremos el cursor
                val id = getInt(getColumnIndexOrThrow(HamburguesasEntry.COLUMN_ID))
                val nombre = getString(getColumnIndexOrThrow(HamburguesasEntry.COLUMN_NOMBRE))
                val tipo = getString(getColumnIndexOrThrow(HamburguesasEntry.COLUMN_TIPO))
                val precio = getFloat(getColumnIndexOrThrow(HamburguesasEntry.COLUMN_PRECIO))
                val imagen = getInt(getColumnIndexOrThrow(HamburguesasEntry.COLUMN_IMAGEN))
                hamburguesas.add(Hamburguesas(id, nombre, tipo, precio, imagen))
            }
        }
        cursor.close() //cerramos el cursor
        db.close() //cerramos la base de datos

        return hamburguesas
    }
}