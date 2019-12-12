package com.artemglotov.switchcase.ui.login.viewModels

import androidx.lifecycle.*
import com.artemglotov.switchcase.networking.NetworkService

class LoginViewModel(
    private val networkService: NetworkService
) : ViewModel() {

    suspend fun signIn(email: String, password: String): Boolean {
        return networkService.signIn(email, password)
    }

    suspend fun signUp(email: String, password: String, username: String, steamLink: String): Boolean {
        return networkService.signUp(email, password, username, steamLink)
    }
}