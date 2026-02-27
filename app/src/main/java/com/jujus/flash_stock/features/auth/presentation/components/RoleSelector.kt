package com.jujus.flash_stock.features.auth.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jujus.flash_stock.core.components.AuthRole

@Composable
fun RoleSelector(
    selectedRole: AuthRole,
    onRoleChange: (AuthRole) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFF1A1A2E), RoundedCornerShape(12.dp))
            .padding(4.dp)
    ) {
        RoleTab(
            label = "COMPRADOR",
            icon = Icons.Default.Person,
            selected = selectedRole == AuthRole.COMPRADOR,
            onClick = { onRoleChange(AuthRole.COMPRADOR) },
            modifier = Modifier.weight(1f)
        )
        RoleTab(
            label = "TIENDA",
            icon = Icons.Default.Store,
            selected = selectedRole == AuthRole.TIENDA,
            onClick = { onRoleChange(AuthRole.TIENDA) },
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun RoleTab(
    label: String,
    icon: ImageVector,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) Color(0xFFFF6B00) else Color.Transparent,
            contentColor = if (selected) Color.White else Color(0xFF6B7280)
        ),
        contentPadding = PaddingValues(vertical = 10.dp),
        elevation = ButtonDefaults.buttonElevation(0.dp),
        modifier = modifier.height(42.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.5.sp
        )
    }
}