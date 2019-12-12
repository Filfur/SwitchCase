package com.artemglotov.switchcase.json

import android.content.Context
import com.artemglotov.switchcase.core.models.Case
import com.artemglotov.switchcase.core.models.Skin
import kotlinx.serialization.json.Json
import kotlinx.serialization.list
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset
import kotlin.random.Random

class DataHelper(context: Context) {
    val json = getCasesJson(context) ?: throw Exception()

    fun getCases(): List<Case> {
        return Json.parse(CaseJson.serializer().list, json).toCases()
    }

    fun getCaseSkins(caseId: Int): List<Skin> {
        val cases = Json.parse(CaseJson.serializer().list, json)
        return cases.find { it.caseId == caseId }?.items?.toSkins() ?: listOf()
    }

    fun dropSkin(caseId: Int): Skin? {
        val skins = getCaseSkins(caseId)
        val skinId = getDroppedSkinId(caseId)
        return skins.find { it.skinId == skinId }
    }

    fun getDroppedSkinId(caseId: Int): Int {
        val random = Random.nextInt(10000)
        val caseIndex = caseId - 1

        return when (random) {
            in 0..50 -> random / 25 + caseIndex * 17
            in 50..500 -> (random - 50) / 150 + 2 + caseIndex * 17
            in 500..3000 -> (random - 500) / 500 + 5 + caseIndex * 17
            else -> (random - 3000) / 1000 + 10 + caseIndex * 17
        }
    }

    private fun getCasesJson(context: Context): String? {
        return try {
            val inputStream: InputStream = context.assets.open("cases.json")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }
}