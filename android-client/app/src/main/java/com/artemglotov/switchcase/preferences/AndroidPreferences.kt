/*
 * Copyright (c) 2019.
 * Powered by Artem Glotov.
 * All rights reserved.
 */

package com.artemglotov.switchcase.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class AndroidPreferences(context: Context) {
    companion object {
        private const val USERNAME = "username"
        private const val EMAIL = "email"
        private const val PASSWORD = "password"
        private const val STEAM_LINK = "steam_link"
        private const val BALANCE = "balance"
        private const val IS_SIGNED_IN = "is_signed_in"
    }

    private val preferences: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    var username: String
        get() = preferences.getString(USERNAME, "") ?: ""
        set(value) = preferences.edit { putString(USERNAME, value) }

    var email: String
        get() = preferences.getString(EMAIL, "") ?: ""
        set(value) = preferences.edit { putString(EMAIL, value) }

    var password: String
        get() = preferences.getString(PASSWORD, "") ?: ""
        set(value) = preferences.edit { putString(PASSWORD, value) }

    var steamLink: String
        get() = preferences.getString(STEAM_LINK, "") ?: ""
        set(value) = preferences.edit { putString(STEAM_LINK, value) }

    var balance: Float
        get() = preferences.getFloat(BALANCE, 0f)
        set(value) = preferences.edit { putFloat(BALANCE, value) }

    var isSignedIn: Boolean
        get() = preferences.getBoolean(IS_SIGNED_IN, false)
        set(value) = preferences.edit { putBoolean(IS_SIGNED_IN, value) }
}