package com.moraiiiss.appburguer.Screen.PantallaPrincipal

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.moraiiiss.appburguer.data.BaseDatos
import com.moraiiiss.appburguer.data.Hamburguesas
import com.moraiiiss.appburguer.data.HamburguesaEntry
import com.moraiiiss.appburguer.app.RutasNavegacion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrincipalViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {

    private val _navegacion = MutableStateFlow<RutasNavegacion>(RutasNavegacion.PantallaPrincipal)
    val navegacion: StateFlow<RutasNavegacion> = _navegacion


}