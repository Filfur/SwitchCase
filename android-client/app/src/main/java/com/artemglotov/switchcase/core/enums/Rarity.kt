package com.artemglotov.switchcase.core.enums

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
enum class Rarity : Parcelable {
    MIL_SPEC,
    RESTRICTED,
    CLASSIFIED,
    COVERT
}