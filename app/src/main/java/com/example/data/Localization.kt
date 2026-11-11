package com.example.data

object Localization {

    fun get(key: String, lang: AppLanguage): String {
        val map = strings[key] ?: return key
        return when (lang) {
            AppLanguage.HINGLISH -> map[0]
            AppLanguage.HINDI -> map[1]
            AppLanguage.ENGLISH -> map[2]
            AppLanguage.PUNJABI -> map[3]
            AppLanguage.MARATHI -> map[4]
        }
    }

    private val strings = mapOf(
        // App Title & System Status
        "app_title" to listOf("VETCARE AI OS • 2026 PROD", "वेटकेयर एआई ओएस • 2026", "VETCARE AI OS • 2026 PROD", "ਵੈੱਟਕੇਅਰ ਏਆਈ ਓਐਸ • 2026", "व्हेटकेअर एआय ओएस • 2026"),
        "system_active" to listOf("सिस्टम सक्रिय", "सिस्टम सक्रिय", "System Active", "ਸਿਸਟਮ ਸਰਗਰਮ", "प्रणाली सक्रिय"),
        "logged_in_as" to listOf("लॉगिन खाता", "सक्रिय उपयोगकर्ता", "Active User", "ਸਰਗਰਮ ਖਾਤਾ", "सक्रिय वापरकर्ता"),

        // Roles & Hero Cards
        "role_doctor" to listOf("अधिकृत पशु चिकित्सक", "अधिकृत पशु चिकित्सक", "Authorized Veterinary Doctor", "ਅਧਿਕਾਰਤ ਪਸ਼ੂ ਡਾਕਟਰ", "अधिकृत पशुवैद्यकीय डॉक्टर"),
        "role_doctor_desc" to listOf("5-स्तरीय एआई रोग निदान, डिजिटल ओपीडी पर्ची, शेफर्स खुराक कैलकुलेटर, दवा टकराव सुरक्षा।", "5-स्तरीय एआई रोग निदान, डिजिटल ओपीडी पर्ची, शेफर्स खुराक कैलकुलेटर, दवा टकराव सुरक्षा।", "5-Tier AI Diagnostics, Digital OPD Rx, Shaeffer's Dose Engine, Drug Interaction Safety.", "5-ਪੱਧਰੀ ਏਆਈ ਰੋਗ ਨਿਦਾਨ, ਡਿਜੀਟਲ ਓਪੀਡੀ ਪਰਚੀ, ਖੁਰਾਕ ਕੈਲਕੁਲੇਟਰ।", "५-स्तरीय एआय रोग निदान, डिजिटल ओपीडी प्रिस्क्रिप्शन, डोस कॅल्क्युलेटर."),
        "doctor_login" to listOf("डॉक्टर लॉगिन", "डॉक्टर लॉगिन", "Doctor Login", "ਡਾਕਟਰ ਲਾਗਇਨ", "डॉक्टर लॉगिन"),
        "doctor_register" to listOf("नया डॉक्टर पंजीकरण", "नया डॉक्टर पंजीकरण", "New Doctor Reg.", "ਨਵਾਂ ਡਾਕਟਰ ਰਜਿਸਟਰ", "नवीन डॉक्टर नोंदणी"),

        "role_farmer" to listOf("जागरूक पशुपालक हब", "जागरूक पशुपालक हब", "Smart Dairy Farmer Hub", "ਜਾਗਰੂਕ ਡੇਅਰੀ ਕਿਸਾਨ ਹੱਬ", "जागरूक दुग्ध उत्पादक शेतकरी हब"),
        "role_farmer_desc" to listOf("डिजिटल पशु आधार पासबुक, दूध-फैट आय खाता, 100% सुरक्षित देसी नुस्खे, 280-दिन गर्भ कैलेंडर।", "डिजिटल पशु आधार पासबुक, दूध-फैट आय खाता, 100% सुरक्षित देसी नुस्खे, 280-दिन गर्भ कैलेंडर।", "Digital Pashu Passbook, Milk Fat-SNF Ledger, 100% Verified Herbal Remedies, 280-Day Calving Calendar.", "ਡਿਜੀਟਲ ਪਸ਼ੂ ਪਾਸਬੁੱਕ, ਦੁੱਧ-ਫੈਟ ਲੇਖਾ, ਦੇਸੀ ਨੁਸਖੇ, 280-ਦਿਨ ਕੈਲੰਡਰ।", "डिजिटल पशु पासबुक, दूध-फॅट खातेवही, १००% सुरक्षित देशी उपाय, २८०-दिवस कॅलेंडर."),
        "farmer_login" to listOf("किसान लॉगिन", "किसान लॉगिन", "Farmer Login", "ਕਿਸਾਨ ਲਾਗਇਨ", "शेतकरी लॉगिन"),
        "farmer_register" to listOf("नया खाता बनाएँ", "नया खाता बनाएँ", "Create Account", "ਨਵਾਂ ਖਾਤਾ ਬਣਾਓ", "नवीन खाते तयार करा"),

        "role_admin" to listOf("अधिकृत एडमिन वॉल्ट", "अधिकृत एडमिन वॉल्ट", "Master Admin Vault", "ਮਾਸਟਰ ਐਡਮਿਨ ਵਾਲਟ", "मास्टर अ‍ॅडमिन वॉल्ट"),
        "role_admin_desc" to listOf("सब्सक्रिप्शन आय व वित्तीय एनालिटिक्स, बैंक/UPI खाता प्रबंधन, आईडी अप्रूवल, नो-कोड लुक कस्टमाइज़र।", "सब्सक्रिप्शन आय व वित्तीय एनालिटिक्स, बैंक/UPI खाता प्रबंधन, आईडी अप्रूवल, नो-कोड लुक कस्टमाइज़र।", "Revenue & Payout Analytics, Bank/UPI Gateway Settings, Doctor VCI Approval, No-Code Live Styler.", "ਆਮਦਨ ਵਿਸ਼ਲੇਸ਼ਣ, ਬੈਂਕ/ਯੂਪੀਆਈ ਸੈਟਿੰਗਾਂ, ਡਾਕਟਰ ਪ੍ਰਵਾਨਗੀ, ਥੀਮ ਸੈਟਿੰਗਜ਼।", "महसूल विश्लेषण, बँक/UPI सेटिंग्ज, डॉक्टर मान्यता, नो-कोड थीम सानुकूलन."),
        "admin_login" to listOf("मास्टर एडमिन लॉगिन", "मास्टर एडमिन लॉगिन", "Master Admin Login", "ਮਾਸਟਰ ਐਡਮਿਨ ਲਾਗਇਨ", "मास्टर अ‍ॅडमिन लॉगिन"),

        // Navigation Drawer
        "nav_menu" to listOf("नेविगेशन मेनू", "नेविगेशन मेनू", "Navigation Menu", "ਨੇਵੀਗੇਸ਼ਨ ਮੇਨੂ", "नेव्हिगेशन मेनू"),
        "close" to listOf("बंद करें ✕", "बंद करें ✕", "Close ✕", "ਬੰਦ ਕਰੋ ✕", "बंद करा ✕"),

        // Doctor Drawer Items
        "nav_opd_mgmt" to listOf("1. ओपीडी एवं रोगी प्रबंधन", "1. ओपीडी एवं रोगी प्रबंधन", "1. OPD & Patient Records", "1. ਓਪੀਡੀ ਤੇ ਮਰੀਜ਼ ਪ੍ਰਬੰਧਨ", "1. ओपीडी आणि रुग्ण व्यवस्थापन"),
        "nav_ai_diagnosis" to listOf("2. एआई रोग लक्षण निदान", "2. एआई रोग लक्षण निदान", "2. 3-Way AI Diagnostics", "2. ਏਆਈ ਰੋਗ ਨਿਦਾਨ", "2. एआय रोग लक्षण निदान"),
        "nav_drugs_stock" to listOf("3. वेटनरी औषधि व स्टॉक", "3. वेटनरी औषधि व स्टॉक", "3. Drugs & Pharmacy Stock", "3. ਦਵਾਈਆਂ ਤੇ ਸਟਾਕ", "3. औषधे आणि फार्मसी साठा"),
        "nav_dosage_safety" to listOf("4. खुराक व ड्रग सुरक्षा", "4. खुराक व ड्रग सुरक्षा", "4. Dosage & Drug Safety", "4. ਖੁਰਾਕ ਤੇ ਸੁਰੱਖਿਆ", "4. डोस आणि औषध सुरक्षा"),
        "nav_breeding_catalog" to listOf("5. प्रजनन व सीमन कैटलॉग", "5. प्रजनन व सीमन कैटलॉग", "5. AI Breeding & Semen Catalog", "5. ਨਸਲ ਸੁਧਾਰ ਤੇ ਸੀਮਨ", "5. पैदास आणि वीर्य कॅटलॉग"),

        // Farmer Drawer Items
        "nav_pashu_passbook" to listOf("1. पशु आधार व स्वास्थ्य", "1. पशु आधार व स्वास्थ्य", "1. Pashu Aadhaar Passbook", "1. ਪਸ਼ੂ ਆਧਾਰ ਤੇ ਸਿਹਤ", "1. पशु आधार आणि आरोग्य"),
        "nav_milk_calc" to listOf("2. दूध व फैट-एसएनएफ खाता", "2. दूध व फैट-एसएनएफ खाता", "2. Daily Milk & Fat-SNF Ledger", "2. ਦੁੱਧ ਤੇ ਫੈਟ ਲੇਖਾ", "2. दूध आणि फॅट-एसएनएफ खाते"),
        "nav_desi_nuskhe" to listOf("3. 100% सुरक्षित देसी नुस्खे", "3. 100% सुरक्षित देसी नुस्खे", "3. 100% Verified Desi Remedies", "3. 100% ਸੁਰੱਖਿਅਤ ਦੇਸੀ ਨੁਸਖੇ", "3. १००% सुरक्षित देशी उपाय"),
        "nav_emergency_sos" to listOf("4. चारा व आपातकालीन SOS", "4. चारा व आपातकालीन SOS", "4. Emergency Vet SOS Call", "4. ਐਮਰਜੈਂਸੀ ਡਾਕਟਰ ਕਾਲ", "4. आणीबाणी डॉक्टर कॉल"),

        // Admin Drawer Items
        "nav_admin_financials" to listOf("1. वित्तीय व रेवेन्यू एनालिटिक्स", "1. वित्तीय व रेवेन्यू एनालिटिक्स", "1. Financial & Revenue Analytics", "1. ਵਿੱਤੀ ਵਿਸ਼ਲੇਸ਼ਣ", "1. आर्थिक आणि महसूल विश्लेषण"),
        "nav_admin_payout" to listOf("2. बैंक व पेआउट सेटिंग्स", "2. बैंक व पेआउट सेटिंग्स", "2. Bank & UPI Payout Gateway", "2. ਬੈਂਕ ਤੇ ਯੂਪੀਆਈ ਸੈਟਿੰਗਾਂ", "2. बँक आणि UPI देयक सेटिंग्ज"),
        "nav_admin_users" to listOf("3. यूज़र व आईडी प्रबंधन", "3. यूज़र व आईडी प्रबंधन", "3. User & VCI Reg. Verification", "3. ਉਪਭੋਗਤਾ ਪ੍ਰਬੰਧਨ", "3. वापरकर्ता व नोंदणी व्यवस्थापन"),
        "nav_admin_customizer" to listOf("4. नो-कोड लुक कस्टमाइज़र", "4. नो-कोड लुक कस्टमाइज़र", "4. No-Code Live Theme Styler", "4. ਥੀਮ ਕਸਟਮਾਈਜ਼ਰ", "4. नो-कोड थीम कस्टमायझर"),

        // Doctor Workspace
        "diag_mode_1" to listOf("मोड 1: केवल लक्षण आधारित", "मोड 1: केवल लक्षण आधारित", "Mode 1: Symptom-Based AI", "ਮੋਡ 1: ਲੱਛਣ ਆਧਾਰਿਤ", "मोड 1: लक्षण आधारित"),
        "diag_mode_2" to listOf("मोड 2: लक्षण + संदेहास्पद रोग क्रॉस-चेक", "मोड 2: लक्षण + संदेहास्पद रोग क्रॉस-चेक", "Mode 2: Symptoms + Suspected Cross-Check", "ਮੋਡ 2: ਸ਼ੱਕੀ ਰੋਗ ਕਰਾਸ-ਚੈੱਕ", "मोड 2: संशयित रोग क्रॉस-चेक"),
        "diag_mode_3" to listOf("मोड 3: प्रत्यक्ष रोग त्वरित गाइड", "मोड 3: प्रत्यक्ष रोग त्वरित गाइड", "Mode 3: Direct Protocol Guide", "ਮੋਡ 3: ਸਿੱਧਾ ਰੋਗ ਗਾਈਡ", "मोड 3: थेट रोग मार्गदर्शक"),

        "species_label" to listOf("पशु प्रजाति (Species)", "पशु प्रजाति", "Animal Species", "ਪਸ਼ੂ ਕਿਸਮ", "प्राणी प्रजाती"),
        "pregnancy_label" to listOf("गर्भ स्थिति (Pregnancy Status)", "गर्भ स्थिति", "Pregnancy Status", "ਗਰਭ ਸਥਿਤੀ", "गर्भधारणा स्थिती"),
        "bodyweight_kg" to listOf("वजन (किग्रा)", "वजन (किग्रा)", "Bodyweight (kg)", "ਵਜ਼ਨ (ਕਿਲੋ)", "वजन (किलो)"),
        "age_label" to listOf("उम्र (वर्ष)", "उम्र (वर्ष)", "Age (Years)", "ਉਮਰ (ਸਾਲ)", "वय (वर्षे)"),

        "compiled_symptoms" to listOf("संकलित नैदानिक लक्षण बैंक", "संकलित नैदानिक लक्षण बैंक", "Compiled Clinical Symptoms Bank", "ਇਕੱਠੇ ਕੀਤੇ ਲੱਛਣ ਬੈਂਕ", "संकलित लक्षण बँक"),
        "clear_all" to listOf("सब साफ़ करें", "सब साफ़ करें", "Clear All", "ਸਭ ਸਾਫ਼ ਕਰੋ", "सर्व साफ करा"),
        "cardinal_sign_label" to listOf("🚨 प्रमुख कार्डिनल लक्षण (Pathognomonic Sign)", "🚨 प्रमुख कार्डिनल लक्षण", "🚨 Cardinal / Pathognomonic Sign", "🚨 ਮੁੱਖ ਕਾਰਡੀਨਲ ਲੱਛਣ", "🚨 मुख्य लक्षण"),
        "cardinal_hint" to listOf("उदा: थन में पत्थर जैसी कठोरता, या चड़-चड़ आवाज", "उदा: थन में कठोरता या घुर्र-घुर्र सांस", "e.g. Stony hard quarter or crepitation", "ਜਿਵੇਂ: ਲੇਵੇ ਦੀ ਸਖ਼ਤ ਸੋਜ", "उदा: कासेला कडक सूज"),

        "voice_assistant" to listOf("बोलकर लक्षण दर्ज करें (Voice)", "बोलकर लक्षण दर्ज करें", "Voice Symptom Input", "ਬੋਲ ਕੇ ਲੱਛਣ ਦਰਜ ਕਰੋ", "बोलून लक्षणे नोंदवा"),
        "photo_attached" to listOf("फोटो संलग्न", "फोटो संलग्न", "Photo Attached", "ਫੋਟੋ ਜੁੜੀ ਹੋਈ", "फोटो संलग्न"),
        "attach_wound_photo" to listOf("घाव / थन की फोटो जोड़ें", "फोटो जोड़ें", "Attach Wound / Udder Photo", "ਜ਼ਖ਼ਮ ਦੀ ਫੋਟੋ ਲਗਾਓ", "जखमेचा फोटो जोडा"),

        "run_offline_diag" to listOf("5-स्तरीय त्वरित ऑफ़लाइन निदान", "5-स्तरीय त्वरित निदान", "Generate 5-Tier Clinical Diagnosis", "5-ਪੱਧਰੀ ਨਿਦਾਨ ਕਰੋ", "५-स्तरीय जलद निदान"),
        "ai_second_opinion" to listOf("🤖 एआई सेकंड ओपिनियन", "🤖 एआई सेकंड ओपिनियन", "🤖 AI Second Opinion", "🤖 ਏਆਈ ਦੂਜੀ ਰਾਏ", "🤖 एआय सेकंड ओपिनियन"),

        "print_rx" to listOf("🖨️ पर्ची प्रिंट करें (Print Rx)", "🖨️ पर्ची प्रिंट करें", "🖨️ Print Prescription", "🖨️ ਪਰਚੀ ਪ੍ਰਿੰਟ ਕਰੋ", "🖨️ प्रिस्क्रिप्शन प्रिंट करा"),
        "whatsapp_rx" to listOf("📲 WhatsApp पर भेजें", "📲 WhatsApp पर भेजें", "📲 Share on WhatsApp", "📲 ਵਟਸਐਪ ਤੇ ਭੇਜੋ", "📲 व्हॉट्सअ‍ॅपवर पाठवा"),

        // Common labels
        "save" to listOf("सहेजें (Save)", "सहेजें", "Save", "ਸੰਭਾਲੋ", "जतन करा"),
        "cancel" to listOf("रद्द करें", "रद्द करें", "Cancel", "ਰੱਦ ਕਰੋ", "रद्द करा"),
        "total_revenue" to listOf("कुल सब्सक्रिप्शन आय", "कुल आय", "Gross Total Revenue", "ਕੁੱਲ ਆਮਦਨ", "एकूण उत्पन्न"),
        "bank_settings" to listOf("बैंक व पेआउट विवरण", "बैंक सेटिंग्स", "Bank & Payout Gateway", "ਬੈਂਕ ਵੇਰਵੇ", "बँक तपशील"),
        "in_stock" to listOf("स्टॉक में उपलब्ध", "उपलब्ध", "In Stock", "ਸਟਾਕ ਵਿੱਚ", "साठ्यात उपलब्ध"),
        "low_stock" to listOf("कम स्टॉक चेतावनी!", "कम स्टॉक!", "Low Stock Alert!", "ਘੱਟ ਸਟਾਕ ਚੇਤਾਵਨੀ!", "कमी साठा!")
    )
}
