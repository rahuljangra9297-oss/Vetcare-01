package com.example.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.*
import com.example.ui.theme.*
import com.example.viewmodel.VetCareViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VetCareTopBar(
    viewModel: VetCareViewModel,
    onMenuClick: () -> Unit
) {
    val language by viewModel.selectedLanguage.collectAsState()
    val role by viewModel.currentRole.collectAsState()
    val sessionSec by viewModel.sessionSecondsRemaining.collectAsState()
    val trialSec by viewModel.trialSecondsRemaining.collectAsState()
    val isDesktopToggle by viewModel.isDesktopModeManualToggle.collectAsState()
    var langMenuExpanded by remember { mutableStateOf(false) }

    val sessionMin = sessionSec / 60
    val sessionSecMod = sessionSec % 60
    val trialHours = trialSec / 3600
    val trialMin = (trialSec % 3600) / 60
    val trialSecMod = trialSec % 60

    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val dotAlpha by infiniteTransition.animateFloat(
        initialValue = 0.4f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "dotAlpha"
    )

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .shadow(2.dp),
        color = Color.White,
        tonalElevation = 0.dp
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Live Session & Trial Countdown Bar (Mobile-responsive with fluid horizontal flow)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Slate900)
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "⏱️ सत्र: %02d:%02d".format(sessionMin, sessionSecMod),
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.Black,
                        color = if (sessionSec < 300) RedAlert else Color.White
                    )
                    Text(
                        text = "•",
                        fontSize = 10.sp,
                        color = Slate500
                    )
                    Text(
                        text = "⏳ ट्रायल: %02d:%02d:%02d".format(trialHours, trialMin, trialSecMod),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = AmberWarning
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Surface(
                    onClick = { viewModel.toggleDesktopMode() },
                    shape = RoundedCornerShape(6.dp),
                    color = if (isDesktopToggle == true) MedicalCyanPrimary else Slate800,
                    modifier = Modifier.height(24.dp)
                ) {
                    Text(
                        text = if (isDesktopToggle == true) "🖥️ डेस्कटॉप" else "📱 लेआउट",
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                    )
                }
            }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Hamburger ☰
            IconButton(
                onClick = onMenuClick,
                modifier = Modifier
                    .size(44.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .border(1.5.dp, FrostedCardBorder, RoundedCornerShape(12.dp))
                    .testTag("hamburger_menu_button")
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = Slate900
                )
            }

            // Branding & Pulsing Status
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .clickable { viewModel.navigateTo(ScreenDestination.HOME) }
                    .padding(horizontal = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "🐾 VETCARE AI OS",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Black,
                        color = Slate900,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Surface(
                        color = Color.White,
                        shape = RoundedCornerShape(6.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, MedicalCyanPrimary)
                    ) {
                        Text(
                            text = "2026",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Black,
                            color = Slate900,
                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                        )
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 2.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(GreenSuccess.copy(alpha = dotAlpha))
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = Localization.get("system_active", language),
                        fontSize = 11.sp,
                        color = Slate900,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Right Actions: Language Selector + User Avatar
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                // Language Dropdown
                Box {
                    Surface(
                        onClick = { langMenuExpanded = true },
                        shape = RoundedCornerShape(10.dp),
                        color = Color.White,
                        border = androidx.compose.foundation.BorderStroke(1.5.dp, MedicalCyanPrimary),
                        modifier = Modifier.height(38.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        ) {
                            Text(
                                text = "🌐 ${language.displayName.take(4)}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Black,
                                color = Slate900
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "Select Language",
                                tint = Slate900,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }

                    DropdownMenu(
                        expanded = langMenuExpanded,
                        onDismissRequest = { langMenuExpanded = false },
                        modifier = Modifier.background(Color.White)
                    ) {
                        AppLanguage.values().forEach { lang ->
                            DropdownMenuItem(
                                text = {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text(
                                            text = lang.displayName,
                                            fontWeight = FontWeight.Bold,
                                            color = Slate900
                                        )
                                        if (lang == language) {
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Icon(
                                                imageVector = Icons.Default.Check,
                                                contentDescription = null,
                                                tint = MedicalCyanPrimary,
                                                modifier = Modifier.size(16.dp)
                                            )
                                        }
                                    }
                                },
                                onClick = {
                                    viewModel.setLanguage(lang)
                                    langMenuExpanded = false
                                }
                            )
                        }
                    }
                }

                // User Badge / Login
                Surface(
                    onClick = { viewModel.openAuthModal(role) },
                    shape = CircleShape,
                    color = when (role) {
                        UserRole.DOCTOR -> MedicalCyanPrimary
                        UserRole.FARMER -> AgroEmeraldPrimary
                        UserRole.ADMIN -> RoyalIndigoPrimary
                    },
                    modifier = Modifier.size(38.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = when (role) {
                                UserRole.DOCTOR -> "🩺"
                                UserRole.FARMER -> "🌾"
                                UserRole.ADMIN -> "🛡️"
                            },
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }

        // Direct 1-Tap Role-Switching Navigation Tabs (Doctor, Farmer, Admin)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF1F5F9))
                .padding(horizontal = 8.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            val roles: List<Triple<UserRole, String, ScreenDestination>> = listOf(
                Triple(UserRole.DOCTOR, "🩺 डॉक्टर कंसोल", ScreenDestination.DOCTOR_DIAGNOSIS),
                Triple(UserRole.FARMER, "🌾 किसान हब", ScreenDestination.FARMER_PASSBOOK),
                Triple(UserRole.ADMIN, "🛡️ एडमिन वॉल्ट", ScreenDestination.ADMIN_FINANCIALS)
            )

            roles.forEach { roleItem ->
                val tabRole = roleItem.first
                val label = roleItem.second
                val dest = roleItem.third
                val isSelected = role == tabRole
                Surface(
                    onClick = {
                        viewModel.setRole(tabRole)
                        viewModel.navigateTo(dest)
                    },
                    shape = RoundedCornerShape(8.dp),
                    color = if (isSelected) {
                        when (tabRole) {
                            UserRole.DOCTOR -> MedicalCyanPrimary
                            UserRole.FARMER -> AgroEmeraldPrimary
                            UserRole.ADMIN -> RoyalIndigoPrimary
                            else -> Slate900
                        }
                    } else Color.White,
                    border = if (!isSelected) androidx.compose.foundation.BorderStroke(1.dp, FrostedCardBorder) else null,
                    modifier = Modifier
                        .weight(1f)
                        .height(34.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.padding(horizontal = 4.dp)
                    ) {
                        Text(
                            text = label,
                            fontSize = 11.5.sp,
                            fontWeight = if (isSelected) FontWeight.Black else FontWeight.Bold,
                            color = if (isSelected) Color.White else Slate900,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}
}

@Composable
fun HeroStageCards(
    viewModel: VetCareViewModel
) {
    val language by viewModel.selectedLanguage.collectAsState()
    val currentUser by viewModel.currentUser.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DaylightCanvas)
            .verticalScroll(rememberScrollState())
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Hero Card 1: 🩺 Veterinary Doctor Console
        FrostedHeroCard(
            title = Localization.get("role_doctor", language),
            badgeText = "5-वे एआई निदान • शेफर्स इंजन",
            description = Localization.get("role_doctor_desc", language),
            accentColor = MedicalCyanPrimary,
            primaryButtonText = if (currentUser?.role == UserRole.DOCTOR) "🩺 कंसोल खोलें (Doctor Portal)" else Localization.get("doctor_login", language),
            secondaryButtonText = Localization.get("doctor_register", language),
            iconEmoji = "🩺",
            onPrimaryClick = {
                if (currentUser?.role == UserRole.DOCTOR) {
                    viewModel.navigateTo(ScreenDestination.DOCTOR_DIAGNOSIS)
                } else {
                    viewModel.openAuthModal(UserRole.DOCTOR, isRegister = false)
                }
            },
            onSecondaryClick = {
                viewModel.openAuthModal(UserRole.DOCTOR, isRegister = true)
            }
        )

        // Hero Card 2: 🌾 Smart Dairy Farmer Hub
        FrostedHeroCard(
            title = Localization.get("role_farmer", language),
            badgeText = "पशु आधार • फैट-एसएनएफ लेजर",
            description = Localization.get("role_farmer_desc", language),
            accentColor = AgroEmeraldPrimary,
            primaryButtonText = if (currentUser?.role == UserRole.FARMER) "🌾 हब खोलें (Farmer Hub)" else Localization.get("farmer_login", language),
            secondaryButtonText = Localization.get("farmer_register", language),
            iconEmoji = "🌾",
            onPrimaryClick = {
                if (currentUser?.role == UserRole.FARMER) {
                    viewModel.navigateTo(ScreenDestination.FARMER_PASSBOOK)
                } else {
                    viewModel.openAuthModal(UserRole.FARMER, isRegister = false)
                }
            },
            onSecondaryClick = {
                viewModel.openAuthModal(UserRole.FARMER, isRegister = true)
            }
        )

        // Hero Card 3: 🛡️ Master Admin Vault
        FrostedHeroCard(
            title = Localization.get("role_admin", language),
            badgeText = "Pre-Registered • Financials",
            description = Localization.get("role_admin_desc", language),
            accentColor = RoyalIndigoPrimary,
            primaryButtonText = if (currentUser?.role == UserRole.ADMIN) "🛡️ वॉल्ट खोलें (Admin Vault)" else Localization.get("admin_login", language),
            secondaryButtonText = null,
            iconEmoji = "🛡️",
            onPrimaryClick = {
                if (currentUser?.role == UserRole.ADMIN) {
                    viewModel.navigateTo(ScreenDestination.ADMIN_FINANCIALS)
                } else {
                    viewModel.openAuthModal(UserRole.ADMIN, isRegister = false)
                }
            },
            onSecondaryClick = {}
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun FrostedHeroCard(
    title: String,
    badgeText: String,
    description: String,
    accentColor: Color,
    primaryButtonText: String,
    secondaryButtonText: String?,
    iconEmoji: String,
    onPrimaryClick: () -> Unit,
    onSecondaryClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(3.dp, RoundedCornerShape(18.dp)),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = DaylightSurface),
        border = androidx.compose.foundation.BorderStroke(2.dp, accentColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(DaylightSurface)
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(46.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .border(2.dp, accentColor, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = iconEmoji, fontSize = 22.sp)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = title,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Black,
                            color = Slate900,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Surface(
                            color = Color.White,
                            shape = RoundedCornerShape(6.dp),
                            border = androidx.compose.foundation.BorderStroke(1.dp, accentColor),
                            modifier = Modifier.padding(top = 2.dp)
                        ) {
                            Text(
                                text = badgeText,
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Slate900,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = description,
                fontSize = 12.5.sp,
                fontWeight = FontWeight.Medium,
                color = Slate900,
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(14.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = onPrimaryClick,
                    colors = ButtonDefaults.buttonColors(containerColor = accentColor),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                ) {
                    Text(
                        text = primaryButtonText,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                if (secondaryButtonText != null) {
                    OutlinedButton(
                        onClick = onSecondaryClick,
                        shape = RoundedCornerShape(10.dp),
                        border = androidx.compose.foundation.BorderStroke(1.5.dp, accentColor),
                        colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White),
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                    ) {
                        Text(
                            text = secondaryButtonText,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Black,
                            color = Slate900,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun IntraHaryanaAccordionDrawer(
    viewModel: VetCareViewModel,
    onClose: () -> Unit
) {
    val role by viewModel.currentRole.collectAsState()
    val currentUser by viewModel.currentUser.collectAsState()
    var expandedCategory by remember { mutableStateOf("doctor") }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.85f)
            .widthIn(max = 320.dp)
            .background(DaylightCanvas)
            .statusBarsPadding()
            .navigationBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Drawer Header with prominent Teal [✕] Close Button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "🐾 VETCARE AI OS",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Black,
                    color = Slate900
                )
                Text(
                    text = "Intra-Haryana Health Grid",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = TealDark
                )
            }

            IconButton(
                onClick = onClose,
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .background(TealDark)
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Authenticated Profile Header Card with Logout Button
        Surface(
            color = DaylightSurface,
            shape = RoundedCornerShape(14.dp),
            border = androidx.compose.foundation.BorderStroke(1.5.dp, TealAccent),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(2.dp, RoundedCornerShape(14.dp))
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        color = when (role) {
                            UserRole.DOCTOR -> MedicalCyanLight
                            UserRole.FARMER -> AgroEmeraldLight
                            UserRole.ADMIN -> RoyalIndigoLight
                        },
                        shape = RoundedCornerShape(6.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, when (role) {
                            UserRole.DOCTOR -> MedicalCyanPrimary
                            UserRole.FARMER -> AgroEmeraldPrimary
                            UserRole.ADMIN -> RoyalIndigoPrimary
                        })
                    ) {
                        Text(
                            text = role.title,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Black,
                            color = Slate900,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }

                    TextButton(
                        onClick = {
                            viewModel.logout()
                            onClose()
                        },
                        contentPadding = PaddingValues(horizontal = 6.dp, vertical = 0.dp)
                    ) {
                        Text("लॉगआउट", color = RedAlert, fontSize = 11.sp, fontWeight = FontWeight.Black)
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = currentUser?.name ?: "अधिकृत उपयोगकर्ता",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Black,
                    color = Slate900
                )
                Text(
                    text = currentUser?.clinicOrVillage ?: "हिसार पशु सुपर-स्पेशलिटी अस्पताल",
                    fontSize = 11.sp,
                    color = Slate900
                )
            }
        }

        Divider(
            color = FrostedCardBorder,
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 12.dp)
        )

        // Accordion 1: Doctor Console
        AccordionGroup(
            title = "🩺 अधिकृत पशु चिकित्सक (Doctor)",
            isExpanded = expandedCategory == "doctor",
            onToggle = { expandedCategory = if (expandedCategory == "doctor") "" else "doctor" }
        ) {
            DrawerSubItem("1. डिजिटल ओपीडी पर्ची", Icons.Default.Description) {
                viewModel.navigateTo(ScreenDestination.DOCTOR_DIAGNOSIS)
                onClose()
            }
            DrawerSubItem("2. 3-वे एआई रोग निदान", Icons.Default.Biotech) {
                viewModel.navigateTo(ScreenDestination.DOCTOR_DIAGNOSIS)
                onClose()
            }
            DrawerSubItem("3. वेटनरी औषधि व स्टॉक", Icons.Default.LocalPharmacy) {
                viewModel.navigateTo(ScreenDestination.DRUGS_DIRECTORY)
                onClose()
            }
            DrawerSubItem("4. शेफर्स खुराक कैलकुलेटर", Icons.Default.Calculate) {
                viewModel.navigateTo(ScreenDestination.DOSAGE_SAFETY)
                onClose()
            }
            DrawerSubItem("5. प्रजनन व सीमन कैटलॉग", Icons.Default.Pets) {
                viewModel.navigateTo(ScreenDestination.BREEDING_CATALOG)
                onClose()
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Accordion 2: Farmer Hub
        AccordionGroup(
            title = "🌾 जागरूक पशुपालक हब (Farmer)",
            isExpanded = expandedCategory == "farmer",
            onToggle = { expandedCategory = if (expandedCategory == "farmer") "" else "farmer" }
        ) {
            DrawerSubItem("1. डिजिटल पशु आधार पासबुक", Icons.Default.Badge) {
                viewModel.navigateTo(ScreenDestination.FARMER_PASSBOOK)
                onClose()
            }
            DrawerSubItem("2. दूध व फैट-एसएनएफ खाता", Icons.Default.Assessment) {
                viewModel.navigateTo(ScreenDestination.FARMER_MILK_CALC)
                onClose()
            }
            DrawerSubItem("3. 100% सुरक्षित देसी नुस्खे", Icons.Default.Eco) {
                viewModel.navigateTo(ScreenDestination.FARMER_DESI_NUSKHE)
                onClose()
            }
            DrawerSubItem("4. 280-दिन डिलीवरी कैलेंडर", Icons.Default.CalendarMonth) {
                viewModel.navigateTo(ScreenDestination.BREEDING_CATALOG)
                onClose()
            }
            DrawerSubItem("5. निकटतम डॉक्टर को इमरजेंसी SOS", Icons.Default.Phone) {
                viewModel.navigateTo(ScreenDestination.EMERGENCY_SOS)
                onClose()
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Accordion 3: Master Admin Vault
        AccordionGroup(
            title = "🛡️ अधिकृत एडमिन वॉल्ट (Admin)",
            isExpanded = expandedCategory == "admin",
            onToggle = { expandedCategory = if (expandedCategory == "admin") "" else "admin" }
        ) {
            DrawerSubItem("1. वित्तीय व रेवेन्यू एनालिटिक्स", Icons.Default.AccountBalanceWallet) {
                viewModel.navigateTo(ScreenDestination.ADMIN_FINANCIALS)
                onClose()
            }
            DrawerSubItem("2. बैंक व पेआउट सेटिंग्स", Icons.Default.CreditCard) {
                viewModel.navigateTo(ScreenDestination.ADMIN_PAYOUT)
                onClose()
            }
            DrawerSubItem("3. यूज़र व वीसीआई अप्रूवल", Icons.Default.VerifiedUser) {
                viewModel.navigateTo(ScreenDestination.ADMIN_USERS)
                onClose()
            }
            DrawerSubItem("4. नो-कोड लुक कस्टमाइज़र", Icons.Default.Palette) {
                viewModel.navigateTo(ScreenDestination.ADMIN_CUSTOMIZER)
                onClose()
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Quick Role Switch Bar at Bottom of Drawer
        Surface(
            color = Color.White,
            shape = RoundedCornerShape(14.dp),
            border = androidx.compose.foundation.BorderStroke(1.5.dp, FrostedCardBorder),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = "भूमिका बदलें (Switch Role):",
                    fontSize = 11.sp,
                    color = Slate900,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    RoleSmallButton("🩺 डॉ.", role == UserRole.DOCTOR, MedicalCyanPrimary) {
                        viewModel.setRole(UserRole.DOCTOR)
                        viewModel.navigateTo(ScreenDestination.DOCTOR_DIAGNOSIS)
                        onClose()
                    }
                    RoleSmallButton("🌾 किसान", role == UserRole.FARMER, AgroEmeraldPrimary) {
                        viewModel.setRole(UserRole.FARMER)
                        viewModel.navigateTo(ScreenDestination.FARMER_PASSBOOK)
                        onClose()
                    }
                    RoleSmallButton("🛡️ एडमिन", role == UserRole.ADMIN, RoyalIndigoPrimary) {
                        viewModel.setRole(UserRole.ADMIN)
                        viewModel.navigateTo(ScreenDestination.ADMIN_FINANCIALS)
                        onClose()
                    }
                }
            }
        }
    }
}

@Composable
fun AccordionGroup(
    title: String,
    isExpanded: Boolean,
    onToggle: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    val rotationAngle by animateFloatAsState(targetValue = if (isExpanded) 180f else 0f, label = "chevronRotate")

    Column(modifier = Modifier.fillMaxWidth()) {
        Surface(
            onClick = onToggle,
            color = if (isExpanded) TealDark else DaylightSurface,
            shape = RoundedCornerShape(12.dp),
            border = androidx.compose.foundation.BorderStroke(1.5.dp, if (isExpanded) TealDark else FrostedCardBorder),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isExpanded) Color.White else Slate900
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = if (isExpanded) Color.White else Slate900,
                    modifier = Modifier.rotate(rotationAngle)
                )
            }
        }

        AnimatedVisibility(
            visible = isExpanded,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {
            Surface(
                color = Color.White,
                shape = RoundedCornerShape(16.dp),
                border = androidx.compose.foundation.BorderStroke(1.5.dp, TealDark),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .shadow(3.dp)
            ) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    content = content
                )
            }
        }
    }
}

@Composable
fun DrawerSubItem(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        color = Color.White,
        shape = RoundedCornerShape(10.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, FrostedCardBorder),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 9.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = TealDark,
                modifier = Modifier.size(17.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Slate900
            )
        }
    }
}

@Composable
fun RoleSmallButton(
    label: String,
    isSelected: Boolean,
    activeColor: Color,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        color = if (isSelected) activeColor else Color.White,
        shape = RoundedCornerShape(8.dp),
        border = androidx.compose.foundation.BorderStroke(1.5.dp, if (isSelected) activeColor else FrostedCardBorder),
        modifier = Modifier.height(34.dp)
    ) {
        Box(
            modifier = Modifier.padding(horizontal = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = label,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = if (isSelected) Color.White else Slate900
            )
        }
    }
}

@Composable
fun CompactBottomToast(
    message: String?
) {
    AnimatedVisibility(
        visible = message != null,
        enter = slideInVertically(initialOffsetY = { it }) + fadeIn(),
        exit = slideOutVertically(targetOffsetY = { it }) + fadeOut(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp)
    ) {
        if (message != null) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Surface(
                    color = Color.White,
                    shape = RoundedCornerShape(24.dp),
                    border = androidx.compose.foundation.BorderStroke(2.dp, Slate900),
                    shadowElevation = 8.dp
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 18.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "🐾 $message",
                            color = Slate900,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Black
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TabSelectorButton(
    title: String,
    isSelected: Boolean,
    activeColor: Color = RoyalIndigoPrimary,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        color = if (isSelected) activeColor else Color.White,
        shape = RoundedCornerShape(10.dp),
        border = androidx.compose.foundation.BorderStroke(1.5.dp, if (isSelected) activeColor else FrostedCardBorder),
        modifier = modifier.height(38.dp)
    ) {
        Box(
            modifier = Modifier.padding(horizontal = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                color = if (isSelected) Color.White else Slate900,
                fontSize = 11.5.sp,
                fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
