package com.yogaindra_18102180.sharedpreference

import android.content.Context

internal class SettingPreference(context: Context) {
    companion object {
        private const val PREFS_NAME = "setting_pref"
        private const val NAME = "name"
        private const val EMAIL = "email"
        private const val AGE = "age"
        private const val PHONE_NUMBER = "phone"
        private const val GOLONGAN_DARAH = "golongan"
        private const val PRODI = "prodi"
        private const val THEME = "theme"
    }

    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setSetting(value: SettingModel) {
        val editor = preferences.edit()
        editor.putString(NAME, value.name)
        editor.putString(EMAIL, value.email)
        editor.putInt(AGE, value.age)
        editor.putString(PHONE_NUMBER, value.phoneNumber)
        editor.putString(GOLONGAN_DARAH, value.golonganDarah)
        editor.putString(PRODI, value.prodi)
        editor.putBoolean(THEME, value.isDarkTheme)
        editor.apply()
    }

    fun getSetting(): SettingModel {
        val model = SettingModel()
        model.name = preferences.getString(NAME, "")
        model.email = preferences.getString(EMAIL, "")
        model.age = preferences.getInt(AGE, 0)
        model.phoneNumber = preferences.getString(PHONE_NUMBER, "")
        model.golonganDarah = preferences.getString(GOLONGAN_DARAH, "")
        model.prodi = preferences.getString(PRODI, "")
        model.isDarkTheme = preferences.getBoolean(THEME, false)
        return model
    }
}