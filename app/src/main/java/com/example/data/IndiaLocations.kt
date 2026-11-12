package com.example.data

object IndiaLocations {

    val statesAndUTs: List<String> = listOf(
        "हरियाणा (Haryana)",
        "पंजाब (Punjab)",
        "राजस्थान (Rajasthan)",
        "उत्तर प्रदेश (Uttar Pradesh)",
        "मध्य प्रदेश (Madhya Pradesh)",
        "गुजरात (Gujarat)",
        "हिमाचल प्रदेश (Himachal Pradesh)",
        "उत्तराखंड (Uttarakhand)",
        "दिल्ली (Delhi NCR)",
        "चंडीगढ़ (Chandigarh)",
        "जम्मू और कश्मीर (Jammu & Kashmir)",
        "लद्दाख (Ladakh)",
        "बिहार (Bihar)",
        "महाराष्ट्र (Maharashtra)",
        "छत्तीसगढ़ (Chhattisgarh)",
        "झारखंड (Jharkhand)",
        "ओडिशा (Odisha)",
        "पश्चिम बंगाल (West Bengal)",
        "असम (Assam)",
        "आंध्र प्रदेश (Andhra Pradesh)",
        "तेलंगाना (Telangana)",
        "कर्नाटक (Karnataka)",
        "तमिलनाडु (Tamil Nadu)",
        "केरल (Kerala)",
        "गोवा (Goa)",
        "अरुणाचल प्रदेश (Arunachal Pradesh)",
        "मणिपुर (Manipur)",
        "मेघालय (Meghalaya)",
        "मिजोरम (Mizoram)",
        "नागालैंड (Nagaland)",
        "सिक्किम (Sikkim)",
        "त्रिपुरा (Tripura)",
        "अंडमान और निकोबार (Andaman & Nicobar)",
        "दादरा और नगर हवेली तथा दमन और दीव",
        "लक्षद्वीप (Lakshadweep)",
        "पुडुचेरी (Puducherry)"
    )

    // All 23 official districts of Haryana including Hansi
    val haryanaDistricts: List<String> = listOf(
        "हिसार (Hisar)",
        "हांसी (Hansi - New District/PD)",
        "रोहतक (Rohtak)",
        "भिवानी (Bhiwani)",
        "चरखी दादरी (Charkhi Dadri)",
        "जींद (Jind)",
        "सिरसा (Sirsa)",
        "फतेहाबाद (Fatehabad)",
        "करनाल (Karnal)",
        "पानीपत (Panipat)",
        "सोनीपत (Sonipat)",
        "कुरुक्षेत्र (Kurukshetra)",
        "कैथल (Kaithal)",
        "अंबाला (Ambala)",
        "यमुनानगर (Yamunanagar)",
        "पंचकूला (Panchkula)",
        "गुरुग्राम (Gurugram)",
        "फरीदाबाद (Faridabad)",
        "पलवल (Palwal)",
        "नूंह / मेवात (Nuh)",
        "रेवाड़ी (Rewari)",
        "महेंद्रगढ़ / नारनौल (Mahendragarh)",
        "झज्जर (Jhajjar)"
    )

    val punjabDistricts: List<String> = listOf(
        "पटियाला (Patiala)", "लुधियाना (Ludhiana)", "अमृतसर (Amritsar)", "बठिंडा (Bathinda)",
        "संगरूर (Sangrur)", "फाजिल्का (Fazilka)", "फिरोजपुर (Ferozepur)", "जालंधर (Jalandhar)",
        "मोहाली (SAS Nagar)", "होशियारपुर (Hoshiarpur)", "गुरदासपुर (Gurdaspur)", "मुक्तसर (Muktsar)"
    )

    val rajasthanDistricts: List<String> = listOf(
        "जयपुर (Jaipur)", "जोधपुर (Jodhpur)", "बीकानेर (Bikaner)", "श्रीगंगानगर (Sri Ganganagar)",
        "हनुमानगढ़ (Hanumangarh)", "अलवर (Alwar)", "सीकर (Sikar)", "झुंझुनू (Jhunjhunu)",
        "कोटा (Kota)", "उदयपुर (Udaipur)", "अजमेर (Ajmer)", "नागौर (Nagaur)"
    )

    val upDistricts: List<String> = listOf(
        "मेरठ (Meerut)", "मुजफ्फरनगर (Muzaffarnagar)", "सहारनपुर (Saharanpur)", "मथुरा (Mathura)",
        "आगरा (Agra)", "बरेली (Bareilly)", "अलीगढ़ (Aligarh)", "बुलंदशहर (Bulandshahr)",
        "लखनऊ (Lucknow)", "वाराणसी (Varanasi)", "गोरखपुर (Gorakhpur)", "कानपुर (Kanpur)"
    )

    val mpDistricts: List<String> = listOf(
        "भोपाल (Bhopal)", "इंदौर (Indore)", "ग्वालियर (Gwalior)", "जबलपुर (Jabalpur)",
        "उज्जैन (Ujjain)", "सागर (Sagar)", "मुरैना (Morena)", "भिंड (Bhind)"
    )

    val genericDistricts: List<String> = listOf(
        "केंद्रीय जिला (Central District)",
        "उत्तरी जिला (North District)",
        "दक्षिणी जिला (South District)",
        "पूर्वी जिला (East District)",
        "पश्चिमी जिला (West District)"
    )

    fun getDistrictsForState(state: String): List<String> {
        return when {
            state.contains("हरियाणा") || state.contains("Haryana") -> haryanaDistricts
            state.contains("पंजाब") || state.contains("Punjab") -> punjabDistricts
            state.contains("राजस्थान") || state.contains("Rajasthan") -> rajasthanDistricts
            state.contains("उत्तर प्रदेश") || state.contains("Uttar Pradesh") -> upDistricts
            state.contains("मध्य प्रदेश") || state.contains("Madhya Pradesh") -> mpDistricts
            else -> genericDistricts
        }
    }
}
