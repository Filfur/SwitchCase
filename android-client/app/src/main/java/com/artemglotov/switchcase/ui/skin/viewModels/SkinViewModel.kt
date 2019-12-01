package com.artemglotov.switchcase.ui.skin.viewModels

import androidx.lifecycle.*
import com.artemglotov.switchcase.core.models.Case
import com.artemglotov.switchcase.core.models.Skin
import com.artemglotov.switchcase.networking.NetworkService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SkinViewModel(
    val skin: Skin,
    private val networkService: NetworkService
) : ViewModel() {
    fun sendToSteam() {

    }

    fun getMoneyBack(): Int {
        return skin.price.toInt()
    }
}