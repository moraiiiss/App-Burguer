package com.moraiiiss.appburguer.screen.pantallaPrincipal

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moraiiiss.appburguer.data.Hamburguesas
import com.moraiiiss.appburguer.screen.RutasNavegacion
import com.moraiiiss.appburguer.screen.pantallaDetallesHamburguesa.HamburguesasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrincipalViewModel @Inject constructor(
    private val hamburguesasRepository: HamburguesasRepository
) : ViewModel() {

    private val _state = MutableStateFlow<List<Hamburguesas>>(emptyList())
    val state: StateFlow<List<Hamburguesas>> = _state

    init {
        viewModelScope.launch {
            _state.emit(hamburguesasRepository.obtenerHamburguesasLocal())
        }
    }



    private val _navegacion = MutableStateFlow<RutasNavegacion>(RutasNavegacion.PantallaPrincipal)
    val navegacion: StateFlow<RutasNavegacion> = _navegacion


}