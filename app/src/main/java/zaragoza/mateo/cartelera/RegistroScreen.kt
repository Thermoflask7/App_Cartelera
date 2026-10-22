package zaragoza.mateo.cartelera

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import zaragoza.mateo.cartelera.ui.theme.CarteleraTheme

fun validarRegistro(
    usuario: String,
    contrasenia: String,
    confirmacion: String
): String {
    if (usuario.isBlank() || contrasenia.isBlank() || confirmacion.isBlank()){
        return "Llena todos los campos solicitados"
    }
    if (contrasenia.length < 6) {
        return "La contraseña debe tener al menos 6 caracteres"
    }
    if (contrasenia != confirmacion){
        return "Las contraseñas no coinciden"
    }
    return ""
}

@Composable
fun RegistroScreen(
    onRegistroOk: () -> Unit,
    onCancelar: () -> Unit
) {
    var usuario by rememberSaveable {mutableStateOf("")}
    var contrasenia by rememberSaveable { mutableStateOf("") }
    var confirmacion by rememberSaveable { mutableStateOf("") }
    var mensajeError by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(
            space = 12.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Crear cuenta",
            style = MaterialTheme.typography.headlineLarge
        )
        OutlinedTextField(
            value = usuario,
            onValueChange = {usuario = it},
            label = { Text ("correo") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = contrasenia,
            onValueChange = {contrasenia = it},
            label = {Text("contraseña")},
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = confirmacion,
            onValueChange = {confirmacion = it},
            label = {Text("Confirmar contraseña")},
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            modifier = Modifier.fillMaxWidth()
        )
        if (mensajeError.isNotBlank()){
            Text(
                text = mensajeError,
                color = MaterialTheme.colorScheme.error
            )
        }
        Button(
            onClick = {
                mensajeError = validarRegistro(usuario, contrasenia, confirmacion)
                if (mensajeError.isEmpty()) {
                    Firebase.auth.createUserWithEmailAndPassword(usuario.trim(), contrasenia)
                        .addOnCompleteListener { tarea ->
                            if (tarea.isSuccessful) {
                                onRegistroOk()
                            } else {
                                mensajeError = tarea.exception?.message ?: "Error al registrar"
                            }
                        }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrarse")
        }
        TextButton(onClick = onCancelar) {
            Text("Ya tengo cuenta")
        }
}
}

@Preview(showBackground = true)
@Composable
fun RegistroScreenPreview() {
    CarteleraTheme {
        RegistroScreen(onRegistroOk = {}, onCancelar = {})
    }
}


