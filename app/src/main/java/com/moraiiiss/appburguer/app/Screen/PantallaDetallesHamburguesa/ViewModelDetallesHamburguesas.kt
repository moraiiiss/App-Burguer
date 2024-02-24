package com.moraiiiss.appburguer.app.Screen.PantallaDetallesHamburguesa

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.moraiiiss.appburguer.data.BaseDatos
import com.moraiiiss.appburguer.data.HamburguesaEntry
import com.moraiiiss.appburguer.data.Hamburguesas
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelDetallesHamburguesas @Inject constructor(application: Application) : AndroidViewModel(application) {
    private val dbHelper = BaseDatos(application)

    private val _hamburguesas = MutableStateFlow<List<Hamburguesas>>(emptyList())
    val hamburguesas: StateFlow<List<Hamburguesas>> = _hamburguesas

    init {
        _hamburguesas.value = getHamburguersas()//le damos el valor de la lista de hamburguesas
        cargarHamburguesas()//cargamos las hamburguesas
    }

    private fun getHamburguersas(): List<Hamburguesas> {
        val db = dbHelper.readableDatabase

        val projection = arrayOf( //creamos un array con las columnas de la base de datos
            HamburguesaEntry.COLUMN_ID,
            HamburguesaEntry.COLUMN_NOMBRE,
            HamburguesaEntry.COLUMN_TIPO,
            HamburguesaEntry.COLUMN_PRECIO,
            HamburguesaEntry.COLUMN_IMAGEN
        )

        val cursor = db.query( //creamos un cursor para recorrer la base de datos
            HamburguesaEntry.TABLE_NAME,
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
                val id = getInt(getColumnIndexOrThrow(HamburguesaEntry.COLUMN_ID))
                val nombre = getString(getColumnIndexOrThrow(HamburguesaEntry.COLUMN_NOMBRE))
                val tipo = getString(getColumnIndexOrThrow(HamburguesaEntry.COLUMN_TIPO))
                val precio = getFloat(getColumnIndexOrThrow(HamburguesaEntry.COLUMN_PRECIO))
                val imagen = getInt(getColumnIndexOrThrow(HamburguesaEntry.COLUMN_IMAGEN))
                hamburguesas.add(Hamburguesas(id, nombre, tipo, precio, imagen))
            }
        }
        cursor.close() //cerramos el cursor


        return hamburguesas
    }

    fun cargarHamburguesas() {
        viewModelScope.launch {
            val hamburguesas = dbHelper.obtenerTodasLasHamburguesas()
            _hamburguesas.value = hamburguesas
        }
    }
}