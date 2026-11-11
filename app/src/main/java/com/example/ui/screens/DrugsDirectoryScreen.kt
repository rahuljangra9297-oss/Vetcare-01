package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.DrugItem
import com.example.ui.components.*
import com.example.ui.theme.*
import com.example.viewmodel.VetCareViewModel

@Composable
fun DrugsDirectoryScreen(
    viewModel: VetCareViewModel
) {
    val searchQuery by viewModel.drugSearchQuery.collectAsState()
    val categoryFilter by viewModel.drugCategoryFilter.collectAsState()
    val drugsList by viewModel.drugsList.collectAsState()
    val shaefferLength by viewModel.shaefferLengthInches.collectAsState()
    val shaefferGirth by viewModel.shaefferGirthInches.collectAsState()
    val bodyWeightKg by viewModel.bodyWeightKg.collectAsState()

    var activeTab by remember { mutableStateOf(0) }
    var selectedDrugForModal by remember { mutableStateOf<DrugItem?>(null) }

    val categories = listOf("सभी", "एंटीबायोटिक", "दर्द निवारक", "एंटीप्रोटोजोअल", "कृमिनाशक", "कैल्शियम व फ्लुइड", "स्टेरॉयड")

    val filteredDrugs = drugsList.filter { item ->
        val matchesCategory = categoryFilter == "सभी" || item.category == categoryFilter
        val matchesSearch = searchQuery.isBlank() ||
                item.saltName.contains(searchQuery, ignoreCase = true) ||
                item.ethicalBrand.contains(searchQuery, ignoreCase = true) ||
                item.genericEquivalent.contains(searchQuery, ignoreCase = true)
        matchesCategory && matchesSearch
    }

    if (selectedDrugForModal != null) {
        val currentDrug = drugsList.find { it.id == selectedDrugForModal!!.id } ?: selectedDrugForModal!!
        SaltDetailsModalDialog(
            drug = currentDrug,
            onDismiss = { selectedDrugForModal = null },
            onIncrement = { viewModel.incrementDrugStock(currentDrug.id) },
            onDecrement = { viewModel.decrementDrugStock(currentDrug.id) }
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(DaylightCanvas)
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Header & Tab Switcher
        item {
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                border = androidx.compose.foundation.BorderStroke(2.dp, MedicalCyanPrimary),
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(3.dp, RoundedCornerShape(18.dp))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(42.dp)
                                .clip(CircleShape)
                                .background(MedicalCyanLight)
                                .border(2.dp, MedicalCyanPrimary, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("💊", fontSize = 22.sp)
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "वेटनरी औषधि व फार्मेसी स्टॉक (Drugs Directory)",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Black,
                                color = Slate900
                            )
                            Text(
                                text = "जेनेरिक vs एथिकल MRP बचत • रियल-टाइम स्टॉक ट्रैकर",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Slate900
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        TabSelectorButton("💊 दवा डायरेक्टरी व स्टॉक", activeTab == 0, activeColor = MedicalCyanPrimary) { activeTab = 0 }
                        TabSelectorButton("⚖️ शेफर्स वजन व खुराक", activeTab == 1, activeColor = MedicalCyanPrimary) { activeTab = 1 }
                    }
                }
            }
        }

        if (activeTab == 0) {
            // Search Bar & Categories
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = androidx.compose.foundation.BorderStroke(1.5.dp, FrostedCardBorder),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        OutlinedTextField(
                            value = searchQuery,
                            onValueChange = { viewModel.setDrugSearchQuery(it) },
                            placeholder = { Text("सॉल्ट या ब्रांड नाम से खोजें (उदा: Ceftriaxone, Intacef)...", fontWeight = FontWeight.Normal) },
                            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = MedicalCyanPrimary) },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            categories.forEach { cat ->
                                FilterChip(
                                    selected = categoryFilter == cat,
                                    onClick = { viewModel.setDrugCategoryFilter(cat) },
                                    label = { Text(cat, fontWeight = FontWeight.Bold) },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = MedicalCyanPrimary,
                                        selectedLabelColor = Color.White,
                                        containerColor = Color.White
                                    ),
                                    border = FilterChipDefaults.filterChipBorder(
                                        borderColor = if (categoryFilter == cat) MedicalCyanPrimary else FrostedCardBorder,
                                        selectedBorderColor = MedicalCyanPrimary,
                                        borderWidth = 1.5.dp,
                                        selectedBorderWidth = 2.dp,
                                        enabled = true,
                                        selected = categoryFilter == cat
                                    )
                                )
                            }
                        }
                    }
                }
            }

            // Drugs List
            items(filteredDrugs) { drug ->
                DrugStockCard(
                    drug = drug,
                    onSaltClick = { selectedDrugForModal = drug },
                    onIncrement = { viewModel.incrementDrugStock(drug.id) },
                    onDecrement = { viewModel.decrementDrugStock(drug.id) }
                )
            }
        } else {
            // Shaeffer's Weight & Dosage Engine
            item {
                ShaeffersWeightCard(
                    lengthInches = shaefferLength,
                    girthInches = shaefferGirth,
                    weightKg = bodyWeightKg,
                    onUpdate = { l, g -> viewModel.updateShaefferDimensions(l, g) }
                )
            }
        }
    }
}

@Composable
fun DrugStockCard(
    drug: DrugItem,
    onSaltClick: () -> Unit = {},
    onIncrement: () -> Unit,
    onDecrement: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = androidx.compose.foundation.BorderStroke(
            1.5.dp,
            if (drug.stockCount <= 5) RedAlert else FrostedCardBorder
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onSaltClick() },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = drug.saltName,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Black,
                            color = Slate900
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Icon(
                            Icons.Default.Info,
                            contentDescription = "Salt Info",
                            tint = MedicalCyanPrimary,
                            modifier = Modifier.size(15.dp)
                        )
                    }
                    Text(
                        text = "श्रेणी: ${drug.category} • मार्ग: ${drug.route} • टैप करके विवरण देखें ↗",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = MedicalCyanDark
                    )
                }

                Surface(
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GreenSuccess)
                ) {
                    Text(
                        text = "${drug.savingsPercent}% बचत",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Black,
                        color = Slate900,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Surface(
                color = Color.White,
                shape = RoundedCornerShape(10.dp),
                border = androidx.compose.foundation.BorderStroke(1.2.dp, FrostedCardBorder),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(text = "एथिकल ब्रांड:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Slate900)
                        Text(text = "${drug.ethicalBrand} • ₹${drug.ethicalMrp}", fontSize = 12.sp, fontWeight = FontWeight.Black, color = Slate900)
                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Text(text = "जेनेरिक समकक्ष:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Slate900)
                        Text(text = "${drug.genericEquivalent} • ₹${drug.genericMrp}", fontSize = 12.sp, fontWeight = FontWeight.Black, color = MedicalCyanDark)
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (drug.stockCount <= 5) {
                        Surface(
                            color = Color.White,
                            shape = RoundedCornerShape(6.dp),
                            border = androidx.compose.foundation.BorderStroke(1.5.dp, RedAlert)
                        ) {
                            Text(
                                text = "⚠️ कम स्टॉक (${drug.stockCount})",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Black,
                                color = Slate900,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    } else {
                        Text(
                            text = "📦 स्टॉक: ${drug.stockCount} शीशियां (Vials)",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Black,
                            color = Slate900
                        )
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = onDecrement,
                        modifier = Modifier
                            .size(34.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .border(1.5.dp, FrostedCardBorder, CircleShape)
                    ) {
                        Icon(Icons.Default.Remove, contentDescription = "Decrease", tint = Slate900, modifier = Modifier.size(16.dp))
                    }

                    Text(
                        text = "${drug.stockCount}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Black,
                        color = Slate900,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )

                    IconButton(
                        onClick = onIncrement,
                        modifier = Modifier
                            .size(34.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .border(1.5.dp, MedicalCyanPrimary, CircleShape)
                    ) {
                        Icon(Icons.Default.Add, contentDescription = "Increase", tint = MedicalCyanPrimary, modifier = Modifier.size(16.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun ShaeffersWeightCard(
    lengthInches: Double,
    girthInches: Double,
    weightKg: Double,
    onUpdate: (Double, Double) -> Unit
) {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = androidx.compose.foundation.BorderStroke(2.dp, MedicalCyanPrimary),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "📐 शेफर्स सूत्र वजन कैलकुलेटर (Shaeffer's Formula):",
                fontSize = 15.sp,
                fontWeight = FontWeight.Black,
                color = MedicalCyanDark
            )
            Text(
                text = "वजन (lbs) = (लंबाई इंच × घेरा इंच²) ÷ 300  |  किग्रा = lbs ÷ 2.2",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Slate900
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(text = "1. पशु की लंबाई (पॉइंट ऑफ शोल्डर से पिन बोन): ${lengthInches.toInt()} इंच", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Slate900)
            Slider(
                value = lengthInches.toFloat(),
                onValueChange = { onUpdate(it.toDouble(), girthInches) },
                valueRange = 40f..90f,
                colors = SliderDefaults.colors(thumbColor = MedicalCyanPrimary, activeTrackColor = MedicalCyanPrimary)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "2. छाती का सीना घेरा (Heart Girth): ${girthInches.toInt()} इंच", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Slate900)
            Slider(
                value = girthInches.toFloat(),
                onValueChange = { onUpdate(lengthInches, it.toDouble()) },
                valueRange = 45f..100f,
                colors = SliderDefaults.colors(thumbColor = MedicalCyanPrimary, activeTrackColor = MedicalCyanPrimary)
            )

            Spacer(modifier = Modifier.height(14.dp))

            Surface(
                color = Color.White,
                shape = RoundedCornerShape(14.dp),
                border = androidx.compose.foundation.BorderStroke(2.dp, MedicalCyanPrimary),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "गणना किया गया पशु भार (Calculated Weight):",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = MedicalCyanDark
                    )
                    Text(
                        text = "$weightKg किग्रा (kg)",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Black,
                        color = Slate900
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "अनुशंसित एंटीबायोटिक खुराक: ${(weightKg / 20.0).toInt()} से ${(weightKg / 15.0).toInt()} ml",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Black,
                        color = Slate900
                    )
                }
            }
        }
    }
}

@Composable
fun SaltDetailsModalDialog(
    drug: DrugItem,
    onDismiss: () -> Unit,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(containerColor = MedicalCyanPrimary),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("बंद करें (Close)", fontWeight = FontWeight.Bold, color = Color.White)
            }
        },
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(MedicalCyanLight),
                    contentAlignment = Alignment.Center
                ) {
                    Text("💊", fontSize = 18.sp)
                }
                Column {
                    Text(
                        text = drug.saltName,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Black,
                        color = Slate900
                    )
                    Text(
                        text = "फार्माकोपिया सॉल्ट विवरण एवं विकल्प",
                        fontSize = 11.sp,
                        color = MedicalCyanDark,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Salt Information Card
                Surface(
                    color = Color(0xFFF1F5F9),
                    shape = RoundedCornerShape(10.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, FrostedCardBorder),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text(
                            text = "क्लिनिकल सॉल्ट जानकारी:",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Black,
                            color = Slate900
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = "• वर्ग: ${drug.category}", fontSize = 11.sp, color = Slate700)
                        Text(text = "• देने का मार्ग: ${drug.route}", fontSize = 11.sp, color = Slate700)
                        Text(
                            text = "• गर्भकाल सुरक्षा: " + if (drug.pregnancySafe) "✅ सुरक्षित (Pregnancy Safe)" else "❌ सावधानी / वर्जित (Contraindicated in 1st/3rd trimester)",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (drug.pregnancySafe) GreenSuccess else RedAlert
                        )
                    }
                }

                // Brand Variations & Substitutes Table
                Text(
                    text = "ब्रांड तुलना एवं बचत विश्लेषण (Ethical vs Generic):",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Black,
                    color = Slate900
                )

                Surface(
                    color = Color.White,
                    shape = RoundedCornerShape(10.dp),
                    border = androidx.compose.foundation.BorderStroke(1.5.dp, FrostedCardBorder),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = "एथिकल ब्रांड (Ethical):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Slate500)
                                Text(text = drug.ethicalBrand, fontSize = 13.sp, fontWeight = FontWeight.Black, color = Slate900)
                                Text(text = "MRP: ₹${drug.ethicalMrp}", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = RedAlert)
                            }
                            Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.End) {
                                Text(text = "जेनेरिक समकक्ष (Generic):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Slate500)
                                Text(text = drug.genericEquivalent, fontSize = 13.sp, fontWeight = FontWeight.Black, color = MedicalCyanDark)
                                Text(text = "दर: ₹${drug.genericMrp}", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = GreenSuccess)
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        Divider(color = FrostedCardBorder, thickness = 1.dp)
                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "सीधी बचत प्रति वायल:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Slate900)
                            Surface(
                                color = GreenSuccess.copy(alpha = 0.12f),
                                shape = RoundedCornerShape(6.dp),
                                border = androidx.compose.foundation.BorderStroke(1.dp, GreenSuccess)
                            ) {
                                Text(
                                    text = "₹${drug.ethicalMrp - drug.genericMrp} बचाएं (${drug.savingsPercent}%)",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Black,
                                    color = GreenSuccess,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                )
                            }
                        }
                    }
                }

                // Packaging Unit Stock Stepper
                Surface(
                    color = Color.White,
                    shape = RoundedCornerShape(10.dp),
                    border = androidx.compose.foundation.BorderStroke(1.5.dp, if (drug.stockCount <= 5) RedAlert else MedicalCyanPrimary),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(text = "उपलब्ध स्टॉक (Live Stock):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Slate500)
                            Text(
                                text = "${drug.stockCount} यूनिट / वायल",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Black,
                                color = if (drug.stockCount <= 5) RedAlert else Slate900
                            )
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconButton(
                                onClick = onDecrement,
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFFF1F5F9))
                                    .border(1.dp, FrostedCardBorder, CircleShape)
                            ) {
                                Icon(Icons.Default.Remove, contentDescription = "Decrease", tint = Slate900, modifier = Modifier.size(16.dp))
                            }

                            Text(
                                text = "${drug.stockCount}",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Black,
                                color = Slate900,
                                modifier = Modifier.padding(horizontal = 12.dp)
                            )

                            IconButton(
                                onClick = onIncrement,
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(CircleShape)
                                    .background(MedicalCyanLight)
                                    .border(1.dp, MedicalCyanPrimary, CircleShape)
                            ) {
                                Icon(Icons.Default.Add, contentDescription = "Increase", tint = MedicalCyanDark, modifier = Modifier.size(16.dp))
                            }
                        }
                    }
                }
            }
        },
        containerColor = Color.White,
        shape = RoundedCornerShape(16.dp)
    )
}
