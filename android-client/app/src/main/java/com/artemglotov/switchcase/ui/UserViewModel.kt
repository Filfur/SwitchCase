package com.artemglotov.switchcase.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemglotov.switchcase.networking.NetworkService
import kotlinx.coroutines.launch

class UserViewModel(
        private val networkService: NetworkService
) : ViewModel() {
    val balance: MutableLiveData<Float> = MutableLiveData()

    init {
        updateUserInfo()
    }

    fun updateUserInfo() {
        viewModelScope.launch {
            val userInfo = networkService.getUserInfo(1)!!
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