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
import com.jujus.flash_stock.core.components.FlashStockButton
import com.jujus.flash_stock.core.components.FlashStockLogo
import com.jujus.flash_stock.features.auth.presentation.components.*
import com.jujus.flash_stock.features.auth.presentation.viewmodels.RegisterAuthUserViewModel

@Composable
fun RegisterUserScreen(
    onRegisterSuccess: () -> Unit,
    onNavigateToLogin: () -> Unit,
    viewModel: RegisterAuthUserViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(uiState.isRegisterSuccessful) {
        if (uiState.isRegisterSuccessful) onRegisterSuccess()
    }

    LaunchedEffect(uiState.error) {
        uiState.error?.let { snackbarHostState.showSnackbar(it) }
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

            Spacer(modifier = Modifier.height(28.dp))

            RoleSelector(
                selectedRole = uiState.selectedRole,
                onRoleChange = viewModel::onRoleChange
            )

            Spacer(modifier = Modifier.height(24.dp))

            RegisterUserForm(
                name = uiState.name,
                email = uiState.email,
                password = uiState.password,
                error = uiState.error,
                onNameChange = viewModel::onNameChange,
                onEmailChange = viewModel::onEmailChange,
                onPasswordChange = viewModel::onPasswordChange,
                phone = uiState.phone,
                onPhoneChange = viewModel::onPhoneChange
            )

            Spacer(modifier = Modifier.height(28.dp))

            FlashStockButton(
                text = "CREAR CUENTA  →",
                onClick = viewModel::onRegisterClick,
                isLoading = uiState.isLoading
            )

            Spacer(modifier = Modifier.height(16.dp))

            RegisterUserFooter(onNavigateToLogin = onNavigateToLogin)

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}