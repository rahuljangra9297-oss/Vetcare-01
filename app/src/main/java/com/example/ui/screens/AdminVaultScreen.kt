package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.data.BankAccount
import com.example.data.UserProfile
import com.example.ui.components.*
import com.example.ui.theme.*
import com.example.viewmodel.VetCareViewModel

@Composable
fun AdminVaultScreen(
    viewModel: VetCareViewModel
) {
    val settings by viewModel.adminSettings.collectAsState()
    val financials by viewModel.financialSummary.collectAsState()
    val timeFilter by viewModel.revenueTimeFilter.collectAsState()
    val usersList by viewModel.userProfiles.collectAsState()
    val bankAccounts by viewModel.bankAccounts.collectAsState()

    var activeAdminTab by remember { mutableStateOf(0) }

    var clinicName by remember(settings) { mutableStateOf(settings.clinicName) }
    var clinicSubtitle by remember(settings) { mutableStateOf(settings.clinicSubtitle) }
    var selectedPreset by remember(settings) { mutableStateOf(settings.presetPalette) }

    // PIN Protection Dialog State
    var showPinDialog by remember { mutableStateOf(false) }
    var enteredPin by remember { mutableStateOf("") }
    var pendingAction by remember { mutableStateOf<(() -> Unit)?>(null) }
    var pinActionTitle by remember { mutableStateOf("") }

    // Add / Edit Bank Account Dialog State
    var showAccountDialog by remember { mutableStateOf(false) }
    var editingAccount by remember { mutableStateOf<BankAccount?>(null) }
    var formBankName by remember { mutableStateOf("") }
    var formAccountNumber by remember { mutableStateOf("") }
    var formIfscCode by remember { mutableStateOf("") }
    var formUpiId by remember { mutableStateOf("") }
    var formPayeeName by remember { mutableStateOf("Rj official") }
    var formIsPrimary by remember { mutableStateOf(false) }

    fun executeWithPinCheck(actionTitle: String, action: () -> Unit) {
        pendingAction = action
        pinActionTitle = actionTitle
        enteredPin = ""
        showPinDialog = true
    }

    val presetPalettes = listOf(
        "Pristine Hospital White",
        "Emerald Agro-Vet",
        "Royal Medical Sapphire",
        "High-Contrast Sunlight Mode"
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(DaylightCanvas)
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Master Header Card
        item {
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                border = BorderStroke(2.dp, RoyalIndigoPrimary),
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(3.dp, RoundedCornerShape(18.dp))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(46.dp)
                                .clip(CircleShape)
                                .background(RoyalIndigoLight)
                                .border(2.dp, RoyalIndigoPrimary, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("🛡️", fontSize = 24.sp)
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "अधिकृत एडमिन वॉल्ट (Master Admin Vault)",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Black,
                                color = Slate900
                            )
                            Text(
                                text = "वित्तीय एनालिटिक्स • बैंक/UPI पेआउट कंट्रोल • नो-कोड कस्टमाइज़र",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = RoyalIndigoDark
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        TabSelectorButton("📊 रेवेन्यू एनालिटिक्स", activeAdminTab == 0) { activeAdminTab = 0 }
                        TabSelectorButton("🏦 बैंक व UPI पेआउट", activeAdminTab == 1) { activeAdminTab = 1 }
                        TabSelectorButton("👥 यूज़र व आईडी", activeAdminTab == 2) { activeAdminTab = 2 }
                        TabSelectorButton("🎨 लुक कस्टमाइज़र", activeAdminTab == 3) { activeAdminTab = 3 }
                    }
                }
            }
        }

        when (activeAdminTab) {
            0 -> {
                // TAB 0: REVENUE ANALYTICS
                item {
                    Card(
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        border = BorderStroke(1.5.dp, FrostedCardBorder),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "📊 कुल रेवेन्यू व आय एनालिटिक्स",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Black,
                                    color = Slate900
                                )
                                Surface(
                                    color = RoyalIndigoLight,
                                    shape = RoundedCornerShape(6.dp),
                                    border = BorderStroke(1.dp, RoyalIndigoPrimary)
                                ) {
                                    Text(
                                        text = "LIVE FY 2026-27",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Black,
                                        color = RoyalIndigoDark,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            // Horizontal Filter Chips
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(rememberScrollState()),
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                FilterChip(
                                    selected = timeFilter == "daily",
                                    onClick = { viewModel.setRevenueTimeFilter("daily") },
                                    label = { Text("आज (Daily)", fontWeight = FontWeight.Bold, fontSize = 11.sp) },
                                    colors = FilterChipDefaults.filterChipColors(containerColor = Color.White, selectedContainerColor = RoyalIndigoPrimary, selectedLabelColor = Color.White)
                                )
                                FilterChip(
                                    selected = timeFilter == "weekly",
                                    onClick = { viewModel.setRevenueTimeFilter("weekly") },
                                    label = { Text("साप्ताहिक (Weekly)", fontWeight = FontWeight.Bold, fontSize = 11.sp) },
                                    colors = FilterChipDefaults.filterChipColors(containerColor = Color.White, selectedContainerColor = RoyalIndigoPrimary, selectedLabelColor = Color.White)
                                )
                                FilterChip(
                                    selected = timeFilter == "monthly",
                                    onClick = { viewModel.setRevenueTimeFilter("monthly") },
                                    label = { Text("मासिक (Monthly)", fontWeight = FontWeight.Bold, fontSize = 11.sp) },
                                    colors = FilterChipDefaults.filterChipColors(containerColor = Color.White, selectedContainerColor = RoyalIndigoPrimary, selectedLabelColor = Color.White)
                                )
                                FilterChip(
                                    selected = timeFilter == "yearly",
                                    onClick = { viewModel.setRevenueTimeFilter("yearly") },
                                    label = { Text("वार्षिक (Yearly)", fontWeight = FontWeight.Bold, fontSize = 11.sp) },
                                    colors = FilterChipDefaults.filterChipColors(containerColor = Color.White, selectedContainerColor = RoyalIndigoPrimary, selectedLabelColor = Color.White)
                                )
                                FilterChip(
                                    selected = timeFilter == "all",
                                    onClick = { viewModel.setRevenueTimeFilter("all") },
                                    label = { Text("कुल शुद्ध आय (Gross Total ₹)", fontWeight = FontWeight.Bold, fontSize = 11.sp) },
                                    colors = FilterChipDefaults.filterChipColors(containerColor = Color.White, selectedContainerColor = RoyalIndigoPrimary, selectedLabelColor = Color.White)
                                )
                            }

                            Spacer(modifier = Modifier.height(14.dp))

                            val displayRevenue = when (timeFilter) {
                                "daily" -> financials.todayRevenue
                                "weekly" -> financials.weeklyRevenue
                                "monthly" -> financials.monthlyRevenue
                                "yearly" -> financials.yearlyRevenue
                                else -> financials.grossTotal
                            }

                            Surface(
                                color = Color.White,
                                shape = RoundedCornerShape(14.dp),
                                border = BorderStroke(2.dp, RoyalIndigoPrimary),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(
                                    modifier = Modifier.padding(16.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "कुल शुद्ध आय (${timeFilter.uppercase()} GROSS NET REVENUE):",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = RoyalIndigoDark
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "₹$displayRevenue",
                                        fontSize = 32.sp,
                                        fontWeight = FontWeight.Black,
                                        color = Slate900
                                    )
                                    Text(
                                        text = "स्टेट बैंक ऑफ इंडिया (****7585) पर ऑटो-सेटलमेंट सक्रिय",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = AgroEmeraldDark
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(14.dp))

                            // Breakdown Cards: Doctor vs Farmer Subscriptions
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Surface(
                                    color = Color.White,
                                    shape = RoundedCornerShape(12.dp),
                                    border = BorderStroke(1.5.dp, MedicalCyanPrimary),
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Column(modifier = Modifier.padding(12.dp)) {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Text("🩺", fontSize = 14.sp)
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Text("डॉक्टर सब्सक्रिप्शन", fontSize = 11.sp, color = MedicalCyanDark, fontWeight = FontWeight.Bold)
                                        }
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text("₹${financials.doctorSubscriptions}", fontSize = 18.sp, fontWeight = FontWeight.Black, color = Slate900)
                                        Text("67.2% हिस्सेदारी", fontSize = 10.sp, color = Slate900, fontWeight = FontWeight.SemiBold)
                                    }
                                }

                                Surface(
                                    color = Color.White,
                                    shape = RoundedCornerShape(12.dp),
                                    border = BorderStroke(1.5.dp, AgroEmeraldPrimary),
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Column(modifier = Modifier.padding(12.dp)) {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Text("🌾", fontSize = 14.sp)
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Text("किसान सब्सक्रिप्शन", fontSize = 11.sp, color = AgroEmeraldDark, fontWeight = FontWeight.Bold)
                                        }
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text("₹${financials.farmerSubscriptions}", fontSize = 18.sp, fontWeight = FontWeight.Black, color = Slate900)
                                        Text("32.8% हिस्सेदारी", fontSize = 10.sp, color = Slate900, fontWeight = FontWeight.SemiBold)
                                    }
                                }
                            }
                        }
                    }
                }
            }

            1 -> {
                // TAB 1: DYNAMIC BANKING & PAYOUTS CONTROLLER
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "🏦 पेआउट बैंक खाते व UPI आईडी",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black,
                                color = Slate900
                            )
                            Text(
                                text = "सभी संशोधन मास्टर पिन (9297) द्वारा सुरक्षित हैं",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = RoyalIndigoDark
                            )
                        }

                        Button(
                            onClick = {
                                executeWithPinCheck("नया बैंक खाता जोड़ने हेतु पिन दर्ज करें") {
                                    editingAccount = null
                                    formBankName = ""
                                    formAccountNumber = ""
                                    formIfscCode = ""
                                    formUpiId = ""
                                    formPayeeName = "Rj official"
                                    formIsPrimary = false
                                    showAccountDialog = true
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = RoyalIndigoPrimary),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.testTag("admin_add_bank_btn")
                        ) {
                            Text("➕ खाता जोड़ें", fontSize = 12.sp, fontWeight = FontWeight.Black, color = Color.White)
                        }
                    }
                }

                // List of Bank Accounts
                items(bankAccounts) { account ->
                    Card(
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        border = BorderStroke(if (account.isPrimary) 2.dp else 1.5.dp, if (account.isPrimary) RoyalIndigoPrimary else FrostedCardBorder),
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(2.dp, RoundedCornerShape(14.dp))
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text("🏦", fontSize = 20.sp)
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Column {
                                        Text(
                                            text = account.bankName,
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Black,
                                            color = Slate900
                                        )
                                        Text(
                                            text = account.accountNumberMasked,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Slate900
                                        )
                                    }
                                }

                                if (account.isPrimary) {
                                    Surface(
                                        color = RoyalIndigoLight,
                                        shape = RoundedCornerShape(6.dp),
                                        border = BorderStroke(1.dp, RoyalIndigoPrimary)
                                    ) {
                                        Text(
                                            text = "🌟 प्राथमिक (Primary)",
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Black,
                                            color = RoyalIndigoDark,
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                        )
                                    }
                                } else {
                                    Surface(
                                        color = DaylightCanvas,
                                        shape = RoundedCornerShape(6.dp),
                                        border = BorderStroke(1.dp, FrostedCardBorder)
                                    ) {
                                        Text(
                                            text = "वैकल्पिक (Secondary)",
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Slate900,
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text("IFSC कोड:", fontSize = 10.sp, color = Slate900, fontWeight = FontWeight.Bold)
                                    Text(account.ifscCode, fontSize = 12.sp, fontWeight = FontWeight.Black, color = Slate900)
                                }
                                Column(modifier = Modifier.weight(1.2f)) {
                                    Text("UPI ID:", fontSize = 10.sp, color = Slate900, fontWeight = FontWeight.Bold)
                                    Text(account.upiId, fontSize = 12.sp, fontWeight = FontWeight.Black, color = RoyalIndigoDark)
                                }
                                Column(modifier = Modifier.weight(1f)) {
                                    Text("खाताधारक:", fontSize = 10.sp, color = Slate900, fontWeight = FontWeight.Bold)
                                    Text(account.payeeName, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Slate900)
                                }
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                if (!account.isPrimary) {
                                    OutlinedButton(
                                        onClick = {
                                            executeWithPinCheck("प्राथमिक खाता बदलने हेतु पिन दर्ज करें") {
                                                viewModel.setPrimaryBankAccount(account.id)
                                            }
                                        },
                                        shape = RoundedCornerShape(8.dp),
                                        border = BorderStroke(1.5.dp, RoyalIndigoPrimary),
                                        modifier = Modifier.weight(1.3f)
                                    ) {
                                        Text("⭐ प्राथमिक बनाएं", fontSize = 11.sp, fontWeight = FontWeight.Black, color = RoyalIndigoPrimary)
                                    }
                                }

                                OutlinedButton(
                                    onClick = {
                                        executeWithPinCheck("खाता संपादित करने हेतु पिन दर्ज करें") {
                                            editingAccount = account
                                            formBankName = account.bankName
                                            formAccountNumber = account.accountNumberFull
                                            formIfscCode = account.ifscCode
                                            formUpiId = account.upiId
                                            formPayeeName = account.payeeName
                                            formIsPrimary = account.isPrimary
                                            showAccountDialog = true
                                        }
                                    },
                                    shape = RoundedCornerShape(8.dp),
                                    border = BorderStroke(1.dp, FrostedCardBorder),
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text("✏️ एडिट", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Slate900)
                                }

                                IconButton(
                                    onClick = {
                                        executeWithPinCheck("बैंक खाता हटाने हेतु पिन दर्ज करें") {
                                            viewModel.deleteBankAccount(account.id)
                                        }
                                    },
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(DaylightCanvas)
                                        .border(1.dp, RedAlert.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
                                ) {
                                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete", tint = RedAlert)
                                }
                            }
                        }
                    }
                }
            }

            2 -> {
                // TAB 2: USER MANAGEMENT & SUBSCRIPTION TRIAL CONTROLLER
                item {
                    Text(
                        text = "👥 पंजीकृत उपयोगकर्ता व वीसीआई सत्यापन (User Management):",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Black,
                        color = Slate900,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }

                items(usersList) { user ->
                    UserManagementRow(
                        user = user,
                        onToggleApproval = { viewModel.toggleVciApproval(user.id) },
                        onExtendDays = { days -> viewModel.extendUserTrial(user.id, days) }
                    )
                }
            }

            3 -> {
                // TAB 3: NO-CODE LOOK & BRANDING CUSTOMIZER
                item {
                    Card(
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        border = BorderStroke(1.5.dp, FrostedCardBorder),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "🎨 नो-कोड लुक व क्लिनिक कस्टमाइज़र",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black,
                                color = Slate900
                            )
                            Text(
                                text = "लाइव ऐप का क्लिनिक नाम, उपशीर्षक व कलर पैलेट तुरंत बदलें:",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Slate900
                            )

                            Spacer(modifier = Modifier.height(14.dp))

                            OutlinedTextField(
                                value = clinicName,
                                onValueChange = { clinicName = it },
                                label = { Text("क्लिनिक / अस्पताल का नाम (Header Title)", fontWeight = FontWeight.Bold) },
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            OutlinedTextField(
                                value = clinicSubtitle,
                                onValueChange = { clinicSubtitle = it },
                                label = { Text("उपशीर्षक (Tagline)", fontWeight = FontWeight.Bold) },
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(14.dp))

                            Text(
                                text = "कलर थीम प्रीसेट्स (Preset Palettes):",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Slate900
                            )
                            Spacer(modifier = Modifier.height(6.dp))

                            presetPalettes.forEach { preset ->
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp)
                                ) {
                                    RadioButton(
                                        selected = selectedPreset == preset,
                                        onClick = { selectedPreset = preset }
                                    )
                                    Text(preset, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Slate900)
                                }
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            Button(
                                onClick = {
                                    viewModel.updateAdminSettings(
                                        clinicName, clinicSubtitle, settings.logoUrl, selectedPreset,
                                        settings.accountHolder, settings.bankName, settings.accountNumber, settings.ifscCode, settings.upiId
                                    )
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = RoyalIndigoPrimary),
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(48.dp)
                            ) {
                                Text("✨ लुक व ब्रांडिंग अपडेट करें", fontSize = 13.sp, fontWeight = FontWeight.Black, color = Color.White)
                            }
                        }
                    }
                }
            }
        }
    }

    // ==========================================
    // PIN VERIFICATION MODAL
    // ==========================================
    if (showPinDialog) {
        Dialog(onDismissRequest = { showPinDialog = false }) {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(2.dp, RoyalIndigoPrimary),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "🔐 एडमिन सुरक्षा सत्यापन",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Black,
                        color = Slate900
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = pinActionTitle,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = RoyalIndigoDark
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    OutlinedTextField(
                        value = enteredPin,
                        onValueChange = { if (it.length <= 10) enteredPin = it },
                        label = { Text("4-अंकीय मास्टर एडमिन पिन*", fontWeight = FontWeight.Bold) },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                        singleLine = true,
                        leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null, tint = RoyalIndigoPrimary) },
                        modifier = Modifier.fillMaxWidth().testTag("admin_pin_input")
                    )

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "💡 मास्टर पिन: 9297",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = RoyalIndigoPrimary
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedButton(
                            onClick = { showPinDialog = false },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("रद्द करें", fontWeight = FontWeight.Bold, color = Slate900)
                        }

                        Button(
                            onClick = {
                                if (viewModel.verifyAdminPin(enteredPin)) {
                                    showPinDialog = false
                                    pendingAction?.invoke()
                                    pendingAction = null
                                } else {
                                    viewModel.showToast("अमान्य एडमिन पिन! (सुरक्षा कोड: 9297)")
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = RoyalIndigoPrimary),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.weight(1f).testTag("admin_pin_confirm_btn")
                        ) {
                            Text("पुष्टि करें", fontWeight = FontWeight.Black, color = Color.White)
                        }
                    }
                }
            }
        }
    }

    // ==========================================
    // ADD / EDIT BANK ACCOUNT DIALOG
    // ==========================================
    if (showAccountDialog) {
        Dialog(onDismissRequest = { showAccountDialog = false }) {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(2.dp, RoyalIndigoPrimary),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp)
                ) {
                    Text(
                        text = if (editingAccount == null) "➕ नया पेआउट बैंक खाता जोड़ें" else "✏️ पेआउट खाता संपादित करें",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Black,
                        color = Slate900
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = formBankName,
                        onValueChange = { formBankName = it },
                        label = { Text("बैंक का नाम (e.g. State Bank of India)*", fontWeight = FontWeight.Bold) },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = formAccountNumber,
                        onValueChange = { formAccountNumber = it },
                        label = { Text("खाता संख्या (A/C Number)*", fontWeight = FontWeight.Bold) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedTextField(
                            value = formIfscCode,
                            onValueChange = { formIfscCode = it },
                            label = { Text("IFSC कोड*", fontWeight = FontWeight.Bold) },
                            singleLine = true,
                            modifier = Modifier.weight(1f)
                        )
                        OutlinedTextField(
                            value = formUpiId,
                            onValueChange = { formUpiId = it },
                            label = { Text("UPI ID*", fontWeight = FontWeight.Bold) },
                            singleLine = true,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = formPayeeName,
                        onValueChange = { formPayeeName = it },
                        label = { Text("खाताधारक का नाम (Payee Name)*", fontWeight = FontWeight.Bold) },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = formIsPrimary,
                            onCheckedChange = { formIsPrimary = it }
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("इसे प्राथमिक पेआउट खाता (Primary Account) बनाएं", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Slate900)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedButton(
                            onClick = { showAccountDialog = false },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("रद्द करें", fontWeight = FontWeight.Bold, color = Slate900)
                        }

                        Button(
                            onClick = {
                                if (formBankName.isBlank() || formAccountNumber.isBlank() || formIfscCode.isBlank() || formUpiId.isBlank()) {
                                    viewModel.showToast("कृपया सभी आवश्यक फ़ील्ड भरें!")
                                    return@Button
                                }
                                val editAcc = editingAccount
                                if (editAcc != null) {
                                    viewModel.updateBankAccount(
                                        id = editAcc.id,
                                        bankName = formBankName,
                                        accountNum = formAccountNumber,
                                        ifsc = formIfscCode,
                                        upi = formUpiId,
                                        payee = formPayeeName,
                                        isPrimary = formIsPrimary
                                    )
                                } else {
                                    viewModel.addBankAccount(
                                        bankName = formBankName,
                                        accountNum = formAccountNumber,
                                        ifsc = formIfscCode,
                                        upi = formUpiId,
                                        payee = formPayeeName,
                                        isPrimary = formIsPrimary
                                    )
                                }
                                showAccountDialog = false
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = RoyalIndigoPrimary),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.weight(1f).testTag("save_bank_account_btn")
                        ) {
                            Text("सहेजें", fontWeight = FontWeight.Black, color = Color.White)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun UserManagementRow(
    user: UserProfile,
    onToggleApproval: () -> Unit,
    onExtendDays: (Int) -> Unit
) {
    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.5.dp, FrostedCardBorder),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = user.name, fontSize = 13.5.sp, fontWeight = FontWeight.Black, color = Slate900)
                    Text(text = "भूमिका: ${user.role.title} • आईडी: ${user.regOrTagNo}", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Slate900)
                    Text(text = "प्लान: ${user.subscriptionTier} (शेष ट्रायल: ${user.trialDaysRemaining} दिन)", fontSize = 10.5.sp, color = RoyalIndigoDark, fontWeight = FontWeight.Bold)
                }

                Surface(
                    color = Color.White,
                    shape = RoundedCornerShape(6.dp),
                    border = BorderStroke(1.dp, if (user.isVciApproved) GreenSuccess else AmberWarning)
                ) {
                    Text(
                        text = if (user.isVciApproved) "स्वीकृत (Approved)" else "लंबित (Pending)",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Black,
                        color = if (user.isVciApproved) GreenSuccess else AmberWarning,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Action row 1: Approval toggle
            OutlinedButton(
                onClick = onToggleApproval,
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.2.dp, if (user.isVciApproved) RedAlert else GreenSuccess),
                modifier = Modifier.fillMaxWidth().height(36.dp)
            ) {
                Text(
                    text = if (user.isVciApproved) "वीसीआई स्वीकृति वापस लें" else "✓ वीसीआई डॉक्टर सत्यापन स्वीकृत करें",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Black,
                    color = if (user.isVciApproved) RedAlert else GreenSuccess
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Action row 2: One-click Trial Extensions (+7d, +15d, +30d)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("ट्रायल बढ़ाएं:", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Slate900)

                Button(
                    onClick = { onExtendDays(7) },
                    colors = ButtonDefaults.buttonColors(containerColor = RoyalIndigoPrimary),
                    shape = RoundedCornerShape(6.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                    modifier = Modifier.weight(1f).height(32.dp)
                ) {
                    Text("+7 दिन", fontSize = 10.sp, fontWeight = FontWeight.Black, color = Color.White)
                }

                Button(
                    onClick = { onExtendDays(15) },
                    colors = ButtonDefaults.buttonColors(containerColor = RoyalIndigoPrimary),
                    shape = RoundedCornerShape(6.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                    modifier = Modifier.weight(1f).height(32.dp)
                ) {
                    Text("+15 दिन", fontSize = 10.sp, fontWeight = FontWeight.Black, color = Color.White)
                }

                Button(
                    onClick = { onExtendDays(30) },
                    colors = ButtonDefaults.buttonColors(containerColor = AgroEmeraldPrimary),
                    shape = RoundedCornerShape(6.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                    modifier = Modifier.weight(1f).height(32.dp)
                ) {
                    Text("+30 दिन", fontSize = 10.sp, fontWeight = FontWeight.Black, color = Color.White)
                }
            }
        }
    }
}
