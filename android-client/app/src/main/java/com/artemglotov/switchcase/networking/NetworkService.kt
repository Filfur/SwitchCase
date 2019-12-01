package com.artemglotov.switchcase.networking

import com.artemglotov.switchcase.core.enums.Rarity
import com.artemglotov.switchcase.core.models.Case
import com.artemglotov.switchcase.core.models.Skin
import com.artemglotov.switchcase.core.models.User
import retrofit2.Retrofit




class NetworkService {

    private val service: SwitchCaseService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .build()

        service = retrofit.create(SwitchCaseService::class.java)
    }

    suspend fun getCases(): List<Case> {
        return listOf(
            Case(1, "Zinya pidor", 100, "somelink"),
            Case(2, "Alex pidor", 200, "somelink"),
            Case(3, "Lesha pidor", 300, "somelink"),
            Case(4, "Pidor pidor", 400, "somelink"),
            Case(5, "I am not pidor", 500, "somelink")
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
        return listOf(
            Skin(1, "Nastya", 10, "AK-47", 0.43, 1, "somelink", Rarity.COVERT),
            Skin(1, "Artem", 40, "AK-47", 0.43, 1, "somelink", Rarity.COVERT),
            Skin(1, "Anton", 10, "AK-47", 0.43, 1, "somelink", Rarity.COVERT),
            Skin(1, "Zinya", 20, "AK-47", 0.43, 1, "somelink", Rarity.COVERT),
            Skin(1, "Nastya", 10, "AK-47", 0.42, 1, "somelink", Rarity.COVERT),
            Skin(1, "Zinya", 30, "AK-47", 0.43, 1, "somelink", Rarity.COVERT),
            Skin(1, "Nastya", 10, "AK-47", 0.43, 1, "somelink", Rarity.COVERT)
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
        return Skin(1, "Nastya", 10, "AK-47", 0.43, 1, "somelink", Rarity.COVERT)

        val response = service.dropSkin(caseId)
        val skin = response.body()
        return if (response.isSuccessful && skin != null) {
            skin
        } else {
            null
        }
    }

    suspend fun getUserInfo(userId: Int): User? {
        return User(1, "pidor@mail.ru", "yapidor", "Zinya", 1000)

        val response = service.getUserInfo(userId)
        val userInfo = response.body()
        return if (response.isSuccessful && userInfo != null) {
            userInfo
        } else {
            null
        }
    }
}