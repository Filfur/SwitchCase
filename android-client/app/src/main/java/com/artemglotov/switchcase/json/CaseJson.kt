package com.artemglotov.switchcase.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CaseJson(
    @SerialName("CaseId")
    val caseId: Int,
    @SerialName("Name")
    val name: String,
    @SerialName("Price")
    val price: Float,
    @SerialName("ImageLink")
    val imageLink: String,
    @SerialName("Items")
    val items: List<SkinJson>
)