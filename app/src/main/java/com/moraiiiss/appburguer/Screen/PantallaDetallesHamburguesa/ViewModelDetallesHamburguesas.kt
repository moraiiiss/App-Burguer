package com.moraiiiss.appburguer.Screen.PantallaDetallesHamburguesa

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moraiiiss.appburguer.data.Hamburguesas
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelDetallesHamburguesas @Inject constructor(
    private val hamburguesasRepository: HamburguesasRepository,
    //private val savedStateHandle: SavedStateHandle

) : ViewModel() {

   // private val id: String = checkNotNull(savedStateHandle["id"])




    //mostrar hamburguesas
    private var _state: List<Hamburguesas> = emptyList()

    val state
        get() = _state

    init {
        viewModelScope.launch {
            _state = hamburguesasRepository.obtenerTodasHamburguesas()
        }
    }

}