package com.artemglotov.switchcase.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemglotov.switchcase.networking.NetworkService
import com.artemglotov.switchcase.preferences.AndroidPreferences
import kotlinx.coroutines.launch

class UserViewModel(
        private val networkService: NetworkService,
        private val preferences: AndroidPreferences
) : ViewModel() {
    val balance: MutableLiveData<Float> = MutableLiveData()

    init {
        updateUserInfo()
    }

    var isSignedIn: Boolean
        get() = preferences.isSignedIn
        set(value) {
            preferences.isSignedIn = value
        }

    fun updateUserInfo() {
        viewModelScope.launch {
            val userInfo = networkService.getUserInfo(1)
            balance.postValue(userInfo.balance)
        }
    }

    fun increaseBalance(count: Float) {
        val newBalance = (((balance.value ?: 0f) + count) * 100).toInt().toFloat() / 100
        balance.postValue(newBalance)
    }

    fun decreaseBalance(count: Float) {
        val newBalance = (((balance.value ?: 0f) - count) * 100).toInt().toFloat() / 100
        balance.postValue(newBalance)
    }
}