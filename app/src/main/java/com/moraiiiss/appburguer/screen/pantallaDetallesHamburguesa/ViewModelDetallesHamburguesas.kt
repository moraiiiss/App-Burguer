package com.moraiiiss.appburguer.screen.pantallaDetallesHamburguesa

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moraiiiss.appburguer.R
import com.moraiiiss.appburguer.data.Hamburguesas
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelDetallesHamburguesas @Inject constructor(
    private val hamburguesasRepository: HamburguesasRepository,
    private val savedStateHandle: SavedStateHandle

) : ViewModel() {

    private val id: Int = checkNotNull(savedStateHandle["id"])

    //mostrar hamburguesas
    private var _state = MutableStateFlow<Hamburguesas>(
        Hamburguesas(
            idNavegacion = 0,
            nombre = "",
            tipo = "",
            precio = 0.0f,
            imagen = 0
        )
    )

    val state = _state

    init {
        viewModelScope.launch {
            _state.emit(hamburguesasRepository.obtenerHamburguesa(id))

        }
    }


}