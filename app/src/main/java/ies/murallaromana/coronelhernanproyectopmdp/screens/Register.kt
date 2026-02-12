package ies.murallaromana.coronelhernanproyectopmdp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import ies.murallaromana.coronelhernanproyectopmdp.components.LogoHeader

@Composable
fun Register(onNavigateToMovieList: () -> Unit, modifier: Modifier) {
    Column(modifier) {
        LogoHeader(
            Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
        RegisterBody(onNavigateToMovieList)
    }
}

@Composable
fun RegisterBody(onNavigateToMovieList: () -> Unit) {

    var usuario by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var passw by remember { mutableStateOf("") }
    var repeatedPassword by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }

    var showPassword by remember { mutableStateOf(false) }

    val isEmailError = usuario.isNotEmpty() && !isEmailValid(usuario)
    val isPasswError = passw.isNotEmpty() && !passwordError(passw, repeatedPassword)
    val isUserError = usuario.isNotEmpty()
    val isPhoneError = telefono.isNotEmpty() && !isPhoneValid(telefono)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text("Nombre de usuario") },
            isError = isUserError,
            supportingText = {
                if (isUserError) {
                    Text(
                        text = "El usuario ya existe",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = isEmailError,
            supportingText = {
                if (isEmailError) {
                    Text(
                        text = "Formato de correo inválido",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            trailingIcon = {
                if (isEmailError) {
                    Icon(Icons.Filled.Info, "Error", tint = MaterialTheme.colorScheme.error)
                }
            },
            singleLine = true,
        )
        OutlinedTextField(
            value = passw,
            onValueChange = { passw = it },
            label = { Text("Contraseña") },
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { showPassword = !showPassword }) {
                    Icon(
                        imageVector = if (showPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = if (showPassword) "Ocultar" else "Mostrar",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        )
        OutlinedTextField(
            value = repeatedPassword,
            onValueChange = { repeatedPassword = it },
            label = { Text("Repetir contraseña") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            isError = isPasswError,
            supportingText = {
                if (isPasswError) {
                    Text(
                        text = "Contraseña Distinta",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = { showPassword = !showPassword }) {
                    Icon(
                        imageVector = if (showPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = if (showPassword) "Ocultar" else "Mostrar",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

        )
        OutlinedTextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text("Teléfono") },
            isError = isPhoneError,
            supportingText = {
                if (isPasswError) {
                    Text(
                        text = "Teléfono inválido",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            trailingIcon = {
                if (isPhoneError) {
                    Icon(Icons.Filled.Info, "Error", tint = MaterialTheme.colorScheme.error)
                }
            }
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

fun passwordError(passw: String, repeatedPassw: String): Boolean {
    return passw != repeatedPassw
}

fun isPhoneValid(phone: String): Boolean {
    val cleanPhone = phone.replace(Regex("[\\s\\-\\(\\)]"), "")
    val phoneRegex = "^(\\+34|0034)?[6789]\\d{8}$".toRegex()

    return cleanPhone.matches(phoneRegex)
}
