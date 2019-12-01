package com.artemglotov.switchcase.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemglotov.switchcase.networking.NetworkService
import kotlinx.coroutines.launch

class UserViewModel(
        private val networkService: NetworkService
) : ViewModel() {
    val balance: MutableLiveData<Int> = MutableLiveData()

    init {
        updateUserInfo()
    }

    fun updateUserInfo() {
        viewModelScope.launch {
            val userInfo = networkService.getUserInfo(1)!!
            balance.postValue(userInfo.balance)
        }
    }

    fun increaseBalance(count: Int) {
        balance.postValue((balance.value ?: 0) + count)
    }

    fun decreaseBalance(count: Int) {
        balance.postValue((balance.value ?: 0) - count)
    }
}