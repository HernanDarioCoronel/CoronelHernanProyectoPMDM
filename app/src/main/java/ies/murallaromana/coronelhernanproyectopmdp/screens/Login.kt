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
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import ies.murallaromana.coronelhernanproyectopmdp.components.LogoHeader


private val correctUser = "a@b.com"
private val correctPassw = "1234"

@Composable
fun Login(onNavigateToMovieList: () -> Unit, onNavigateToRegister: () -> Unit, modifier: Modifier) {
    Column(modifier) {
        Surface() {
            Column() {
                LogoHeader(
                    Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
                LoginBody(onNavigateToMovieList, onNavigateToRegister)
            }
        }
    }
}

@Composable
fun LoginBody(onNavigateToMovieList: () -> Unit, onNavigateToRegister: () -> Unit) {
    var usuario by remember { mutableStateOf("") }
    var passw by remember { mutableStateOf("") }

    val isEmailError = usuario.isNotEmpty() && !isEmailValid(usuario)
    var showPassword by remember { mutableStateOf(false) }

    var errorMsg by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),

        ) {
        OutlinedTextField(
            value = usuario,
            onValueChange = { usuario = it },
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
        Text(
            text = errorMsg,
            color = MaterialTheme.colorScheme.error
        )
        Button(
            onClick = {
                if (loginError(usuario, passw)) {
                    errorMsg = "Usuario o contraseña incorrectos"
                } else {
                    onNavigateToMovieList()
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContentColor = MaterialTheme.colorScheme.secondary
            )
        ) {
            Text("Login")
        }
        RegisterLink(onNavigateToRegister)
    }
}

fun isEmailValid(email: String): Boolean {
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-z]{2,}$".toRegex()
    return email.matches(emailRegex)
}

fun loginError(user: String, passw: String): Boolean {
    return user != correctUser || passw != correctPassw
}

@Composable
fun RegisterLink(onNavigateToRegister: () -> Unit) {
    val navController = rememberNavController()
    val annotatedString = buildAnnotatedString {
        append("No tienes cuenta?. ")

        withLink(
            LinkAnnotation.Clickable(
                tag = "Login",
                styles = TextLinkStyles(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                ),
                linkInteractionListener = {
                    onNavigateToRegister()
                }
            )
        ) {
            append("Registrate")
        }
    }
    Text(text = annotatedString)
}
