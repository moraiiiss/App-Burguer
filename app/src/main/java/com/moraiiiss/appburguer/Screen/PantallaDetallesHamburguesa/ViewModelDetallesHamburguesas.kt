package com.moraiiiss.appburguer.Screen.PantallaDetallesHamburguesa

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
    private val hamburguesasRepository: HamburguesasRepository
) : ViewModel() {

    //mostrar hamburguesas
    private val _hamburguesas = MutableStateFlow<List<Hamburguesas>>(emptyList())
    val hamburguesas: StateFlow<List<Hamburguesas>> = _hamburguesas

    init {
        viewModelScope.launch {
            _hamburguesas.value = hamburguesasRepository.obtenerTodasHamburguesas()
        }
    }

}