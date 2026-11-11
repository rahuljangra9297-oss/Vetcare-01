package com.example

import org.junit.Assert.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
  @Test
  fun addition_isCorrect() {
    assertEquals(4, 2 + 2)
  }

  @Test
  fun testDrugDosageCalculationAndFelineContraindication() {
    val melonexPlus = com.example.data.DrugSubstituteDetail(
      id = "sub_meloxicam",
      saltName = "Meloxicam + Paracetamol",
      brandName = "Melonex Plus",
      company = "Intas",
      mrp = 145,
      doseRateMgPerKg = 0.5,
      concentrationMgPerMl = 5.0,
      route = "IM",
      clinicalUsage = "बुखार व दर्द",
      pregnancySafe = true,
      contraindicatedSpecies = listOf(com.example.data.Species.CAT),
      speciesSpecialWarning = "Paracetamol fatal in cats"
    )

    // Bovine 300kg: (300 * 0.5) / 5.0 = 30.0 ml
    val bovineDose = melonexPlus.calculateDoseMl(300.0, com.example.data.Species.CATTLE)
    assertEquals(30.0, bovineDose, 0.1)

    // Feline (Cat) must return 0.0 ml due to Paracetamol contraindication
    val catDose = melonexPlus.calculateDoseMl(4.0, com.example.data.Species.CAT)
    assertEquals(0.0, catDose, 0.01)
  }
}
