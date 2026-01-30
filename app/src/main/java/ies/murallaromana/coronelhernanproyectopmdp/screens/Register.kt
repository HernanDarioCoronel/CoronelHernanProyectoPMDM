package ies.murallaromana.coronelhernanproyectopmdp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ies.murallaromana.coronelhernanproyectopmdp.components.BackFloatingActionButton
import ies.murallaromana.coronelhernanproyectopmdp.components.LogoHeader

@Composable
fun Register(onNavigateToMovieList: () -> Unit, modifier: Modifier, onBackToLogin: () -> Unit) {
    Column(modifier) {
        LogoHeader(
            Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
        RegisterBody(onNavigateToMovieList, onBackToLogin)
    }
}

@Composable
fun RegisterBody(onNavigateToMovieList: () -> Unit, onBackToLogin: () -> Unit) {
    var usuario = "juanPerez123"
    var email = "pjuan-123@example.com"
    var passw = "********"
    var new_passw = "********"
    var telefono = "+34 123 456 678"
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        BackFloatingActionButton(onBackToLogin)
        OutlinedTextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text("Nombre de usuario") },
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )
        OutlinedTextField(
            value = passw,
            onValueChange = { passw = it },
            label = { Text("Contraaseña") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = { Icons.Filled.Visibility },
        )
        OutlinedTextField(
            value = new_passw,
            onValueChange = { new_passw = it },
            label = { Text("Ingrese nuevamente la contraseña") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = { Icons.Filled.Visibility },

            )
        OutlinedTextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text("Email") }
        )

        Button(
            onClick = onNavigateToMovieList,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContentColor = MaterialTheme.colorScheme.secondary
            )
        ) {
            Text("Registrarse")
        }
    }

}

