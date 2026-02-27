package com.jujus.flash_stock.features.auth.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jujus.flash_stock.core.components.FlashStockTextField

@Composable
fun RegisterUserForm(
    name: String,
    email: String,
    password: String,
    error: String?,
    phone: String,
    onPhoneChange: (String) -> Unit,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var passwordVisible by remember { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxWidth()) {

        FieldLabel(text = "NOMBRE COMPLETO")
        Spacer(modifier = Modifier.height(6.dp))
        FlashStockTextField(
            value = name,
            onValueChange = onNameChange,
            placeholder = "Ej: Juan Pérez",
            leadingIcon = Icons.Default.Person,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(16.dp))

        FieldLabel(text = "EMAIL")
        Spacer(modifier = Modifier.height(6.dp))
        FlashStockTextField(
            value = email,
            onValueChange = onEmailChange,
            placeholder = "hola@ejemplo.com",
            leadingIcon = Icons.Default.Email,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(16.dp))


        FieldLabel(text = "TELÉFONO")
        Spacer(modifier = Modifier.height(6.dp))
        FlashStockTextField(
            value = phone,
            onValueChange = onPhoneChange,
            placeholder = "Ej: 1234567890",
            leadingIcon = Icons.Default.Phone,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        Spacer(modifier = Modifier.height(16.dp))

        FieldLabel(text = "CONTRASEÑA")
        Spacer(modifier = Modifier.height(6.dp))
        FlashStockTextField(
            value = password,
            onValueChange = onPasswordChange,
            placeholder = "••••••••",
            leadingIcon = Icons.Default.Lock,
            visualTransformation = if (passwordVisible)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible)
                            Icons.Default.Visibility
                        else
                            Icons.Default.VisibilityOff,
                        contentDescription = null,
                        tint = Color(0xFF6B7280)
                    )
                }
            }
        )

        if (error != null) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = error,
                color = Color(0xFFEF4444),
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}