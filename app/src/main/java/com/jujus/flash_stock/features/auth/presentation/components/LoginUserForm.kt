package com.jujus.flash_stock.features.auth.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jujus.flash_stock.core.components.FlashStockTextField

@Composable
fun LoginUserForm(
    email: String,
    password: String,
    error: String?,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onForgotPasswordClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val TextMuted = Color(0xFF6B7280)
    var passwordVisible by remember { mutableStateOf(false) }

    Column(modifier = modifier) {

        FieldLabel(text = "EMAIL")
        Spacer(modifier = Modifier.height(8.dp))
        FlashStockTextField(
            value = email,
            onValueChange = onEmailChange,
            placeholder = "hola@ejemplo.com",
            leadingIcon = Icons.Default.Email,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(10.dp))

        CompositionLocalProvider(
            LocalMinimumInteractiveComponentSize  provides 0.dp
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                FieldLabel(text = "CONTRASEÑA")
                TextButton(
                    onClick = onForgotPasswordClick,
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier.padding(end = 20.dp)
                ) {
                /*Text(
                        text = "CONTRASEÑA",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFFF6B00),
                        letterSpacing = 1.sp
                    )*/
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

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
                        tint = TextMuted
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

@Composable
private fun FieldLabel(text: String) {
    Text(
        text = text,
        fontSize = 11.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color(0xFF6B7280),
        letterSpacing = 1.sp,
        modifier = Modifier.fillMaxWidth()
    )
}