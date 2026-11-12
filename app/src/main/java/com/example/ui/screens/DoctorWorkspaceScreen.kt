package com.example.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.data.*
import com.example.ui.components.RxPdfGenerator
import com.example.ui.theme.*
import com.example.viewmodel.VetCareViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DoctorWorkspaceScreen(
    viewModel: VetCareViewModel
) {
    val diagMode by viewModel.diagnosticMode.collectAsState()
    val species by viewModel.selectedSpecies.collectAsState()
    val pregnancyStatus by viewModel.pregnancyStatus.collectAsState()
    val pregnancyMonth by viewModel.pregnancyMonth.collectAsState()
    val bodyWeightKg by viewModel.bodyWeightKg.collectAsState()
    val ageYears by viewModel.animalAgeYears.collectAsState()
    val selectedRegion by viewModel.selectedRegion.collectAsState()
    val compiledSymptoms by viewModel.compiledSymptomIds.collectAsState()
    val cardinalSign by viewModel.cardinalSignInput.collectAsState()
    val suspectedDiseaseId by viewModel.suspectedDiseaseId.collectAsState()
    val diagnosticResult by viewModel.diagnosticResult.collectAsState()
    val patientQueue by viewModel.patientQueue.collectAsState()
    val isListeningVoice by viewModel.isListeningVoice.collectAsState()
    val selectedTreatmentTab by viewModel.selectedTreatmentTab.collectAsState()
    val showAiSecondOpinion by viewModel.showAiSecondOpinion.collectAsState()
    val aiEvaluation by viewModel.aiEvaluation.collectAsState()

    val shaefferLength by viewModel.shaefferLengthInches.collectAsState()
    val shaefferGirth by viewModel.shaefferGirthInches.collectAsState()
    val attachedPhotoUri by viewModel.attachedPhotoUri.collectAsState()
    val selectedDrugSubstitute by viewModel.selectedDrugSubstitute.collectAsState()
    val drugSubstitutes by viewModel.drugSubstitutes.collectAsState()

    val selectedHotspot by viewModel.selectedHotspot.collectAsState()
    val selectedTemperature by viewModel.selectedTemperature.collectAsState()
    val maxInjectVolume = viewModel.getMaxInjectionVolumePerSite(species)
    val activeLabAnalysis by viewModel.activeLabReport.collectAsState()
    val showPharmacopeiaSheet by viewModel.showPharmacopeiaSheet.collectAsState()
    val pharmacopeiaSearch by viewModel.pharmacopeiaSearchQuery.collectAsState()
    val pharmacopeiaList by viewModel.pharmacopeiaList.collectAsState()
    val pharmacopeiaCategory by viewModel.pharmacopeiaCategoryFilter.collectAsState()
    val adminSettings by viewModel.adminSettings.collectAsState()
    val currentUser by viewModel.currentUser.collectAsState()

    val context = LocalContext.current

    val infiniteTransition = rememberInfiniteTransition(label = "pulseTransition")
    val pulseBorderAlpha by infiniteTransition.animateFloat(
        initialValue = 0.4f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulseAlpha"
    )

    val isDesktopToggle by viewModel.isDesktopModeManualToggle.collectAsState()

    BoxWithConstraints(modifier = Modifier.fillMaxSize().background(DaylightCanvas)) {
        val isWideScreen = (maxWidth >= 650.dp && isDesktopToggle != false) || isDesktopToggle == true

        if (isWideScreen) {
            // DESKTOP / TABLET DUAL-PANE LAYOUT
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(14.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // LEFT PANE: Input Parameters, Vitals, Symptoms & Photos
                LazyColumn(
                    modifier = Modifier
                        .weight(1.1f)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    // Header Banner
                    item {
                        Card(
                            shape = RoundedCornerShape(18.dp),
                            colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                            border = BorderStroke(2.dp, MedicalCyanPrimary),
                            modifier = Modifier.fillMaxWidth().shadow(4.dp, RoundedCornerShape(18.dp))
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(14.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(46.dp)
                                        .clip(CircleShape)
                                        .background(MedicalCyanLight)
                                        .border(2.dp, MedicalCyanPrimary, CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("🩺", fontSize = 24.sp)
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = "पशु चिकित्सक कार्यक्षेत्र (Desktop Dual-Pane)",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Black,
                                        color = Slate900
                                    )
                                    Text(
                                        text = "बाईं ओर: इनपुट व लक्षण • दाईं ओर: लाइव एआई निदान व पर्ची",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = MedicalCyanDark
                                    )
                                }
                            }
                        }
                    }

                    // 1. Patient Queue
                    item {
                        Card(
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                            border = BorderStroke(1.5.dp, FrostedCardBorder),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text("📋 सक्रिय ओपीडी कतार", fontSize = 12.sp, fontWeight = FontWeight.Black, color = Slate900)
                                    Surface(color = MedicalCyanLight, shape = RoundedCornerShape(6.dp), border = BorderStroke(1.dp, MedicalCyanPrimary)) {
                                        Text("${patientQueue.size} प्रतीक्षारत", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Slate900, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                                    }
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                                    items(patientQueue) { item ->
                                        PatientQueueCard(item = item, onLoad = { viewModel.loadPatientFromQueue(item) })
                                    }
                                }
                            }
                        }
                    }

                    // 2. Diagnostic Switcher & Vitals
                    item {
                        Card(
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                            border = BorderStroke(1.5.dp, FrostedCardBorder),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(14.dp)) {
                                Text("नैदानिक मोड:", fontSize = 12.sp, fontWeight = FontWeight.Black, color = Slate900)
                                Spacer(modifier = Modifier.height(6.dp))
                                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                    DiagnosticModeButton("लक्षण आधारित", diagMode == 1, modifier = Modifier.weight(1f)) { viewModel.setDiagnosticMode(1) }
                                    DiagnosticModeButton("क्रॉस-चेक", diagMode == 2, modifier = Modifier.weight(1f)) { viewModel.setDiagnosticMode(2) }
                                    DiagnosticModeButton("त्वरित गाइड", diagMode == 3, modifier = Modifier.weight(1f)) { viewModel.setDiagnosticMode(3) }
                                }
                                Spacer(modifier = Modifier.height(10.dp))

                                Text("प्रजाति (Species):", fontSize = 11.sp, color = Slate900, fontWeight = FontWeight.Bold)
                                Spacer(modifier = Modifier.height(4.dp))
                                Row(modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                    Species.values().forEach { sp ->
                                        FilterChip(
                                            selected = species == sp,
                                            onClick = { viewModel.setSpecies(sp) },
                                            label = { Text("${sp.icon} ${sp.hindiName}", fontWeight = FontWeight.Bold, fontSize = 11.sp) },
                                            colors = FilterChipDefaults.filterChipColors(selectedContainerColor = MedicalCyanPrimary, selectedLabelColor = Color.White)
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                Text("गर्भ स्थिति (Pregnancy):", fontSize = 11.sp, color = Slate900, fontWeight = FontWeight.Bold)
                                Spacer(modifier = Modifier.height(4.dp))
                                Row(modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                    PregnancyStatus.values().forEach { ps ->
                                        FilterChip(
                                            selected = pregnancyStatus == ps,
                                            onClick = { viewModel.setPregnancyStatus(ps) },
                                            label = { Text(ps.label, fontWeight = FontWeight.Bold, fontSize = 11.sp) },
                                            colors = FilterChipDefaults.filterChipColors(selectedContainerColor = if (ps == PregnancyStatus.PREGNANT) RedAlert else MedicalCyanPrimary, selectedLabelColor = Color.White)
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                // Shaeffer Calculator inside Desktop Left Pane (Species-Calibrated)
                                Surface(
                                    color = TealLight,
                                    shape = RoundedCornerShape(10.dp),
                                    border = BorderStroke(1.dp, TealAccent),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Column(modifier = Modifier.padding(10.dp)) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text("⚖️ शेफर्स वजन कैलकुलेटर", fontSize = 11.sp, fontWeight = FontWeight.Black, color = Slate900)
                                            Surface(color = Color.White, shape = RoundedCornerShape(6.dp), border = BorderStroke(1.dp, TealAccent)) {
                                                Text("अनुमानित वजन: ${bodyWeightKg} kg", fontSize = 11.sp, fontWeight = FontWeight.Black, color = TealDark, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                                            }
                                        }
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text(
                                            text = "अधिकतम इंजेक्शन मात्रा: ${maxInjectVolume} ml प्रति साइट",
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = RedAlert
                                        )
                                        Spacer(modifier = Modifier.height(6.dp))
                                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                            Column(modifier = Modifier.weight(1f)) {
                                                Text("लंबाई: ${shaefferLength.toInt()}\"", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Slate900)
                                                Slider(value = shaefferLength.toFloat(), onValueChange = { viewModel.updateShaefferDimensions(it.toDouble(), shaefferGirth) }, valueRange = 20f..100f, colors = SliderDefaults.colors(thumbColor = TealAccent, activeTrackColor = TealAccent))
                                            }
                                            Column(modifier = Modifier.weight(1f)) {
                                                Text("घेरा: ${shaefferGirth.toInt()}\"", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Slate900)
                                                Slider(value = shaefferGirth.toFloat(), onValueChange = { viewModel.updateShaefferDimensions(shaefferLength, it.toDouble()) }, valueRange = 25f..110f, colors = SliderDefaults.colors(thumbColor = TealAccent, activeTrackColor = TealAccent))
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    // 3. Mutually Exclusive Body Temperature Chips & 9 Independent Anatomical Hotspots
                    item {
                        Card(
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                            border = BorderStroke(1.5.dp, FrostedCardBorder),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(14.dp)) {
                                Text("🌡️ शरीर तापमान (एकल चयन):", fontSize = 12.sp, fontWeight = FontWeight.Black, color = Slate900)
                                Spacer(modifier = Modifier.height(6.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    TemperatureRange.values().forEach { temp ->
                                        val isSelected = selectedTemperature == temp
                                        FilterChip(
                                            selected = isSelected,
                                            onClick = { viewModel.setSelectedTemperature(temp) },
                                            label = { Text("${temp.labelHindi} (${temp.tempFahrenheit})", fontSize = 10.5.sp, fontWeight = FontWeight.Bold) },
                                            colors = FilterChipDefaults.filterChipColors(
                                                selectedContainerColor = if (temp == TemperatureRange.HIGH_FEVER) RedAlert else MedicalCyanPrimary,
                                                selectedLabelColor = Color.White
                                            )
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(12.dp))
                                Text("🐄 9 स्वतंत्र शारीरिक अंग (Anatomical Hotspots):", fontSize = 12.sp, fontWeight = FontWeight.Black, color = Slate900)
                                Spacer(modifier = Modifier.height(6.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    AnatomicalHotspot.values().forEach { spot ->
                                        val isSelected = selectedHotspot == spot
                                        Surface(
                                            onClick = { viewModel.setSelectedHotspot(spot) },
                                            color = if (isSelected) MedicalCyanPrimary else DaylightCanvas,
                                            shape = RoundedCornerShape(8.dp),
                                            border = BorderStroke(1.dp, if (isSelected) MedicalCyanPrimary else FrostedCardBorder)
                                        ) {
                                            Text(
                                                text = "${spot.icon} ${spot.labelHindi}",
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = if (isSelected) Color.White else Slate900,
                                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
                                            )
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                val filteredSymptoms = VeterinaryKnowledgeBase.symptomsList.filter {
                                    it.region == selectedHotspot.legacyRegion || selectedHotspot.legacyRegion == AnatomicalRegion.ALL
                                }

                                FlowRow(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                                    verticalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    filteredSymptoms.forEach { sym ->
                                        val isChecked = compiledSymptoms.contains(sym.id)
                                        FilterChip(
                                            selected = isChecked,
                                            onClick = { viewModel.toggleSymptom(sym.id) },
                                            label = { Text(sym.labelHindi, fontSize = 11.sp, fontWeight = FontWeight.Bold) },
                                            colors = FilterChipDefaults.filterChipColors(selectedContainerColor = MedicalCyanPrimary, selectedLabelColor = Color.White)
                                        )
                                    }
                                }
                            }
                        }
                    }

                    // 4. Clinical Photo & Multimodal Lab Report Analyzer
                    item {
                        val photoPickerLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
                            if (uri != null) viewModel.setAttachedPhotoUri(uri.toString())
                        }
                        val reportPickerLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
                            if (uri != null) viewModel.analyzeUploadedReport("CBC_Blood_Smear_Report.pdf")
                        }

                        Card(
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                            border = BorderStroke(1.5.dp, FrostedCardBorder),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(14.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text("📷 फोटो एवं लैब रिपोर्ट AI विश्लेषक", fontSize = 12.sp, fontWeight = FontWeight.Black, color = Slate900)
                                    Button(
                                        onClick = { viewModel.openPharmacopeiaSheet() },
                                        colors = ButtonDefaults.buttonColors(containerColor = Slate900),
                                        shape = RoundedCornerShape(8.dp),
                                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                                        modifier = Modifier.height(28.dp)
                                    ) {
                                        Text("💊 फार्माकोपिया", fontSize = 10.sp, color = Color.White)
                                    }
                                }
                                Spacer(modifier = Modifier.height(8.dp))

                                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                    OutlinedButton(
                                        onClick = { photoPickerLauncher.launch("image/*") },
                                        modifier = Modifier.weight(1f).height(38.dp),
                                        shape = RoundedCornerShape(8.dp)
                                    ) {
                                        Text(if (attachedPhotoUri != null) "✓ फोटो संलग्न" else "📷 फोटो चुनें", fontSize = 11.sp, color = MedicalCyanPrimary)
                                    }
                                    Button(
                                        onClick = { reportPickerLauncher.launch("*/*") },
                                        modifier = Modifier.weight(1f).height(38.dp),
                                        shape = RoundedCornerShape(8.dp),
                                        colors = ButtonDefaults.buttonColors(containerColor = MedicalCyanPrimary)
                                    ) {
                                        Text("🔬 लैब रिपोर्ट स्कैन", fontSize = 11.sp, color = Color.White)
                                    }
                                }

                                if (activeLabAnalysis != null) {
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Surface(
                                        color = MedicalCyanLight,
                                        shape = RoundedCornerShape(8.dp),
                                        border = BorderStroke(1.dp, MedicalCyanPrimary),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(modifier = Modifier.padding(8.dp)) {
                                            Text("📋 AI रिपोर्ट: ${activeLabAnalysis!!.reportType}", fontSize = 11.sp, fontWeight = FontWeight.Black, color = Slate900)
                                            Text("संभावित निदान: ${activeLabAnalysis!!.tentativeDiagnosis}", fontSize = 10.sp, color = MedicalCyanDark, fontWeight = FontWeight.Bold)
                                            if (activeLabAnalysis!!.criticalAlert.isNotBlank()) {
                                                Text("⚠️ ${activeLabAnalysis!!.criticalAlert}", fontSize = 10.sp, color = RedAlert, fontWeight = FontWeight.Black)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    item {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Button(onClick = { viewModel.runDiagnosis() }, colors = ButtonDefaults.buttonColors(containerColor = MedicalCyanPrimary), shape = RoundedCornerShape(12.dp), modifier = Modifier.weight(1f).height(48.dp)) {
                                Text("🩺 निदान चलाएं", fontSize = 12.sp, fontWeight = FontWeight.Black, color = Color.White)
                            }
                            Button(onClick = { viewModel.evaluateAiSecondOpinion() }, colors = ButtonDefaults.buttonColors(containerColor = RoyalIndigoPrimary), shape = RoundedCornerShape(12.dp), modifier = Modifier.weight(1f).height(48.dp)) {
                                Text("🤖 सेकंड ओपिनियन", fontSize = 12.sp, fontWeight = FontWeight.Black, color = Color.White)
                            }
                        }
                    }
                }

                // RIGHT PANE: Live Diagnosis, 5-Tier Treatment & Prescription
                LazyColumn(
                    modifier = Modifier
                        .weight(1.3f)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    diagnosticResult?.let { result ->
                        item {
                            ClinicalPrescriptionPad(
                                result = result,
                                isPregnant = pregnancyStatus == PregnancyStatus.PREGNANT,
                                pregnancyMonth = pregnancyMonth,
                                selectedTab = selectedTreatmentTab,
                                onSelectTab = { viewModel.setSelectedTreatmentTab(it) },
                                onSelectGenericSalt = { viewModel.openDrugSubstitute(it) },
                                onPrint = {
                                    RxPdfGenerator.printDocument(
                                        context = context,
                                        result = result,
                                        patientName = "टैग #UP-78-4091 (${species.hindiName})",
                                        doctorName = currentUser?.name ?: "Dr. Rahul Jangra, B.V.Sc & A.H.",
                                        councilReg = currentUser?.regOrTagNo ?: "VCI-89241",
                                        clinicTitle = adminSettings.clinicName.ifBlank { "VETCARE AI OS (CLINICAL TELE-PRESCRIPTION)" },
                                        clinicSubtitle = adminSettings.clinicSubtitle.ifBlank { "Authorized Veterinary Practitioner Portal | ISO 9001:2026 Compliant Rx" }
                                    )
                                },
                                onPdfShare = {
                                    RxPdfGenerator.generateAndSharePdf(
                                        context = context,
                                        result = result,
                                        patientName = "टैग #UP-78-4091 (${species.hindiName})",
                                        doctorName = currentUser?.name ?: "Dr. Rahul Jangra, B.V.Sc & A.H.",
                                        councilReg = currentUser?.regOrTagNo ?: "VCI-89241",
                                        clinicTitle = adminSettings.clinicName.ifBlank { "VETCARE AI OS (CLINICAL TELE-PRESCRIPTION)" },
                                        clinicSubtitle = adminSettings.clinicSubtitle.ifBlank { "Authorized Veterinary Practitioner Portal | ISO 9001:2026 Compliant Rx" }
                                    )
                                },
                                onWhatsApp = {
                                    val text = viewModel.generateWhatsAppPrescription()
                                    val sendIntent = Intent().apply {
                                        action = Intent.ACTION_SEND
                                        putExtra(Intent.EXTRA_TEXT, text)
                                        type = "text/plain"
                                    }
                                    try {
                                        context.startActivity(Intent.createChooser(sendIntent, "पर्ची WhatsApp पर भेजें"))
                                    } catch (e: Exception) {
                                        viewModel.showToast("शेयरिंग उपलब्ध नहीं है")
                                    }
                                },
                                onRecordBill = { total, paid, status, mode, notes ->
                                    viewModel.recordOpdBilling(
                                        patientTag = "टैग #UP-78-4091 (${species.hindiName})",
                                        ownerName = "राजेश कुमार (पशुपालक)",
                                        ownerPhone = "9896123490",
                                        totalAmount = total,
                                        paidAmount = paid,
                                        status = status,
                                        mode = mode,
                                        notes = "${result.disease.hindiName} - $notes"
                                    )
                                },
                                onNavigateToFinance = { viewModel.navigateTo(ScreenDestination.DOCTOR_FINANCE) }
                            )
                        }
                    } ?: item {
                        Card(
                            shape = RoundedCornerShape(18.dp),
                            colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                            border = BorderStroke(1.5.dp, FrostedCardBorder),
                            modifier = Modifier.fillMaxWidth().padding(top = 40.dp)
                        ) {
                            Column(modifier = Modifier.fillMaxWidth().padding(30.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("🔬", fontSize = 42.sp)
                                Spacer(modifier = Modifier.height(10.dp))
                                Text("लाइव एआई निदान प्रतीक्षारत", fontSize = 16.sp, fontWeight = FontWeight.Black, color = Slate900)
                                Text("बाईं ओर लक्षण चुनें और 'निदान चलाएं' पर टैप करें।", fontSize = 12.sp, color = Slate500)
                            }
                        }
                    }
                }
            }
        } else {
            // SINGLE-COLUMN MOBILE TOUCH LAYOUT
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DaylightCanvas)
                    .padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
        // Workspace Header Banner
        item {
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                border = BorderStroke(2.dp, MedicalCyanPrimary),
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(4.dp, RoundedCornerShape(18.dp))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(MedicalCyanLight)
                            .border(2.dp, MedicalCyanPrimary, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("🩺", fontSize = 26.sp)
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "अधिकृत पशु चिकित्सक कार्यक्षेत्र (Doctor Console)",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Black,
                            color = Slate900
                        )
                        Text(
                            text = "5-स्तरीय एआई रोग निदान • शेफर्स खुराक कैलकुलेटर • डिजिटल ओपीडी पर्ची",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Slate900
                        )
                    }
                }
            }
        }

        // 1. Horizontal Patient Queue Carousel
        item {
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                border = BorderStroke(1.5.dp, FrostedCardBorder),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f, fill = false)
                        ) {
                            Text("📋", fontSize = 16.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "सक्रिय ओपीडी कतार (Live Queue)",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Black,
                                color = Slate900,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Surface(
                            color = MedicalCyanLight,
                            shape = RoundedCornerShape(6.dp),
                            border = BorderStroke(1.dp, MedicalCyanPrimary)
                        ) {
                            Text(
                                text = "${patientQueue.size} मरीज",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Slate900,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(patientQueue) { item ->
                            PatientQueueCard(
                                item = item,
                                onLoad = { viewModel.loadPatientFromQueue(item) }
                            )
                        }
                    }
                }
            }
        }

        // 2. 3-Way Diagnostic Mode Switcher
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                border = BorderStroke(1.5.dp, FrostedCardBorder),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = "नैदानिक कार्यप्रणाली (3-Way Diagnostic Switcher):",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Black,
                        color = Slate900
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        DiagnosticModeButton("मोड 1: लक्षण आधारित", diagMode == 1, modifier = Modifier.weight(1f)) {
                            viewModel.setDiagnosticMode(1)
                        }
                        DiagnosticModeButton("मोड 2: क्रॉस-चेक", diagMode == 2, modifier = Modifier.weight(1f)) {
                            viewModel.setDiagnosticMode(2)
                        }
                        DiagnosticModeButton("मोड 3: त्वरित गाइड", diagMode == 3, modifier = Modifier.weight(1f)) {
                            viewModel.setDiagnosticMode(3)
                        }
                    }
                }
            }
        }

        // 3. Patient Vitals & History + Shaeffer's Weight Formula
        item {
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                border = BorderStroke(1.5.dp, FrostedCardBorder),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "रोगी इतिहास एवं वाइटल्स (Patient Vitals):",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Black,
                        color = Slate900
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(text = "पशु प्रजाति (Species):", fontSize = 12.sp, color = Slate900, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Species.values().forEach { sp ->
                            FilterChip(
                                selected = species == sp,
                                onClick = { viewModel.setSpecies(sp) },
                                label = { Text("${sp.icon} ${sp.hindiName}", fontWeight = FontWeight.Bold) },
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = MedicalCyanPrimary,
                                    selectedLabelColor = Color.White,
                                    containerColor = DaylightSurface
                                ),
                                border = FilterChipDefaults.filterChipBorder(
                                    borderColor = if (species == sp) MedicalCyanPrimary else FrostedCardBorder,
                                    selectedBorderColor = MedicalCyanPrimary,
                                    borderWidth = 1.5.dp,
                                    selectedBorderWidth = 2.dp,
                                    enabled = true,
                                    selected = species == sp
                                )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(text = "गर्भ स्थिति (Pregnancy Status):", fontSize = 12.sp, color = Slate900, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        PregnancyStatus.values().forEach { ps ->
                            FilterChip(
                                selected = pregnancyStatus == ps,
                                onClick = { viewModel.setPregnancyStatus(ps) },
                                label = { Text(ps.label, fontWeight = FontWeight.Bold) },
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = if (ps == PregnancyStatus.PREGNANT) RedAlert else MedicalCyanPrimary,
                                    selectedLabelColor = Color.White,
                                    containerColor = DaylightSurface
                                ),
                                border = FilterChipDefaults.filterChipBorder(
                                    borderColor = if (pregnancyStatus == ps) MedicalCyanPrimary else FrostedCardBorder,
                                    selectedBorderColor = if (ps == PregnancyStatus.PREGNANT) RedAlert else MedicalCyanPrimary,
                                    borderWidth = 1.5.dp,
                                    selectedBorderWidth = 2.dp,
                                    enabled = true,
                                    selected = pregnancyStatus == ps
                                )
                            )
                        }
                    }

                    if (pregnancyStatus == PregnancyStatus.PREGNANT) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Surface(
                            color = RedAlertLight,
                            shape = RoundedCornerShape(12.dp),
                            border = BorderStroke(2.dp, RedAlert),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {
                                Text(
                                    text = "🔴 गर्भ का महीना: $pregnancyMonth वां महीना (स्टेरॉयड/एलबेंडाजोल सख्त निषेध)",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Black,
                                    color = RedAlert
                                )
                                Slider(
                                    value = pregnancyMonth.toFloat(),
                                    onValueChange = { viewModel.setPregnancyMonth(it.toInt()) },
                                    valueRange = 1f..9f,
                                    steps = 7,
                                    colors = SliderDefaults.colors(
                                        thumbColor = RedAlert,
                                        activeTrackColor = RedAlert
                                    )
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Shaeffer's Weight Calculator Horizontal Card with Flexible Inputs & Instant Weight
                    Surface(
                        color = TealLight,
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(1.dp, TealAccent),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "⚖️ शेफर्स वजन कैलकुलेटर (Shaeffer Formula)",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Black,
                                    color = Slate900
                                )
                                Surface(
                                    color = Color.White,
                                    shape = RoundedCornerShape(8.dp),
                                    border = BorderStroke(1.5.dp, TealAccent)
                                ) {
                                    Text(
                                        text = "अनुमानित वजन: ${bodyWeightKg} kg",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Black,
                                        color = TealDark,
                                        maxLines = 1,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "अधिकतम इंजेक्शन मात्रा: ${maxInjectVolume} ml प्रति साइट",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = RedAlert
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Formula: (लंबाई × सीने का घेरा²) / 300 = वजन (पाउंड) ➔ किलोग्राम (${species.hindiName} अनुसार स्केल्ड)",
                                fontSize = 10.sp,
                                color = Slate900
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text("लंबाई (L):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Slate900)
                                        Text("${shaefferLength.toInt()} इंच", fontSize = 11.sp, fontWeight = FontWeight.Black, color = TealDark)
                                    }
                                    Slider(
                                        value = shaefferLength.toFloat(),
                                        onValueChange = { viewModel.updateShaefferDimensions(it.toDouble(), shaefferGirth) },
                                        valueRange = 20f..100f,
                                        colors = SliderDefaults.colors(thumbColor = TealAccent, activeTrackColor = TealAccent)
                                    )
                                }
                                Column(modifier = Modifier.weight(1f)) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text("सीने का घेरा (G):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Slate900)
                                        Text("${shaefferGirth.toInt()} इंच", fontSize = 11.sp, fontWeight = FontWeight.Black, color = TealDark)
                                    }
                                    Slider(
                                        value = shaefferGirth.toFloat(),
                                        onValueChange = { viewModel.updateShaefferDimensions(shaefferLength, it.toDouble()) },
                                        valueRange = 25f..110f,
                                        colors = SliderDefaults.colors(thumbColor = TealAccent, activeTrackColor = TealAccent)
                                    )
                                }
                            }
                        }
                    }

                    if (diagMode == 2 || diagMode == 3) {
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = if (diagMode == 2) "संदेहास्पद रोग (Cross-Check):" else "प्रत्यक्ष रोग का चयन करें:",
                            fontSize = 12.sp,
                            color = Slate900,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            VeterinaryKnowledgeBase.diseasesList.forEach { dis ->
                                FilterChip(
                                    selected = suspectedDiseaseId == dis.id,
                                    onClick = { viewModel.setSuspectedDisease(dis.id) },
                                    label = { Text(dis.hindiName, fontWeight = FontWeight.Bold) },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = MedicalCyanPrimary,
                                        selectedLabelColor = Color.White,
                                        containerColor = DaylightSurface
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }

        // 4. 🐄 9 Independent Anatomical Hotspots & Single-Choice Temperature Range Chips
        item {
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                border = BorderStroke(1.5.dp, FrostedCardBorder),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "🌡️ शरीर तापमान (परस्पर अनन्य / Single-Choice):",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Black,
                        color = Slate900
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        TemperatureRange.values().forEach { temp ->
                            val isSelected = selectedTemperature == temp
                            FilterChip(
                                selected = isSelected,
                                onClick = { viewModel.setSelectedTemperature(temp) },
                                label = { Text("${temp.labelHindi} (${temp.tempFahrenheit})", fontSize = 11.sp, fontWeight = FontWeight.Bold) },
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = if (temp == TemperatureRange.HIGH_FEVER) RedAlert else MedicalCyanPrimary,
                                    selectedLabelColor = Color.White
                                )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))
                    Text(
                        text = "🐄 9 स्वतंत्र शारीरिक अंग (Independent Anatomical Hotspots):",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Black,
                        color = Slate900
                    )
                    Text(
                        text = "अंग पर टैप करें और समर्पित उप-सूची (Sub-List Chips) में से लक्षण चुनें:",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Slate900
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    // Horizontal Sliding 9 Independent Hotspot Cards
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(AnatomicalHotspot.values()) { spot ->
                            val isSelected = selectedHotspot == spot
                            val matchingCount = VeterinaryKnowledgeBase.symptomsList.count {
                                it.region == spot.legacyRegion && compiledSymptoms.contains(it.id)
                            }

                            Surface(
                                onClick = { viewModel.setSelectedHotspot(spot) },
                                color = if (isSelected) MedicalCyanLight else Color.White,
                                shape = RoundedCornerShape(12.dp),
                                border = BorderStroke(if (isSelected) 2.dp else 1.2.dp, if (isSelected) MedicalCyanPrimary else FrostedCardBorder),
                                modifier = Modifier
                                    .width(145.dp)
                                    .height(72.dp)
                            ) {
                                Column(
                                    modifier = Modifier.padding(8.dp),
                                    verticalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(spot.icon, fontSize = 16.sp)
                                        if (matchingCount > 0) {
                                            Surface(
                                                color = MedicalCyanPrimary,
                                                shape = CircleShape
                                            ) {
                                                Text(
                                                    text = "$matchingCount",
                                                    color = Color.White,
                                                    fontSize = 9.sp,
                                                    fontWeight = FontWeight.Black,
                                                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
                                                )
                                            }
                                        }
                                    }
                                    Text(
                                        text = spot.labelHindi,
                                        fontSize = 11.sp,
                                        fontWeight = if (isSelected) FontWeight.Black else FontWeight.Bold,
                                        color = if (isSelected) MedicalCyanDark else Slate900,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = "उप-लक्षण सूची (Sub-List Chips - ${selectedHotspot.labelHindi}):",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = MedicalCyanDark
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    val filteredSymptoms = VeterinaryKnowledgeBase.symptomsList.filter {
                        it.region == selectedHotspot.legacyRegion || selectedHotspot.legacyRegion == AnatomicalRegion.ALL
                    }

                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        filteredSymptoms.forEach { sym ->
                            val isChecked = compiledSymptoms.contains(sym.id)
                            FilterChip(
                                selected = isChecked,
                                onClick = { viewModel.toggleSymptom(sym.id) },
                                label = {
                                    Text(
                                        text = sym.labelHindi,
                                        fontSize = 11.sp,
                                        fontWeight = if (isChecked) FontWeight.Black else FontWeight.Bold,
                                        color = if (isChecked) Color.White else Slate900
                                    )
                                },
                                leadingIcon = if (isChecked) {
                                    { Icon(Icons.Default.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(15.dp)) }
                                } else null,
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = MedicalCyanPrimary,
                                    selectedLabelColor = Color.White,
                                    containerColor = Color.White
                                )
                            )
                        }
                    }
                }
            }
        }

        // 5. 📦 Dynamic Compiled Lakshan Bank & 🎙️ Voice Dictation
        item {
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                border = BorderStroke(2.dp, MedicalCyanPrimary),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "📦 संकलित नैदानिक लक्षण बैंक",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Black,
                                color = Slate900
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Surface(
                                color = MedicalCyanPrimary,
                                shape = CircleShape
                            ) {
                                Text(
                                    text = "${compiledSymptoms.size}",
                                    color = Color.White,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Black,
                                    modifier = Modifier.padding(horizontal = 7.dp, vertical = 2.dp)
                                )
                            }
                        }

                        if (compiledSymptoms.isNotEmpty()) {
                            TextButton(onClick = { viewModel.clearSymptoms() }) {
                                Text("🗑️ सब साफ़ करें", color = RedAlert, fontSize = 12.sp, fontWeight = FontWeight.Black)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    if (compiledSymptoms.isEmpty()) {
                        Text(
                            text = "कोई लक्षण नहीं चुना गया। ऊपर अंगों में से लक्षण चुनें या नीचे वॉइस माइक से बोलें।",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Slate900
                        )
                    } else {
                        FlowRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            compiledSymptoms.forEach { symId ->
                                val sym = VeterinaryKnowledgeBase.symptomsList.find { it.id == symId }
                                Surface(
                                    color = MedicalCyanLight,
                                    shape = RoundedCornerShape(12.dp),
                                    border = BorderStroke(1.5.dp, MedicalCyanPrimary)
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                                    ) {
                                        Text(
                                            text = sym?.labelHindi ?: symId,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Black,
                                            color = Slate900
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Icon(
                                            imageVector = Icons.Default.Close,
                                            contentDescription = "Remove",
                                            tint = RedAlert,
                                            modifier = Modifier
                                                .size(14.dp)
                                                .clickable { viewModel.toggleSymptom(symId) }
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Voice Dictation Button & Phrase Chips
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = { viewModel.toggleVoiceDictation() },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isListeningVoice) RedAlert else MedicalCyanPrimary
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Icon(
                                imageVector = if (isListeningVoice) Icons.Default.MicOff else Icons.Default.Mic,
                                contentDescription = "Voice Input",
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isListeningVoice) "सुन रहा हूँ..." else "बोलकर लक्षण जोड़ें",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 12.sp
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Row(
                            modifier = Modifier
                                .weight(1f)
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            VoicePhraseChip("तेज बुखार व लार") { viewModel.processVoiceInput(it) }
                            VoicePhraseChip("थन में सूजन व छेछड़े") { viewModel.processVoiceInput(it) }
                            VoicePhraseChip("आफरा व गैस") { viewModel.processVoiceInput(it) }
                            VoicePhraseChip("कॉफी रंग पेशाब") { viewModel.processVoiceInput(it) }
                            VoicePhraseChip("गले में गर्म सूजन") { viewModel.processVoiceInput(it) }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Cardinal Sign Text Input
                    OutlinedTextField(
                        value = cardinalSign,
                        onValueChange = { viewModel.setCardinalSign(it) },
                        label = { Text("🚨 विशिष्ट प्रधान लक्षण (Cardinal / Pathognomonic Sign)", fontWeight = FontWeight.Bold) },
                        placeholder = { Text("उदा. गले में सूजन, चड़-चड़ आवाज, कॉफी रंग पेशाब") },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(BorderStroke(2.dp, RedAlert.copy(alpha = pulseBorderAlpha)), RoundedCornerShape(8.dp))
                    )
                }
            }
        }

        // 📷 Clinical Photo Attachment Card with Instant Thumbnail Preview
        item {
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                border = BorderStroke(1.5.dp, FrostedCardBorder),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("📷", fontSize = 18.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Text(
                                    text = "नैदानिक फोटो / थन-घाव तस्वीर (Clinical Photo)",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Black,
                                    color = Slate900
                                )
                                Text(
                                    text = "एआई इमेज विजन व डॉक्टर क्रॉस-रेफरेंस",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MedicalCyanDark
                                )
                            }
                        }

                        if (attachedPhotoUri != null) {
                            TextButton(onClick = { viewModel.setAttachedPhoto(null) }) {
                                Text("हटाएं ✕", color = RedAlert, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    val photoPickerLauncher = rememberLauncherForActivityResult(
                        contract = ActivityResultContracts.GetContent()
                    ) { uri: Uri? ->
                        if (uri != null) {
                            viewModel.setAttachedPhotoUri(uri.toString())
                        }
                    }

                    if (attachedPhotoUri != null) {
                        Surface(
                            color = MedicalCyanLight,
                            shape = RoundedCornerShape(12.dp),
                            border = BorderStroke(1.5.dp, MedicalCyanPrimary),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(56.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(Color.White)
                                        .border(1.5.dp, MedicalCyanPrimary, RoundedCornerShape(10.dp)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("🐄📸", fontSize = 24.sp)
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    Text("तस्वीर संलग्न: थन सूजन व घाव (Clinical Photo)", fontSize = 12.sp, fontWeight = FontWeight.Black, color = Slate900)
                                    Text("URI: ${attachedPhotoUri!!.take(24)}... • साइज: अनुकूलित", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Slate900)
                                    Text("स्थिति: एआई इमेज विजन विश्लेषण तैयार ✅", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = GreenSuccess)
                                }
                            }
                        }
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            OutlinedButton(
                                onClick = { photoPickerLauncher.launch("image/*") },
                                shape = RoundedCornerShape(10.dp),
                                border = BorderStroke(1.5.dp, MedicalCyanPrimary),
                                modifier = Modifier.weight(1f).height(44.dp)
                            ) {
                                Icon(Icons.Default.AddPhotoAlternate, contentDescription = null, tint = MedicalCyanPrimary)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("फोटो चुनें", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = MedicalCyanPrimary)
                            }

                            val reportPickerLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
                                if (uri != null) viewModel.analyzeUploadedReport("CBC_Milk_Test.pdf")
                            }

                            Button(
                                onClick = { reportPickerLauncher.launch("*/*") },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = MedicalCyanPrimary),
                                modifier = Modifier.weight(1f).height(44.dp)
                            ) {
                                Text("🔬 लैब रिपोर्ट स्कैन", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            }
                        }

                        if (activeLabAnalysis != null) {
                            Spacer(modifier = Modifier.height(10.dp))
                            Surface(
                                color = MedicalCyanLight,
                                shape = RoundedCornerShape(10.dp),
                                border = BorderStroke(1.2.dp, MedicalCyanPrimary),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(modifier = Modifier.padding(10.dp)) {
                                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                        Text("📋 रिपोर्ट प्रकार: ${activeLabAnalysis!!.reportType}", fontSize = 11.sp, fontWeight = FontWeight.Black, color = Slate900)
                                        Text("AI विश्लेषित ✅", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = GreenSuccess)
                                    }
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text("संभावित निदान: ${activeLabAnalysis!!.tentativeDiagnosis}", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = MedicalCyanDark)
                                    if (activeLabAnalysis!!.criticalAlert.isNotBlank()) {
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text("🚨 ${activeLabAnalysis!!.criticalAlert}", fontSize = 10.5.sp, fontWeight = FontWeight.Black, color = RedAlert)
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        OutlinedButton(
                            onClick = { viewModel.openPharmacopeiaSheet() },
                            shape = RoundedCornerShape(10.dp),
                            border = BorderStroke(1.2.dp, Slate900),
                            modifier = Modifier.fillMaxWidth().height(42.dp)
                        ) {
                            Text("💊 20+ पशु चिकित्सा साल्ट एवं ड्रग फार्माकोपिया खोलें", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Slate900)
                        }
                    }
                }
            }
        }

        // 6. Action Button Bar: Run Diagnosis & AI Second Opinion
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { viewModel.runDiagnosis() },
                    colors = ButtonDefaults.buttonColors(containerColor = MedicalCyanPrimary),
                    shape = RoundedCornerShape(12.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                ) {
                    Text(
                        text = "🩺 एआई रोग निदान",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Button(
                    onClick = { viewModel.evaluateAiSecondOpinion() },
                    colors = ButtonDefaults.buttonColors(containerColor = RoyalIndigoPrimary),
                    shape = RoundedCornerShape(12.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                ) {
                    Text(
                        text = "🤖 सेकंड ओपिनियन",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }

        // 7. Clinical Prescription & 5-Tier Treatment Output
        diagnosticResult?.let { result ->
            item {
                ClinicalPrescriptionPad(
                    result = result,
                    isPregnant = pregnancyStatus == PregnancyStatus.PREGNANT,
                    pregnancyMonth = pregnancyMonth,
                    selectedTab = selectedTreatmentTab,
                    onSelectTab = { viewModel.setSelectedTreatmentTab(it) },
                    onSelectGenericSalt = { viewModel.openDrugSubstitute(it) },
                    onPrint = {
                        RxPdfGenerator.printDocument(
                            context = context,
                            result = result,
                            patientName = "टैग #UP-78-4091 (${species.hindiName})",
                            doctorName = currentUser?.name ?: "Dr. Rahul Jangra, B.V.Sc & A.H.",
                            councilReg = currentUser?.regOrTagNo ?: "VCI-89241",
                            clinicTitle = adminSettings.clinicName.ifBlank { "VETCARE AI OS (CLINICAL TELE-PRESCRIPTION)" },
                            clinicSubtitle = adminSettings.clinicSubtitle.ifBlank { "Authorized Veterinary Practitioner Portal | ISO 9001:2026 Compliant Rx" }
                        )
                    },
                    onPdfShare = {
                        RxPdfGenerator.generateAndSharePdf(
                            context = context,
                            result = result,
                            patientName = "टैग #UP-78-4091 (${species.hindiName})",
                            doctorName = currentUser?.name ?: "Dr. Rahul Jangra, B.V.Sc & A.H.",
                            councilReg = currentUser?.regOrTagNo ?: "VCI-89241",
                            clinicTitle = adminSettings.clinicName.ifBlank { "VETCARE AI OS (CLINICAL TELE-PRESCRIPTION)" },
                            clinicSubtitle = adminSettings.clinicSubtitle.ifBlank { "Authorized Veterinary Practitioner Portal | ISO 9001:2026 Compliant Rx" }
                        )
                    },
                    onWhatsApp = {
                        val text = viewModel.generateWhatsAppPrescription()
                        val sendIntent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, text)
                            type = "text/plain"
                        }
                        try {
                            context.startActivity(Intent.createChooser(sendIntent, "पर्ची WhatsApp पर भेजें"))
                        } catch (e: Exception) {
                            viewModel.showToast("शेयरिंग उपलब्ध नहीं है")
                        }
                    },
                    onRecordBill = { total, paid, status, mode, notes ->
                        viewModel.recordOpdBilling(
                            patientTag = "टैग #UP-78-4091 (${species.hindiName})",
                            ownerName = "राजेश कुमार (पशुपालक)",
                            ownerPhone = "9896123490",
                            totalAmount = total,
                            paidAmount = paid,
                            status = status,
                            mode = mode,
                            notes = "${result.disease.hindiName} - $notes"
                        )
                    },
                    onNavigateToFinance = { viewModel.navigateTo(ScreenDestination.DOCTOR_FINANCE) }
                )
            }
        }
    }
    }
}

    // 🤖 Interactive AI Second Opinion Modal Dialog
    if (showAiSecondOpinion && aiEvaluation != null) {
        AiSecondOpinionDialog(
            evaluation = aiEvaluation!!,
            onDismiss = { viewModel.closeAiSecondOpinion() }
        )
    }

    // 💊 Interactive Drug Substitutes Popup Dialog with live weight-calculated mL dose
    if (selectedDrugSubstitute != null) {
        DrugSubstitutePopupDialog(
            drug = selectedDrugSubstitute!!,
            bodyWeightKg = bodyWeightKg,
            species = species,
            allSubstitutes = drugSubstitutes,
            onSelectOther = { viewModel.openDrugSubstitute(it) },
            onDismiss = { viewModel.closeDrugSubstitute() }
        )
    }

    // 📖 Searchable Veterinary Pharmacopeia Dialog
    if (showPharmacopeiaSheet) {
        PharmacopeiaModalDialog(
            items = pharmacopeiaList,
            searchQuery = pharmacopeiaSearch,
            selectedCategory = pharmacopeiaCategory,
            onSearchChange = { viewModel.setPharmacopeiaSearchQuery(it) },
            onCategoryChange = { viewModel.setPharmacopeiaCategory(it) },
            onDismiss = { viewModel.closePharmacopeiaSheet() }
        )
    }
}

// Patient Queue Item Card
@Composable
fun PatientQueueCard(
    item: PatientQueueItem,
    onLoad: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = DaylightSurface),
        border = BorderStroke(if (item.isEmergency) 2.dp else 1.2.dp, if (item.isEmergency) RedAlert else FrostedCardBorder),
        modifier = Modifier
            .width(220.dp)
            .shadow(2.dp, RoundedCornerShape(14.dp))
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = if (item.isEmergency) RedAlertLight else MedicalCyanLight,
                    shape = RoundedCornerShape(6.dp),
                    border = BorderStroke(1.dp, if (item.isEmergency) RedAlert else MedicalCyanPrimary)
                ) {
                    Text(
                        text = item.tokenNo,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Black,
                        color = if (item.isEmergency) RedAlert else MedicalCyanDark,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }

                if (item.isEmergency) {
                    Surface(color = RedAlert, shape = RoundedCornerShape(4.dp)) {
                        Text(
                            text = "🚨 आपातकाल",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "${item.species.icon} ${item.ownerName}",
                fontSize = 13.sp,
                fontWeight = FontWeight.Black,
                color = Slate900,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = item.primaryComplaint,
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = Slate900,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = onLoad,
                colors = ButtonDefaults.buttonColors(containerColor = if (item.isEmergency) RedAlert else MedicalCyanPrimary),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                modifier = Modifier.fillMaxWidth().height(36.dp)
            ) {
                Text("जांचें (Examine)", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}

// 5-Tier Treatment Horizontal Sliding Protocol & Prescription Pad
@Composable
fun ClinicalPrescriptionPad(
    result: DiagnosticResult,
    isPregnant: Boolean,
    pregnancyMonth: Int,
    selectedTab: Int,
    onSelectTab: (Int) -> Unit,
    onSelectGenericSalt: (String) -> Unit = {},
    onPrint: () -> Unit,
    onPdfShare: () -> Unit = {},
    onWhatsApp: () -> Unit,
    onRecordBill: ((total: Double, paid: Double, status: PaymentStatus, mode: PaymentMode, notes: String) -> Unit)? = null,
    onNavigateToFinance: (() -> Unit)? = null
) {
    val disease = result.disease
    val tabs = listOf("💉 इंजेक्शन", "🧴 ओरल", "🌿 आयुर्वेदिक", "💧 होम्योपैथिक", "🥣 देसी नुस्खे", "🔬 लैब टेस्ट", "🏡 प्रबंधन सुझाव")

    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = DaylightSurface),
        border = BorderStroke(2.dp, MedicalCyanPrimary),
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp, RoundedCornerShape(20.dp))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "डिजिटल ओपीडी पर्ची (Veterinary Rx)",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Black,
                        color = Slate900
                    )
                    Text(
                        text = "VETCARE AI OS • Verified Clinical Protocol",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = MedicalCyanDark
                    )
                }
                Surface(
                    color = MedicalCyanLight,
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.5.dp, MedicalCyanPrimary)
                ) {
                    Text(
                        text = "मैच: ${result.matchPercentage}%",
                        color = MedicalCyanDark,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Black,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = { result.matchPercentage / 100f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(RoundedCornerShape(3.dp)),
                color = if (result.matchPercentage > 75) GreenSuccess else AmberWarning,
                trackColor = FrostedCardBorder
            )

            Divider(color = FrostedCardBorder, thickness = 1.dp, modifier = Modifier.padding(vertical = 12.dp))

            // Disease Name
            Text(
                text = "1️⃣ संभावित रोग पहचान (Disease Names):",
                fontSize = 13.sp,
                fontWeight = FontWeight.Black,
                color = MedicalCyanDark
            )
            Text(
                text = disease.scientificName,
                fontSize = 17.sp,
                fontWeight = FontWeight.Black,
                color = Slate900
            )
            Text(
                text = "मानक हिन्दी: ${disease.hindiName} • ग्रामीण/देसी: ${disease.localDesiNames}",
                fontSize = 13.sp,
                color = Slate900,
                fontWeight = FontWeight.Bold
            )

            // Etiology
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "2️⃣ मूल कारण (Etiology): ${disease.etiology}",
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = Slate900
            )

            // Pregnancy Alert Banner (Crimson Red)
            if (isPregnant) {
                Spacer(modifier = Modifier.height(10.dp))
                Surface(
                    color = RedAlertLight,
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(2.dp, RedAlert),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("🚨", fontSize = 16.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "⚠️ प्रेगनेंसी आपात चेतावनी (महीना $pregnancyMonth)",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Black,
                                color = RedAlert
                            )
                        }
                        Text(
                            text = "डेक्सामेथासोन, आइसोफ्लुप्रेडोन, प्रेडनिसोलोन और एलबेंडाजोल सख्त वर्जित हैं! केवल सुरक्षित विकल्प (Meloxicam, Ceftriaxone) ही दें।",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Slate900
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // 6-Tier Treatment Horizontal Sliding Tabs
            Text(
                text = "4️⃣ 6-स्तरीय संपूर्ण उपचार व प्रबंधन योजना (Swipeable Tabs):",
                fontSize = 13.sp,
                fontWeight = FontWeight.Black,
                color = MedicalCyanDark
            )
            Spacer(modifier = Modifier.height(8.dp))

            ScrollableTabRow(
                selectedTabIndex = selectedTab,
                edgePadding = 0.dp,
                containerColor = DaylightCanvas,
                divider = {}
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { onSelectTab(index) },
                        text = {
                            Text(
                                text = title,
                                fontSize = 12.sp,
                                fontWeight = if (selectedTab == index) FontWeight.Black else FontWeight.Bold,
                                color = if (selectedTab == index) MedicalCyanPrimary else Slate900
                            )
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Swipeable Data Tables
            when (selectedTab) {
                0 -> { // Injections Table
                    InjectionsSwipeableTable(
                        injections = disease.injections,
                        isPregnant = isPregnant,
                        onSelectGenericSalt = onSelectGenericSalt
                    )
                }
                1 -> { // Oral Medicines Table
                    OralMedicinesSwipeableTable(oralMeds = disease.oralMeds)
                }
                2 -> { // Ayurvedic
                    AyurvedicCardView(herbalMeds = disease.herbalMeds)
                }
                3 -> { // Homeopathic
                    HomeopathicCardView(homeoMeds = disease.homeopathicMeds)
                }
                4 -> { // Desi Nuskhe
                    DesiNuskheCardView(desiRemedies = disease.desiRemedies)
                }
                5 -> { // Lab Tests & MRP
                    LabTestsSwipeableTable(labTests = disease.labTests)
                }
                6 -> { // Lifestyle & Management Tips
                    LifestyleHusbandryTipsCard(disease = disease)
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Action Buttons: Print, PDF & WhatsApp
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = onPrint,
                    colors = ButtonDefaults.buttonColors(containerColor = Slate900),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                ) {
                    Text("🖨️ प्रिंट", fontSize = 11.5.sp, fontWeight = FontWeight.Black, color = Color.White)
                }

                Button(
                    onClick = onPdfShare,
                    colors = ButtonDefaults.buttonColors(containerColor = MedicalCyanPrimary),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                ) {
                    Text("📄 PDF", fontSize = 11.5.sp, fontWeight = FontWeight.Black, color = Color.White)
                }

                Button(
                    onClick = onWhatsApp,
                    colors = ButtonDefaults.buttonColors(containerColor = GreenSuccess),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .weight(1.2f)
                        .height(48.dp)
                ) {
                    Text("📲 WhatsApp", fontSize = 11.5.sp, fontWeight = FontWeight.Black, color = Color.White)
                }
            }

            // OPD Billing & Payment Settlement Section
            if (onRecordBill != null) {
                Spacer(modifier = Modifier.height(14.dp))
                Divider(color = FrostedCardBorder, thickness = 1.dp)
                Spacer(modifier = Modifier.height(12.dp))

                OpdBillingSettlementSection(
                    patientTag = "टैग #IN-HR-1092-4821",
                    onSaveBill = { total, paid, status, mode, notes ->
                        onRecordBill(total, paid, status, mode, notes)
                    },
                    onViewLedger = onNavigateToFinance
                )
            }
        }
    }
}

// Injections Horizontal Swipeable Table
@Composable
fun InjectionsSwipeableTable(
    injections: List<InjectionDrug>,
    isPregnant: Boolean,
    onSelectGenericSalt: (String) -> Unit = {}
) {
    Surface(
        color = DaylightSurface,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.2.dp, FrostedCardBorder),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(10.dp)
        ) {
            // Table Header Row
            Row(
                modifier = Modifier.background(MedicalCyanLight).padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TableCell("वर्ग", width = 80.dp, isHeader = true)
                TableCell("जेनेरिक साल्ट (टैप करें)", width = 170.dp, isHeader = true)
                TableCell("एथिकल ब्रांड", width = 130.dp, isHeader = true)
                TableCell("जेनेरिक विकल्प", width = 130.dp, isHeader = true)
                TableCell("एथिकल MRP", width = 80.dp, isHeader = true)
                TableCell("जेनेरिक MRP", width = 80.dp, isHeader = true)
                TableCell("खुराक व रूट", width = 140.dp, isHeader = true)
                TableCell("गाभिन सुरक्षा", width = 90.dp, isHeader = true)
            }

            Divider(color = FrostedCardBorder, thickness = 1.dp)

            injections.forEach { inj ->
                val isUnsafe = isPregnant && !inj.pregnancySafe
                Row(
                    modifier = Modifier
                        .background(if (isUnsafe) RedAlertLight else Color.Transparent)
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TableCell(inj.category, width = 80.dp)
                    TableCell(
                        text = "💊 ${inj.genericSalt}",
                        width = 170.dp,
                        isBold = true,
                        textColor = MedicalCyanDark,
                        onClick = { onSelectGenericSalt(inj.genericSalt) }
                    )
                    TableCell(inj.ethicalBrand, width = 130.dp)
                    TableCell(inj.genericEquivalent, width = 130.dp)
                    TableCell("₹${inj.ethicalMrp}", width = 80.dp)
                    TableCell("₹${inj.genericMrp}", width = 80.dp, isBold = true, textColor = GreenSuccess)
                    TableCell(inj.dosageRoute, width = 140.dp)
                    TableCell(
                        text = if (inj.pregnancySafe) "✅ सुरक्षित" else "❌ वर्जित",
                        width = 90.dp,
                        textColor = if (inj.pregnancySafe) GreenSuccess else RedAlert,
                        isBold = true
                    )
                }
                Divider(color = FrostedCardBorder, thickness = 0.5.dp)
            }
        }
    }
}

// Oral Medicines Swipeable Table
@Composable
fun OralMedicinesSwipeableTable(oralMeds: List<OralMedicine>) {
    if (oralMeds.isEmpty()) {
        Text("कोई ओरल दवा निर्धारित नहीं है।", modifier = Modifier.padding(8.dp), color = Slate900)
        return
    }
    Surface(
        color = DaylightSurface,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.2.dp, FrostedCardBorder),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(10.dp)
        ) {
            Row(modifier = Modifier.background(TealLight).padding(8.dp)) {
                TableCell("प्रकार", width = 80.dp, isHeader = true)
                TableCell("साल्ट नाम", width = 160.dp, isHeader = true)
                TableCell("एथिकल ब्रांड", width = 130.dp, isHeader = true)
                TableCell("जेनेरिक विकल्प", width = 130.dp, isHeader = true)
                TableCell("जेनेरिक MRP", width = 80.dp, isHeader = true)
                TableCell("खुराक व समय", width = 140.dp, isHeader = true)
                TableCell("उद्देश्य", width = 150.dp, isHeader = true)
            }
            Divider(color = FrostedCardBorder, thickness = 1.dp)

            oralMeds.forEach { om ->
                Row(modifier = Modifier.padding(8.dp)) {
                    TableCell(om.type, width = 80.dp)
                    TableCell(om.saltName, width = 160.dp, isBold = true)
                    TableCell(om.ethicalBrand, width = 130.dp)
                    TableCell(om.genericEquivalent, width = 130.dp)
                    TableCell("₹${om.genericMrp}", width = 80.dp, isBold = true, textColor = GreenSuccess)
                    TableCell(om.dosageFreq, width = 140.dp)
                    TableCell(om.purpose, width = 150.dp)
                }
                Divider(color = FrostedCardBorder, thickness = 0.5.dp)
            }
        }
    }
}

// Ayurvedic Card View
@Composable
fun AyurvedicCardView(herbalMeds: List<HerbalMedicine>) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        herbalMeds.forEach { hm ->
            Surface(
                color = AgroEmeraldLight,
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, AgroEmeraldPrimary),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("🌿 ${hm.formulation}", fontWeight = FontWeight.Black, fontSize = 12.sp, color = Slate900)
                        Text("MRP: ₹${hm.mrp}", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = AgroEmeraldDark)
                    }
                    Text("खुराक: ${hm.dosage}", fontSize = 11.sp, color = Slate900)
                    Text("लाभ: ${hm.benefits}", fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = Slate900)
                }
            }
        }
    }
}

// Homeopathic Card View
@Composable
fun HomeopathicCardView(homeoMeds: List<HomeopathicMedicine>) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        homeoMeds.forEach { hm ->
            Surface(
                color = DaylightSurface,
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, FrostedCardBorder),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("💧 ${hm.medicinePotency}", fontWeight = FontWeight.Black, fontSize = 12.sp, color = Slate900)
                        Text("MRP: ₹${hm.mrp}", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Slate900)
                    }
                    Text("खुराक: ${hm.dosage}", fontSize = 11.sp, color = Slate900)
                    Text("प्रभाव: ${hm.action}", fontSize = 11.sp, color = Slate900)
                }
            }
        }
    }
}

// Desi Nuskhe Card View
@Composable
fun DesiNuskheCardView(desiRemedies: List<DesiRemedy>) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        desiRemedies.forEach { dr ->
            Surface(
                color = AgroEmeraldLight,
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.5.dp, AgroEmeraldPrimary),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("🥣 100% सुरक्षित देसी घरेलू नुस्खा: ${dr.remedyName}", fontSize = 13.sp, fontWeight = FontWeight.Black, color = AgroEmeraldDark)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("सामग्री: ${dr.ingredients}", fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = Slate900)
                    Text("बनाने की विधि: ${dr.preparationMethod}", fontSize = 11.sp, color = Slate900)
                    Text("सावधानी व प्रयोग: ${dr.usagePrecautions}", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = AgroEmeraldDark)
                }
            }
        }
    }
}

// Lab Tests Swipeable Table (6-Column Comprehensive Horizontal Scroll)
@Composable
fun LabTestsSwipeableTable(labTests: List<LabTest>) {
    Surface(
        color = DaylightSurface,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.2.dp, FrostedCardBorder),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier.background(MedicalCyanLight).padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TableCell("1. टेस्ट का नाम", width = 180.dp, isHeader = true)
                TableCell("2. सैंपल प्रकार", width = 120.dp, isHeader = true)
                TableCell("3. परिणाम संकेत", width = 130.dp, isHeader = true)
                TableCell("4. रिपोर्ट समय", width = 100.dp, isHeader = true)
                TableCell("5. शुल्क MRP", width = 90.dp, isHeader = true)
                TableCell("6. नैदानिक महत्व", width = 220.dp, isHeader = true)
            }
            Divider(color = FrostedCardBorder, thickness = 1.dp)

            labTests.forEach { test ->
                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TableCell(test.testName, width = 180.dp, isBold = true)
                    TableCell(test.sampleType, width = 120.dp)
                    TableCell(test.indicativeResult, width = 130.dp, isBold = true, textColor = GreenSuccess)
                    TableCell(test.turnaroundTime, width = 100.dp)
                    TableCell("₹${test.estimatedMrp}", width = 90.dp, isBold = true, textColor = MedicalCyanDark)
                    TableCell(test.clinicalSignificance, width = 220.dp)
                }
                Divider(color = FrostedCardBorder, thickness = 0.5.dp)
            }
        }
    }
}

@Composable
fun TableCell(
    text: String,
    width: androidx.compose.ui.unit.Dp,
    isHeader: Boolean = false,
    isBold: Boolean = false,
    textColor: Color = Slate900,
    onClick: (() -> Unit)? = null
) {
    val baseModifier = Modifier.width(width).padding(horizontal = 4.dp)
    val finalModifier = if (onClick != null) {
        baseModifier.clickable { onClick() }
    } else {
        baseModifier
    }

    Text(
        text = text,
        fontSize = 11.sp,
        fontWeight = if (isHeader) FontWeight.Black else if (isBold) FontWeight.Bold else FontWeight.Normal,
        color = if (isHeader) Slate900 else textColor,
        modifier = finalModifier
    )
}

// 🤖 Interactive AI Second Opinion Modal Dialog
@Composable
fun AiSecondOpinionDialog(
    evaluation: AiSecondOpinionEvaluation,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = DaylightSurface),
            border = BorderStroke(2.5.dp, RoyalIndigoPrimary),
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
                .shadow(8.dp, RoundedCornerShape(20.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                // Modal Title
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("🤖", fontSize = 24.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = "एआई सेकंड ओपिनियन",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Black,
                                color = Slate900
                            )
                            Text(
                                text = "AI Cross-Check & Clinical Safety",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = RoyalIndigoDark
                            )
                        }
                    }
                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Close, contentDescription = "Close", tint = Slate900)
                    }
                }

                Divider(color = FrostedCardBorder, thickness = 1.dp, modifier = Modifier.padding(vertical = 10.dp))

                // Risk Severity Badge
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("क्लिनिकल जोखिम स्तर:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Slate900)
                    Surface(
                        color = Color(evaluation.riskLevel.badgeColorHex),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = evaluation.riskLevel.label,
                            color = Color.White,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Black,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Farmer Savings Box
                Surface(
                    color = AgroEmeraldLight,
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(1.5.dp, AgroEmeraldPrimary),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("💰 किसान दवा बचत विश्लेषण:", fontSize = 12.sp, fontWeight = FontWeight.Black, color = AgroEmeraldDark)
                            Text("${evaluation.ethicalVsGenericSavingsPercent}% बचत", fontSize = 13.sp, fontWeight = FontWeight.Black, color = GreenSuccess)
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("ब्रांडेड एथिकल खर्च: ₹${evaluation.totalEthicalCost}", fontSize = 11.sp, color = Slate900)
                            Text("जेनेरिक विकल्प खर्च: ₹${evaluation.totalGenericCost}", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Slate900)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Differential Diagnosis Overlap
                if (evaluation.differentialMatches.isNotEmpty()) {
                    Text("विभेदक निदान (Differential Diagnoses):", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Slate900)
                    evaluation.differentialMatches.forEach { (name, pct) ->
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("• $name", fontSize = 11.sp, color = Slate900)
                            Text("$pct% समानता", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = RoyalIndigoDark)
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }

                // Missing Signs
                if (evaluation.missingSignsToInvestigate.isNotEmpty()) {
                    Text(
                        text = "जांचने योग्य अतिरिक्त लक्षण: ${evaluation.missingSignsToInvestigate.take(3).joinToString()}",
                        fontSize = 11.sp,
                        color = Slate900
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }

                // Pharmacological Warning Note
                Surface(
                    color = DaylightCanvas,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = evaluation.pharmacologicalAdvice,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Slate900,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                Button(
                    onClick = onDismiss,
                    colors = ButtonDefaults.buttonColors(containerColor = RoyalIndigoPrimary),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth().height(46.dp)
                ) {
                    Text("स्वीकार करें व पर्ची अपडेट करें", fontSize = 12.sp, fontWeight = FontWeight.Black, color = Color.White)
                }
            }
        }
    }
}

@Composable
fun DiagnosticModeButton(
    title: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        color = if (isSelected) MedicalCyanPrimary else DaylightSurface,
        border = BorderStroke(1.5.dp, if (isSelected) MedicalCyanPrimary else FrostedCardBorder),
        modifier = modifier.height(42.dp)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(horizontal = 4.dp)) {
            Text(
                text = title,
                fontSize = 10.5.sp,
                fontWeight = FontWeight.Bold,
                color = if (isSelected) Color.White else Slate900,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun VoicePhraseChip(
    text: String,
    onClick: (String) -> Unit
) {
    Surface(
        onClick = { onClick(text) },
        shape = RoundedCornerShape(8.dp),
        color = DaylightSurface,
        border = BorderStroke(1.dp, FrostedCardBorder)
    ) {
        Text(
            text = "🗣️ $text",
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold,
            color = Slate900,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}

// 💊 Interactive Drug Substitutes Popup Dialog with live weight-calculated mL dose
@Composable
fun DrugSubstitutePopupDialog(
    drug: DrugSubstituteDetail,
    bodyWeightKg: Double,
    species: Species = Species.CATTLE,
    allSubstitutes: List<DrugSubstituteDetail>,
    onSelectOther: (String) -> Unit,
    onDismiss: () -> Unit
) {
    val isContraindicated = drug.contraindicatedSpecies.contains(species)
    val calculatedDoseMl = if (isContraindicated) 0.0 else drug.calculateDoseMl(bodyWeightKg, species)

    Dialog(onDismissRequest = onDismiss) {
        Card(
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(2.dp, if (isContraindicated) RedAlert else MedicalCyanPrimary),
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp)
            ) {
                // Modal Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("💊", fontSize = 22.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = "दवा विकल्प व लाइव खुराक",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Black,
                                color = Slate900
                            )
                            Text(
                                text = "${species.icon} ${species.hindiName} • वजन आधारित सटीक mL डोजिंग",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = MedicalCyanDark
                            )
                        }
                    }
                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Close, contentDescription = "Close", tint = Slate900)
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Species Contraindication Alert or Live Weight Dose Banner
                if (isContraindicated) {
                    Surface(
                        color = RedAlertLight,
                        shape = RoundedCornerShape(14.dp),
                        border = BorderStroke(2.dp, RedAlert),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(14.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text("🚨 जानलेवा निषेध (FATAL CONTRAINDICATION) 🚨", fontSize = 12.sp, fontWeight = FontWeight.Black, color = RedAlert)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "0.0 mL (सख्त वर्जित)",
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Black,
                                color = RedAlert
                            )
                            Text(
                                text = drug.speciesSpecialWarning.ifBlank { "यह दवा ${species.hindiName} में सख्त वर्जित है!" },
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Black,
                                color = RedAlert
                            )
                        }
                    }
                } else {
                    Surface(
                        color = MedicalCyanLight,
                        shape = RoundedCornerShape(14.dp),
                        border = BorderStroke(2.dp, MedicalCyanPrimary),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(14.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "वर्तमान पशु वजन: ${bodyWeightKg} kg (${species.hindiName})",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = MedicalCyanDark
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "$calculatedDoseMl mL",
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Black,
                                color = Slate900
                            )
                            Text(
                                text = "गणना: (${bodyWeightKg} kg × ${drug.doseRateMgPerKg} mg/kg) ÷ ${drug.concentrationMgPerMl} mg/ml = $calculatedDoseMl mL",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Slate900
                            )
                            if (drug.speciesSpecialWarning.isNotBlank()) {
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = drug.speciesSpecialWarning,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = AmberWarning
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Drug Details
                Text(
                    text = drug.saltName,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Black,
                    color = Slate900
                )
                Text(
                    text = "ब्रांड: ${drug.brandName} • निर्माता: ${drug.company}",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Slate900
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Surface(
                        color = DaylightCanvas,
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, FrostedCardBorder),
                        modifier = Modifier.weight(1f)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text("रूट (Route):", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Slate900)
                            Text(drug.route, fontSize = 11.sp, fontWeight = FontWeight.Black, color = Slate900)
                        }
                    }
                    Surface(
                        color = DaylightCanvas,
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, FrostedCardBorder),
                        modifier = Modifier.weight(1f)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text("अनुमानित MRP:", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Slate900)
                            Text("₹${drug.mrp}", fontSize = 13.sp, fontWeight = FontWeight.Black, color = AgroEmeraldDark)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Pregnancy Safety Badge
                Surface(
                    color = if (drug.pregnancySafe) GreenSuccess.copy(alpha = 0.15f) else RedAlertLight,
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.5.dp, if (drug.pregnancySafe) GreenSuccess else RedAlert),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(if (drug.pregnancySafe) "✅" else "⚠️", fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (drug.pregnancySafe) "100% प्रेगनेंसी सुरक्षित (Safe in All Trimesters)" else "गर्भावती पशु में सख्त वर्जित (Abortion / Teratogenic Risk)",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Black,
                            color = if (drug.pregnancySafe) GreenSuccess else RedAlert
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "नैदानिक उपयोग: ${drug.clinicalUsage}",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Slate900
                )

                Spacer(modifier = Modifier.height(14.dp))
                Text(
                    text = "अन्य उपलब्ध जेनेरिक विकल्प (Quick Switch):",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Slate900
                )
                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    allSubstitutes.forEach { alt ->
                        FilterChip(
                            selected = alt.id == drug.id,
                            onClick = { onSelectOther(alt.saltName) },
                            label = { Text(alt.saltName.take(18), fontSize = 10.sp, fontWeight = FontWeight.Bold) },
                            colors = FilterChipDefaults.filterChipColors(
                                containerColor = Color.White,
                                selectedContainerColor = MedicalCyanPrimary,
                                selectedLabelColor = Color.White
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = onDismiss,
                    colors = ButtonDefaults.buttonColors(containerColor = MedicalCyanPrimary),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth().height(44.dp)
                ) {
                    Text("स्वीकार करें व बंद करें", fontSize = 12.sp, fontWeight = FontWeight.Black, color = Color.White)
                }
            }
        }
    }
}

// 📖 Searchable Veterinary Pharmacopeia Modal Dialog
@Composable
fun PharmacopeiaModalDialog(
    items: List<PharmacopeiaItem>,
    searchQuery: String,
    selectedCategory: String,
    onSearchChange: (String) -> Unit,
    onCategoryChange: (String) -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(20.dp),
            color = Color.White,
            border = BorderStroke(2.dp, MedicalCyanPrimary),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f)
                .shadow(8.dp, RoundedCornerShape(20.dp))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("💊", fontSize = 22.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = "पशु चिकित्सा फार्माकोपिया (Pharmacopeia)",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Black,
                                color = Slate900
                            )
                            Text(
                                text = "VCI 2026 • 20+ साल्ट, डोज, ब्रांड व गर्भ सुरक्षा",
                                fontSize = 10.5.sp,
                                color = MedicalCyanDark,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Close, contentDescription = "Close", tint = Slate900)
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Search Bar
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = onSearchChange,
                    placeholder = { Text("ब्रांड, जेनेरिक साल्ट या रोग खोजें...") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = MedicalCyanPrimary) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Category Chips Carousel
                val categories = listOf("All", "Antibiotic", "NSAID", "Antiprotozoal", "Anthelmintic", "Antihistamine", "Calcium/Mineral", "Digestive/Rumenotoric")
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    categories.forEach { cat ->
                        val isSelected = (cat == "All" && selectedCategory.isBlank()) || selectedCategory.equals(cat, ignoreCase = true)
                        FilterChip(
                            selected = isSelected,
                            onClick = { onCategoryChange(if (cat == "All") "" else cat) },
                            label = { Text(cat, fontSize = 10.5.sp, fontWeight = FontWeight.Bold) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MedicalCyanPrimary,
                                selectedLabelColor = Color.White
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "${items.size} औषधियां उपलब्ध:",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Slate900
                )

                Spacer(modifier = Modifier.height(6.dp))

                // Drug List
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(items) { drug ->
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = DaylightCanvas),
                            border = BorderStroke(1.dp, FrostedCardBorder),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = drug.brandName,
                                            fontSize = 13.5.sp,
                                            fontWeight = FontWeight.Black,
                                            color = Slate900
                                        )
                                        Text(
                                            text = "साल्ट: ${drug.genericSalt}",
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = MedicalCyanDark
                                        )
                                    }
                                    val isSafe = drug.pregnancySafety.contains("सुरक्षित") || drug.pregnancySafety.contains("Safe", ignoreCase = true)
                                    Surface(
                                        color = if (isSafe) GreenSuccess.copy(alpha = 0.15f) else RedAlertLight,
                                        shape = RoundedCornerShape(6.dp),
                                        border = BorderStroke(1.dp, if (isSafe) GreenSuccess else RedAlert)
                                    ) {
                                        Text(
                                            text = drug.pregnancySafety.take(18),
                                            fontSize = 9.5.sp,
                                            fontWeight = FontWeight.Black,
                                            color = if (isSafe) GreenSuccess else RedAlert,
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(6.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Text("वर्ग: ${drug.therapeuticCategory}", fontSize = 10.sp, color = Slate900, fontWeight = FontWeight.Bold)
                                    Text("• रूट: ${drug.route}", fontSize = 10.sp, color = Slate900)
                                    Text("• MRP: ₹${drug.approxMrp}", fontSize = 10.5.sp, fontWeight = FontWeight.Black, color = AgroEmeraldDark)
                                }

                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "खुराक: ${drug.standardDosagePerKg}",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Slate900
                                )
                                Text(
                                    text = "इंडिकेशन: ${drug.indications}",
                                    fontSize = 10.sp,
                                    color = Slate900,
                                    maxLines = 2
                                )

                                if (drug.commercialSubstitutes.isNotEmpty()) {
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "सस्ते विकल्प: ${drug.commercialSubstitutes.joinToString(", ")}",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = GreenSuccess
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = onDismiss,
                    colors = ButtonDefaults.buttonColors(containerColor = Slate900),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth().height(42.dp)
                ) {
                    Text("बंद करें (Close)", fontSize = 12.sp, color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun LifestyleHusbandryTipsCard(disease: DiseaseDefinition) {
    val tips = if (disease.lifestyleHusbandryTips.isNotEmpty()) {
        disease.lifestyleHusbandryTips
    } else {
        when {
            disease.scientificName.contains("Prolapse", ignoreCase = true) || disease.hindiName.contains("प्रोलैप्स") || disease.hindiName.contains("फूल") -> listOf(
                "शाम के समय अधिक मात्रा में भारी सूखा चारा या पानी न दें, भोजन को 3-4 बार में थोड़ा-थोड़ा दें।",
                "पशु के बैठने वाले स्थान के पीछे के फर्श को 3 से 4 इंच ऊंचा रखें (Elevated rear floor) ताकि गर्भाशय पर दबाव कम रहे।",
                "बासी, फफूंद लगा या सड़ा हुआ आहार सख्त बंद करें। कब्ज से बचाव हेतु चोकर व ईसबगोल की भूसी दें।",
                "पशु को जबरन ज्यादा देर तक एक ही तरफ लेटने न दें, नियमित हल्की चहलकदमी कराएं।"
            )
            disease.scientificName.contains("Mastitis", ignoreCase = true) || disease.hindiName.contains("थनैला") -> listOf(
                "दूध दुहने के तुरंत बाद 1% पोविडोन आयोडीन या पोटाश पानी से टीट-डिप (Teat Dip) अवश्य करें।",
                "दूध निकालने के बाद कम से कम 30-45 मिनट तक पशु को बैठने न दें, आगे हरा चारा डाल दें ताकि थन का छेद बंद हो सके।",
                "बाड़े का फर्श सूखा व चूने का छिड़काव युक्त रखें। गीली जगह पर थनैला जीवाणु तेजी से फैलते हैं।",
                "दूध दुहने का क्रम: पहले स्वस्थ व युवा पशुओं का दूध निकालें, संक्रमित पशु का दूध सबसे अंत में अलग बर्तन में निकालें।"
            )
            disease.scientificName.contains("Ketosis", ignoreCase = true) || disease.hindiName.contains("कीटोसिस") -> listOf(
                "ब्याने के पहले और बाद में प्रतिदिन 250 ग्राम गुड़ या मीठा शीरा और 200 मिली प्रोपलीन ग्लाइकोल दें।",
                "अचानक दाना मिश्रण न बदलें, सुपाच्य प्रोटीन व खनिज मिश्रण (MinMix) नियमित दें।",
                "पशु का वजन ब्याने के समय अत्यधिक मोटा या पतला न होने दें (Optimal BCS 3.5)।"
            )
            disease.scientificName.contains("Bloat", ignoreCase = true) || disease.hindiName.contains("आफरा") -> listOf(
                "सुबह ओस पड़ा गीला बरसीम या हरा चारा खाली पेट न खिलाएं। पहले सूखा तूड़ा या भूसा खिलाएं।",
                "पशु को अचानक बहुत सारा हरा चारा या दाना न दें, धीरे-धीरे चारे की मात्रा बढ़ाएं।",
                "आफरा होने पर पशु के मुंह में लकड़ी का बीट बांधें व उसे धीरे-धीरे टहलाएं।"
            )
            else -> listOf(
                "पशु आवास को स्वच्छ, हवादार व सूखा रखें तथा धूप की पर्याप्त व्यवस्था सुनिश्चित करें।",
                "साफ व ताजा पीने का पानी 24 घंटे उपलब्ध कराएं। नियमित समय पर पौष्टिक संतुलित आहार दें।",
                "संक्रमित पशु को तुरंत अन्य स्वस्थ पशुओं से अलग (Segregate) करें ताकि रोग का प्रसार रुके।",
                "पशुशाला में मक्खी, मच्छर व किलनी (Ticks) नियंत्रण हेतु नियमित कीटनाशक छिड़काव करें।"
            )
        }
    }

    Surface(
        color = DaylightSurface,
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.5.dp, MedicalCyanPrimary),
        modifier = Modifier.fillMaxWidth().shadow(2.dp, RoundedCornerShape(14.dp))
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(MedicalCyanLight),
                    contentAlignment = Alignment.Center
                ) {
                    Text("🏡", fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = "प्रबंधन और देखभाल सुझाव (Husbandry Protocol)",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Black,
                        color = Slate900
                    )
                    Text(
                        text = "रोग-विशिष्ट पशुपालन व जीवनशैली सुधार निर्देश",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MedicalCyanDark
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            tips.forEachIndexed { idx, tip ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Surface(
                        color = MedicalCyanLight,
                        shape = CircleShape,
                        modifier = Modifier.size(22.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = "${idx + 1}",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Black,
                                color = MedicalCyanDark
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = tip,
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.Medium,
                        color = Slate900,
                        lineHeight = 18.sp,
                        modifier = Modifier.weight(1f)
                    )
                }
                if (idx < tips.size - 1) {
                    Divider(color = FrostedCardBorder.copy(alpha = 0.5f), modifier = Modifier.padding(vertical = 4.dp))
                }
            }
        }
    }
}

@Composable
fun OpdBillingSettlementSection(
    patientTag: String,
    onSaveBill: (total: Double, paid: Double, status: PaymentStatus, mode: PaymentMode, notes: String) -> Unit,
    onViewLedger: (() -> Unit)? = null
) {
    var totalAmountInput by remember { mutableStateOf("850") }
    var paidAmountInput by remember { mutableStateOf("850") }
    var selectedStatus by remember { mutableStateOf(PaymentStatus.PAID_FULL) }
    var selectedMode by remember { mutableStateOf(PaymentMode.UPI) }
    var notesInput by remember { mutableStateOf("ओपीडी परामर्श, दवाइयां व इंजेक्शन") }
    var billSavedSuccess by remember { mutableStateOf(false) }

    val totalVal = totalAmountInput.toDoubleOrNull() ?: 0.0
    val paidVal = paidAmountInput.toDoubleOrNull() ?: 0.0
    val balanceDue = (totalVal - paidVal).coerceAtLeast(0.0)

    Surface(
        color = Color(0xFFF8FAFC),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.5.dp, TealAccent),
        modifier = Modifier.fillMaxWidth().shadow(2.dp, RoundedCornerShape(16.dp))
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(34.dp)
                            .clip(CircleShape)
                            .background(TealLight),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("💳", fontSize = 16.sp)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "ओपीडी बिलिंग व भुगतान सेटलमेंट (OPD Billing)",
                            fontSize = 13.5.sp,
                            fontWeight = FontWeight.Black,
                            color = Slate900
                        )
                        Text(
                            text = "Billing & Payment Settlement • $patientTag",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = TealDark
                        )
                    }
                }
                if (onViewLedger != null) {
                    TextButton(onClick = onViewLedger) {
                        Text("📊 खाता बही", fontSize = 11.5.sp, fontWeight = FontWeight.Black, color = TealDark)
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Total Amount & Paid Amount Inputs
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OutlinedTextField(
                    value = totalAmountInput,
                    onValueChange = {
                        totalAmountInput = it
                        if (selectedStatus == PaymentStatus.PAID_FULL) {
                            paidAmountInput = it
                        }
                    },
                    label = { Text("कुल बिल राशि (₹)") },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.weight(1f),
                    colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = TealDark)
                )

                OutlinedTextField(
                    value = paidAmountInput,
                    onValueChange = {
                        paidAmountInput = it
                        val p = it.toDoubleOrNull() ?: 0.0
                        if (p >= totalVal && totalVal > 0) {
                            selectedStatus = PaymentStatus.PAID_FULL
                        } else if (p > 0) {
                            selectedStatus = PaymentStatus.PARTIAL
                        } else {
                            selectedStatus = PaymentStatus.UNPAID
                        }
                    },
                    label = { Text("प्राप्त राशि (₹)") },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.weight(1f),
                    colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = GreenSuccess)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Auto-Calculated Balance Due Card
            Surface(
                color = if (balanceDue > 0) RedAlertLight else GreenSuccessLight,
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, if (balanceDue > 0) RedAlert else GreenSuccess),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (balanceDue > 0) "⚠️ उधारी / शेष बकाया राशि (Balance Due):" else "✅ पूरा भुगतान प्राप्त (Fully Settled):",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (balanceDue > 0) RedAlert else GreenSuccessDark
                    )
                    Text(
                        text = "₹${"%.2f".format(balanceDue)}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Black,
                        color = if (balanceDue > 0) RedAlert else GreenSuccessDark
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Payment Status Selection
            Text(
                text = "भुगतान स्थिति (Payment Status):",
                fontSize = 11.sp,
                fontWeight = FontWeight.Black,
                color = Slate900
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                listOf(
                    Triple(PaymentStatus.PAID_FULL, "पूरा भुगतान", GreenSuccess),
                    Triple(PaymentStatus.PARTIAL, "उधारी / आधा", AmberWarning),
                    Triple(PaymentStatus.UNPAID, "बकाया (Credit)", RedAlert)
                ).forEach { (status, label, color) ->
                    val isSel = selectedStatus == status
                    Surface(
                        onClick = {
                            selectedStatus = status
                            when (status) {
                                PaymentStatus.PAID_FULL -> paidAmountInput = totalAmountInput
                                PaymentStatus.PARTIAL -> paidAmountInput = ((totalAmountInput.toDoubleOrNull() ?: 0.0) / 2.0).toInt().toString()
                                PaymentStatus.UNPAID -> paidAmountInput = "0"
                            }
                        },
                        shape = RoundedCornerShape(8.dp),
                        color = if (isSel) color else Color.White,
                        border = BorderStroke(1.dp, if (isSel) color else FrostedCardBorder),
                        modifier = Modifier.weight(1f).height(36.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = label,
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.Black,
                                color = if (isSel) Color.White else Slate900
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Payment Mode Selection
            Text(
                text = "भुगतान माध्यम (Payment Mode):",
                fontSize = 11.sp,
                fontWeight = FontWeight.Black,
                color = Slate900
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                listOf(
                    Pair(PaymentMode.CASH, "💵 नकद (Cash)"),
                    Pair(PaymentMode.UPI, "📱 Online / UPI"),
                    Pair(PaymentMode.BANK, "🏦 बैंक खाता")
                ).forEach { (mode, label) ->
                    val isSel = selectedMode == mode
                    Surface(
                        onClick = { selectedMode = mode },
                        shape = RoundedCornerShape(8.dp),
                        color = if (isSel) TealDark else Color.White,
                        border = BorderStroke(1.dp, if (isSel) TealDark else FrostedCardBorder),
                        modifier = Modifier.weight(1f).height(36.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = label,
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.Black,
                                color = if (isSel) Color.White else Slate900
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {
                    onSaveBill(totalVal, paidVal, selectedStatus, selectedMode, notesInput)
                    billSavedSuccess = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = if (billSavedSuccess) GreenSuccess else TealDark),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth().height(46.dp)
            ) {
                Text(
                    text = if (billSavedSuccess) "✅ ओपीडी रसीद सहेजी गई!" else "💾 बिल सहेजें व रसीद बनाएं (Save OPD Bill)",
                    fontSize = 12.5.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun DoctorFinanceDashboardScreen(
    viewModel: VetCareViewModel
) {
    val records by viewModel.doctorBillingRecords.collectAsState()
    val filter by viewModel.financeTimeframeFilter.collectAsState()
    val currentUser by viewModel.currentUser.collectAsState()
    val adminSettings by viewModel.adminSettings.collectAsState()
    val context = LocalContext.current

    val now = System.currentTimeMillis()
    val filteredRecords = when (filter) {
        "DAILY" -> records.filter { now - it.timestamp <= 86400000L }
        "WEEKLY" -> records.filter { now - it.timestamp <= 7 * 86400000L }
        "MONTHLY" -> records.filter { now - it.timestamp <= 30 * 86400000L }
        "YEARLY" -> records.filter { now - it.timestamp <= 365 * 86400000L }
        else -> records
    }

    val totalBilled = filteredRecords.sumOf { it.totalAmount }
    val totalCollected = filteredRecords.sumOf { it.paidAmount }
    val totalPendingUdhaar = filteredRecords.sumOf { it.balanceDue }
    val caseCount = filteredRecords.size

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DaylightCanvas)
            .verticalScroll(rememberScrollState())
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Top Header
        Card(
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = DaylightSurface),
            border = BorderStroke(2.dp, TealAccent),
            modifier = Modifier.fillMaxWidth().shadow(4.dp, RoundedCornerShape(18.dp))
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .clip(CircleShape)
                                .background(TealLight),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("💰", fontSize = 22.sp)
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = "फाइनेंस और हिसाब (Doctor Finance Ledger)",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black,
                                color = Slate900
                            )
                            Text(
                                text = "ओपीडी बिलिंग, दैनिक आय व उधारी प्रबंधन",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = TealDark
                            )
                        }
                    }

                    IconButton(
                        onClick = { viewModel.navigateTo(ScreenDestination.DOCTOR_DIAGNOSIS) },
                        modifier = Modifier.size(38.dp).clip(CircleShape).background(Slate100)
                    ) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Slate900)
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Timeframe Filter Chips
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    listOf(
                        Pair("ALL", "कुल (All-Time)"),
                        Pair("DAILY", "दैनिक (Daily)"),
                        Pair("WEEKLY", "साप्ताहिक (Weekly)"),
                        Pair("MONTHLY", "मासिक (Monthly)"),
                        Pair("YEARLY", "वार्षिक (Yearly)")
                    ).forEach { (fKey, fLabel) ->
                        val isSel = filter == fKey
                        FilterChip(
                            selected = isSel,
                            onClick = { viewModel.setFinanceTimeframeFilter(fKey) },
                            label = { Text(fLabel, fontSize = 11.5.sp, fontWeight = if (isSel) FontWeight.Black else FontWeight.Bold) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = TealDark,
                                selectedLabelColor = Color.White
                            )
                        )
                    }
                }
            }
        }

        // Financial Metrics Cards: Credit (आय) vs Debit (उधारी)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Income / Credit Card
            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = GreenSuccessLight),
                border = BorderStroke(1.5.dp, GreenSuccess),
                modifier = Modifier.weight(1f).shadow(2.dp, RoundedCornerShape(14.dp))
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = "💵 कुल आय (Credit)",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = GreenSuccessDark
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "₹${"%.2f".format(totalCollected)}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Black,
                        color = GreenSuccessDark
                    )
                    Text(
                        text = "प्राप्त नकद/UPI",
                        fontSize = 10.sp,
                        color = Slate700
                    )
                }
            }

            // Udhaar / Debit Card
            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = RedAlertLight),
                border = BorderStroke(1.5.dp, RedAlert),
                modifier = Modifier.weight(1f).shadow(2.dp, RoundedCornerShape(14.dp))
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = "⏳ कुल उधारी (Debit)",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = RedAlert
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "₹${"%.2f".format(totalPendingUdhaar)}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Black,
                        color = RedAlert
                    )
                    Text(
                        text = "शेष बकाया राशि",
                        fontSize = 10.sp,
                        color = Slate700
                    )
                }
            }
        }

        // Summary Info Banner & 1-Click PDF Export Button
        Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = DaylightSurface),
            border = BorderStroke(1.dp, FrostedCardBorder),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "कुल ओपीडी केस: $caseCount | कुल बिलिंग: ₹${"%.2f".format(totalBilled)}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Black,
                        color = Slate900
                    )
                    Text(
                        text = "अवधि: ${when (filter) { "DAILY" -> "आज"; "WEEKLY" -> "इस सप्ताह"; "MONTHLY" -> "इस माह"; "YEARLY" -> "इस वर्ष"; else -> "सभी समय" }}",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Slate600
                    )
                }

                Button(
                    onClick = {
                        RxPdfGenerator.generateAndShareDoctorFinancePdf(
                            context = context,
                            records = filteredRecords,
                            timeframe = filter,
                            doctorName = currentUser?.name ?: "डॉ. राहुल जांगड़ा",
                            clinicName = adminSettings.clinicName.ifBlank { "हिसार पशु अस्पताल, हरियाणा" }
                        )
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = TealDark),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Icon(Icons.Default.Download, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("📄 1-Click PDF", fontSize = 11.5.sp, fontWeight = FontWeight.Black, color = Color.White)
                }
            }
        }

        // Transactions List
        Text(
            text = "ओपीडी पर्ची लेन-देन विवरण (Transaction Log):",
            fontSize = 13.sp,
            fontWeight = FontWeight.Black,
            color = Slate900
        )

        if (filteredRecords.isEmpty()) {
            Surface(
                color = Color.White,
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, FrostedCardBorder),
                modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("📋", fontSize = 32.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("इस अवधि में कोई ओपीडी बिलिंग रिकॉर्ड नहीं है।", fontSize = 13.sp, color = Slate600, fontWeight = FontWeight.Bold)
                }
            }
        } else {
            filteredRecords.forEach { record ->
                Card(
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                    border = BorderStroke(1.dp, if (record.balanceDue > 0) RedAlert.copy(alpha = 0.5f) else FrostedCardBorder),
                    modifier = Modifier.fillMaxWidth().shadow(2.dp, RoundedCornerShape(14.dp))
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = "${record.billNumber} • ${record.patientTag}",
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.Black,
                                    color = Slate900
                                )
                                Text(
                                    text = "पालक: ${record.ownerName} (${record.ownerPhone})",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Slate600
                                )
                            }
                            Surface(
                                color = when (record.paymentStatus) {
                                    PaymentStatus.PAID_FULL -> GreenSuccessLight
                                    PaymentStatus.PARTIAL -> AmberWarningLight
                                    PaymentStatus.UNPAID -> RedAlertLight
                                },
                                shape = RoundedCornerShape(6.dp),
                                border = BorderStroke(1.dp, when (record.paymentStatus) {
                                    PaymentStatus.PAID_FULL -> GreenSuccess
                                    PaymentStatus.PARTIAL -> AmberWarning
                                    PaymentStatus.UNPAID -> RedAlert
                                })
                            ) {
                                Text(
                                    text = when (record.paymentStatus) {
                                        PaymentStatus.PAID_FULL -> "✅ पूर्ण भुगतान"
                                        PaymentStatus.PARTIAL -> "⚠️ आधा / उधारी"
                                        PaymentStatus.UNPAID -> "🚨 बकाया (Credit)"
                                    },
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Black,
                                    color = when (record.paymentStatus) {
                                        PaymentStatus.PAID_FULL -> GreenSuccessDark
                                        PaymentStatus.PARTIAL -> AmberWarningDark
                                        PaymentStatus.UNPAID -> RedAlert
                                    },
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("कुल बिल: ₹${record.totalAmount.toInt()}", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Slate900)
                            Text("प्राप्त: ₹${record.paidAmount.toInt()} (${record.paymentMode.name})", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = GreenSuccessDark)
                            if (record.balanceDue > 0) {
                                Text("उधारी: ₹${record.balanceDue.toInt()}", fontSize = 11.5.sp, fontWeight = FontWeight.Black, color = RedAlert)
                            }
                        }

                        if (record.notes.isNotBlank()) {
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "उपचार: ${record.notes}",
                                fontSize = 10.5.sp,
                                color = Slate600
                            )
                        }
                    }
                }
            }
        }
    }
}


