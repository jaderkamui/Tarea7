package wallet.jader_munoz_marzo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }

    @Composable
    fun HomeScreen() {
        val context = this@HomeActivity
        val username = remember { mutableStateOf("") }
        val bitcoinData = remember { mutableStateOf<List<BitcoinData>>(emptyList()) }
        val currentBitcoinValue = remember { mutableStateOf(0.0) }

        LaunchedEffect(Unit) {
            username.value = UserPreferences(context).getUser()
            val data = BitcoinService.api.getBitcoinData().serie
            bitcoinData.value = data.take(7) // Get data for the last 7 days
            currentBitcoinValue.value = data.firstOrNull()?.valor ?: 0.0 // Get current value
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Bienvenido: ${username.value}",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Divider(color = Color.Gray, thickness = 1.dp)
            Text(
                text = "Valor actual de Bitcoin: ${currentBitcoinValue.value}",
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color.Blue,
                    fontSize = 20.sp
                ),
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Divider(color = Color.Gray, thickness = 1.dp)
            if (bitcoinData.value.isNotEmpty()) {
                BitcoinList(bitcoinData.value)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    lifecycleScope.launch {
                        UserPreferences(context).clearUser()
                        val intent = Intent(context, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cerrar Sesión")
            }
        }
    }

    @Composable
    fun BitcoinList(bitcoinData: List<BitcoinData>) {
        LazyColumn {
            items(bitcoinData) { data ->
                Text(
                    text = "Fecha: ${data.fecha.split("T")[0]}, Valor: ${data.valor}",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}