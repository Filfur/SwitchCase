package com.artemglotov.switchcase.core.models

import com.artemglotov.switchcase.core.enums.Rarity

data class Skin(
    val skinId: Int,
    val skinName: String,
    val price: Long,
    val weaponName: String,
    val dropRate: Double,
    val caseId: Int,
    val imageLink: String,
    val rarity: Rarity
)