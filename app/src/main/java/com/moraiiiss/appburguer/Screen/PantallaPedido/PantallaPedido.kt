package com.moraiiiss.appburguer.Screen.PantallaPedido

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.moraiiiss.appburguer.data.Pedido

@Composable
fun PantallaPedidoScreen(
    navegacionFuncion: () -> Unit,
    viewModelPantallaPedido: ViewModelPantallaPedido = hiltViewModel()
) {
    Scaffold(
        containerColor = Color(0xFFF5E1DA),
        contentColor = Color(0xFFE6AB30),
        topBar = { TopBarPantallaPedido(navegacionFuncion) },

        ) { innerPadding ->
        PedidoContent(
            modifier = Modifier.padding(innerPadding), viewModelPantallaPedido = hiltViewModel()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarPantallaPedido(navegacionFuncion: () -> Unit) {
    TopAppBar(title = {
        val offset = Offset(4.0f, 6.0f)

        Text(
            text = "Resume de Pedido",
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(
                    Alignment.Center
                ),
            fontSize = 35.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                fontSize = 24.sp, shadow = Shadow(
                    color = Color(0xFFE6AB30), offset = offset, blurRadius = 5f
                )


            )
        )
    }, navigationIcon = {
        IconButton(onClick = { navegacionFuncion() }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Atrás",
                modifier = Modifier
                    .height(30.dp)
                    .width(40.dp)
            )
        }

    }, colors = TopAppBarDefaults.topAppBarColors(
        containerColor = Color(0xFF8D6E63), navigationIconContentColor = Color(0xFF000000)
    )


    )
}

@Composable
fun PedidoContent(modifier: Modifier, viewModelPantallaPedido: ViewModelPantallaPedido) {/*val pedidos by viewModelPantallaPedido.pedido.collectAsState()

    LazyColumn(modifier = modifier) {
        items(pedidos) { pedido ->
            Text(text = "Producto: ${pedido.producto}")
            Text(text = "Cantidad: ${pedido.cantidad}")
            Text(text = "Precio: ${pedido.precio}")
        }
    }*/

    var total = remember { mutableDoubleStateOf(0.0) }

    LazyColumn(modifier = modifier) {
        val pedidos = listOf(Pedido("hamburguesa", 15, 12.0)) // Aquí debes reemplazar la lista de pedidos con tus datos reales
        items(pedidos) { pedido ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Producto: ${pedido.producto}",
                        style = MaterialTheme.typography.headlineLarge
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Cantidad: ${pedido.cantidad}", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Precio: ${pedido.precio}", style = MaterialTheme.typography.bodyMedium)
                }
            }
            total.doubleValue = pedido.precio * pedido.cantidad
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Divider(thickness = 2.dp, color = Color(0xFF000000), modifier = Modifier.width(250.dp).padding(15.dp))

        Text(text = "Total: ${total.doubleValue}€", modifier = Modifier.padding(bottom = 16.dp), fontSize = 40.sp, color = Color(
            0xFF6B1009
        )
        )
        Divider(thickness = 2.dp, color = Color(0xFF000000), modifier = Modifier.width(250.dp).padding(15.dp))
        Button(
            onClick = {  },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color(0xFFE6AB30))
        ) {
            Text(text = "Confirmar Compra", color = Color.Black, fontSize = 20.sp)
        }
    }
}
