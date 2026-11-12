package com.example.data

object SampleData {

    val initialDrugs: List<DrugItem> = listOf(
        // Antibiotics
        DrugItem("d1", "Ceftriaxone + Tazobactam 4.5g", "Intacef Tazo 4.5g", "Cef-Tazo Vet 4.5g", "एंटीबायोटिक", 480, 190, 35, "IM/IV", true),
        DrugItem("d2", "Enrofloxacin 100mg/ml 30ml", "Enrocin 30ml", "Flox-Vet 30ml", "एंटीबायोटिक", 210, 85, 24, "IM", true),
        DrugItem("d3", "Amoxicillin + Cloxacillin 3g", "Intamox 3g", "Amoxi-Clox Vet 3g", "एंटीबायोटिक", 310, 130, 18, "IM", true),
        DrugItem("d4", "Oxytetracycline 200mg/ml LA", "Terramycin LA 30ml", "Oxy-LA Vet 30ml", "एंटीबायोटिक", 210, 85, 4, "Deep IM", true), // low stock
        DrugItem("d5", "Procaine Penicillin 40L IU", "Pronapen 40L", "Peni-Vet 40L", "एंटीबायोटिक", 180, 75, 42, "IM", true),

        // NSAIDs
        DrugItem("d6", "Meloxicam + Paracetamol 30ml", "Melonex Plus 30ml", "Melox-P Vet 30ml", "दर्द निवारक", 140, 55, 60, "IM", true),
        DrugItem("d7", "Flunixin Meglumine 50mg/ml", "Megludyne 20ml", "Flunix Vet 20ml", "दर्द निवारक", 240, 95, 12, "Slow IV", true),
        DrugItem("d8", "Isoflupredone Acetate 10ml", "Predef 2X 10ml", "Iso-Vet 10ml", "स्टेरॉयड", 190, 80, 15, "IM", false), // Not pregnant safe!

        // Antiprotozoal
        DrugItem("d9", "Buparvaquone 50mg/ml 20ml", "Butalex 20ml", "Zubion Vet 20ml", "एंटीप्रोटोजोअल", 1250, 680, 8, "Deep IM Neck", false),
        DrugItem("d10", "Diminazene Aceturate 7% 20ml", "Berenil 20ml", "Dimina-Vet 20ml", "एंटीप्रोटोजोअल", 280, 110, 3, "Deep IM", true), // low stock
        DrugItem("d11", "Quinapyramine Sulfate/Chloride", "Triquin 2.5g", "Surra-Nil 2.5g", "एंटीप्रोटोजोअल", 420, 190, 16, "SC", false),

        // Anthelmintics
        DrugItem("d12", "Ivermectin 10mg/ml 10ml", "Neomec 10ml", "Iver-Vet 10ml", "कृमिनाशक", 140, 60, 28, "SC", true),
        DrugItem("d13", "Albendazole 3g Bolus", "Valbazen 3g", "Albo-Vet 3g", "कृमिनाशक", 45, 18, 55, "Oral", false), // Not pregnant safe in 1st trimester!
        DrugItem("d14", "Fenbendazole 3g Bolus", "Fentas 3g", "Fen-Vet 3g", "कृमिनाशक", 60, 25, 40, "Oral", true),

        // Fluids & Calciums
        DrugItem("d15", "Calcium Borogluconate 450ml", "Mifex 450ml", "Calci-Vet 450ml", "कैल्शियम व फ्लुइड", 350, 160, 14, "Slow IV", true),
        DrugItem("d16", "Dextrose 20% 500ml", "Dextrose 20% Infusion", "Dex-Vet 500ml", "कैल्शियम व फ्लुइड", 120, 50, 30, "Rapid IV", true),
        DrugItem("d17", "Ringer's Lactate (RL) 1000ml", "RL Infusion 1000ml", "RL Vet 1000ml", "कैल्शियम व फ्लुइड", 95, 40, 2, "IV", true) // low stock
    )

    val initialBulls: List<BullPedigree> = listOf(
        BullPedigree("BUL-MUR-29", "मुराह सुल्तान किंग (Sultan King)", "मुराह भैंस (Murrah)", "बाप: M-14 (NDRI) • मां: Ganga Champion", 5400, 8.2, 140, 450, 68, "HLDB", Species.BUFFALO),
        BullPedigree("BUL-NLR-08", "नीली-रावी सतलुज (Nili-Ravi Satluj)", "नीली-रावी भैंस (Nili-Ravi)", "बाप: NR-Ferozepur • मां: Satluj Rani 18L", 4600, 8.4, 95, 420, 67, "HLDB", Species.BUFFALO),
        BullPedigree("BUL-JAF-14", "जाफराबादी सम्राट (Samrat)", "जाफराबादी भैंस (Jaffarabadi)", "बाप: JF-09 (Junagadh) • मां: Gir Champion", 4900, 8.8, 85, 420, 66, "NDDB", Species.BUFFALO),
        BullPedigree("BUL-SAH-09", "साहीवाल कान्हा (Kanha Bull)", "साहीवाल गाय (Sahiwal)", "बाप: SW-02 • मां: Nandini Best Yield", 4800, 4.8, 95, 350, 72, "HLDB", Species.CATTLE),
        BullPedigree("BUL-GIR-18", "गीर सोमनाथ गौरव (Somnath Pride)", "गीर गाय (Gir)", "बाप: GR-07 (Junagadh) • मां: Kasturi", 5100, 4.9, 110, 400, 70, "NDDB", Species.CATTLE),
        BullPedigree("BUL-THA-05", "थारपारकर मरुधर (Thar Gem)", "थारपारकर गाय (Tharparkar)", "बाप: TP-01 • मां: Maru Rani", 4200, 4.7, 80, 300, 74, "BAIF", Species.CATTLE),
        BullPedigree("BUL-HFR-909", "एचएफ ग्लेशियर (HF Glacier 909)", "एचएफ गाय (Holstein Friesian)", "बाप: US-Glacier • मां: Super-Milk USA", 9200, 3.8, 220, 600, 65, "ABC", Species.CATTLE),
        BullPedigree("BUL-JER-303", "जर्सी अंबर गोल्ड (Amber Gold)", "जर्सी गाय (Jersey)", "बाप: JR-Den • मां: Golden Queen", 6800, 5.2, 150, 500, 69, "ABC", Species.CATTLE),
        BullPedigree("BUL-BEE-44", "बीटल जमुनापरी किंग (Beetal King)", "बीटल बकरी (Beetal Goat)", "बाप: CIRG-Makhdoom • मां: Twin-Yield 4.2L", 1200, 4.2, 180, 250, 76, "HLDB", Species.GOAT),
        BullPedigree("BUL-RAM-12", "मेरिनो रैम सुपीरियर (Merino Ram)", "मेरिनो भेड़ (Merino Sheep)", "बाप: CSWRI-Avikanagar • मां: Fine-Wool A+", 850, 0.0, 90, 200, 71, "BAIF", Species.SHEEP),
        BullPedigree("BUL-GSD-01", "जर्मन शेफर्ड चैंपियन वोल्फ (K9 Champion)", "जर्मन शेफर्ड (GSD Dog)", "बाप: VA1-German Line • मां: K9-Gold Medal", 0, 0.0, 40, 1200, 80, "ABC", Species.DOG)
    )

    val initialPashuList: List<PashuRecord> = listOf(
        PashuRecord("IN-HR-1092-4821", "सुखविंदर सिंह", "9812039297", "हांसी (हिसार)", Species.BUFFALO, "मुराह (Murrah)", 4.5, "दूसरा ब्यांत (पीक दुग्ध)", 16.5, false, 0, "FMD+HS 2026", "आइवरमेक्टिन दिया गया"),
        PashuRecord("IN-HR-8832-1920", "धर्मपाल जांगड़ा", "9416088219", "बरवाला (हिसार)", Species.CATTLE, "साहीवाल (Sahiwal)", 3.8, "पहला ब्यांत (गाभिन)", 14.0, true, 5, "FMD 2026", "फेनबेंडाजोल दिया गया"),
        PashuRecord("IN-HR-4412-9844", "बलबीर सांगवान", "9896011234", "भिवानी", Species.CATTLE, "गीर (Gir)", 5.2, "तीसरा ब्यांत (गाभिन)", 18.2, true, 2, "HS+BQ 2026", "नियमित"),
        PashuRecord("IN-PB-7741-3329", "हरप्रीत सिंह", "9872055667", "पटियाला", Species.CATTLE, "एचएफ क्रॉस (HF Cross)", 4.0, "दूसरा ब्यांत", 24.5, false, 0, "FMD 2026", "नियमित"),
        PashuRecord("IN-HR-5521-6670", "रामनिवास शर्मा", "9991039297", "रोहतक", Species.GOAT, "बीटल बकरी (Beetal)", 2.5, "दूध उत्पादन", 3.2, false, 0, "PPR 2026", "नियमित")
    )

    val initialMilkEntries: List<MilkEntry> = listOf(
        MilkEntry("m1", "08 Nov 2026", "सुबह (Morning)", "IN-HR-1092-4821", 16.5, 7.2, 9.2, 58.40, 963.60),
        MilkEntry("m2", "07 Nov 2026", "शाम (Evening)", "IN-HR-1092-4821", 15.0, 7.0, 9.1, 56.80, 852.00),
        MilkEntry("m3", "07 Nov 2026", "सुबह (Morning)", "IN-HR-8832-1920", 14.0, 4.8, 8.8, 44.50, 623.00),
        MilkEntry("m4", "06 Nov 2026", "शाम (Evening)", "IN-HR-4412-9844", 18.0, 5.0, 9.0, 46.20, 831.60),
        MilkEntry("m5", "06 Nov 2026", "सुबह (Morning)", "IN-PB-7741-3329", 24.0, 3.8, 8.6, 38.50, 924.00)
    )

    val initialUsers: List<UserProfile> = listOf(
        UserProfile("u_doc1", "डॉ. राहुल जांगड़ा (B.V.Sc & A.H)", UserRole.DOCTOR, "9991039297", "HR-VCI-8892", "हिसार पशु सुपर-स्पेशलिटी अस्पताल", 0, true, true),
        UserProfile("u_doc2", "डॉ. विकास शर्मा (M.V.Sc Medicine)", UserRole.DOCTOR, "9416123456", "VCI-2018-4421", "रोहतक वेटनरी पॉलीक्लीनिक", 0, true, true),
        UserProfile("u_far1", "सुखविंदर सिंह (डेयरी संचालक)", UserRole.FARMER, "9812039297", "TAG-HR-1092", "हांसी (हिसार)", 14, false, true),
        UserProfile("u_far2", "धर्मपाल जांगड़ा (प्रगतिशील किसान)", UserRole.FARMER, "9416088219", "TAG-HR-8832", "बरवाला (हिसार)", 8, false, true),
        UserProfile("u_adm1", "मास्टर एडमिन (Rahul Jangra)", UserRole.ADMIN, "9991039297", "ADM-MASTER-9297", "VETCARE Central Command HQ", 0, true, true)
    )

    val initialQueue: List<PatientQueueItem> = listOf(
        PatientQueueItem("q1", "T-01", "IN-HR-1092-4821", Species.BUFFALO, "सुखविंदर सिंह", "9812039297", "थन में कठोर सूजन व दही जैसे छेछड़े (थनैला)", false, 5),
        PatientQueueItem("q2", "T-02", "IN-HR-3341-9981", Species.CATTLE, "राजेश कुमार", "9896123490", "गले में अत्यधिक गर्म सूजन, घुर्र-घुर्र सांस (HS)", true, 0),
        PatientQueueItem("q3", "T-03", "IN-HR-8832-1920", Species.CATTLE, "धर्मपाल जांगड़ा", "9416088219", "कॉफी रंग का गहरा लाल पेशाब, 106°F बुखार", true, 0),
        PatientQueueItem("q4", "T-04", "IN-HR-4412-9844", Species.CATTLE, "बलबीर सांगवान", "9896011234", "बाईं कोख में भीषण आफरा व दम फूलना (Bloat)", true, 2),
        PatientQueueItem("q5", "T-05", "IN-HR-5521-6670", Species.GOAT, "रामनिवास शर्मा", "9991039297", "मुंह में छाले व तेज दस्त (PPR)", false, 15)
    )

    val initialBankAccounts: List<BankAccount> = listOf(
        BankAccount(
            id = "bank_sbi_primary",
            bankName = "State Bank of India (SBI)",
            accountNumberMasked = "A/C ending ****7585",
            accountNumberFull = "392971817585",
            ifscCode = "SBIN0001812",
            upiId = "rahuljangra9297@oksbi",
            payeeName = "Rj official",
            isPrimary = true
        ),
        BankAccount(
            id = "bank_pnb_secondary",
            bankName = "Punjab National Bank (PNB)",
            accountNumberMasked = "A/C ending ****5098",
            accountNumberFull = "0812000100005098",
            ifscCode = "PUNB0081200",
            upiId = "rahuljangra9297-1@okicici",
            payeeName = "Rj official",
            isPrimary = false
        )
    )

    val initialDrugSubstitutes: List<DrugSubstituteDetail> = listOf(
        DrugSubstituteDetail(
            id = "sub_amoxi_clox",
            saltName = "Amoxicillin + Cloxacillin",
            brandName = "Intamox 3g / Amoxi-Clox Vet",
            company = "Intas Pharmaceuticals / Generic Vet",
            mrp = 280,
            doseRateMgPerKg = 10.0,
            concentrationMgPerMl = 100.0, // reconstituted 3g in 30ml
            route = "Intramuscular (IM) / Slow IV",
            clinicalUsage = "तीव्र थनैला (Acute Mastitis), घाव, जननांग संक्रमण",
            pregnancySafe = true
        ),
        DrugSubstituteDetail(
            id = "sub_ceftriaxone_tazo",
            saltName = "Ceftriaxone + Tazobactam",
            brandName = "Intacef Tazo 4.5g / Cef-Tazo Vet",
            company = "Intas Pharma / Vet Generic Co.",
            mrp = 480,
            doseRateMgPerKg = 10.0,
            concentrationMgPerMl = 150.0, // reconstituted 4.5g in 30ml
            route = "IM / Slow IV (Twice Daily)",
            clinicalUsage = "गलघोंटू (HS), जटिल थनैला, न्यूमोनिया व सेप्सिस",
            pregnancySafe = true
        ),
        DrugSubstituteDetail(
            id = "sub_ceftiofur",
            saltName = "Ceftiofur Sodium / RTU",
            brandName = "Xyrofur 1g / Excenel RTU",
            company = "Zoetis / Virbac Animal Health",
            mrp = 550,
            doseRateMgPerKg = 2.2,
            concentrationMgPerMl = 50.0, // 50mg/ml
            route = "Intramuscular (IM) once daily",
            clinicalUsage = "जीरो मिल्क विथड्रॉल अवधि, मेट्राइटिस व सांस रोग",
            pregnancySafe = true
        ),
        DrugSubstituteDetail(
            id = "sub_oxytetracycline_la",
            saltName = "Oxytetracycline LA 200mg/ml",
            brandName = "Terramycin LA / Oxy-LA Vet",
            company = "Pfizer / Zydus Animal Health",
            mrp = 210,
            doseRateMgPerKg = 20.0,
            concentrationMgPerMl = 200.0, // 200mg/ml
            route = "Deep Intramuscular (Neck region)",
            clinicalUsage = "सर्रा, एनाप्लाज्मोसिस, लंगड़ा बुखार (BQ), न्यूमोनिया",
            pregnancySafe = true
        ),
        DrugSubstituteDetail(
            id = "sub_enrofloxacin",
            saltName = "Enrofloxacin 100mg/ml",
            brandName = "Enrocin 100 / Flox-Vet 30ml",
            company = "Cadila Animal Health / Mankind Vet",
            mrp = 195,
            doseRateMgPerKg = 5.0,
            concentrationMgPerMl = 100.0, // 100mg/ml
            route = "Intramuscular (IM) / Slow IV",
            clinicalUsage = "गंभीर दस्त, पेरिटोनाइटिस, यूरीन इन्फेक्शन",
            pregnancySafe = true,
            contraindicatedSpecies = emptyList(),
            speciesSpecialWarning = "कुत्तों (Canine) में: छोटे पिल्लों (<8 महीने) में जोड़ों की उपास्थि (cartilage) क्षति के जोखिम के कारण सावधानी बरतें।"
        ),
        DrugSubstituteDetail(
            id = "sub_gentamicin",
            saltName = "Gentamicin Sulfate 40mg/ml",
            brandName = "Gentacip / Genta-Vet 100ml",
            company = "Cipla Vet / Wockhardt",
            mrp = 120,
            doseRateMgPerKg = 4.0,
            concentrationMgPerMl = 40.0, // 40mg/ml
            route = "Intramuscular (IM) strictly 3 days",
            clinicalUsage = "ग्राम-नेगेटिव एंटराइटिस, गर्भाशय स्राव (Intrauterine)",
            pregnancySafe = true
        ),
        DrugSubstituteDetail(
            id = "sub_streptopenicillin",
            saltName = "Procaine Penicillin + Streptomycin",
            brandName = "Dicrysticin / Munomycin 2.5g",
            company = "Sarabhai / Zydus AHL",
            mrp = 160,
            doseRateMgPerKg = 10.0,
            concentrationMgPerMl = 125.0,
            route = "Deep Intramuscular (IM)",
            clinicalUsage = "लंगड़ा बुखार (BQ), गलघोंटू, खुरपका के घाव",
            pregnancySafe = true
        ),
        DrugSubstituteDetail(
            id = "sub_florfenicol",
            saltName = "Florfenicol 300mg/ml",
            brandName = "Nuflor 100ml / Flor-Vet",
            company = "MSD Animal Health",
            mrp = 950,
            doseRateMgPerKg = 20.0,
            concentrationMgPerMl = 300.0,
            route = "Intramuscular (IM) 2 doses 48h apart",
            clinicalUsage = "बोवाइन रेस्पिरेटरी डिजीज (BRD), संक्रामक फुटरोट",
            pregnancySafe = true
        ),
        DrugSubstituteDetail(
            id = "sub_tylosin",
            saltName = "Tylosin Tartrate 200mg/ml",
            brandName = "Tylan 200 / Tylo-Vet 100ml",
            company = "Elanco Animal Health",
            mrp = 720,
            doseRateMgPerKg = 10.0,
            concentrationMgPerMl = 200.0,
            route = "Deep IM once daily for 3-5 days",
            clinicalUsage = "माइकोप्लाज्मा थनैला, निमोनिया, डिप्थीरिया",
            pregnancySafe = true
        ),
        DrugSubstituteDetail(
            id = "sub_diminazene",
            saltName = "Diminazene Aceturate 70mg/ml",
            brandName = "Berenil 20ml / Dimina-Vet",
            company = "Intervet MSD / Carus Animal Health",
            mrp = 280,
            doseRateMgPerKg = 3.5,
            concentrationMgPerMl = 70.0,
            route = "Deep Intramuscular (Gluteal muscles)",
            clinicalUsage = "बेबेशियोसिस (लाल पेशाब) व ट्रिपैनोसोमियासिस (सर्रा)",
            pregnancySafe = true
        ),
        DrugSubstituteDetail(
            id = "sub_buparvaquone",
            saltName = "Buparvaquone 50mg/ml",
            brandName = "Butalex 20ml / Zubion Vet",
            company = "MSD Animal Health / Intas Pharma",
            mrp = 1250,
            doseRateMgPerKg = 2.5,
            concentrationMgPerMl = 50.0,
            route = "Deep IM strictly in Neck muscles only",
            clinicalUsage = "थायलेरियासिस (Theileriosis) में जीवनरक्षक सिंगल डोज",
            pregnancySafe = false
        ),
        DrugSubstituteDetail(
            id = "sub_imidocarb",
            saltName = "Imidocarb Dipropionate 120mg/ml",
            brandName = "Imizol 100ml / Imido-Vet",
            company = "Schering-Plough / MSD",
            mrp = 1450,
            doseRateMgPerKg = 1.2,
            concentrationMgPerMl = 120.0,
            route = "Subcutaneous (SC) or IM",
            clinicalUsage = "बेबेशियोसिस व एनाप्लाज्मोसिस का स्थायी इलाज",
            pregnancySafe = true
        ),
        DrugSubstituteDetail(
            id = "sub_mifex_cbg",
            saltName = "Calcium Borogluconate 25% + Mg + P",
            brandName = "Mifex 450ml / Calborol",
            company = "Novartis / Elanco Animal Health",
            mrp = 360,
            doseRateMgPerKg = 1.0, // ml/kg directly
            concentrationMgPerMl = 1.0, // 1 ml per kg
            route = "Slow Intravenous (Warm at Body Temp)",
            clinicalUsage = "मिल्क फीवर (Milk Fever), हाइपोकैल्सीमिया, डाउनर काउ",
            pregnancySafe = true
        ),
        DrugSubstituteDetail(
            id = "sub_catosal",
            saltName = "Butaphosphan 100mg + Cyanocobalamin (B12)",
            brandName = "Catosal 100ml / Fostone Vet",
            company = "Bayer Animal Health / Intas",
            mrp = 640,
            doseRateMgPerKg = 0.05, // ml/kg
            concentrationMgPerMl = 1.0,
            route = "IV / IM / SC (15-25 ml per animal)",
            clinicalUsage = "मेटाबॉलिक टॉनिक, ऊर्जा वृद्धि, लिवर पुनर्जनन",
            pregnancySafe = true
        ),
        DrugSubstituteDetail(
            id = "sub_immuplus",
            saltName = "Immunomodulator & Phyto-Active Herbal",
            brandName = "Immuplus Liquid 500ml / Restobal",
            company = "Dabur Ayurvet / Indian Herbs",
            mrp = 390,
            doseRateMgPerKg = 0.1,
            concentrationMgPerMl = 1.0,
            route = "Oral Liquid (50 ml daily)",
            clinicalUsage = "प्रतिरक्षा वृद्धि, तनाव मुक्ति, टीकाकरण पूर्व तैयारी",
            pregnancySafe = true
        ),
        DrugSubstituteDetail(
            id = "sub_meloxicam",
            saltName = "Meloxicam + Paracetamol",
            brandName = "Melonex Plus 30ml / Melox-P Vet",
            company = "Intas Pharmaceuticals",
            mrp = 145,
            doseRateMgPerKg = 0.5,
            concentrationMgPerMl = 5.0, // 5mg/ml meloxicam
            route = "Intramuscular (IM) - 100% प्रेगनेंसी सुरक्षित",
            clinicalUsage = "बुखार, सूजन, दर्द व लंगड़ापन",
            pregnancySafe = true,
            contraindicatedSpecies = listOf(Species.CAT),
            speciesSpecialWarning = "⚠️ बिल्ली (Cat) में पैरासिटामोल जानलेवा (FATAL/LETHAL) है! बिल्ली में कभी न दें।"
        ),
        DrugSubstituteDetail(
            id = "sub_flunixin",
            saltName = "Flunixin Meglumine 50mg/ml",
            brandName = "Megludyne 20ml / Flunix Vet",
            company = "Virbac Animal Health",
            mrp = 250,
            doseRateMgPerKg = 2.2,
            concentrationMgPerMl = 50.0,
            route = "Slow IV (एंटी-एंडोटॉक्सिक प्रभाव)",
            clinicalUsage = "गंभीर सेप्सिस, टॉक्सिक थनैला, आफरा व तीव्र दर्द",
            pregnancySafe = true
        )
    )

    val repeatBreederCauses: List<RepeatBreederCause> = listOf(
        RepeatBreederCause(
            id = "rb_endometritis",
            title = "1. सबक्लिनिकल एंडोमेट्राइटिस (गर्भाशय आंतरिक सूजन)",
            scientificTitle = "Subclinical Endometritis / White Discharge",
            description = "पशु बार-बार हीट में आता है परंतु ठहरता नहीं। डिस्चार्ज में हल्का मटमैलापन या सफेद डोरे दिखाई देते हैं।",
            fieldProtocol = "ए.आई. से 24 घंटे पूर्व या 24 घंटे बाद ल्यूगाल आयोडीन (1:10) या सेफप्रिन इन्ट्रा-यूटेराइन घोल डालें। 2 चक्रों तक प्राकृतिक संभोग न कराएं।",
            recommendedMedicines = listOf("Ceftiofur IU Infusion (500mg)", "Lugol's Iodine 1%", "Utrovet / Replanta Syrup 500ml"),
            durationCategory = RepeatDurationCategory.SHORT_TERM
        ),
        RepeatBreederCause(
            id = "rb_luteal_defect",
            title = "2. ल्यूटियल फेज डिफेक्ट व प्रोजेस्टेरोन की कमी",
            scientificTitle = "Luteal Phase Defect / Early Embryonic Death (EED)",
            description = "भ्रूण 16-20 दिन पर जीवित नहीं रह पाता क्योंकि कॉर्पस ल्यूटियम पर्याप्त प्रोजेस्टेरोन हार्मोन नहीं बना पाता।",
            fieldProtocol = "ए.आई. के दिन GnRH (Receptal 2.5ml IM) लगाएं। ए.आई. के 5वें दिन हाइड्रोक्सीप्रोजेस्टेरोन (Duraprogen 750mg IM) लगाएं।",
            recommendedMedicines = listOf("Buserelin Acetate (Receptal 2.5ml IM)", "Hydroxyprogesterone 750mg IM", "Vitamin E + Selenium Injections"),
            durationCategory = RepeatDurationCategory.LONG_TERM
        ),
        RepeatBreederCause(
            id = "rb_mineral_deficiency",
            title = "3. पोषक सूक्ष्म खनिज व विटामिन की कमी",
            scientificTitle = "Nutritional Trace Mineral (Cu, Zn, Co, Se) Deficiency",
            description = "तांबा, जस्ता, कोबाल्ट व विटामिन-A, E की कमी से अंडाशय निष्क्रिय (Inactive Ovaries) हो जाता है या साइलेंट हीट होती है।",
            fieldProtocol = "चीलेटेड मिनरल मिक्सचर 50 ग्राम प्रतिदिन 60 दिनों तक खिलाएं। फास्फोरस व विटामिन AD3E के 3 इंजेक्शन 7-7 दिन के अंतराल पर लगाएं।",
            recommendedMedicines = listOf("Chelated Agrimin Forte (50g daily)", "Tonophosphan / Fostone 10ml IM", "Intavita / Vit-AD3E Injection"),
            durationCategory = RepeatDurationCategory.SHORT_TERM
        ),
        RepeatBreederCause(
            id = "rb_delayed_ovulation",
            title = "4. देर से अंडोत्सर्जन व अत्यधिक हीट स्ट्रेस",
            scientificTitle = "Delayed Ovulation / Heat Stress Anovulation",
            description = "गर्मी के मौसम में अंडा समय पर नहीं फूटता, जब तक सीमन के शुक्राणु मर चुके होते हैं।",
            fieldProtocol = "डबल ए.आई. प्रोटोकॉल अपनाएं: पहली ए.आई. हीट दिखने के 12 घंटे बाद तथा दूसरी ए.आई. 24 घंटे बाद। ए.आई. के समय सिर पर ठंडा पानी डालें।",
            recommendedMedicines = listOf("Double AI Schedule (12h + 24h)", "Chorulon (hCG 1500 IU IM)", "Electrolyte & Betaine Coolers"),
            durationCategory = RepeatDurationCategory.SHORT_TERM
        ),
        RepeatBreederCause(
            id = "rb_pyometra",
            title = "5. क्रोनिक पायोमेट्रा व गर्भाशय ग्रीवा सूजन",
            scientificTitle = "Chronic Pyometra / Cervicitis / Salpingitis",
            description = "गर्भाशय में पुराना मवाद भरा रहता है। ग्रीवा (Cervix) सूजी व लाल होती है, जिससे शुक्राणु आगे नहीं बढ़ पाते।",
            fieldProtocol = "PGF2alpha (Cloprostenol 2ml IM) लगाएं ताकि गर्भाशय का मुंह खुले और मवाद बाहर निकले। इसके बाद 3 दिन तक एंटीबायोटिक वॉश दें।",
            recommendedMedicines = listOf("Pragma / Lutalyse 2ml IM (PGF2a)", "Excenel IU Wash 3 Days", "Septomax Bolus (Uterine Cleanser)"),
            durationCategory = RepeatDurationCategory.LONG_TERM
        ),
        RepeatBreederCause(
            id = "rb_bull_semen",
            title = "6. सीमन स्ट्रॉ की खराब गुणवत्ता व गलत ए.आई. तकनीक",
            scientificTitle = "Substandard Semen Motility / Incorrect AI Placement",
            description = "खराब लिक्विड नाइट्रोजन लेवल, गलत थॉइंग (37°C पर 30 सेकंड न करना) या गन को सर्विक्स के बॉडी में न रखना।",
            fieldProtocol = "हमेशा प्रमाणित A-ग्रेड सीमन स्ट्रॉ (Conception Rate >60%) का चयन करें। थॉइंग तापमान डिजिटल थर्मामीटर से 37°C सुनिश्चित करें।",
            recommendedMedicines = listOf("A-Grade Progeny Tested Semen", "Digital Thawing Monitor (37°C/30s)", "Mid-Cervical Gun Deposition"),
            durationCategory = RepeatDurationCategory.SHORT_TERM
        )
    )

    val farmerDiseaseDirectory: List<FarmerDiseaseItem> = listOf(
        // ==========================================
        // CATEGORY 1: HEAD & NERVOUS (🧠 सिर व तंत्रिका)
        // ==========================================
        FarmerDiseaseItem(
            id = "fd_fmd",
            nameHindi = "खुरपका-मुंहपका (FMD)",
            nameScientific = "Aphthovirus (Foot & Mouth Disease)",
            desiNames = "खुरहा, मुंहपका, रपका, बादी",
            rootCauseType = "अति-संक्रामक विषाणु (Aphthovirus)",
            clinicalSigns = listOf("मुंह से तार की तरह लगातार लार टपकना", "जीभ, मसूड़ों व खुरों के बीच में दर्दनाक छाले", "तेज बुखार व अत्यधिक लंगड़ापन"),
            stagesTimeline = listOf(
                "पहला चरण (1-2 दिन): 104-106°F बुखार, मुंह से तार जैसी लार का जमीन तक लटकना।",
                "दूसरा चरण (3-5 दिन): जीभ व खुरों के छालों का फूटना, चमड़ी उतरना व लंगड़ाना।",
                "तीसरा चरण (6-10 दिन): खुरों में कीड़े (Maggots) पड़ने का खतरा, दुग्ध उत्पादन 80% घटना।"
            ),
            homeRemedies = listOf(
                "फिटकरी 2% या लाल दवा (KMNO4) के हल्के घोल से दिन में 3 बार मुंह व खुरों को धोएं।",
                "खुरों के घावों पर बोरिक एसिड व सरसों का तेल मिलाकर लेप करें।",
                "पशु को मुलायम दलिया, गुड़ व ठंडा चारा ही दें।"
            ),
            urgentAction = "घावों पर कीड़े मारने का स्प्रे करें व सेकंडरी संक्रमण रोकने हेतु एंटीबायोटिक लगवाएं।",
            anatomicalCategory = "HEAD_NERVOUS"
        ),
        FarmerDiseaseItem(
            id = "fd_rabies",
            nameHindi = "रेबीज / पागलपन (Hydrophobia / Rabies)",
            nameScientific = "Rabies Lyssavirus",
            desiNames = "अलर्क रोग, बावलापन, पागल कुत्ता काटना",
            rootCauseType = "रेबीज वायरस (पागल कुत्ते या सियार के काटने से)",
            clinicalSigns = listOf("अकारण रंभाना व उत्तेजना", "मुंह से झागदार लार गिरना व निगलने में असमर्थता", "पशु का दीवार से सिर टकराना या लकवाग्रस्त होना"),
            stagesTimeline = listOf(
                "पहला चरण (0-2 दिन): व्यवहार में अचानक बदलाव, बेचैनी, बार-बार रंभाना।",
                "दूसरा चरण (2-4 दिन): मुंह से प्रचुर लार गिरना, आंखें चौड़ी, पानी व चारे से डर।",
                "तीसरा चरण (4-7 दिन): पिछले धड़ का लकवा, कोमा व शत-प्रतिशत मृत्यु।"
            ),
            homeRemedies = listOf(
                "काटने के तुरंत बाद घाव को बहते नल के नीचे 15 मिनट तक साबुन से धोएं।",
                "घाव पर लाल दवा (पोविडोन आयोडीन) लगाएं, कोई पट्टी न बांधें।"
            ),
            urgentAction = "काटने के 0, 3, 7, 14, 28वें दिन रेबीज का एंटी-रेबीज टीका (Raksharab) अनिवार्य लगवाएं।",
            anatomicalCategory = "HEAD_NERVOUS"
        ),
        FarmerDiseaseItem(
            id = "fd_surra",
            nameHindi = "सर्रा रोग (Surra / Trypanosomiasis)",
            nameScientific = "Trypanosoma evansi",
            desiNames = "तीबरसा, मक्खी रोग, फेरा, सर्रा",
            rootCauseType = "रक्त प्रोटोजोआ (डंस मक्खी / Tabanus fly द्वारा संचरण)",
            clinicalSigns = listOf("गोल-गोल चक्कर काटना व अंधापन", "रुक-रुक कर आने वाला 104-106°F बुखार", "तेज वजन घटना, एनीमिया व पिछले पैरों में कमजोरी"),
            stagesTimeline = listOf(
                "पहला चरण: तीव्र बुखार, सुस्ती, आंखों से पानी बहना व दूध का गिरना।",
                "दूसरा चरण: गोल-गोल चक्कर काटना, दीवारों से सिर टकराना, दांत पीसना।",
                "तीसरा चरण: जमीन पर गिरकर पैर साइकिल की तरह चलाना व मृत्यु।"
            ),
            homeRemedies = listOf(
                "बाड़े में नीम के पत्तों का धुआं करें ताकि डंस मक्खियां भाग जाएं।",
                "पशु को छायादार स्थान पर रखें व मीठा दलिया गुड़ के साथ दें।"
            ),
            urgentAction = "तुरंत Triquin / Quinapyramine sulfate + chloride या Berenil का इंजेक्शन लगवाएं।",
            anatomicalCategory = "HEAD_NERVOUS"
        ),
        FarmerDiseaseItem(
            id = "fd_lumpy_jaw",
            nameHindi = "जबड़े की हड्डी की सूजन (Lumpy Jaw)",
            nameScientific = "Actinomyces bovis",
            desiNames = "जबड़ा गांठ, हड्डी फोड़ा, मूंढसूजन",
            rootCauseType = "जीवाणु (नुकीले चारे से मुंह में चोट लगने पर हड्डी में संक्रमण)",
            clinicalSigns = listOf("निचले जबड़े की हड्डी में कठोर पत्थर जैसी सूजन", "जबड़े से सफेद मवाद का रिसाव", "चबाने में दर्द व वजन घटना"),
            stagesTimeline = listOf(
                "पहला चरण: जबड़े पर छोटी दर्दहीन हड्डी की गांठ जो हिलती नहीं।",
                "दूसरा चरण: गांठ का बड़ा होना, त्वचा से चिपकना और मवाद की नालियां बनना।",
                "तीसरा चरण: दांतों का हिलना, चारा न चबा पाना व गंभीर भुखमरी।"
            ),
            homeRemedies = listOf(
                "कठोर व कांटेदार सूखा चारा तुरंत बंद करें, बारीक गीला चारा दें।",
                "मवाद वाले घाव को पोटाश पानी से धोकर टिंचर आयोडीन लगाएं।"
            ),
            urgentAction = "पोटैशियम आयोडाइड (KI) का ओरल कोर्स व पेनिसिलिन / स्ट्रेप्टोमाइसिन इंजेक्शन दें।",
            anatomicalCategory = "HEAD_NERVOUS"
        ),
        FarmerDiseaseItem(
            id = "fd_woody_tongue",
            nameHindi = "लकड़ी जैसी सख्त जीभ (Woody Tongue)",
            nameScientific = "Actinobacillus lignieresii",
            desiNames = "काठ जीभ, जीभ सूजन, लकड़ी जीभ",
            rootCauseType = "जीवाणु (Actinobacillus - जीभ के कोमल ऊतकों में संक्रमण)",
            clinicalSigns = listOf("जीभ का लकड़ी की तरह सख्त व मोटी हो जाना", "जीभ का मुंह से बाहर लटके रहना व लार टपकना", "चारा अंदर खींचने में पूरी असमर्थता"),
            stagesTimeline = listOf(
                "पहला चरण: जीभ पर छोटी दर्दनाक गांठें व मुंह से प्रचुर लार टपकना।",
                "दूसरा चरण: जीभ का फूलना, सख्त होना व बाहर लटकना, खाना बंद।",
                "तीसरा चरण: गंभीर कमजोरी, जबड़े के नीचे लिम्फ नोड्स में सूजन।"
            ),
            homeRemedies = listOf(
                "गुनगुने नमक के पानी से जीभ को धोएं।",
                "पशु को पतला दलिया व गुड़ का शरबत नाल द्वारा पिलाएं।"
            ),
            urgentAction = "सोडियम आयोडाइड 10% IV इन्फ्यूजन व एमोक्सिसिलिन इंजेक्शन तुरंत दिलवाएं।",
            anatomicalCategory = "HEAD_NERVOUS"
        ),
        FarmerDiseaseItem(
            id = "fd_calf_diphtheria",
            nameHindi = "बछड़ों का डिप्थीरिया (Calf Diphtheria)",
            nameScientific = "Fusobacterium necrophorum",
            desiNames = "गला घोंटनी, मुंह सड़न, तालू घाव",
            rootCauseType = "एनारोबिक जीवाणु (गंदे दूध के बर्तनों व बाड़े की नमी से)",
            clinicalSigns = listOf("मुंह व तालू पर पीले-सफेद बदबूदार छाले", "गले में घरघराहट व सांस लेने में कठिनाई", "104°F बुखार व दूध पीने से इनकार"),
            stagesTimeline = listOf(
                "पहला चरण: बछड़ा दूध नहीं पीता, मुंह से दुर्गंध आती है, हल्का बुखार।",
                "दूसरा चरण: गाल व तालू पर मोटे पीले छिलके, सांस लेने में जोर लगाना।",
                "तीसरा चरण: फेफड़ों तक संक्रमण फैलकर न्यूमोनिया से मृत्यु।"
            ),
            homeRemedies = listOf(
                "दूध पिलाने की बाल्टी व निप्पल को उबलते पानी से धोएं।",
                "मुंह के छालों पर ग्लिसरीन में बोरिक एसिड मिलाकर लेप लगाएं।"
            ),
            urgentAction = "Sulfadimidine 33.3% या Oxytetracycline का 3 दिन का कोर्स डॉक्टर से कराएं।",
            anatomicalCategory = "HEAD_NERVOUS"
        ),
        FarmerDiseaseItem(
            id = "fd_nervous_ketosis",
            nameHindi = "नर्वस कीटोसिस (Nervous Ketosis)",
            nameScientific = "Bovine Ketosis (Nervous Form)",
            desiNames = "पागल कीटोसिस, बावली गाय, अंधापन दौरा",
            rootCauseType = "गंभीर ऊर्जा असंतुलन (Negative Energy Balance) व कीटोन बॉडीज का मस्तिष्क पर असर",
            clinicalSigns = listOf("अंधाधुंध आगे भागना व दीवार चाटना", "दांत किटकिटाना, जीभ लगातार बाहर निकालना", "दूध व सांस से पके सेब/नेल पॉलिश जैसी मीठी गंध"),
            stagesTimeline = listOf(
                "पहला चरण: दूध में अचानक 50% कमी, दाना खाना बंद, केवल सूखा चारा खाना।",
                "दूसरा चरण: दांत पीसना, बाड़े की लोहे की जाली व खूंटा चाटना, कंपकंपी।",
                "तीसरा चरण: अंधापन, लड़खड़ाहट, जमीन पर गिरना।"
            ),
            homeRemedies = listOf(
                "पशु को गुड़ 500 ग्राम + मीठा सोडा 100 ग्राम तुरंत पानी में घोलकर पिलाएं।",
                "प्रोपिलीन ग्लाइकोल (Propylene Glycol) 250ml दिन में दो बार 4 दिन दें।"
            ),
            urgentAction = "Dextrose 25% या 50% (1-2 लीटर IV) व Catosal / Mifex का इंजेक्शन लगवाएं।",
            anatomicalCategory = "HEAD_NERVOUS"
        ),
        FarmerDiseaseItem(
            id = "fd_grass_tetany",
            nameHindi = "ग्रास टेटनी / मैग्नीशियम की कमी (Grass Tetany)",
            nameScientific = "Hypomagnesemia",
            desiNames = "घास मिर्गी, कंपकंपी रोग, हरी घास दौरा",
            rootCauseType = "मैग्नीशियम (Mg) की भारी कमी (अत्यधिक रसीली हरी घास चरने से)",
            clinicalSigns = listOf("कान खड़े, आंखें फटी हुई व अत्यधिक घबराहट", "पैर पटकना, मांसपेशियों में तीव्र ऐंठन", "जरा सी आहट पर चौंक कर गिर पड़ना"),
            stagesTimeline = listOf(
                "पहला चरण: झुंड से अलग खड़े रहना, कान सीधे, असामान्य सतर्कता।",
                "दूसरा चरण: पैर पटकना, लड़खड़ाकर चलना, पेशाब-गोबर बार-बार करना।",
                "तीसरा चरण: जमीन पर गिरकर झटके आना, सिर पीछे मुड़ना, 2 घंटे में मृत्यु का खतरा।"
            ),
            homeRemedies = listOf(
                "रसीली हरी घास से पशु को तुरंत हटाकर सूखा भूसा दें।",
                "पशु के पास शोरगुल बिल्कुल न होने दें।"
            ),
            urgentAction = "Calcium Borogluconate with Magnesium (Mifex 450ml) अत्यंत धीमी गति से IV लगवाएं।",
            anatomicalCategory = "HEAD_NERVOUS"
        ),

        // ==========================================
        // CATEGORY 2: THROAT & CHEST (🫁 गला व छाती)
        // ==========================================
        FarmerDiseaseItem(
            id = "fd_hs",
            nameHindi = "गलघोंटू (Hemorrhagic Septicemia - HS)",
            nameScientific = "Pasteurella multocida Infection",
            desiNames = "घुर्रका, गलघोंटू, कंठसूज, घोटू",
            rootCauseType = "जीवाणु (Pasteurella - वर्षा ऋतु में नमी व तनाव से तेज प्रसार)",
            clinicalSigns = listOf("गले व सीने में अत्यधिक गर्म व दर्दनाक सूजन", "घुर्र-घुर्र की तेज आवाज के साथ जीभ बाहर निकाल कर सांस लेना", "106-107°F तेज बुखार व आंखें लाल"),
            stagesTimeline = listOf(
                "पहला चरण (0-6 घंटे): अचानक 106°F बुखार, खाना-पीना व जुगाली बंद, सुस्त खड़े रहना।",
                "दूसरा चरण (6-18 घंटे): गले के नीचे गर्म भारी सूजन, लार टपकना, घुर्र-घुर्र सांस।",
                "तीसरा चरण (18-24 घंटे): दम घुटने से पशु का गिर पड़ना, आपातकालीन मृत्यु का भारी खतरा।"
            ),
            homeRemedies = listOf(
                "गले की सूजन पर गर्म सेंक कभी न करें (इससे सूजन और फैलती है)।",
                "पशु को हवादार खुले शेड में रखें और तुरंत अन्य पशुओं से अलग करें।"
            ),
            urgentAction = "यह एक मेडिकल इमरजेंसी है! 2 घंटे के भीतर Cef-Tazo / Sulpha injection व Flunixin लगवाएं।",
            anatomicalCategory = "THROAT_CHEST"
        ),
        FarmerDiseaseItem(
            id = "fd_brd",
            nameHindi = "बोवाइन रेस्पिरेटरी डिजीज (BRD / निमोनिया)",
            nameScientific = "Bovine Respiratory Disease Complex (Mannheimia)",
            desiNames = "छाती जमना, फेफड़ा सूजन, सूखी खांसी, पसली चलना",
            rootCauseType = "मिश्रित वायरल व बैक्टीरियल संक्रमण (सर्दी, परिवहन व धूल से)",
            clinicalSigns = listOf("पसलियों का तेजी से धौंकनी की तरह चलना", "गहरी दर्दनाक खांसी व नाक से गाढ़ा पीला मवाद बहना", "104-105°F लगातार बुखार व भूख न लगना"),
            stagesTimeline = listOf(
                "पहला चरण: नाक से साफ पानी, हल्का बुखार, सुस्ती, कभी-कभार खांसी।",
                "दूसरा चरण: नाक से गाढ़ा पीला कफ, पसलियां चलना, मुंह खोलकर सांस।",
                "तीसरा चरण: फेफड़ों का स्थायी कंसॉलिडेशन, गंभीर दमा जैसी स्थिति।"
            ),
            homeRemedies = listOf(
                "तुलसी + अदरक + काली मिर्च + गुड़ का काढ़ा गुनगुना पिलाएं।",
                "बाड़े में नीलगिरी (Eucalyptus) तेल की भाप दें।"
            ),
            urgentAction = "Florfenicol (Nuflor 300mg/ml) या Ceftiofur Sodium + Meloxicam इंजेक्शन दिलवाएं।",
            anatomicalCategory = "THROAT_CHEST"
        ),
        FarmerDiseaseItem(
            id = "fd_tb",
            nameHindi = "तपेदिक / टीबी (Bovine Tuberculosis)",
            nameScientific = "Mycobacterium bovis",
            desiNames = "क्षय रोग, पुरानी खांसी, सोखा रोग",
            rootCauseType = "एसिड-फास्ट जीवाणु (दूषित हवा व दूध द्वारा फैलने वाला जूनोटिक रोग)",
            clinicalSigns = listOf("महीनों तक चलने वाली पुरानी सूखी खांसी", "अच्छा खाना खाने के बावजूद शरीर का कंकाल बन जाना", "गले व फेफड़ों की ग्रंथियों (Lymph nodes) में सूजन"),
            stagesTimeline = listOf(
                "पहला चरण: कभी-कभी खांसी, सुबह के समय हल्की घरघराहट, दूध में मंद गिरावट।",
                "दूसरा चरण: पसलियां दिखना, खांसी बार-बार आना, आंखें धंसना।",
                "तीसरा चरण: अत्यधिक क्षीणता (Emaciation), सांस लेने में जोर, असाध्य स्थिति।"
            ),
            homeRemedies = listOf(
                "रोगग्रस्त पशु का कच्चा दूध इंसानों या बछड़ों को कभी न पिलाएं (उबालना अनिवार्य)।",
                "पशु को सूखे, धूप वाले शेड में रखें।"
            ),
            urgentAction = "सरकारी पशु चिकित्सालय में ट्यूबरकुलिन टेस्ट (SID Test) करवाएं।",
            anatomicalCategory = "THROAT_CHEST"
        ),
        FarmerDiseaseItem(
            id = "fd_lungworms",
            nameHindi = "फेफड़ों के कृमि / कीड़े (Lungworm Disease)",
            nameScientific = "Dictyocaulus viviparus",
            desiNames = "कफ कीड़े, फेफड़ा सूंडी, बरसाती खांसी",
            rootCauseType = "गोल परजीवी कृमि (गीले चरागाह से लार्वा खाने से फेफड़ों में पहुंचते हैं)",
            clinicalSigns = listOf("गर्दन आगे खींचकर लगातार खांसना", "सांस लेते समय सीने से सीटी जैसी आवाज", "तेजी से वजन घटना व कमजोरी"),
            stagesTimeline = listOf(
                "पहला चरण: चरागाह से लौटने के बाद बछड़ों में हल्की सूखी खांसी।",
                "दूसरा चरण: गंभीर खांसी के दौरे, जीभ बाहर निकालना, झागदार थूक।",
                "तीसरा चरण: सांस की नली में कीड़ों का गुच्छा फंसने से दम घुटना।"
            ),
            homeRemedies = listOf(
                "गीले व दलदली चरागाहों में पशुओं को चरने से रोकें।",
                "साफ कुएं या नलके का ताजा पानी ही पिलाएं।"
            ),
            urgentAction = "Fenbendazole (10mg/kg) या Ivermectin 1% SC इंजेक्शन तुरंत लगवाएं।",
            anatomicalCategory = "THROAT_CHEST"
        ),
        FarmerDiseaseItem(
            id = "fd_ccpp",
            nameHindi = "बकरियों का संक्रामक निमोनिया (CCPP)",
            nameScientific = "Contagious Caprine Pleuropneumonia (Mycoplasma)",
            desiNames = "बकरी फेफड़ा, घुर्रकी, छाती दर्द",
            rootCauseType = "माइकोप्लाज्मा (Mycoplasma capricolum - अत्यधिक संक्रामक)",
            clinicalSigns = listOf("बकरी का दर्द के कारण खांसते समय कराहना", "नाक से गाढ़ा मवाद व मुंह से लार", "तेज बुखार व एक तरफ लेट जाना"),
            stagesTimeline = listOf(
                "पहला चरण: 105°F बुखार, झुंड से पीछे छूटना, चारा न खाना।",
                "दूसरा चरण: दर्दनाक खांसी, सीने पर हाथ लगाने पर कराहना, हांफना।",
                "तीसरा चरण: फेफड़ों में पानी भरना (Pleural effusion), 48 घंटे में भारी मृत्यु दर।"
            ),
            homeRemedies = listOf(
                "बीमार बकरियों को तुरंत बाकी रेवड़ से 50 मीटर दूर अलग करें।",
                "रात को ठंड व ठंडी हवा से बचाने हेतु टाट के बोरे से शेड ढकें।"
            ),
            urgentAction = "Tylosin 200mg/ml या Enrofloxacin इंजेक्शन 3 दिन तक तुरंत लगवाएं।",
            anatomicalCategory = "THROAT_CHEST"
        ),
        FarmerDiseaseItem(
            id = "fd_ibr",
            nameHindi = "संक्रामक बोवाइन राइनोट्रैकाइटिस (IBR)",
            nameScientific = "Bovine Herpesvirus-1 (BHV-1)",
            desiNames = "लाल नाक रोग, लाल नथुना, श्वास ज्वर",
            rootCauseType = "हर्पीस वायरस (BHV-1 - सांस व सीमन द्वारा फैलता है)",
            clinicalSigns = listOf("नथुने का अत्यधिक लाल व सूजा होना (Red Nose)", "आंखों से पानी बहना व कॉर्निया पर धुंधलापन", "तेज बुखार, छींकें व गाभिन गायों में गर्भपात"),
            stagesTimeline = listOf(
                "पहला चरण: नथुने लाल, 105°F बुखार, छींकना व पारदर्शी नाक स्राव।",
                "दूसरा चरण: नथुने पर छाले व पपड़ी, आंखों में कंजंक्टिवाइटिस, दूध गिरना।",
                "तीसरा चरण: गाभिन पशुओं में 6-8 माह पर अचानक गर्भपात।"
            ),
            homeRemedies = listOf(
                "नथुनों को बोरिक एसिड पानी से साफ करें।",
                "आंखों में सिप्रोफ्लोक्सासिन आई ड्रॉप दिन में 3 बार डालें।"
            ),
            urgentAction = "प्रतिरक्षा बढ़ाने हेतु Immuplus लिक्विड व द्वितीयक संक्रमण रोकने हेतु सेफ्टिओफर दें।",
            anatomicalCategory = "THROAT_CHEST"
        ),
        FarmerDiseaseItem(
            id = "fd_trp",
            nameHindi = "लोहे की कील व छाती सूजन (Hardware Disease / TRP)",
            nameScientific = "Traumatic Reticuloperitonitis",
            desiNames = "कील रोग, तार चुभना, जाल रोग, छाती सूजन",
            rootCauseType = "चारे के साथ लोहे का तार या कील निगलना जो पेट चीरकर दिल तक पहुंचती है",
            clinicalSigns = listOf("पीठ कूबड़ की तरह ऊपर उठाकर खड़ा होना", "हृदय के पास सीने व गलकंबल में स्पंज जैसी सूजन", "कराहते हुए गोबर-पेशाब करना व जुगाली बंद"),
            stagesTimeline = listOf(
                "पहला चरण: अचानक दूध कम, चलने में संकोच, हल्का बुखार, चारा छोड़ना।",
                "दूसरा चरण: छाती के निचले हिस्से (Brisket) में पानी भरना, जुगुलर नस मोटी होना।",
                "तीसरा चरण: कील के दिल की झिल्ली (Pericardium) में घुसने से हृदयाघात व मृत्यु।"
            ),
            homeRemedies = listOf(
                "पशु को आगे से ऊंचे ढलान वाले फर्श पर बांधें ताकि कील पीछे खिसके।",
                "चारे को शक्तिशाली चुंबक से साफ करके ही खिलाएं।"
            ),
            urgentAction = "रूमेन मैग्नेट (Rumen Magnet) निगलवाएं या पशु चिकित्सक से सर्जरी (Rumenotomy) कराएं।",
            anatomicalCategory = "THROAT_CHEST"
        ),

        // ==========================================
        // CATEGORY 3: ABDOMEN & DUNG (🥣 पेट व गोबर)
        // ==========================================
        FarmerDiseaseItem(
            id = "fd_bloat",
            nameHindi = "आफरा व पेट में गैस (Frothy Bloat / Tympany)",
            nameScientific = "Acute Ruminal Tympany",
            desiNames = "आफरा, पेट फूलना, दम घुटना, बदहजमी",
            rootCauseType = "पाचन विकार (अत्यधिक गीला बरसीम या सड़ा दाना खाने से झाग बनना)",
            clinicalSigns = listOf("बाईं कोख ढोलक की तरह ऊपर फूल जाना", "मुंह खोलकर जीभ बाहर निकाल कर हांफना", "बेचैनी, बार-बार उठना-बैठना व पेट पर लात मारना"),
            stagesTimeline = listOf(
                "पहला चरण (0-1 घंटा): बाईं कोख में उभार, जुगाली बंद, बेचैनी।",
                "दूसरा चरण (1-3 घंटे): पेट अत्यधिक फूलना, डायाफ्राम पर दबाव से सांस में भारी रुकावट।",
                "तीसरा चरण (3+ घंटे): पशु का गिर पड़ना, मुंह से नीला फेन, दम घुटने का तात्कालिक खतरा।"
            ),
            homeRemedies = listOf(
                "सरसों का तेल 250ml + हींग 20g + तारपीन का तेल 30ml मिलाकर तुरंत नाल द्वारा पिलाएं।",
                "पशु के मुंह में आड़ा लकड़ी का डंडा बांधें ताकि झागदार लार बाहर निकले।",
                "पशु को आगे से ऊंचे स्थान पर खड़ा रखें ताकि फेफड़ों पर दबाव घटे।"
            ),
            urgentAction = "गंभीर स्थिति में ट्रॉकर-कैनुला द्वारा बाईं कोख से तुरंत गैस निकालें व Bloatosil दें।",
            anatomicalCategory = "ABDOMEN_DUNG"
        ),
        FarmerDiseaseItem(
            id = "fd_acidosis",
            nameHindi = "रूमेन एसिडोसिस / खट्टा पेट (Grain Overload)",
            nameScientific = "Acute Ruminal Lactic Acidosis",
            desiNames = "अनाज बदहजमी, खट्टा पानी, दाना चरना, दलिया आफरा",
            rootCauseType = "अत्यधिक गेहूं, चावल, आटा या गुड़ खा लेना (pH < 5.0 गिरना)",
            clinicalSigns = listOf("पतला बदबूदार खट्टा पानी जैसा दस्त", "पेट से पानी छलकने की आवाज आना", "पशु का सुस्त होकर सिर जमीन पर टिका लेना व लड़खड़ाहट"),
            stagesTimeline = listOf(
                "पहला चरण (2-6 घंटे): दाना चरने के बाद सुस्ती, जुगाली बंद, पेट में भारीपन।",
                "दूसरा चरण (6-18 घंटे): पानी जैसा खट्टा दस्त, निर्जलीकरण, आंखें धंसना, लड़खड़ाहट।",
                "तीसरा चरण (18-24 घंटे): टॉक्सिक शॉक, कोमा व गुर्दे फेल होने से मृत्यु।"
            ),
            homeRemedies = listOf(
                "मीठा सोडा (Sodium Bicarbonate) 100-150g गुनगुने पानी में घोलकर तुरंत पिलाएं।",
                "पशु को दाना, चोकर व हरा चारा बिल्कुल न दें, केवल सूखा भूसा दें।"
            ),
            urgentAction = "Sodium Bicarbonate 1.4% या 5% IV इन्फ्यूजन व पेट की धुलाई (Gastric Lavage) कराएं।",
            anatomicalCategory = "ABDOMEN_DUNG"
        ),
        FarmerDiseaseItem(
            id = "fd_alkalosis",
            nameHindi = "रूमेन एल्केलोसिस (Ruminal Alkalosis)",
            nameScientific = "Ruminal Alkalosis (Urea Toxicity / Basic pH)",
            desiNames = "यूरिया विषाक्तता, क्षारीय आफरा, झागदार उल्टी",
            rootCauseType = "यूरिया खाद खा लेना या प्रोटीन की अत्यधिक अधिकता (pH > 7.5 होना)",
            clinicalSigns = listOf("मुंह से सफेद झाग व लार बहना", "मांसपेशियों में तेज कंपकंपी व पेट में दर्द", "सांस फूलना व गोल चक्कर काटना"),
            stagesTimeline = listOf(
                "पहला चरण (15-30 मिनट): बेचैनी, बार-बार पेशाब, कान फड़कना।",
                "दूसरा चरण (30-60 मिनट): पेट फूलना, मुंह से झाग, लड़खड़ाकर गिरना।",
                "तीसरा चरण: गंभीर सांस अवरोध व आधे घंटे में आकस्मिक मृत्यु।"
            ),
            homeRemedies = listOf(
                "सिरका (Vinegar / Acetic acid) 1 से 2 लीटर ठंडे पानी में घोलकर तुरंत पिलाएं।",
                "सिरका न होने पर 20-25 नींबू का रस 2 लीटर ठंडे पानी में मिलाकर दें।"
            ),
            urgentAction = "ठंडे पानी से पेट की सिकाई करें व तुरंत IV ग्लूकोज व सेलाइन लगवाएं।",
            anatomicalCategory = "ABDOMEN_DUNG"
        ),
        FarmerDiseaseItem(
            id = "fd_calf_scours",
            nameHindi = "बछड़ों के सफेद दस्त (White Scours)",
            nameScientific = "Colibacillosis (E. coli Infection)",
            desiNames = "बछड़ा दस्त, सफेद हगना, दूध दस्त, पेचिश",
            rootCauseType = "ई. कोलाई जीवाणु (जन्म के बाद समय पर खीस/Colostrum न मिलना)",
            clinicalSigns = listOf("सफेद या पीला बदबूदार पानी जैसा दस्त", "आंखें अंदर धंसना व त्वचा का ढीला पड़ना", "बछड़े का उठ न पाना व अत्यधिक ठंड लगना"),
            stagesTimeline = listOf(
                "पहला चरण: बछड़ा दूध नहीं पीता, पूंछ व जांघों पर पीला चिपचिपा गोबर।",
                "दूसरा चरण: लगातार सफेद पानी का रिसाव, शरीर ठंडा पड़ना, आंखें धंसना।",
                "तीसरा चरण: निर्जलीकरण (Dehydration) से बछड़े का कोमा में जाना व मृत्यु।"
            ),
            homeRemedies = listOf(
                "ORS का घोल (इलेक्ट्रोलाइट) 1-1 लीटर दिन में 3-4 बार गुनगुना पिलाएं।",
                "बछड़े को गर्म व सूखे बिछावन (पुआल) पर रखें।"
            ),
            urgentAction = "Gentamicin या Enrofloxacin इंजेक्शन व Ringers Lactate (RL) IV लगवाएं।",
            anatomicalCategory = "ABDOMEN_DUNG"
        ),
        FarmerDiseaseItem(
            id = "fd_coccidiosis",
            nameHindi = "खूनी दस्त / कॉक्सीडियोसिस (Coccidiosis)",
            nameScientific = "Eimeria bovis / Eimeria zurnii",
            desiNames = "खूनी पेचिश, लाल दस्त, आंत मरोड़, कुंथन",
            rootCauseType = "आंतों का प्रोटोजोआ (दूषित पानी व कीचड़युक्त फर्श से संक्रमण)",
            clinicalSigns = listOf("गोबर में गहरे लाल खून के थक्के व आंतों की झिल्ली आना", "गोबर करते समय अत्यधिक जोर लगाना (Tenesmus)", "तेज दर्द से पेट पर लात मारना व एनीमिया"),
            stagesTimeline = listOf(
                "पहला चरण: पतला मटमैला दस्त, हल्का बुखार, भूख में कमी।",
                "दूसरा चरण: गोबर में चमकीला लाल खून व बलगम, बार-बार पूंछ उठाना।",
                "तीसरा चरण: खून की भारी कमी, गुदा बाहर निकलना (Prolapse) व मृत्यु।"
            ),
            homeRemedies = listOf(
                "अनार के छिलके का काढ़ा + बेल का गूदा पीसकर छाछ के साथ पिलाएं।",
                "बाड़े के फर्श को चूना छिड़ककर सूखा रखें।"
            ),
            urgentAction = "Amprolium पाउडर (10mg/kg) या सल्फा डिमिडीन (Sulphadimidine Bolus) 5 दिन दें।",
            anatomicalCategory = "ABDOMEN_DUNG"
        ),
        FarmerDiseaseItem(
            id = "fd_jd",
            nameHindi = "जोहन्स रोग / पुराना पतला गोबर (Johne's Disease - JD)",
            nameScientific = "Mycobacterium avium paratuberculosis (MAP)",
            desiNames = "सूखा रोग, पुराना हगना, लकड़ी रोग, क्षय पेचिश",
            rootCauseType = "एसिड-फास्ट जीवाणु (आंतों की दीवार को स्थायी रूप से मोटी व खराब करना)",
            clinicalSigns = listOf("महीनों तक बिना किसी बुखार के लगातार पतला हरा गोबर", "अच्छा दाना-चारा खाने पर भी शरीर की केवल हड्डियां बचना", "जबड़े के नीचे पानी की थैली जैसी सूजन (Bottle Jaw)"),
            stagesTimeline = listOf(
                "पहला चरण: गोबर कभी पतला कभी ठीक, दूध उत्पादन में धीरे-धीरे गिरावट।",
                "दूसरा चरण: लगातार पाइप की तरह पतला गोबर, पसलियां व कूल्हे की हड्डियां चमकना।",
                "तीसरा चरण: जबड़े के नीचे सूजन (Edema), चलने में असमर्थता व अंततः मृत्यु।"
            ),
            homeRemedies = listOf(
                "इस रोग का कोई घरेलू इलाज नहीं है, पशु को अन्य स्वस्थ पशुओं से तुरंत अलग करें।",
                "गोबर को बाड़े से दूर गड्ढे में दबाएं ताकि बछड़े संक्रमित न हों।"
            ),
            urgentAction = "पशु चिकित्सक से एलिसा (ELISA) टेस्ट करवाएं व सहायक उपचार लें।",
            anatomicalCategory = "ABDOMEN_DUNG"
        ),
        FarmerDiseaseItem(
            id = "fd_liver_fluke",
            nameHindi = "लिवर फ्लूक / कलेजे के कीड़े (Fascioliasis)",
            nameScientific = "Fasciola gigantica",
            desiNames = "पित्त कीड़े, कलेजा रोग, गलसूजा, पोंक",
            rootCauseType = "चपटे पत्ती जैसे परजीवी कृमि (घोंघों/Snails वाले तालाब व नहर के किनारे चरने से)",
            clinicalSigns = listOf("निचले जबड़े के नीचे नरम ठंडी सूजन (Bottle Jaw)", "भूख न लगना, एनीमिया व पीलिया के लक्षण", "लगातार दस्त व ऊन/बालों का रूखा होकर झड़ना"),
            stagesTimeline = listOf(
                "पहला चरण: सुस्ती, आंख की झिल्ली सफेद होना, दूध की मात्रा घटना।",
                "दूसरा चरण: जबड़े के नीचे लटकती सूजन, पेट का नीचे लटकना, कमजोरी।",
                "तीसरा चरण: लिवर सिरोसिस, गंभीर पीलिया व आंतरिक रक्तस्राव से मृत्यु।"
            ),
            homeRemedies = listOf(
                "पशुओं को तालाबों या रुके हुए पानी के किनारे कभी न चरने दें।",
                "तालाब के घोंघे नष्ट करने हेतु कॉपर सल्फेट का छिड़काव करें।"
            ),
            urgentAction = "Oxyclozanide + Levamisole (Lemasol / Nilzan) या Triclabendazole सिरप पिलाएं।",
            anatomicalCategory = "ABDOMEN_DUNG"
        ),
        FarmerDiseaseItem(
            id = "fd_amphistomiasis",
            nameHindi = "पेट के जोंक / एम्फिस्टोमियासिस (Amphistomiasis)",
            nameScientific = "Paramphistomum cervi",
            desiNames = "पेट की जोंक, बरसाती दस्त, जोंकड़ा, आंत फोड़ा",
            rootCauseType = "रूमेन व आंतों के परजीवी (युवा फ्लूक आंत की दीवार को छलनी करते हैं)",
            clinicalSigns = listOf("गंभीर बदबूदार पानी जैसा काला-हरा दस्त", "अत्यधिक प्यास लगना व बार-बार पानी मांगना", "गले के नीचे भारी पानी की सूजन व तीव्र कमजोरी"),
            stagesTimeline = listOf(
                "पहला चरण: अचानक गंभीर पतला दस्त, भूख बंद, पानी बहुत पीना।",
                "दूसरा चरण: आंखें धंसना, जबड़े के नीचे 'बॉटल जॉ' सूजन, खड़ा न हो पाना।",
                "तीसरा चरण: आंतों के कटने से आंतों का छिद्रण व 3-5 दिन में मृत्यु।"
            ),
            homeRemedies = listOf(
                "पशु को चावल का मांड + नमक व सौंफ का पानी पिलाएं।",
                "ताजे हरे चारे के बजाय 4 दिन तक केवल सूखा ज्वार/बाजरा कुट्टी दें।"
            ),
            urgentAction = "Oxyclozanide की उच्च खुराक (20mg/kg) डॉक्टर की देखरेख में तुरंत दें।",
            anatomicalCategory = "ABDOMEN_DUNG"
        ),
        FarmerDiseaseItem(
            id = "fd_roundworms",
            nameHindi = "पेट के कीड़े / गोल कृमि (Roundworms / Ascariasis)",
            nameScientific = "Neoascaris vitulorum",
            desiNames = "पेट के कीड़े, केंचुआ रोग, चुनचुने, सूंडी",
            rootCauseType = "आंतों के बड़े गोल कीड़े (मां के दूध या दूषित मिट्टी से बछड़ों में संक्रमण)",
            clinicalSigns = listOf("बछड़े का पेट मटके की तरह गोल फूलना", "बाल रूखे, खड़े व चमक गायब होना", "सांस व गोबर से मिट्टी या खट्टी बदबू आना"),
            stagesTimeline = listOf(
                "पहला चरण: बछड़े का वजन न बढ़ना, मिट्टी व दीवार चाटना, सुस्ती।",
                "दूसरा चरण: पेट मटके जैसा फूलना, कभी दस्त कभी कब्ज, गोबर में सफेद केंचुए दिखना।",
                "तीसरा चरण: आंत में कीड़ों का गुच्छा फंसकर आंत फटना (Intestinal rupture)।"
            ),
            homeRemedies = listOf(
                "बायबिडंग (Vidanga) 20g + हींग 5g गुड़ में मिलाकर बछड़े को खिलाएं।",
                "कद्दू के बीज का चूर्ण (Pumpkin seed powder) छाछ के साथ दें।"
            ),
            urgentAction = "Albendazole (Valbazen) या Piperazine liquid जन्म के 15वें व 30वें दिन अवश्य पिलाएं।",
            anatomicalCategory = "ABDOMEN_DUNG"
        ),

        // ==========================================
        // CATEGORY 4: UDDER & MILK (🥛 लेवटी व थन)
        // ==========================================
        FarmerDiseaseItem(
            id = "fd_acute_mastitis",
            nameHindi = "तीव्र थनैला (Acute Clinical Mastitis)",
            nameScientific = "Bovine Mastitis (Coliform / Staphylococcal)",
            desiNames = "गरम थनैला, थन सूजन, दूध फटाव, गादी पकना",
            rootCauseType = "जीवाणु (थनों के छिद्र से गंदे फर्श के रोगाणुओं का अंदर जाना)",
            clinicalSigns = listOf("एक या अधिक थन का पत्थर जैसा सख्त, लाल व अत्यंत गर्म होना", "दूध की जगह पीला पानी, खून या दही जैसे बदबूदार थक्के निकलना", "गाय को थन या लेवटी छूने न देना व लात मारना"),
            stagesTimeline = listOf(
                "पहला चरण (0-12 घंटे): थन में हल्की गर्माहट, दूध में बारीक जाली या छींटे।",
                "दूसरा चरण (12-24 घंटे): थन का पत्थर जैसा कठोर होना, दूध बंद होकर पीला मवाद आना।",
                "तीसरा चरण (24-48 घंटे): थन का रंग नीला/काला पड़ना (गैंग्रीन), थन हमेशा के लिए मर जाना।"
            ),
            homeRemedies = listOf(
                "हल्दी (50g) + एलोवेरा का गूदा (250g) + कलाई चूना (10g) पीसकर गाढ़ा लेप थन पर दिन में 3 बार लगाएं।",
                "नींबू का रस (50ml) + सरसों का तेल (100ml) दिन में दो बार 3 दिन तक पिलाएं।",
                "प्रभावित थन से हर 2 घंटे बाद पूरा खराब दूध निकाल कर जमीन में गाड़ें।"
            ),
            urgentAction = "Intamox 3g / Intacef Tazo व Melonex Plus का इंजेक्शन तुरंत लगवाएं।",
            anatomicalCategory = "UDDER_MILK"
        ),
        FarmerDiseaseItem(
            id = "fd_chronic_mastitis",
            nameHindi = "पुराना थनैला व गांठ (Chronic Mastitis & Fibrosis)",
            nameScientific = "Chronic Streptococcal / Staphylococcal Fibrosis",
            desiNames = "गांठदार थनैला, पथरी थन, अंधा थन, सूखी बादी",
            rootCauseType = "अधूरे इलाज से थन के अंदर रेशेदार ऊतक (Fibrous tissue) की स्थायी गांठ बनना",
            clinicalSigns = listOf("थन के अंदर सुपारी या गेंद जैसी कठोर गांठ महसूस होना", "दूध की धार पतली आना या दूध कम होना", "दूध का स्वाद नमकीन होना व बार-बार फटना"),
            stagesTimeline = listOf(
                "पहला चरण: पिछले बियान के थनैला का अधूरा इलाज, थन में छोटी गांठ।",
                "दूसरा चरण: गांठ का बढ़ना, दूध में लगातार 40% तक कमी।",
                "तीसरा चरण: थन की नलिका पूरी तरह बंद होना (Fibrous cord) व थन सूखना।"
            ),
            homeRemedies = listOf(
                "पोटैशियम आयोडाइड मलहम से थन की गांठ पर रोजाना 10 मिनट मालिश करें।",
                "कपूर को सरसों के तेल में मिलाकर गुनगुना करके थन पर मलें।"
            ),
            urgentAction = "फाइब्रोसिस घोलने हेतु Serratiopeptidase बोलस व Long Acting Penicillin का कोर्स कराएं।",
            anatomicalCategory = "UDDER_MILK"
        ),
        FarmerDiseaseItem(
            id = "fd_subclinical_mastitis",
            nameHindi = "सब-क्लिनिकल थनैला (Subclinical Mastitis)",
            nameScientific = "Subclinical High Somatic Cell Count (SCC)",
            desiNames = "छिपा थनैला, मीठा थनैला, दूध चोरी, कम दूध",
            rootCauseType = "बिना किसी बाह्य सूजन के थन में सूक्ष्म जीवाणु जो चुपचाप दूध घटाते हैं",
            clinicalSigns = listOf("थन बाहर से बिल्कुल सामान्य दिखता है", "दूध में 15-30% की अप्रत्याशित गिरावट", "दूध की शेल्फ लाइफ घटना व गर्म करने पर जल्दी फटना"),
            stagesTimeline = listOf(
                "पहला चरण: दूध की गुणवत्ता कम, फैट व एसएनएफ गिरना, कोई शारीरिक लक्षण नहीं।",
                "दूसरा चरण: कैलिफोर्निया मैस्टाइटिस टेस्ट (CMT) करने पर दूध का जैल बन जाना।",
                "तीसरा चरण: कभी भी भड़ककर तीव्र क्लिनिकल थनैला में बदल जाना।"
            ),
            homeRemedies = listOf(
                "दूध निकालने के तुरंत बाद थनों को 0.5% पोविडोन आयोडीन घोल में डुबोएं (Teat Dipping)।",
                "पशु को दोहने के बाद 45 मिनट तक बैठने न दें (चारा डालकर खड़ा रखें)।"
            ),
            urgentAction = "विटामिन ई + सेलेनियम व बायोटीन पाउडर (Mastilep / Masti-Plus) 10 दिन खिलाएं।",
            anatomicalCategory = "UDDER_MILK"
        ),
        FarmerDiseaseItem(
            id = "fd_mycotic_mastitis",
            nameHindi = "फंगल / फफूंद थनैला (Mycotic Mastitis)",
            nameScientific = "Candida albicans / Aspergillus Mastitis",
            desiNames = "फफूंद थनैला, ईस्ट थन, बेअसर बादी",
            rootCauseType = "एंटीबायोटिक के अत्यधिक व अंधाधुंध इस्तेमाल से थन में फंगस पनपना",
            clinicalSigns = listOf("एंटीबायोटिक इंजेक्शन देने के बावजूद थन ठीक न होना", "दूध में सफेद दही जैसे गाढ़े बदबूदार लच्छे", "थन में हल्का दर्द व लगातार सूजन बने रहना"),
            stagesTimeline = listOf(
                "पहला चरण: सामान्य थनैला के लिए 5-7 दिन भारी एंटीबायोटिक दिए गए।",
                "दूसरा चरण: थन में कोई सुधार नहीं, दूध में खट्टी दुर्गंध व सफेद पपड़ी।",
                "तीसरा चरण: थन के दूध ग्रंथि ऊतक का हमेशा के लिए नष्ट होना।"
            ),
            homeRemedies = listOf(
                "एंटीबायोटिक दवाओं का प्रयोग तुरंत रोक दें।",
                "लहसुन का रस 50ml + शहद 50g मिलाकर ओरल दें (एंटी-फंगल प्रभाव)।"
            ),
            urgentAction = "थन के अंदर Clotrimazole या Nystatin एंटीफंगल सस्पेंशन डॉक्टर से डलवाएं।",
            anatomicalCategory = "UDDER_MILK"
        ),
        FarmerDiseaseItem(
            id = "fd_teat_spider",
            nameHindi = "थन में मकड़ी / सिस्ट (Teat Spider / Polyp)",
            nameScientific = "Teat Canal Obstruction / Mucosal Polyp",
            desiNames = "मकड़ी, थन की गांठ, थन बंद, फंसी धार",
            rootCauseType = "थन के छेद के अंदर म्यूकोसल झिल्ली का बढ़ जाना या चोट लगना",
            clinicalSigns = listOf("थन में दूध भरा है पर धार नहीं निकलती", "दूध निकालते समय बहुत जोर लगाना पड़ता है व छींटे बिखरते हैं", "थन के सिरे पर उंगली से छूने पर छोटी गांठ महसूस होना"),
            stagesTimeline = listOf(
                "पहला चरण: दूध की धार पतली व टेढ़ी होना, दोहने में समय लगना।",
                "दूसरा चरण: धार का पूरी तरह बंद होना, थन में दूध का दबाव बढ़ना।",
                "तीसरा चरण: दूध अंदर सड़ने से भयंकर थनैला व सेप्सिस।"
            ),
            homeRemedies = listOf(
                "थन के छेद में सुई, साइकिल की तीली या माचिस की तीली कभी न डालें (इससे संक्रमण फैलता है)।",
                "थन के सिरे को गुनगुने नमक पानी में 5 मिनट डुबोकर रखें।"
            ),
            urgentAction = "पशु चिकित्सक द्वारा टीट साइफन (Teat Siphon) या हडसन टीट ट्यूमर एक्सट्रैक्टर से सिस्ट निकलवाएं।",
            anatomicalCategory = "UDDER_MILK"
        ),
        FarmerDiseaseItem(
            id = "fd_blood_in_milk",
            nameHindi = "दूध में खून आना (Blood in Milk / Hemolactia)",
            nameScientific = "Bovine Hemolactia",
            desiNames = "लाल दूध, लहू दूध, थन चोट, रक्त स्तन",
            rootCauseType = "थन की सूक्ष्म रक्त नलिकाओं का फटना (चोट, अधिक दूध दबाव या विटामिन सी की कमी)",
            clinicalSigns = listOf("दूध का रंग हल्का गुलाबी या गहरा लाल होना", "दूध को बर्तन में रखने पर नीचे लाल खून बैठ जाना", "थन में कोई दर्द या बुखार न होना"),
            stagesTimeline = listOf(
                "पहला चरण: प्रसव के 2-5 दिन बाद दूध का रंग हल्का गुलाबी दिखना।",
                "दूसरा चरण: दोहते समय साफ लाल खून के धागे आना, दूध का खट्टा होना।",
                "तीसरा चरण: खून लगातार बहने से थन में थक्का जमना व धार बंद होना।"
            ),
            homeRemedies = listOf(
                "फिटकरी (Alum) 10g + 250ml दूध में घोलकर दिन में दो बार 3 दिन पिलाएं।",
                "थन पर बर्फ या ठंडे पानी की सिकाई करें (गर्म सिकाई बिल्कुल न करें)।",
                "कपूर 5g केले में रखकर खिलाएं।"
            ),
            urgentAction = "Botropase / Chromium coagulant (Styptochrome) व Vitamin K इंजेक्शन लगवाएं।",
            anatomicalCategory = "UDDER_MILK"
        ),
        FarmerDiseaseItem(
            id = "fd_teat_chaps",
            nameHindi = "थन का फटना व छाले (Teat Chaps & Pox)",
            nameScientific = "Bovine Pseudocowpox / Teat Chaps",
            desiNames = "थन चीर, थन फटना, शीतला छाले, खुजली थन",
            rootCauseType = "विषाणु (Parapoxvirus) या सर्दियों में ठंडी हवा व गीले हाथ से दोहना",
            clinicalSigns = listOf("थन की त्वचा पर गहरे दर्दनाक चीरे व दरारें", "थन पर अंगूठी के आकार के गोल फफोले व पपड़ी", "गाय को हाथ लगाते ही लात मारना"),
            stagesTimeline = listOf(
                "पहला चरण: थन पर लाल फुंसियां, जो 48 घंटे में पानी के छालों में बदलती हैं।",
                "दूसरा चरण: छालों का फटना, खुरंड जमना व दोहते समय खून निकलना।",
                "तीसरा चरण: दरारों में मक्खियां बैठकर कीड़े (Maggots) पड़ने का खतरा।"
            ),
            homeRemedies = listOf(
                "ग्लिसरीन में बोरिक एसिड 1:4 के अनुपात में मिलाकर दोहने के बाद थनों पर लगाएं।",
                "देसी घी में हल्दी पकाकर ठंडा लेप दरारों में भरें।"
            ),
            urgentAction = "पशु चिकित्सक से जेंटियन वॉयलेट (Gentian Violet 1%) व एंटीसेप्टिक क्रीम लगवाएं।",
            anatomicalCategory = "UDDER_MILK"
        ),
        FarmerDiseaseItem(
            id = "fd_udder_edema",
            nameHindi = "लेवटी की सूजन / एडीमा (Physiological Udder Edema)",
            nameScientific = "Parturient Udder Edema",
            desiNames = "गादी पानी, बादी सूजन, बियान सूजन, कच्ची लेवटी",
            rootCauseType = "प्रसव के समय रक्त व लसिका (Lymph) का अत्यधिक संचार व नसों पर दबाव",
            clinicalSigns = listOf("लेवटी व नाभि के नीचे तक नरम ठंडी सूजन", "अंगुली दबाने पर गड्ढा बन जाना (Pitting edema)", "दूध सामान्य आना व कोई दर्द या बुखार न होना"),
            stagesTimeline = listOf(
                "पहला चरण: बियाने से 10 दिन पहले लेवटी का बहुत बड़ा हो जाना।",
                "दूसरा चरण: बियाने के बाद सूजन का आगे नाभि व छाती तक फैलना।",
                "तीसरा चरण: अत्यधिक खिंचाव से लेवटी के लिगामेंट (Suspensory ligament) टूटना।"
            ),
            homeRemedies = listOf(
                "दाने में नमक की मात्रा आधी कर दें।",
                "लेवटी की नीचे से ऊपर की ओर हल्के हाथ से सूखी मालिश करें।"
            ),
            urgentAction = "मूत्रवर्धक इंजेक्शन (Furosemide / Lasix 5-10ml) व Isoflupredone डॉक्टर से लगवाएं।",
            anatomicalCategory = "UDDER_MILK"
        ),

        // ==========================================
        // CATEGORY 5: URINARY & REPRODUCTIVE (🩸 पेशाब व प्रजनन)
        // ==========================================
        FarmerDiseaseItem(
            id = "fd_babesiosis",
            nameHindi = "लाल पेशाब / बबेसिओसिस (Babesiosis / Red Water)",
            nameScientific = "Babesia bigemina Infection",
            desiNames = "रक्तमूत्र, लाल पेशाब, चिचड़ी बुखार, झर्रा",
            rootCauseType = "रक्त प्रोटोजोआ (चिचड़ी/Ticks के काटने से आरबीसी का तेजी से फूटना)",
            clinicalSigns = listOf("कॉफी या गहरे लाल रंग का पेशाब आना", "106-107°F तीव्र बुखार व कंपकंपी", "आंखों व मसूड़ों का सफेद (एनीमिया) व पीला पड़ना"),
            stagesTimeline = listOf(
                "पहला चरण (Day 1): 106°F बुखार, चिचड़ियां चिपकी होना, दूध में भारी गिरावट।",
                "दूसरा चरण (Day 2): पेशाब का रंग गहरा लाल व बाद में कॉफी जैसा होना, धड़कन तेज।",
                "तीसरा चरण (Day 3-4): गंभीर पीलिया, हीमोग्लोबिन 3-4 g/dl गिरना व मृत्यु का खतरा।"
            ),
            homeRemedies = listOf(
                "गुड़ 250g + मेथी दाना का काढ़ा ठंडा करके पिलाएं ताकि ताकत मिले।",
                "शरीर से सभी चिचड़ियों को हाथ से हटाकर नष्ट करें व बाड़े में दवा छिड़कें।"
            ),
            urgentAction = "Berenil (Diminazene Aceturate 7%) इंजेक्शन 15-20ml डीप आईएम तुरंत लगवाएं।",
            anatomicalCategory = "URINARY_REPRO"
        ),
        FarmerDiseaseItem(
            id = "fd_pph",
            nameHindi = "प्रसव उपरांत लाल पेशाब (PPH / Hypophosphatemia)",
            nameScientific = "Post-Parturient Hemoglobinuria",
            desiNames = "ब्याने का लाल पेशाब, फास्फोरस कमी, लहू मूतना",
            rootCauseType = "फास्फोरस (Phosphorus) की भारी कमी (प्रसव के 2-4 सप्ताह के भीतर अत्यधिक दूध देने वाली भैंसों में)",
            clinicalSigns = listOf("बिना किसी बुखार के गहरा लाल या भूरा पेशाब आना", "अत्यधिक कमजोरी व गोबर का सूखा व सख्त होना", "पशु का दीवार या खुरली चाटना"),
            stagesTimeline = listOf(
                "पहला चरण: बियाने के 15-30 दिन बाद अचानक गहरा लाल पेशाब, बुखार शून्य।",
                "दूसरा चरण: खून की भारी कमी, सांस तेज चलना, चारा छोड़ना।",
                "तीसरा चरण: अत्यधिक एनीमिया से दिल का दौरा व 48 घंटे में मृत्यु।"
            ),
            homeRemedies = listOf(
                "सोडियम एसिड फास्फेट (Urocon / Sodaphos) 60g गुड़ के साथ दिन में दो बार खिलाएं।",
                "पशु को हरी बरसीम तुरंत बंद करके सूखा तूड़ा व बिनौला खल दें।"
            ),
            urgentAction = "Tonophosphan / Fostone (10-15ml IV/IM) व गंभीर स्थिति में फ्रेश ब्लड ट्रांसफ्यूजन करवाएं।",
            anatomicalCategory = "URINARY_REPRO"
        ),
        FarmerDiseaseItem(
            id = "fd_pyometra",
            nameHindi = "गर्भाशय में मवाद / पायोमेट्रा (Pyometra)",
            nameScientific = "Bovine Pyometra / Closed & Open Cervix",
            desiNames = "बच्चेदानी पीप, मवाद भरा पेट, गंदा पानी, बंद पायोमेट्रा",
            rootCauseType = "कॉर्पस ल्यूटियम (CL) बने रहने से गर्भाशय में भारी मवाद जमा होना",
            clinicalSigns = listOf("पशु का बार-बार पूंछ उठाना व सफेद-पीला मवाद गिराना", "पशु का हीट में न आना (झूठी गर्भावस्था)", "पेट का असामान्य रूप से बड़ा दिखना"),
            stagesTimeline = listOf(
                "पहला चरण: ए.आई. या संभोग के बाद संक्रमण, गर्भाशय में मवाद भरना शुरू।",
                "दूसरा चरण: गर्भाशय 5 से 10 लीटर बदबूदार मवाद से भर जाना, सर्विक्स बंद।",
                "तीसरा चरण: गर्भाशय की दीवार पतली होना व स्थायी बांझपन।"
            ),
            homeRemedies = listOf(
                "उलटाव व गर्भाशय सफाई हेतु यूट्रोटोन / रेप्लांटा सिरप 100ml रोजाना 5 दिन दें।",
                "हल्दी व अजवाइन का काढ़ा गुड़ के साथ पिलाएं।"
            ),
            urgentAction = "Cloprostenol (Pragma / Lutalyse 2ml IM) लगवाएं ताकि गर्भाशय का मुंह खुले व मवाद निकले।",
            anatomicalCategory = "URINARY_REPRO"
        ),
        FarmerDiseaseItem(
            id = "fd_metritis",
            nameHindi = "गर्भाशय सूजन / मेट्राइटिस (Metritis & Endometritis)",
            nameScientific = "Puerperal Acute Metritis",
            desiNames = "जेर सड़न, गर्भाशय सूजन, गंदा डिस्चार्ज, मैला छांटना",
            rootCauseType = "प्रसव के समय अस्वच्छ हाथ डालना या जेर का सड़ना",
            clinicalSigns = listOf("ब्याने के 3-10 दिन बाद बदबूदार लाल-भूरा मटमैला पानी गिरना", "104°F बुखार, भूख बंद व दूध में अचानक भारी गिरावट", "पशु का पीठ झुकाकर कराहते हुए खड़े रहना"),
            stagesTimeline = listOf(
                "पहला चरण: जेर रुकने के बाद गंदी बदबूदार मैला आना, हल्का बुखार।",
                "दूसरा चरण: तेज बुखार, दूध सूखना, पशु का खाना छोड़ना व सेप्सिस।",
                "तीसरा चरण: पेरिटोनाइटिस या हमेशा के लिए बच्चेदानी खराब होना।"
            ),
            homeRemedies = listOf(
                "मेथी दाना 250g + सोंठ 50g + गुड़ 500g का काढ़ा बनाकर रोज 3 दिन दें।",
                "पशु की पूंछ व योनि मार्ग को लाल दवा के पानी से रोजाना धोएं।"
            ),
            urgentAction = "Ceftiofur RTU (Xyrofur 1g IM) व गर्भाशय में ल्यूगाल आयोडीन इन्फ्यूजन करवाएं।",
            anatomicalCategory = "URINARY_REPRO"
        ),
        FarmerDiseaseItem(
            id = "fd_repeat_breeding",
            nameHindi = "बार-बार फिरना / रिपीट ब्रीडिंग (Repeat Breeding)",
            nameScientific = "Repeat Breeder Cow Syndrome (RBS)",
            desiNames = "उलट जाना, फिर जाना, न ठहरना, झूठी हीट",
            rootCauseType = "सबक्लिनिकल एंडोमेट्राइटिस, हार्मोन असंतुलन या कमजोर सीमन गुणवत्ता",
            clinicalSigns = listOf("पशु हर 21 दिन पर नियमित हीट में आता है पर गाभिन नहीं ठहरता", "हीट के डिस्चार्ज में हल्का मटमैलापन या सफेद धागे", "3 या अधिक बार ए.आई. कराने पर भी खाली रहना"),
            stagesTimeline = listOf(
                "पहला चक्र: ए.आई. कराई गई पर 21वें दिन पशु दोबारा बोल पड़ा।",
                "दूसरा चक्र: डिस्चार्ज की जांच में हल्का पस, अंडा समय पर न फूटना।",
                "तीसरा चक्र: पशुपालक का भारी आर्थिक नुकसान, ड्राई पीरियड लंबा होना।"
            ),
            homeRemedies = listOf(
                "चीलेटेड मिनरल मिक्सचर 50 ग्राम रोज 2 माह तक लगातार दाने में दें।",
                "हीट में आने पर पशु को धूप में न बांधें, ठंडा पानी सिर पर डालें।"
            ),
            urgentAction = "ए.आई. के समय Receptal (Buserelin 2.5ml IM) व 5वें दिन Duraprogen लगवाएं।",
            anatomicalCategory = "URINARY_REPRO"
        ),
        FarmerDiseaseItem(
            id = "fd_rop",
            nameHindi = "जेर का रुकना (Retention of Placenta - ROP)",
            nameScientific = "Retained Fetal Membranes (RFM)",
            desiNames = "जेर अड़ना, नाल रुकना, पछुआ न गिरना, जेर फंसना",
            rootCauseType = "प्रसव के 8-12 घंटे बाद भी जेर बाहर न निकलना (कैल्शियम व हार्मोन की कमी)",
            clinicalSigns = listOf("योनि से सड़ी हुई बदबूदार जेर का लटकना", "मक्खियों का भिनभिनाना व पूंछ हिलाना", "हल्का बुखार व दूध में कमी"),
            stagesTimeline = listOf(
                "पहला चरण (0-8 घंटे): प्रसव के बाद जेर लटकती रहती है, पशु बेचैन।",
                "दूसरा चरण (8-24 घंटे): जेर सड़ना शुरू, बदबूदार मवाद रिसना, भूख कम।",
                "तीसरा चरण (24+ घंटे): गर्भाशय में भयंकर जहर फैलना (Toxemia) व मृत्यु का खतरा।"
            ),
            homeRemedies = listOf(
                "बांस के ताजे पत्ते (1 किग्रा) या प्याज 1 किग्रा गुड़ के साथ उबालकर पिलाएं।",
                "जेर पर ईंट, पत्थर या भारी वजन कभी न बांधें (गर्भाशय उलटने का खतरा)।",
                "जेर को कभी जबरन हाथ से न खींचें (खून बहने का खतरा)।"
            ),
            urgentAction = "Utrovet सिरप 500ml तुरंत पिलाएं व डॉक्टर से गर्भाशय में सेप्टोमैक्स बोलस रखवाएं।",
            anatomicalCategory = "URINARY_REPRO"
        ),
        FarmerDiseaseItem(
            id = "fd_prolapse",
            nameHindi = "फूल/पाछा दिखाना / प्रोलैप्स (Uterine / Vaginal Prolapse)",
            nameScientific = "Prolapse of Vagina and Uterus",
            desiNames = "फूल दिखाना, पाछा निकलना, बेल निकलना, कांच निकलना",
            rootCauseType = "एस्ट्रोजन हार्मोन की अधिकता, कैल्शियम की कमी व बैठने पर अत्यधिक जोर लगाना",
            clinicalSigns = listOf("योनि मार्ग से फुटबॉल या तरबूज जैसा लाल मांस का गोला बाहर आना", "पशु का लगातार पीछे जोर लगाना व दर्द से कराहना", "पेशाब की नली दबने से पेशाब बंद हो जाना"),
            stagesTimeline = listOf(
                "पहला चरण: बैठने पर टेनिस बॉल जैसा छोटा लाल गोला दिखना जो खड़े होने पर अंदर चला जाता है।",
                "दूसरा चरण: बड़ा गोला बाहर रहना, खड़े होने पर भी अंदर न जाना, सूजन व घाव।",
                "तीसरा चरण: ब्याने के बाद पूरी बच्चेदानी बाहर आ जाना, खून बहना व आपातकाल।"
            ),
            homeRemedies = listOf(
                "बाहर निकले अंग को साफ पॉलीथिन पर रखें, गोबर व धूल से बचाएं।",
                "बर्फ के ठंडे पानी या फिटकरी पानी से धोकर सूजन कम करें।",
                "पशु को पीछे से ऊंचे स्थान पर खड़ा करें ताकि दबाव घटे।"
            ),
            urgentAction = "पशु चिकित्सक द्वारा अंग को वापस अंदर करवाकर Buhner सुई से टांके लगवाएं।",
            anatomicalCategory = "URINARY_REPRO"
        ),
        FarmerDiseaseItem(
            id = "fd_brucellosis",
            nameHindi = "ब्रूसेलोसिस / संक्रामक गर्भपात (Bovine Brucellosis)",
            nameScientific = "Brucella abortus Infection",
            desiNames = "तुवा रोग, छूत गर्भपात, बांझपन रोग, माल्टा ज्वर",
            rootCauseType = "जीवाणु (Brucella abortus - इंसानों में फैलने वाला खतरनाक जूनोटिक रोग)",
            clinicalSigns = listOf("गाभिन गाय-भैंस का 7वें से 8वें महीने में अचानक गर्भपात होना", "गर्भपात के बाद जेर का अनिवार्य रूप से रुकना व सड़ना", "नर पशुओं के अंडकोष (Testicles) में भारी सूजन"),
            stagesTimeline = listOf(
                "पहला चरण: गर्भावस्था के अंतिम तिमाही में बिना किसी पूर्व लक्षण के गर्भपात।",
                "दूसरा चरण: जेर रुकना, गर्भाशय से भूरा बदबूदार स्राव कई हफ्तों तक बहना।",
                "तीसरा चरण: पशु का हमेशा के लिए बांझ हो जाना, इंसानों में अनडुलेटिंग फीवर।"
            ),
            homeRemedies = listOf(
                "गिरे हुए भ्रूण व जेर को दस्ताने पहनकर 6 फीट गहरे गड्ढे में चूना डालकर दबाएं।",
                "प्रभावित पशु का दूध बिना उबाले कभी न पिएं।"
            ),
            urgentAction = "4-8 माह की बछड़ियों में ब्रूसेला का टीका (Bruvax / Cotton Strain 19) अवश्य लगवाएं।",
            anatomicalCategory = "URINARY_REPRO"
        ),

        // ==========================================
        // CATEGORY 6: LEGS, SKIN & METABOLIC (🦵 पैर, त्वचा व उपापचय)
        // ==========================================
        FarmerDiseaseItem(
            id = "fd_bq",
            nameHindi = "लंगड़ा बुखार / काला बादी (Black Quarter - BQ)",
            nameScientific = "Clostridium chauvoei Infection",
            desiNames = "जहरबाद, काला बादी, सुकवा, चड़चड़िया",
            rootCauseType = "बीजाणु जीवाणु (Clostridium spores मिट्टी व घाव से प्रवेश करते हैं)",
            clinicalSigns = listOf("पुट्ठे, कंधे या जांघ पर बड़ी गर्म व दर्दनाक सूजन", "सूजन पर हाथ दबाने पर सूखे पत्तों जैसी चड़-चड़ आवाज (Crepitation)", "पैर से गंभीर लंगड़ापन व 105°F तेज बुखार"),
            stagesTimeline = listOf(
                "पहला चरण (Day 1): एक पैर से अचानक लंगड़ाना, 105°F तेज बुखार, कंपकंपी।",
                "दूसरा चरण (Day 1-2): पुट्ठे पर गर्म सूजन जो बाद में ठंडी व बेजान हो जाती है, दबाने पर गैस।",
                "तीसरा चरण (Day 2-3): चीरा लगाने पर काला बदबूदार झागदार खून निकलना, टॉक्सिमिया से मृत्यु।"
            ),
            homeRemedies = listOf(
                "सूजन वाले स्थान पर चीरा केवल अधिकृत पशु चिकित्सक ही लगाएं।",
                "प्रभावित बाड़े को ब्लीचिंग पाउडर व कलाई चूने से पूरी तरह सैनिटाइज करें।"
            ),
            urgentAction = "तुरंत पेनिसिलिन (Pronapen 40L) या Oxy-LA की भारी खुराक शिरा/मांस में लगवाएं।",
            anatomicalCategory = "LEGS_SKIN"
        ),
        FarmerDiseaseItem(
            id = "fd_foot_rot",
            nameHindi = "संक्रामक फुटरोट / खुर सड़न (Infectious Foot Rot)",
            nameScientific = "Fusobacterium necrophorum & Dichelobacter",
            desiNames = "खुर सड़न, सड़वा, पैर गलना, खुर घाव",
            rootCauseType = "जीवाणु (कीचड़युक्त गीले बाड़े में खुरों के बीच घाव से संक्रमण)",
            clinicalSigns = listOf("दोनों खुरों के बीच में सड़ा हुआ बदबूदार गहरा घाव", "पैर जमीन पर न रख पाना व तीन पैरों पर लंगड़ा कर चलना", "खुर के ऊपर टखने तक सूजन व तेज दर्द"),
            stagesTimeline = listOf(
                "पहला चरण: खुरों के बीच की चमड़ी लाल होना, हल्का लंगड़ापन।",
                "दूसरा चरण: गहरा छाला बनना, सड़े मक्खन जैसी दुर्गंध, खुर का फूलना।",
                "तीसरा चरण: खुर की हड्डी व जोड़ तक सड़न फैलना, खुर का खोल अलग होना।"
            ),
            homeRemedies = listOf(
                "नीला थोथा (Copper Sulfate 5%) के पानी के हौज में खुरों को 5 मिनट डुबोएं (Foot Bath)।",
                "खुर के घाव पर तारपीन का तेल व कपूर मिलाकर पट्टी बांधें।"
            ),
            urgentAction = "Ceftiofur RTU या Long Acting Oxytetracycline व दर्दनिवारक इंजेक्शन दें।",
            anatomicalCategory = "LEGS_SKIN"
        ),
        FarmerDiseaseItem(
            id = "fd_lsd",
            nameHindi = "गांठदार त्वचा रोग (Lumpy Skin Disease - LSD)",
            nameScientific = "Capripoxvirus (LSDV)",
            desiNames = "लम्पी, गांठ रोग, चेचक दाने, चमड़ी फोड़ा",
            rootCauseType = "कैप्रीपॉक्स वायरस (मच्छर, मक्खी व चिचड़ियों के काटने से प्रसार)",
            clinicalSigns = listOf("पूरे शरीर पर 2 से 5 सेमी की कठोर उभरी हुई गोल गांठें", "पैरों व गलकंबल में भारी पानी की सूजन", "105°F तेज बुखार, नाक व आंखों से स्राव"),
            stagesTimeline = listOf(
                "पहला चरण (1-3 दिन): तेज बुखार, आंख से पानी, दूध में 80% गिरावट।",
                "दूसरा चरण (4-8 दिन): चमड़ी पर सैकड़ों कठोर गांठें उभरना, पैरों में सूजन।",
                "तीसरा चरण (9-15 दिन): गांठों का फटना, गहरे घाव बनना, कीड़े पड़ने का खतरा।"
            ),
            homeRemedies = listOf(
                "नीम की पत्ती (250g) + हल्दी (50g) + काली मिर्च (20g) + गुड़ (250g) का लड्डू बनाकर रोज खिलाएं।",
                "नीम के उबले पानी से घावों को धोएं व कपूर-नारियल तेल का लेप करें।",
                "बाड़े में नीम व गूगल का धुआं करके मक्खी-मच्छर भगाएं।"
            ),
            urgentAction = "गोट पॉक्स वैक्सीन (Goat Pox Vaccine) स्वस्थ पशुओं में लगवाएं व एंटीबायोटिक दें।",
            anatomicalCategory = "LEGS_SKIN"
        ),
        FarmerDiseaseItem(
            id = "fd_ringworm",
            nameHindi = "दाद / फंगल इन्फेक्शन (Ringworm)",
            nameScientific = "Trichophyton verrucosum",
            desiNames = "दाद, चर्म रोग, गोल पपड़ी, चकदत्ते",
            rootCauseType = "त्वचा की फफूंद (अंधेरे, सीलनयुक्त बाड़े व संक्रमित ब्रश/रस्सी से)",
            clinicalSigns = listOf("गर्दन, सिर व आंखों के चारों ओर गोल सिक्के जैसी सफेद पपड़ी", "प्रभावित जगह से बाल पूरी तरह उड़ जाना", "खुरदरी एस्बेस्टस जैसी मोटी चमड़ी"),
            stagesTimeline = listOf(
                "पहला चरण: त्वचा पर छोटी गोल लाल फुंसियां, हल्के बाल झड़ना।",
                "दूसरा चरण: सफेद-धूसर रंग की सूखी पपड़ी जमना, सिक्कों के आकार में फैलना।",
                "तीसरा चरण: चेहरे व गर्दन पर बड़े-बड़े चकत्तों का आपस में मिल जाना।"
            ),
            homeRemedies = listOf(
                "पपड़ी को साबुन व गर्म पानी से खुरच कर साफ करें।",
                "टिंचर आयोडीन या सल्फर पाउडर को सरसों तेल में मिलाकर रोजाना लगाएं।"
            ),
            urgentAction = "Clotrimazole मलहम या ओरल Griseofulvin पाउडर डॉक्टर की सलाह से दें।",
            anatomicalCategory = "LEGS_SKIN"
        ),
        FarmerDiseaseItem(
            id = "fd_mange",
            nameHindi = "खुजली / चिचड़ी व जूं (Mange & Ectoparasites)",
            nameScientific = "Sarcoptes scabiei / Psoroptes ovis",
            desiNames = "खाज, खुजली, जूं, चींचड़, अठई",
            rootCauseType = "त्वचा में सुरंग बनाने वाले सूक्ष्म माइट्स व चिचड़ियां",
            clinicalSigns = listOf("दीवार, खूंटे या पेड़ से शरीर को पागलों की तरह रगड़ना", "गर्दन, पूंछ व जांघों से बाल उड़ना व खून निकलना", "चमड़ी का हाथी की तरह मोटा, झुर्रीदार व काला पड़ना"),
            stagesTimeline = listOf(
                "पहला चरण: रात में तीव्र खुजली, पशु बेचैन होकर खाना छोड़ता है।",
                "दूसरा चरण: रगड़ने से घाव, पपड़ी जमना, बालों का बड़ा हिस्सा उड़ना।",
                "तीसरा चरण: एनीमिया, गंभीर क्षीणता व द्वितीयक जीवाणु संक्रमण।"
            ),
            homeRemedies = listOf(
                "नीम का तेल (500ml) + कपूर (20g) मिलाकर पूरे शरीर पर धूप में लगाएं।",
                "बाड़े की दरारों में ब्लो-टॉर्च या साइपरमेथ्रिन का छिड़काव करें।"
            ),
            urgentAction = "Ivermectin 1% (1ml per 50kg body weight) केवल चमड़ी के नीचे (SC) लगवाएं।",
            anatomicalCategory = "LEGS_SKIN"
        ),
        FarmerDiseaseItem(
            id = "fd_milk_fever",
            nameHindi = "मिल्क फीवर / सूतिका ज्वर (Milk Fever)",
            nameScientific = "Parturient Hypocalcemia",
            desiNames = "सूतिका ज्वर, ठंडा बुखार, ब्याने की कमजोरी, कैल्शियम गिरना",
            rootCauseType = "खून में कैल्शियम का अचानक घातक स्तर तक गिरना (प्रसव के 48 घंटे के भीतर)",
            clinicalSigns = listOf("गर्दन को मोड़कर कोख (Flank) पर रखकर लेटे रहना ('S' शेप वक्र)", "शरीर, कान व थनों का बर्फ जैसा ठंडा पड़ जाना (तापमान < 98°F)", "पशु का खड़ा न हो पाना, पुतलियां फैली होना"),
            stagesTimeline = listOf(
                "पहला चरण (0-2 घंटे): पिछले पैरों में लड़खड़ाहट, कान ठंडे, दांत पीसना।",
                "दूसरा चरण (2-10 घंटे): जमीन पर बैठ जाना, सिर कोख पर टिकाना, पेशाब-गोबर बंद।",
                "तीसरा चरण (10+ घंटे): करवट के बल गिरना, कोमा, ब्लोट व 12 घंटे में मृत्यु।"
            ),
            homeRemedies = listOf(
                "पशु को जबरदस्ती खड़े होने के लिए न मारें (हड्डी टूटने का खतरा)।",
                "बेहोश पशु को नाल द्वारा कभी कुछ न पिलाएं (फेफड़ों में पानी जाने से मृत्यु)।",
                "पशु को पुआल का तकिया लगाकर छाती के बल सीधा बैठाएं।"
            ),
            urgentAction = "Calcium Borogluconate (Mifex / Calborol 450ml) शरीर के तापमान पर गर्म करके धीमे IV लगवाएं।",
            anatomicalCategory = "LEGS_SKIN"
        ),
        FarmerDiseaseItem(
            id = "fd_downer_cow",
            nameHindi = "डाउनर काउ सिंड्रोम (Downer Cow Syndrome)",
            nameScientific = "Downer Cow Complex / Ischemic Muscle Necrosis",
            desiNames = "बैठी गाय, न उठने वाली गाय, नस दबना, सुन्न पैर",
            rootCauseType = "कैल्शियम चढ़ाने के बाद भी मांसपेशियों व नसों में रक्त संचार रुकने से पशु का न उठ पाना",
            clinicalSigns = listOf("सतर्क आंखें व चारा खाना पर पिछले पैरों के बल बिल्कुल न उठ पाना", "पिछले पैरों की मांसपेशियों में कठोरता व संवेदनहीनता", "पशु का रेंगने की कोशिश करना पर खड़े न हो पाना"),
            stagesTimeline = listOf(
                "पहला चरण (Day 1): मिल्क फीवर का उपचार हुआ पर पशु फर्श पर लेटा रहा।",
                "दूसरा चरण (Day 2-3): सख्त फर्श पर लेटे रहने से जांघों की मांसपेशियों की मृत्यु (Necrosis)।",
                "तीसरा चरण (Day 4+): बेड सोर (घाव) बनना, टॉक्सिमिया व असाध्य स्थिति।"
            ),
            homeRemedies = listOf(
                "पशु को तुरंत सख्त पक्के फर्श से हटाकर 1 फीट मोटी रेत या पुआल पर रखें।",
                "हर 3 से 4 घंटे बाद पशु की करवट बदलें ताकि दोनों पैरों में खून चले।",
                "पिछले पैरों की मालिश गर्म पानी व तेल से करें।"
            ),
            urgentAction = "Mecobalamin (Neuroxin-12 / Tribivet) + Vitamin AD3E + NSAID इंजेक्शन दिलवाएं।",
            anatomicalCategory = "LEGS_SKIN"
        ),
        FarmerDiseaseItem(
            id = "fd_ketosis",
            nameHindi = "कीटोसिस / उपापचयी विकार (Bovine Ketosis / Acetonemia)",
            nameScientific = "Clinical Acetonemia",
            desiNames = "कीटोसिस, दूध सूखा, मीठी सांस, दाना छोड़ना",
            rootCauseType = "प्रसव के 2 से 8 सप्ताह बाद ऊर्जा (ग्लूकोज) की भारी कमी व वसा का टूटना",
            clinicalSigns = listOf("सांस, पेशाब व दूध से पके मीठे सेब या एसीटोन जैसी खुशबू", "दाना व चोकर खाने से पूरी तरह इनकार, सिर्फ सूखा चारा खाना", "दूध उत्पादन में 50% से अधिक अचानक गिरावट व वजन घटना"),
            stagesTimeline = listOf(
                "पहला चरण: पशु दाना नहीं खाता, सुस्त रहता है, गोबर सूखा व काले रंग का।",
                "दूसरा चरण: आंखें धंसना, तेजी से वजन गिरना, दूध का स्वाद कसैला होना।",
                "तीसरा चरण: नर्वस लक्षण (दीवार चाटना, लड़खड़ाहट) व क्रोनिक दुर्बलता।"
            ),
            homeRemedies = listOf(
                "गुड़ 500 ग्राम + मीठा सोडा 100 ग्राम दिन में दो बार 5 दिन पिलाएं।",
                "प्रोपिलीन ग्लाइकोल (Ketocheck / Anabolite) 200ml रोजाना 4 दिन दें।"
            ),
            urgentAction = "Dextrose 25% (1 लीटर IV) व Catosal (15-20ml IV) का इंजेक्शन डॉक्टर से लगवाएं।",
            anatomicalCategory = "LEGS_SKIN"
        )
    )

    // ==============================================================
    // 🩺 DOCTOR-EXCLUSIVE SEARCHABLE VETERINARY PHARMACOPEIA (20+ DRUGS)
    // ==============================================================
    val initialPharmacopeiaList: List<PharmacopeiaItem> = listOf(
        PharmacopeiaItem(
            id = "pharma_ceftriaxone_tazo",
            brandName = "Intacef Tazo 4.5g / 3.375g",
            genericSalt = "Ceftriaxone Sodium (3000mg) + Tazobactam Sodium (375mg)",
            manufacturer = "Intas Pharmaceuticals Ltd.",
            therapeuticCategory = "तीसरी पीढ़ी का सेफलोस्पोरिन एंटीबायोटिक + बीटा-लैक्टामेज अवरोधक",
            standardDosagePerKg = "10.0 mg/kg शारीरिक वजन (10-15 ml प्रति 300-400kg गाय/भैंस)",
            route = "Intramuscular (IM) / Slow Intravenous (IV)",
            indications = "गंभीर थनैला (Coliform / Environmental Mastitis), गलघोंटू (HS), जटिल न्यूमोनिया, ब्रोंकोन्यूमोनिया, मेट्राइटिस व सेप्टिसीमिया।",
            contraindications = "सेफलोस्पोरिन से अतिसंवेदनशीलता। अत्यधिक तेजी से IV न दें।",
            pregnancySafety = "100% प्रेगनेंसी सुरक्षित (Safe in All Trimesters)",
            withdrawalPeriod = "दूध: 7 दिन (14 दोहन) • मांस: 28 दिन",
            approxMrp = 480,
            commercialSubstitutes = listOf("Cef-Tazo Vet 4.5g (₹190 Generic)", "Tazomac Vet (₹420)", "Cefti-Plus 4.5g (₹220)")
        ),
        PharmacopeiaItem(
            id = "pharma_amoxi_clox",
            brandName = "Intamox 3g / 4g Vet",
            genericSalt = "Amoxicillin Sodium (1500mg) + Cloxacillin Sodium (1500mg)",
            manufacturer = "Intas Animal Health",
            therapeuticCategory = "पेनिसिलिनेज-प्रतिरोधी ब्रॉड-स्पेक्ट्रम एंटीबायोटिक",
            standardDosagePerKg = "7.0 - 10.0 mg/kg (20-30 ml रिकॉन्स्टिट्यूटेड सस्पेंशन)",
            route = "Deep IM / Slow IV (दिन में 2 बार)",
            indications = "स्टैफिलोकोकल व स्ट्रेप्टोकोकल थनैला, खुरपका के घाव, प्रसव उपरांत गर्भाशय संक्रमण व घाव।",
            contraindications = "पेनिसिलिन एलर्जी। इंट्रा-मेमरी ट्यूब के साथ मौखिक पेनिसिलिन न दें।",
            pregnancySafety = "100% प्रेगनेंसी सुरक्षित (Safe)",
            withdrawalPeriod = "दूध: 3 दिन • मांस: 14 दिन",
            approxMrp = 290,
            commercialSubstitutes = listOf("Amoxi-Clox Vet (₹130 Generic)", "Moxikind-CV (₹260)", "Bivomox 3g (₹140)")
        ),
        PharmacopeiaItem(
            id = "pharma_ceftiofur",
            brandName = "Xyrofur 1g / Excenel RTU 50mg/ml",
            genericSalt = "Ceftiofur Sodium / Ceftiofur Hydrochloride RTU",
            manufacturer = "Zoetis / Virbac Animal Health",
            therapeuticCategory = "तीसरी पीढ़ी का पशु-विशिष्ट सेफलोस्पोरिन (Zero Milk Withdrawal)",
            standardDosagePerKg = "1.1 - 2.2 mg/kg शारीरिक वजन (1ml प्रति 50kg)",
            route = "Intramuscular (IM) / Subcutaneous (SC) गर्दन में",
            indications = "बोवाइन रेस्पिरेटरी डिजीज (BRD), एक्यूट प्यूरपेरल मेट्राइटिस, संक्रामक फुटरोट। ZERO दूध विथड्रॉल का सबसे बड़ा लाभ।",
            contraindications = "सेफलोस्पोरिन अतिसंवेदनशीलता।",
            pregnancySafety = "100% प्रेगनेंसी सुरक्षित (Safe)",
            withdrawalPeriod = "दूध: 0 दिन (Zero Milk Withdrawal) • मांस: 4 दिन",
            approxMrp = 560,
            commercialSubstitutes = listOf("Ceftiofur RTU 50ml (₹320 Generic)", "Furacin Vet (₹480)")
        ),
        PharmacopeiaItem(
            id = "pharma_enrofloxacin",
            brandName = "Enrocin 100 / Flox-Vet 10%",
            genericSalt = "Enrofloxacin 100 mg/ml",
            manufacturer = "Cadila Animal Health / Mankind Vet",
            therapeuticCategory = "फ्लोरोक्विनोलोन जीवाणुरोधी (डीएनए गायरेज अवरोधक)",
            standardDosagePerKg = "5.0 mg/kg शारीरिक वजन (15-20 ml वयस्क गाय/भैंस हेतु)",
            route = "IM / Slow IV / SC",
            indications = "गंभीर दस्त (Colibacillosis), पेरिटोनाइटिस, मूत्रमार्ग संक्रमण, माइकोप्लाज्मा निमोनिया।",
            contraindications = "बढ़ते कुत्तों/पिल्लों में जोड़ों की कार्टिलेज क्षति के कारण वर्जित। घोड़े में न दें।",
            pregnancySafety = "सावधानीपूर्वक प्रथम तिमाही में सुरक्षित (Use with Caution)",
            withdrawalPeriod = "दूध: 4 दिन • मांस: 14 दिन",
            approxMrp = 210,
            commercialSubstitutes = listOf("Flox-Vet 100ml (₹85 Generic)", "Baytril 100 (₹380)", "Fortivir 10% (₹95)")
        ),
        PharmacopeiaItem(
            id = "pharma_oxytetracycline_la",
            brandName = "Terramycin LA 200mg/ml",
            genericSalt = "Oxytetracycline 200 mg/ml (Long Acting Base)",
            manufacturer = "Pfizer / Zydus Animal Health",
            therapeuticCategory = "दीर्घकालिक टेट्रासाइक्लिन एंटीबायोटिक (72 घंटे असर)",
            standardDosagePerKg = "20.0 mg/kg शारीरिक वजन (1ml प्रति 10kg deep IM)",
            route = "Deep Intramuscular (गर्दन की मांसपेशियों में, अधिकतम 15ml प्रति स्थान)",
            indications = "एनाप्लाज्मोसिस, लंगड़ा बुखार (BQ), गलघोंटू (HS), संक्रामक केराटो-कंजंक्टिवाइटिस (गुलाबी आंख)।",
            contraindications = "गर्भावती पशुओं में दांतों व हड्डियों का पीला पड़ना। शिरा (IV) में तेजी से कभी न दें।",
            pregnancySafety = "अंतिम तिमाही में सावधानी (Caution in Late Gestation)",
            withdrawalPeriod = "दूध: 7 दिन • मांस: 21 दिन",
            approxMrp = 220,
            commercialSubstitutes = listOf("Oxy-LA Vet 100ml (₹95 Generic)", "Tetra-LA 200 (₹110)")
        ),
        PharmacopeiaItem(
            id = "pharma_meloxicam_plus",
            brandName = "Melonex Plus 30ml / 100ml",
            genericSalt = "Meloxicam (5mg) + Paracetamol (150mg) प्रति ml",
            manufacturer = "Intas Pharmaceuticals Ltd.",
            therapeuticCategory = "चयनात्मक COX-2 अवरोधक + गैर-नारकोटिक ज्वरनाशक (NSAID)",
            standardDosagePerKg = "0.5 mg/kg मेलोक्सीकैम (15-20 ml वयस्क पशु हेतु)",
            route = "Deep Intramuscular (IM)",
            indications = "तीव्र बुखार, थनैला की सूजन, लंगड़ापन, चोट, आर्थराइटिस व सर्जरी उपरांत दर्द।",
            contraindications = "⚠️ बिल्लियों (Cat) में पैरासिटामोल घातक (FATAL) है! बिल्ली में बिल्कुल न दें। डिहाइड्रेशन में सावधानी।",
            pregnancySafety = "100% प्रेगनेंसी सुरक्षित (Safe in All Trimesters)",
            withdrawalPeriod = "दूध: 2 दिन • मांस: 5 दिन",
            approxMrp = 145,
            commercialSubstitutes = listOf("Melox-P Vet 30ml (₹55 Generic)", "Zobid-P (₹135)", "Mel-Plus 100ml (₹120)")
        ),
        PharmacopeiaItem(
            id = "pharma_flunixin",
            brandName = "Megludyne 20ml / Flunix Vet",
            genericSalt = "Flunixin Meglumine 50 mg/ml",
            manufacturer = "Virbac Animal Health",
            therapeuticCategory = "शक्तिशाली एंटी-एंडोटॉक्सिक गैर-स्टेरॉयडल प्रदाहनाशक (NSAID)",
            standardDosagePerKg = "1.1 - 2.2 mg/kg शारीरिक वजन (10-15 ml धीमी IV)",
            route = "Slow Intravenous (IV) / IM",
            indications = "टॉक्सिक थनैला, एंडोटॉक्सिक शॉक, तीव्र आफरा, पेट दर्द (Colic), सांस अवरोध में जीवनरक्षक।",
            contraindications = "गंभीर पेट के अल्सर, गुर्दा विफलता में वर्जित।",
            pregnancySafety = "100% प्रेगनेंसी सुरक्षित (Safe)",
            withdrawalPeriod = "दूध: 36 घंटे • मांस: 4 दिन",
            approxMrp = 260,
            commercialSubstitutes = listOf("Flunix-Vet 20ml (₹95 Generic)", "Finadyne (₹310)")
        ),
        PharmacopeiaItem(
            id = "pharma_isoflupredone",
            brandName = "Predef 2X 10ml / Isoflud Vet",
            genericSalt = "Isoflupredone Acetate 2 mg/ml",
            manufacturer = "Zoetis / Zydus Animal Health",
            therapeuticCategory = "अति-शक्तिशाली ग्लूकोकोर्टिकोइड स्टेरॉयड",
            standardDosagePerKg = "10 - 20 mg प्रति वयस्क पशु (5-10 ml कुल मात्रा)",
            route = "Deep IM / Intra-articular",
            indications = "कीटोसिस, गंभीर एलर्जी, पित्ती (Urticaria), लेवटी का गंभीर एडीमा, एनाफाइलेक्सिस।",
            contraindications = "🚨 गर्भावती पशु में सख्त वर्जित (Abortion Inducer)। संक्रमण में बिना एंटीबायोटिक न दें।",
            pregnancySafety = "❌ सख्त वर्जित (Causes Abortion in Pregnant Animals)",
            withdrawalPeriod = "दूध: 3 दिन • मांस: 7 दिन",
            approxMrp = 195,
            commercialSubstitutes = listOf("Iso-Vet 10ml (₹80 Generic)", "Flupred Vet (₹90)")
        ),
        PharmacopeiaItem(
            id = "pharma_diminazene",
            brandName = "Berenil 7% RTU 20ml / 90ml",
            genericSalt = "Diminazene Aceturate (70mg) + Phenazone प्रति ml",
            manufacturer = "Intervet MSD Animal Health",
            therapeuticCategory = "एंटीप्रोटोजोअल (बेबेशिया व ट्रिपैनोसोमा नाशक)",
            standardDosagePerKg = "3.5 mg/kg शारीरिक वजन (1ml प्रति 20kg body weight)",
            route = "Deep Intramuscular (कूल्हे/Gluteal मांसपेशियों में)",
            indications = "बेबेशियोसिस (लाल पेशाब / Red Water), सर्रा (Trypanosomiasis), चिचड़ी बुखार।",
            contraindications = "ऊंट व कुत्तों में तंत्रिका विषाक्तता का जोखिम। अत्यधिक मात्रा में न दें।",
            pregnancySafety = "100% प्रेगनेंसी सुरक्षित (Safe)",
            withdrawalPeriod = "दूध: 3 दिन • मांस: 21 दिन",
            approxMrp = 280,
            commercialSubstitutes = listOf("Dimina-Vet 20ml (₹110 Generic)", "Babecure 20ml (₹130)")
        ),
        PharmacopeiaItem(
            id = "pharma_buparvaquone",
            brandName = "Butalex 20ml / Zubion Vet",
            genericSalt = "Buparvaquone 50 mg/ml",
            manufacturer = "MSD Animal Health / Intas Pharma",
            therapeuticCategory = "विशिष्ट थायलेरियासिस रोधी (Anti-Theilerial)",
            standardDosagePerKg = "2.5 mg/kg शारीरिक वजन (1ml प्रति 20kg)",
            route = "Deep IM strictly in Neck muscles only (गर्दन के मांस में)",
            indications = "बोवाइन थायलेरियासिस (Theileria annulata) - तेज बुखार, लिम्फ नोड्स सूजन व एनीमिया में एकल जीवनरक्षक टीका।",
            contraindications = "अंतःशिरा (IV) सख्त वर्जित। गंभीर मामलों में 48 घंटे बाद दूसरी खुराक दें।",
            pregnancySafety = "गर्भावस्था में सावधानी के साथ दें (Use with caution)",
            withdrawalPeriod = "दूध: 14 दिन • मांस: 42 दिन",
            approxMrp = 1290,
            commercialSubstitutes = listOf("Zubion 20ml (₹780 Generic)", "Theiler-Nil (₹690)")
        ),
        PharmacopeiaItem(
            id = "pharma_calcium_mifex",
            brandName = "Mifex 450ml / Calborol",
            genericSalt = "Calcium Borogluconate 25% + Magnesium & Phosphorus",
            manufacturer = "Novartis / Elanco Animal Health",
            therapeuticCategory = "मेटाबॉलिक मिनरल इन्फ्यूजन (हाइपोकैल्सीमिया जीवनरक्षक)",
            standardDosagePerKg = "1 ml प्रति kg (350-450 ml प्रति वयस्क पशु)",
            route = "Slow Intravenous (Warm to Body Temperature) + SC",
            indications = "मिल्क फीवर (Milk Fever), हाइपोकैल्सीमिया, डाउनर काउ सिंड्रोम, प्रसव उपरांत कमजोरी।",
            contraindications = "ठंडा इन्फ्यूजन कभी न चढ़ाएं (हार्ट अटैक का खतरा)। दिल की धड़कन सुनते हुए धीमे चढ़ाएं।",
            pregnancySafety = "100% प्रेगनेंसी सुरक्षित (Safe)",
            withdrawalPeriod = "दूध: 0 दिन • मांस: 0 दिन",
            approxMrp = 360,
            commercialSubstitutes = listOf("Calci-Vet 450ml (₹160 Generic)", "Calci-Gold (₹210)")
        ),
        PharmacopeiaItem(
            id = "pharma_ivermectin",
            brandName = "Neomec 10ml / Hitek 1%",
            genericSalt = "Ivermectin 10 mg/ml (1% w/v)",
            manufacturer = "Virbac / Intas Animal Health",
            therapeuticCategory = "ब्रॉड-स्पेक्ट्रम एंडो व एक्टोपैरासाइटिसाइड (कृमि व चिचड़ी नाशक)",
            standardDosagePerKg = "0.2 mg/kg शारीरिक वजन (1ml प्रति 50kg body weight)",
            route = "Subcutaneous (SC) strictly under skin of neck",
            indications = "चिचड़ी, जूं, खाज-खुजली (Mange), पेट के गोल कृमि, फेफड़ों के कीड़े।",
            contraindications = "मांसपेशी (IM) या शिरा (IV) में कभी न दें। कोली (Collie) नस्ल के कुत्तों में वर्जित।",
            pregnancySafety = "100% प्रेगनेंसी सुरक्षित (Safe)",
            withdrawalPeriod = "दूध: 7 दिन • मांस: 28 दिन",
            approxMrp = 140,
            commercialSubstitutes = listOf("Iver-Vet 10ml (₹60 Generic)", "Vermic 10ml (₹55)")
        ),
        PharmacopeiaItem(
            id = "pharma_buserelin",
            brandName = "Receptal 2.5ml / 10ml",
            genericSalt = "Buserelin Acetate (GnRH Analogue 0.004 mg/ml)",
            manufacturer = "Intervet MSD Animal Health",
            therapeuticCategory = "गोनाडोट्रोपिन रिलीजिंग हार्मोन (प्रजनन नियामक)",
            standardDosagePerKg = "2.5 ml - 5.0 ml प्रति पशु (एकल खुराक)",
            route = "Intramuscular (IM) / Intravenous",
            indications = "सिस्टिक ओवेरियन सिंड्रोम, ओवुलेशन प्रेरण, ए.आई. के समय कंसेप्शन रेट बढ़ाने हेतु, रिपीट ब्रीडिंग।",
            contraindications = "गर्भावती पशुओं में आवश्यक नहीं।",
            pregnancySafety = "100% प्रेगनेंसी सुरक्षित (Safe)",
            withdrawalPeriod = "दूध: 0 दिन • मांस: 0 दिन",
            approxMrp = 380,
            commercialSubstitutes = listOf("Gynarich 2.5ml (₹220 Generic)", "Ovuprost (₹280)")
        ),
        PharmacopeiaItem(
            id = "pharma_cloprostenol",
            brandName = "Pragma 2ml / Lutalyse",
            genericSalt = "Cloprostenol Sodium 250 mcg/ml (PGF2alpha)",
            manufacturer = "Carus Animal Health / Zoetis",
            therapeuticCategory = "ल्यूटियोलाइटिक प्रोस्टाग्लैंडिन हार्मोन",
            standardDosagePerKg = "2 ml एकल खुराक (मांसपेशी में)",
            route = "Intramuscular (IM strictly)",
            indications = "पायोमेट्रा (मवाद वाली बच्चेदानी), मृत भ्रूण बाहर निकालना, जेर अड़ना, साइलेंट हीट सिंक्रोनाइजेशन।",
            contraindications = "🚨 गाभिन पशु में गर्भपात करा देगा! गर्भ स्थिति जांचे बिना कभी न लगाएं।",
            pregnancySafety = "❌ सख्त वर्जित (Induces Abortion)",
            withdrawalPeriod = "दूध: 0 दिन • मांस: 1 दिन",
            approxMrp = 220,
            commercialSubstitutes = listOf("Clopro-Vet 2ml (₹95 Generic)", "Vetmate 2ml (₹160)")
        ),
        PharmacopeiaItem(
            id = "pharma_chlorpheniramine",
            brandName = "Anistamin 30ml / Zeet Vet",
            genericSalt = "Chlorpheniramine Maleate 10 mg/ml (Antihistaminic)",
            manufacturer = "Intas Pharmaceuticals Ltd.",
            therapeuticCategory = "एंटीहिस्टामिनिक व एलर्जी रोधी",
            standardDosagePerKg = "0.5 mg/kg (5 - 10 ml प्रति वयस्क पशु)",
            route = "Intramuscular (IM)",
            indications = "दवा रिएक्शन, एनाफाइलेक्सिस, कीड़ा काटने की सूजन, खुजली, एलर्जी, जहरीला चारा खाने पर।",
            contraindications = "अत्यधिक उनींदापन हो सकता है।",
            pregnancySafety = "100% प्रेगनेंसी सुरक्षित (Safe)",
            withdrawalPeriod = "दूध: 1 दिन • मांस: 1 दिन",
            approxMrp = 75,
            commercialSubstitutes = listOf("CPM Vet 30ml (₹35 Generic)", "Cadistin Vet (₹65)")
        )
    )

    // ==============================================================
    // 🔬 REAL-TIME LAB & DIAGNOSTIC REPORT ANALYZER SAMPLES
    // ==============================================================
    val sampleLabReportAnalyses: List<LabReportAnalysis> = listOf(
        LabReportAnalysis(
            id = "rep_cbc_anemia",
            fileName = "हिसार_पशु_अस्पताल_CBC_Report_Pashu_1092.pdf",
            reportType = "पूर्ण रक्त गणना (Complete Blood Count - CBC)",
            sampleType = "EDTA Whole Blood",
            extractedParameters = mapOf(
                "Hemoglobin (Hb)" to "5.4 g/dL (गंभीर एनीमिया - सामान्य 8.0-12.0)",
                "Total Leukocyte Count (TLC)" to "16,400 /uL (ल्यूकोसाइटोसिस / संक्रमण)",
                "Platelet Count" to "1,20,000 /uL (थ्रोम्बोसाइटोपेनिया)",
                "Packed Cell Volume (PCV)" to "17.2% (तीव्र रक्त अल्पता)"
            ),
            tentativeDiagnosis = "हेमोप्रोटोजोअल संक्रमण (बेबेशियोसिस / थायलेरियासिस) जनित गंभीर एनीमिया",
            clinicalRecommendations = listOf(
                "Berenil (Diminazene) 7% इंजेक्शन 15ml Deep IM लगाएं।",
                "Tonophosphan 10ml IM + Feritas (आयरन डेक्सट्रान) 10ml IM 3 दिन दें।",
                "गंभीर स्थिति (Hb < 5) में 2-3 लीटर ताजा ब्लड ट्रांसफ्यूजन करवाएं।"
            ),
            criticalAlert = "🚨 हीमोग्लोबिन स्तर 5.4 g/dL पर आ चुका है! तत्काल एंटीप्रोटोजोअल व आयरन सपोर्टिव दें।"
        ),
        LabReportAnalysis(
            id = "rep_blood_smear",
            fileName = "माइक्रोस्कोपी_रक्त_स्मीयर_Giemsa_Stain.jpg",
            reportType = "रक्त स्मीयर माइक्रोस्कोपी (Blood Smear Examination)",
            sampleType = "Peripheral Blood Smear (Giemsa Stained)",
            extractedParameters = mapOf(
                "RBC Morphology" to "Microcytic hypochromic with Anisocytosis",
                "Hemoprotozoa Presence" to "Theileria annulata Piroplasms detected (++)",
                "Parasitemia Index" to "3.8% RBCs infested with ring and comma forms",
                "Neutrophils" to "74% (Toxic granules present)"
            ),
            tentativeDiagnosis = "बोवाइन थायलेरियासिस (Theileriosis) पुष्टिमार्ग संक्रमण",
            clinicalRecommendations = listOf(
                "Butalex (Buparvaquone 50mg/ml) 20ml गर्दन के मांस में Deep IM लगाएं।",
                "बुखार व सूजन नियंत्रण हेतु Melonex Plus 20ml IM दें।",
                "बाड़े में चिपकी चिचड़ियों को मारने हेतु Ivermectin 1% SC लगाएं।"
            ),
            criticalAlert = "⚠️ RBCs में थायलेरिया के छल्ले पाए गए हैं। तुरंत Buparvaquone का सिंगल शॉट लगवाएं।"
        ),
        LabReportAnalysis(
            id = "rep_milk_scc",
            fileName = "दुग्ध_परीक्षण_CMT_व_Somatic_Cell_Count.pdf",
            reportType = "कैलिफोर्निया मैस्टाइटिस टेस्ट व दैहिक कोशिका गणना (Milk SCC)",
            sampleType = "Quarter Milk Sample (Left Fore & Left Hind)",
            extractedParameters = mapOf(
                "Somatic Cell Count (SCC)" to "18,50,000 cells/ml (अति-उच्च - सामान्य < 2,00,000)",
                "CMT Gel Reaction" to "Grade 3+ (कठोर जैल थक्के - सबक्लिनिकल/क्लिनिकल थनैला)",
                "Milk pH" to "7.2 (क्षारीय दूध - सूजन का संकेत)",
                "Bacterial Culture" to "Streptococcus agalactiae isolate confirmed"
            ),
            tentativeDiagnosis = "सब-क्लिनिकल व क्रोनिक स्ट्रेप्टोकोकल थनैला (Streptococcal Mastitis)",
            clinicalRecommendations = listOf(
                "Intamox 3g (Amoxi-Clox) का 3 दिन का कोर्स IM दिलवाएं।",
                "थन पूरी तरह खाली करके Pendistrin-SH / Ceftri-Mast इंट्रा-मेमरी ट्यूब चढ़ाएं।",
                "हल्दी (50g) + एलोवेरा (250g) + चूना (10g) का लेप थन पर दिन में 3 बार लगाएं।"
            ),
            criticalAlert = "दूध में सोमैटिक सेल 18.5 लाख से अधिक हैं! बिना देरी इंट्रा-मेमरी व पैरेंट्रल एंटीबायोटिक दें।"
        )
    )

    // ==============================================================
    // 🌿 45 INDIGENOUS NDDB / IVRI VALIDATED HERBAL REMEDY BANK
    // ==============================================================
    val initialHerbalRemedies45: List<HerbalRemedy45> = listOf(
        HerbalRemedy45(
            id = "hr_01_acute_mastitis",
            conditionNameHindi = "तीव्र थनैला (Acute Mastitis)",
            conditionNameEnglish = "Acute Clinical Mastitis",
            anatomicalCategory = "UDDER_MILK",
            targetSpecies = "गाय व भैंस (Cattle & Buffalo)",
            ingredientsWithWeights = listOf(
                "ग्वारपाठा / एलोवेरा (Aloe vera) ताजे पत्ते: 250 ग्राम",
                "हल्दी पाउडर (Curcuma longa): 50 ग्राम",
                "कलाई चूना (Calcium hydroxide edible paste): 10 ग्राम",
                "नींबू का रस: 50 मिली (ओरल पिलाने हेतु)"
            ),
            preparationMethod = "एलोवेरा का गूदा निकालें। उसमें हल्दी पाउडर व कलाई चूना मिलाकर सिलबट्टे पर महीन पीसकर गाढ़ा पेस्ट बनाएं। इसमें 100 मिली पानी मिलाकर घोल तैयार करें।",
            dosageAndSchedule = "थन को अच्छी तरह खाली करने के बाद पूरे थन व लेवटी पर दिन में 3 से 4 बार लेप लगाएं। लगातार 5 दिन तक जारी रखें।",
            warningsAndPrecautions = "लेप लगाने से पहले थन का गंदा दूध पूरी तरह निकाल लें। लेप केवल बाहरी त्वचा पर लगाएं, थन के छेद के अंदर न डालें।"
        ),
        HerbalRemedy45(
            id = "hr_02_chronic_mastitis",
            conditionNameHindi = "पुराना गांठदार थनैला (Fibrotic Mastitis)",
            conditionNameEnglish = "Chronic Fibrotic Mastitis",
            anatomicalCategory = "UDDER_MILK",
            targetSpecies = "गाय व भैंस",
            ingredientsWithWeights = listOf(
                "कपूर (Camphor): 20 ग्राम",
                "सरसों का शुद्ध तेल: 200 मिली",
                "सेंधा नमक बारीक पिसा: 30 ग्राम",
                "लहसुन की कलियां: 50 ग्राम"
            ),
            preparationMethod = "सरसों के तेल को गर्म करें। उसमें लहसुन की कलियां डालकर भूरा होने तक पकाएं। आंच से उतारकर कपूर और सेंधा नमक घोलें। ठंडा होने पर कांच की शीशी में रखें।",
            dosageAndSchedule = "गुनगुने तेल से थन की कठोर गांठ पर नीचे से ऊपर की ओर 10 मिनट तक रोजाना 2 बार मालिश करें। 10-15 दिन नियमित करें।",
            warningsAndPrecautions = "थन पर घाव या छाले होने पर मालिश न करें। गांठ ज्यादा पुरानी होने पर डॉक्टर से फाइब्रोलिटिक बोलस भी दिलवाएं।"
        ),
        HerbalRemedy45(
            id = "hr_03_bloat",
            conditionNameHindi = "आफरा व पेट में गैस (Bloat & Tympany)",
            conditionNameEnglish = "Acute Ruminal Bloat / Frothy Tympany",
            anatomicalCategory = "ABDOMEN_DUNG",
            targetSpecies = "गाय, भैंस, बकरी व भेड़",
            ingredientsWithWeights = listOf(
                "सरसों या तीली का तेल: 250 से 300 मिली (बकरी हेतु 50 मिली)",
                "हींग (Asafoetida): 15 से 20 ग्राम",
                "तारपीन का तेल (Turpentine oil medicinal): 25 से 30 मिली",
                "सौंफ व अजवाइन: 50-50 ग्राम"
            ),
            preparationMethod = "हींग को पीसकर थोड़े गुनगुने पानी में घोलें। उसमें सरसों का तेल, तारपीन का तेल और अजवाइन का बारीक चूर्ण मिलाकर अच्छी तरह फेंटें।",
            dosageAndSchedule = "नाल द्वारा धीरे-धीरे पशु को तुरंत पिलाएं। यदि 1 घंटे में गैस न निकले तो आधी खुराक दोबारा दें।",
            warningsAndPrecautions = "पशु की जीभ कभी न पकड़ें, नाल सांस की नली में जाने का खतरा रहता है। पशु के मुंह में आड़ा लकड़ी का डंडा बांधें।"
        ),
        HerbalRemedy45(
            id = "hr_04_indigestion",
            conditionNameHindi = "भूख व जुगाली बंद / बदहजमी (Anorexia & Indigestion)",
            conditionNameEnglish = "Simple Indigestion / Off-Feed Anorexia",
            anatomicalCategory = "ABDOMEN_DUNG",
            targetSpecies = "समस्त पशु (Ruminants)",
            ingredientsWithWeights = listOf(
                "सोंठ (सूखा अदरक): 50 ग्राम",
                "काली मिर्च: 20 ग्राम",
                "सौंफ: 50 ग्राम",
                "काला नमक: 50 ग्राम",
                "मीठा सोडा (Sodium bicarbonate): 50 ग्राम",
                "गुड़: 250 ग्राम"
            ),
            preparationMethod = "सभी सूखी जड़ी-बूटियों को कूटकर बारीक चूर्ण बनाएं। गुड़ में मिलाकर 4 बड़े लड्डू बनाएं।",
            dosageAndSchedule = "सुबह और शाम 2-2 लड्डू 3 दिन तक जीभ पर रखें। जुगाली तुरंत शुरू होती है।",
            warningsAndPrecautions = "पानी हमेशा ताजा व गुनगुना पिलाएं। फफूंद लगा या सड़ा हुआ चारा बिल्कुल न दें।"
        ),
        HerbalRemedy45(
            id = "hr_05_calf_scours",
            conditionNameHindi = "बछड़ों के सफेद व पतले दस्त (Calf Scours / Diarrhea)",
            conditionNameEnglish = "Calf Scours & Bacterial Enteritis",
            anatomicalCategory = "ABDOMEN_DUNG",
            targetSpecies = "बछड़े व कटड़े (Calves)",
            ingredientsWithWeights = listOf(
                "मेथी दाना: 25 ग्राम",
                "हल्दी गांठ: 10 ग्राम",
                "सौंफ: 20 ग्राम",
                "अनार के सूखे छिलके: 25 ग्राम",
                "काला नमक: 10 ग्राम",
                "छाछ (मट्ठा): 500 मिली"
            ),
            preparationMethod = "मेथी, हल्दी, सौंफ व अनार के छिलकों को 1 लीटर पानी में उबालकर आधा रहने तक काढ़ा बनाएं। ठंडा होने पर छाछ व नमक मिलाएं।",
            dosageAndSchedule = "बछड़े को 100-150 मिली काढ़ा दिन में 3 बार 3 दिन तक पिलाएं। साथ में ओआरएस पानी दें।",
            warningsAndPrecautions = "दूध की मात्रा आधी कर दें। बछड़े को गीले फर्श से हटाकर सूखे पुआल पर रखें।"
        ),
        HerbalRemedy45(
            id = "hr_06_rop",
            conditionNameHindi = "जेर का रुकना (Retention of Placenta - ROP)",
            conditionNameEnglish = "Retained Fetal Membranes (RFM)",
            anatomicalCategory = "REPRO_CALVING",
            targetSpecies = "गाय व भैंस",
            ingredientsWithWeights = listOf(
                "बांस के ताजे हरे पत्ते: 1 किग्रा",
                "देसी गुड़: 500 ग्राम",
                "अजवाइन: 50 ग्राम",
                "सोंठ चूर्ण: 50 ग्राम",
                "काली जीरी: 25 ग्राम"
            ),
            preparationMethod = "बांस के पत्तों को 3 लीटर पानी में कूटकर डालें। उसमें गुड़, अजवाइन व सोंठ मिलाकर 15 मिनट उबालें।",
            dosageAndSchedule = "ब्याने के 4 से 6 घंटे बाद गुनगुना काढ़ा पिलाएं। जेर 2 घंटे के भीतर स्वतः गिर जाती है।",
            warningsAndPrecautions = "जेर पर ईंट या वजन कभी न बांधें। जेर को कभी जबरन हाथ से न खींचे।"
        ),
        HerbalRemedy45(
            id = "hr_07_prolapse",
            conditionNameHindi = "फूल/पाछा दिखाना (Uterine & Vaginal Prolapse)",
            conditionNameEnglish = "Vaginal and Uterine Prolapse",
            anatomicalCategory = "REPRO_CALVING",
            targetSpecies = "गाय व भैंस",
            ingredientsWithWeights = listOf(
                "फिटकरी (Alum): 50 ग्राम (धोने हेतु)",
                "बर्फ का ठंडा पानी: 5 लीटर",
                "बबूल की छाल का काढ़ा: 500 मिली",
                "ग्लिसरीन: 100 मिली",
                "लजावती (छुईमुई) पौधे का चूर्ण: 50 ग्राम"
            ),
            preparationMethod = "फिटकरी को ठंडे पानी में घोलकर बाहर निकले अंग को अच्छी तरह धोएं ताकि सूजन घटे। छुईमुई चूर्ण को गुड़ में मिलाकर अंदर खिलाने हेतु दें।",
            dosageAndSchedule = "धोने के बाद अंग पर ग्लिसरीन लगाकर चिकना करें। पशु को पीछे से 1 फीट ऊंचे फर्श पर खड़ा करें।",
            warningsAndPrecautions = "अंग पर गोबर व मिट्टी न लगने दें। डॉक्टर द्वारा अंदर करवाकर सूई से टांके लगवाना सुरक्षित है।"
        ),
        HerbalRemedy45(
            id = "hr_08_repeat_breeding",
            conditionNameHindi = "बार-बार फिरना / गुप्त मद (Repeat Breeding & Silent Heat)",
            conditionNameEnglish = "Repeat Breeding Syndrome & Anestrus",
            anatomicalCategory = "REPRO_CALVING",
            targetSpecies = "गाय व भैंस",
            ingredientsWithWeights = listOf(
                "उलट कंबल (Abroma augusta) की जड़ का चूर्ण: 30 ग्राम",
                "मेथी दाना: 100 ग्राम",
                "काली जीरी: 25 ग्राम",
                "एलोवेरा का ताजा गूदा: 150 ग्राम",
                "देसी गुड़: 250 ग्राम"
            ),
            preparationMethod = "मेथी दाना व काली जीरी को रातभर पानी में भिगोएं। सुबह एलोवेरा गूदे व गुड़ के साथ मिलाकर लड्डू बनाएं।",
            dosageAndSchedule = "सुबह खाली पेट रोजाना 7 दिन तक खिलाएं। पशु साफ डिस्चार्ज के साथ जोरदार हीट में आता है।",
            warningsAndPrecautions = "गाभिन पशु को यह नुस्खा कभी न दें (गर्भपात हो सकता है)।"
        ),
        HerbalRemedy45(
            id = "hr_09_fmd_lesions",
            conditionNameHindi = "खुरपका-मुंहपका के घाव (FMD Oral & Hoof Lesions)",
            conditionNameEnglish = "Foot and Mouth Disease Lesion Care",
            anatomicalCategory = "THROAT_CHEST",
            targetSpecies = "समस्त खुरदार पशु",
            ingredientsWithWeights = listOf(
                "फिटकरी पाउडर: 20 ग्राम (मुंह धोने हेतु)",
                "हल्दी पाउडर: 50 ग्राम",
                "बोरिक एसिड पाउडर: 50 ग्राम",
                "सरसों या तिल का तेल: 200 मिली",
                "कपूर: 20 ग्राम"
            ),
            preparationMethod = "फिटकरी को 2 लीटर गुनगुने पानी में घोलकर मुंह धोएं। सरसों के तेल में हल्दी, बोरिक एसिड व कपूर मिलाकर घावों का लेप तैयार करें।",
            dosageAndSchedule = "मुंह को दिन में 3 बार धोएं। खुरों के घावों पर लेप लगाकर नीम की पत्ती से सुरक्षित रखें। 5-7 दिन तक करें।",
            warningsAndPrecautions = "पशु को सूखा भूसा न दें, केवल मुलायम दलिया व गुड़ दें।"
        ),
        HerbalRemedy45(
            id = "hr_10_hs_supportive",
            conditionNameHindi = "गलघोंटू सहायक देखभाल (Hemorrhagic Septicemia Supportive)",
            conditionNameEnglish = "HS Throat Swelling Supportive Care",
            anatomicalCategory = "THROAT_CHEST",
            targetSpecies = "गाय व भैंस",
            ingredientsWithWeights = listOf(
                "काली मिर्च: 25 ग्राम",
                "लहसुन की कलियां: 50 ग्राम",
                "तुलसी के पत्ते: 50 ग्राम",
                "हल्दी गांठ: 50 ग्राम",
                "गुड़: 250 ग्राम"
            ),
            preparationMethod = "सभी सामग्रियों को सिलबट्टे पर बारीक पीसकर 1 लीटर पानी में 10 मिनट उबालें।",
            dosageAndSchedule = "गुनगुना काढ़ा 250 मिली दिन में 3 बार पिलाएं। यह श्वास नलिका की सूजन घटाने में सहायक है।",
            warningsAndPrecautions = "⚠️ गलघोंटू में तुरंत डॉक्टर से एंटीबायोटिक (Ceftriaxone) लगवाना जीवनरक्षक है। केवल घरेलू नुस्खे पर निर्भर न रहें।"
        ),
        HerbalRemedy45(
            id = "hr_11_bq_supportive",
            conditionNameHindi = "लंगड़ा बुखार प्राथमिक राहत (Black Quarter Supportive)",
            conditionNameEnglish = "BQ Muscle Crepitation Relief",
            anatomicalCategory = "LEGS_SKIN",
            targetSpecies = "गाय व बैल (Young Stock)",
            ingredientsWithWeights = listOf(
                "नीम की छाल व पत्ते: 250 ग्राम",
                "हल्दी: 100 ग्राम",
                "सेंधा नमक: 50 ग्राम",
                "कपूर: 25 ग्राम",
                "मिट्टी का तेल या तारपीन तेल: 50 मिली"
            ),
            preparationMethod = "नीम की छाल व हल्दी को पानी में उबालकर लेप बनाएं और उसमें कपूर व तारपीन तेल मिलाएं।",
            dosageAndSchedule = "पुट्ठे या कंधे की चड़-चड़ वाली सूजन पर हल्के हाथ से बाहरी लेप लगाएं।",
            warningsAndPrecautions = "सूजन पर चीरा केवल अधिकृत डॉक्टर ही लगाएं। तुरंत पेनिसिलिन का इंजेक्शन दिलवाएं।"
        ),
        HerbalRemedy45(
            id = "hr_12_milk_fever",
            conditionNameHindi = "मिल्क फीवर / कैल्शियम कमी (Milk Fever Supportive)",
            conditionNameEnglish = "Hypocalcemia & Downer Supportive Tonic",
            anatomicalCategory = "METABOLIC_GENERAL",
            targetSpecies = "उच्च दुग्ध उत्पादक गाय-भैंस",
            ingredientsWithWeights = listOf(
                "देसी चूना (Edible Lime paste): 50 ग्राम",
                "मीठा गुड़: 500 ग्राम",
                "सेंधा नमक: 30 ग्राम",
                "सौंफ व अजवाइन: 50-50 ग्राम",
                "गुनगुना पानी: 2 लीटर"
            ),
            preparationMethod = "चूने को 2 लीटर पानी में रातभर भिगोएं। सुबह ऊपर का साफ पानी निथार लें। उस पानी में गुड़, सेंधा नमक व अजवाइन घोलें।",
            dosageAndSchedule = "ब्याने के तुरंत बाद तथा अगले 3 दिन तक रोजाना एक बार नाल द्वारा पिलाएं।",
            warningsAndPrecautions = "बेहोश या लेटे हुए पशु को जबरन नाल न पिलाएं (Drenching pneumonia का खतरा)। डॉक्टर से Mifex IV चढ़वाएं।"
        ),
        HerbalRemedy45(
            id = "hr_13_ketosis",
            conditionNameHindi = "कीटोसिस व मीठी सांस (Bovine Ketosis Herbal Energy)",
            conditionNameEnglish = "Ketosis Energy Booster",
            anatomicalCategory = "METABOLIC_GENERAL",
            targetSpecies = "गाय व भैंस",
            ingredientsWithWeights = listOf(
                "देसी गुड़: 500 ग्राम",
                "मीठा सोडा (Sodium bicarbonate): 100 ग्राम",
                "ईस्ट पाउडर (Live Baker's Yeast): 25 ग्राम",
                "नींबू का रस: 50 मिली"
            ),
            preparationMethod = "गुड़ को 1 लीटर पानी में घोलकर चाशनी जैसा बनाएं। उसमें मीठा सोडा, नींबू रस व ईस्ट पाउडर मिलाएं।",
            dosageAndSchedule = "सुबह व शाम 4 दिन तक लगातार पिलाएं। रूमेन पीएच संतुलित होकर ग्लूकोज बढ़ता है।",
            warningsAndPrecautions = "दाना-चोकर 3 दिन बंद रखें, सूखा चारा ही खिलाएं।"
        ),
        HerbalRemedy45(
            id = "hr_14_ectoparasites",
            conditionNameHindi = "चिचड़ी, जूं, किलनी व अठई (Ectoparasites / Ticks & Lice)",
            conditionNameEnglish = "Ticks, Fleas, Lice & Mites Eradication",
            anatomicalCategory = "SKIN_PARASITES",
            targetSpecies = "समस्त पशु",
            ingredientsWithWeights = listOf(
                "नीम का शुद्ध तेल: 250 मिली",
                "कपूर की टिकिया: 25 ग्राम",
                "सीताफल (शरीफा) के बीजों का चूर्ण: 50 ग्राम",
                "तारपीन का तेल: 25 मिली"
            ),
            preparationMethod = "नीम के तेल में कपूर घोलें और सीताफल के बीजों का चूर्ण व तारपीन तेल मिलाकर अच्छी तरह हिलाएं।",
            dosageAndSchedule = "धूप के समय पशु के पूरे शरीर पर, विशेषकर जांघों, कान के पीछे व पूंछ पर मालिश करें। 3 दिन बाद धोएं।",
            warningsAndPrecautions = "आंखों व मुंह के अंदर यह तेल न जाने दें। बाड़े की दरारों में चूना छिड़कें।"
        ),
        HerbalRemedy45(
            id = "hr_15_ringworm",
            conditionNameHindi = "दाद व गोल चकत्ते (Ringworm & Skin Mycosis)",
            conditionNameEnglish = "Dermatophytosis / Ringworm",
            anatomicalCategory = "SKIN_PARASITES",
            targetSpecies = "बछड़े व वयस्क पशु",
            ingredientsWithWeights = listOf(
                "गंधक (सल्फर पाउडर): 50 ग्राम",
                "सरसों का तेल: 200 मिली",
                "नीम का तेल: 50 मिली",
                "कपूर: 10 ग्राम"
            ),
            preparationMethod = "सरसों के तेल में नीम का तेल, गंधक और कपूर मिलाकर गाढ़ा मलम तैयार करें।",
            dosageAndSchedule = "दाद की सफेद पपड़ी को साबुन पानी से खुरचकर साफ करें। फिर रोजाना दिन में 2 बार यह लेप लगाएं। 7 दिन में दाद पूरी तरह खत्म हो जाता है।",
            warningsAndPrecautions = "दाद छूने के बाद अपने हाथ साबुन से धोएं, यह इंसानों में भी फैल सकता है।"
        ),
        HerbalRemedy45(
            id = "hr_16_lsd",
            conditionNameHindi = "गांठदार त्वचा रोग लेप (Lumpy Skin Disease Care)",
            conditionNameEnglish = "LSD Skin Nodules & Wound Healer",
            anatomicalCategory = "SKIN_PARASITES",
            targetSpecies = "गाय व गोवंश",
            ingredientsWithWeights = listOf(
                "नीम के पत्ते: 250 ग्राम",
                "हल्दी पाउडर: 100 ग्राम",
                "काली मिर्च: 25 ग्राम",
                "लहसुन: 50 ग्राम",
                "देसी घी या नारियल तेल: 150 मिली",
                "कपूर: 20 ग्राम"
            ),
            preparationMethod = "नीम, हल्दी, काली मिर्च व लहसुन को पीसकर नारियल तेल में धीमी आंच पर पकाएं। उतारकर कपूर मिलाएं।",
            dosageAndSchedule = "शरीर की सभी फूटी हुई गांठों व घावों पर दिन में 2 बार लेप करें। मक्खियां बिल्कुल नहीं बैठेंगी।",
            warningsAndPrecautions = "बाड़े में नीम के पत्तों का धुआं करें ताकि मच्छर व मक्खियां दूर रहें।"
        ),
        HerbalRemedy45(
            id = "hr_17_eye_infection",
            conditionNameHindi = "आंखों में जाला / पानी गिरना (Corneal Opacity & Eye Infections)",
            conditionNameEnglish = "Infectious Bovine Keratoconjunctivitis",
            anatomicalCategory = "THROAT_CHEST",
            targetSpecies = "समस्त पशु",
            ingredientsWithWeights = listOf(
                "शुद्ध गुलाब जल: 100 मिली",
                "फिटकरी भस्म (फुला): 2 ग्राम",
                "शुद्ध शहद (Honey): 20 ग्राम",
                "बोरिक एसिड: 3 ग्राम"
            ),
            preparationMethod = "गुलाब जल में फिटकरी भस्म व बोरिक एसिड घोलकर महीन कपड़े से 3 बार छानें। अंत में शहद मिलाएं।",
            dosageAndSchedule = "ड्रॉपर की सहायता से आंख में 3-4 बूंद दिन में 3 बार डालें। 3 से 5 दिन में आंख का जाला व सफेदी साफ हो जाती है।",
            warningsAndPrecautions = "घोल पूरी तरह कण-मुक्त होना चाहिए। तेज धूप से पशु को बचाकर छायादार शेड में रखें।"
        ),
        HerbalRemedy45(
            id = "hr_18_cough_cold",
            conditionNameHindi = "खांसी व नजला (Cough, Cold & Bronchitis)",
            conditionNameEnglish = "Bovine Cough & Upper Respiratory Relief",
            anatomicalCategory = "THROAT_CHEST",
            targetSpecies = "गाय, भैंस, बकरी",
            ingredientsWithWeights = listOf(
                "तुलसी के पत्ते: 50 ग्राम",
                "अदरक / सोंठ: 50 ग्राम",
                "काली मिर्च: 15 ग्राम",
                "मुलेठी चूर्ण: 30 ग्राम",
                "देसी गुड़: 200 ग्राम"
            ),
            preparationMethod = "सभी जड़ी-बूटियों को 1.5 लीटर पानी में उबालकर 500 मिली काढ़ा तैयार करें।",
            dosageAndSchedule = "गुनगुना काढ़ा दिन में 2 बार 4 दिन तक पिलाएं। रात को नीलगिरी तेल की भाप दें।",
            warningsAndPrecautions = "पशु को ठंडी हवा व खुले आसमान के नीचे न बांधें।"
        ),
        HerbalRemedy45(
            id = "hr_19_maggot_wounds",
            conditionNameHindi = "कीड़े पड़े सड़े घाव (Maggot Infested Wounds)",
            conditionNameEnglish = "Maggot Wound Antiseptic & Larvicide",
            anatomicalCategory = "LEGS_SKIN",
            targetSpecies = "समस्त पशु",
            ingredientsWithWeights = listOf(
                "तारपीन का शुद्ध तेल (Turpentine): 100 मिली",
                "कपूर: 25 ग्राम",
                "सीताफल के पत्तों का अर्क: 50 मिली",
                "नीम का तेल: 100 मिली"
            ),
            preparationMethod = "तारपीन के तेल में कपूर को पूरी तरह घोलें। उसमें नीम का तेल व सीताफल पत्तों का रस मिलाएं।",
            dosageAndSchedule = "घाव के अंदर रुई भिगोकर यह तेल भरें। 5 मिनट में सारे कीड़े (Maggots) बाहर गिरकर मर जाते हैं।",
            warningsAndPrecautions = "कीड़ों को चिमटी से निकालें। घाव पर मक्खी न बैठने हेतु फिनाइल या टॉपिक्योर स्प्रे करें।"
        ),
        HerbalRemedy45(
            id = "hr_20_heat_stress",
            conditionNameHindi = "लू लगना व हांफना (Heat Stress & Sunstroke)",
            conditionNameEnglish = "Summer Heat Stress & Hyperthermia Cooler",
            anatomicalCategory = "METABOLIC_GENERAL",
            targetSpecies = "एचएफ गाय, जर्सी व भैंस",
            ingredientsWithWeights = listOf(
                "प्याज का रस: 200 मिली",
                "पुदीना पत्ता चटनी: 100 ग्राम",
                "सौंफ का शरबत: 100 मिली",
                "देसी खांड या गुड़: 250 ग्राम",
                "सेंधा नमक: 25 ग्राम",
                "ठंडा पानी: 3 लीटर"
            ),
            preparationMethod = "ठंडे पानी में प्याज का रस, पुदीना, सौंफ शरबत, खांड व सेंधा नमक घोलें।",
            dosageAndSchedule = "दोपहर के समय पशु को पिलाएं तथा सिर पर ठंडा पानी 15 मिनट तक धार बनाकर डालें।",
            warningsAndPrecautions = "पशु के शरीर पर तेज धूप न पड़ने दें। शेड में पंखा या फव्वारा (Fogger) लगाएं।"
        ),
        HerbalRemedy45(
            id = "hr_21_deworming_tonic",
            conditionNameHindi = "पेट के कीड़े / कृमिनाशक टॉनिक (Internal Worms Herbal Dewormer)",
            conditionNameEnglish = "Herbal Anti-Parasitic & Deworming Formula",
            anatomicalCategory = "ABDOMEN_DUNG",
            targetSpecies = "गाय, भैंस, बकरी",
            ingredientsWithWeights = listOf(
                "वायविडंग (Vidanga seeds): 50 ग्राम",
                "कद्दू के छिले बीज (Pumpkin seeds): 50 ग्राम",
                "पलाश (ढाक) के बीज चूर्ण: 25 ग्राम",
                "हींग: 10 ग्राम",
                "देसी गुड़: 150 ग्राम"
            ),
            preparationMethod = "सभी बीजों को कूटकर बारीक चूर्ण बनाएं और गुड़ में मिलाकर 2 बड़े लड्डू बनाएं।",
            dosageAndSchedule = "सुबह खाली पेट खिलाएं। 2 घंटे बाद 100 ग्राम अरंडी का तेल पिलाएं ताकि मरे हुए कीड़े गोबर से बाहर निकल जाएं।",
            warningsAndPrecautions = "हर 3 महीने में यह प्राकृतिक डीवॉर्मिंग दोहराएं।"
        ),
        HerbalRemedy45(
            id = "hr_22_accidental_poisoning",
            conditionNameHindi = "विषाक्त चारा व कीटनाशक राहत (Poisoning First Aid)",
            conditionNameEnglish = "Toxic Ingestion / Pesticide First-Aid Charcoal",
            anatomicalCategory = "ABDOMEN_DUNG",
            targetSpecies = "समस्त पशु",
            ingredientsWithWeights = listOf(
                "सक्रिय लकड़ी का कोयला चूर्ण (Activated Charcoal): 250 ग्राम",
                "कच्चे अंडों की जर्दी: 4 नग",
                "गाय का दूध: 1 लीटर",
                "गुड़ का शीरा: 250 ग्राम"
            ),
            preparationMethod = "कोयले के चूर्ण को दूध और फेंटे हुए अंडों में घोलकर गाढ़ा सस्पेंशन बनाएं।",
            dosageAndSchedule = "तुरंत नाल द्वारा पिलाएं। कोयला पेट में मौजूद जहर को सोखकर रक्त में जाने से रोकता है।",
            warningsAndPrecautions = "यह केवल प्राथमिक उपचार है। तुरंत पशु चिकित्सक को बुलाकर एट्रोपिन इंजेक्शन लगवाएं।"
        ),
        HerbalRemedy45(
            id = "hr_23_udder_edema",
            conditionNameHindi = "लेवटी की सूजन / एडीमा (Parturient Udder Edema)",
            conditionNameEnglish = "Physiological Udder Edema Relief",
            anatomicalCategory = "UDDER_MILK",
            targetSpecies = "गाय व भैंस",
            ingredientsWithWeights = listOf(
                "पुनर्नवा (Boerhavia diffusa) चूर्ण: 50 ग्राम",
                "गोखरू चूर्ण: 50 ग्राम",
                "जौ का पानी (Barley water): 2 लीटर",
                "सेंधा नमक: 10 ग्राम"
            ),
            preparationMethod = "जौ, पुनर्नवा व गोखरू को पानी में 20 मिनट उबालकर मूत्रवर्धक काढ़ा बनाएं।",
            dosageAndSchedule = "दिन में 2 बार 3 दिन तक पिलाएं। पेशाब खुलकर आता है और लेवटी का पानी सूख जाता है।",
            warningsAndPrecautions = "दाने में सादा नमक बिल्कुल बंद कर दें। लेवटी पर ठंडी मालिश करें।"
        ),
        HerbalRemedy45(
            id = "hr_24_blood_in_milk",
            conditionNameHindi = "दूध में खून आना (Hemolactia / Blood in Milk)",
            conditionNameEnglish = "Blood in Milk Coagulant Remedy",
            anatomicalCategory = "UDDER_MILK",
            targetSpecies = "गाय व भैंस",
            ingredientsWithWeights = listOf(
                "कपूर की टिकिया: 5 ग्राम",
                "केला पका हुआ: 2 नग",
                "फिटकरी पाउडर: 10 ग्राम",
                "ठंडा दूध: 250 मिली"
            ),
            preparationMethod = "केले के बीच में कपूर की टिकिया रखकर पशु को खिलाएं। फिटकरी को 250 मिली ठंडे दूध में घोलकर पिलाएं।",
            dosageAndSchedule = "दिन में 2 बार 3 दिन तक दें। थन पर ठंडे बर्फ के पानी की सिकाई करें।",
            warningsAndPrecautions = "थन पर कभी गर्म सेंक न करें (खून का बहाव तेज हो सकता है)।"
        ),
        HerbalRemedy45(
            id = "hr_25_teat_cracks",
            conditionNameHindi = "थन चीरा व मस्से (Teat Chaps & Warts)",
            conditionNameEnglish = "Teat Fissures & Warts Healer",
            anatomicalCategory = "UDDER_MILK",
            targetSpecies = "गाय व भैंस",
            ingredientsWithWeights = listOf(
                "देसी गाय का घी: 100 ग्राम",
                "हल्दी पाउडर: 25 ग्राम",
                "सुहागा (Borax) भस्म: 10 ग्राम",
                "मोम (Beeswax): 20 ग्राम"
            ),
            preparationMethod = "घी और मोम को पिघलाएं। उसमें हल्दी व सुहागा भस्म मिलाकर ठंडा करके मलहम बनाएं।",
            dosageAndSchedule = "दूध निकालने के बाद थनों की दरारों व मस्सों पर लेप करें। 5 दिन में दरारें भर जाती हैं।",
            warningsAndPrecautions = "दूध दोहने से पहले थन को गुनगुने पानी से पोंछना न भूलें।"
        ),
        HerbalRemedy45(
            id = "hr_26_foot_rot",
            conditionNameHindi = "खुर सड़न व फुटरोट (Infectious Foot Rot)",
            conditionNameEnglish = "Foot Rot & Interdigital Necrosis Healer",
            anatomicalCategory = "LEGS_SKIN",
            targetSpecies = "गाय, भैंस, भेड़, बकरी",
            ingredientsWithWeights = listOf(
                "नीला थोथा (Copper sulfate): 50 ग्राम (हौज हेतु)",
                "तारपीन का तेल: 50 मिली",
                "कपूर: 10 ग्राम",
                "कत्था पाउडर: 20 ग्राम"
            ),
            preparationMethod = "नीले थोथे के 5% घोल में पैर को 5 मिनट डुबोकर धोएं। कत्था व कपूर को तारपीन तेल में मिलाकर घाव में पट्टी बांधें।",
            dosageAndSchedule = "रोजाना सुबह-शाम 4 दिन तक करें। सड़ा हुआ खुर सूखकर नया खुर बनता है।",
            warningsAndPrecautions = "पशु को कीचड़ व दलदल में न बांधें। बाड़े का फर्श सूखा रखें।"
        ),
        HerbalRemedy45(
            id = "hr_27_joint_ill",
            conditionNameHindi = "जोड़ों की सूजन व लंगड़ापन (Arthritis & Joint Ill)",
            conditionNameEnglish = "Joint Inflammation & Swelling Liniment",
            anatomicalCategory = "LEGS_SKIN",
            targetSpecies = "बछड़े व वयस्क पशु",
            ingredientsWithWeights = listOf(
                "धतूरे के पत्तों का रस: 100 मिली",
                "आक (मदार) के पत्तों का रस: 100 मिली",
                "सरसों का तेल: 250 मिली",
                "लहसुन पिसा हुआ: 50 ग्राम"
            ),
            preparationMethod = "सरसों के तेल में धतूरा व आक का रस तथा लहसुन डालकर धीमी आंच पर तेल जलने तक पकाएं। छानकर रखें।",
            dosageAndSchedule = "सूजे हुए जोड़ों पर गुनगुने तेल की 10 मिनट मालिश करें और गर्म पट्टी बांधें।",
            warningsAndPrecautions = "यह तेल विषैला है, मुंह या आंखों में न लगने दें। घाव पर न लगाएं।"
        ),
        HerbalRemedy45(
            id = "hr_28_fracture_sprain",
            conditionNameHindi = "हड्डी मोच व अंदरूनी चोट (Sprain & Bone Bruise)",
            conditionNameEnglish = "Bone Sprain & Deep Tissue Repair Paste",
            anatomicalCategory = "LEGS_SKIN",
            targetSpecies = "समस्त पशु",
            ingredientsWithWeights = listOf(
                "हड़जोड़ (Cissus quadrangularis) का तना: 200 ग्राम",
                "मैदा या गेहूं का आटा: 100 ग्राम",
                "हल्दी पाउडर: 50 ग्राम",
                "चूना: 15 ग्राम"
            ),
            preparationMethod = "हड़जोड़ को पीसकर पेस्ट बनाएं। उसमें हल्दी, आटा व थोड़ा चूना मिलाकर गर्म लेप तैयार करें।",
            dosageAndSchedule = "मोच या चोट वाले स्थान पर मोटा लेप लगाकर बांस की खपच्ची (Splint) बांधें।",
            warningsAndPrecautions = "हड्डी टूट (Open fracture) में तुरंत ऑर्थोपेडिक प्लास्टर डॉक्टर से करवाएं।"
        ),
        HerbalRemedy45(
            id = "hr_29_downer_cow",
            conditionNameHindi = "बैठी गाय हेतु स्नायु टॉनिक (Downer Cow Nerve Tonic)",
            conditionNameEnglish = "Downer Cow Nerve & Muscle Revitalizer",
            anatomicalCategory = "LEGS_SKIN",
            targetSpecies = "गाय व भैंस",
            ingredientsWithWeights = listOf(
                "अश्वगंधा चूर्ण: 50 ग्राम",
                "कौंच के बीज चूर्ण: 50 ग्राम",
                "सोंठ: 30 ग्राम",
                "देसी घी: 100 ग्राम",
                "शहद या गुड़: 200 ग्राम"
            ),
            preparationMethod = "घी में सोंठ भूनें। अश्वगंधा व कौंच चूर्ण मिलाकर गुड़ की चाशनी में लड्डू बनाएं।",
            dosageAndSchedule = "रोजाना सुबह-शाम 7 दिन तक खिलाएं। पैरों की नसों में रक्त संचार तेज होता है।",
            warningsAndPrecautions = "पशु की करवट हर 4 घंटे बाद बदलें ताकि नसें न दबें। रेत का बिछावन दें।"
        ),
        HerbalRemedy45(
            id = "hr_30_dehydration",
            conditionNameHindi = "बछड़ों में निर्जलीकरण (Calf Dehydration ORS)",
            conditionNameEnglish = "Electrolyte Rehydration Solution (Homemade ORS)",
            anatomicalCategory = "ABDOMEN_DUNG",
            targetSpecies = "बछड़े व कटड़े",
            ingredientsWithWeights = listOf(
                "उबला हुआ ठंडा पानी: 2 लीटर",
                "ग्लूकोज या चीनी: 50 ग्राम",
                "सेंधा नमक: 5 ग्राम",
                "मीठा सोडा (Baking soda): 5 ग्राम",
                "नींबू रस: 10 मिली"
            ),
            preparationMethod = "पानी में चीनी, नमक, मीठा सोडा और नींबू का रस घोलकर घर का शुद्ध इलेक्ट्रोलाइट बनाएं।",
            dosageAndSchedule = "500 मिली घोल दिन में 4 बार बछड़े को गुनगुना पिलाएं।",
            warningsAndPrecautions = "घोल हमेशा 12 घंटे के भीतर ताजा बनाकर ही पिलाएं।"
        ),
        HerbalRemedy45(
            id = "hr_31_liver_tonic",
            conditionNameHindi = "लिवर टॉनिक व पीलिया (Jaundice & Liver Tonic)",
            conditionNameEnglish = "Hepatic Stimulant & Jaundice Cleanser",
            anatomicalCategory = "ABDOMEN_DUNG",
            targetSpecies = "समस्त पशु",
            ingredientsWithWeights = listOf(
                "भूमि आंवला (Phyllanthus niruri): 100 ग्राम",
                "कालमेघ (Andrographis paniculata): 50 ग्राम",
                "कुटकी: 20 ग्राम",
                "गिलोय का तना: 100 ग्राम",
                "गुड़: 200 ग्राम"
            ),
            preparationMethod = "सभी जड़ी-बूटियों को 2 लीटर पानी में उबालकर 500 मिली काढ़ा बनाएं। गुड़ मिलाएं।",
            dosageAndSchedule = "सुबह खाली पेट 250 मिली काढ़ा 5 दिन तक दें। पीलिया व भूख न लगना ठीक होता है।",
            warningsAndPrecautions = "पशु को गरिष्ठ व फफूंद लगा दाना बिल्कुल न दें।"
        ),
        HerbalRemedy45(
            id = "hr_32_acidosis",
            conditionNameHindi = "अनाज खाकर खट्टा पेट / एसिडोसिस (Grain Overload / Acidosis)",
            conditionNameEnglish = "Ruminal Lactic Acidosis Neutralizer",
            anatomicalCategory = "ABDOMEN_DUNG",
            targetSpecies = "गाय व भैंस",
            ingredientsWithWeights = listOf(
                "मीठा सोडा (Sodium bicarbonate): 150 ग्राम",
                "मैग्नीशियम ऑक्साइड / हाइड्रोक्साइड: 100 ग्राम",
                "ठंडा पानी: 2 लीटर",
                "सौंफ का अर्क: 50 मिली"
            ),
            preparationMethod = "ठंडे पानी में मीठा सोडा और मैग्नीशियम ऑक्साइड अच्छी तरह घोलें।",
            dosageAndSchedule = "नाल द्वारा तुरंत पिलाएं। रूमेन की एसिडिटी (pH < 5) तुरंत सामान्य (6.5) होती है।",
            warningsAndPrecautions = "अनाज, चोकर व गुड़ बिल्कुल न दें। 48 घंटे केवल सूखा भूसा ही दें।"
        ),
        HerbalRemedy45(
            id = "hr_33_alkalosis",
            conditionNameHindi = "यूरिया व क्षारीय आफरा (Ruminal Alkalosis / Urea Toxicity)",
            conditionNameEnglish = "Urea Poisoning & Alkaline Rumen Neutralizer",
            anatomicalCategory = "ABDOMEN_DUNG",
            targetSpecies = "गाय व भैंस",
            ingredientsWithWeights = listOf(
                "सिरका (Vinegar / Acetic acid): 1 से 1.5 लीटर",
                "ठंडा पानी: 3 लीटर",
                "नींबू का रस: 15-20 नींबू का रस"
            ),
            preparationMethod = "ठंडे पानी में सिरका और नींबू का रस मिलाकर एसिडिक ड्रेंच तैयार करें।",
            dosageAndSchedule = "तुरंत नाल द्वारा पिलाएं। रूमेन का बढ़ा हुआ क्षारीय पीएच (pH > 7.5) घटकर सामान्य होता है।",
            warningsAndPrecautions = "यूरिया विषाक्तता में समय बहुत कम होता है, तुरंत डॉक्टर को भी सूचित करें।"
        ),
        HerbalRemedy45(
            id = "hr_34_metritis",
            conditionNameHindi = "गर्भाशय सूजन व बदबूदार मैला (Metritis & Endometritis)",
            conditionNameEnglish = "Uterine Infection & Cleansing Decoction",
            anatomicalCategory = "REPRO_CALVING",
            targetSpecies = "गाय व भैंस",
            ingredientsWithWeights = listOf(
                "मेथी दाना: 250 ग्राम",
                "अजवाइन: 100 ग्राम",
                "सोंठ: 50 ग्राम",
                "हल्दी: 50 ग्राम",
                "देसी गुड़: 500 ग्राम",
                "काली जीरी: 25 ग्राम"
            ),
            preparationMethod = "सभी सामग्रियों को 3 लीटर पानी में 20 मिनट उबालें।",
            dosageAndSchedule = "ब्याने के बाद 5 दिन तक रोजाना सुबह गुनगुना काढ़ा दें। गर्भाशय की पूरी सफाई हो जाती है।",
            warningsAndPrecautions = "बदबूदार पस ज्यादा होने पर डॉक्टर से इंट्रा-यूटेराइन एंटीबायोटिक भी डलवाएं।"
        ),
        HerbalRemedy45(
            id = "hr_35_silent_heat",
            conditionNameHindi = "गुम मद व हीट न दिखना (Silent Heat Activator)",
            conditionNameEnglish = "Silent Estrus & Ovarian Follicle Stimulator",
            anatomicalCategory = "REPRO_CALVING",
            targetSpecies = "भैंस व संकर गाय",
            ingredientsWithWeights = listOf(
                "अंकुरित गेहूं (Sprouted wheat): 500 ग्राम",
                "मेथी दाना उबला हुआ: 100 ग्राम",
                "तिल (Sesame seeds): 100 ग्राम",
                "गुड़: 200 ग्राम"
            ),
            preparationMethod = "अंकुरित गेहूं को तिल, उबली मेथी और गुड़ के साथ मिलाकर दाने में दें।",
            dosageAndSchedule = "रोजाना शाम को 10 दिन तक खिलाएं। प्राकृतिक विटामिन-ई से अंडाशय सक्रिय होता है।",
            warningsAndPrecautions = "सुबह 5 बजे व रात 10 बजे योनि के डिस्चार्ज की सावधानी से निगरानी करें।"
        ),
        HerbalRemedy45(
            id = "hr_36_agalactia",
            conditionNameHindi = "दूध न उतारना व पावसना (Milk Letdown Failure / Agalactia)",
            conditionNameEnglish = "Milk Letdown & Oxytocin Alternative Tonic",
            anatomicalCategory = "UDDER_MILK",
            targetSpecies = "गाय व भैंस",
            ingredientsWithWeights = listOf(
                "शतावरी (Asparagus racemosus) चूर्ण: 50 ग्राम",
                "सफेद जीरा भुना हुआ: 50 ग्राम",
                "सौंफ: 50 ग्राम",
                "देसी खांड या गुड़: 200 ग्राम"
            ),
            preparationMethod = "शतावरी, जीरा व सौंफ के चूर्ण को गुड़ में मिलाकर 2 लड्डू बनाएं।",
            dosageAndSchedule = "दूध निकालने से 30 मिनट पहले खिलाएं। 5 दिन में पशु प्रेम से दूध उतारने लगता है।",
            warningsAndPrecautions = "पशु को कभी लाठी से न डराएं, डरने से एड्रेनालिन हार्मोन दूध रोक लेता है।"
        ),
        HerbalRemedy45(
            id = "hr_37_calf_pneumonia",
            conditionNameHindi = "बछड़े का निमोनिया व पसली चलना (Calf Pneumonia Relief)",
            conditionNameEnglish = "Pediatric Calf Respiratory & Bronchial Relief",
            anatomicalCategory = "THROAT_CHEST",
            targetSpecies = "बछड़े व कटड़े",
            ingredientsWithWeights = listOf(
                "तुलसी पत्ता रस: 20 मिली",
                "अदरक रस: 10 मिली",
                "काली मिर्च चूर्ण: 3 ग्राम",
                "शुद्ध शहद: 20 ग्राम"
            ),
            preparationMethod = "तुलसी व अदरक के रस में काली मिर्च चूर्ण और शहद मिलाकर चाटन बनाएं।",
            dosageAndSchedule = "बछड़े की जीभ पर दिन में 3 बार 4 दिन तक चटाएं।",
            warningsAndPrecautions = "बछड़े के सीने पर तारपीन तेल की मालिश करें और गर्म बोरी से ढकें।"
        ),
        HerbalRemedy45(
            id = "hr_38_enterotoxemia",
            conditionNameHindi = "आंत जहरबाद / फिड़किया (Enterotoxemia Relief)",
            conditionNameEnglish = "Clostridial Enterotoxemia Herbal Adsorbent",
            anatomicalCategory = "ABDOMEN_DUNG",
            targetSpecies = "भेड़ व बकरी (Small Ruminants)",
            ingredientsWithWeights = listOf(
                "लकड़ी का पिसा कोयला: 50 ग्राम",
                "सोंठ चूर्ण: 15 ग्राम",
                "हींग: 5 ग्राम",
                "छाछ: 250 मिली"
            ),
            preparationMethod = "छाछ में कोयला, सोंठ और हींग मिलाकर घोलें।",
            dosageAndSchedule = "बकरी/भेड़ को तुरंत नाल द्वारा पिलाएं।",
            warningsAndPrecautions = "मानसून से पहले ईटी (ET) वैक्सीन लगवाना शत-प्रतिशत अनिवार्य है।"
        ),
        HerbalRemedy45(
            id = "hr_39_coccidiosis",
            conditionNameHindi = "खूनी पेचिश व आंत मरोड़ (Bloody Coccidiosis Dung)",
            conditionNameEnglish = "Coccidial Dysentery & Intestinal Healer",
            anatomicalCategory = "ABDOMEN_DUNG",
            targetSpecies = "बछड़े व वयस्क पशु",
            ingredientsWithWeights = listOf(
                "बेल का सूखा गूदा चूर्ण: 50 ग्राम",
                "अनार के छिलके का काढ़ा: 100 मिली",
                "कुटज (कड़ाया) छाल चूर्ण: 25 ग्राम",
                "ताजी मीठी छाछ: 500 मिली"
            ),
            preparationMethod = "अनार के छिलके के काढ़े में बेल गूदा और कुटज चूर्ण छाछ के साथ मिलाएं।",
            dosageAndSchedule = "दिन में 2 बार 4 दिन तक पिलाएं। खूनी दस्त व पेट की मरोड़ बंद होती है।",
            warningsAndPrecautions = "बाड़े के फर्श पर चूना छिड़कें ताकि प्रोटोजोआ के अंडे नष्ट हों।"
        ),
        HerbalRemedy45(
            id = "hr_40_skin_scabies",
            conditionNameHindi = "हाथी जैसी मोटी चमड़ी व खाज (Sarcoptic Scabies & Mange)",
            conditionNameEnglish = "Chronic Sarcoptic Mange Keratolytic Salve",
            anatomicalCategory = "SKIN_PARASITES",
            targetSpecies = "समस्त पशु",
            ingredientsWithWeights = listOf(
                "नीम का तेल: 200 मिली",
                "करण्ज (Pongamia) का तेल: 100 मिली",
                "सल्फर (गंधक) बारीक पाउडर: 50 ग्राम",
                "कपूर: 20 ग्राम"
            ),
            preparationMethod = "नीम व करञ्ज के तेल में गंधक व कपूर मिलाकर धूप में 2 घंटे रखें।",
            dosageAndSchedule = "मोटी खुरदरी चमड़ी पर ब्रश से अच्छी तरह मलें। हफ्ते में 2 बार 3 सप्ताह तक करें।",
            warningsAndPrecautions = "उपचार के बाद पशु को 2 घंटे तक चाटने न दें।"
        ),
        HerbalRemedy45(
            id = "hr_41_fly_repellent",
            conditionNameHindi = "मक्खी-मच्छर भगाने का देसी स्प्रे (Herbal Fly & Mosquito Repellent)",
            conditionNameEnglish = "Natural Cattle Barn Insect Repellent Spray",
            anatomicalCategory = "SKIN_PARASITES",
            targetSpecies = "डेयरी शेड व समस्त पशु",
            ingredientsWithWeights = listOf(
                "नीम के पत्तों का काढ़ा: 2 लीटर",
                "नीलगिरी (Eucalyptus) का तेल: 25 मिली",
                "सिट्रोनेला या लेमनग्रास तेल: 25 मिली",
                "साबुन का घोल: 50 मिली"
            ),
            preparationMethod = "नीम के काढ़े में नीलगिरी, लेमनग्रास तेल और साबुन का घोल मिलाकर स्प्रे पंप में भरें।",
            dosageAndSchedule = "पशु के शरीर पर तथा बाड़े की दीवारों पर सुबह-शाम छिड़काव करें।",
            warningsAndPrecautions = "आंखों के संपर्क से बचाएं। यह पूरी तरह विष-मुक्त और जैविक है।"
        ),
        HerbalRemedy45(
            id = "hr_42_burn_injury",
            conditionNameHindi = "आग से झुलसने पर लेप (Thermal Burn Injury Soothing Salve)",
            conditionNameEnglish = "Topical Burn Healer & Tissue Regenerator",
            anatomicalCategory = "LEGS_SKIN",
            targetSpecies = "समस्त पशु",
            ingredientsWithWeights = listOf(
                "ग्वारपाठा (एलोवेरा) का गूदा: 200 ग्राम",
                "शुद्ध देसी शहद: 50 ग्राम",
                "नारियल का तेल: 100 मिली",
                "हल्दी: 20 ग्राम"
            ),
            preparationMethod = "एलोवेरा गूदे में शहद, नारियल तेल व हल्दी मिलाकर ठंडा लेप बनाएं।",
            dosageAndSchedule = "जली हुई त्वचा पर हल्के हाथ से दिन में 3 बार लगाएं। जलन व फफोले तुरंत शांत होते हैं।",
            warningsAndPrecautions = "घाव को खुरचें नहीं। मक्खियां न बैठने दें।"
        ),
        HerbalRemedy45(
            id = "hr_43_snakebite_firstaid",
            conditionNameHindi = "सांप-बिच्छू काटने पर प्राथमिक उपचार (Snakebite & Scorpion First-Aid)",
            conditionNameEnglish = "Emergency Snakebite & Venom Neutralizer First-Aid",
            anatomicalCategory = "METABOLIC_GENERAL",
            targetSpecies = "समस्त पशु",
            ingredientsWithWeights = listOf(
                "ईश्वर मूल (Aristolochia indica) की जड़: 50 ग्राम",
                "काली मिर्च: 20 ग्राम",
                "घी: 100 ग्राम",
                "नीम की पत्तियां: 100 ग्राम"
            ),
            preparationMethod = "ईश्वर मूल और काली मिर्च को पीसकर घी में घोलें। नीम की पत्तियों का लेप बनाएं।",
            dosageAndSchedule = "काढ़े को तुरंत पिलाएं तथा काटने वाले स्थान पर नीम का लेप बांधें।",
            warningsAndPrecautions = "⚠️ यह केवल अस्पताल पहुंचने तक का प्राथमिक उपचार है। तुरंत पॉलीवैलेंट एंटी-स्नेक वेनम दिलवाएं।"
        ),
        HerbalRemedy45(
            id = "hr_44_postpartum_pain",
            conditionNameHindi = "प्रसव उपरांत बदन दर्द व कंपकंपी (Post-Partum Body Pain)",
            conditionNameEnglish = "Maternal Post-Calving Pain & Stiffness Tonic",
            anatomicalCategory = "REPRO_CALVING",
            targetSpecies = "गाय व भैंस",
            ingredientsWithWeights = listOf(
                "मेथी दाना भुना हुआ: 100 ग्राम",
                "सोंठ: 50 ग्राम",
                "हल्दी: 50 ग्राम",
                "देसी गुड़: 500 ग्राम",
                "सरसों का शुद्ध तेल: 100 मिली"
            ),
            preparationMethod = "सरसों के तेल में हल्दी व सोंठ भूनें। मेथी चूर्ण व गुड़ मिलाकर गर्म-गर्म हलवा बनाएं।",
            dosageAndSchedule = "ब्याने के बाद 7 दिन तक शाम को गुनगुना खिलाएं। पशु की कंपकंपी व दर्द दूर होता है।",
            warningsAndPrecautions = "ताजा ठंडा पानी तुरंत न दें, गुनगुना पानी ही दें।"
        ),
        HerbalRemedy45(
            id = "hr_45_calving_booster",
            conditionNameHindi = "बियाने बाद ताकत व दूध वर्धक लड्डू (Post-Calving Immunity & Milk Booster)",
            conditionNameEnglish = "Galactagogue & Uterine Involution Ladoo",
            anatomicalCategory = "METABOLIC_GENERAL",
            targetSpecies = "गाय व भैंस",
            ingredientsWithWeights = listOf(
                "शतावरी चूर्ण: 50 ग्राम",
                "जीवंती चूर्ण: 50 ग्राम",
                "सौंफ: 50 ग्राम",
                "गोंद कतीरा: 50 ग्राम",
                "देसी घी: 150 ग्राम",
                "गुड़: 500 ग्राम"
            ),
            preparationMethod = "घी में गोंद को भूनें। बाकी सभी जड़ी-बूटियों को गुड़ की चाशनी में मिलाकर 7 बड़े लड्डू बनाएं।",
            dosageAndSchedule = "ब्याने के 5वें दिन से रोजाना 1 लड्डू सुबह खाली पेट 7 दिन तक दें। दूध में 25% तक प्राकृतिक वृद्धि होती है।",
            warningsAndPrecautions = "दाने में मिनरल मिक्सचर 50 ग्राम अवश्य शामिल करें।"
        )
    )
}



