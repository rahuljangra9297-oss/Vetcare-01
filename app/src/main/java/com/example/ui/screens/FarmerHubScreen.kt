package com.example.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.*
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.*
import com.example.ui.components.*
import com.example.ui.theme.*
import com.example.viewmodel.VetCareViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun FarmerHubScreen(
    viewModel: VetCareViewModel
) {
    val pashuList by viewModel.pashuList.collectAsState()
    val milkEntries by viewModel.milkEntries.collectAsState()
    val inputLiters by viewModel.calcMilkLiters.collectAsState()
    val inputFat by viewModel.calcFatPercent.collectAsState()
    val inputSnf by viewModel.calcSnfPercent.collectAsState()
    val repeatCauses by viewModel.repeatBreederCauses.collectAsState()
    val farmerDiseases by viewModel.farmerDiseases.collectAsState()
    val diseaseSearch by viewModel.farmerDiseaseSearch.collectAsState()
    val aiTimestamp by viewModel.aiDateTimestamp.collectAsState()

    var activeFarmerTab by remember { mutableStateOf(0) }
    var expandedRepeatCauseId by remember { mutableStateOf<String?>("rb_endometritis") }
    var expandedDiseaseId by remember { mutableStateOf<String?>("fd_mastitis") }

    val context = LocalContext.current

    val liters = inputLiters.toDoubleOrNull() ?: 10.0
    val fat = inputFat.toDoubleOrNull() ?: 6.5
    val snf = inputSnf.toDoubleOrNull() ?: 8.8
    val previewRate = Math.round(((fat * 5.8) + (snf * 2.2)) * 100.0) / 100.0
    val previewTotal = Math.round((liters * previewRate) * 100.0) / 100.0

    val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    val cal = Calendar.getInstance().apply { timeInMillis = aiTimestamp }
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

    var selectedAnatomicalTab by remember { mutableStateOf("ALL") }

    val filteredDiseases = farmerDiseases.filter { dis ->
        (selectedAnatomicalTab == "ALL" || dis.anatomicalCategory == selectedAnatomicalTab) &&
        (diseaseSearch.isBlank() ||
         dis.nameHindi.contains(diseaseSearch, ignoreCase = true) ||
         dis.desiNames.contains(diseaseSearch, ignoreCase = true) ||
         dis.nameScientific.contains(diseaseSearch, ignoreCase = true) ||
         dis.clinicalSigns.any { it.contains(diseaseSearch, ignoreCase = true) })
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(DaylightCanvas)
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Farmer Hub Header
        item {
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                border = BorderStroke(2.dp, AgroEmeraldPrimary),
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
                                .background(AgroEmeraldLight)
                                .border(2.dp, AgroEmeraldPrimary, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("🌾", fontSize = 24.sp)
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "स्मार्ट पशुपालक हब (Smart Dairy Farmer Hub)",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Black,
                                color = Slate900
                            )
                            Text(
                                text = "पशु आधार • 280-दिवसीय प्रसव कैलेंडर • रिपीट ब्रीडर गाइड • दूध खाता",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = AgroEmeraldDark
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
                        TabSelectorButton("🐾 पशु आधार व गर्भ चक्र", activeFarmerTab == 0) { activeFarmerTab = 0 }
                        TabSelectorButton("🧬 रिपीट ब्रीडर समाधान", activeFarmerTab == 1) { activeFarmerTab = 1 }
                        TabSelectorButton("📖 रोग व चरण निर्देशिका", activeFarmerTab == 2) { activeFarmerTab = 2 }
                        TabSelectorButton("🥛 दूध-फैट खाता बही", activeFarmerTab == 3) { activeFarmerTab = 3 }
                        TabSelectorButton("🥣 45 देसी नुस्खे", activeFarmerTab == 4) { activeFarmerTab = 4 }
                        TabSelectorButton("🐂 उच्च नस्ल सांड कैटलॉग", activeFarmerTab == 6) { viewModel.navigateTo(ScreenDestination.BREEDING_CATALOG) }
                        TabSelectorButton("🚨 आपातकालीन हेल्पलाइन", activeFarmerTab == 5) { activeFarmerTab = 5 }
                    }
                }
            }
        }

        when (activeFarmerTab) {
            0 -> {
                // TAB 0: PASHU PASSBOOK & 280-DAY GESTATION TRACKER
                item {
                    // Quick Horizontal Cattle Carousel
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "🐾 पंजीकृत पशु आधार कार्ड (Swipeable Cattle):",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Black,
                                color = Slate900
                            )
                            Text(
                                text = "${pashuList.size} पशु पंजीकृत",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = AgroEmeraldDark
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(pashuList) { pashu ->
                                Card(
                                    shape = RoundedCornerShape(14.dp),
                                    colors = CardDefaults.cardColors(containerColor = DaylightSurface),
                                    border = BorderStroke(1.5.dp, if (pashu.isPregnant) RedAlert else AgroEmeraldPrimary),
                                    modifier = Modifier
                                        .width(220.dp)
                                        .shadow(2.dp, RoundedCornerShape(14.dp))
                                ) {
                                    Column(modifier = Modifier.padding(12.dp)) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Text(pashu.species.icon, fontSize = 20.sp)
                                                Spacer(modifier = Modifier.width(6.dp))
                                                Text(
                                                    text = pashu.breed,
                                                    fontSize = 12.sp,
                                                    fontWeight = FontWeight.Black,
                                                    color = Slate900
                                                )
                                            }
                                            Surface(
                                                color = if (pashu.isPregnant) RedAlertLight else GreenSuccess.copy(alpha = 0.15f),
                                                shape = RoundedCornerShape(4.dp),
                                                border = BorderStroke(1.dp, if (pashu.isPregnant) RedAlert else GreenSuccess)
                                            ) {
                                                Text(
                                                    text = if (pashu.isPregnant) "गाभिन (${pashu.pregnancyMonth} माह)" else "खाली",
                                                    fontSize = 9.sp,
                                                    fontWeight = FontWeight.Black,
                                                    color = if (pashu.isPregnant) RedAlert else GreenSuccess,
                                                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                                                )
                                            }
                                        }

                                        Spacer(modifier = Modifier.height(6.dp))
                                        Text(pashu.tagId, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Slate900)
                                        Text("दैनिक दूध: ${pashu.dailyMilkAvgLiters} L • ${pashu.lactationStage}", fontSize = 11.sp, color = Slate900)
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text("टीकाकरण: ${pashu.lastVaccine}", fontSize = 10.sp, color = AgroEmeraldDark, fontWeight = FontWeight.Bold)
                                    }
                                }
                            }
                        }
                    }
                }

                // 280-Day Heat Cycle & Gestation Countdown Card
                item {
                    Card(
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        border = BorderStroke(2.dp, AgroEmeraldPrimary),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text("🗓️", fontSize = 20.sp)
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Column {
                                        Text(
                                            text = "280-दिवसीय गर्भ व प्रसव कैलकुलेटर",
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Black,
                                            color = Slate900
                                        )
                                        Text(
                                            text = "ए.आई. तारीख से ऑटो-कैलकुलेटेड अलर्ट",
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = AgroEmeraldDark
                                        )
                                    }
                                }

                                Surface(
                                    color = AgroEmeraldLight,
                                    shape = RoundedCornerShape(6.dp),
                                    border = BorderStroke(1.dp, AgroEmeraldPrimary)
                                ) {
                                    Text(
                                        text = "AI: $aiDateStr",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Black,
                                        color = AgroEmeraldDark,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(14.dp))

                            // 3 Key Breeding Alerts (21-Day, 60-Day, 280-Day)
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Surface(
                                    color = DaylightCanvas,
                                    shape = RoundedCornerShape(12.dp),
                                    border = BorderStroke(1.5.dp, AmberWarning),
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Column(modifier = Modifier.padding(10.dp)) {
                                        Text("1️⃣ 21 दिन हीट अलर्ट", fontSize = 10.sp, fontWeight = FontWeight.Black, color = AmberWarning)
                                        Spacer(modifier = Modifier.height(2.dp))
                                        Text(heatCheckDateStr, fontSize = 12.sp, fontWeight = FontWeight.Black, color = Slate900)
                                        Text("हीट लक्षण जांचें", fontSize = 9.sp, color = Slate900)
                                    }
                                }

                                Surface(
                                    color = DaylightCanvas,
                                    shape = RoundedCornerShape(12.dp),
                                    border = BorderStroke(1.5.dp, MedicalCyanPrimary),
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Column(modifier = Modifier.padding(10.dp)) {
                                        Text("2️⃣ 60 दिन PD चेक", fontSize = 10.sp, fontWeight = FontWeight.Black, color = MedicalCyanDark)
                                        Spacer(modifier = Modifier.height(2.dp))
                                        Text(pdCheckDateStr, fontSize = 12.sp, fontWeight = FontWeight.Black, color = Slate900)
                                        Text("गर्भ पुष्टि जांच", fontSize = 9.sp, color = Slate900)
                                    }
                                }

                                Surface(
                                    color = DaylightCanvas,
                                    shape = RoundedCornerShape(12.dp),
                                    border = BorderStroke(1.5.dp, AgroEmeraldPrimary),
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Column(modifier = Modifier.padding(10.dp)) {
                                        Text("3️⃣ 280 दिन प्रसव", fontSize = 10.sp, fontWeight = FontWeight.Black, color = AgroEmeraldDark)
                                        Spacer(modifier = Modifier.height(2.dp))
                                        Text(calvingDateStr, fontSize = 12.sp, fontWeight = FontWeight.Black, color = Slate900)
                                        Text("ब्यांत की तैयारी", fontSize = 9.sp, color = Slate900)
                                    }
                                }
                            }
                        }
                    }
                }

                // Full Detailed Animal Cards
                items(pashuList) { pashu ->
                    PashuPassbookCard(pashu = pashu)
                }
            }

            1 -> {
                // TAB 1: REPEAT BREEDER ROOT CAUSE ANALYZER (6 FIELD CAUSES)
                item {
                    Card(
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        border = BorderStroke(2.dp, AgroEmeraldPrimary),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("🧬", fontSize = 22.sp)
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(
                                        text = "रिपीट ब्रीडर रूट कॉज एनालाइजर (Repeat Breeder AI)",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Black,
                                        color = Slate900
                                    )
                                    Text(
                                        text = "गाय-भैंस बार-बार फिरने के 6 प्रमुख वैज्ञानिक कारण व अचूक समाधान",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = AgroEmeraldDark
                                    )
                                }
                            }
                        }
                    }
                }

                items(repeatCauses) { cause ->
                    val isExpanded = expandedRepeatCauseId == cause.id
                    Card(
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        border = BorderStroke(if (isExpanded) 2.dp else 1.dp, if (isExpanded) AgroEmeraldPrimary else FrostedCardBorder),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                expandedRepeatCauseId = if (isExpanded) null else cause.id
                            }
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = cause.title,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Black,
                                        color = Slate900
                                    )
                                    Text(
                                        text = cause.scientificTitle,
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = AgroEmeraldDark
                                    )
                                }
                                Icon(
                                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    tint = Slate900
                                )
                            }

                            AnimatedVisibility(visible = isExpanded) {
                                Column(modifier = Modifier.padding(top = 10.dp)) {
                                    Divider(color = FrostedCardBorder, thickness = 1.dp)
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "लक्षण व पहचान: ${cause.description}",
                                        fontSize = 11.sp,
                                        color = Slate900,
                                        lineHeight = 16.sp
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Surface(
                                        color = AgroEmeraldLight,
                                        shape = RoundedCornerShape(10.dp),
                                        border = BorderStroke(1.dp, AgroEmeraldPrimary),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(modifier = Modifier.padding(10.dp)) {
                                            Text(
                                                text = "🩺 फील्ड उपचार प्रोटोकॉल:",
                                                fontSize = 11.sp,
                                                fontWeight = FontWeight.Black,
                                                color = AgroEmeraldDark
                                            )
                                            Text(
                                                text = cause.fieldProtocol,
                                                fontSize = 11.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Slate900,
                                                lineHeight = 16.sp
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "दवाइयां: ${cause.recommendedMedicines.joinToString(" • ")}",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Slate900
                                    )
                                }
                            }
                        }
                    }
                }
            }

            2 -> {
                // TAB 2: FARMER DISEASE DIRECTORY WITH 3-STAGE PROGRESSION TIMELINE
                item {
                    Card(
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        border = BorderStroke(2.dp, AgroEmeraldPrimary),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("📖", fontSize = 22.sp)
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(
                                        text = "किसान रोग निर्देशिका व प्रगति चरण (Disease Directory)",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Black,
                                        color = Slate900
                                    )
                                    Text(
                                        text = "लक्षण, दिन-वार रोग के 3 चरण, घरेलू नुस्खे व आपातकालीन कदम",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = AgroEmeraldDark
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            OutlinedTextField(
                                value = diseaseSearch,
                                onValueChange = { viewModel.setFarmerDiseaseSearch(it) },
                                label = { Text("बीमारी का नाम खोजें (उदा. थनैला, गलघोंटू, आफरा)", fontWeight = FontWeight.Bold) },
                                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = AgroEmeraldPrimary) },
                                trailingIcon = {
                                    if (diseaseSearch.isNotBlank()) {
                                        IconButton(onClick = { viewModel.setFarmerDiseaseSearch("") }) {
                                            Icon(Icons.Default.Close, contentDescription = "Clear", tint = Slate500)
                                        }
                                    }
                                },
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth().testTag("farmer_disease_search_input")
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            // 6 Anatomical Category Tab Carousels
                            Text("शारीरिक अंग श्रेणी (6 Anatomical Tabs):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = AgroEmeraldDark)
                            Spacer(modifier = Modifier.height(6.dp))

                            val anatomicalCategories = listOf(
                                "ALL" to "⭐ समस्त रोग (45+)",
                                "HEAD_NERVOUS" to "🧠 सिर, मुंह व तंत्रिका",
                                "THROAT_CHEST" to "🫁 गला, सीना व श्वसन",
                                "ABDOMEN_DUNG" to "🥣 पेट, पाचन व गोबर",
                                "UDDER_MILK" to "🥛 थन, अयन व दुग्ध",
                                "URINARY_REPRO" to "💧 मूत्र, जननांग व प्रजनन",
                                "LEGS_SKIN" to "🦵 पैर, खुर, त्वचा व मेटाबॉलिक"
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                anatomicalCategories.forEach { (catId, catLabel) ->
                                    val isCatSelected = selectedAnatomicalTab == catId
                                    Surface(
                                        onClick = { selectedAnatomicalTab = catId },
                                        color = if (isCatSelected) AgroEmeraldPrimary else DaylightCanvas,
                                        shape = RoundedCornerShape(8.dp),
                                        border = BorderStroke(1.2.dp, if (isCatSelected) AgroEmeraldPrimary else FrostedCardBorder)
                                    ) {
                                        Text(
                                            text = catLabel,
                                            fontSize = 11.sp,
                                            fontWeight = if (isCatSelected) FontWeight.Black else FontWeight.Bold,
                                            color = if (isCatSelected) Color.White else Slate900,
                                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                items(filteredDiseases) { dis ->
                    val isExpanded = expandedDiseaseId == dis.id
                    Card(
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        border = BorderStroke(if (isExpanded) 2.dp else 1.2.dp, if (isExpanded) AgroEmeraldPrimary else FrostedCardBorder),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { expandedDiseaseId = if (isExpanded) null else dis.id }
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = dis.nameHindi,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Black,
                                        color = Slate900
                                    )
                                    Text(
                                        text = "देसी नाम: ${dis.desiNames} • ${dis.nameScientific}",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Slate900
                                    )
                                }
                                Icon(
                                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    tint = Slate900
                                )
                            }

                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "कारण: ${dis.rootCauseType}",
                                fontSize = 11.sp,
                                color = AgroEmeraldDark,
                                fontWeight = FontWeight.Bold
                            )

                            AnimatedVisibility(visible = isExpanded) {
                                Column(modifier = Modifier.padding(top = 10.dp)) {
                                    Divider(color = FrostedCardBorder, thickness = 1.dp)
                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text("🚨 प्रमुख नैदानिक लक्षण:", fontSize = 11.sp, fontWeight = FontWeight.Black, color = Slate900)
                                    dis.clinicalSigns.forEach { sign ->
                                        Text("• $sign", fontSize = 11.sp, color = Slate900)
                                    }

                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text("📈 रोग प्रगति की समयरेखा (Disease Progression Timeline):", fontSize = 11.sp, fontWeight = FontWeight.Black, color = MedicalCyanDark)
                                    Spacer(modifier = Modifier.height(4.dp))

                                    dis.stagesTimeline.forEachIndexed { idx, stage ->
                                        Surface(
                                            color = when (idx) {
                                                0 -> AgroEmeraldLight
                                                1 -> AmberWarningLight
                                                else -> RedAlertLight
                                            },
                                            shape = RoundedCornerShape(8.dp),
                                            border = BorderStroke(1.dp, when (idx) {
                                                0 -> AgroEmeraldPrimary
                                                1 -> AmberWarning
                                                else -> RedAlert
                                            }),
                                            modifier = Modifier.fillMaxWidth().padding(vertical = 3.dp)
                                        ) {
                                            Text(
                                                text = stage,
                                                fontSize = 11.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Slate900,
                                                modifier = Modifier.padding(8.dp)
                                            )
                                        }
                                    }

                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text("🥣 प्राथमिक घरेलू उपचार:", fontSize = 11.sp, fontWeight = FontWeight.Black, color = AgroEmeraldDark)
                                    dis.homeRemedies.forEach { remedy ->
                                        Text("• $remedy", fontSize = 11.sp, color = Slate900)
                                    }

                                    Spacer(modifier = Modifier.height(8.dp))
                                    Surface(
                                        color = RedAlertLight,
                                        shape = RoundedCornerShape(8.dp),
                                        border = BorderStroke(1.dp, RedAlert),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(
                                            text = "⚠️ त्वरित डॉक्टर कदम: ${dis.urgentAction}",
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Black,
                                            color = RedAlert,
                                            modifier = Modifier.padding(8.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            3 -> {
                // TAB 3: MILK FAT & SNF CALCULATOR & MONTHLY LEDGER
                item {
                    Card(
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        border = BorderStroke(2.dp, AgroEmeraldPrimary),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "🥛 दुग्ध-फैट व एसएनएफ कैलकुलेटर (Milk Rate Calc)",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black,
                                color = Slate900
                            )
                            Text(
                                text = "डेयरी मानक TS फॉर्मूला: फैट व एसएनएफ के आधार पर सटीक दैनिक आय:",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Slate900
                            )

                            Spacer(modifier = Modifier.height(14.dp))

                            OutlinedTextField(
                                value = inputLiters,
                                onValueChange = { viewModel.setCalcMilkLiters(it) },
                                label = { Text("कुल दूध मात्रा (Liters)", fontWeight = FontWeight.Bold) },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                OutlinedTextField(
                                    value = inputFat,
                                    onValueChange = { viewModel.setCalcFatPercent(it) },
                                    label = { Text("फैट % (Fat)", fontWeight = FontWeight.Bold) },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                                    singleLine = true,
                                    modifier = Modifier.weight(1f)
                                )
                                OutlinedTextField(
                                    value = inputSnf,
                                    onValueChange = { viewModel.setCalcSnfPercent(it) },
                                    label = { Text("एसएनएफ % (SNF)", fontWeight = FontWeight.Bold) },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                                    singleLine = true,
                                    modifier = Modifier.weight(1f)
                                )
                            }

                            Spacer(modifier = Modifier.height(14.dp))

                            Surface(
                                color = Color.White,
                                shape = RoundedCornerShape(12.dp),
                                border = BorderStroke(2.dp, AgroEmeraldPrimary),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(14.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Column {
                                        Text("डेयरी रेट प्रति लीटर:", fontSize = 11.sp, color = AgroEmeraldDark, fontWeight = FontWeight.Bold)
                                        Text("₹$previewRate /L", fontSize = 18.sp, fontWeight = FontWeight.Black, color = Slate900)
                                    }
                                    Column(horizontalAlignment = Alignment.End) {
                                        Text("कुल दैनिक दुग्ध आय:", fontSize = 11.sp, color = AgroEmeraldDark, fontWeight = FontWeight.Bold)
                                        Text("₹$previewTotal", fontSize = 22.sp, fontWeight = FontWeight.Black, color = AgroEmeraldDark)
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(14.dp))

                            Button(
                                onClick = { viewModel.recordMilkEntry() },
                                colors = ButtonDefaults.buttonColors(containerColor = AgroEmeraldPrimary),
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(48.dp)
                            ) {
                                Text("📝 खाता बही में दर्ज करें (Save Ledger)", fontSize = 13.sp, fontWeight = FontWeight.Black, color = Color.White)
                            }
                        }
                    }
                }

                item {
                    Text(
                        text = "मासिक दुग्ध खाता बही (Recent Ledger History):",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Black,
                        color = Slate900,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

                items(milkEntries) { entry ->
                    MilkEntryRow(entry = entry)
                }
            }

            4 -> {
                // TAB 4: 100% DESI NUSKHE (45 NDDB/IVRI Herbal Remedies)
                item {
                    DesiRemediesHub(viewModel = viewModel)
                }
            }

            5 -> {
                // TAB 5: EMERGENCY SOS
                item {
                    EmergencySosCard(onCall = {
                        val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9991039297"))
                        context.startActivity(callIntent)
                    })
                }
            }
        }
    }
}

@Composable
fun PashuPassbookCard(pashu: PashuRecord) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
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
                    Text(pashu.species.icon, fontSize = 22.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = pashu.tagId,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Black,
                            color = Slate900
                        )
                        Text(
                            text = "मालिक: ${pashu.ownerName} (${pashu.village})",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Slate900
                        )
                    }
                }

                Surface(
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.5.dp, if (pashu.isPregnant) RedAlert else GreenSuccess)
                ) {
                    Text(
                        text = if (pashu.isPregnant) "🔴 गाभिन (${pashu.pregnancyMonth} माह)" else "🟢 खाली (Non-Pregnant)",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Black,
                        color = Slate900,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text("नस्ल:", fontSize = 10.sp, color = Slate900, fontWeight = FontWeight.Bold)
                    Text(pashu.breed, fontSize = 12.sp, fontWeight = FontWeight.Black, color = Slate900)
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text("उम्र:", fontSize = 10.sp, color = Slate900, fontWeight = FontWeight.Bold)
                    Text("${pashu.ageYears} वर्ष", fontSize = 12.sp, fontWeight = FontWeight.Black, color = Slate900)
                }
                Column(modifier = Modifier.weight(1.2f)) {
                    Text("दैनिक दूध:", fontSize = 10.sp, color = Slate900, fontWeight = FontWeight.Bold)
                    Text("${pashu.dailyMilkAvgLiters} ली/दिन", fontSize = 12.sp, fontWeight = FontWeight.Black, color = AgroEmeraldDark)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Surface(
                color = DaylightCanvas,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("टीकाकरण: ${pashu.lastVaccine}", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Slate900)
                    Text("कीड़े की दवा: ${pashu.dewormingStatus}", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Slate900)
                }
            }
        }
    }
}

@Composable
fun MilkEntryRow(entry: MilkEntry) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.2.dp, FrostedCardBorder),
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
                Text(text = "${entry.date} • ${entry.shift}", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Slate900)
                Text(text = "मात्रा: ${entry.liters} L • फैट: ${entry.fatPercent}% • SNF: ${entry.snfPercent}%", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Slate900)
                Text(text = "रेट: ₹${entry.ratePerLiter} प्रति लीटर", fontSize = 11.sp, color = AgroEmeraldDark, fontWeight = FontWeight.Bold)
            }
            Text(text = "₹${entry.totalEarnings}", fontSize = 16.sp, fontWeight = FontWeight.Black, color = AgroEmeraldDark)
        }
    }
}

@Composable
fun DesiRemediesHub(viewModel: VetCareViewModel) {
    val remedies by viewModel.herbalRemedies45.collectAsState()
    val searchQuery by viewModel.herbalSearchQuery.collectAsState()
    val selectedCategory by viewModel.herbalCategoryFilter.collectAsState()

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
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("🥣", fontSize = 24.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "45 देसी नुस्खा बैंक (NDDB/IVRI Certified)",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Black,
                            color = Slate900
                        )
                        Text(
                            text = "ग्राम/मिली सटीक मात्रा • तैयारी विधि • खुराक अनुसूची",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = AgroEmeraldDark
                        )
                    }
                }
                Surface(
                    color = AgroEmeraldLight,
                    shape = RoundedCornerShape(6.dp),
                    border = BorderStroke(1.dp, AgroEmeraldPrimary)
                ) {
                    Text(
                        text = "${remedies.size} नुस्खे",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Black,
                        color = AgroEmeraldDark,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Search Bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { viewModel.setHerbalSearchQuery(it) },
                placeholder = { Text("बीमारी, अंग या देसी नाम खोजें (उदा. थनैला, आफरा, घाव)...") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = AgroEmeraldPrimary) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Anatomical Categories Carousel
            val categories = listOf("All", "थन व दुग्ध", "पेट व पाचन", "प्रजनन व गर्भाशय", "त्वचा व घाव", "श्वास व बुखार", "जोड़ व पैर")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                categories.forEach { cat ->
                    val isSelected = (cat == "All" && selectedCategory.isBlank()) || selectedCategory == cat
                    FilterChip(
                        selected = isSelected,
                        onClick = { viewModel.setHerbalCategory(if (cat == "All") "" else cat) },
                        label = { Text(cat, fontSize = 11.sp, fontWeight = FontWeight.Bold) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = AgroEmeraldPrimary,
                            selectedLabelColor = Color.White
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                remedies.forEach { remedy ->
                    Surface(
                        color = DaylightCanvas,
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(1.2.dp, FrostedCardBorder),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "${remedy.conditionNameHindi} (${remedy.conditionNameEnglish})",
                                    fontSize = 13.5.sp,
                                    fontWeight = FontWeight.Black,
                                    color = Slate900
                                )
                                Surface(
                                    color = Color.White,
                                    shape = RoundedCornerShape(4.dp),
                                    border = BorderStroke(1.dp, AgroEmeraldPrimary)
                                ) {
                                    Text(
                                        text = remedy.anatomicalCategory,
                                        fontSize = 9.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = AgroEmeraldDark,
                                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "🌿 घटक (सटीक मात्रा):",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Black,
                                color = AgroEmeraldDark
                            )
                            Text(
                                text = remedy.ingredientsWithWeights.joinToString(" • "),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Slate900
                            )

                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "🥣 निर्माण विधि: ${remedy.preparationMethod}",
                                fontSize = 10.5.sp,
                                color = Slate900
                            )

                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "⏱️ खुराक व समय: ${remedy.dosageAndSchedule}",
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Slate900
                            )

                            if (remedy.warningsAndPrecautions.isNotBlank()) {
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "⚠️ सावधानी: ${remedy.warningsAndPrecautions}",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = RedAlert
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun EmergencySosCard(onCall: () -> Unit) {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(2.dp, RedAlert),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(RedAlertLight)
                    .border(2.dp, RedAlert, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text("🚨", fontSize = 28.sp)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "आपातकालीन पशु चिकित्सा हेल्पलाइन (Emergency SOS)",
                fontSize = 15.sp,
                fontWeight = FontWeight.Black,
                color = RedAlert
            )
            Text(
                text = "हरियाणा पशु सुपर-स्पेशलिटी 24x7 इमरजेंसी कमांड",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Slate900
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onCall,
                colors = ButtonDefaults.buttonColors(containerColor = RedAlert),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .testTag("emergency_sos_call_btn")
            ) {
                Icon(Icons.Default.Phone, contentDescription = null, tint = Color.White)
                Spacer(modifier = Modifier.width(8.dp))
                Text("📞 डॉक्टर से तुरंत बात करें (9991039297)", fontSize = 13.sp, fontWeight = FontWeight.Black, color = Color.White)
            }
        }
    }
}
