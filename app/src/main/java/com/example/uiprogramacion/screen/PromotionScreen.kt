package com.example.uiprogramacion.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uiprogramacion.TipoCambio

@Composable
fun PromotionScreen(tipoCambio: TipoCambio) {
    Scaffold() {
            paddingValues -> PromotionContent(modifier = Modifier.padding(paddingValues),
        tipoCambio)
    }
}


@Composable
fun PromotionContent(modifier: Modifier, tipoCambio: TipoCambio){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "TC VENTA OFICIAL")
        Text(tipoCambio.venta_oficial)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "TC COMPRA OFICIAL")
        Text(tipoCambio.compra_oficial)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "TC VENTA PARALELO")
        Text(tipoCambio.venta_paralelo)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "TC COMPRA PARALELO")
        Text(tipoCambio.compra_paralelo)
    }
}
