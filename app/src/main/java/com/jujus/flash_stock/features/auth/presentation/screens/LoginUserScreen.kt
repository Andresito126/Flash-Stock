package com.jujus.flash_stock.features.auth.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jujus.flash_stock.features.auth.presentation.components.*
import com.jujus.flash_stock.features.auth.presentation.viewmodels.LoginAuthUserViewModel
import com.jujus.flash_stock.core.components.*


@Composable
fun LoginUserScreen(
    onLoginSuccess: () -> Unit,
    onNavigateToRegister: () -> Unit,
    onNavigateToStoreLogin: () -> Unit,
    viewModel: LoginAuthUserViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(uiState.isLoginSuccessful) {
        if (uiState.isLoginSuccessful) onLoginSuccess()
    }

    LaunchedEffect(uiState.error) {
        uiState.error?.let { snackbarHostState.showSnackbar(it) }
    }

    LaunchedEffect(uiState.selectedRole) {
        if (uiState.selectedRole == AuthRole.TIENDA) {
            viewModel.onRoleChange(AuthRole.COMPRADOR)
            onNavigateToStoreLogin()
        }
    }

    Scaffold(
        containerColor = Color(0xFF0D0D1A),
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { data ->
                Snackbar(
                    snackbarData = data,
                    containerColor = Color(0xFF1F1F2E),
                    contentColor = Color.White,
                    actionColor = Color(0xFFFF6B00),
                    shape = RoundedCornerShape(10.dp)
                )
            }
        },
        bottomBar = {
            SslBadge()
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 28.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            FlashStockLogo()

            Spacer(modifier = Modifier.height(36.dp))

            RoleSelector(
                selectedRole = uiState.selectedRole,
                onRoleChange = viewModel::onRoleChange
            )

            Spacer(modifier = Modifier.height(24.dp))


            LoginUserForm(
                email = uiState.email,
                password = uiState.password,
                error = uiState.error,
                onEmailChange = viewModel::onEmailChange,
                onPasswordChange = viewModel::onPasswordChange,
                onForgotPasswordClick = { /* TODO */ }
            )

            Spacer(modifier = Modifier.height(28.dp))

            FlashStockButton(
                text = "INICIAR SESIÓN  →",
                onClick = viewModel::onLoginClick,
                isLoading = uiState.isLoading
            )

            Spacer(modifier = Modifier.height(16.dp))

            LoginUserFooter(onNavigateToRegister = onNavigateToRegister)

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun SslBadge() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Lock,
            contentDescription = null,
            tint = Color(0xFF6B7280),
            modifier = Modifier.size(12.dp)
        )
        Spacer(modifier = Modifier.width(1.dp))
        Text(
            text = "CONEXIÓN SEGURA SSL",
            color = Color(0xFF6B7280),
            fontSize = 11.sp,
            letterSpacing = 1.sp
        )
    }
}
