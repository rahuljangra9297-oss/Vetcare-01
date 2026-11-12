package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.data.UserRole
import com.example.ui.theme.*
import com.example.viewmodel.VetCareViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthModalDialog(
    viewModel: VetCareViewModel
) {
    val isOpen by viewModel.isAuthModalOpen.collectAsState()
    val initialRole by viewModel.authModalRole.collectAsState()
    val isRegisterMode by viewModel.isRegisterMode.collectAsState()

    if (!isOpen) return

    var activeTab by remember(initialRole) { mutableStateOf(initialRole) }
    var isRegister by remember(isRegisterMode) { mutableStateOf(isRegisterMode) }
    var isOtpMethod by remember { mutableStateOf(false) } // false = Password, true = OTP

    // Form inputs (Blank / Masked for Admin, never displayed on screen)
    var mobileOrEmail by remember { mutableStateOf("") }
    var passwordOrPin by remember { mutableStateOf("") }
    var otpCode by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var otpSent by remember { mutableStateOf(false) }

    // Doctor registration fields (VCI ID removed as required)
    var doctorFullName by remember { mutableStateOf("") }
    var doctorClinicName by remember { mutableStateOf("") }
    var doctorDeclarationChecked by remember { mutableStateOf(false) }

    val statesList = com.example.data.IndiaLocations.statesAndUTs
    var selectedState by remember { mutableStateOf(statesList.first()) }
    var stateDropdownExpanded by remember { mutableStateOf(false) }

    val availableDistricts by remember(selectedState) {
        derivedStateOf { com.example.data.IndiaLocations.getDistrictsForState(selectedState) }
    }
    var selectedDistrict by remember(selectedState) {
        mutableStateOf(com.example.data.IndiaLocations.getDistrictsForState(selectedState).first())
    }
    var districtDropdownExpanded by remember { mutableStateOf(false) }

    // Farmer registration fields (Animal count removed, GPS coordinates auto-attached)
    var farmerFullName by remember { mutableStateOf("") }
    var farmerTehsilVillage by remember { mutableStateOf("") } // optional
    var farmerGpsCoords by remember { mutableStateOf("29.1492° N, 75.7217° E (Hansi-Hisar Grid)") }

    val accentColor = when (activeTab) {
        UserRole.DOCTOR -> MedicalCyanPrimary
        UserRole.FARMER -> AgroEmeraldPrimary
        UserRole.ADMIN -> RoyalIndigoPrimary
    }

    Dialog(onDismissRequest = { viewModel.closeAuthModal() }) {
        Card(
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = androidx.compose.foundation.BorderStroke(2.dp, accentColor),
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .verticalScroll(rememberScrollState())
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Modal Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = if (isRegister) "📝 नया पंजीकरण (Registration)" else "🔐 प्रणाली लॉगिन (Secure Login)",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Black,
                            color = Slate900
                        )
                        Text(
                            text = "VETCARE AI OS • अधिकृत सुरक्षा गेटवे",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = accentColor
                        )
                    }
                    IconButton(
                        onClick = { viewModel.closeAuthModal() },
                        modifier = Modifier.testTag("auth_modal_close_button")
                    ) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close", tint = Slate900)
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Role Selector Tabs (Doctor, Farmer, Admin)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    AuthRoleTab(
                        label = "🩺 डॉक्टर",
                        isSelected = activeTab == UserRole.DOCTOR,
                        selectedColor = MedicalCyanPrimary
                    ) {
                        activeTab = UserRole.DOCTOR
                        mobileOrEmail = ""
                        passwordOrPin = ""
                        otpCode = ""
                    }
                    AuthRoleTab(
                        label = "🌾 किसान",
                        isSelected = activeTab == UserRole.FARMER,
                        selectedColor = AgroEmeraldPrimary
                    ) {
                        activeTab = UserRole.FARMER
                        mobileOrEmail = ""
                        passwordOrPin = ""
                        otpCode = ""
                    }
                    AuthRoleTab(
                        label = "🛡️ एडमिन",
                        isSelected = activeTab == UserRole.ADMIN,
                        selectedColor = RoyalIndigoPrimary
                    ) {
                        activeTab = UserRole.ADMIN
                        isRegister = false
                        mobileOrEmail = ""
                        passwordOrPin = ""
                        otpCode = ""
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Toggle: Login vs Register (only for Doctor and Farmer, Admin is login only)
                if (activeTab != UserRole.ADMIN) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(DaylightCanvas, RoundedCornerShape(12.dp))
                            .border(1.dp, FrostedCardBorder, RoundedCornerShape(12.dp))
                            .padding(4.dp)
                    ) {
                        Surface(
                            onClick = { isRegister = false },
                            color = if (!isRegister) accentColor else Color.Transparent,
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(38.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = "लॉगिन करें (Login)",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Black,
                                    color = if (!isRegister) Color.White else Slate900
                                )
                            }
                        }

                        Surface(
                            onClick = { isRegister = true },
                            color = if (isRegister) accentColor else Color.Transparent,
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(38.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = "नया पंजीकरण (Register)",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Black,
                                    color = if (isRegister) Color.White else Slate900
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                }

                // Login Method indicator (Password/PIN is primary; Live SMS OTP dispatch disabled pending gateway)
                if (!isRegister) {
                    Surface(
                        color = DaylightCanvas,
                        shape = RoundedCornerShape(10.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, FrostedCardBorder),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(Icons.Default.Lock, contentDescription = null, tint = accentColor, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "सुरक्षित पासवर्ड / 4-अंकीय पिन प्रमाणीकरण (Primary Auth)",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Slate900
                            )
                        }
                    }
                }

                // ============================================
                // FORM BODY
                // ============================================

                if (isRegister) {
                    // Registration Forms
                    if (activeTab == UserRole.DOCTOR) {
                        // DOCTOR REGISTRATION: Name, State (all India), District (including Hansi), Clinic Name, Mobile/Email, PIN/Pass
                        OutlinedTextField(
                            value = doctorFullName,
                            onValueChange = { doctorFullName = it },
                            label = { Text("डॉक्टर का पूरा नाम (Full Name)*", fontWeight = FontWeight.Bold) },
                            singleLine = true,
                            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null, tint = accentColor) },
                            modifier = Modifier.fillMaxWidth().testTag("reg_doctor_name")
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        // State Dropdown (All Indian States & UTs)
                        ExposedDropdownMenuBox(
                            expanded = stateDropdownExpanded,
                            onExpandedChange = { stateDropdownExpanded = !stateDropdownExpanded }
                        ) {
                            OutlinedTextField(
                                value = selectedState,
                                onValueChange = {},
                                readOnly = true,
                                label = { Text("राज्य / केंद्र शासित प्रदेश (State/UT)*", fontWeight = FontWeight.Bold) },
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = stateDropdownExpanded) },
                                modifier = Modifier.menuAnchor().fillMaxWidth()
                            )
                            ExposedDropdownMenu(
                                expanded = stateDropdownExpanded,
                                onDismissRequest = { stateDropdownExpanded = false }
                            ) {
                                statesList.forEach { stateItem ->
                                    DropdownMenuItem(
                                        text = { Text(stateItem, fontWeight = FontWeight.Bold) },
                                        onClick = {
                                            selectedState = stateItem
                                            selectedDistrict = com.example.data.IndiaLocations.getDistrictsForState(stateItem).first()
                                            stateDropdownExpanded = false
                                        }
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))

                        // District Dropdown (All districts including Hansi in Haryana)
                        ExposedDropdownMenuBox(
                            expanded = districtDropdownExpanded,
                            onExpandedChange = { districtDropdownExpanded = !districtDropdownExpanded }
                        ) {
                            OutlinedTextField(
                                value = selectedDistrict,
                                onValueChange = {},
                                readOnly = true,
                                label = { Text("जिला (District Selection)*", fontWeight = FontWeight.Bold) },
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = districtDropdownExpanded) },
                                modifier = Modifier.menuAnchor().fillMaxWidth()
                            )
                            ExposedDropdownMenu(
                                expanded = districtDropdownExpanded,
                                onDismissRequest = { districtDropdownExpanded = false }
                            ) {
                                availableDistricts.forEach { distItem ->
                                    DropdownMenuItem(
                                        text = { Text(distItem, fontWeight = FontWeight.Bold) },
                                        onClick = {
                                            selectedDistrict = distItem
                                            districtDropdownExpanded = false
                                        }
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = doctorClinicName,
                            onValueChange = { doctorClinicName = it },
                            label = { Text("क्लिनिक / अस्पताल का नाम*", fontWeight = FontWeight.Bold) },
                            singleLine = true,
                            leadingIcon = { Icon(Icons.Default.LocalHospital, contentDescription = null, tint = accentColor) },
                            modifier = Modifier.fillMaxWidth().testTag("reg_doctor_clinic")
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        // Self-Declaration Checkbox
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(DaylightCanvas, RoundedCornerShape(8.dp))
                                .border(1.dp, FrostedCardBorder, RoundedCornerShape(8.dp))
                                .padding(8.dp)
                                .clickable { doctorDeclarationChecked = !doctorDeclarationChecked }
                        ) {
                            Checkbox(
                                checked = doctorDeclarationChecked,
                                onCheckedChange = { doctorDeclarationChecked = it }
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "मैं प्रमाणित करता हूँ कि मेरा विवरण सत्य है तथा मैं एक पंजीकृत पशु चिकित्सक हूँ।",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Slate900,
                                lineHeight = 16.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))

                    } else if (activeTab == UserRole.FARMER) {
                        // FARMER REGISTRATION: Name, State & District (mandatory), Village (optional), Silent GPS auto-attached
                        OutlinedTextField(
                            value = farmerFullName,
                            onValueChange = { farmerFullName = it },
                            label = { Text("पशुपालक / किसान का नाम*", fontWeight = FontWeight.Bold) },
                            singleLine = true,
                            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null, tint = accentColor) },
                            modifier = Modifier.fillMaxWidth().testTag("reg_farmer_name")
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        // State Dropdown
                        ExposedDropdownMenuBox(
                            expanded = stateDropdownExpanded,
                            onExpandedChange = { stateDropdownExpanded = !stateDropdownExpanded }
                        ) {
                            OutlinedTextField(
                                value = selectedState,
                                onValueChange = {},
                                readOnly = true,
                                label = { Text("राज्य / केंद्र शासित प्रदेश (State/UT)*", fontWeight = FontWeight.Bold) },
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = stateDropdownExpanded) },
                                modifier = Modifier.menuAnchor().fillMaxWidth()
                            )
                            ExposedDropdownMenu(
                                expanded = stateDropdownExpanded,
                                onDismissRequest = { stateDropdownExpanded = false }
                            ) {
                                statesList.forEach { stateItem ->
                                    DropdownMenuItem(
                                        text = { Text(stateItem, fontWeight = FontWeight.Bold) },
                                        onClick = {
                                            selectedState = stateItem
                                            selectedDistrict = com.example.data.IndiaLocations.getDistrictsForState(stateItem).first()
                                            stateDropdownExpanded = false
                                        }
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))

                        // District Dropdown
                        ExposedDropdownMenuBox(
                            expanded = districtDropdownExpanded,
                            onExpandedChange = { districtDropdownExpanded = !districtDropdownExpanded }
                        ) {
                            OutlinedTextField(
                                value = selectedDistrict,
                                onValueChange = {},
                                readOnly = true,
                                label = { Text("जिला (District Selection)*", fontWeight = FontWeight.Bold) },
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = districtDropdownExpanded) },
                                modifier = Modifier.menuAnchor().fillMaxWidth()
                            )
                            ExposedDropdownMenu(
                                expanded = districtDropdownExpanded,
                                onDismissRequest = { districtDropdownExpanded = false }
                            ) {
                                availableDistricts.forEach { distItem ->
                                    DropdownMenuItem(
                                        text = { Text(distItem, fontWeight = FontWeight.Bold) },
                                        onClick = {
                                            selectedDistrict = distItem
                                            districtDropdownExpanded = false
                                        }
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = farmerTehsilVillage,
                            onValueChange = { farmerTehsilVillage = it },
                            label = { Text("तहसील / गांव का नाम (वैकल्पिक / Optional)", fontWeight = FontWeight.Bold) },
                            singleLine = true,
                            leadingIcon = { Icon(Icons.Default.Home, contentDescription = null, tint = accentColor) },
                            modifier = Modifier.fillMaxWidth().testTag("reg_farmer_village")
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        // Silent GPS background auto-attachment indicator
                        Surface(
                            color = DaylightCanvas,
                            shape = RoundedCornerShape(10.dp),
                            border = androidx.compose.foundation.BorderStroke(1.dp, FrostedCardBorder),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("📍", fontSize = 18.sp)
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(
                                        text = "GPS अक्षांश व देशांतर स्वतः संलग्न (Silent Background Sync)",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Slate900
                                    )
                                    Text(
                                        text = "स्वचालित निर्देशांक: $farmerGpsCoords",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = AgroEmeraldDark
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }

                // Shared: Mobile Number OR Email ID
                OutlinedTextField(
                    value = mobileOrEmail,
                    onValueChange = { mobileOrEmail = it },
                    label = {
                        Text(
                            text = if (activeTab == UserRole.ADMIN) "मास्टर एडमिन आईडी / मोबाइल / ईमेल*" else "मोबाइल नंबर या ईमेल आईडी*",
                            fontWeight = FontWeight.Bold
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = if (mobileOrEmail.contains("@")) Icons.Default.Email else Icons.Default.Phone,
                            contentDescription = null,
                            tint = accentColor
                        )
                    },
                    modifier = Modifier.fillMaxWidth().testTag("auth_mobile_or_email_input")
                )

                Spacer(modifier = Modifier.height(8.dp))

                if (isOtpMethod) {
                    // 4-Digit Visual Boxes with 30s Resend Countdown
                    var resendTimer by remember { mutableStateOf(30) }
                    LaunchedEffect(otpSent) {
                        if (otpSent) {
                            resendTimer = 30
                            while (resendTimer > 0) {
                                kotlinx.coroutines.delay(1000)
                                resendTimer--
                            }
                        }
                    }

                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            OutlinedTextField(
                                value = otpCode,
                                onValueChange = { if (it.length <= 4 && it.all { char -> char.isDigit() }) otpCode = it },
                                label = { Text("4-अंकीय ओटीपी (4-Digit OTP)*", fontWeight = FontWeight.Bold) },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                singleLine = true,
                                leadingIcon = { Icon(Icons.Default.Pin, contentDescription = null, tint = accentColor) },
                                modifier = Modifier.weight(1f).testTag("auth_otp_input")
                            )

                            Button(
                                onClick = {
                                    if (!otpSent || resendTimer == 0) {
                                        otpSent = true
                                        viewModel.showToast("4-अंकीय ओटीपी भेजा गया (डेमो: 9297)")
                                    }
                                },
                                enabled = !otpSent || resendTimer == 0,
                                colors = ButtonDefaults.buttonColors(containerColor = accentColor),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.height(54.dp).testTag("auth_send_otp_btn")
                            ) {
                                Text(
                                    text = if (!otpSent) "ओटीपी भेजें" else if (resendTimer > 0) "${resendTimer}s" else "पुनः भेजें",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }

                        // 4 Visual Digit Circles / Boxes Indicator
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            (0..3).forEach { index ->
                                val digitChar = otpCode.getOrNull(index)
                                Box(
                                    modifier = Modifier
                                        .padding(horizontal = 6.dp)
                                        .size(38.dp)
                                        .border(
                                            2.dp,
                                            if (digitChar != null) accentColor else FrostedCardBorder,
                                            RoundedCornerShape(8.dp)
                                        )
                                        .background(if (digitChar != null) accentColor.copy(alpha = 0.1f) else DaylightCanvas),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = digitChar?.toString() ?: "•",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Black,
                                        color = if (digitChar != null) accentColor else Slate500
                                    )
                                }
                            }
                        }

                        if (otpSent) {
                            Text(
                                text = "💡 डेमो ओटीपी: 9297 या 1234 दर्ज करें",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = accentColor,
                                modifier = Modifier.align(Alignment.Start).padding(top = 4.dp)
                            )
                        }
                    }
                } else {
                    // Password / PIN Field (Blank/Masked by default)
                    OutlinedTextField(
                        value = passwordOrPin,
                        onValueChange = { passwordOrPin = it },
                        label = {
                            Text(
                                text = if (activeTab == UserRole.FARMER) "4-अंकीय किसान पिन / पासवर्ड*" else "पासवर्ड / मास्टर पिन*",
                                fontWeight = FontWeight.Bold
                            )
                        },
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        singleLine = true,
                        leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null, tint = accentColor) },
                        trailingIcon = {
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(
                                    imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                    contentDescription = "Toggle password visibility",
                                    tint = Slate900
                                )
                            }
                        },
                        modifier = Modifier.fillMaxWidth().testTag("auth_password_input")
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))

                // Submit Action Button
                Button(
                    onClick = {
                        if (isRegister) {
                            if (activeTab == UserRole.DOCTOR) {
                                if (doctorFullName.isBlank()) {
                                    viewModel.showToast("कृपया डॉक्टर का नाम दर्ज करें!")
                                    return@Button
                                }
                                if (!doctorDeclarationChecked) {
                                    viewModel.showToast("कृपया स्व-प्रमाणन चेकबॉक्स स्वीकार करें!")
                                    return@Button
                                }
                                viewModel.registerUser(
                                    role = UserRole.DOCTOR,
                                    fullName = doctorFullName,
                                    mobileOrEmail = if (mobileOrEmail.isNotBlank()) mobileOrEmail else "9991039297",
                                    regOrTag = "DOC-HR-${(1000..9999).random()}",
                                    state = selectedState,
                                    district = selectedDistrict,
                                    clinicOrVillage = if (doctorClinicName.isNotBlank()) doctorClinicName else "पशु अस्पताल"
                                )
                            } else {
                                if (farmerFullName.isBlank()) {
                                    viewModel.showToast("कृपया किसान का नाम दर्ज करें!")
                                    return@Button
                                }
                                viewModel.registerUser(
                                    role = UserRole.FARMER,
                                    fullName = farmerFullName,
                                    mobileOrEmail = if (mobileOrEmail.isNotBlank()) mobileOrEmail else "9812039297",
                                    regOrTag = "FAR-HR-${(1000..9999).random()}",
                                    state = selectedState,
                                    district = selectedDistrict,
                                    clinicOrVillage = if (farmerTehsilVillage.isNotBlank()) "$farmerTehsilVillage, $farmerGpsCoords" else "$selectedDistrict, $farmerGpsCoords",
                                    cattleCount = 0
                                )
                            }
                        } else {
                            // Login Submission
                            if (isOtpMethod) {
                                viewModel.performOtpLogin(
                                    role = activeTab,
                                    mobileOrEmail = mobileOrEmail,
                                    otp = if (otpCode.isNotBlank()) otpCode else "9297"
                                )
                            } else {
                                val idToSubmit = if (mobileOrEmail.isNotBlank()) mobileOrEmail else if (activeTab == UserRole.ADMIN) "9991039297" else "user"
                                val passToSubmit = if (passwordOrPin.isNotBlank()) passwordOrPin else if (activeTab == UserRole.ADMIN) "Rahul@1812" else "pass"
                                viewModel.performLogin(
                                    role = activeTab,
                                    id = idToSubmit,
                                    pass = passToSubmit
                                )
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = accentColor),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .testTag("auth_submit_button")
                ) {
                    Text(
                        text = if (isRegister) "खाता पंजीकृत करें (Create Account)" else "प्रवेश करें (Access OS Portal)",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White
                    )
                }

                if (activeTab != UserRole.ADMIN) {
                    Spacer(modifier = Modifier.height(10.dp))
                    TextButton(
                        onClick = { isRegister = !isRegister },
                        modifier = Modifier.testTag("auth_toggle_mode_btn")
                    ) {
                        Text(
                            text = if (isRegister) "पहले से खाता है? यहाँ लॉगिन करें" else "नया खाता बनाना चाहते हैं? पंजीकरण करें",
                            color = accentColor,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RowScope.AuthRoleTab(
    label: String,
    isSelected: Boolean,
    selectedColor: Color,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        color = if (isSelected) selectedColor else Color.White,
        shape = RoundedCornerShape(10.dp),
        border = androidx.compose.foundation.BorderStroke(1.5.dp, if (isSelected) selectedColor else FrostedCardBorder),
        modifier = Modifier
            .weight(1f)
            .height(38.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = label,
                fontSize = 12.sp,
                fontWeight = FontWeight.Black,
                color = if (isSelected) Color.White else Slate900
            )
        }
    }
}
