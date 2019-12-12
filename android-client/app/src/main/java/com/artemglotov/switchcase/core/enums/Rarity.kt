package com.artemglotov.switchcase.core.enums

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
enum class Rarity : Parcelable {
    @SerialName("Mil-Spec")
    MIL_SPEC,
    @SerialName("Restricted")
    RESTRICTED,
    @SerialName("Classified")
    CLASSIFIED,
    @SerialName("Covert")
    COVERT
}