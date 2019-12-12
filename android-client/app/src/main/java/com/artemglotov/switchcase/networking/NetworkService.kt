package com.artemglotov.switchcase.networking

import com.artemglotov.switchcase.core.enums.Rarity
import com.artemglotov.switchcase.core.models.Case
import com.artemglotov.switchcase.core.models.Skin
import com.artemglotov.switchcase.core.models.User
import com.artemglotov.switchcase.json.DataHelper
import com.artemglotov.switchcase.preferences.AndroidPreferences
import retrofit2.Retrofit




class NetworkService(
    private val preferences: AndroidPreferences,
    private val dataHelper: DataHelper
) {

    private val service: SwitchCaseService


    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .build()

        service = retrofit.create(SwitchCaseService::class.java)
    }

    suspend fun signIn(email: String, password: String): Boolean {
        return preferences.email == email && preferences.password == password
    }

    suspend fun signUp(email: String, password: String, username: String, steamLink: String): Boolean {
        preferences.email = email
        preferences.password = password
        preferences.steamLink = steamLink
        preferences.username = username
        return true
    }

    suspend fun getCases(): List<Case> {
        return dataHelper.getCases()

        return listOf(
            Case(1, "Zinya pidor", 100f, "somelink"),
            Case(2, "Alex pidor", 200f, "somelink"),
            Case(3, "Lesha pidor", 300f, "somelink"),
            Case(4, "Pidor pidor", 400f, "somelink"),
            Case(5, "I am not pidor", 500f, "somelink")
        )

        val response = service.getCases()
        val cases = response.body()
        return if (response.isSuccessful && cases != null) {
            cases
        } else {
            listOf()
        }
    }

    suspend fun getCaseSkins(caseId: Int): List<Skin> {
        return dataHelper.getCaseSkins(caseId)


        return listOf(
            Skin(1, "Nastya", 10f, "AK-47", 0.43, 1, "somelink", Rarity.COVERT),
            Skin(1, "Artem", 40f, "AK-47", 0.43, 1, "somelink", Rarity.COVERT),
            Skin(1, "Anton", 10f, "AK-47", 0.43, 1, "somelink", Rarity.COVERT),
            Skin(1, "Zinya", 20f, "AK-47", 0.43, 1, "somelink", Rarity.COVERT),
            Skin(1, "Nastya", 10f, "AK-47", 0.42, 1, "somelink", Rarity.COVERT),
            Skin(1, "Zinya", 30f, "AK-47", 0.43, 1, "somelink", Rarity.COVERT),
            Skin(1, "Nastya", 10f, "AK-47", 0.43, 1, "somelink", Rarity.COVERT)
        )

        val response = service.getCaseSkins(caseId)
        val skins = response.body()
        return if (response.isSuccessful && skins != null) {
            skins
        } else {
            listOf()
        }
    }

    suspend fun dropSkin(caseId: Int): Skin? {

        return dataHelper.dropSkin(caseId)

        return Skin(1, "Nastya", 10f, "AK-47", 0.43, 1, "somelink", Rarity.COVERT)

        val response = service.dropSkin(caseId)
        val skin = response.body()
        return if (response.isSuccessful && skin != null) {
            skin
        } else {
            null
        }
    }

    suspend fun getUserInfo(userId: Int): User? {
        return User(1, "pidor@mail.ru", "yapidor", "Zinya", 1000f)

        val response = service.getUserInfo(userId)
        val userInfo = response.body()
        return if (response.isSuccessful && userInfo != null) {
            userInfo
        } else {
            null
        }
    }
}