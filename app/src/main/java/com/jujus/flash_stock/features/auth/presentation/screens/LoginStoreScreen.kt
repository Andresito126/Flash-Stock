package com.jujus.flash_stock.features.auth.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jujus.flash_stock.core.components.AuthRole
import com.jujus.flash_stock.core.components.FlashStockButton
import com.jujus.flash_stock.core.components.FlashStockLogo
import com.jujus.flash_stock.features.auth.presentation.components.*
import com.jujus.flash_stock.features.auth.presentation.viewmodels.LoginAuthStoreViewModel

@Composable
fun LoginStoreScreen(
    onLoginSuccess: () -> Unit,
    onNavigateToRegister: () -> Unit,
    onNavigateToUserLogin: () -> Unit,
    viewModel: LoginAuthStoreViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(uiState.isLoginSuccessful) {
        if (uiState.isLoginSuccessful) onLoginSuccess()
    }

    LaunchedEffect(uiState.error) {
        uiState.error?.let { snackbarHostState.showSnackbar(it) }
    }

    // Navega a login de usuario cuando cambia el rol
    LaunchedEffect(uiState.selectedRole) {
        if (uiState.selectedRole == AuthRole.COMPRADOR) {
            viewModel.onRoleChange(AuthRole.TIENDA) // resetea
            onNavigateToUserLogin()
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
        bottomBar = { SslBadge() }
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

            // Arranca con TIENDA seleccionado
            RoleSelector(
                selectedRole = uiState.selectedRole,
                onRoleChange = viewModel::onRoleChange
            )

            Spacer(modifier = Modifier.height(24.dp))

            LoginStoreForm(
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

           // LoginStoreFooter(onNavigateToRegister = onNavigateToRegister)

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}