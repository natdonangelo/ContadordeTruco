package com.natalia_donangelo.contadordetruco

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.natalia_donangelo.contadordetruco.ui.theme.ContadorDeTrucoTheme

class MainActivity : ComponentActivity() {

    private val viewModel: ContadorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        // CORRIGIDO: Removido o ": Bundle?" de dentro dos parênteses do super
        super.onCreate(savedInstanceState)
        setContent {
            ContadorDeTrucoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContadorApp(viewModel)
                }
            }
        }
    }
}

@Composable
fun ContadorApp(viewModel: ContadorViewModel) {
    val pontosA by viewModel.pontosA.collectAsState()
    val pontosB by viewModel.pontosB.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Contador de Truco",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(top = 24.dp)
        )

        // Painel dos Times
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
             Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Time A", fontSize = 24.sp)
                Text(text = "$pontosA", fontSize = 64.sp, modifier = Modifier.padding(vertical = 16.dp))
                Button(onClick = { viewModel.somarTimeA(1) }) { Text("+1") }
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { viewModel.somarTimeA(3) }) { Text("+3") }
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedButton(onClick = { viewModel.subtrairTimeA() }) { Text("-1") }
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Time B", fontSize = 24.sp)
                Text(text = "$pontosB", fontSize = 64.sp, modifier = Modifier.padding(vertical = 16.dp))
                Button(onClick = { viewModel.somarTimeB(1) }) { Text("+1") }
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { viewModel.somarTimeB(3) }) { Text("+3") }
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedButton(onClick = { viewModel.subtrairTimeB() }) { Text("-1") }
            }
        }

        // Botão de Reset
        Button(
            onClick = { viewModel.reiniciarPartida() },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        ) {
            Text(text = "Zerar Partida", color = MaterialTheme.colorScheme.onError)
        }
    }
}