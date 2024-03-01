package com.moraiiiss.appburguer.Screen.PantallaPrincipal

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.moraiiiss.appburguer.app.RutasNavegacion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PrincipalViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {

    private val _navegacion = MutableStateFlow<RutasNavegacion>(RutasNavegacion.PantallaPrincipal)
    val navegacion: StateFlow<RutasNavegacion> = _navegacion


}