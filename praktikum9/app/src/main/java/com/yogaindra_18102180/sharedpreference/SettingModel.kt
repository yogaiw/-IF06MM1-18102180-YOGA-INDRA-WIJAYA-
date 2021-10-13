package com.yogaindra_18102180.sharedpreference

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SettingModel(
    var name: String? = null,
    var email: String? = null,
    var age: Int = 0,
    var phoneNumber: String? = null,
    var golonganDarah: String? = null,
    var prodi: String? = null,
    var isDarkTheme: Boolean = false
):Parcelable