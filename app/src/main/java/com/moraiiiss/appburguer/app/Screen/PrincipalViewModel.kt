package com.moraiiiss.appburguer.app.Screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moraiiiss.appburguer.R
import com.moraiiiss.appburguer.data.Hamburguesas
import com.moraiiiss.appburguer.data.RutasNavegacion
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PrincipalViewModel @Inject constructor() : ViewModel() {

    private val _hamburguesas = MutableLiveData<List<Hamburguesas>>()//creamos un livedata mutable
    val hamburguesas: LiveData<List<Hamburguesas>> = _hamburguesas//creamos un livedata inmutable

    private val _navegacion = MutableLiveData<RutasNavegacion>()//creamos un livedata mutable
    val navegacion: LiveData<RutasNavegacion> = _navegacion //creamos un livedata inmutable


    init {//inicializamos el livedata
        _hamburguesas.value = getHamburguersas()//le damos el valor de la lista de hamburguesas
    }

    private fun getHamburguersas(): List<Hamburguesas> { //creamos una lista de hamburguesas
        return listOf(
            Hamburguesas(1, "California", "Carne", 12.5f, R.drawable.california),
            Hamburguesas(2, "King Buffalo", "Carne", 13.5f, R.drawable.kingbuffalo),
            Hamburguesas(3, "The Ultimate", "Carne", 15.0f, R.drawable.theultimate),
            Hamburguesas(4, "Iberian Burger", "Carne", 15.0f, R.drawable.iberianburger),
            Hamburguesas(5, "Le Poulet", "Pollo", 10.5f, R.drawable.poulet),
            Hamburguesas(6, "Vegan Burger", "Vegana", 11.9f, R.drawable.vegana),
        )
    }
}