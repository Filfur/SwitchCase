package com.artemglotov.switchcase.core.models

import android.os.Parcelable
import com.artemglotov.switchcase.core.enums.Rarity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Skin(
    val skinId: Int,
    val skinName: String,
    val price: Long,
    val weaponName: String,
    val dropRate: Double,
    val caseId: Int,
    val imageLink: String,
    val rarity: Rarity
) : Parcelable