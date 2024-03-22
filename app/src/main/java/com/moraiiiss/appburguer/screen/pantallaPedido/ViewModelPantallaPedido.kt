package com.moraiiiss.appburguer.screen.pantallaPedido

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.moraiiiss.appburguer.data.Pedido
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ViewModelPantallaPedido @Inject constructor(application: Application) : AndroidViewModel(application) {

    private val _pedido = MutableStateFlow(emptyList<Pedido>())
    val pedido: StateFlow<List<Pedido>> = _pedido
}