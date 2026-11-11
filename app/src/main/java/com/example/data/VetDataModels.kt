package com.example.data

enum class AppLanguage(val code: String, val displayName: String) {
    HINGLISH("hinglish", "Hinglish"),
    HINDI("hi", "हिन्दी"),
    ENGLISH("en", "English"),
    PUNJABI("pa", "ਪੰਜਾਬੀ"),
    MARATHI("mr", "मराठी")
}

enum class UserRole(val title: String) {
    DOCTOR("पशु चिकित्सक (Doctor)"),
    FARMER("पशुपालक (Dairy Farmer)"),
    ADMIN("मास्टर एडमिन (Admin)")
}

enum class ScreenDestination {
    HOME,
    DOCTOR_DIAGNOSIS,
    DOCTOR_OPD_QUEUE,
    DRUGS_DIRECTORY,
    DOSAGE_SAFETY,
    BREEDING_CATALOG,
    FARMER_PASSBOOK,
    FARMER_MILK_CALC,
    FARMER_DESI_NUSKHE,
    EMERGENCY_SOS,
    ADMIN_FINANCIALS,
    ADMIN_PAYOUT,
    ADMIN_USERS,
    ADMIN_CUSTOMIZER
}

enum class Species(val code: String, val hindiName: String, val icon: String) {
    CATTLE("cattle", "गाय (Cattle)", "🐄"),
    BUFFALO("buffalo", "भैंस (Buffalo)", "🐃"),
    GOAT("goat", "बकरी (Goat)", "🐐"),
    SHEEP("sheep", "भेड़ (Sheep)", "🐑"),
    DOG("dog", "कुत्ता (Dog)", "🐕"),
    CAT("cat", "बिल्ली (Cat)", "🐱")
}

enum class PregnancyStatus(val label: String) {
    NON_PREGNANT("🟢 खाली (Non-Pregnant)"),
    PREGNANT("🔴 गर्भवती (Pregnant)"),
    RECENTLY_CALVED("🟡 ताजा ब्याही (Recently Calved)")
}

enum class AnatomicalRegion(val label: String) {
    ALL("समस्त शरीर"),
    HEAD_EYES("सिर, आंख व मुंह"),
    NECK("गला व छाती"),
    ABDOMEN("पेट व कोख"),
    UDDER("थन व अयन"),
    HOOVES("पैर, खुर व त्वचा"),
    FLANK("कोख व पुट्ठा")
}

// 9 Independent Granular Hotspots
enum class AnatomicalHotspot(val id: String, val labelHindi: String, val labelEnglish: String, val icon: String) {
    HEAD("head", "सिर (Head)", "Head & Brain", "🧠"),
    EYES("eyes", "आंख (Eyes)", "Eyes & Vision", "👀"),
    MOUTH_TONGUE("mouth", "मुंह/जीभ (Mouth/Tongue)", "Oral Cavity", "👅"),
    THROAT("throat", "गला (Throat)", "Throat & Pharynx", "🧣"),
    CHEST_RESPIRATION("chest", "सीना/सांस (Chest/Respiration)", "Respiratory System", "🫁"),
    ABDOMEN_RUMEN("rumen", "पेट/कोख (Abdomen/Rumen)", "Rumen & Digestion", "🫄"),
    UDDER_TEATS("udder", "थन/अयन (Udder/Teats)", "Mammary Glands", "🥛"),
    LEGS_HOOVES("hooves", "पैर/खुर (Legs/Hooves)", "Locomotion & Hooves", "🦵"),
    SKIN("skin", "त्वचा (Skin)", "Dermatology & Coat", "🐆");

    val legacyRegion: AnatomicalRegion
        get() = when (this) {
            HEAD, EYES, MOUTH_TONGUE -> AnatomicalRegion.HEAD_EYES
            THROAT, CHEST_RESPIRATION -> AnatomicalRegion.NECK
            ABDOMEN_RUMEN -> AnatomicalRegion.ABDOMEN
            UDDER_TEATS -> AnatomicalRegion.UDDER
            LEGS_HOOVES, SKIN -> AnatomicalRegion.HOOVES
        }
}

// Mutually Exclusive Body Temperature Chips
enum class TemperatureRange(val id: String, val labelHindi: String, val tempFahrenheit: String, val colorHex: Long) {
    NORMAL("normal", "सामान्य (101–102°F)", "101.5°F", 0xFF059669),
    MODERATE_FEVER("moderate", "मध्यम बुखार (103–104.5°F)", "103.8°F", 0xFFD97706),
    HIGH_FEVER("high", "अति-तीव्र बुखार (105–107°F)", "106.2°F", 0xFFDC2626),
    HYPOTHERMIA("cold", "शरीर ठंडा पड़ना (<100°F)", "98.4°F", 0xFF0284C7)
}

data class SymptomItem(
    val id: String,
    val labelHinglish: String,
    val labelHindi: String,
    val labelEnglish: String,
    val labelPunjabi: String,
    val labelMarathi: String,
    val region: AnatomicalRegion,
    val categoryGroup: String
)

data class LabTest(
    val testName: String,
    val sampleType: String,
    val estimatedMrp: Int,
    val clinicalSignificance: String,
    val indicativeResult: String = "पॉजिटिव (Positive)",
    val turnaroundTime: String = "15-30 मिनट"
)

data class InjectionDrug(
    val category: String,
    val genericSalt: String,
    val ethicalBrand: String,
    val genericEquivalent: String,
    val ethicalMrp: Int,
    val genericMrp: Int,
    val dosageRoute: String,
    val pregnancySafe: Boolean,
    val clinicalPurpose: String
)

data class OralMedicine(
    val type: String,
    val saltName: String,
    val ethicalBrand: String,
    val genericEquivalent: String,
    val ethicalMrp: Int,
    val genericMrp: Int,
    val dosageFreq: String,
    val purpose: String
)

data class HerbalMedicine(
    val formulation: String,
    val keyIngredients: String,
    val mrp: Int,
    val dosage: String,
    val benefits: String
)

data class HomeopathicMedicine(
    val medicinePotency: String,
    val mrp: Int,
    val dosage: String,
    val action: String
)

data class DesiRemedy(
    val remedyName: String,
    val ingredients: String,
    val preparationMethod: String,
    val usagePrecautions: String
)

data class BiosecurityMeasure(
    val title: String,
    val instructions: String
)

data class DiseaseDefinition(
    val id: String,
    val scientificName: String,
    val hindiName: String,
    val localDesiNames: String,
    val etiology: String,
    val associatedSymptoms: List<String>,
    val pathognomonicSign: String,
    val labTests: List<LabTest>,
    val pregnancyRedAlert: String?,
    val contraIndicatedDrugs: List<String>,
    val safeAlternativeDrugs: List<String>,
    val injections: List<InjectionDrug>,
    val oralMeds: List<OralMedicine>,
    val herbalMeds: List<HerbalMedicine>,
    val homeopathicMeds: List<HomeopathicMedicine>,
    val desiRemedies: List<DesiRemedy>,
    val biosecurity: List<BiosecurityMeasure>,
    val recoveryMinDays: Int,
    val recoveryMaxDays: Int,
    val redFlagWarnings: List<String>,
    val secondOpinionNote: String
)

data class DiagnosticResult(
    val disease: DiseaseDefinition,
    val matchPercentage: Int,
    val matchedSymptoms: List<String>,
    val cardinalMatched: Boolean,
    val differentialDiagnoses: List<Pair<String, Int>>,
    val pregnancyAlertActive: Boolean
)

data class DrugItem(
    val id: String,
    val saltName: String,
    val ethicalBrand: String,
    val genericEquivalent: String,
    val category: String,
    val ethicalMrp: Int,
    val genericMrp: Int,
    var stockCount: Int,
    val route: String,
    val pregnancySafe: Boolean
) {
    val savingsPercent: Int
        get() = if (ethicalMrp > 0) ((ethicalMrp - genericMrp) * 100) / ethicalMrp else 0
}

data class PashuRecord(
    val tagId: String,
    val ownerName: String,
    val ownerPhone: String,
    val village: String,
    val species: Species,
    val breed: String,
    val ageYears: Double,
    val lactationStage: String,
    val dailyMilkAvgLiters: Double,
    val isPregnant: Boolean,
    val pregnancyMonth: Int,
    val lastVaccine: String,
    val dewormingStatus: String
)

data class MilkEntry(
    val id: String,
    val date: String,
    val shift: String, // Morning / Evening
    val animalTag: String,
    val liters: Double,
    val fatPercent: Double,
    val snfPercent: Double,
    val ratePerLiter: Double,
    val totalEarnings: Double
)

data class BullPedigree(
    val tagId: String,
    val name: String,
    val breed: String,
    val sireDamLineage: String,
    val damPeakLactationKg: Int,
    val damFatPercent: Double,
    val strawStockCount: Int,
    val pricePerStraw: Int,
    val conceptionRatePercent: Int,
    val sourceAgency: String = "HLDB", // HLDB, ABC, NDDB, BAIF
    val species: Species = Species.BUFFALO
)

data class AdminSettings(
    val clinicName: String = "VETCARE AI OS • Animal Super-Speciality Hospital",
    val clinicSubtitle: String = "Govt. Approved Veterinary Healthcare & Dairy Intelligence",
    val logoUrl: String = "",
    val presetPalette: String = "Pristine Hospital White",
    val accountHolder: String = "Dr. Rahul Jangra",
    val bankName: String = "State Bank of India (SBI)",
    val accountNumber: String = "392971812001",
    val ifscCode: String = "SBIN0001812",
    val upiId: String = "9991039297@upi",
    val doctorWeeklyPrice: Int = 199,
    val doctorMonthlyPrice: Int = 599,
    val doctorQuarterlyPrice: Int = 1499,
    val doctorAnnualPrice: Int = 4999,
    val farmerWeeklyPrice: Int = 49,
    val farmerMonthlyPrice: Int = 149,
    val farmerQuarterlyPrice: Int = 399,
    val farmerAnnualPrice: Int = 1199,
    val activePromoCode: String = "HARYANA2026",
    val promoDiscountPercent: Int = 20
)

data class FinancialSummary(
    val grossTotal: Long = 1845600,
    val todayRevenue: Long = 14200,
    val weeklyRevenue: Long = 98500,
    val monthlyRevenue: Long = 385000,
    val yearlyRevenue: Long = 1845600,
    val doctorSubscriptions: Long = 1240000,
    val farmerSubscriptions: Long = 605600
)

data class UserProfile(
    val id: String,
    val name: String,
    val role: UserRole,
    val mobile: String,
    val regOrTagNo: String,
    val clinicOrVillage: String,
    val herdSize: Int = 0,
    val isVciApproved: Boolean = true,
    val isSubscribed: Boolean = true,
    var trialDaysRemaining: Int = 24,
    val subscriptionTier: String = "Pro Diagnostic Plan",
    val subscriptionExpiry: String = "2026-12-31"
)

// Real-Time Veterinary Pharmacopeia Item (Doctor-Exclusive)
data class PharmacopeiaItem(
    val id: String,
    val brandName: String,
    val genericSalt: String,
    val manufacturer: String,
    val therapeuticCategory: String,
    val standardDosagePerKg: String,
    val route: String,
    val indications: String,
    val contraindications: String,
    val pregnancySafety: String,
    val withdrawalPeriod: String,
    val approxMrp: Int,
    val commercialSubstitutes: List<String>
)

// Real-Time Clinical Diagnostic Vision & Lab Report Analyzer Result
data class LabReportAnalysis(
    val id: String,
    val fileName: String,
    val reportType: String,
    val sampleType: String,
    val extractedParameters: Map<String, String>,
    val tentativeDiagnosis: String,
    val clinicalRecommendations: List<String>,
    val criticalAlert: String = "",
    val timestamp: String = "Live Analyzed"
)

// 45 Indigenous NDDB / IVRI Validated Herbal Remedies
data class HerbalRemedy45(
    val id: String,
    val conditionNameHindi: String,
    val conditionNameEnglish: String,
    val anatomicalCategory: String, // UDDER_MILK, ABDOMEN_DUNG, THROAT_CHEST, REPRO_CALVING, SKIN_PARASITES, METABOLIC_GENERAL
    val targetSpecies: String,
    val ingredientsWithWeights: List<String>,
    val preparationMethod: String,
    val dosageAndSchedule: String,
    val warningsAndPrecautions: String
)

enum class ClinicalRiskLevel(val label: String, val badgeColorHex: Long) {
    MILD("हल्का (Mild Risk)", 0xFF10B981),
    MODERATE("मध्यम (Moderate Alert)", 0xFFD97706),
    LIFE_THREATENING_CRITICAL("अति-गंभीर (Critical Life-Threatening)", 0xFFDC2626)
}

data class PatientQueueItem(
    val id: String,
    val tokenNo: String,
    val animalTag: String,
    val species: Species,
    val ownerName: String,
    val ownerPhone: String,
    val primaryComplaint: String,
    val isEmergency: Boolean,
    val waitTimeMin: Int
)

data class AiSecondOpinionEvaluation(
    val riskLevel: ClinicalRiskLevel,
    val primaryDiseaseName: String,
    val differentialMatches: List<Pair<String, Int>>,
    val missingSignsToInvestigate: List<String>,
    val confirmatoryTests: List<LabTest>,
    val ethicalVsGenericSavingsPercent: Int,
    val totalEthicalCost: Int,
    val totalGenericCost: Int,
    val pharmacologicalAdvice: String
)

data class BankAccount(
    val id: String,
    val bankName: String,
    val accountNumberMasked: String,
    val accountNumberFull: String,
    val ifscCode: String,
    val upiId: String,
    val payeeName: String,
    val isPrimary: Boolean
)

data class DrugSubstituteDetail(
    val id: String,
    val saltName: String,
    val brandName: String,
    val company: String,
    val mrp: Int,
    val doseRateMgPerKg: Double,
    val concentrationMgPerMl: Double, // e.g. 100 mg/ml or 10 mg/ml
    val route: String,
    val clinicalUsage: String,
    val pregnancySafe: Boolean,
    val contraindicatedSpecies: List<Species> = emptyList(),
    val speciesSpecialWarning: String = ""
) {
    fun calculateDoseMl(weightKg: Double, species: Species = Species.CATTLE): Double {
        if (contraindicatedSpecies.contains(species)) return 0.0
        if (concentrationMgPerMl <= 0.0) return 0.0
        // Scaled species rate adjustment
        val adjustedRate = when (species) {
            Species.CAT -> doseRateMgPerKg * 0.75 // Pediatric/precision lower rate
            Species.DOG -> doseRateMgPerKg * 0.90
            Species.GOAT, Species.SHEEP -> doseRateMgPerKg * 1.10 // Faster ruminant metabolism
            Species.CATTLE, Species.BUFFALO -> doseRateMgPerKg
        }
        val ml = (weightKg * adjustedRate) / concentrationMgPerMl
        return Math.round(ml * 10.0) / 10.0
    }
}

data class RepeatBreederCause(
    val id: String,
    val title: String,
    val scientificTitle: String,
    val description: String,
    val fieldProtocol: String,
    val recommendedMedicines: List<String>
)

data class FarmerDiseaseItem(
    val id: String,
    val nameHindi: String,
    val nameScientific: String,
    val desiNames: String,
    val rootCauseType: String,
    val clinicalSigns: List<String>,
    val stagesTimeline: List<String>,
    val homeRemedies: List<String>,
    val urgentAction: String,
    val anatomicalCategory: String = "HEAD_NERVOUS" // HEAD_NERVOUS, THROAT_CHEST, ABDOMEN_DUNG, UDDER_MILK, URINARY_REPRO, LEGS_SKIN
)

data class HeatCycleRecord(
    val tagId: String,
    val animalName: String,
    val lastHeatDate: String,
    val aiDate: String?,
    val expectedNextHeatDate: String,
    val pdDueDate: String,
    val expectedCalvingDate: String?,
    val daysUntilCalving: Int?,
    val status: String
)


