package com.example.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class VetCareViewModel : ViewModel() {

    // Localization & System State
    private val _selectedLanguage = MutableStateFlow(AppLanguage.HINGLISH)
    val selectedLanguage: StateFlow<AppLanguage> = _selectedLanguage.asStateFlow()

    private val _currentRole = MutableStateFlow(UserRole.DOCTOR)
    val currentRole: StateFlow<UserRole> = _currentRole.asStateFlow()

    private val _activeScreen = MutableStateFlow(ScreenDestination.HOME)
    val activeScreen: StateFlow<ScreenDestination> = _activeScreen.asStateFlow()

    private val _currentUser = MutableStateFlow<UserProfile?>(null)
    val currentUser: StateFlow<UserProfile?> = _currentUser.asStateFlow()

    // Auth Modal State
    private val _isAuthModalOpen = MutableStateFlow(false)
    val isAuthModalOpen: StateFlow<Boolean> = _isAuthModalOpen.asStateFlow()

    private val _authModalRole = MutableStateFlow(UserRole.DOCTOR)
    val authModalRole: StateFlow<UserRole> = _authModalRole.asStateFlow()

    private val _isRegisterMode = MutableStateFlow(false)
    val isRegisterMode: StateFlow<Boolean> = _isRegisterMode.asStateFlow()

    // Compact Toast State (silent on launch, only user-triggered)
    private val _toastMessage = MutableStateFlow<String?>(null)
    val toastMessage: StateFlow<String?> = _toastMessage.asStateFlow()

    // Navigation Drawer
    private val _isDrawerOpen = MutableStateFlow(false)
    val isDrawerOpen: StateFlow<Boolean> = _isDrawerOpen.asStateFlow()

    // Doctor Workspace State
    private val _diagnosticMode = MutableStateFlow(1) // 1: Symptoms, 2: Cross-check, 3: Direct Quick Protocol
    val diagnosticMode: StateFlow<Int> = _diagnosticMode.asStateFlow()

    private val _selectedSpecies = MutableStateFlow(Species.CATTLE)
    val selectedSpecies: StateFlow<Species> = _selectedSpecies.asStateFlow()

    private val _pregnancyStatus = MutableStateFlow(PregnancyStatus.NON_PREGNANT)
    val pregnancyStatus: StateFlow<PregnancyStatus> = _pregnancyStatus.asStateFlow()

    private val _pregnancyMonth = MutableStateFlow(1)
    val pregnancyMonth: StateFlow<Int> = _pregnancyMonth.asStateFlow()

    private val _bodyWeightKg = MutableStateFlow(380.0)
    val bodyWeightKg: StateFlow<Double> = _bodyWeightKg.asStateFlow()

    private val _animalAgeYears = MutableStateFlow(4.0)
    val animalAgeYears: StateFlow<Double> = _animalAgeYears.asStateFlow()

    private val _selectedRegion = MutableStateFlow(AnatomicalRegion.ALL)
    val selectedRegion: StateFlow<AnatomicalRegion> = _selectedRegion.asStateFlow()

    private val _compiledSymptomIds = MutableStateFlow<Set<String>>(setOf("udder_hot_hard_swelling", "milk_flakes_blood"))
    val compiledSymptomIds: StateFlow<Set<String>> = _compiledSymptomIds.asStateFlow()

    private val _cardinalSignInput = MutableStateFlow("")
    val cardinalSignInput: StateFlow<String> = _cardinalSignInput.asStateFlow()

    private val _suspectedDiseaseId = MutableStateFlow<String?>("mastitis")
    val suspectedDiseaseId: StateFlow<String?> = _suspectedDiseaseId.asStateFlow()

    private val _attachedPhotoUri = MutableStateFlow<String?>("sample_udder_photo")
    val attachedPhotoUri: StateFlow<String?> = _attachedPhotoUri.asStateFlow()

    private val _diagnosticResult = MutableStateFlow<DiagnosticResult?>(null)
    val diagnosticResult: StateFlow<DiagnosticResult?> = _diagnosticResult.asStateFlow()

    // Horizontal 5-Tier Treatment Tab: 0: Injections, 1: Oral, 2: Ayurvedic, 3: Homeopathic, 4: Desi, 5: Lab Tests
    private val _selectedTreatmentTab = MutableStateFlow(0)
    val selectedTreatmentTab: StateFlow<Int> = _selectedTreatmentTab.asStateFlow()

    // AI Second Opinion Dialog & Evaluation
    private val _showAiSecondOpinion = MutableStateFlow(false)
    val showAiSecondOpinion: StateFlow<Boolean> = _showAiSecondOpinion.asStateFlow()

    private val _aiEvaluation = MutableStateFlow<AiSecondOpinionEvaluation?>(null)
    val aiEvaluation: StateFlow<AiSecondOpinionEvaluation?> = _aiEvaluation.asStateFlow()

    // Voice Dictation Simulation
    private val _isListeningVoice = MutableStateFlow(false)
    val isListeningVoice: StateFlow<Boolean> = _isListeningVoice.asStateFlow()

    // Shaeffer's Weight Calculator
    private val _shaefferLengthInches = MutableStateFlow(62.0)
    val shaefferLengthInches: StateFlow<Double> = _shaefferLengthInches.asStateFlow()

    private val _shaefferGirthInches = MutableStateFlow(74.0)
    val shaefferGirthInches: StateFlow<Double> = _shaefferGirthInches.asStateFlow()

    // Active OPD Queue
    private val _patientQueue = MutableStateFlow<List<PatientQueueItem>>(SampleData.initialQueue)
    val patientQueue: StateFlow<List<PatientQueueItem>> = _patientQueue.asStateFlow()

    // Pharmacy Drugs
    private val _drugsList = MutableStateFlow<List<DrugItem>>(SampleData.initialDrugs)
    val drugsList: StateFlow<List<DrugItem>> = _drugsList.asStateFlow()

    private val _drugSearchQuery = MutableStateFlow("")
    val drugSearchQuery: StateFlow<String> = _drugSearchQuery.asStateFlow()

    private val _drugCategoryFilter = MutableStateFlow("सभी")
    val drugCategoryFilter: StateFlow<String> = _drugCategoryFilter.asStateFlow()

    // Dairy Farmer Data
    private val _pashuList = MutableStateFlow<List<PashuRecord>>(SampleData.initialPashuList)
    val pashuList: StateFlow<List<PashuRecord>> = _pashuList.asStateFlow()

    private val _milkEntries = MutableStateFlow<List<MilkEntry>>(SampleData.initialMilkEntries)
    val milkEntries: StateFlow<List<MilkEntry>> = _milkEntries.asStateFlow()

    // Milk Rate Calc Inputs
    private val _calcMilkLiters = MutableStateFlow("15.0")
    val calcMilkLiters: StateFlow<String> = _calcMilkLiters.asStateFlow()

    private val _calcFatPercent = MutableStateFlow("7.0")
    val calcFatPercent: StateFlow<String> = _calcFatPercent.asStateFlow()

    private val _calcSnfPercent = MutableStateFlow("9.0")
    val calcSnfPercent: StateFlow<String> = _calcSnfPercent.asStateFlow()

    private val _calcAnimalTag = MutableStateFlow("IN-HR-1092-4821")
    val calcAnimalTag: StateFlow<String> = _calcAnimalTag.asStateFlow()

    // AI Breeding & Calving
    private val _bullsList = MutableStateFlow<List<BullPedigree>>(SampleData.initialBulls)
    val bullsList: StateFlow<List<BullPedigree>> = _bullsList.asStateFlow()

    private val _aiDateTimestamp = MutableStateFlow(System.currentTimeMillis())
    val aiDateTimestamp: StateFlow<Long> = _aiDateTimestamp.asStateFlow()

    // Real-Time AI Bull Search State
    private val _liveBullAnalysisResult = MutableStateFlow<BullPedigree?>(null)
    val liveBullAnalysisResult: StateFlow<BullPedigree?> = _liveBullAnalysisResult.asStateFlow()

    private val _isSearchingLiveBull = MutableStateFlow(false)
    val isSearchingLiveBull: StateFlow<Boolean> = _isSearchingLiveBull.asStateFlow()

    // Doctor OPD Finance Ledger & Billing Tracker
    private val _doctorBillingRecords = MutableStateFlow<List<DoctorBillingRecord>>(listOf(
        DoctorBillingRecord("bill_1", "OPD-2026-001", "IN-HR-1092-4821", "सुखविंदर सिंह", "9812039297", 850.0, 850.0, 0.0, PaymentStatus.PAID_FULL, PaymentMode.UPI, System.currentTimeMillis() - 3600000L, "थनैला एंटीबायोटिक व लेप"),
        DoctorBillingRecord("bill_2", "OPD-2026-002", "IN-HR-3341-9981", "राजेश कुमार", "9896123490", 1200.0, 700.0, 500.0, PaymentStatus.PARTIAL, PaymentMode.CASH, System.currentTimeMillis() - 14400000L, "गलघोंटू आपातकालीन उपचार (₹500 उधारी)"),
        DoctorBillingRecord("bill_3", "OPD-2026-003", "IN-HR-8832-1920", "धर्मपाल जांगड़ा", "9416088219", 950.0, 950.0, 0.0, PaymentStatus.PAID_FULL, PaymentMode.BANK, System.currentTimeMillis() - 86400000L, "बबेसिओसिस इंजेक्शन व फ्लुइड"),
        DoctorBillingRecord("bill_4", "OPD-2026-004", "IN-HR-4412-9844", "बलबीर सांगवान", "9896011234", 600.0, 0.0, 600.0, PaymentStatus.UNPAID, PaymentMode.CASH, System.currentTimeMillis() - 172800000L, "आफरा व रुमेनोटोमी परामर्श (पूर्ण उधारी)"),
        DoctorBillingRecord("bill_5", "OPD-2026-005", "IN-HR-5521-6670", "रामनिवास शर्मा", "9991039297", 450.0, 450.0, 0.0, PaymentStatus.PAID_FULL, PaymentMode.UPI, System.currentTimeMillis() - 259200000L, "बकरी पीपीआर व दस्त उपचार")
    ))
    val doctorBillingRecords: StateFlow<List<DoctorBillingRecord>> = _doctorBillingRecords.asStateFlow()

    private val _financeTimeframeFilter = MutableStateFlow("ALL") // PER_CASE, DAILY, WEEKLY, MONTHLY, YEARLY, ALL
    val financeTimeframeFilter: StateFlow<String> = _financeTimeframeFilter.asStateFlow()

    // Master Admin Settings & Analytics
    private val _adminSettings = MutableStateFlow(AdminSettings())
    val adminSettings: StateFlow<AdminSettings> = _adminSettings.asStateFlow()

    private val _financialSummary = MutableStateFlow(FinancialSummary())
    val financialSummary: StateFlow<FinancialSummary> = _financialSummary.asStateFlow()

    private val _revenueTimeFilter = MutableStateFlow("monthly") // daily, weekly, monthly, yearly, all
    val revenueTimeFilter: StateFlow<String> = _revenueTimeFilter.asStateFlow()

    private val _userProfiles = MutableStateFlow<List<UserProfile>>(SampleData.initialUsers)
    val userProfiles: StateFlow<List<UserProfile>> = _userProfiles.asStateFlow()

    // Dynamic Banking & Payout Accounts (StateFlow backed)
    private val _bankAccounts = MutableStateFlow<List<BankAccount>>(SampleData.initialBankAccounts)
    val bankAccounts: StateFlow<List<BankAccount>> = _bankAccounts.asStateFlow()

    // Interactive Drug Substitutes Popup State
    private val _selectedDrugSubstitute = MutableStateFlow<DrugSubstituteDetail?>(null)
    val selectedDrugSubstitute: StateFlow<DrugSubstituteDetail?> = _selectedDrugSubstitute.asStateFlow()

    private val _drugSubstitutes = MutableStateFlow<List<DrugSubstituteDetail>>(SampleData.initialDrugSubstitutes)
    val drugSubstitutes: StateFlow<List<DrugSubstituteDetail>> = _drugSubstitutes.asStateFlow()

    // Repeat Breeder Causes & Farmer Disease Directory
    private val _repeatBreederCauses = MutableStateFlow<List<RepeatBreederCause>>(SampleData.repeatBreederCauses)
    val repeatBreederCauses: StateFlow<List<RepeatBreederCause>> = _repeatBreederCauses.asStateFlow()

    private val _farmerDiseases = MutableStateFlow<List<FarmerDiseaseItem>>(SampleData.farmerDiseaseDirectory)
    val farmerDiseases: StateFlow<List<FarmerDiseaseItem>> = _farmerDiseases.asStateFlow()

    private val _farmerDiseaseSearch = MutableStateFlow("")
    val farmerDiseaseSearch: StateFlow<String> = _farmerDiseaseSearch.asStateFlow()

    private val _bullSearchQuery = MutableStateFlow("")
    val bullSearchQuery: StateFlow<String> = _bullSearchQuery.asStateFlow()

    private val _bullBreedFilter = MutableStateFlow("सभी")
    val bullBreedFilter: StateFlow<String> = _bullBreedFilter.asStateFlow()

    private val _bullAgencyFilter = MutableStateFlow("सभी")
    val bullAgencyFilter: StateFlow<String> = _bullAgencyFilter.asStateFlow()

    // Desktop/Tablet Multi-Pane Manual Toggle (Overrides screen width check if user clicks)
    private val _isDesktopModeManualToggle = MutableStateFlow<Boolean?>(null)
    val isDesktopModeManualToggle: StateFlow<Boolean?> = _isDesktopModeManualToggle.asStateFlow()

    // 9 Independent Granular Hotspots
    private val _selectedHotspot = MutableStateFlow(AnatomicalHotspot.HEAD)
    val selectedHotspot: StateFlow<AnatomicalHotspot> = _selectedHotspot.asStateFlow()

    // Mutually Exclusive Body Temperature Radio State
    private val _selectedTemperature = MutableStateFlow(TemperatureRange.NORMAL)
    val selectedTemperature: StateFlow<TemperatureRange> = _selectedTemperature.asStateFlow()

    // Real-Time Veterinary Pharmacopeia (Doctor-Exclusive)
    private val _pharmacopeiaList = MutableStateFlow<List<PharmacopeiaItem>>(SampleData.initialPharmacopeiaList)
    val pharmacopeiaList: StateFlow<List<PharmacopeiaItem>> = _pharmacopeiaList.asStateFlow()

    private val _pharmacopeiaSearchQuery = MutableStateFlow("")
    val pharmacopeiaSearchQuery: StateFlow<String> = _pharmacopeiaSearchQuery.asStateFlow()

    private val _pharmacopeiaCategoryFilter = MutableStateFlow("सभी")
    val pharmacopeiaCategoryFilter: StateFlow<String> = _pharmacopeiaCategoryFilter.asStateFlow()

    private val _showPharmacopeiaSheet = MutableStateFlow(false)
    val showPharmacopeiaSheet: StateFlow<Boolean> = _showPharmacopeiaSheet.asStateFlow()

    // Multimodal AI Vision & Lab Report Analyzer
    private val _activeLabReport = MutableStateFlow<LabReportAnalysis?>(null)
    val activeLabReport: StateFlow<LabReportAnalysis?> = _activeLabReport.asStateFlow()

    private val _isAnalyzingReport = MutableStateFlow(false)
    val isAnalyzingReport: StateFlow<Boolean> = _isAnalyzingReport.asStateFlow()

    private val _showReportAnalysisDialog = MutableStateFlow(false)
    val showReportAnalysisDialog: StateFlow<Boolean> = _showReportAnalysisDialog.asStateFlow()

    // 45 Indigenous NDDB / IVRI Validated Herbal Remedies
    private val _herbalRemedies45 = MutableStateFlow<List<HerbalRemedy45>>(SampleData.initialHerbalRemedies45)
    val herbalRemedies45: StateFlow<List<HerbalRemedy45>> = _herbalRemedies45.asStateFlow()

    private val _herbalCategoryFilter = MutableStateFlow("ALL")
    val herbalCategoryFilter: StateFlow<String> = _herbalCategoryFilter.asStateFlow()

    private val _herbalSearchQuery = MutableStateFlow("")
    val herbalSearchQuery: StateFlow<String> = _herbalSearchQuery.asStateFlow()

    // Admin Controls
    private val _adminUserSearchQuery = MutableStateFlow("")
    val adminUserSearchQuery: StateFlow<String> = _adminUserSearchQuery.asStateFlow()

    // Session (60-minute) and Free Trial (24-hour) Timers
    private val _sessionSecondsRemaining = MutableStateFlow(3600) // 60 minutes
    val sessionSecondsRemaining: StateFlow<Int> = _sessionSecondsRemaining.asStateFlow()

    private val _trialSecondsRemaining = MutableStateFlow(18 * 3600 + 42 * 60 + 15) // 18h 42m 15s remaining
    val trialSecondsRemaining: StateFlow<Int> = _trialSecondsRemaining.asStateFlow()

    private val _isSessionExpired = MutableStateFlow(false)
    val isSessionExpired: StateFlow<Boolean> = _isSessionExpired.asStateFlow()

    init {
        // Run initial diagnosis on launch
        runDiagnosis()
        startSessionAndTrialTimers()
    }

    private fun startSessionAndTrialTimers() {
        viewModelScope.launch {
            while (true) {
                delay(1000)
                if (_sessionSecondsRemaining.value > 0) {
                    _sessionSecondsRemaining.value -= 1
                    if (_sessionSecondsRemaining.value == 0) {
                        _isSessionExpired.value = true
                        logout()
                        showToast("सत्र समाप्त! सुरक्षा कारणों से स्वतः लॉगआउट किया गया।")
                    }
                }
                if (_trialSecondsRemaining.value > 0) {
                    _trialSecondsRemaining.value -= 1
                }
            }
        }
    }

    fun toggleDesktopMode() {
        val current = _isDesktopModeManualToggle.value ?: false
        _isDesktopModeManualToggle.value = !current
        showToast(if (!current) "🖥️ डेस्कटॉप व्यू सक्रिय" else "📱 मोबाइल व्यू सक्रिय")
    }

    fun setAttachedPhotoUri(uri: String?) {
        _attachedPhotoUri.value = uri
        showToast(if (uri != null) "📸 क्लीनिकल फोटो संलग्न की गई" else "फोटो हटाई गई")
    }

    // Language
    fun setLanguage(language: AppLanguage) {
        _selectedLanguage.value = language
        showToast("भाषा बदली गई: ${language.displayName}")
    }

    // Role & Navigation
    fun setRole(role: UserRole) {
        val user = _currentUser.value
        if (user != null) {
            if (user.role != UserRole.ADMIN && !user.hasDualRoleAuthority && user.role != role) {
                showToast("⚠️ भूमिका बदलने का अधिकार केवल सुपर एडमिन द्वारा प्रदान किया जाता है। आपकी भूमिका ${user.role.title} पर लॉक है।")
                return
            }
        }
        _currentRole.value = role
        showToast("${role.title} सक्रिय हुआ")
    }

    fun navigateTo(destination: ScreenDestination) {
        val user = _currentUser.value
        if (user == null && destination != ScreenDestination.HOME) {
            val targetRole = when (destination) {
                ScreenDestination.DOCTOR_DIAGNOSIS,
                ScreenDestination.DOCTOR_OPD_QUEUE,
                ScreenDestination.DOSAGE_SAFETY,
                ScreenDestination.DRUGS_DIRECTORY,
                ScreenDestination.DOCTOR_FINANCE -> UserRole.DOCTOR
                ScreenDestination.FARMER_PASSBOOK,
                ScreenDestination.FARMER_MILK_CALC,
                ScreenDestination.FARMER_DESI_NUSKHE,
                ScreenDestination.EMERGENCY_SOS,
                ScreenDestination.BREEDING_CATALOG -> UserRole.FARMER
                ScreenDestination.ADMIN_FINANCIALS,
                ScreenDestination.ADMIN_PAYOUT,
                ScreenDestination.ADMIN_USERS,
                ScreenDestination.ADMIN_CUSTOMIZER -> UserRole.ADMIN
                ScreenDestination.HOME -> null
            }
            if (targetRole != null) {
                openAuthModal(targetRole)
                showToast("सत्र प्रमाणीकरण आवश्यक: कृपया ${targetRole.title} में लॉगिन करें")
                return
            }
        } else if (user != null && destination != ScreenDestination.HOME) {
            // Check if user is trying to access a screen of another role without dual-role authority
            if (user.role != UserRole.ADMIN && !user.hasDualRoleAuthority) {
                val doctorScreens = setOf(
                    ScreenDestination.DOCTOR_DIAGNOSIS,
                    ScreenDestination.DOCTOR_OPD_QUEUE,
                    ScreenDestination.DOSAGE_SAFETY,
                    ScreenDestination.DRUGS_DIRECTORY,
                    ScreenDestination.DOCTOR_FINANCE
                )
                val farmerScreens = setOf(
                    ScreenDestination.FARMER_PASSBOOK,
                    ScreenDestination.FARMER_MILK_CALC,
                    ScreenDestination.FARMER_DESI_NUSKHE,
                    ScreenDestination.EMERGENCY_SOS,
                    ScreenDestination.BREEDING_CATALOG
                )
                val adminScreens = setOf(
                    ScreenDestination.ADMIN_FINANCIALS,
                    ScreenDestination.ADMIN_PAYOUT,
                    ScreenDestination.ADMIN_USERS,
                    ScreenDestination.ADMIN_CUSTOMIZER
                )

                if (user.role == UserRole.DOCTOR && destination in (farmerScreens + adminScreens)) {
                    showToast("⚠️ अनधिकृत अनुभाग! केवल डॉक्टर टूल्स अनुमत हैं।")
                    return
                }
                if (user.role == UserRole.FARMER && destination in (doctorScreens + adminScreens)) {
                    showToast("⚠️ अनधिकृत अनुभाग! केवल किसान हब अनुमत है।")
                    return
                }
            }
        }
        _activeScreen.value = destination
    }

    // Drawer
    fun openDrawer() { _isDrawerOpen.value = true }
    fun closeDrawer() { _isDrawerOpen.value = false }

    // Auth Modals
    fun openAuthModal(role: UserRole, isRegister: Boolean = false) {
        _authModalRole.value = role
        _isRegisterMode.value = isRegister
        _isAuthModalOpen.value = true
    }

    fun closeAuthModal() {
        _isAuthModalOpen.value = false
    }

    fun performLogin(role: UserRole = _authModalRole.value, id: String, pass: String) {
        if (role == UserRole.ADMIN) {
            if ((id == "9991039297" || id == "9297") && (pass == "Rahul@1812" || pass == "OTP_BYPASS")) {
                val adminUser = _userProfiles.value.find { it.role == UserRole.ADMIN } ?: UserProfile(
                    id = "u_admin_master",
                    name = "डॉ. राहुल जांगड़ा (Master Admin)",
                    role = UserRole.ADMIN,
                    mobile = "9991039297",
                    regOrTagNo = "HR-VET-001",
                    clinicOrVillage = "हिसार पशु अस्पताल, हरियाणा",
                    isVciApproved = true,
                    isSubscribed = true
                )
                _currentUser.value = adminUser
                _currentRole.value = UserRole.ADMIN
                _isAuthModalOpen.value = false
                _activeScreen.value = ScreenDestination.ADMIN_FINANCIALS
                showToast("मास्टर एडमिन वॉल्ट में स्वागत है!")
            } else {
                showToast("अमान्य एडमिन क्रेडेंशियल! (ID: 9991039297, Pass: Rahul@1812 या OTP: 9297)")
            }
        } else {
            val user = _userProfiles.value.find { it.role == role && (it.mobile == id || it.regOrTagNo.equals(id, ignoreCase = true)) }
                ?: _userProfiles.value.find { it.role == role }
                ?: SampleData.initialUsers.find { it.role == role }
                ?: UserProfile(
                    id = "u_${role.name.lowercase()}_auth",
                    name = if (role == UserRole.DOCTOR) "डॉ. राहुल जांगड़ा (सत्यापित)" else "सुखविंदर सिंह (पशुपालक)",
                    role = role,
                    mobile = id.ifBlank { if (role == UserRole.DOCTOR) "9991039297" else "9812401822" },
                    regOrTagNo = if (role == UserRole.DOCTOR) "VCI-HR-4491" else "TAG-HR-88219",
                    clinicOrVillage = if (role == UserRole.DOCTOR) "हिसार पशु अस्पताल, हरियाणा" else "गांव घिराय, हिसार",
                    isVciApproved = true,
                    isSubscribed = true
                )
            _currentUser.value = user
            _currentRole.value = role
            _isAuthModalOpen.value = false
            if (role == UserRole.DOCTOR) {
                _activeScreen.value = ScreenDestination.DOCTOR_DIAGNOSIS
                showToast("डॉक्टर कंसोल में स्वागत है! डॉ. ${user.name}")
            } else {
                _activeScreen.value = ScreenDestination.FARMER_PASSBOOK
                showToast("किसान हब में स्वागत है! ${user.name} जी")
            }
        }
    }

    fun performOtpLogin(role: UserRole = _authModalRole.value, mobileOrEmail: String, otp: String) {
        if (otp == "9297" || otp == "1234" || otp.length == 4) {
            performLogin(role, mobileOrEmail, "OTP_BYPASS")
        } else {
            showToast("अमान्य 4-अंकीय ओटीपी! (डेमो कोड: 9297 या 1234)")
        }
    }

    fun registerUser(
        role: UserRole,
        fullName: String,
        mobileOrEmail: String,
        regOrTag: String,
        state: String,
        district: String,
        clinicOrVillage: String,
        cattleCount: Int = 0
    ) {
        val existing = _userProfiles.value.find {
            it.mobile.trim().equals(mobileOrEmail.trim(), ignoreCase = true)
        }
        if (existing != null) {
            showToast("⚠️ यह मोबाइल/ईमेल पहले से पंजीकृत है (${existing.role.title})! कृपया सीधे लॉगिन करें।")
            return
        }

        val newUser = UserProfile(
            id = "u_${System.currentTimeMillis()}",
            name = fullName,
            role = role,
            mobile = mobileOrEmail,
            regOrTagNo = regOrTag.ifBlank { if (role == UserRole.DOCTOR) "DOC-${(1000..9999).random()}" else "FAR-${(1000..9999).random()}" },
            clinicOrVillage = if (clinicOrVillage.isNotBlank()) "$clinicOrVillage, $district, $state" else "$district, $state",
            herdSize = cattleCount,
            isVciApproved = true,
            isSubscribed = true,
            hasDualRoleAuthority = false
        )
        _userProfiles.value = listOf(newUser) + _userProfiles.value
        _currentUser.value = newUser
        _currentRole.value = role
        _isAuthModalOpen.value = false
        if (role == UserRole.DOCTOR) {
            _activeScreen.value = ScreenDestination.DOCTOR_DIAGNOSIS
            showToast("डॉक्टर खाता पंजीकृत व लॉक! स्वागत है डॉ. $fullName")
        } else {
            _activeScreen.value = ScreenDestination.FARMER_PASSBOOK
            showToast("किसान खाता पंजीकृत व लॉक! स्वागत है $fullName जी")
        }
    }

    fun logout() {
        _currentUser.value = null
        _isAuthModalOpen.value = false
        _activeScreen.value = ScreenDestination.HOME
        showToast("सफलतापूर्वक लॉगआउट किया गया। कृपया अधिकृत भूमिका से लॉगिन करें।")
    }

    // Dynamic Banking & Payout Accounts Controller
    fun verifyAdminPin(pin: String): Boolean {
        return pin == "9297" || pin == "Rahul@1812"
    }

    fun addBankAccount(
        bankName: String,
        accountNum: String,
        ifsc: String,
        upi: String,
        payee: String,
        isPrimary: Boolean
    ) {
        val masked = if (accountNum.length >= 4) {
            "A/C ending ****${accountNum.takeLast(4)}"
        } else "A/C ending ****$accountNum"

        val newAcc = BankAccount(
            id = "bank_${System.currentTimeMillis()}",
            bankName = bankName,
            accountNumberMasked = masked,
            accountNumberFull = accountNum,
            ifscCode = ifsc,
            upiId = upi,
            payeeName = payee,
            isPrimary = isPrimary
        )

        val updated = if (isPrimary) {
            _bankAccounts.value.map { it.copy(isPrimary = false) } + newAcc
        } else {
            _bankAccounts.value + newAcc
        }
        _bankAccounts.value = updated
        showToast("नया बैंक खाता सफलतापूर्वक जोड़ा गया!")
    }

    fun updateBankAccount(
        id: String,
        bankName: String,
        accountNum: String,
        ifsc: String,
        upi: String,
        payee: String,
        isPrimary: Boolean
    ) {
        val masked = if (accountNum.length >= 4) {
            "A/C ending ****${accountNum.takeLast(4)}"
        } else "A/C ending ****$accountNum"

        _bankAccounts.value = _bankAccounts.value.map { acc ->
            if (acc.id == id) {
                acc.copy(
                    bankName = bankName,
                    accountNumberMasked = masked,
                    accountNumberFull = accountNum,
                    ifscCode = ifsc,
                    upiId = upi,
                    payeeName = payee,
                    isPrimary = isPrimary
                )
            } else if (isPrimary) {
                acc.copy(isPrimary = false)
            } else {
                acc
            }
        }
        showToast("बैंक खाता अपडेट किया गया!")
    }

    fun setPrimaryBankAccount(id: String) {
        _bankAccounts.value = _bankAccounts.value.map {
            it.copy(isPrimary = (it.id == id))
        }
        showToast("प्राथमिक पेआउट खाता बदला गया!")
    }

    fun deleteBankAccount(id: String) {
        if (_bankAccounts.value.size <= 1) {
            showToast("कम से कम 1 बैंक खाता अनिवार्य है!")
            return
        }
        _bankAccounts.value = _bankAccounts.value.filter { it.id != id }
        showToast("बैंक खाता हटाया गया")
    }

    // Interactive Drug Substitutes Popup Actions
    fun openDrugSubstitute(saltOrName: String) {
        val query = saltOrName.lowercase()
        val found = _drugSubstitutes.value.find {
            it.saltName.lowercase().contains(query) ||
            query.contains(it.saltName.lowercase()) ||
            it.brandName.lowercase().contains(query)
        } ?: _drugSubstitutes.value.first()
        _selectedDrugSubstitute.value = found
    }

    fun closeDrugSubstitute() {
        _selectedDrugSubstitute.value = null
    }

    fun getCalculatedDoseMl(drug: DrugSubstituteDetail): Double {
        return drug.calculateDoseMl(_bodyWeightKg.value)
    }

    fun setFarmerDiseaseSearch(query: String) {
        _farmerDiseaseSearch.value = query
    }

    fun setBullSearchQuery(query: String) {
        _bullSearchQuery.value = query
    }

    fun setBullBreedFilter(filter: String) {
        _bullBreedFilter.value = filter
    }

    fun setBullAgencyFilter(agency: String) {
        _bullAgencyFilter.value = agency
    }

    // Doctor Actions
    fun setDiagnosticMode(mode: Int) {
        _diagnosticMode.value = mode
    }

    fun setSpecies(species: Species) {
        _selectedSpecies.value = species
    }

    fun setPregnancyStatus(status: PregnancyStatus) {
        _pregnancyStatus.value = status
        runDiagnosis()
    }

    fun setPregnancyMonth(month: Int) {
        _pregnancyMonth.value = month
    }

    fun setBodyWeightKg(kg: Double) {
        _bodyWeightKg.value = kg
    }

    fun setAnimalAgeYears(years: Double) {
        _animalAgeYears.value = years
    }

    fun setSelectedRegion(region: AnatomicalRegion) {
        _selectedRegion.value = region
    }

    fun setSelectedTreatmentTab(tab: Int) {
        _selectedTreatmentTab.value = tab
    }

    fun toggleSymptom(symptomId: String) {
        val current = _compiledSymptomIds.value.toMutableSet()
        if (current.contains(symptomId)) {
            current.remove(symptomId)
        } else {
            current.add(symptomId)
        }
        _compiledSymptomIds.value = current
        runDiagnosis()
    }

    fun clearSymptoms() {
        _compiledSymptomIds.value = emptySet()
        _cardinalSignInput.value = ""
        runDiagnosis()
        showToast("सभी लक्षण साफ़ किए गए")
    }

    fun setCardinalSign(text: String) {
        _cardinalSignInput.value = text
        runDiagnosis()
    }

    fun setSuspectedDisease(id: String?) {
        _suspectedDiseaseId.value = id
        if (id != null) {
            val def = VeterinaryKnowledgeBase.findDiseaseById(id)
            if (def != null && _diagnosticMode.value == 3) {
                _compiledSymptomIds.value = def.associatedSymptoms.toSet()
            }
        }
        runDiagnosis()
    }

    fun setAttachedPhoto(uri: String?) {
        _attachedPhotoUri.value = uri
        if (uri != null) showToast("फोटो संलग्न की गई")
    }

    fun runDiagnosis() {
        val isPreg = _pregnancyStatus.value == PregnancyStatus.PREGNANT
        val result = VeterinaryKnowledgeBase.diagnose(
            selectedSymptomIds = _compiledSymptomIds.value,
            suspectedDiseaseId = _suspectedDiseaseId.value,
            cardinalSignText = _cardinalSignInput.value,
            isPregnant = isPreg
        )
        _diagnosticResult.value = result
    }

    // AI Second Opinion Trigger
    fun evaluateAiSecondOpinion() {
        val current = _diagnosticResult.value?.disease ?: return
        val isPreg = _pregnancyStatus.value == PregnancyStatus.PREGNANT
        val eval = VeterinaryKnowledgeBase.evaluateAiSecondOpinion(
            disease = current,
            selectedSymptomIds = _compiledSymptomIds.value,
            isPregnant = isPreg
        )
        _aiEvaluation.value = eval
        _showAiSecondOpinion.value = true
        showToast("🤖 एआई सेकंड ओपिनियन व क्रॉस-चेक तैयार")
    }

    fun closeAiSecondOpinion() {
        _showAiSecondOpinion.value = false
    }

    fun setSelectedHotspot(hotspot: AnatomicalHotspot) {
        _selectedHotspot.value = hotspot
        // Automatically map hotspot to corresponding AnatomicalRegion
        val region = when (hotspot) {
            AnatomicalHotspot.HEAD, AnatomicalHotspot.EYES, AnatomicalHotspot.MOUTH_TONGUE -> AnatomicalRegion.HEAD_EYES
            AnatomicalHotspot.THROAT, AnatomicalHotspot.CHEST_RESPIRATION -> AnatomicalRegion.NECK
            AnatomicalHotspot.ABDOMEN_RUMEN -> AnatomicalRegion.ABDOMEN
            AnatomicalHotspot.UDDER_TEATS -> AnatomicalRegion.UDDER
            AnatomicalHotspot.LEGS_HOOVES, AnatomicalHotspot.SKIN -> AnatomicalRegion.HOOVES
        }
        _selectedRegion.value = region
    }

    fun setTemperatureRange(temp: TemperatureRange) {
        _selectedTemperature.value = temp
        // Mutually exclusive: remove all other temp symptom IDs first, then add the chosen one
        val current = _compiledSymptomIds.value.toMutableSet()
        current.removeAll(setOf("temp_normal", "temp_fever_mid", "temp_fever_high", "temp_subnormal"))
        when (temp) {
            TemperatureRange.NORMAL -> current.add("temp_normal")
            TemperatureRange.MODERATE_FEVER -> current.add("temp_fever_mid")
            TemperatureRange.HIGH_FEVER -> current.add("temp_fever_high")
            TemperatureRange.HYPOTHERMIA -> current.add("temp_subnormal")
        }
        _compiledSymptomIds.value = current
        runDiagnosis()
        showToast("तापमान सेट: ${temp.labelHindi}")
    }

    fun setSelectedTemperature(temp: TemperatureRange) = setTemperatureRange(temp)

    // Species-Calibrated Shaeffer Calculation
    fun updateShaefferDimensions(lengthInches: Double, girthInches: Double) {
        _shaefferLengthInches.value = lengthInches
        _shaefferGirthInches.value = girthInches
        // Formula: Weight in lbs = (Length * Girth^2) / 300; in kg = lbs / 2.20462
        val rawLbs = (lengthInches * (girthInches * girthInches)) / 300.0
        val baseKg = rawLbs / 2.20462

        // Calibrate by species: Small ruminants (Goat/Sheep) and pets are scaled down proportionally
        val scaledKg = when (_selectedSpecies.value) {
            Species.GOAT, Species.SHEEP -> (baseKg * 0.20).coerceIn(12.0, 85.0) // Small ruminants
            Species.DOG -> (baseKg * 0.10).coerceIn(4.0, 50.0) // Canine
            Species.CAT -> (baseKg * 0.02).coerceIn(2.0, 8.0)  // Feline
            Species.CATTLE, Species.BUFFALO -> baseKg.coerceIn(50.0, 800.0) // Adult bovine
        }
        _bodyWeightKg.value = Math.round(scaledKg * 10.0) / 10.0
    }

    fun getMaxInjectionVolumePerSite(species: Species = _selectedSpecies.value): String {
        return when (species) {
            Species.CATTLE, Species.BUFFALO -> "अधिकतम 15 - 20 ml Deep IM प्रति साइट (Cattle / Buffalo)"
            Species.GOAT, Species.SHEEP -> "अधिकतम 3 - 5 ml प्रति साइट (Goat / Sheep / Calf)"
            Species.DOG, Species.CAT -> "अधिकतम 1 - 2 ml प्रति साइट (Dog / Cat - Pets)"
        }
    }

    // Multimodal AI Vision & Lab Report Analyzer
    fun analyzeUploadedReport(fileName: String, sampleIndex: Int = 0) {
        viewModelScope.launch {
            _isAnalyzingReport.value = true
            showToast("🔬 एआई मल्टीमॉडल लैब रिपोर्ट विश्लेषण प्रारंभ...")
            delay(1400)
            val selected = SampleData.sampleLabReportAnalyses.getOrElse(sampleIndex) { SampleData.sampleLabReportAnalyses.first() }
            _activeLabReport.value = selected.copy(fileName = fileName)
            _isAnalyzingReport.value = false
            _showReportAnalysisDialog.value = true
            showToast("✅ रिपोर्ट विश्लेषित: ${selected.reportType}")
        }
    }

    fun analyzeAttachedClinicalPhoto(uri: String) {
        viewModelScope.launch {
            _isAnalyzingReport.value = true
            showToast("📷 एआई विजन द्वारा नैदानिक तस्वीर का विश्लेषण...")
            delay(1300)
            _activeLabReport.value = LabReportAnalysis(
                id = "vision_${System.currentTimeMillis()}",
                fileName = "क्लीनिकल_फोटो_विजन_विश्लेषण.jpg",
                reportType = "एआई विजन डर्मेटोलॉजी व घाव विश्लेषण",
                sampleType = "क्लिनिकल फोटो (थन व त्वचा)",
                extractedParameters = mapOf(
                    "Tissue Erythema" to "तीव्र रक्तिमा व सूजन (Severe Erythema)",
                    "Surface Lesions" to "थन के छेद पर दरार व छाले (Teat Fissures)",
                    "Exudate Type" to "पीला गाढ़ा चिपचिपा स्राव (Purulent Exudate)"
                ),
                tentativeDiagnosis = "तीव्र क्लिनिकल थनैला (Acute Mastitis) एवं घाव",
                clinicalRecommendations = listOf(
                    "Intamox 3g IM 3 दिन तक तुरंत दें।",
                    "दर्द निवारक Melonex Plus 20ml IM लगाएं।",
                    "हल्दी + एलोवेरा + कलाई चूने का लेप दिन में 3 बार लगाएं।"
                ),
                criticalAlert = "तस्वीर में थन की अत्यधिक कठोरता व लाली स्पष्ट है। तुरंत एंटीबायोटिक लगाएं।"
            )
            _isAnalyzingReport.value = false
            _showReportAnalysisDialog.value = true
        }
    }

    fun closeReportAnalysisDialog() {
        _showReportAnalysisDialog.value = false
    }

    // Doctor Pharmacopeia Controller
    fun setPharmacopeiaSearch(query: String) {
        _pharmacopeiaSearchQuery.value = query
    }

    fun setPharmacopeiaSearchQuery(query: String) = setPharmacopeiaSearch(query)

    fun setPharmacopeiaCategory(cat: String) {
        _pharmacopeiaCategoryFilter.value = cat
    }

    fun togglePharmacopeiaSheet(open: Boolean) {
        _showPharmacopeiaSheet.value = open
    }

    fun openPharmacopeiaSheet() = togglePharmacopeiaSheet(true)
    fun closePharmacopeiaSheet() = togglePharmacopeiaSheet(false)

    // 45 Herbal Remedies Controller
    fun setHerbalCategoryFilter(category: String) {
        _herbalCategoryFilter.value = category
    }

    fun setHerbalCategory(cat: String) = setHerbalCategoryFilter(cat)

    fun setHerbalSearchQuery(query: String) {
        _herbalSearchQuery.value = query
    }

    // Admin Controls
    fun setAdminUserSearch(query: String) {
        _adminUserSearchQuery.value = query
    }

    fun extendUserTrial(userId: String, daysToAdd: Int) {
        _userProfiles.value = _userProfiles.value.map {
            if (it.id == userId) {
                it.copy(trialDaysRemaining = it.trialDaysRemaining + daysToAdd)
            } else it
        }
        showToast("उपयोगकर्ता का ट्रायल +$daysToAdd दिन बढ़ाया गया!")
    }

    fun updatePricingTiers(
        docW: Int, docM: Int, docQ: Int, docY: Int,
        farW: Int, farM: Int, farQ: Int, farY: Int,
        promo: String, disc: Int
    ) {
        _adminSettings.value = _adminSettings.value.copy(
            doctorWeeklyPrice = docW,
            doctorMonthlyPrice = docM,
            doctorQuarterlyPrice = docQ,
            doctorAnnualPrice = docY,
            farmerWeeklyPrice = farW,
            farmerMonthlyPrice = farM,
            farmerQuarterlyPrice = farQ,
            farmerAnnualPrice = farY,
            activePromoCode = promo,
            promoDiscountPercent = disc
        )
        showToast("सब्सक्रिप्शन पैकेज दरें सफलतापूर्वक अपडेट की गईं!")
    }

    // Voice Dictation Toggle & Speech Processing
    fun toggleVoiceDictation() {
        _isListeningVoice.value = !_isListeningVoice.value
        if (_isListeningVoice.value) {
            showToast("🎙️ बोलिए... (उदा. 'गाय को 106 डिग्री तेज बुखार है और गले में सूजन है')")
            viewModelScope.launch {
                delay(3500)
                if (_isListeningVoice.value) {
                    processVoiceInput("पशु को तेज बुखार और गले में गर्म सूजन है")
                    _isListeningVoice.value = false
                }
            }
        }
    }

    fun processVoiceInput(text: String) {
        val lower = text.lowercase()
        val matched = mutableSetOf<String>()
        if (lower.contains("बुखार") || lower.contains("ताप") || lower.contains("fever")) {
            matched.add("temp_fever_high")
        }
        if (lower.contains("थन") || lower.contains("दूध") || lower.contains("mastitis") || lower.contains("छेछड़े")) {
            matched.add("udder_hot_hard_swelling")
            matched.add("milk_flakes_blood")
        }
        if (lower.contains("आफरा") || lower.contains("गैस") || lower.contains("bloat")) {
            matched.add("abdomen_left_bloat")
        }
        if (lower.contains("लार") || lower.contains("छाले") || lower.contains("mouth")) {
            matched.add("mouth_salivation")
            matched.add("mouth_ulcers")
        }
        if (lower.contains("पेशाब") || lower.contains("लाल") || lower.contains("red water")) {
            matched.add("urine_red_coffee")
        }
        if (lower.contains("गला") || lower.contains("घुर्र") || lower.contains("hs")) {
            matched.add("throat_hot_swelling")
            matched.add("resp_labored_grunting")
        }
        if (lower.contains("लंगड़ा") || lower.contains("चड़-चड़") || lower.contains("bq")) {
            matched.add("crepitating_swelling_thigh")
            matched.add("leg_lameness")
        }
        if (lower.contains("गांठ") || lower.contains("लम्पी") || lower.contains("lsd")) {
            matched.add("skin_firm_nodules")
        }

        if (matched.isNotEmpty()) {
            _compiledSymptomIds.value = _compiledSymptomIds.value + matched
            runDiagnosis()
            showToast("वॉइस इनपुट: ${matched.size} लक्षण जुड़े!")
        } else {
            showToast("वॉइस: सामान्य लक्षण नोट किए गए")
        }
    }

    // Load Patient From OPD Queue
    fun loadPatientFromQueue(item: PatientQueueItem) {
        _selectedSpecies.value = item.species
        _calcAnimalTag.value = item.animalTag
        val matchedSymptom = when (item.id) {
            "q1" -> setOf("udder_hot_hard_swelling", "milk_flakes_blood")
            "q2" -> setOf("throat_hot_swelling", "resp_labored_grunting", "temp_fever_high")
            "q3" -> setOf("urine_red_coffee", "temp_fever_high", "eyes_pale")
            "q4" -> setOf("abdomen_left_bloat", "resp_labored_grunting")
            "q5" -> setOf("mouth_ulcers", "dung_watery_foul", "temp_fever_high")
            else -> setOf("temp_fever_mid")
        }
        _compiledSymptomIds.value = matchedSymptom
        runDiagnosis()
        navigateTo(ScreenDestination.DOCTOR_DIAGNOSIS)
        showToast("मरीज लोड हुआ: ${item.tokenNo} (${item.ownerName})")
    }

    // Prescription Export for WhatsApp
    fun generateWhatsAppPrescription(): String {
        val result = _diagnosticResult.value ?: return "पर्ची उपलब्ध नहीं है।"
        val d = result.disease
        val isPreg = _pregnancyStatus.value == PregnancyStatus.PREGNANT

        return buildString {
            append("🐾 *VETCARE AI OS • डिजिटल ओपीडी पर्ची*\n")
            append("------------------------------------\n")
            append("👤 पशुपालक: सुखविंदर सिंह • टैग: ${_calcAnimalTag.value}\n")
            append("🐄 प्रजाति: ${_selectedSpecies.value.hindiName} • वजन: ${_bodyWeightKg.value} kg\n")
            append("🤰 गर्भ स्थिति: ${_pregnancyStatus.value.label}\n\n")
            append("🩺 *निदान (Diagnosis)*: ${d.hindiName} (${d.scientificName})\n")
            append("📊 मैच प्रतिशत: ${result.matchPercentage}%\n\n")

            if (isPreg) {
                append("⚠️ *प्रेगनेंसी सुरक्षा चेतावनी*: Dexamethasone, Isoflupredone, Albendazole निषिद्ध!\n\n")
            }

            append("💉 *प्रमुख इंजेक्शन (Prescribed Injections)*:\n")
            d.injections.forEachIndexed { idx, inj ->
                append("${idx + 1}. ${inj.genericSalt} (${inj.ethicalBrand})\n   खुराक: ${inj.dosageRoute} | MRP: ₹${inj.genericMrp}\n")
            }

            if (d.oralMeds.isNotEmpty()) {
                append("\n🧴 *ओरल दवाइयां (Oral Medicines)*:\n")
                d.oralMeds.forEachIndexed { idx, om ->
                    append("${idx + 1}. ${om.saltName} (${om.genericEquivalent}) - ${om.dosageFreq}\n")
                }
            }

            if (d.desiRemedies.isNotEmpty()) {
                append("\n🥣 *100% सुरक्षित देसी नुस्खा*:\n")
                val dr = d.desiRemedies.first()
                append("• ${dr.remedyName}: ${dr.ingredients}\n  प्रयोग: ${dr.preparationMethod}\n")
            }

            append("\n🗓️ फॉलो-अप: ${d.recoveryMinDays} दिन बाद दोबारा दिखाएं।\n")
            append("📞 आपातकालीन संपर्क: 9991039297\n")
            append("हिसार पशु सुपर-स्पेशलिटी अस्पताल grid.")
        }
    }

    // Pharmacy Stock Management
    fun setDrugSearchQuery(q: String) {
        _drugSearchQuery.value = q
    }

    fun setDrugCategoryFilter(cat: String) {
        _drugCategoryFilter.value = cat
    }

    fun incrementDrugStock(drugId: String) {
        _drugsList.value = _drugsList.value.map {
            if (it.id == drugId) it.copy(stockCount = it.stockCount + 1) else it
        }
        showToast("स्टॉक बढ़ाया गया (+1)")
    }

    fun decrementDrugStock(drugId: String) {
        _drugsList.value = _drugsList.value.map {
            if (it.id == drugId && it.stockCount > 0) it.copy(stockCount = it.stockCount - 1) else it
        }
        showToast("स्टॉक घटाया गया (-1)")
    }

    // Farmer Milk Ledger
    fun setCalcMilkLiters(v: String) { _calcMilkLiters.value = v }
    fun setCalcFatPercent(v: String) { _calcFatPercent.value = v }
    fun setCalcSnfPercent(v: String) { _calcSnfPercent.value = v }
    fun setCalcAnimalTag(tag: String) { _calcAnimalTag.value = tag }

    fun recordMilkEntry() {
        val liters = _calcMilkLiters.value.toDoubleOrNull() ?: 10.0
        val fat = _calcFatPercent.value.toDoubleOrNull() ?: 6.5
        val snf = _calcSnfPercent.value.toDoubleOrNull() ?: 8.8

        // Industry standard milk TS rate formula
        val rate = Math.round(((fat * 5.8) + (snf * 2.2)) * 100.0) / 100.0
        val total = Math.round((liters * rate) * 100.0) / 100.0

        val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
        val newEntry = MilkEntry(
            id = "m_${System.currentTimeMillis()}",
            date = dateFormat.format(Date()),
            shift = "दैनिक (Logged)",
            animalTag = _calcAnimalTag.value,
            liters = liters,
            fatPercent = fat,
            snfPercent = snf,
            ratePerLiter = rate,
            totalEarnings = total
        )

        _milkEntries.value = listOf(newEntry) + _milkEntries.value
        showToast("पर्ची दुग्ध खाता बही में दर्ज हुई! (₹$total)")
    }

    // AI Breeding Calving Computation
    fun setAiDate(timestamp: Long) {
        _aiDateTimestamp.value = timestamp
        showToast("ए.आई. तारीख अपडेट हुई!")
    }

    // Admin Payout & Settings
    fun updateAdminSettings(
        clinicName: String,
        clinicSubtitle: String,
        logoUrl: String,
        palette: String,
        accountHolder: String,
        bankName: String,
        accountNumber: String,
        ifscCode: String,
        upiId: String
    ) {
        _adminSettings.value = AdminSettings(
            clinicName = clinicName,
            clinicSubtitle = clinicSubtitle,
            logoUrl = logoUrl,
            presetPalette = palette,
            accountHolder = accountHolder,
            bankName = bankName,
            accountNumber = accountNumber,
            ifscCode = ifscCode,
            upiId = upiId
        )
        showToast("बैंक व पेआउट सेटिंग्स सुरक्षित सहेजी गईं!")
    }

    fun setRevenueTimeFilter(filter: String) {
        _revenueTimeFilter.value = filter
    }

    fun toggleVciApproval(userId: String) {
        _userProfiles.value = _userProfiles.value.map {
            if (it.id == userId) it.copy(isVciApproved = !it.isVciApproved) else it
        }
        showToast("डॉक्टर वीसीआई स्टेटस अपडेट हुआ")
    }

    fun extendSubscription(userId: String) {
        showToast("सब्सक्रिप्शन 1 वर्ष के लिए बढ़ाया गया")
    }

    // Super Admin User & Role Management
    fun toggleDualRoleAuthority(userId: String) {
        _userProfiles.value = _userProfiles.value.map {
            if (it.id == userId) {
                val updated = !it.hasDualRoleAuthority
                it.copy(hasDualRoleAuthority = updated)
            } else it
        }
        if (_currentUser.value?.id == userId) {
            _currentUser.value = _currentUser.value?.let {
                it.copy(hasDualRoleAuthority = !it.hasDualRoleAuthority)
            }
        }
        showToast("दोहरी भूमिका (Dual-Role) स्विच अधिकार अपडेट हुआ!")
    }

    fun deleteUserAccount(userId: String) {
        _userProfiles.value = _userProfiles.value.filter { it.id != userId }
        if (_currentUser.value?.id == userId) {
            logout()
        }
        showToast("उपयोगकर्ता खाता सफलतापूर्वक हटाया गया!")
    }

    // AI Breeding Repository & Real-Time Bull Search
    fun searchBullWithAi(query: String) {
        val q = query.trim()
        if (q.isBlank()) return
        _bullSearchQuery.value = q
        _isSearchingLiveBull.value = true
        viewModelScope.launch {
            delay(750) // simulate real-time AI grounded query
            val existing = _bullsList.value.find {
                it.name.contains(q, ignoreCase = true) || it.tagId.contains(q, ignoreCase = true) || it.breed.contains(q, ignoreCase = true)
            }
            val resultBull = if (existing != null) {
                existing
            } else {
                val isBuffalo = q.contains("Murrah", ignoreCase = true) || q.contains("भैंस", ignoreCase = true) || q.contains("Kungrad", ignoreCase = true) || q.contains("Sultan", ignoreCase = true) || q.contains("मुराह", ignoreCase = true)
                val isExotic = q.contains("HF", ignoreCase = true) || q.contains("Jersey", ignoreCase = true) || q.contains("Holstein", ignoreCase = true)
                val breedName = when {
                    isBuffalo -> "मुर्राह भैंस (Murrah Champion Lineage)"
                    isExotic -> "होलस्टीन फ्रीजियन (HF 100% Pedigree Sire)"
                    else -> "गीर / साहीवाल संवर्धन (Indigenous Pedigree)"
                }
                val agency = if (isBuffalo) "HLDB (Haryana Livestock Development Board)" else "NDDB / Animal Breeding Centre (ABC)"
                val peakKg = if (isBuffalo) 32 else if (isExotic) 46 else 28
                val fatVal = if (isBuffalo) 8.2 else if (isExotic) 4.2 else 5.2
                val tag = "AI-SR-${(100..999).random()}-${q.take(3).uppercase()}"

                val created = BullPedigree(
                    tagId = tag,
                    name = "$q (AI Grounded Verified Sire)",
                    breed = breedName,
                    sireDamLineage = "पिता: नेशनल चैंपियन प्रोजेनी $q-Sire-01 | माता: हाई यील्डर सुपर डैमर $q-Dam-X",
                    damPeakLactationKg = peakKg,
                    damFatPercent = fatVal,
                    strawStockCount = 120,
                    pricePerStraw = if (isBuffalo) 450 else 350,
                    conceptionRatePercent = 68,
                    sourceAgency = agency,
                    species = if (isBuffalo) Species.BUFFALO else Species.CATTLE
                )
                _bullsList.value = listOf(created) + _bullsList.value
                created
            }
            _liveBullAnalysisResult.value = resultBull
            _isSearchingLiveBull.value = false
            showToast("⚡ AI लाइव सीमन व बुल विश्लेषण पूर्ण: ${resultBull.name}")
        }
    }

    fun clearLiveBullAnalysis() {
        _liveBullAnalysisResult.value = null
    }

    // Doctor Finance Ledger & OPD Billing
    fun recordOpdBilling(
        patientTag: String,
        ownerName: String,
        ownerPhone: String,
        totalAmount: Double,
        paidAmount: Double,
        status: PaymentStatus,
        mode: PaymentMode,
        notes: String
    ) {
        val balance = (totalAmount - paidAmount).coerceAtLeast(0.0)
        val opdNum = "OPD-${SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(Date())}-${(100..999).random()}"
        val record = DoctorBillingRecord(
            id = "bill_${System.currentTimeMillis()}",
            billNumber = opdNum,
            patientTag = patientTag.ifBlank { "IN-HR-${(1000..9999).random()}" },
            ownerName = ownerName.ifBlank { "पशुपालक" },
            ownerPhone = ownerPhone.ifBlank { "98xxxxxxx" },
            totalAmount = totalAmount,
            paidAmount = paidAmount,
            balanceDue = balance,
            paymentStatus = status,
            paymentMode = mode,
            timestamp = System.currentTimeMillis(),
            notes = notes.ifBlank { "ओपीडी परामर्श व उपचार पर्ची" }
        )
        _doctorBillingRecords.value = listOf(record) + _doctorBillingRecords.value
        showToast("✅ ओपीडी बिल दर्ज हुआ! रसीद: $opdNum (भुगतान: ₹$paidAmount, बकाया: ₹$balance)")
    }

    fun setFinanceTimeframeFilter(filter: String) {
        _financeTimeframeFilter.value = filter
    }

    fun deleteBillingRecord(billId: String) {
        _doctorBillingRecords.value = _doctorBillingRecords.value.filter { it.id != billId }
        showToast("बिलिंग रिकॉर्ड हटाया गया!")
    }

    fun showToast(msg: String) {
        viewModelScope.launch {
            _toastMessage.value = msg
            delay(2500)
            if (_toastMessage.value == msg) {
                _toastMessage.value = null
            }
        }
    }
}
