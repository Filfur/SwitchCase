package com.artemglotov.switchcase.json

import com.artemglotov.switchcase.core.enums.Rarity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SkinJson(
    @SerialName("SkinId")
    val skinId: Int,
    @SerialName("Name")
    val name: String,
    @SerialName("Price")
    val price: Float,
    @SerialName("WeaponName")
    val weaponName: String,
    @SerialName("DropRate")
    val dropRate: Double,
    @SerialName("CaseId")
    val caseId: Int,
    @SerialName("ImageLink")
    val imageLink: String,
    @SerialName("Rarity")
    val rarity: Rarity
)