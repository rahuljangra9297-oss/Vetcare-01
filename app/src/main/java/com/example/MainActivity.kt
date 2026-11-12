package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.ScreenDestination
import com.example.ui.components.*
import com.example.ui.screens.*
import com.example.ui.theme.DaylightCanvas
import com.example.ui.theme.MyApplicationTheme
import com.example.viewmodel.VetCareViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val viewModel: VetCareViewModel = viewModel()
                VetCareApp(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun VetCareApp(viewModel: VetCareViewModel) {
    val activeScreen by viewModel.activeScreen.collectAsState()
    val toastMessage by viewModel.toastMessage.collectAsState()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    // Handle Android system Back button cleanly
    BackHandler(enabled = drawerState.isOpen || activeScreen != ScreenDestination.HOME) {
        if (drawerState.isOpen) {
            coroutineScope.launch { drawerState.close() }
        } else if (activeScreen != ScreenDestination.HOME) {
            viewModel.navigateTo(ScreenDestination.HOME)
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color.White
            ) {
                IntraHaryanaAccordionDrawer(
                    viewModel = viewModel,
                    onClose = { coroutineScope.launch { drawerState.close() } }
                )
            }
        }
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(DaylightCanvas),
            containerColor = DaylightCanvas,
            topBar = {
                VetCareTopBar(
                    viewModel = viewModel,
                    onMenuClick = { coroutineScope.launch { drawerState.open() } }
                )
            },
            contentWindowInsets = WindowInsets.safeDrawing
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(DaylightCanvas)
            ) {
                // Screen Content Routing
                when (activeScreen) {
                    ScreenDestination.HOME -> {
                        HeroStageCards(viewModel = viewModel)
                    }
                    ScreenDestination.DOCTOR_DIAGNOSIS,
                    ScreenDestination.DOCTOR_OPD_QUEUE -> {
                        DoctorWorkspaceScreen(viewModel = viewModel)
                    }
                    ScreenDestination.DOCTOR_FINANCE -> {
                        DoctorFinanceDashboardScreen(viewModel = viewModel)
                    }
                    ScreenDestination.DRUGS_DIRECTORY,
                    ScreenDestination.DOSAGE_SAFETY -> {
                        DrugsDirectoryScreen(viewModel = viewModel)
                    }
                    ScreenDestination.BREEDING_CATALOG -> {
                        BreedingCatalogScreen(viewModel = viewModel)
                    }
                    ScreenDestination.FARMER_PASSBOOK,
                    ScreenDestination.FARMER_MILK_CALC,
                    ScreenDestination.FARMER_DESI_NUSKHE,
                    ScreenDestination.EMERGENCY_SOS -> {
                        FarmerHubScreen(viewModel = viewModel)
                    }
                    ScreenDestination.ADMIN_FINANCIALS,
                    ScreenDestination.ADMIN_PAYOUT,
                    ScreenDestination.ADMIN_USERS,
                    ScreenDestination.ADMIN_CUSTOMIZER -> {
                        AdminVaultScreen(viewModel = viewModel)
                    }
                }

                // Auth Modal Overlay
                AuthModalDialog(viewModel = viewModel)

                // Single compact bottom toast alert (silent on launch, only user-triggered)
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .navigationBarsPadding(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    CompactBottomToast(message = toastMessage)
                }
            }
        }
    }
}
