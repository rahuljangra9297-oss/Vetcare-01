package com.example.data

object VeterinaryKnowledgeBase {

    val symptomsList: List<SymptomItem> = listOf(
        // 1. Temperature
        SymptomItem("temp_normal", "Normal (101-102°F)", "सामान्य (101-102°F)", "Normal Temp (101-102°F)", "ਆਮ ਤਾਪਮਾਨ (101-102°F)", "सामान्य (101-102°F)", AnatomicalRegion.ALL, "तापमान"),
        SymptomItem("temp_fever_mid", "Moderate Fever (103-104.5°F)", "मध्यम बुखार (103-104.5°F)", "Moderate Fever (103-104.5°F)", "ਦਰਮਿਆਨਾ ਬੁਖਾਰ (103-104.5°F)", "मध्यम ताप (103-104.5°F)", AnatomicalRegion.ALL, "तापमान"),
        SymptomItem("temp_fever_high", "High Fever (105-107°F)", "अति-तीव्र बुखार (105-107°F)", "High Fever (105-107°F)", "ਤੇਜ਼ ਬੁਖਾਰ (105-107°F)", "अति-तीव्र ताप (105-107°F)", AnatomicalRegion.ALL, "तापमान"),
        SymptomItem("temp_subnormal", "Subnormal Cold Body (<100°F)", "शरीर ठंडा पड़ना (<100°F)", "Subnormal Body Temp (<100°F)", "ਸਰੀਰ ਠੰਢਾ ਪੈਣਾ (<100°F)", "शरीर थंड पडणे (<100°F)", AnatomicalRegion.ALL, "तापमान"),

        // 2. Eyes & Mucosa
        SymptomItem("eyes_pink", "Normal Pink Mucosa", "सामान्य गुलाबी श्लेष्मा", "Normal Pink Mucosa", "ਆਮ ਗੁਲਾਬੀ ਝਿੱਲੀ", "सामान्य गुलाबी श्लेष्मा", AnatomicalRegion.HEAD_EYES, "आंखें व श्लेष्मा"),
        SymptomItem("eyes_congested", "Congested Red Eyes", "लाल कंजेस्टेड आंखें", "Congested Red Eyes", "ਲਾਲ ਅੱਖਾਂ", "लाल रक्तवर्णी डोळे", AnatomicalRegion.HEAD_EYES, "आंखें व श्लेष्मा"),
        SymptomItem("eyes_pale", "Pale Anemic Mucosa", "सफेद-फीकी आंखें (एनीमिया)", "Pale Whitish Mucosa", "ਫਿੱਕੀ ਚਿੱਟੀ ਝਿੱਲੀ", "पांढरे फिके डोळे (अ‍ॅनिमिया)", AnatomicalRegion.HEAD_EYES, "आंखें व श्लेष्मा"),
        SymptomItem("eyes_icteric", "Yellow Icteric (Jaundice)", "पीली आंखें (पीलिया/Jaundice)", "Yellowish Mucosa (Jaundice)", "ਪੀਲੀਆਂ ਅੱਖਾਂ (ਪੀਲੀਆ)", "पिवळे डोळे (कावीळ)", AnatomicalRegion.HEAD_EYES, "आंखें व श्लेष्मा"),
        SymptomItem("eyes_corneal_opacity", "Corneal Opacity / Cloudiness", "आंखों में धुंधलापन / मोतियाबिंद", "Corneal Opacity / Cloudiness", "ਅੱਖਾਂ ਵਿੱਚ ਧੁੰਦਲਾਪਣ", "डोळ्यात धुरकटपणा", AnatomicalRegion.HEAD_EYES, "आंखें व श्लेष्मा"),

        // 3. Head, Mouth & Nervous
        SymptomItem("mouth_salivation", "Profuse Frothy Salivation", "अत्यधिक लार व झाग गिरना", "Profuse Drooling / Salivation", "ਮੂੰਹੋਂ ਬਹੁਤ ਲਾਰ ਡਿੱਗਣਾ", "तोंडातून फेसळ लाळ गळणे", AnatomicalRegion.HEAD_EYES, "सिर व मुंह"),
        SymptomItem("mouth_ulcers", "Ulcers in Mouth & Tongue", "मुंह व जीभ में छाले", "Oral Ulcers / Erosions", "ਮੂੰਹ ਤੇ ਜੀਭ ਦੇ ਛਾਲੇ", "तोंडात व जिभेवर व्रण/फोडे", AnatomicalRegion.HEAD_EYES, "सिर व मुंह"),
        SymptomItem("nervous_circling", "Circling Movement & Incoordination", "गोल-गोल चक्कर काटना / असंतुलन", "Circling & Nervous Incoordination", "ਗੋਲ ਚੱਕਰ ਕੱਟਣਾ", "गोलाकार फेऱ्या मारणे", AnatomicalRegion.HEAD_EYES, "सिर व मुंह"),
        SymptomItem("nervous_sternal_recumbency", "Head Turned on Flank (S-Curve)", "गर्दन मोड़कर सीने पर बैठना (S-Curve)", "Head Turned on Flank (S-Curve)", "ਧੌਣ ਮੋੜ ਕੇ ਬੈਠਣਾ", "मान वळवून बसणे (S-Curve)", AnatomicalRegion.HEAD_EYES, "सिर व मुंह"),
        SymptomItem("ears_cold", "Cold Horns & Drooping Ears", "कान व सींग ठंडे पड़ना", "Cold Ears & Horns", "ਕੰਨ ਤੇ ਸਿੰਗ ਠੰਢੇ ਹੋਣਾ", "कान व शिंगे थंड पडणे", AnatomicalRegion.HEAD_EYES, "सिर व मुंह"),
        SymptomItem("jaw_hard_swelling", "Hard Bony Jaw Swelling (Lumpy Jaw)", "जबड़े पर पत्थर जैसी सख्त सूजन", "Hard Bony Mandible Swelling", "ਜਬਾੜ੍ਹੇ ਦੀ ਸਖ਼ਤ ਸੋਜ", "जबड्यावर कडक हाडाची सूज", AnatomicalRegion.HEAD_EYES, "सिर व मुंह"),

        // 4. Throat & Respiratory
        SymptomItem("throat_hot_swelling", "Hot Painful Throat Swelling (HS)", "गले में गर्म दर्दनाक सूजन (गलघोंटू)", "Hot Swelling at Brisket/Throat", "ਗਲੇ ਦੀ ਗਰਮ ਸੋਜ (ਗਲਘੋਟੂ)", "घशात गरम वेदनामयी सूज", AnatomicalRegion.NECK, "गला व श्वसन"),
        SymptomItem("resp_labored_grunting", "Labored Grunting Respiration", "घुर्र-घुर्र सांस व कराहना", "Labored Grunting Respiration", "ਘੁਰ-ਘੁਰ ਸਾਹ ਲੈਣਾ", "घोरण्यासारखा धाप लागलेला श्वास", AnatomicalRegion.NECK, "गला व श्वसन"),
        SymptomItem("resp_coughing", "Persistent Cough & Panting", "तेज हांफना व सूखी/गीली खांसी", "Panting with Open Mouth Cough", "ਤੇਜ਼ ਸਾਹ ਤੇ ਖੰਘ", "धाप लागणे व खोकला", AnatomicalRegion.NECK, "गला व श्वसन"),
        SymptomItem("resp_nasal_discharge_crust", "Mucopurulent Nasal Crusts", "नाक से गाढ़ा मवाद व पपड़ी", "Mucopurulent Nasal Discharge", "ਨੱਕ ਵਿੱਚੋਂ ਪੀਕ", "नाकातून घट्ट स्त्राव व खपली", AnatomicalRegion.NECK, "गला व श्वसन"),

        // 5. Stomach, Digestion & Dung
        SymptomItem("digestion_anorexia", "Complete Loss of Appetite & Rumination", "भूख व जुगाली 24+ घंटे बंद", "Complete Anorexia (No Rumination)", "ਭੁੱਖ ਤੇ ਜੁਗਾਲੀ ਬੰਦ", "भूक व रवंथ पूर्ण बंद", AnatomicalRegion.ABDOMEN, "पेट व गोबर"),
        SymptomItem("abdomen_left_bloat", "Left Flank Distention / Frothy Bloat", "बाईं कोख में आफरा व गैस (Bloat)", "Left Flank Tympany / Bloat", "ਖੱਬੀ ਵੱਖੀ ਦਾ ਅਫਾਰਾ", "डाव्या कुशीत गॅस / फुगवटा", AnatomicalRegion.ABDOMEN, "पेट व गोबर"),
        SymptomItem("dung_watery_foul", "Profuse Watery Foul Diarrhea", "पतला बदबूदार पानी जैसा दस्त", "Profuse Foul-Smelling Diarrhea", "ਪਤਲੇ ਬਦਬੂਦਾਰ ਦਸਤ", "घाणेरडे पातळ जुलाब", AnatomicalRegion.ABDOMEN, "पेट व गोबर"),
        SymptomItem("dung_bloody_mucus", "Blood & Mucus Clots in Dung", "गोबर में खून व सफेद आंव", "Dysentery with Blood & Mucus", "ਗੋਹੇ ਵਿੱਚ ਖੂਨ ਤੇ ਆਂਵ", "शेणात रक्त व चिकटा", AnatomicalRegion.ABDOMEN, "पेट व गोबर"),
        SymptomItem("dung_hard_constipated", "Hard Dry Constipated Dung", "कड़ा सूखा बंधा गोबर (कब्ज)", "Constipated Mucus-Coated Dung", "ਸਖ਼ਤ ਸੁੱਕਾ ਗੋਹਾ (ਕਬਜ਼)", "कडक खडा शेण (बद्धकोष्ठता)", AnatomicalRegion.ABDOMEN, "पेट व गोबर"),
        SymptomItem("grunt_on_withers_pinch", "Pain Grunt on Withers Pinch (TRP)", "रीढ़ दबाने पर दर्द से कराहना (TRP)", "Pain on Withers Pinch Test", "ਮੋਢੇ ਦਬਾਉਣ ਤੇ ਦਰਦ", "पाठीवर दाब दिल्यावर वेदनेने ओरडणे", AnatomicalRegion.ABDOMEN, "पेट व गोबर"),

        // 6. Urine & Genital
        SymptomItem("urine_red_coffee", "Red / Dark Coffee-Colored Urine", "लाल या कॉफी रंग का पेशाब (Red Water)", "Red / Port-Wine Urine", "ਲਾਲ/ਕੌਫੀ ਰੰਗਾ ਪਿਸ਼ਾਬ", "लाल किंवा कॉफी रंगाची लघवी", AnatomicalRegion.FLANK, "मूत्र व जननांग"),
        SymptomItem("urine_straining", "Straining & Painful Urination", "रुक-रुक कर दर्द से पेशाब (Straining)", "Dysuria / Straining to Urinate", "ਦਰਦ ਨਾਲ ਪਿਸ਼ਾਬ ਰੁਕਣਾ", "वेदनायुक्त लघवीचा त्रास", AnatomicalRegion.FLANK, "मूत्र व जननांग"),
        SymptomItem("genital_foul_discharge", "Foul Smelling Vaginal Discharge", "योनि से बदबूदार मवाद/स्राव", "Purulent Vaginal Discharge", "ਬਦਬੂਦਾਰ ਪੀਕ ਵਾਲਾ ਵਹਾਅ", "योनीतून दुर्गंधीयुक्त स्त्राव", AnatomicalRegion.FLANK, "मूत्र व जननांग"),
        SymptomItem("genital_rop", "Retained Placenta >12 Hours", "ब्यांत के बाद जेर न गिरना (ROP)", "Retained Fetal Membranes (ROP)", "ਜੇਰ ਨਾ ਡਿੱਗਣਾ", "वार न पडणे (ROP)", AnatomicalRegion.FLANK, "मूत्र व जननांग"),

        // 7. Udder, Teats & Milk
        SymptomItem("udder_hot_hard_swelling", "Hot Hard Painful Udder (Mastitis)", "थन में कठोर गर्म सूजन व दर्द", "Hot Hard Swollen Quarter (Mastitis)", "ਲੇਵੇ ਦੀ ਸਖ਼ਤ ਗਰਮ ਸੋਜ", "कासेला गरम कडक सूज", AnatomicalRegion.UDDER, "थन व दूध"),
        SymptomItem("milk_flakes_blood", "Flakes, Clots & Blood in Milk", "दूध में खून, छेछड़े या पीला पानी", "Curds, Blood or Watery Milk", "ਦੁੱਧ ਵਿੱਚ ਛਿੱਛੜੇ ਤੇ ਖੂਨ", "दुधात गुठळ्या, रक्त किंवा पाणी", AnatomicalRegion.UDDER, "थन व दूध"),
        SymptomItem("milk_sudden_drop", "Sudden 80-100% Drop in Milk Yield", "दूध का अचानक सूख जाना", "Acute Precipitous Agalactia", "ਦੁੱਧ ਦਾ ਅਚਾਨਕ ਸੁੱਕ ਜਾਣਾ", "दुधात अचानक तीव्र घट", AnatomicalRegion.UDDER, "थन व दूध"),

        // 8. Legs, Hooves & Skin
        SymptomItem("crepitating_swelling_thigh", "Crepitating Swelling on Thigh (BQ)", "पुट्ठे पर दबाने पर चड़-चड़ आवाज (BQ)", "Crepitant Crackling Gas Swelling", "ਪੱਟ ਤੇ ਚੜ-ਚੜ ਅਵਾਜ਼ ਵਾਲੀ ਸੋਜ", "मांड्यावर दाबल्यावर कडकड आवाज", AnatomicalRegion.HOOVES, "पैर व त्वचा"),
        SymptomItem("leg_lameness", "Acute Severe Lameness", "पैरों में अचानक तेज लंगड़ापन", "Acute Severe Lameness", "ਪੈਰਾਂ ਵਿੱਚ ਤੇਜ਼ ਲੰਗੜਾਪਣ", "पायांमध्ये तीव्र लंगडेपणा", AnatomicalRegion.HOOVES, "पैर व त्वचा"),
        SymptomItem("hoof_interdigital_lesions", "Blisters & Maggot Wounds in Hooves", "खुरों के बीच छाले व घाव (FMD)", "Interdigital Erosions / Vesicles", "ਖੁਰਾਂ ਵਿੱਚ ਛਾਲੇ ਤੇ ਜ਼ਖ਼ਮ", "खुरांच्या फटीत व्रण/जखम", AnatomicalRegion.HOOVES, "पैर व त्वचा"),
        SymptomItem("skin_firm_nodules", "Firm Painful Nodules on Skin (LSD)", "त्वचा पर सख्त उभरी गांठें (लम्पी)", "Circumscribed Cutaneous Nodules", "ਚਮੜੀ ਤੇ ਸਖ਼ਤ ਗੰਢਾਂ (ਲੰਪੀ)", "त्वचेवर कडक गाठी (लम्पी)", AnatomicalRegion.HOOVES, "पैर व त्वचा"),
        SymptomItem("skin_ticks_infestation", "Severe Tick & Ectoparasite Infestation", "शरीर पर अत्यधिक चिचड़ी/जूँ", "Heavy Tick Infestation", "ਸਰੀਰ ਤੇ ਚਿੱਚੜਾਂ ਦਾ ਹਮਲਾ", "शरीरावर गोचिड/उवा", AnatomicalRegion.HOOVES, "पैर व त्वचा"),
        SymptomItem("prescapular_lymph_swollen", "Swollen Prescapular Lymph Nodes", "कंधे के आगे लसिका ग्रंथि सूजन", "Enlarged Prescapular Lymph Node", "ਗਿਲਟੀਆਂ ਦੀ ਸੋਜ", "खांद्यापुढील गाठ सुजणे", AnatomicalRegion.HOOVES, "पैर व त्वचा")
    )

    val diseasesList: List<DiseaseDefinition> = listOf(
        // 1. Acute Mastitis
        DiseaseDefinition(
            id = "mastitis",
            scientificName = "Acute Bovine Mastitis",
            hindiName = "तीव्र थनैला रोग",
            localDesiNames = "थान पका, गदह, बादी थनैला",
            etiology = "Staphylococcus aureus, Streptococcus agalactiae, E. coli bacteria entering through open teat canal.",
            associatedSymptoms = listOf("udder_hot_hard_swelling", "milk_flakes_blood", "temp_fever_mid", "milk_sudden_drop"),
            pathognomonicSign = "थन में पत्थर जैसी कठोरता और दूध में खून/दही जैसे छेछड़े (Curds in Milk)",
            labTests = listOf(
                LabTest("California Mastitis Test (CMT)", "Dung/Milk (दूध)", 80, "Gel formation confirms somatic cell count >500,000/ml"),
                LabTest("Milk Microbial Culture & ABST", "Aseptic Milk (दूध)", 450, "Identifies causative pathogen and drug sensitivity")
            ),
            pregnancyRedAlert = null,
            contraIndicatedDrugs = emptyList(),
            safeAlternativeDrugs = listOf("Amoxicillin-Sulbactam", "Ceftriaxone-Tazobactam", "Meloxicam-Paracetamol"),
            injections = listOf(
                InjectionDrug("एंटीबायोटिक", "Ceftriaxone + Tazobactam 4.5g", "Intacef Tazo 4.5g", "Cef-Tazo Vet 4.5g", 480, 190, "IM/IV Once Daily x 3 days", true, "Broad spectrum G+ / G- bacterial cure"),
                InjectionDrug("एंटी-इन्फ्लेमेटरी", "Meloxicam + Paracetamol", "Melonex Plus 30ml", "Meloxic-P Vet 30ml", 140, 55, "IM 15-20 ml", true, "Reduces severe heat, pain and swelling"),
                InjectionDrug("सपोर्टिव", "Chlorpheniramine Maleate", "Anistamin 30ml", "CPM Vet 30ml", 65, 25, "IM 10 ml", true, "Antihistaminic relief")
            ),
            oralMeds = listOf(
                OralMedicine("पाउडर", "Trisodium Citrate + Vit A, D3, E", "Mastilep Bolus / Masticure", "Citra-Mast Pouch", 220, 95, "50g daily for 5 days", "Restores normal milk pH to 6.5")
            ),
            herbalMeds = listOf(
                HerbalMedicine("हर्बल लेप", "Mastilep Gel (Charak/Ayurvet)", 160, "Apply twice daily after milking", "Soothes inflammation without milk residue")
            ),
            homeopathicMeds = listOf(
                HomeopathicMedicine("Phytolacca 200C + Belladonna 200C", 110, "10-10 drops 4 times daily", "Effective in stony hard congestion")
            ),
            desiRemedies = listOf(
                DesiRemedy("हल्दी-चूना-घृतकुमारी लेप", "हल्दी 250g, खाने का चूना 50g, एलोवेरा 250g", "पीसकर चिकना पेस्ट बना लें", "थन खाली करके दिन में 3 बार लगाएं। 100% सुरक्षित।")
            ),
            biosecurity = listOf(
                BiosecurityMeasure("थनों की स्वच्छता", "दुहने से पहले व बाद में पोटैशियम परमैंगनेट (लाल दवा 1:1000) के घोल में थन डुबोएं (Teat Dip)."),
                BiosecurityMeasure("फर्श सूखा रखें", "पशु को दुहने के 1 घंटे बाद तक बैठने न दें (चारा खिलाएं ताकि टीट कनाल बंद हो सके).")
            ),
            recoveryMinDays = 3,
            recoveryMaxDays = 7,
            redFlagWarnings = listOf("थन का नीला या काला पड़ना (Gangrenous Mastitis) - तुरंत सर्जरी या विच्छेदन आवश्यक!"),
            secondOpinionNote = "CMT टेस्ट आवश्यक रूप से करें। यदि 48 घंटे में सुधार न हो तो तुरंत एंटीबायोटिक बदलकर Ceftiofur Sodium या Marbofloxacin पर स्विच करें।"
        ),

        // 2. Hemorrhagic Septicemia (HS)
        DiseaseDefinition(
            id = "hs",
            scientificName = "Hemorrhagic Septicemia (HS)",
            hindiName = "गलघोंटू रोग",
            localDesiNames = "घुर्रका, गलघोंटू, नाविक ज्वर",
            etiology = "Pasteurella multocida (B:2 serotype) causing acute endotoxic septicemia.",
            associatedSymptoms = listOf("throat_hot_swelling", "resp_labored_grunting", "temp_fever_high", "mouth_salivation"),
            pathognomonicSign = "गले व गलकंबल पर अति-गर्म दर्दनाक सूजन और घुर्र-घुर्र की भयानक आवाज (Hot Submandibular Edema with Stertorous Grunting)",
            labTests = listOf(
                LabTest("Peripheral Blood Smear (Leishman/Methylene Blue)", "Jugular Blood (रक्त)", 120, "Reveals classic bipolar Pasteurella organisms"),
                LabTest("Serum Rapid Agglutination Test", "Blood Serum (सीरम)", 250, "Confirms acute Pasteurella endotoxin surge")
            ),
            pregnancyRedAlert = "⚠️ अत्यंत सावधानी: उच्च बुखार से गर्भपात (Abortion) संभव। केवल सुरक्षित एंटीपायरेटिक Meloxicam दें।",
            contraIndicatedDrugs = listOf("Dexamethasone in pregnancy", "Isoflupredone"),
            safeAlternativeDrugs = listOf("Ceftriaxone-Sulbactam", "Meloxicam", "Sulphadimidine"),
            injections = listOf(
                InjectionDrug("एंटीबायोटिक ऑफ चॉइस", "Ceftriaxone + Sulbactam 4.5g", "Intacef 4.5g", "Cef-Sulb Vet 4.5g", 420, 180, "Slow IV/IM Immediate", true, "Kills Pasteurella before endotoxin collapse"),
                InjectionDrug("सल्फा एंटीबायोटिक", "Sulphadimidine 33.3% 100ml", "Dimidine Vet 100ml", "Sulpha-33 Vet", 180, 80, "Slow IV 100-150 ml", true, "Classic effective pasteurella cure"),
                InjectionDrug("एंटी-इन्फ्लेमेटरी", "Meloxicam 20ml", "Melonex 30ml", "Melox Vet 30ml", 120, 45, "IM 15 ml", true, "Safe in pregnancy, lowers throat swelling")
            ),
            oralMeds = emptyList(),
            herbalMeds = listOf(
                HerbalMedicine("काफसूट / कफ-गो सिरप", "Kaf-Go Vet Liquid 200ml", 140, "50ml twice daily with honey", "Eases bronchial spasm")
            ),
            homeopathicMeds = listOf(
                HomeopathicMedicine("Belladonna 1M + Bryonia 200C", 120, "15 drops every 2 hours", "Controls hyperacute throat edema")
            ),
            desiRemedies = listOf(
                DesiRemedy("गले की सिकाई व भाप", "अजवाइन 50g, लहसुन 10 कली, सरसों तेल 100ml", "पकाकर गले पर गुनगुना लेप करें", "सूजन कम करने में तुरंत सहायक।")
            ),
            biosecurity = listOf(
                BiosecurityMeasure("एचएस वार्षिक टीकाकरण", "मानसून से पूर्व (मई-जून) में एलम प्रेसिपिटेटेड HS टीका अवश्य लगवाएं।")
            ),
            recoveryMinDays = 2,
            recoveryMaxDays = 4,
            redFlagWarnings = listOf("गले की सूजन से सांस रुकने (Asphyxia) का खतरा - 4 से 12 घंटे में मृत्यु संभव!"),
            secondOpinionNote = "यह अति-तीव्र रोग है। लक्षण दिखते ही बिना किसी देरी के Ceftriaxone 4.5g IV और Dimidine 33% IV तुरंत शुरू करें।"
        ),

        // 3. Black Quarter (BQ)
        DiseaseDefinition(
            id = "bq",
            scientificName = "Black Quarter (Clostridial Myositis)",
            hindiName = "लंगड़ा बुखार / काला बादी",
            localDesiNames = "एकटंगिया, जहरबाद, सुजका",
            etiology = "Clostridium chauvoei endospores germinating in heavy muscle masses producing necrotizing alpha toxin.",
            associatedSymptoms = listOf("crepitating_swelling_thigh", "leg_lameness", "temp_fever_high", "digestion_anorexia"),
            pathognomonicSign = "पुट्ठे या कंधे के मांस पर दबाने पर सूखी पत्तियों जैसी चड़-चड़ आवाज (Crepitation due to subcutaneous gas)",
            labTests = listOf(
                LabTest("Muscle Aspirate Gram Stain & Direct Smear", "Muscle Exudate (मांस रस)", 150, "Demonstrates Gram-positive Clostridium sporogenes"),
                LabTest("Fluorescent Antibody Test (FAT)", "Tissue Smear", 400, "Rapid definitive Clostridium chauvoei confirmation")
            ),
            pregnancyRedAlert = "⚠️ प्रेगनेंसी चेतावनी: टॉक्सिन से सेप्टीसीमिया। पेनिसिलिन पूर्णतः सुरक्षित है।",
            contraIndicatedDrugs = listOf("Corticosteroids", "Deep tissue incisions without drainage"),
            safeAlternativeDrugs = listOf("Procaine Penicillin", "Meloxicam", "Crystalline Penicillin"),
            injections = listOf(
                InjectionDrug("ड्रग ऑफ चॉइस", "Procaine + Potassium Penicillin 40L IU", "Pronapen 40L IU", "Pen-40 Vet", 180, 75, "Deep IM twice daily x 4 days", true, "Gold standard Clostridial bactericide"),
                InjectionDrug("एंटी-इन्फ्लेमेटरी", "Meloxicam + Paracetamol 30ml", "Melonex Plus", "Melox-P Vet", 140, 55, "IM 15 ml", true, "Relieves severe muscular pain"),
                InjectionDrug("एंटी-टॉक्सिन सपोर्ट", "Vitamin C (Ascorbic Acid) 30ml", "Redoxon Vet", "Vit-C Vet", 110, 45, "IV 20 ml", true, "Neutralizes clostridial free-radicals")
            ),
            oralMeds = emptyList(),
            herbalMeds = listOf(
                HerbalMedicine("हर्बल डेटॉक्स", "Himax Ointment for skin lesions", 95, "Apply on muscle swelling", "Antiseptic protective barrier")
            ),
            homeopathicMeds = listOf(
                HomeopathicMedicine("Anthracinum 200C + Lachesis 200C", 110, "10 drops 3 times daily", "Supportive in gangrenous muscle toxins")
            ),
            desiRemedies = listOf(
                DesiRemedy("नीम छाल व कपूर लेप", "नीम की छाल 100g, कपूर 10g, तिल तेल 150ml", "पकाकर सूजन पर हल्के हाथ से मलें", "मांसपेशी के संक्रमण को शांत करता है।")
            ),
            biosecurity = listOf(
                BiosecurityMeasure("BQ वैक्सीन", "6 माह से अधिक उम्र के सभी पशुओं को मानसून से पहले BQ टीका लगवाएं।")
            ),
            recoveryMinDays = 4,
            recoveryMaxDays = 9,
            redFlagWarnings = listOf("मांस का काला पड़ना व गैस का तेजी से फैलना - तुरंत पेनिसिलिन की दोगुनी खुराक दें!"),
            secondOpinionNote = "पेनिसिलिन 40 लाख IU को स्थानीय सूजन के चारों ओर सब-क्यूटेनियस भी इन्फिल्ट्रेट करें ताकि क्लोस्ट्रीडियम का प्रसार रुक सके।"
        ),

        // 4. Bovine Theileriosis
        DiseaseDefinition(
            id = "theileriosis",
            scientificName = "Bovine Theileriosis (Tropical Theileriosis)",
            hindiName = "थायलेरियासिस (मटमैला पेशाब / लसिका ग्रंथि रोग)",
            localDesiNames = "टिक फीवर, गिलटी रोग, लाल बुखार",
            etiology = "Theileria annulata protozoa transmitted by Hyalomma ticks attacking lymphoid system and erythrocytes.",
            associatedSymptoms = listOf("prescapular_lymph_swollen", "temp_fever_high", "eyes_pale", "skin_ticks_infestation"),
            pathognomonicSign = "कंधे के आगे प्री-स्कैपुलर लिम्फ नोड (गिलटी) का अमरूद जैसा बड़ा हो जाना व 106°F तेज बुखार (Marked Prescapular Lymphadenopathy)",
            labTests = listOf(
                LabTest("Lymph Node Biopsy / Aspiration Smear", "Lymph Aspirate (गिलटी रस)", 180, "Demonstrates Koch's blue bodies inside lymphocytes"),
                LabTest("Thin Blood Smear (Giemsa)", "Capillary Blood (रक्त)", 120, "Detects intra-erythrocytic piroplasms")
            ),
            pregnancyRedAlert = "⚠️ प्रेगनेंसी चेतावनी: Buparvaquone से उच्च गाभिन पशुओं में गर्भपात का जोखिम। केवल जीवन रक्षा प्राथमिकता!",
            contraIndicatedDrugs = listOf("Overdosing Buparvaquone", "Immunosuppressants"),
            safeAlternativeDrugs = listOf("Buparvaquone single dose", "Oxytetracycline LA", "Iron-B12 tonics"),
            injections = listOf(
                InjectionDrug("स्पेसिफिक ड्रग", "Buparvaquone 50mg/ml 20ml", "Butalex 20ml", "Zubion 20ml", 1250, 680, "Deep IM Neck strictly (1ml/20kg)", false, "Eliminates intra-cellular Theileria parasites"),
                InjectionDrug("सपोर्टिव एंटीबायोटिक", "Oxytetracycline LA 200mg/ml", "Terramycin LA 30ml", "Oxy-LA Vet 30ml", 210, 85, "Deep IM 20 ml", true, "Clears secondary piroplasm stages"),
                InjectionDrug("आयरन व लिवर टॉनिक", "Iron Dextran + Vit B12", "Imferon Vet 30ml", "Ferro-Vet 30ml", 160, 70, "Deep IM 10 ml", true, "Combats catastrophic anemia")
            ),
            oralMeds = listOf(
                OralMedicine("लिवर टॉनिक", "Tricholine Citrate + Silymarin", "Liv-52 Vet / Brotone", "Livo-Vet 500ml", 190, 85, "50ml daily for 10 days", "Protects hepatobiliary system")
            ),
            herbalMeds = listOf(
                HerbalMedicine("हर्बल रक्तशोधक", "Ictovet / Heptovet Liquid", 160, "40ml twice daily", "Accelerates reticulocyte production")
            ),
            homeopathicMeds = listOf(
                HomeopathicMedicine("Cinchona 200C + Ferrum Met 30C", 110, "15 drops 3 times daily", "Effective in deep weakness and post-fever anemia")
            ),
            desiRemedies = listOf(
                DesiRemedy("चिचड़ी नाशक देसी घोल", "नीम पत्ता 1kg, तंबाकू पत्ता 250g, 5 लीटर पानी", "उबालकर ठंडा करें और शरीर पर स्प्रे करें", "चिचड़ियों को 100% जड़ से समाप्त करता है।")
            ),
            biosecurity = listOf(
                BiosecurityMeasure("गोशाला में चिचड़ी नियंत्रण", "दीवारों की दरारों में फ्लैम गन (Flame Gun) चलाएं व डेलटामेथ्रिन 1.25% का छिड़काव करें।")
            ),
            recoveryMinDays = 5,
            recoveryMaxDays = 12,
            redFlagWarnings = listOf("गंभीर एनीमिया (PCV < 12%) और पुतली में मोतियाबिंद (Corneal Opacity) - तुरंत रक्त आधान (Blood Transfusion) आवश्यक!"),
            secondOpinionNote = "बुपरवाक्वोन (Buparvaquone) को गर्दन के मांस में ही लगाएं। एक ही स्थान पर 10ml से अधिक न दें।"
        ),

        // 5. Bovine Babesiosis (Red Water)
        DiseaseDefinition(
            id = "babesiosis",
            scientificName = "Bovine Babesiosis (Red Water / Texas Fever)",
            hindiName = "बबेसिओसिस (लाल पेशाब / रेड वाटर)",
            localDesiNames = "रक्तमूत्र, झांझ, खून का पेशाब",
            etiology = "Babesia bigemina / B. bovis multiplying inside RBCs causing massive intravascular hemolysis.",
            associatedSymptoms = listOf("urine_red_coffee", "temp_fever_high", "eyes_pale", "eyes_icteric"),
            pathognomonicSign = "गहरे कॉफी या वाइन रंग का झागदार लाल पेशाब (Port-wine Hemoglobinuria) व 105-107°F तेज बुखार",
            labTests = listOf(
                LabTest("Ear-Vein Blood Smear (Giemsa)", "Ear Vein Blood (रक्त)", 110, "Detects paired pear-shaped Babesia inside erythrocytes"),
                LabTest("Urine Centrifugation Test", "Urine (पेशाब)", 60, "Differentiates true hemoglobinuria from hematuria")
            ),
            pregnancyRedAlert = "⚠️ प्रेगनेंसी चेतावनी: डिमिनाजीन एसीट्यूरेट (Diminazene) सुरक्षित मात्रा (3.5mg/kg) में ही दें।",
            contraIndicatedDrugs = listOf("Urinary Acidifiers", "Overdosage of Diminazene causing neurotoxicity"),
            safeAlternativeDrugs = listOf("Diminazene Aceturate", "Meloxicam", "Phosphorus tonics"),
            injections = listOf(
                InjectionDrug("स्पेसिफिक एंटीप्रोटोजोअल", "Diminazene Aceturate 7% 20ml", "Berenil 20ml", "Dimina-Vet 20ml", 280, 110, "Deep IM strictly (3.5 mg/kg)", true, "Rapid destruction of intra-erythrocytic Babesia"),
                InjectionDrug("फास्फोरस सपोर्ट", "Sodium Acid Phosphate 40.3%", "Tonophosphan 30ml", "Phos-Vet 30ml", 240, 115, "IV/IM 20 ml", true, "Stabilizes RBC fragile cell membrane"),
                InjectionDrug("एंटी-इन्फ्लेमेटरी", "Meloxicam 20ml", "Melonex 30ml", "Melox Vet", 120, 45, "IM 15 ml", true, "Controls hyperthermia safely")
            ),
            oralMeds = listOf(
                OralMedicine("हेमाटिनिक टॉनिक", "Ferrous Sulfate + Folic Acid", "Sharkoferrol Vet 500g", "Ferro-Boost", 180, 80, "50g daily in feed", "Quick regeneration of destroyed blood cells")
            ),
            herbalMeds = listOf(
                HerbalMedicine("हर्बल यूरिनरी क्लींजर", "Stonvil / Cystone Vet Liquid", 140, "50ml twice daily", "Flushes cleared hemoglobin from kidneys")
            ),
            homeopathicMeds = listOf(
                HomeopathicMedicine("Crotalus Horridus 200C + Cantharis 200C", 110, "15 drops every 3 hours", "Stops internal micro-vascular capillary bleeding")
            ),
            desiRemedies = listOf(
                DesiRemedy("ठंडा मीठा दही व सौंफ नुस्खा", "ताजा मीठा दही 1kg, मिश्री 200g, सौंफ 50g, धनिया 50g", "पीसकर सुबह-शाम पिलाएं", "पेशाब की जलन व शरीर की अत्यधिक गर्मी शांत करता है।")
            ),
            biosecurity = listOf(
                BiosecurityMeasure("चिचड़ी मुक्ति", "Rhipicephalus (Boophilus) microplus चिचड़ी का समूल नाश करें।")
            ),
            recoveryMinDays = 3,
            recoveryMaxDays = 6,
            redFlagWarnings = listOf("गंभीर पीलिया (Severe Jaundice) और गुर्दा विफलता (Anuria) - तुरंत ग्लूकोज व डेक्सट्रोज 20% IV ड्रिप शुरू करें!"),
            secondOpinionNote = "बेरेनिल (Diminazene) लगाने के 24 घंटे के अंदर पेशाब का रंग साफ हो जाना चाहिए। यदि न हो तो फास्फोरस की कमी (Post-Parturient Hemoglobinuria) की जांच करें।"
        ),

        // 6. Frothy Bloat & Ruminal Tympany
        DiseaseDefinition(
            id = "bloat",
            scientificName = "Acute Ruminal Tympany (Frothy Bloat)",
            hindiName = "तीव्र आफरा / पेट फूलना",
            localDesiNames = "आफरा, पेट की गैस, हवा भरना",
            etiology = "Stable foam trapping fermentation gases in rumen due to excessive leguminous clover (बरसीम/लुसर्न) or grain overload.",
            associatedSymptoms = listOf("abdomen_left_bloat", "resp_labored_grunting", "digestion_anorexia", "mouth_salivation"),
            pathognomonicSign = "बाईं कोख (Left paralumbar fossa) का ढोल जैसा फूलना और सांस लेने में भारी तकलीफ (Drum-like Left Flank Tympany)",
            labTests = listOf(
                LabTest("Stomach Tube Passage Test", "Ruminal Gas (गैस)", 50, "Differentiates free-gas bloat from viscous frothy bloat")
            ),
            pregnancyRedAlert = "⚠️ प्रेगनेंसी चेतावनी: बढ़ा हुआ रूमन डायाफ्राम पर दबाव डालकर सांस रोक सकता है। तुरंत राहत आवश्यक!",
            contraIndicatedDrugs = listOf("Oral drenching in unconscious animals causing aspiration"),
            safeAlternativeDrugs = listOf("Simethicone + Dill Oil", "Turpentine oil emulsion", "Magnesium Hydroxide"),
            injections = listOf(
                InjectionDrug("एंटी-स्पास्मोडिक", "Hyoscine Butylbromide + Dipyrone", "Buscopan Vet 20ml", "Spasmo-Vet 20ml", 140, 60, "IM/IV 15 ml", true, "Relaxes severe gastrointestinal spasm"),
                InjectionDrug("एंटी-हिस्टामिनिक", "Pheniramine Maleate 30ml", "Avil Vet 30ml", "Anistamin", 65, 25, "IM 10 ml", true, "Suppresses ruminal histamine release")
            ),
            oralMeds = listOf(
                OralMedicine("एंटी-ब्लोट कार्मिनिटिव", "Simethicone + Dill Oil Liquid", "Bloatosil 100ml / Tympol", "Anti-Bloat Vet", 110, 45, "100ml mixed in 500ml edible oil", "Breaks viscous surface foam bubbles instantly")
            ),
            herbalMeds = listOf(
                HerbalMedicine("हर्बल पाचक चूर्ण", "Himalayan Batisa / Ruchamax 100g", 85, "100g with lukewarm water", "Expels trapped ruminal gases")
            ),
            homeopathicMeds = listOf(
                HomeopathicMedicine("Carbo Veg 200C + Nux Vomica 200C", 110, "15 drops every 30 minutes", "Legendary emergency remedy for severe gas distention")
            ),
            desiRemedies = listOf(
                DesiRemedy("तारपीन का तेल व मीठा तेल", "तारपीन का तेल (Turpentine) 30ml, सरसों का तेल 250ml, हींग 10g", "अच्छी तरह मिलाकर धीरे-धीरे पिलाएं", "झागदार गैस को 20 मिनट में फोड़कर बाहर निकालता है।")
            ),
            biosecurity = listOf(
                BiosecurityMeasure("गीला बरसीम न खिलाएं", "ओस पड़ा या अत्यधिक हरा चारा खिलाने से पहले हमेशा सूखा भूसा खिलाएं।")
            ),
            recoveryMinDays = 1,
            recoveryMaxDays = 2,
            redFlagWarnings = listOf("मुंह से नीली जीभ बाहर निकलना व दम घुटना - तुरंत ट्रोकार कैनुला (Trocar & Cannula) से बाईं कोख में छेद करें!"),
            secondOpinionNote = "यदि पशु बैठ जाए और सांस रुकने लगे, तो लकड़ी की खूंटी मुंह में आड़ी बांधें ताकि लार व गैस निकल सके। आपातकाल में 16G सुई से पंचर करें।"
        ),

        // 7. Milk Fever (Hypocalcemia)
        DiseaseDefinition(
            id = "milk_fever",
            scientificName = "Parturient Hypocalcemia (Milk Fever)",
            hindiName = "दुग्ध ज्वर / प्रसव पक्षाघात",
            localDesiNames = "सूता रोग, ब्यांत की कमजोरी, जकड़न",
            etiology = "Acute drop in ionic blood calcium following sudden colostrum drained at calving.",
            associatedSymptoms = listOf("nervous_sternal_recumbency", "temp_subnormal", "ears_cold", "digestion_anorexia"),
            pathognomonicSign = "गर्दन मोड़कर कोख पर रखकर बैठना (S-Shape posture) और शरीर व सींग का बर्फ जैसा ठंडा पड़ना",
            labTests = listOf(
                LabTest("Serum Total & Ionized Calcium", "Serum (सीरम)", 180, "Serum calcium drops below critical 5.0 mg/dl")
            ),
            pregnancyRedAlert = "⚠️ प्रसव पक्षाघात: ब्यांत के 72 घंटे के अंदर होता है। तुरंत IV कैल्शियम न देने पर मृत्यु निश्चित!",
            contraIndicatedDrugs = listOf("Rapid IV calcium push causing cardiac arrest (Heart block)"),
            safeAlternativeDrugs = listOf("Calcium Borogluconate 25%", "Magnesium", "Vitamin D3"),
            injections = listOf(
                InjectionDrug("ड्रग ऑफ चॉइस (जीवन रक्षक)", "Calcium Borogluconate 25% + Mg + P", "Mifex 450ml / Calborol", "Calci-Vet 450ml", 350, 160, "Slow IV (Warm to body temp) 350-450 ml", true, "Miraculous cure within 15-30 minutes"),
                InjectionDrug("विटामिन D3 मेटाबोलाइट", "Cholecalciferol 300,000 IU", "Arachitol Vet", "Vit-D3 Vet", 110, 45, "IM 5 ml", true, "Mobilizes bone calcium reserves")
            ),
            oralMeds = listOf(
                OralMedicine("ओरल कैल्शियम जेल", "Ionic Calcium Gel 300g", "Cal-Up Gel / Ostovet Gel", "Cal-Jel Vet", 220, 95, "1 bottle immediately after standing", "Maintains calcium levels without relapse")
            ),
            herbalMeds = emptyList(),
            homeopathicMeds = listOf(
                HomeopathicMedicine("Calcarea Phos 200C", 110, "15 drops 3 times daily", "Strengthens calcium assimilation")
            ),
            desiRemedies = listOf(
                DesiRemedy("सोंठ, अजवाइन व पुराना गुड़ हलवा", "पुराना गुड़ 500g, सोंठ 50g, अजवाइन 50g, मेथी 50g", "देसी घी में भूनकर गुनगुना खिलाएं (खड़े होने के बाद)", "शरीर में गर्मी व ऊर्जा लौटाता है।")
            ),
            biosecurity = listOf(
                BiosecurityMeasure("ड्राई पीरियड में कम कैल्शियम", "ब्यांत से 2 माह पूर्व अधिक कैल्शियम न दें ताकि पैराथायराइड ग्रंथि सक्रिय रहे।")
            ),
            recoveryMinDays = 1,
            recoveryMaxDays = 2,
            redFlagWarnings = listOf("कैल्शियम चढ़ाते समय दिल की धड़कन (Bradycardia) रुकना - गति अत्यंत धीमी रखें (15-20 मिनट में 1 बोतल)!"),
            secondOpinionNote = "Mifex को शरीर के तापमान पर गुनगुना करके ही IV चढ़ाएं। आधा बोतल IV और आधा बोतल Subcutaneous लगाने से रिलैप्स नहीं होता।"
        ),

        // 8. Foot and Mouth Disease (FMD)
        DiseaseDefinition(
            id = "fmd",
            scientificName = "Foot and Mouth Disease (FMD)",
            hindiName = "खुरपका-मुंहपका रोग (FMD)",
            localDesiNames = "खुरपका, मुंहपका, रपका, खुरहा",
            etiology = "Aphthovirus (O, A, Asia-1 types) causing vesicular eruptions on tongue, gums, teats and interdigital hooves.",
            associatedSymptoms = listOf("mouth_salivation", "mouth_ulcers", "hoof_interdigital_lesions", "leg_lameness"),
            pathognomonicSign = "मुंह से तागे जैसी चिपचिपी लार टपकना, मुंह में फफोले व खुरों के बीच कीड़े पड़ने वाले गहरे घाव",
            labTests = listOf(
                LabTest("Antigen Detection ELISA / RT-PCR", "Vesicular Fluid / Tongue Epithelium", 500, "Serotype confirmation (O, A, Asia-1)")
            ),
            pregnancyRedAlert = "⚠️ प्रेगनेंसी चेतावनी: तेज बुखार व दर्द से 3-6 माह की गाभिन गायों में गर्भपात का खतरा।",
            contraIndicatedDrugs = listOf("Steroids", "Caustic acids on raw mouth ulcers"),
            safeAlternativeDrugs = listOf("Ceftriaxone", "Meloxicam", "Boroglycerine", "Potassium Permanganate"),
            injections = listOf(
                InjectionDrug("सेकेंडरी संक्रमण रोधी", "Ceftriaxone Sodium 3g", "Intacef 3g", "Cef-Vet 3g", 280, 120, "IM Once Daily x 3 days", true, "Prevents secondary bacterial gangrene"),
                InjectionDrug("दर्द व बुखार निवारक", "Meloxicam 20ml", "Melonex 30ml", "Melox Vet", 120, 45, "IM 15 ml", true, "Eases painful walking and eating"),
                InjectionDrug("विटामिन A & E रिपेयर", "Vitamin A, D3, E 10ml", "Intavita 10ml", "Vit-ADE Vet", 130, 55, "IM 5 ml", true, "Repairs damaged oral epithelium")
            ),
            oralMeds = emptyList(),
            herbalMeds = listOf(
                HerbalMedicine("मुंह के छालों का लेप", "Boroglycerine / Somastatin Gel", 85, "Apply on tongue and gums 3 times daily", "Heals raw vesicles smoothly")
            ),
            homeopathicMeds = listOf(
                HomeopathicMedicine("Mercurius Sol 200C + Rhus Tox 200C", 110, "15 drops in water 4 times daily", "Supreme remedy for ropy salivation and hoof ulcers")
            ),
            desiRemedies = listOf(
                DesiRemedy("लाल दवा व फिटकरी से खुर धोना", "पोटैशियम परमैंगनेट (लाल दवा 1:1000) या फिटकरी 50g, 5 लीटर गुनगुना पानी", "खुरों को धोकर फिनाइल या नीम तेल लगाएं", "खुरों के घावों में कीड़े (Maggots) नहीं पड़ने देता।")
            ),
            biosecurity = listOf(
                BiosecurityMeasure("FMD 6-मासिक टीकाकरण", "राष्ट्रीय पशु रोग नियंत्रण कार्यक्रम (NADCP) के तहत वर्ष में दो बार टीका लगवाएं।")
            ),
            recoveryMinDays = 7,
            recoveryMaxDays = 15,
            redFlagWarnings = listOf("छोटे बछड़ों में दिल की मांसपेशियों का फेल होना (Tiger Heart Myocarditis) - बिना लक्षण अचानक मृत्यु!"),
            secondOpinionNote = "खुरों के घाव में कीड़े पड़ जाएं तो तारपीन तेल की पट्टी बांधें। मुंह में केवल बोरो-ग्लिसरीन या शहद-हल्दी का लेप लगाएं।"
        ),

        // 9. Lumpy Skin Disease (LSD)
        DiseaseDefinition(
            id = "lsd",
            scientificName = "Lumpy Skin Disease (LSD)",
            hindiName = "लम्पी स्किन डिजीज (गांठदार त्वचा रोग)",
            localDesiNames = "लम्पी, त्वचा की गांठे, चेचक",
            etiology = "Capripoxvirus transmitted by blood-sucking mosquitoes, flies, and ticks.",
            associatedSymptoms = listOf("skin_firm_nodules", "temp_fever_high", "prescapular_lymph_swollen", "leg_lameness"),
            pathognomonicSign = "संपूर्ण शरीर पर 2 से 5 सेमी की सख्त उभरी गोल गांठें, पैरों में भारी पानी जैसी सूजन व नाक से स्राव",
            labTests = listOf(
                LabTest("Capripox Real-Time PCR", "Skin Scab (गांठ की पपड़ी)", 650, "Definitive viral genomic confirmation")
            ),
            pregnancyRedAlert = "⚠️ प्रेगनेंसी चेतावनी: तीसरे ट्राइमेस्टर में उच्च बुखार से 20-30% गायों में अबॉर्शन।",
            contraIndicatedDrugs = listOf("Steroids", "Strong astringents"),
            safeAlternativeDrugs = listOf("Enrofloxacin / Ceftriaxone", "Meloxicam", "Ivermectin", "Methylene Blue"),
            injections = listOf(
                InjectionDrug("एंटीबायोटिक कवर", "Enrofloxacin 100mg/ml 30ml", "Enrocin 30ml", "Flox-Vet 30ml", 210, 85, "IM 15 ml x 4 days", true, "Stops secondary cutaneous suppuration"),
                InjectionDrug("एंटी-इन्फ्लेमेटरी", "Meloxicam + Paracetamol 30ml", "Melonex Plus", "Melox-P Vet", 140, 55, "IM 15 ml", true, "Brings down 105°F fever and edema"),
                InjectionDrug("एंटी-एलर्जिक", "Pheniramine Maleate 30ml", "Avil Vet", "CPM Vet", 65, 25, "IM 10 ml", true, "Reduces cutaneous pruritus")
            ),
            oralMeds = listOf(
                OralMedicine("प्रतिरक्षा वर्धक बोलस", "Zinc + Vitamin C + Selenium", "Immu-Vet Bolus", "Zinc-Sel Pouch", 140, 60, "2 bolus daily for 7 days", "Boosts viral phagocytosis")
            ),
            herbalMeds = listOf(
                HerbalMedicine("हर्बल त्वचा स्प्रे", "Charmil Plus / Scavon Spray", 130, "Spray on ruptured nodules twice daily", "Repels flies and cures raw skin ulcers")
            ),
            homeopathicMeds = listOf(
                HomeopathicMedicine("Variolinum 200C + Thuja 200C", 110, "15 drops 3 times daily", "Highly praised prophylactic and curative in Pox eruptions")
            ),
            desiRemedies = listOf(
                DesiRemedy("नीम, हल्दी, काली मिर्च व घी लड्डू", "हल्दी 50g, काली मिर्च 20g, दालचीनी 10g, तुलसी 20 पत्ते, देसी घी 100g, गुड़ 100g", "लड्डू बनाकर दिन में दो बार खिलाएं", "रोग प्रतिरोधक क्षमता बढ़ाकर गांठों को सुखाता है।")
            ),
            biosecurity = listOf(
                BiosecurityMeasure("मच्छर-मक्खी रोकथाम", "धुआं करें, गोशाला में जाली लगाएं और नीम के तेल का छिड़काव करें।")
            ),
            recoveryMinDays = 14,
            recoveryMaxDays = 30,
            redFlagWarnings = listOf("गले और श्वास नली में गांठें बनने से दम घुटना व फेफड़ों का सेप्टिक निमोनिया!"),
            secondOpinionNote = "फूटने वाली गांठों पर मक्खियां न बैठने दें। घावों पर नीम तेल या चारमिल स्प्रे लगाएं ताकि कीड़े न पड़ें।"
        ),

        // 10. Surra (Trypanosomiasis)
        DiseaseDefinition(
            id = "surra",
            scientificName = "Trypanosomiasis (Surra)",
            hindiName = "सर्रा रोग / तीबरसा",
            localDesiNames = "सर्रा, फिरकी, अंधा रोग",
            etiology = "Trypanosoma evansi protozoa transmitted mechanically by Tabanus and Stomoxys biting horseflies.",
            associatedSymptoms = listOf("nervous_circling", "eyes_corneal_opacity", "temp_fever_high", "eyes_pale"),
            pathognomonicSign = "गोल-गोल चक्कर काटना, दीवार से सिर टिकाकर खड़े होना, रुक-रुक कर आने वाला बुखार और आंखों में मोतियाबिंद",
            labTests = listOf(
                LabTest("Wet Blood Film / Stained Smear", "Peripheral Ear Blood", 100, "Live motile flagellated Trypanosomes visible under 40X")
            ),
            pregnancyRedAlert = "⚠️ प्रेगनेंसी चेतावनी: Quinapyramine से गर्भाशय संकुचन हो सकता है। Triquin सावधानीपूर्वक दें।",
            contraIndicatedDrugs = listOf("Subcutaneous pooling of Quinapyramine causing severe sterile abscesses"),
            safeAlternativeDrugs = listOf("Quinapyramine sulfate/chloride", "Diminazene Aceturate (higher dose)", "Neurotropic vitamins"),
            injections = listOf(
                InjectionDrug("स्पेसिफिक सर्रा क्योर", "Quinapyramine Sulfate & Chloride 2.5g", "Triquin 2.5g", "Surra-Nil 2.5g", 420, 190, "Subcutaneously in 2-3 divided sites", false, "Eradicates Trypanosoma from blood and CNS"),
                InjectionDrug("नर्वस टॉनिक", "Methylcobalamin + B-Complex", "Neurobion Vet 30ml", "Mecobal Vet", 160, 65, "IM 10 ml", true, "Heals damaged brain nerves and stops circling"),
                InjectionDrug("एंटी-इन्फ्लेमेटरी", "Meloxicam 20ml", "Melonex", "Melox Vet", 120, 45, "IM 15 ml", true, "Controls intermittent fever spikes")
            ),
            oralMeds = listOf(
                OralMedicine("आयरन टॉनिक", "Ferrous Gluconate + Liver Extract", "Feritas / Sharkoferrol", "Livo-Ferro", 180, 80, "50ml daily for 15 days", "Replaces red blood cells")
            ),
            herbalMeds = emptyList(),
            homeopathicMeds = listOf(
                HomeopathicMedicine("Arsenicum Album 1M + Gelsemium 200C", 110, "15 drops twice daily", "Controls neurological tremors and severe prostration")
            ),
            desiRemedies = listOf(
                DesiRemedy("शहद, काली मिर्च व सोंठ का अवलेह", "शहद 100g, काली मिर्च 10g, सोंठ 20g, पीपल 10g", "चाटने के लिए दें", "कमजोरी दूर करता है व तंत्रिका तंत्र को बल देता है।")
            ),
            biosecurity = listOf(
                BiosecurityMeasure("डांस मक्खी (Tabanus) नियंत्रण", "बरसात के मौसम में तालाबों के पास चरने न भेजें और गोशाला में धुआं करें।")
            ),
            recoveryMinDays = 7,
            recoveryMaxDays = 21,
            redFlagWarnings = listOf("पागलपन के दौरे (Excitement phase), अंधापन व कोमा - तुरंत Triquin SC लगाएं!"),
            secondOpinionNote = "ट्राइक्विन (Triquin) को ठंडे पानी में घोलकर 2-3 अलग-अलग स्थानों पर गर्दन की चमड़ी के नीचे (SC) ही लगाएं।"
        ),

        // 11. Bovine Ketosis
        DiseaseDefinition(
            id = "ketosis",
            scientificName = "Bovine Ketosis (Acetonemia)",
            hindiName = "कीटोसिस रोग (एसिटोनेमिया)",
            localDesiNames = "कीटोसिस, दाना बंद रोग, मीठी सांस",
            etiology = "Negative energy balance in high-yielding dairy cattle mobilizing body fat into ketone bodies.",
            associatedSymptoms = listOf("digestion_anorexia", "dung_hard_constipated", "milk_sudden_drop", "temp_normal"),
            pathognomonicSign = "दाना-खल खाना पूर्णतः बंद लेकिन सूखा भूसा खाना जारी, दूध व सांस से मीठे पके सेब (Sweet Chloroform) जैसी गंध",
            labTests = listOf(
                LabTest("Rothera's Nitroprusside Urine/Milk Test", "Urine/Milk (मूत्र/दूध)", 70, "Deep purple ring confirms high Acetoacetic acid")
            ),
            pregnancyRedAlert = null,
            contraIndicatedDrugs = listOf("Dexamethasone or Isoflupredone in late pregnancy"),
            safeAlternativeDrugs = listOf("Dextrose 20% / 50%", "Propylene Glycol", "Niacinamide", "Biotin"),
            injections = listOf(
                InjectionDrug("ऊर्जा बूस्टर", "Dextrose 20% or 50% 500ml", "Dextrose 20% IV", "Dex-Vet 500ml", 120, 50, "Rapid IV 1000-2000 ml", true, "Instantly restores blood glucose"),
                InjectionDrug("ग्लुकोकोर्टिकॉइड", "Isoflupredone Acetate 2mg/ml", "Predef 2X 10ml", "Iso-Vet 10ml", 190, 80, "IM 10ml (Caution: strictly not in pregnancy)", false, "Stimulates rapid hepatic gluconeogenesis"),
                InjectionDrug("विटामिन B12 व फास्फोरस", "Catafos / Butaphosphan + B12", "Catosal 100ml", "Phos-B12 Vet 100ml", 520, 260, "IM/IV 15-20 ml", true, "Optimizes Krebs energy cycle in liver")
            ),
            oralMeds = listOf(
                OralMedicine("ग्लूकोजेनिक प्रिकर्सर", "Propylene Glycol + Glycerol Liquid", "Keto-Boost 500ml / Ener-G", "Gluco-Vet 500ml", 320, 160, "200ml twice daily for 3 days", "Metabolized directly into propionate glucose")
            ),
            herbalMeds = listOf(
                HerbalMedicine("हर्बल रूमन स्टिमुलेंट", "Ruchamax / RumenFS Powder", 180, "50g twice daily with jaggery", "Revives stalled rumination")
            ),
            homeopathicMeds = listOf(
                HomeopathicMedicine("Lycopodium 200C + Chelidonium 200C", 110, "15 drops 3 times daily", "Restores hepatic glycogen storage")
            ),
            desiRemedies = listOf(
                DesiRemedy("मीठा शर्बत व पुराना गुड़ नुस्खा", "पुराना गुड़ 500g, सोंठ 50g, मीठा सोडा 50g", "1 लीटर पानी में घोलकर पिलाएं", "दिन में दो बार दें। ऊर्जा की कमी तुरंत पूरी होती है।")
            ),
            biosecurity = listOf(
                BiosecurityMeasure("संतुलित दाना मिश्रण", "उच्च दुधारू गायों को ब्यांत के बाद बिनौला खल, मक्का व बाईपास फैट अवश्य खिलाएं।")
            ),
            recoveryMinDays = 2,
            recoveryMaxDays = 5,
            redFlagWarnings = listOf("नर्वस कीटोसिस में पशु का खुद की खाल चबाना या पागलपन जैसा व्यवहार करना!"),
            secondOpinionNote = "कीटोसिस में प्रोपलीन ग्लाइकोल ओरल देना सबसे स्थायी इलाज है। Dextrose 20% IV तुरंत ऊर्जा देता है।"
        ),

        // 12. Canine Parvovirus
        DiseaseDefinition(
            id = "parvo",
            scientificName = "Canine Parvoviral Enteritis (CPV-2)",
            hindiName = "कैनाइन पार्वो वायरस (कुत्तों का खूनी दस्त)",
            localDesiNames = "पार्वो, खूनी उल्टी-दस्त",
            etiology = "Canine Parvovirus type 2 attacking rapidly dividing crypt cells of intestinal mucosa and bone marrow.",
            associatedSymptoms = listOf("temp_fever_high", "dung_bloody_mucus", "dung_watery_foul", "digestion_anorexia"),
            pathognomonicSign = "तीव्र सड़ी मछली जैसी असहनीय बदबूदार खूनी उल्टी व दस्त (Rotten-fish foul hemorrhagic enteritis)",
            labTests = listOf(
                LabTest("CPV Ag Rapid Lateral Flow Kit", "Fecal Swab (मल)", 350, "Gold standard 10-minute antigen confirmation")
            ),
            pregnancyRedAlert = "⚠️ प्रेगनेंसी चेतावनी: भ्रूण मृत्यु व गर्भाशय संक्रमण।",
            contraIndicatedDrugs = listOf("Oral fluids during active vomiting"),
            safeAlternativeDrugs = listOf("Ringer Lactate", "Metoclopramide", "Ceftriaxone-Sulbactam"),
            injections = listOf(
                InjectionDrug("एंटी-एमेटिक", "Ondansetron 2mg/ml", "Emeset Vet 10ml", "Onda-Vet 10ml", 95, 35, "Slow IV 1-2 ml twice daily", true, "Stops intractable vomiting"),
                InjectionDrug("एंटीबायोटिक सपोर्ट", "Ceftriaxone + Sulbactam 375mg", "Intacef 562mg", "Cef-Sulb Vet", 160, 65, "IV twice daily", true, "Prevents bacterial sepsis through breached mucosa"),
                InjectionDrug("आईवी फ्लुइड्स", "Ringer's Lactate (RL) + Metronidazole", "RL 500ml Infusion", "RL Vet", 85, 35, "Slow IV 30-50 ml/kg daily", true, "Replaces catastrophic fluid loss")
            ),
            oralMeds = listOf(
                OralMedicine("प्रोबायोटिक्स (उल्टी रुकने के बाद)", "Bacillus clausii Spores", "Enterogermina / Darolac", "Probio-Pet", 90, 45, "1 vial daily after vomiting stops", "Restores shattered gut microbiome")
            ),
            herbalMeds = listOf(
                HerbalMedicine("हर्बल इम्युनिटी ड्रॉप्स", "ImmuPlus Vet Drops 30ml", 140, "10 drops twice daily", "Supports white blood cell revival")
            ),
            homeopathicMeds = listOf(
                HomeopathicMedicine("Arsenicum Album 200C + Phosphorus 200C", 110, "5 drops every hour in water", "Renowned supportive homeopathic remedy for Parvo")
            ),
            desiRemedies = listOf(
                DesiRemedy("इलेक्ट्रोलाइट व चावल का माड़", "चावल का पानी 200ml, ग्लूकोज 1 चम्मच, चुटकी भर नमक", "ठंडा करके चम्मच से दें (उल्टी रुकने पर)", "उल्टी जारी रहने पर मुंह से कुछ भी न दें।")
            ),
            biosecurity = listOf(
                BiosecurityMeasure("कठोर कीटाणुशोधन", "1:30 ब्लीच (Sodium Hypochlorite) के घोल से सफाई करें।"),
                BiosecurityMeasure("टीकाकरण", "पिल्लों को 6, 9 और 12 सप्ताह पर अनिवार्य रूप से वैक्सीन लगवाएं।")
            ),
            recoveryMinDays = 5,
            recoveryMaxDays = 10,
            redFlagWarnings = listOf("गंभीर ल्यूकोपेनिया (WBC < 2000/ul) और हाइपोथर्मिया - तुरंत प्लाज्मा ट्रांसफ्यूजन!"),
            secondOpinionNote = "NIL PER ORAL (NPO) नियम का पालन करें: जब तक उल्टी बंद न हो, मुंह से पानी या खाना बिल्कुल न दें।"
        ),

        // 13. Peste des Petits Ruminants (PPR / Goat Plague)
        DiseaseDefinition(
            id = "ppr",
            scientificName = "Peste des Petits Ruminants (PPR)",
            hindiName = "बकरी प्लेग (पीपीआर रोग)",
            localDesiNames = "बकरियों का प्लेग, संक्रामक दस्त, कटा",
            etiology = "Morbillivirus attacking respiratory and gastrointestinal tract of sheep and goats.",
            associatedSymptoms = listOf("temp_fever_high", "mouth_ulcers", "resp_nasal_discharge_crust", "dung_watery_foul"),
            pathognomonicSign = "बकरियों में मुंह में सफेद बदबूदार छाले, नाक-आंख से गाढ़ा मवाद व अचानक खूनी पतले दस्त",
            labTests = listOf(
                LabTest("PPR Ag Rapid Dipstick Test", "Nasal/Ocular Swab", 300, "15-minute Morbillivirus confirmation")
            ),
            pregnancyRedAlert = "⚠️ प्रेगनेंसी चेतावनी: गाभिन बकरियों में 40% तक गर्भपात का जोखिम।",
            contraIndicatedDrugs = listOf("Live vaccine during outbreak in pregnant animals"),
            safeAlternativeDrugs = listOf("Enrofloxacin", "Meloxicam", "Oral Rehydration Salt (ORS)"),
            injections = listOf(
                InjectionDrug("एंटीबायोटिक सपोर्ट", "Enrofloxacin 100mg/ml", "Enrocin 30ml", "Flox-Vet 30ml", 210, 85, "IM 3-5 ml for 3 days", true, "Prevents secondary bacterial pneumonia"),
                InjectionDrug("बुखार निवारक", "Meloxicam 20ml", "Melonex", "Melox Vet", 120, 45, "IM 2-3 ml", true, "Controls high fever")
            ),
            oralMeds = listOf(
                OralMedicine("इलेक्ट्रोलाइट व ओआरएस", "Electral / ORS Pouch", "Walyte Vet Pouch", "ORS-Vet", 45, 18, "1 pouch in 2 liters water", "Prevents fatal dehydration")
            ),
            herbalMeds = listOf(
                HerbalMedicine("मुंह के घाव का हर्बल लोशन", "Boroglycerine with Turmeric", 80, "Apply in mouth twice daily", "Soothes oral ulcers")
            ),
            homeopathicMeds = listOf(
                HomeopathicMedicine("Mercurius Cor 200C + Arsenic Alb 200C", 110, "5 drops 4 times daily", "Relieves dysentery and mouth lesions")
            ),
            desiRemedies = listOf(
                DesiRemedy("मेथी, सौंफ व छाछ घोल", "मेथी 20g, सौंफ 20g, जीरा 10g पीसकर 500ml छाछ में", "दिन में दो बार पिलाएं", "दस्त रोकने व पेट को ठंडक देने में लाभकारी।")
            ),
            biosecurity = listOf(
                BiosecurityMeasure("PPR 3-वार्षिक टीका", "3 माह से ऊपर की सभी बकरियों को PPR टीका लगवाएं (3 वर्ष तक सुरक्षा).")
            ),
            recoveryMinDays = 6,
            recoveryMaxDays = 12,
            redFlagWarnings = listOf("गंभीर निमोनिया व डिहाइड्रेशन से 80% मृत्यु दर - तुरंत सब-क्यूटेनियस फ्लुइड्स दें!"),
            secondOpinionNote = "पीपीआर वायरस जनित है, अतः सेकेंडरी बैक्टीरियल निमोनिया को रोकना और इलेक्ट्रोलाइट्स की भरपाई करना ही मुख्य इलाज है।"
        ),

        // 14. Bovine Anaplasmosis
        DiseaseDefinition(
            id = "anaplasmosis",
            scientificName = "Bovine Anaplasmosis (Gall Sickness)",
            hindiName = "पीत ज्वर / एनाप्लाज्मोसिस",
            localDesiNames = "पीलिया बुखार, पित्त रोग, सूखा पीलिया",
            etiology = "Anaplasma marginale rickettsia transmitted by ticks causing severe extravascular hemolysis without hemoglobinuria.",
            associatedSymptoms = listOf("temp_fever_mid", "eyes_icteric", "eyes_pale", "dung_hard_constipated"),
            pathognomonicSign = "गंभीर पीलिया (Jaundice) लेकिन पेशाब का रंग साफ (No Red Water) व कड़ा सूखा गोबर",
            labTests = listOf(
                LabTest("Giemsa Blood Smear", "Blood", 120, "Identifies marginal dense inclusion bodies in RBCs")
            ),
            pregnancyRedAlert = "⚠️ प्रेगनेंसी चेतावनी: ऑक्सीटेट्रासाइक्लिन (OTC) की उच्च खुराक भ्रूण पर असर कर सकती है।",
            contraIndicatedDrugs = listOf("Steroids", "Urinary acidifiers"),
            safeAlternativeDrugs = listOf("Oxytetracycline LA", "Imidocarb dipropionate", "Liver extract"),
            injections = listOf(
                InjectionDrug("ड्रग ऑफ चॉइस", "Oxytetracycline LA 200mg/ml", "Terramycin LA 30ml", "Oxy-LA Vet 30ml", 210, 85, "Deep IM 20ml (Repeat in 72h)", true, "Specific cure for Anaplasma marginale"),
                InjectionDrug("लिवर सपोर्ट", "B-Complex with Liver Extract", "Belamyl 30ml", "Livo-B Vet", 110, 45, "IM 10 ml", true, "Clears severe bilirubin toxicity")
            ),
            oralMeds = listOf(
                OralMedicine("हेमाटिनिक टॉनिक", "Iron & Copper Tonic", "Sharkoferrol Vet 500g", "Ferro-Boost", 180, 80, "50g daily", "Accelerates RBC regeneration")
            ),
            herbalMeds = listOf(
                HerbalMedicine("हर्बल यकृत सुरक्षा", "Liv-52 Vet Liquid 500ml", 190, "50ml twice daily", "Normalizes elevated liver enzymes")
            ),
            homeopathicMeds = listOf(
                HomeopathicMedicine("Chelidonium 200C + Carduus Marianus 200C", 110, "15 drops 3 times daily", "Cleans congested gallbladder")
            ),
            desiRemedies = listOf(
                DesiRemedy("गन्ने का रस व मूली के पत्ते", "गन्ने का रस 1 लीटर, मूली के पत्तों का रस 250ml", "दिन में एक बार पिलाएं", "पीलिया को तेजी से ठीक करता है।")
            ),
            biosecurity = listOf(
                BiosecurityMeasure("चिचड़ी रोकथाम", "डेलटामेथ्रिन 1.25% से पशुओं व बाड़े को नियमित उपचारित करें।")
            ),
            recoveryMinDays = 5,
            recoveryMaxDays = 14,
            redFlagWarnings = listOf("अत्यधिक आक्रामकता (Anoxic aggression) मस्तिष्क में ऑक्सीजन की कमी के कारण!"),
            secondOpinionNote = "बबेसिओसिस और एनाप्लाज्मोसिस में मुख्य अंतर यह है कि एनाप्लाज्मोसिस में पेशाब में खून नहीं आता, केवल पीलापन होता है।"
        ),

        // 15. Traumatic Reticuloperitonitis (TRP / Hardware Disease)
        DiseaseDefinition(
            id = "trp",
            scientificName = "Traumatic Reticuloperitonitis (TRP)",
            hindiName = "हार्डवेयर डिजीज (पेट में कील-तार चुभना)",
            localDesiNames = "कील रोग, तार चुभना, जाल रोग",
            etiology = "Ingested metallic sharp objects (nails, wire) penetrating the reticular wall towards the pericardium.",
            associatedSymptoms = listOf("grunt_on_withers_pinch", "digestion_anorexia", "temp_fever_mid", "resp_labored_grunting"),
            pathognomonicSign = "कंधे के ऊपर रीढ़ दबाने पर दर्द से जोर से कराहना (Positive Withers Pinch Test) और छाती के आगे सूजन",
            labTests = listOf(
                LabTest("Metal Detector / Rumen Radiography", "Reticulum Area", 200, "Detects metallic ferromagnetic foreign bodies in reticulum"),
                LabTest("Peritoneal Fluid Analysis (Abdominocentesis)", "Peritoneal Fluid", 250, "Elevated total protein and neutrophils confirms peritonitis")
            ),
            pregnancyRedAlert = "⚠️ प्रेगनेंसी चेतावनी: भारी गाभिन गायों में गर्भाशय का दबाव कील को दिल (Pericardium) की ओर धकेल सकता है!",
            contraIndicatedDrugs = listOf("Vigorous purging laxatives"),
            safeAlternativeDrugs = listOf("Rumen Magnet", "Amoxicillin-Sulbactam", "Meloxicam"),
            injections = listOf(
                InjectionDrug("एंटीबायोटिक", "Amoxicillin + Sulbactam 3g", "Intamox 3g", "Amoxi-Sulb Vet 3g", 310, 130, "IM twice daily x 5 days", true, "Controls localized reticular abscess"),
                InjectionDrug("दर्द निवारक", "Meloxicam 20ml", "Melonex 30ml", "Melox Vet", 120, 45, "IM 15 ml", true, "Controls painful peritonitis")
            ),
            oralMeds = listOf(
                OralMedicine("रूमेन मैग्नेट (चुंबक)", "Alnico Rumen Magnet", "Vet Rumen Magnet", "Standard Magnet", 150, 90, "1 magnet administered orally via balling gun", "Traps and immobilizes loose wires and nails permanently")
            ),
            herbalMeds = emptyList(),
            homeopathicMeds = listOf(
                HomeopathicMedicine("Silicea 200C + Hepar Sulph 200C", 110, "15 drops twice daily", "Helps encyst foreign bodies safely")
            ),
            desiRemedies = listOf(
                DesiRemedy("ऊंचा अगला हिस्सा व आराम", "पशु के अगले पैरों के नीचे 6 इंच ऊंचा चबूतरा बनाएं", "पशु को आगे से ऊंचा रखें", "कील को पीछे की ओर सरकने में मदद मिलती है।")
            ),
            biosecurity = listOf(
                BiosecurityMeasure("चारा छानना", "तूड़ी-भूसे में चुंबक चलाकर लोहे के तार व कीलें अलग करें।")
            ),
            recoveryMinDays = 7,
            recoveryMaxDays = 20,
            redFlagWarnings = listOf("जुगुलर नस का रस्सी जैसा फूलना (Bovine Traumatic Pericarditis) - वाशिंग मशीन जैसी दिल की आवाज (Muffled Heart Sounds)!"),
            secondOpinionNote = "शुरुआती अवस्था में रूमेन मैग्नेट (Rumen Magnet) खिलाने और पशु को आगे से ऊंचा रखने से 80% पशु बिना सर्जरी ठीक हो जाते हैं।"
        ),

        // 16. Enterotoxemia (Pulpy Kidney)
        DiseaseDefinition(
            id = "enterotoxemia",
            scientificName = "Enterotoxemia (Pulpy Kidney Disease)",
            hindiName = "फिड़किया रोग (एंटरोटॉक्सिमिया)",
            localDesiNames = "फिड़किया, आंतों का विष, अचानक मौत",
            etiology = "Clostridium perfringens type D multiplying rapidly in gut after sudden rich grain or lush pasture intake producing lethal epsilon toxin.",
            associatedSymptoms = listOf("nervous_circling", "dung_watery_foul", "temp_fever_mid", "digestion_anorexia"),
            pathognomonicSign = "बकरियों-भेड़ों का अचानक छटपटाना, सिर पीछे की ओर खींचना (Opisthotonos) व पेशाब में ग्लूकोज (Glycosuria)",
            labTests = listOf(
                LabTest("Urine Sugar Strip Test", "Urine", 40, "Heavy glycosuria (4+ sugar in urine) is pathognomonic in sheep/goats"),
                LabTest("Intestinal Smear Gram Stain", "Intestinal contents", 120, "Overwhelming Gram-positive spore-forming Clostridia")
            ),
            pregnancyRedAlert = "⚠️ प्रेगनेंसी चेतावनी: टॉक्सिन से तुरंत मौत का खतरा। एंटीटॉक्सिन व पेनिसिलिन तुरंत दें।",
            contraIndicatedDrugs = listOf("High carbohydrate feeds"),
            safeAlternativeDrugs = listOf("Procaine Penicillin", "Clostridial Antitoxin", "Electrolytes"),
            injections = listOf(
                InjectionDrug("एंटीबायोटिक", "Procaine Penicillin 20L IU", "Pronapen 20L", "Peni-Vet 20L", 110, 45, "IM 5 ml twice daily", true, "Kills Clostridium perfringens in intestinal wall"),
                InjectionDrug("विटामिन B1 (Thiamine)", "Thiamine Hydrochloride 100mg/ml", "Berin Vet 10ml", "Vit-B1 Vet", 90, 35, "IM/IV 5 ml", true, "Combats cerebral polioencephalomalacia symptoms")
            ),
            oralMeds = listOf(
                OralMedicine("मैग्नीशियम सल्फेट (दस्त साफ करना)", "Magnesium Sulfate 100g", "Epsom Salt Pouch", "Mag-Sulf Vet", 40, 15, "50g in water orally", "Purges lethal epsilon toxin from intestines")
            ),
            herbalMeds = emptyList(),
            homeopathicMeds = listOf(
                HomeopathicMedicine("Belladonna 200C + Nux Vomica 200C", 110, "10 drops every hour", "Controls sudden nervous convulsions")
            ),
            desiRemedies = listOf(
                DesiRemedy("मीठा सोडा व हींग का पानी", "मीठा सोडा 20g, हींग 5g, पानी 250ml", "घोलकर तुरंत पिलाएं", "एसिडोसिस को नियंत्रित करता है।")
            ),
            biosecurity = listOf(
                BiosecurityMeasure("ET टीका", "मानसून से पूर्व सभी भेड़ों-बकरियों को ET वैक्सीन अनिवार्य रूप से लगाएं।")
            ),
            recoveryMinDays = 2,
            recoveryMaxDays = 4,
            redFlagWarnings = listOf("अचानक जमीन पर गिरकर पैर पटकना व 2 घंटे में मौत - स्वस्थ तंदुरुस्त बकरियों को तुरंत अलग करें!"),
            secondOpinionNote = "अचानक दाना या बरसीम चारा न बदलें। फिड़किया रोग में तुरंत दाना बंद करके सूखा चारा व एप्सम साल्ट दें।"
        ),

        // 17. Actinomycosis (Lumpy Jaw)
        DiseaseDefinition(
            id = "actinomycosis",
            scientificName = "Actinomycosis (Lumpy Jaw)",
            hindiName = "जबड़े की हड्डी का रोग (लम्पी जॉ)",
            localDesiNames = "जबड़ा सूजन, हड्डी का फोड़ा, काष्ठास्थि",
            etiology = "Actinomyces bovis entering mandible bone through sharp awns or tooth eruption causing chronic rarefying osteomyelitis.",
            associatedSymptoms = listOf("jaw_hard_swelling", "digestion_anorexia", "mouth_salivation", "temp_normal"),
            pathognomonicSign = "निचले जबड़े की हड्डी पर पत्थर जैसी अचल सख्त सूजन और पीले सल्फर दानों (Sulfur granules) वाला मवाद",
            labTests = listOf(
                LabTest("Pus Gram Stain & Sulfur Granule Exam", "Pus Aspirate (मवाद)", 110, "Demonstrates characteristic radiating ray fungus rosette under microscope")
            ),
            pregnancyRedAlert = "⚠️ प्रेगनेंसी चेतावनी: पोटैशियम आयोडाइड (Potassium Iodide) से गर्भपात का खतरा। गाभिन पशुओं में केवल पेनिसिलिन दें।",
            contraIndicatedDrugs = listOf("Potassium Iodide in pregnant animals (Causes abortion)"),
            safeAlternativeDrugs = listOf("Streptopenicillin", "Procaine Penicillin", "Local Iodine infiltration"),
            injections = listOf(
                InjectionDrug("एंटीबायोटिक ऑफ चॉइस", "Streptomycin + Penicillin 2.5g", "Dicrysticin-S 2.5g", "Strepto-Pen 2.5g", 120, 50, "IM once daily x 7 days", true, "Penetrates bony osteomyelitis tissue"),
                InjectionDrug("आईवी आयोडीन थेरेपी", "Sodium Iodide 20% 450ml", "Sod-Iodide Vet", "Iodine-Vet", 380, 190, "Slow IV (Non-pregnant only)", false, "Dissolves actinomycotic fibrous granulomas")
            ),
            oralMeds = listOf(
                OralMedicine("पोटैशियम आयोडाइड पाउडर", "Potassium Iodide 100g", "Pot-Iodide Pouch", "Iodide Pouch", 180, 85, "10g daily for 7 days (Non-pregnant only)", "Classic systemic iodism therapy")
            ),
            herbalMeds = listOf(
                HerbalMedicine("आयोडीन ऑइंटमेंट", "Betadine 5% Ointment", 90, "Apply on drained sinuses", "Prevents secondary contamination")
            ),
            homeopathicMeds = listOf(
                HomeopathicMedicine("Hecla Lava 200C + Silicea 200C", 110, "15 drops twice daily", "Renowned homeopathic specific for facial bone exostosis")
            ),
            desiRemedies = listOf(
                DesiRemedy("नीम, कपूर व तिल तेल पट्टी", "नीम रस 50ml, कपूर 10g, तिल तेल 100ml", "गर्म करके जबड़े की सूजन पर बांधें", "हड्डी के दर्द को कम करता है।")
            ),
            biosecurity = listOf(
                BiosecurityMeasure("नुकीला चारा न खिलाएं", "कांटेदार खरपतवार या नुकीले गेहूं के तिनके चारे से अलग रखें।")
            ),
            recoveryMinDays = 15,
            recoveryMaxDays = 45,
            redFlagWarnings = listOf("जबड़े की हड्डी का गलना व दांतों का उखड़ना - शुरुआती अवस्था में ही पेनिसिलिन शुरू करें!"),
            secondOpinionNote = "यदि पशु गाभिन है, तो पोटैशियम आयोडाइड बिल्कुल न दें! केवल डाइक्रिस्टिसिन (Strepto-Penicillin) 7 से 10 दिन तक लगाएं।"
        ),

        // 18. Bovine Coccidiosis
        DiseaseDefinition(
            id = "coccidiosis",
            scientificName = "Bovine Coccidiosis",
            hindiName = "कोक्सीडिओसिस (बछड़ों का खूनी दस्त)",
            localDesiNames = "रक्त अतिसार, बछड़ों का पेचिश, आंव दस्त",
            etiology = "Eimeria bovis / E. zuernii protozoa invading and destroying cecal and colonic epithelial cells.",
            associatedSymptoms = listOf("dung_bloody_mucus", "urine_straining", "temp_fever_mid", "eyes_pale"),
            pathognomonicSign = "बछड़ों में रुक-रुक कर दर्द के साथ खूनी थक्केदार दस्त व पिछवाड़े पर गोबर लिपटा रहना",
            labTests = listOf(
                LabTest("Fecal Flotation for Oocysts", "Feces (गोबर)", 90, "Demonstrates high count of Eimeria oocysts under microscope")
            ),
            pregnancyRedAlert = null,
            contraIndicatedDrugs = listOf("Prolonged Sulphonamides causing kidney crystal formation"),
            safeAlternativeDrugs = listOf("Amprolium", "Sulphadimidine", "Toltrazuril"),
            injections = listOf(
                InjectionDrug("सल्फा एंटीप्रोटोजोअल", "Sulphadimidine 33.3% 100ml", "Dimidine Vet", "Sulpha-33 Vet", 180, 80, "Slow IV/SC 15-30 ml for calf", true, "Destroys developing merozoites in intestinal mucosa"),
                InjectionDrug("विटामिन K (रक्तस्राव रोधी)", "Menadione Sodium Bisulfite", "K-Vet 10ml", "Vit-K Vet", 95, 40, "IM 3 ml", true, "Stops internal mucosal bleeding")
            ),
            oralMeds = listOf(
                OralMedicine("कोक्सीडियोस्टेट लिक्विड", "Amprolium 20% Solution / Powder", "Amprosol 100g / Toltrazuril", "Coccidi-Nil", 160, 75, "10ml per 20kg calf daily for 5 days", "Thiamine competitor starving Coccidia")
            ),
            herbalMeds = listOf(
                HerbalMedicine("हर्बल एंटी-डायरियल", "Diar-Stop Vet Liquid 100ml", 90, "30ml twice daily", "Coats irritated intestinal lining")
            ),
            homeopathicMeds = listOf(
                HomeopathicMedicine("Mercurius Cor 200C", 110, "10 drops 4 times daily", "Specific for painful straining with bloody stool")
            ),
            desiRemedies = listOf(
                DesiRemedy("कच्चा बेलगिरी व अनार छाल का काढ़ा", "बेलगिरी चूर्ण 20g, अनार छाल 20g, 500ml पानी", "उबालकर छाछ के साथ बछड़े को पिलाएं", "दस्त व आंव को तुरंत रोकता है।")
            ),
            biosecurity = listOf(
                BiosecurityMeasure("बाड़े का फर्श सूखा रखें", "गीली मिट्टी में कोक्सीडिया के अंडे जीवित रहते हैं। फर्श पर चूना छिड़कें।")
            ),
            recoveryMinDays = 3,
            recoveryMaxDays = 6,
            redFlagWarnings = listOf("गंभीर रक्ताल्पता व गुदा का बाहर निकलना (Rectal prolapse due to continuous tenesmus)!"),
            secondOpinionNote = "एम्प्रोलियम (Amprolium) ओरल या सल्फाडिमिडीन देने के साथ बछड़े को पानी की कमी न होने दें। ORS घोल पिलाते रहें।"
        ),

        // 19. Acute Metritis & Pyometra
        DiseaseDefinition(
            id = "metritis",
            scientificName = "Acute Puerperal Metritis & Pyometra",
            hindiName = "गर्भाशय शोथ व मवाद (बच्चेदानी का संक्रमण)",
            localDesiNames = "बच्चेदानी में मैला, मवाद गिरना, जेर रुकना",
            etiology = "Arcanobacterium pyogenes, E. coli and anaerobes invading uterus post-calving or retained placenta.",
            associatedSymptoms = listOf("genital_foul_discharge", "genital_rop", "temp_fever_mid", "milk_sudden_drop"),
            pathognomonicSign = "योनि से अत्यधिक बदबूदार लाल-भूरा मवाद गिरना, ब्यांत के बाद जेर का सड़ांध मारना और भूख बंद होना",
            labTests = listOf(
                LabTest("Vaginal Discharge Microbial Culture", "Uterine Lochia", 350, "Determines bacterial flora and sensitive intrauterine antibiotics"),
                LabTest("Per-Rectal Uterine Palpation", "Clinical Exam", 80, "Detects doughy enlarged fluid-filled uterine horns")
            ),
            pregnancyRedAlert = "⚠️ प्रेगनेंसी स्थिति: यह प्रसवोपरांत रोग है। गाभिन पशुओं में PGF2-alpha सख्त निषिद्ध (गर्भाधान समाप्त कर देगा)।",
            contraIndicatedDrugs = listOf("PGF2-alpha in pregnant animals"),
            safeAlternativeDrugs = listOf("Ceftiofur Sodium", "Meloxicam", "Uterine herbal cleansing tonics"),
            injections = listOf(
                InjectionDrug("एंटीबायोटिक", "Ceftiofur Sodium 1g", "Xceft 1g", "Ceftio-Vet 1g", 380, 160, "IM once daily x 3-5 days (Zero milk withdrawal)", true, "Reaches high concentrations in uterine caruncles"),
                InjectionDrug("गर्भाशय संकुचन हार्मोन", "Cloprostenol Sodium (PGF2a) 2ml", "Vetmate 2ml / Pragma", "PGF-Vet 2ml", 220, 110, "IM 2 ml strictly in non-pregnant animals", false, "Expels trapped pus and lochia by opening cervix"),
                InjectionDrug("एंटी-इन्फ्लेमेटरी", "Meloxicam 20ml", "Melonex 30ml", "Melox Vet", 120, 45, "IM 15 ml", true, "Reduces severe uterine pelvic pain")
            ),
            oralMeds = listOf(
                OralMedicine("हर्बल यूटेराइन टॉनिक", "Utrovet / Exapar Liquid 1000ml", "Exapar 1L / Replanta", "Utero-Clean 1L", 280, 140, "100ml twice daily for 5 days", "Promotes natural uterine involution and clears retained lochia")
            ),
            herbalMeds = listOf(
                HerbalMedicine("गर्भाशय शोधक काढ़ा", "Replanta Powder 250g", 160, "50g boiled in water with jaggery", "Facilitates gentle placental shedding")
            ),
            homeopathicMeds = listOf(
                HomeopathicMedicine("Secale Cornutum 200C + Pulsatilla 200C", 110, "15 drops 3 times daily", "Expels retained fetal membranes smoothly")
            ),
            desiRemedies = listOf(
                DesiRemedy("बांस की पत्तियां, अजवाइन व पुराना गुड़", "बांस की हरी पत्तियां 500g, अजवाइन 50g, हल्दी 50g, पुराना गुड़ 500g", "2 लीटर पानी में उबालकर गुनगुना पिलाएं", "बच्चेदानी की गंदगी व जेर के टुकड़े 24 घंटे में बाहर फेंकता है।")
            ),
            biosecurity = listOf(
                BiosecurityMeasure("स्वच्छ प्रसव प्रबंधन", "ब्यांत के समय साफ सुथरी सूखी पराली बिछाएं और हाथ अच्छी तरह धोकर ही सहायता करें।")
            ),
            recoveryMinDays = 5,
            recoveryMaxDays = 12,
            redFlagWarnings = listOf("सेप्टिक टॉक्सिमिया (Toxemia) व पेरिटोनाइटिस - तुरंत सेफ्टिओफर IV और फ्लूइड थेरेपी शुरू करें!"),
            secondOpinionNote = "ब्यांत के 10 दिन के अंदर गर्भाशय में हाथ डालकर जबरन जेर न खींचे! Exapar सिरप और सेफ्टिओफर इंजेक्शन से गर्भाशय स्वतः साफ हो जाता है।"
        ),

        // 20. Infectious Bovine Rhinotracheitis (IBR)
        DiseaseDefinition(
            id = "ibr",
            scientificName = "Infectious Bovine Rhinotracheitis (IBR / Red Nose)",
            hindiName = "संक्रामक नासा-श्वासनली शोथ (लाल नाक रोग)",
            localDesiNames = "लाल नाक, नासा बुखार, छूत का जुकाम",
            etiology = "Bovine Herpesvirus-1 (BHV-1) causing severe upper respiratory inflammation, pustular vulvovaginitis and abortions.",
            associatedSymptoms = listOf("resp_nasal_discharge_crust", "resp_coughing", "temp_fever_high", "eyes_congested"),
            pathognomonicSign = "थूथन (Muzzle) का अत्यधिक लाल व सूजन युक्त होना (Red Nose), नाक से गाढ़ी पपड़ीदार मवाद व तेज सांस",
            labTests = listOf(
                LabTest("IBR BHV-1 Antibody ELISA / PCR", "Nasal Swab / Serum", 480, "Detects Bovine Herpesvirus-1 antigen and antibody titre")
            ),
            pregnancyRedAlert = "⚠️ प्रेगनेंसी चेतावनी: आईबीआर वायरस दूसरे व तीसरे ट्राइमेस्टर में गंभीर 'अबॉर्शन स्टॉर्म' (Abortion Storm) पैदा करता है!",
            contraIndicatedDrugs = listOf("Corticosteroids (Reactivates latent BHV-1 herpesvirus)"),
            safeAlternativeDrugs = listOf("Ceftriaxone-Tazobactam", "Meloxicam", "Vitamin C", "Steam inhalation"),
            injections = listOf(
                InjectionDrug("एंटीबायोटिक", "Ceftriaxone + Tazobactam 4.5g", "Intacef Tazo 4.5g", "Cef-Tazo Vet 4.5g", 480, 190, "IM/IV once daily x 3 days", true, "Prevents fatal secondary Mannheimia pneumonia"),
                InjectionDrug("एंटी-इन्फ्लेमेटरी", "Meloxicam 20ml", "Melonex 30ml", "Melox Vet", 120, 45, "IM 15 ml", true, "Relieves severe nasal and tracheal inflammation")
            ),
            oralMeds = listOf(
                OralMedicine("कफ व श्वास सिरप", "Guaifenesin + Terbutaline", "Kaf-Go Vet Liquid 200ml", "Kaf-Relief Vet", 140, 65, "50ml twice daily", "Liquefies thick tracheobronchial mucus")
            ),
            herbalMeds = listOf(
                HerbalMedicine("हर्बल ब्रोंकोडायलेटर", "Resposan / Pulmo-Plus", 160, "40ml twice daily", "Clears upper respiratory congestion")
            ),
            homeopathicMeds = listOf(
                HomeopathicMedicine("Aconite 1M + Drosera 200C", 110, "15 drops 3 times daily", "Effective in dry painful barking cough")
            ),
            desiRemedies = listOf(
                DesiRemedy("नीलगिरी तेल व कपूर की भाप", "नीलगिरी तेल 10 बूंद, कपूर 5g, उबलते पानी में", "पशु को कपड़े से ढककर भाप दें", "नाक व श्वासनली की जकड़न तुरंत खोलता है।")
            ),
            biosecurity = listOf(
                BiosecurityMeasure("संक्रमित पशु अलग रखें", "IBR अत्यंत संक्रामक है। बीमार पशु का दाना-पानी बर्तन अलग करें।")
            ),
            recoveryMinDays = 7,
            recoveryMaxDays = 14,
            redFlagWarnings = listOf("गंभीर डिप्थीरिया जैसी श्वासनली रुकावट व गर्भपात - कॉर्टिकोस्टेरॉइड कभी न दें!"),
            secondOpinionNote = "हर्पीस वायरस में स्टेरॉयड देने से वायरस का गुणन 100 गुना बढ़ जाता है। केवल Meloxicam और एंटीबायोटिक कवर दें।"
        ),

        // 21. Calf Scours / Colibacillosis
        DiseaseDefinition(
            id = "calf_scours",
            scientificName = "Calf Scours (Enterotoxigenic E. coli - ETEC)",
            hindiName = "बछड़ों का सफेद दस्त (काफ स्काउर)",
            localDesiNames = "सफेद दस्त, नवजात दस्त, बछड़े की मरोड़",
            etiology = "Enterotoxigenic E. coli (K99 pilus antigen) producing STa enterotoxin causing hypersecretory watery diarrhea in calves under 2 weeks.",
            associatedSymptoms = listOf("dung_watery_foul", "temp_subnormal", "eyes_pale", "digestion_anorexia"),
            pathognomonicSign = "1 से 14 दिन के नवजात बछड़ों में बदबूदार सफेद-पीला पानी जैसा दस्त, आंखें अंदर धंसना (Sunken Eyes) व खड़े न हो पाना",
            labTests = listOf(
                LabTest("Fecal E. coli K99 Rapid Strip", "Fecal Swab", 200, "Detects K99 adhesive fimbrial antigen")
            ),
            pregnancyRedAlert = null,
            contraIndicatedDrugs = listOf("Cold oral fluids in comatose hypothermic calves"),
            safeAlternativeDrugs = listOf("Warm Ringer Lactate with 5% Dextrose", "Gentamicin / Enrofloxacin", "Electrolytes"),
            injections = listOf(
                InjectionDrug("एंटीबायोटिक", "Gentamicin Sulfate 100mg/ml", "Gentacin Vet 30ml", "Genta-Vet 30ml", 85, 35, "IM 2-3 ml strictly with fluids", true, "Clears enterotoxigenic E. coli"),
                InjectionDrug("आईवी फ्लुइड्स", "Ringer's Lactate + Dextrose 5% 500ml", "RL Infusion 500ml", "RL Vet", 85, 35, "Slow IV (Warm to body temp) 500-1000 ml", true, "Saves calf from fatal metabolic acidosis")
            ),
            oralMeds = listOf(
                OralMedicine("ओआरएस व इलेक्ट्रोलाइट", "Calf Lyte / Enerlyte Pouch", "Walyte Vet Calf", "Calf-ORS", 55, 25, "1 pouch in 1 liter warm water 3 times daily", "Corrects dehydration and acid-base balance")
            ),
            herbalMeds = listOf(
                HerbalMedicine("हर्बल आंत संरक्षक", "Neblon Powder / Diaroak 50g", 75, "15g twice daily with rice starch", "Stops hypersecretory fluid loss")
            ),
            homeopathicMeds = listOf(
                HomeopathicMedicine("Podophyllum 200C + China 200C", 110, "5 drops every 2 hours", "Specific for profuse gushing yellowish-white diarrhea")
            ),
            desiRemedies = listOf(
                DesiRemedy("चावल का माड़ व ईसबगोल की भूसी", "चावल का उबला पानी (माड़) 250ml, ईसबगोल 1 चम्मच, चुटकी भर सेंधा नमक", "गुनगुना पिलाएं", "आंतों पर सुरक्षात्मक परत बनाता है।")
            ),
            biosecurity = listOf(
                BiosecurityMeasure("खीस (Colostrum) पिलाना", "जन्म के 1 घंटे के अंदर बछड़े के वजन का 10% खीस अनिवार्य रूप से पिलाएं।")
            ),
            recoveryMinDays = 2,
            recoveryMaxDays = 5,
            redFlagWarnings = listOf("आंखें 5mm अंदर धंसना, जीभ ठंडी होना व कोमा - तुरंत गर्म आईवी फ्लुइड्स चढ़ाएं!"),
            secondOpinionNote = "बछड़ों में दस्त से मौत का कारण बैक्टीरिया नहीं बल्कि डिहाइड्रेशन व एसिडोसिस है। दूध 24 घंटे के लिए आधा करें और ORS भरपूर दें।"
        )
    )

    fun findDiseaseById(id: String): DiseaseDefinition? {
        return diseasesList.find { it.id.equals(id, ignoreCase = true) }
    }

    fun diagnose(
        selectedSymptomIds: Set<String>,
        suspectedDiseaseId: String? = null,
        cardinalSignText: String = "",
        isPregnant: Boolean = false
    ): DiagnosticResult {
        if (selectedSymptomIds.isEmpty() && suspectedDiseaseId == null && cardinalSignText.isBlank()) {
            val defaultDisease = diseasesList.first()
            return DiagnosticResult(
                disease = defaultDisease,
                matchPercentage = 85,
                matchedSymptoms = defaultDisease.associatedSymptoms,
                cardinalMatched = false,
                differentialDiagnoses = listOf("hs" to 45, "theileriosis" to 30),
                pregnancyAlertActive = isPregnant && defaultDisease.pregnancyRedAlert != null
            )
        }

        // Score all diseases
        val scored = diseasesList.map { disease ->
            var score = 0
            val matched = mutableListOf<String>()

            for (symId in selectedSymptomIds) {
                if (disease.associatedSymptoms.contains(symId)) {
                    score += 25
                    matched.add(symId)
                }
            }

            // Cardinal sign bonus
            var cardinalHit = false
            if (cardinalSignText.isNotBlank()) {
                val keywords = cardinalSignText.lowercase()
                if (disease.pathognomonicSign.lowercase().contains(keywords) ||
                    disease.hindiName.lowercase().contains(keywords) ||
                    disease.scientificName.lowercase().contains(keywords)
                ) {
                    score += 45
                    cardinalHit = true
                }
            }

            // Suspected disease boost
            if (suspectedDiseaseId != null && disease.id.equals(suspectedDiseaseId, ignoreCase = true)) {
                score += 35
            }

            val maxPossible = (disease.associatedSymptoms.size * 25) + 45
            val pct = ((score.toDouble() / maxPossible.toDouble()) * 100).toInt().coerceIn(15, 99)

            Triple(disease, pct, matched to cardinalHit)
        }.sortedByDescending { it.second }

        val best = scored.first()
        val differentials = scored.drop(1).take(3).map { it.first.id to it.second }

        return DiagnosticResult(
            disease = best.first,
            matchPercentage = best.second,
            matchedSymptoms = best.third.first,
            cardinalMatched = best.third.second,
            differentialDiagnoses = differentials,
            pregnancyAlertActive = isPregnant && (best.first.pregnancyRedAlert != null || best.first.contraIndicatedDrugs.isNotEmpty())
        )
    }

    // AI Second Opinion Evaluator Engine
    fun evaluateAiSecondOpinion(
        disease: DiseaseDefinition,
        selectedSymptomIds: Set<String>,
        isPregnant: Boolean
    ): AiSecondOpinionEvaluation {
        // 1. Calculate Clinical Risk Severity
        val riskLevel = when (disease.id) {
            "hs", "bq", "parvo", "bloat", "babesiosis", "metritis" -> ClinicalRiskLevel.LIFE_THREATENING_CRITICAL
            "mastitis", "surra", "lsd", "milk_fever", "ppr", "anaplasmosis", "trp", "enterotoxemia" -> ClinicalRiskLevel.MODERATE
            else -> ClinicalRiskLevel.MILD
        }

        // 2. Identify missing differential signs to investigate
        val missing = disease.associatedSymptoms.filterNot { selectedSymptomIds.contains(it) }.map { symId ->
            symptomsList.find { it.id == symId }?.labelHindi ?: symId
        }

        // 3. Differential matches
        val differentials = diseasesList
            .filter { it.id != disease.id }
            .map { other ->
                val overlap = other.associatedSymptoms.intersect(selectedSymptomIds).size
                val score = (overlap * 30).coerceIn(10, 85)
                other.hindiName to score
            }
            .sortedByDescending { it.second }
            .take(3)

        // 4. Calculate Ethical vs Generic pricing comparison
        var totalEthical = disease.injections.sumOf { it.ethicalMrp } + disease.oralMeds.sumOf { it.ethicalMrp }
        var totalGeneric = disease.injections.sumOf { it.genericMrp } + disease.oralMeds.sumOf { it.genericMrp }
        if (totalEthical == 0) totalEthical = 500
        if (totalGeneric == 0) totalGeneric = 220
        val savingsPct = (((totalEthical - totalGeneric).toDouble() / totalEthical.toDouble()) * 100).toInt().coerceIn(30, 75)

        // 5. Pharmacological advice
        val advice = buildString {
            if (isPregnant) {
                append("🔴 [प्रेगनेंसी आपात निर्देश]: डेक्सामेथासोन, आइसोफ्लुप्रेडोन, प्रेडनिसोलोन और एलबेंडाजोल सख्त वर्जित हैं। केवल सुरक्षित एंटी-इन्फ्लेमेटरी (Meloxicam) और एंटीबायोटिक (Ceftriaxone) दें। ")
            }
            append(disease.secondOpinionNote)
            if (disease.safeAlternativeDrugs.isNotEmpty()) {
                append(" • अनुशंसित सुरक्षित विकल्प: ${disease.safeAlternativeDrugs.joinToString(", ")}।")
            }
        }

        return AiSecondOpinionEvaluation(
            riskLevel = riskLevel,
            primaryDiseaseName = "${disease.hindiName} (${disease.scientificName})",
            differentialMatches = differentials,
            missingSignsToInvestigate = missing,
            confirmatoryTests = disease.labTests,
            ethicalVsGenericSavingsPercent = savingsPct,
            totalEthicalCost = totalEthical,
            totalGenericCost = totalGeneric,
            pharmacologicalAdvice = advice
        )
    }
}
