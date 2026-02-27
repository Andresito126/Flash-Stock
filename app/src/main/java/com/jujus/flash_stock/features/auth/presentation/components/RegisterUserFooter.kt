package com.jujus.flash_stock.features.auth.presentation.components

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun RegisterUserFooter(onNavigateToLogin: () -> Unit) {
    TextButton(onClick = onNavigateToLogin) {
        Row {
            Text(
                text = "¿YA TIENES CUENTA? ",
                color = Color(0xFF6B7280),
                fontSize = 13.sp
            )
            Text(
                text = "INICIA SESIÓN",
                color = Color.White,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}