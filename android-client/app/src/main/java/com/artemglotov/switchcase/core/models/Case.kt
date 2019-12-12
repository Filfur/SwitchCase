package com.artemglotov.switchcase.core.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Case(
    val caseId: Int,
    val name: String,
    val price: Float,
    val imageLink: String
) : Parcelable