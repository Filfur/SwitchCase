package com.artemglotov.switchcase.ui.profile.viewModels

import androidx.lifecycle.ViewModel
import com.artemglotov.switchcase.core.models.User
import com.artemglotov.switchcase.networking.NetworkService

class ProfileViewModel(
    private val networkService: NetworkService
) : ViewModel() {

    val user: User
        get() = networkService.getUserInfo(1)


    suspend fun saveProfile(
        email: String,
        password: String,
        username: String,
        steamLink: String
    ): Boolean {
        return networkService.saveProfile(email, password, username, steamLink)
    }
}
