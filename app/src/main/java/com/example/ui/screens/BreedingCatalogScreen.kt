package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
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
import com.example.data.BullPedigree
import com.example.ui.components.*
import com.example.ui.theme.*
import com.example.viewmodel.VetCareViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun BreedingCatalogScreen(
    viewModel: VetCareViewModel
) {
    val bullsList by viewModel.bullsList.collectAsState()
    val aiTimestamp by viewModel.aiDateTimestamp.collectAsState()
    val bullSearch by viewModel.bullSearchQuery.collectAsState()
    val breedFilter by viewModel.bullBreedFilter.collectAsState()
    val agencyFilter by viewModel.bullAgencyFilter.collectAsState()
    val liveBullResult by viewModel.liveBullAnalysisResult.collectAsState()
    val isSearchingLiveBull by viewModel.isSearchingLiveBull.collectAsState()
    var selectedBreedingTab by remember { mutableStateOf(0) }

    val filteredBulls = bullsList.filter { bull ->
        val matchesAgency = agencyFilter == "सभी" || bull.sourceAgency.equals(agencyFilter, ignoreCase = true)
        val matchesBreed = breedFilter == "ALL" || bull.breed.contains(breedFilter, ignoreCase = true)
        val matchesSearch = bullSearch.isBlank() ||
                bull.name.contains(bullSearch, ignoreCase = true) ||
                bull.tagId.contains(bullSearch, ignoreCase = true) ||
                bull.breed.contains(bullSearch, ignoreCase = true) ||
                bull.sourceAgency.contains(bullSearch, ignoreCase = true)
        matchesAgency && matchesBreed && matchesSearch
    }

    val cal = Calendar.getInstance().apply { timeInMillis = aiTimestamp }
    val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())

    val aiDateStr = dateFormat.format(cal.time)

    val heatCheckCal = Calendar.getInstance().apply {
        timeInMillis = aiTimestamp
        add(Calendar.DAY_OF_YEAR, 21)
    }
    val heatCheckDateStr = dateFormat.format(heatCheckCal.time)

    val pdCheckCal = Calendar.getInstance().apply {
        timeInMillis = aiTimestamp
        add(Calendar.DAY_OF_YEAR, 60)
    }
    val pdCheckDateStr = dateFormat.format(pdCheckCal.time)

    val calvingCal = Calendar.getInstance().apply {
        timeInMillis = aiTimestamp
        add(Calendar.DAY_OF_YEAR, 280)
    }
    val calvingDateStr = dateFormat.format(calvingCal.time)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(DaylightCanvas)
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Header Banner
        item {
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                border = androidx.compose.foundation.BorderStroke(2.dp, AgroEmeraldPrimary),
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
                                .background(AgroEmeraldLight)
                                .border(2.dp, AgroEmeraldPrimary, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("🧬", fontSize = 22.sp)
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "प्रजनन व सांड सीमन कैटलॉग (Breeding Repository)",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Black,
                                color = Slate900
                            )
                            Text(
                                text = "टॉप पैडिग्री सांड स्ट्रा • 280-दिवसीय प्रसव कैलेंडर",
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
                        TabSelectorButton("🧬 सांड सीमन स्ट्रा कैटलॉग", selectedBreedingTab == 0, activeColor = AgroEmeraldPrimary) { selectedBreedingTab = 0 }
                        TabSelectorButton("📅 280-दिन डिलीवरी कैलकुलेटर", selectedBreedingTab == 1, activeColor = AgroEmeraldPrimary) { selectedBreedingTab = 1 }
                    }
                }
            }
        }

        if (selectedBreedingTab == 0) {
            // Search & Filter Box
            item {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                    border = androidx.compose.foundation.BorderStroke(1.5.dp, FrostedCardBorder),
                    modifier = Modifier.fillMaxWidth().shadow(1.dp, RoundedCornerShape(12.dp))
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            OutlinedTextField(
                                value = bullSearch,
                                onValueChange = { viewModel.setBullSearchQuery(it) },
                                placeholder = { Text("किसी भी सांड/नस्ल का नाम (उदा. अर्जुन कुंगड़, गीर, HF)...", fontSize = 11.5.sp, color = Slate500) },
                                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = AgroEmeraldPrimary) },
                                trailingIcon = {
                                    if (bullSearch.isNotBlank()) {
                                        IconButton(onClick = { viewModel.setBullSearchQuery("") }) {
                                            Icon(Icons.Default.Close, contentDescription = "Clear", tint = Slate500)
                                        }
                                    }
                                },
                                singleLine = true,
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(10.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = AgroEmeraldPrimary,
                                    unfocusedBorderColor = FrostedCardBorder,
                                    focusedTextColor = Slate900,
                                    unfocusedTextColor = Slate900
                                )
                            )

                            Button(
                                onClick = { viewModel.searchBullWithAi(bullSearch.ifBlank { "अर्जुन कुंगड़ (Arjun Kungrad)" }) },
                                colors = ButtonDefaults.buttonColors(containerColor = AgroEmeraldPrimary),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.height(52.dp),
                                contentPadding = PaddingValues(horizontal = 10.dp)
                            ) {
                                Text("⚡ AI सर्च", fontSize = 11.5.sp, fontWeight = FontWeight.Black, color = Color.White)
                            }
                        }

                        // AI Loading State or Live Bull Card
                        if (isSearchingLiveBull) {
                            Spacer(modifier = Modifier.height(10.dp))
                            Surface(
                                color = AgroEmeraldLight,
                                shape = RoundedCornerShape(10.dp),
                                border = androidx.compose.foundation.BorderStroke(1.dp, AgroEmeraldPrimary),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    CircularProgressIndicator(modifier = Modifier.size(20.dp), color = AgroEmeraldPrimary, strokeWidth = 2.dp)
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(
                                        text = "⚡ AI वेब-ग्राउंडेड पेडिग्री, दूध रिकॉर्ड व सीमन बैंक विश्लेषण चालू है...",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = AgroEmeraldDark
                                    )
                                }
                            }
                        } else if (liveBullResult != null) {
                            Spacer(modifier = Modifier.height(10.dp))
                            LiveAiBullAnalysisCard(
                                bull = liveBullResult!!,
                                onBookStraw = {
                                    viewModel.showToast("सीमन स्ट्रा सफलतापूर्वक बुक! (${liveBullResult!!.name})")
                                },
                                onClear = { viewModel.clearLiveBullAnalysis() }
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Source Agency Filter (HLDB, ABC, NDDB, BAIF)
                        Text(
                            text = "प्रमाणित सीमन बैंक / संस्था (Source Agency):",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Black,
                            color = Slate900
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            listOf("सभी" to "🏛️ सभी बैंक", "HLDB" to "हरियाणा बोर्ड (HLDB)", "NDDB" to "एनडीडीबी (NDDB/SAG)", "ABC" to "एबीसी ब्रीडिंग (ABC)", "BAIF" to "बाइफ संस्थान (BAIF)").forEach { (code, label) ->
                                val isSelected = agencyFilter == code
                                Surface(
                                    onClick = { viewModel.setBullAgencyFilter(code) },
                                    color = if (isSelected) AgroEmeraldPrimary else Color.White,
                                    shape = RoundedCornerShape(8.dp),
                                    border = androidx.compose.foundation.BorderStroke(1.2.dp, if (isSelected) AgroEmeraldPrimary else FrostedCardBorder)
                                ) {
                                    Text(
                                        text = label,
                                        fontSize = 11.sp,
                                        fontWeight = if (isSelected) FontWeight.Black else FontWeight.Bold,
                                        color = if (isSelected) Color.White else Slate900,
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Universal Multi-Species & Breed Filter
                        Text(
                            text = "प्रजाति व नस्ल चयन (Multi-Species & Breed):",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Black,
                            color = Slate900
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            listOf(
                                "ALL" to "सभी नस्लें",
                                "Murrah" to "🐃 मुराह भैंस",
                                "Jaffarabadi" to "🐃 जाफराबादी भैंस",
                                "Sahiwal" to "🐄 साहीवाल गाय",
                                "Gir" to "🐄 गीर गाय",
                                "Tharparkar" to "🐄 थारपारकर",
                                "HF" to "🐄 एचएफ (HF)",
                                "Jersey" to "🐄 जर्सी",
                                "Beetal" to "🐐 बीटल बकरी",
                                "Merino" to "🐑 मेरिनो भेड़",
                                "German" to "🐕 जर्मन शेफर्ड"
                            ).forEach { (code, label) ->
                                val isSelected = breedFilter == code
                                Surface(
                                    onClick = { viewModel.setBullBreedFilter(code) },
                                    color = if (isSelected) AgroEmeraldPrimary else Color.White,
                                    shape = RoundedCornerShape(8.dp),
                                    border = androidx.compose.foundation.BorderStroke(1.dp, if (isSelected) AgroEmeraldPrimary else FrostedCardBorder)
                                ) {
                                    Text(
                                        text = label,
                                        fontSize = 11.sp,
                                        fontWeight = if (isSelected) FontWeight.Black else FontWeight.Bold,
                                        color = if (isSelected) Color.White else Slate900,
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Horizontal Carousel of Top Conception Bulls
            item {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "🏆 टॉप पैडिग्री सांड (Horizontal Swipe Carousel):",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Black,
                            color = Slate900
                        )
                        Text(
                            text = "उच्च गर्भधारण दर",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = AgroEmeraldDark
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    androidx.compose.foundation.lazy.LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(filteredBulls) { bull ->
                            Card(
                                shape = RoundedCornerShape(14.dp),
                                colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                                border = androidx.compose.foundation.BorderStroke(1.5.dp, AgroEmeraldPrimary),
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
                                        Text(bull.breed.take(10), fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Slate900)
                                        Surface(
                                            color = AgroEmeraldLight,
                                            shape = RoundedCornerShape(6.dp),
                                            border = androidx.compose.foundation.BorderStroke(1.dp, AgroEmeraldPrimary)
                                        ) {
                                            Text(
                                                text = "${bull.conceptionRatePercent}% CR",
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Black,
                                                color = AgroEmeraldDark,
                                                modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(bull.name, fontSize = 12.sp, fontWeight = FontWeight.Black, color = Slate900, maxLines = 1)
                                    Text("मां का दुग्ध: ${bull.damPeakLactationKg} kg", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = AgroEmeraldDark)
                                    Spacer(modifier = Modifier.height(6.dp))
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text("₹${bull.pricePerStraw}/स्ट्रा", fontSize = 12.sp, fontWeight = FontWeight.Black, color = Slate900)
                                        Button(
                                            onClick = { viewModel.showToast("स्ट्रा बुक: ${bull.name}") },
                                            colors = ButtonDefaults.buttonColors(containerColor = AgroEmeraldPrimary),
                                            shape = RoundedCornerShape(6.dp),
                                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp)
                                        ) {
                                            Text("बुक", fontSize = 10.sp, color = Color.White)
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }

            // Bulls Repository List
            items(filteredBulls) { bull ->
                BullPedigreeCard(bull = bull, onOrderStraw = {
                    viewModel.showToast("सीमन स्ट्रा बुक की गई: ${bull.name}")
                })
            }
        } else {
            // 280-Day Calving Calculator Card
            item {
                Card(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                    border = androidx.compose.foundation.BorderStroke(2.dp, AgroEmeraldPrimary),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.CalendarMonth, contentDescription = null, tint = AgroEmeraldPrimary)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "280-दिवसीय गर्भ व प्रसव कैलकुलेटर",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Black,
                                color = Slate900
                            )
                        }
                        Text(
                            text = "कृत्रिम गर्भाधान (A.I.) की तारीख से महत्वपूर्ण जांच व डिलीवरी डेट:",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Slate900
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Surface(
                            color = Color.White,
                            shape = RoundedCornerShape(12.dp),
                            border = androidx.compose.foundation.BorderStroke(1.5.dp, FrostedCardBorder),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text("ए.आई. की तारीख (Insemination Date):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Slate900)
                                    Text(aiDateStr, fontSize = 16.sp, fontWeight = FontWeight.Black, color = Slate900)
                                }
                                Button(
                                    onClick = { viewModel.setAiDate(System.currentTimeMillis()) },
                                    colors = ButtonDefaults.buttonColors(containerColor = AgroEmeraldPrimary)
                                ) {
                                    Text("आज की तारीख", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        CalvingMilestoneItem(
                            stepNumber = "1",
                            title = "21-दिन हीट वापसी जांच (Heat Return Check)",
                            dateText = heatCheckDateStr,
                            badgeText = "21 वां दिन",
                            badgeColor = AmberWarning,
                            instruction = "यदि पशु दोबारा रंभाए या तार गिराए तो तुरंत डॉक्टर को दिखाएं।"
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        CalvingMilestoneItem(
                            stepNumber = "2",
                            title = "60-दिन गाभिन जांच (PD Palpation Date)",
                            dateText = pdCheckDateStr,
                            badgeText = "60 वां दिन",
                            badgeColor = MedicalCyanPrimary,
                            instruction = "हाथ डालकर गर्भ परीक्षण (Per-rectal exam) द्वारा गर्भ सुनिश्चित करें।"
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        CalvingMilestoneItem(
                            stepNumber = "3",
                            title = "अपेक्षित प्रसव तिथि (280-Day Calving Countdown)",
                            dateText = calvingDateStr,
                            badgeText = "280 वां दिन (डिलीवरी)",
                            badgeColor = RedAlert,
                            instruction = "ब्यांत से 15 दिन पूर्व पशु को अलग साफ हवादार कोठरी में बांधें।"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BullPedigreeCard(
    bull: BullPedigree,
    onOrderStraw: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = androidx.compose.foundation.BorderStroke(1.5.dp, FrostedCardBorder),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = bull.name,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Black,
                            color = Slate900
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Surface(
                            color = AgroEmeraldLight,
                            shape = RoundedCornerShape(4.dp),
                            border = androidx.compose.foundation.BorderStroke(1.dp, AgroEmeraldPrimary)
                        ) {
                            Text(
                                text = bull.sourceAgency,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Black,
                                color = AgroEmeraldDark,
                                modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
                            )
                        }
                    }
                    Text(
                        text = "टैग: ${bull.tagId} • नस्ल: ${bull.breed} • बैंक: ${bull.sourceAgency}",
                        fontSize = 11.sp,
                        color = AgroEmeraldDark,
                        fontWeight = FontWeight.Bold
                    )
                }

                Surface(
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp),
                    border = androidx.compose.foundation.BorderStroke(1.5.dp, AgroEmeraldPrimary)
                ) {
                    Text(
                        text = "₹${bull.pricePerStraw} / स्ट्रा",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Black,
                        color = Slate900,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
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
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "वंशावली (Lineage): ${bull.sireDamLineage}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Slate900
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "मां का पीक दुग्ध: ${bull.damPeakLactationKg} किग्रा",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Black,
                            color = Slate900
                        )
                        Text(
                            text = "फैट: ${bull.damFatPercent}% • गर्भधारण दर: ${bull.conceptionRatePercent}%",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Slate900
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "उपलब्ध स्ट्रा: ${bull.strawStockCount} Stems",
                    fontSize = 12.sp,
                    color = Slate900,
                    fontWeight = FontWeight.Bold
                )

                Button(
                    onClick = onOrderStraw,
                    colors = ButtonDefaults.buttonColors(containerColor = AgroEmeraldPrimary),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text("सीमन बुक करें", fontSize = 12.sp, fontWeight = FontWeight.Black, color = Color.White)
                }
            }
        }
    }
}

@Composable
fun CalvingMilestoneItem(
    stepNumber: String,
    title: String,
    dateText: String,
    badgeText: String,
    badgeColor: Color,
    instruction: String
) {
    Surface(
        color = Color.White,
        shape = RoundedCornerShape(12.dp),
        border = androidx.compose.foundation.BorderStroke(1.5.dp, FrostedCardBorder),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(badgeColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(stepNumber, color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(title, fontSize = 13.sp, fontWeight = FontWeight.Black, color = Slate900)
                }
                Surface(
                    color = Color.White,
                    shape = RoundedCornerShape(6.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, badgeColor)
                ) {
                    Text(
                        text = badgeText,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Black,
                        color = Slate900,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "तारीख: $dateText",
                fontSize = 15.sp,
                fontWeight = FontWeight.Black,
                color = Slate900
            )
            Text(
                text = "परामर्श: $instruction",
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = Slate900
            )
        }
    }
}

@Composable
fun LiveAiBullAnalysisCard(
    bull: BullPedigree,
    onBookStraw: () -> Unit,
    onClear: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = DaylightSurface),
        border = androidx.compose.foundation.BorderStroke(2.dp, AgroEmeraldPrimary),
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp, RoundedCornerShape(16.dp))
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        color = AgroEmeraldLight,
                        shape = RoundedCornerShape(8.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, AgroEmeraldPrimary)
                    ) {
                        Text(
                            text = "⚡ AI लाइव विश्लेषण",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.Black,
                            color = AgroEmeraldDark,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = bull.tagId,
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Slate600
                    )
                }

                IconButton(
                    onClick = onClear,
                    modifier = Modifier.size(28.dp).clip(CircleShape).background(Slate100)
                ) {
                    Icon(Icons.Default.Close, contentDescription = "Clear", tint = Slate700, modifier = Modifier.size(16.dp))
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = bull.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Black,
                color = Slate900
            )
            Text(
                text = "नस्ल: ${bull.breed} • बैंक: ${bull.sourceAgency}",
                fontSize = 11.5.sp,
                fontWeight = FontWeight.Bold,
                color = AgroEmeraldDark
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Stats Grid
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Surface(
                    color = DaylightCanvas,
                    shape = RoundedCornerShape(10.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, FrostedCardBorder),
                    modifier = Modifier.weight(1f)
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text("माता का दूध रिकॉर्ड", fontSize = 9.5.sp, color = Slate600, fontWeight = FontWeight.Bold)
                        Text("${bull.damPeakLactationKg} kg/दिन (${bull.damFatPercent}% वसा)", fontSize = 11.sp, fontWeight = FontWeight.Black, color = Slate900)
                    }
                }

                Surface(
                    color = DaylightCanvas,
                    shape = RoundedCornerShape(10.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, FrostedCardBorder),
                    modifier = Modifier.weight(1f)
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text("गर्भधारण दर (CR)", fontSize = 9.5.sp, color = Slate600, fontWeight = FontWeight.Bold)
                        Text("${bull.conceptionRatePercent}%", fontSize = 11.sp, fontWeight = FontWeight.Black, color = GreenSuccessDark)
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Surface(
                color = DaylightCanvas,
                shape = RoundedCornerShape(10.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, FrostedCardBorder),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text("वंशावली / पेडिग्री (Lineage):", fontSize = 10.sp, fontWeight = FontWeight.Black, color = Slate900)
                    Text(bull.sireDamLineage, fontSize = 10.5.sp, color = Slate700)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("सीमन स्ट्रा मूल्य: ₹${bull.pricePerStraw}/-", fontSize = 13.sp, fontWeight = FontWeight.Black, color = AgroEmeraldDark)
                    Text("उपलब्ध स्ट्रा: ${bull.strawStockCount} डोज", fontSize = 10.sp, color = Slate600)
                }

                Button(
                    onClick = onBookStraw,
                    colors = ButtonDefaults.buttonColors(containerColor = AgroEmeraldPrimary),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text("✅ स्ट्रा बुक करें", fontSize = 11.5.sp, fontWeight = FontWeight.Black, color = Color.White)
                }
            }
        }
    }
}
