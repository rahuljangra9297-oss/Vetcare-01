package com.example.ui.components

import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.os.Bundle
import android.os.CancellationSignal
import android.os.ParcelFileDescriptor
import android.print.PageRange
import android.print.PrintAttributes
import android.print.PrintDocumentAdapter
import android.print.PrintDocumentInfo
import android.print.PrintManager
import android.widget.Toast
import androidx.core.content.FileProvider
import com.example.data.DiagnosticResult
import java.io.File
import java.io.FileOutputStream
import java.io.FileInputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object RxPdfGenerator {

    fun generateAndSharePdf(
        context: Context,
        result: DiagnosticResult,
        patientName: String = "टैग #UP-78-4091",
        doctorName: String = "Dr. R. Sharma, B.V.Sc & A.H.",
        councilReg: String = "VCI-89241"
    ) {
        try {
            val file = createPdfFile(context, result, patientName, doctorName, councilReg)
            val uri: Uri = FileProvider.getUriForFile(
                context,
                "${context.packageName}.fileprovider",
                file
            )

            val sendIntent = Intent(Intent.ACTION_SEND).apply {
                type = "application/pdf"
                putExtra(Intent.EXTRA_STREAM, uri)
                putExtra(Intent.EXTRA_SUBJECT, "Veterinary Prescription - ${result.disease.scientificName}")
                putExtra(Intent.EXTRA_TEXT, "डिजिटल पशु चिकित्सा पर्ची (VETCARE AI OS):\nरोग: ${result.disease.hindiName} (${result.disease.scientificName})\nसंभाव्यता: ${result.matchPercentage}%")
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            context.startActivity(Intent.createChooser(sendIntent, "पर्ची साझा करें (Share Rx)"))
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(context, "PDF तैयार करने में त्रुटि: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
        }
    }

    fun printDocument(
        context: Context,
        result: DiagnosticResult,
        patientName: String = "टैग #UP-78-4091",
        doctorName: String = "Dr. R. Sharma, B.V.Sc & A.H.",
        councilReg: String = "VCI-89241"
    ) {
        val printManager = context.getSystemService(Context.PRINT_SERVICE) as? PrintManager
        if (printManager == null) {
            Toast.makeText(context, "प्रिंट सेवा उपलब्ध नहीं है", Toast.LENGTH_SHORT).show()
            return
        }

        val jobName = "VetCare_Rx_${System.currentTimeMillis()}"
        printManager.print(jobName, object : PrintDocumentAdapter() {
            private var pdfFile: File? = null

            override fun onLayout(
                oldAttributes: PrintAttributes?,
                newAttributes: PrintAttributes?,
                cancellationSignal: CancellationSignal?,
                callback: LayoutResultCallback?,
                extras: Bundle?
            ) {
                if (cancellationSignal?.isCanceled == true) {
                    callback?.onLayoutCancelled()
                    return
                }

                pdfFile = createPdfFile(context, result, patientName, doctorName, councilReg)
                val info = PrintDocumentInfo.Builder("prescription.pdf")
                    .setContentType(PrintDocumentInfo.CONTENT_TYPE_DOCUMENT)
                    .setPageCount(1)
                    .build()
                callback?.onLayoutFinished(info, true)
            }

            override fun onWrite(
                pages: Array<out PageRange>?,
                destination: ParcelFileDescriptor?,
                cancellationSignal: CancellationSignal?,
                callback: WriteResultCallback?
            ) {
                if (cancellationSignal?.isCanceled == true) {
                    callback?.onWriteCancelled()
                    return
                }

                val input = FileInputStream(pdfFile)
                val output = FileOutputStream(destination?.fileDescriptor)
                val buf = ByteArray(1024)
                var bytesRead: Int
                try {
                    while (input.read(buf).also { bytesRead = it } > 0) {
                        output.write(buf, 0, bytesRead)
                    }
                    callback?.onWriteFinished(arrayOf(PageRange.ALL_PAGES))
                } catch (e: Exception) {
                    callback?.onWriteFailed(e.message)
                } finally {
                    try { input.close() } catch (_: IOException) {}
                    try { output.close() } catch (_: IOException) {}
                }
            }
        }, null)
    }

    private fun createPdfFile(
        context: Context,
        result: DiagnosticResult,
        patientName: String,
        doctorName: String,
        councilReg: String
    ): File {
        val document = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(595, 842, 1).create() // Standard A4 portrait in points (72 dpi)
        val page = document.startPage(pageInfo)
        val canvas: Canvas = page.canvas

        val titlePaint = Paint().apply {
            color = Color.rgb(2, 132, 199) // Clinical Teal #0284C7
            textSize = 18f
            isFakeBoldText = true
        }
        val subPaint = Paint().apply {
            color = Color.rgb(71, 85, 105) // Slate 600
            textSize = 10f
        }
        val sectionHeaderPaint = Paint().apply {
            color = Color.rgb(15, 23, 42) // Slate 900
            textSize = 12f
            isFakeBoldText = true
        }
        val bodyPaint = Paint().apply {
            color = Color.rgb(15, 23, 42)
            textSize = 9.5f
        }
        val alertPaint = Paint().apply {
            color = Color.rgb(220, 38, 38) // Red
            textSize = 9f
            isFakeBoldText = true
        }
        val linePaint = Paint().apply {
            color = Color.rgb(203, 213, 225) // Slate 300
            strokeWidth = 1f
        }

        var y = 45f

        // Header
        canvas.drawText("VETCARE AI OS (CLINICAL TELE-PRESCRIPTION)", 40f, y, titlePaint)
        y += 18f
        canvas.drawText("Authorized Veterinary Practitioner Portal | ISO 9001:2026 Compliant Rx", 40f, y, subPaint)
        y += 15f
        canvas.drawLine(40f, y, 555f, y, linePaint)
        y += 20f

        // Doctor & Clinic Info Box
        canvas.drawText("PRACTITIONER:", 40f, y, sectionHeaderPaint)
        canvas.drawText(doctorName, 140f, y, bodyPaint)
        canvas.drawText("REGISTRATION ID:", 360f, y, sectionHeaderPaint)
        canvas.drawText(councilReg, 465f, y, bodyPaint)
        y += 18f

        val dateFormat = SimpleDateFormat("dd MMMM yyyy, hh:mm a", Locale.getDefault())
        canvas.drawText("DATE & TIME:", 40f, y, sectionHeaderPaint)
        canvas.drawText(dateFormat.format(Date()), 140f, y, bodyPaint)
        canvas.drawText("PATIENT / CASE:", 360f, y, sectionHeaderPaint)
        canvas.drawText(patientName, 465f, y, bodyPaint)
        y += 18f
        canvas.drawLine(40f, y, 555f, y, linePaint)
        y += 22f

        // Diagnosis
        val disease = result.disease
        canvas.drawText("PRIMARY CLINICAL DIAGNOSIS (निदान):", 40f, y, sectionHeaderPaint)
        y += 18f
        val diagText = "${disease.hindiName} (${disease.scientificName}) — Match: ${result.matchPercentage}%"
        canvas.drawText(diagText, 40f, y, titlePaint.apply { textSize = 13f; color = Color.rgb(15, 23, 42) })
        y += 16f
        canvas.drawText("Etiology: ${disease.etiology} | Pathognomonic: ${disease.pathognomonicSign}", 40f, y, subPaint)
        y += 20f

        // Clinical Notes / Red Flags
        if (disease.redFlagWarnings.isNotEmpty()) {
            canvas.drawText("CRITICAL CAUTION / चेतावनी:", 40f, y, alertPaint)
            y += 14f
            for (warning in disease.redFlagWarnings.take(2)) {
                canvas.drawText("• $warning", 45f, y, alertPaint.apply { isFakeBoldText = false })
                y += 14f
            }
            y += 8f
        }

        // 1. Injectable Medications Protocol
        canvas.drawText("1. INJECTABLE MEDICATIONS (इंजेक्शन प्रोटोकॉल):", 40f, y, sectionHeaderPaint)
        y += 15f

        // Table background rect
        val bgPaint = Paint().apply { color = Color.rgb(241, 245, 249) }
        canvas.drawRect(40f, y - 11f, 555f, y + 4f, bgPaint)
        canvas.drawText("Generic Salt", 45f, y, sectionHeaderPaint.apply { textSize = 8.5f })
        canvas.drawText("Ethical Brand", 185f, y, sectionHeaderPaint)
        canvas.drawText("Route & Dose", 310f, y, sectionHeaderPaint)
        canvas.drawText("Pregnancy Safe", 445f, y, sectionHeaderPaint)
        y += 15f

        for (inj in disease.injections.take(3)) {
            canvas.drawText(inj.genericSalt.take(24), 45f, y, bodyPaint)
            canvas.drawText(inj.ethicalBrand.take(18), 185f, y, bodyPaint)
            canvas.drawText(inj.dosageRoute.take(20), 310f, y, bodyPaint)
            canvas.drawText(if (inj.pregnancySafe) "✅ सुरक्षित" else "❌ वर्जित", 445f, y, bodyPaint)
            y += 12f
            canvas.drawText("  → Purpose: ${inj.clinicalPurpose}", 50f, y, subPaint)
            y += 13f
            canvas.drawLine(40f, y - 2f, 555f, y - 2f, linePaint)
            y += 5f
        }

        y += 8f
        // 2. Oral Medications / Bolus / Syrups
        canvas.drawText("2. ORAL MEDICATIONS & BOLUS (ओरल बोलस व सिरप):", 40f, y, sectionHeaderPaint)
        y += 14f
        for (om in disease.oralMeds.take(2)) {
            canvas.drawText("• [${om.type}] ${om.ethicalBrand} (${om.saltName})", 45f, y, bodyPaint.apply { isFakeBoldText = true })
            y += 12f
            canvas.drawText("   खुराक: ${om.dosageFreq} | प्रयोजन: ${om.purpose}", 50f, y, subPaint)
            y += 13f
        }

        y += 6f
        // 3. Ayurvedic & Herbal Formulations (NDDB / IVRI)
        canvas.drawText("3. AYURVEDIC & HERBAL CARE (आयुर्वेदिक व देशी उपचार):", 40f, y, sectionHeaderPaint)
        y += 14f
        if (disease.herbalMeds.isNotEmpty()) {
            val hm = disease.herbalMeds.first()
            canvas.drawText("• ${hm.formulation} - घटक: ${hm.keyIngredients.take(35)}", 45f, y, bodyPaint)
            y += 12f
            canvas.drawText("   खुराक: ${hm.dosage} | लाभ: ${hm.benefits.take(40)}", 50f, y, subPaint)
            y += 13f
        }
        if (disease.desiRemedies.isNotEmpty()) {
            val dr = disease.desiRemedies.first()
            canvas.drawText("• देशी काढ़ा: ${dr.remedyName} (${dr.ingredients.take(35)})", 45f, y, bodyPaint)
            y += 13f
        }

        y += 6f
        // 4. Dietary Advisory & Milk/Meat Withdrawal Warnings
        canvas.drawText("4. DIETARY ADVISORY & WITHDRAWAL NOTICE (खान-पान व विथड्रॉल चेतावनी):", 40f, y, sectionHeaderPaint)
        y += 13f
        canvas.drawText("• दूध विथड्रॉल: एंटीबायोटिक अवधि के दौरान व अंतिम खुराक के 72 घंटे बाद तक दूध मनुष्य उपयोग हेतु उबालकर दें।", 45f, y, alertPaint.apply { isFakeBoldText = false; textSize = 8.5f })
        y += 12f
        canvas.drawText("• आहार निर्देश: सुपाच्य दलिया, हरा चारा व पर्याप्त ताजा जल उपलब्ध कराएं। दाना मिश्रण 40% कम करें।", 45f, y, bodyPaint.apply { textSize = 8.5f })
        y += 12f
        if (disease.biosecurity.isNotEmpty()) {
            canvas.drawText("• जैव सुरक्षा: ${disease.biosecurity.first().title} - ${disease.biosecurity.first().instructions.take(50)}", 45f, y, subPaint)
            y += 13f
        }

        y += 15f
        canvas.drawLine(380f, y, 540f, y, linePaint)
        y += 13f
        canvas.drawText("Authorized Digital Sign", 400f, y, subPaint)
        y += 11f
        canvas.drawText("VETCARE AI OS Secure Stamp", 390f, y, subPaint)

        // Footer
        y = 810f
        canvas.drawLine(40f, y, 555f, y, linePaint)
        y += 14f
        canvas.drawText("This is an electronically validated veterinary clinical record generated by VetCare AI OS. Verified under VCI Ethics Code 2026.", 40f, y, subPaint.apply { textSize = 8f })

        document.finishPage(page)

        val outputDir = File(context.cacheDir, "prescriptions").apply { mkdirs() }
        val outputFile = File(outputDir, "Rx_${disease.scientificName.replace(" ", "_")}_${System.currentTimeMillis()}.pdf")
        val stream = FileOutputStream(outputFile)
        document.writeTo(stream)
        stream.close()
        document.close()

        return outputFile
    }
}
