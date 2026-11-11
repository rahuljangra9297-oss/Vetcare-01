# Implementation Plan: Vetcare AI OS (2026 Production Upgrade)

Refactor and upgrade **Vetcare AI OS** to eliminate layout/scrolling constraints, streamline clinical workflows, and introduce new role-based capabilities for Doctors, Dairy Farmers, and Administrators in native Android Jetpack Compose.

---

## User Review & Critical Decisions

> [!IMPORTANT]
> The following decisions were clarified and confirmed during the interview phase:
> - **Architecture**: Native Jetpack Compose Android UI with smooth single-pass scrolling and responsive dual-pane desktop ergonomics.
> - **AI Diagnostic Vision & Lab Report Analyzer**: Interactive photo and report file picker with multimodal clinical interpretation (lesions, udder swelling, CBC/blood smear/milk test analysis).
> - **Prescription Export**: Direct Android PDF generation (`PdfDocument`) combined with system Print Document Preview (`PrintManager` / `PrintDocumentAdapter`) and WhatsApp sharing.
> - **45 Indigenous Herbal Remedies**: Instant searchable NDDB/IVRI directory organized with anatomical category filters.

---

## 1. Overview & Core Concept

**Vetcare AI OS** is a high-contrast, bilingual (Hindi & English) clinical operating system tailored for rural veterinary doctors, dairy farmers, and clinic administrators. This upgrade transforms the app from a gated prototype into an open, production-grade clinical suite featuring:
- Seamless role switching (Doctor 🩺, Farmer 🌾, Admin 🛡️) without guest session roadblocks.
- High-precision clinical diagnostics with 9 independent anatomical organ hotspots, single-choice temperature chips, and species-calibrated Shaeffer dosage calculations.
- Doctor-exclusive searchable pharmacopeia and multimodal AI report analyzer.
- 45 NDDB/IVRI-validated indigenous livestock herbal remedies.
- Shared sire and bull breeding catalog for genetic herd improvement.
- Full administrative control over user accounts, trial extensions, and segmented subscription tiers.

---

## 2. User Experience & Visual Design

### Key User Flows

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                       TopBar: Direct Role Switcher                          │
│        [🩺 अधिकृत डॉक्टर]       [🌾 स्मार्ट किसान]       [🛡️ एडमिन वॉल्ट]       │
└───────────────────────┬─────────────────────┬───────────────────────┬───────┘
                        │                     │                       │
                        ▼                     ▼                       ▼
            ┌───────────────────────┐ ┌───────────────┐ ┌───────────────────┐
            │ Doctor Console        │ │ Farmer Hub    │ │ Admin Vault       │
            ├───────────────────────┤ ├───────────────┤ ├───────────────────┤
            │ • 9 Organ Hotspots    │ │ • 45 NDDB/IVRI│ │ • User Inspection │
            │ • Radio Temperature   │ │   Herbal Bank │ │ • Trial Extensions│
            │ • Calibrated Shaeffer │ │ • Sire Catalog│ │   (+7d/+15d/+30d) │
            │ • AI Vision & Reports │ │ • Passbook    │ │ • Doctor vs Farmer│
            │ • Pharmacopeia Search │ │ • Milk Calc   │ │   Tier Pricing    │
            │ • PDF / Print Rx      │ │ • SOS Alerts  │ │ • Payout Config   │
            └───────────────────────┘ └───────────────┘ └───────────────────┘
```

### Visual Identity & Theme
- **Color Palette (Daylight High-Contrast)**:
  - Canvas: `#F8FAFC` to `#FFFFFF` with high sunlight readability.
  - Primary Clinical: `#0284C7` (Teal/Cyan) and `#0D9488` (Medical Teal).
  - Healing Pasture: `#059669` (Agro Emerald).
  - Security & Vault: `#4338CA` (Royal Indigo) and `#0F172A` (Slate Navy).
  - Alert & Safety: `#DC2626` (Emergency Crimson) and `#D97706` (Amber Warning).
- **Typography**: 100% opaque `Slate900` (`#0F172A`) for crisp sunlight legibility in rural dairy farms and open veterinary dispensaries.
- **Touch Ergonomics**: All interactive elements strictly meet the 48dp minimum touch target (`minimumInteractiveComponentSize`).

---

## 3. Key Product Decisions & Component Architecture

### Component 1: Viewport, Scrolling & Direct Access
- **Eliminate Scroll Locking**: Remove conflicting nested scroll constraints; ensure mobile views scroll smoothly in a single `LazyColumn` and desktop views use properly weighted parallel scrollable columns (`1.1f` left pane, `1.3f` right pane) with `min-width` guarantees.
- **Remove Compulsory Guest / Auth Lock**: Remove modal gatekeeping. The TopBar and Home Stage provide instant 1-tap switching between Doctor, Farmer, and Admin consoles.

### Component 2: Doctor Console Diagnostic & Pharmacopeia Overhaul
- **9 Independent Anatomical Hotspots**:
  Split grouped chips into independent organs:
  1. सिर (Head)
  2. आंख (Eyes)
  3. मुंह/जीभ (Mouth/Tongue)
  4. गला (Throat)
  5. सीना/सांस (Chest/Respiration)
  6. पेट/कोख (Abdomen/Rumen)
  7. थन/अयन (Udder/Teats)
  8. पैर/खुर (Legs/Hooves)
  9. त्वचा (Skin)
- **Mutually Exclusive Body Temperature**: Single-select radio behavior for:
  - सामान्य (101–102°F)
  - मध्यम बुखार (103–104.5°F)
  - अति-तीव्र बुखार (105–107°F)
  - शरीर ठंडा पड़ना (<100°F)
- **Species-Calibrated Shaeffer Dosage Engine**:
  - Formulas scaled by species: Small ruminants (Goats/Sheep) and calves calculated with weight-safe volume limits (e.g. max 5–10 ml per IM injection site vs. 20–30 ml for cattle/buffalo).
  - Automatic lethal toxicity locks (e.g., Paracetamol in cats = `0.0 mL` fatal alert).
- **Interactive Multimodal AI Vision & Lab Report Analyzer**:
  - Real file & camera launcher for photos and diagnostic PDF/image reports.
  - AI extraction of lab parameters (CBC, Blood Smear, Somatic Cell Count, Parasites) mapped to instant clinical differentials.
- **Searchable Veterinary Pharmacopeia (Doctor-Exclusive)**:
  - Search by Brand Name, Generic/Salt, or Manufacturer.
  - Cards detail: Salt, therapeutic class, standard dosage/kg, route, indications, contraindications, pregnancy safety, milk/meat withdrawal period, MRP, and generic alternatives.
- **Print & PDF Generation**:
  - Direct Print preview using Android `PrintManager`.
  - Android `PdfDocument` generation generating a standard A4-formatted Digital Rx sheet.

### Component 3: Smart Dairy Farmer Hub Expansion
- **45 NDDB/IVRI Validated Indigenous Herbal Remedies**:
  - Expand herbal repository to 45 prioritized conditions across 6 anatomical categories.
  - Clear item cards with precise gram/ml ingredient quantities, decoction/preparation methods, dosing intervals, and red-flag alerts.
- **Shared Sire & Breeding Repository**:
  - Full bull pedigree catalog accessible to both Farmers and Doctors.
  - Search by Bull ID, Name, or Breed (Murrah, Sahiwal, Gir, Tharparkar, HF/Jersey Cross) with dam milk yield, CR%, semen price, and availability.

### Component 4: Admin Vault & Subscription Controls
- **User Profile Search & Inspection**: Admin search and inspect active Doctor and Farmer profiles.
- **One-Click Trial Extension**: Quick action buttons for `+7 दिन`, `+15 दिन`, `+30 दिन`, or custom days.
- **Segmented Tier Pricing**: Configurable Doctor vs. Farmer pricing toggles across Weekly, Monthly, Quarterly, and Annual plans.

---

## 4. Technical Architecture & File Plan

```
app/src/main/java/com/example/
├── data/
│   ├── VetDataModels.kt            # AnatomicalHotspot enum, TemperatureRange enum, PharmacopeiaItem, LabReportAnalysis, BullPedigree, HerbalRemedy45
│   └── SampleData.kt               # 45 NDDB/IVRI remedies, complete pharmacopeia drugs, breeding sires
├── viewmodel/
│   └── VetCareViewModel.kt         # Hotspot selection, radio temp, species Shaeffer dosing, AI report parsing, trial extension, PDF generator
└── ui/
    ├── components/
    │   ├── CommonComponents.kt     # TopBar direct role switcher, trial badge, compact toast
    │   ├── RxPdfGenerator.kt       # Native Android PdfDocument & PrintManager integration
    │   └── AuthModals.kt           # Admin PIN confirmation & optional profile updater
    └── screens/
        ├── DoctorWorkspaceScreen.kt# 9 hotspots, radio temp, calibrated Shaeffer, AI vision/report dialog, PDF & print buttons
        ├── DrugsDirectoryScreen.kt # Searchable Doctor Pharmacopeia with detailed pharmacology cards
        ├── BreedingCatalogScreen.kt# Shared Sire search & pedigree catalog (Doctor & Farmer)
        ├── FarmerHubScreen.kt      # 45 NDDB/IVRI herbal directory with instant anatomical search
        └── AdminVaultScreen.kt     # User search, trial extensions (+7/+15/+30d), and tiered pricing
```

---

## 5. Verification & Testing Strategy
- **Compilation Check**: Run `compile_applet` after modular changes.
- **Unit Testing**: Run `gradle :app:testDebugUnitTest` to verify species-scaled dosage math, feline contraindication checks, and Shaeffer formula accuracy.
- **UI Layout Verification**: Ensure zero double scrollbars, zero letter-by-letter text wrapping, and seamless desktop dual-pane responsiveness (>650dp).
