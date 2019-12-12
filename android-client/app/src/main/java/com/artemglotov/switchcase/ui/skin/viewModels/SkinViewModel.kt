package com.artemglotov.switchcase.ui.skin.viewModels

import androidx.lifecycle.*
import com.artemglotov.switchcase.core.models.Skin
import com.artemglotov.switchcase.networking.NetworkService

class SkinViewModel(
    val skin: Skin,
    private val networkService: NetworkService
) : ViewModel() {
    fun sendToSteam() {

    }

    fun getMoneyBack(): Float {
        return skin.price
    }
}